package com.sinlov.java.playground.utils;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;
import test.TempTest;

import static org.junit.Assert.*;

public class JsonDemoTest extends TempTest {

    private String code;
    private String code2;

    @Override
    public void setUp() throws Exception {
        super.setUp();
         code = "{\"code\":200,\"message\":\"\\u4fdd\\u5b58\\u6210\\u529f\"}";
         code2 = "{\"code\":200,\"message\":\"保存成功\"}";
    }

    @Test
    public void print_code() {
        // unicode 转换成 中文
        String unescapeJava = StringEscapeUtils.unescapeJava(code);
        System.out.println("unicode 转换成 中文 unescapeJava = " + unescapeJava);
        // 中文转换成 unicode
        String escapeJava = StringEscapeUtils.escapeJava(code2);
        System.out.println("中文转换成 unicode escapeJava = " + escapeJava);
    }

    @Test
    public void escapeJava() {
        String escapeJava = JsonDemo.escapeJava(code2);
        System.out.println("escapeJava = " + escapeJava);
        assertEquals("{\"code\":200,\"message\":\"\\u4fdd\\u5b58\\u6210\\u529f\"}", escapeJava);
    }

    @Test
    public void unescapeUnicode() {
        String unescapeUnicode = JsonDemo.unescapeUnicode(code);
        System.out.println("unescapeUnicode = " + unescapeUnicode);
        assertEquals("保存成功", unescapeUnicode);
    }
}