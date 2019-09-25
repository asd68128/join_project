package com.sl.automobile.utils;

/**
 * Created by happy on 2019/9/21.
 */
public class GetInt {
    public int getIntValue(String str) {
        int r = 0;
        if (str != null && str.length() != 0) {
            StringBuffer bf = new StringBuffer();

            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c >= '0' && c <= '9') {
                    bf.append(c);
                } else if (c == ',') {
                    continue;
                } else {
                    if (bf.length() != 0) {
                        break;
                    }
                }
            }
            try {
                r = Integer.parseInt(bf.toString());
            } catch (Exception e) {
            }
        }
        return r;
    }
}
