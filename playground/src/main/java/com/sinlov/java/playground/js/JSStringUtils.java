package com.sinlov.java.playground.js;

import com.sinlov.java.utils.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;

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
 * Created by sinlov on 2020/1/2.
 */
public class JSStringUtils {

    /**
     * JavaScript's <code>window.btoa</code> function.
     *
     * @param src the data to encode
     * @param enc The name of a supported {@linkplain java.nio.charset.Charset charset}
     * @return base64 with ASCII. Returns <code>null</code> if the String is <code>null</code>.
     */
    public static String btoa(String src, String enc) {
        String s = null;
        try {
            s = Base64.encodeToString(src.getBytes(Charset.forName(enc)), Base64.NO_WRAP);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return s;
        }
    }

    /**
     * JavaScript's <code>window.atob</code> function.
     *
     * @param src base64 with ASCII
     * @param enc The name of a supported {@linkplain java.nio.charset.Charset charset}
     * @return the data to decode. Returns <code>null</code> if the String is <code>null</code>.
     */
    public static String atob(String src, String enc) {
        String s = null;
        try {
            s = Base64.encodeToString(src.getBytes(Charset.forName(enc)), Base64.NO_WRAP);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return s;
        }
    }

    /**
     * Decodes the passed UTF-8 String using an algorithm that's compatible with
     * JavaScript's <code>decodeURIComponent</code> function.
     *
     * @param s   The UTF-8 encoded String to be decoded
     * @param enc The name of a supported {@linkplain java.nio.charset.Charset charset}
     * @return the decoded String. Returns <code>null</code> if the String is <code>null</code>.
     */
    public static String decodeURIComponent(String s, String enc) {
        if (s == null) {
            return null;
        }

        String result = null;

        try {
            result = URLDecoder.decode(s, enc);
        }

        // This exception should never occur.
        catch (UnsupportedEncodingException e) {
            result = s;
        }

        return result;
    }

    /**
     * Encodes the passed String as UTF-8 using an algorithm that's compatible
     * with JavaScript's <code>encodeURIComponent</code> function.
     *
     * @param s   The String to be encoded
     * @param enc The name of a supported {@linkplain java.nio.charset.Charset charset}
     * @return the encoded String. Returns <code>null</code> if the String is <code>null</code>.
     */
    public static String encodeURIComponent(String s, String enc) {
        String result = null;

        try {
            result = URLEncoder.encode(s, enc)
                    .replaceAll("\\+", "%20")
                    .replaceAll("\\%21", "!")
                    .replaceAll("\\%27", "'")
                    .replaceAll("\\%28", "(")
                    .replaceAll("\\%29", ")")
                    .replaceAll("\\%7E", "~");
        }

        // This exception should never occur.
        catch (UnsupportedEncodingException e) {
            result = s;
        }

        return result;
    }

    private JSStringUtils() {
    }
}

