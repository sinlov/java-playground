package com.sinlov.java.playground.utils;

import org.junit.Test;
import test.TempTest;

import static org.junit.Assert.*;

public class HexUtilsTest extends TempTest {

    public static final String TEST_STR_ONE = "12345678qwertyui";
    public static final String TEST_HEX_ONE = "31323334353637387177657274797569";
    public static final String TEST_HEX_STR_2 = "4fb136d957b092cd29";

    @Test
    public void base() {
        byte[] bytes = TEST_STR_ONE.getBytes();
        String hexStr = HexUtils.bytes2HexStr(bytes);
        System.out.println("hexStr = " + hexStr);
        assertEquals(TEST_HEX_ONE, hexStr);
    }

    @Test
    public void hexStr2Bytes() {
        byte[] hexBytes = HexUtils.hexStr2Bytes(TEST_HEX_STR_2);
        assertNotEquals(null, hexBytes);
        assert hexBytes != null;
        for (byte b :
                hexBytes) {
            String byte2HexStr = HexUtils.byte2HexStr(b);
            System.out.println("hexBytes to byte: " + byte2HexStr);
            assertNotEquals(null, byte2HexStr);
        }
    }

    @Test
    public void hexStringToBytes() {
        byte[] bytes = HexUtils.hexStringToBytes("4fb136d957b092cd29c9b8555167b730976596f12af1ba99032f87ee753e2d465105e92919e81f6ed2de0af9abb98ca08d5db6fe46085a0b1158a5a7d349feea");
        for (byte d :
                bytes) {
            String byte2HexStr = HexUtils.byte2HexStr(d);
            System.out.println("hexStringToBytes: " + byte2HexStr);
            assertNotEquals(null, byte2HexStr);
        }
    }

    @Test
    public void bytes2HexStr() {
        byte[] strData = TEST_STR_ONE.getBytes();
        String bytes2HexStr = HexUtils.bytes2HexStr(strData);
        System.out.println("Datas: " + bytes2HexStr);
        assertEquals("31323334353637387177657274797569", bytes2HexStr);
    }

    @Test
    public void byte2HexStr() {
        byte[] strData = TEST_STR_ONE.getBytes();
        for (byte data :
                strData) {
            String byte2HexStr = HexUtils.byte2HexStr(data);
            System.out.println("str to byte: " + byte2HexStr);
            assertNotEquals(null, byte2HexStr);
        }
    }
}