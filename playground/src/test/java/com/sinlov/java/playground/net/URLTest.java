package com.sinlov.java.playground.net;

import org.junit.Test;
import test.TempTest;

import java.net.URI;

import static org.junit.Assert.*;

public class URLTest extends TempTest {

    private String serverUrl;
    private URI wsUrl;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        serverUrl = "10.8.230.246:31313/echo";
        wsUrl = URI.create("ws://" + serverUrl);
    }

    @Test
    public void test_url_create_ws() {
        String wsFullString = wsUrl.toString();
        System.out.println("url = " + wsFullString);
        assertEquals("ws://10.8.230.246:31313/echo", wsFullString);
        String scheme = wsUrl.getScheme();
        System.out.println("url.getScheme = " + scheme);
        assertEquals("ws", scheme);
        String host = wsUrl.getHost();
        System.out.println("url.getHost = " + host);
        assertEquals("10.8.230.246", host);
        int port = wsUrl.getPort();
        System.out.println("url.getPort = " + port);
        assertEquals(31313, port);
        String path = wsUrl.getPath();
        System.out.println("url.getPort = " + path);
        assertEquals("/echo", path);
    }
}
