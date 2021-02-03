package com.sinlov.java.playground.utils;

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by sinlov on 16/12/27.
 */
public class JsonDemo {
    static String code = "{\"code\":200,\"message\":\"\u0048\\u0065\u006C\u006C\u006F\"}";
    static String code2 = "{\"code\":200,\"message\":\"保存成功\"}";
    static StringBuffer sb;

    public static String escapeJava(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int chr1 = (char) str.charAt(i);
            if (chr1 >= 19968 && chr1 <= 171941) {//汉字范围 \u4e00-\u9fa5 (中文)
                result += "\\u" + Integer.toHexString(chr1);
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }

    public static String unescapeUnicode(String str) {
        if (null == str || str.equals("")) {
            return "";
        }
        if (null == sb) {
            sb = new StringBuffer();
        }
        sb.setLength(0);
        Matcher m = Pattern.compile("\\\\u([0-9a-fA-F]{4})").matcher(str);
        try {
            while (m.find()) {
                sb.append((char) Integer.parseInt(m.group(1), 16));
            }
            return sb.toString();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return str;
        }
    }

    // public static void main(String[] args) {
    //     System.out.println(unescapeUnicode(code));
    //     System.out.println(escapeJava(code2));

    //     // unicode 转换成 中文
    //     System.out.println(StringEscapeUtils.unescapeJava(code));
    //     // 中文转换成 unicode
    //     System.out.println(StringEscapeUtils.escapeJava(code2));
    // }
}
