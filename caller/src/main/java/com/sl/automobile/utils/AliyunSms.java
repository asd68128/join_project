package com.sl.automobile.utils;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.Jedis;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.0.3</version>
</dependency>
*/
@Component
public class AliyunSms {
    // 创建DefaultAcsClient实例并初始化(地域id，accesskey id，accesskey id accesskey secret)
    DefaultProfile profile = DefaultProfile.getProfile("default", "LTAI4FqcB88GGkGBoiiGpBUo", "PpJ86ZoWpOTqAD5jt8TThC9vP0LThE");
    IAcsClient client = new DefaultAcsClient(profile);
    String keys=null;
    //发送验证码方法
    public String sendSmsCode(String phoneNum){
//当您要调用的某个产品的API没有提供SDK时，可以采用泛用型的API调用方式（CommonRequest）。
// 使用CommonRequest调用方式可实现任意Open API接口的调用。
        // 创建API请求并设置参数
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        //跨域共享cookie的方法：设置cookie.setDomain();
        //dysmsapi.aliyuncs.com  就可以获得本机得cookie
        request.setDomain("dysmsapi.aliyuncs.com");
        //setVersion()方法指定一个版本号
        request.setVersion("2017-05-25");
        //设置动作为SendSms
        request.setAction("SendSms");
        //设置参数
        request.putQueryParameter("RegionId", "cn-xian");
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", "深蓝汽车资讯");
        request.putQueryParameter("TemplateCode", "SMS_174279254");
        //随机生成000000-999999之间的6位整数
        request.putQueryParameter("TemplateParam", "{code:"+((int) (Math.random() * 900000 + 100000))+"}");
        try {
            //客户端获取相应
            CommonResponse response = client.getCommonResponse(request);
            String responseData = response.getData();
            System.out.println(responseData);

            JSONObject jsonObject = JSONObject.parseObject(responseData);
            String message = jsonObject.getString("Message");
            String bizId = jsonObject.getString("BizId");
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            String date1 = dateFormat.format(date);
            //查询发送信息中的Content值
            String sendDetails = QuerySendDetails(phoneNum, date1, "10", "1", bizId);
            //获取信息中的验证码
            int smsCodeKey = new GetInt().getIntValue(bizId);
            //存入redis并设置生存时间
            Jedis jedis;
            jedis= new Jedis();
            keys=phoneNum+"的验证码";
            jedis.set(keys,smsCodeKey+"");
            jedis.expire(keys,6000);
            return message;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "发送失败";
        /*"Message": "OK",
               "RequestId": "438F7049-97F6-49D7-81F5-1D903117327E",
                "BizId": "789516368987536261^0",
                "Code": "OK"
         */
    }
    //查询验证码方法
    public String QuerySendDetails(String phoneNum, String sendData,
                                   @RequestParam(defaultValue = "10") String pageSize,
                                   @RequestParam(defaultValue = "1")String currentPage,
                                   String bizId){
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("QuerySendDetails");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        //四个必须参数
        request.putQueryParameter("PhoneNumber", phoneNum);
        //发送日期格式为（yyyymmdd）
        request.putQueryParameter("SendDate", sendData);
        //一页显示多少
        request.putQueryParameter("PageSize", pageSize);
        //第几页
        request.putQueryParameter("CurrentPage", currentPage);
        //
        request.putQueryParameter("BizId",bizId);
        try {
            CommonResponse response = client.getCommonResponse(request);
            String responseData = response.getData();
            System.out.println(responseData);
            //
            JSONObject jsonObject = JSONObject.parseObject(responseData);
            String content = jsonObject.getString("Content");
            return content;

        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "查询失败";
        /*返回结果：
        {
            "TotalCount": 2,
                "Message": "OK",
                "RequestId": "714684E1-9655-4D4B-9CA7-3F5C30C23314",
                "SmsSendDetailDTOs": {
            "SmsSendDetailDTO": [
            {
                "SendDate": "2019-09-20 19:06:26",
                    "SendStatus": 3,
                    "ReceiveDate": "2019-09-20 19:06:37",
                    "ErrCode": "DELIVERED",
                    "TemplateCode": "SMS_174279254",
                    "Content": "【深蓝汽车资讯】尊敬的用户，您的注册会员动态密码为：750151，请勿泄漏于他人！",
                    "PhoneNum": "15771775078"
            }
		]
        },
            "Code": "OK"
        }*/

    }
    //校验验证码方法
    public boolean checkSmsCode (String phoneNum,  String smsCode){
        String smsCodeKey;
        boolean flag=false;
        keys=phoneNum+"的验证码";
        Jedis jedis;
        jedis= new Jedis();
        smsCodeKey = jedis.get(keys);
        if (smsCodeKey.equals(smsCode)){
            jedis.del(keys);
            return flag=true;
        }
        return flag;
    }
}
