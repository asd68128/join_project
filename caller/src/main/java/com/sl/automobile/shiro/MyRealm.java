
package com.sl.automobile.shiro;

import com.sl.automobile.pojo.UserTable;
import com.sl.automobile.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;



public class MyRealm extends AuthorizingRealm{
    @Autowired
    private UserService userService;
//   @Autowired
//    private PermissionService permissionService;
//    @Autowired
//    private BusinessService businessService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取身份信息
        Object principal = principalCollection.getPrimaryPrincipal();
        if (!StringUtils.isEmpty(principal)){
            String userName = (String) principal;
            //List<PermissionTable> allPermissionByUna = permissionService.findAllPermissionByUna(userName);
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //权限去重
            Set<String> pers = new HashSet<>();
            pers.add("mihao");
            pers.add("hello");
          /*  for (PermissionTable p:allPermissionByUna) {
                String pmenuUrl = p.getPmenuUrl();
                pers.add(pmenuUrl);

            }*/
           simpleAuthorizationInfo.setStringPermissions(pers);

           return simpleAuthorizationInfo;
        }

        return null;
    }

    //身份验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1,获取身份信息（用户名）
        Object principal = authenticationToken.getPrincipal();
        if (!StringUtils.isEmpty(principal)){
            String loginName = (String)principal;
            UserTable byName = userService.loadByNa(loginName);
            if (byName!=null){
                SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginName, byName.getUserPwd(),getName());
                return authenticationInfo;
            }
        }
        return null;
    }
}


