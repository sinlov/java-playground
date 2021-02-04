package com.sinlov.java.playground.regex;

import org.junit.Test;
import test.TempTest;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLMatchesTest extends TempTest {

    private String IS_URL;
    private Pattern compileURL;
    private String M_URL;

    ArrayList<String> testURLs;
    private String url1;
    private String url2;
    private String url3;
    private String url4;
    private String url5;
    private String url6;
    private String url7;
    private String url8;
    private String url9;
    private String url10;
    private String url11;


    @Override
    public void setUp() throws Exception {
        super.setUp();

        IS_URL = "^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";
        compileURL = Pattern.compile(IS_URL);
        M_URL = "recharge_res.php";

        url1 = "https://www.mo9.com/gateway/mobile.shtml?m=mobile&lc=CN&version=2.2&return_url=http%3A%2F%2Ftest.g.kuaifazs.com%2Fforeign%2Frecharge%2Fcallback.php%3F_payType%3Dmo9_wap%26orderId%3D1612209900002000&amount=1.00&item_name=%E7%96%AF%E7%8B%82%E5%AE%9D%E7%9F%B3%E5%85%85%E5%80%BC&payer_id=18543&currency=CNY&m=mobile&invoice=1612209900002000&notify_url=http%3A%2F%2Ftest.g.kuaifazs.com%2Fforeign%2Frecharge%2Fnotify.php%3F_payType%3Dmo9_wap&fromDFT=true&pay_to_email=45597195%40qq.com&app_id=2014adOPnHIONj&sign=90a4d13f12547fc5a86e0102c2dce203&token=2C1EFD120A027A92D707F174FE5BBAFC";
        url2 = "https://www.mo9.com/gateway/wap_gateway.shtml?m=showLoginPage";
        url3 = "https://www.mo9.com/gateway/wap_gateway.shtml?m=showTxConfirmPage";
        url4 = "https://www.mo9.com/gateway/pay.shtml?m=pay&gatewayDealcode=BABFLBLPNNALLLHL&mobile=18600678470&channel=alipay&amount=1.00&subchannel=WapDirectPay&extral=%7C%7C%7C&sign=E6EE1346E072D640A7740BE83BF28C7E&topupPage=3&trade_sessionId=201612200931549004941268&merchantname=%E6%88%90%E9%83%BD%E4%BA%91%E7%AB%AF%E5%8A%A9%E6%89%8B%E7%A7%91%E6%8A%80%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8";
        url5 = "http://wappaygw.alipay.com/service/rest.htm?sign=5809e364076966fd7cc4efcea2a7a37e&v=2.0&sec_id=MD5&req_data=%3Cauth_and_execute_req%3E%3Crequest_token%3E20161220117cd2c8142e433a9110cd20b0c4708c%3C%2Frequest_token%3E%3C%2Fauth_and_execute_req%3E&service=alipay.wap.auth.authAndExecute&partner=2088611361723512&format=xml";
        url6 = "https://wappaygw.alipay.com/service/rest.htm?sec_id=MD5&format=xml&sign=5809e364076966fd7cc4efcea2a7a37e&v=2.0&req_data=%3Cauth_and_execute_req%3E%3Crequest_token%3E20161220117cd2c8142e433a9110cd20b0c4708c%3C%2Frequest_token%3E%3C%2Fauth_and_execute_req%3E&service=alipay.wap.auth.authAndExecute&partner=2088611361723512";
        url7 = "https://www.mo9.com/gateway/topup/alipay/WapDirectPay/return.shtml?out_trade_no=WAAEJAJPNEJOKOEH&request_token=requestToken&result=success&trade_no=2016122021001004100233821521&sign=5cc14a8c11495e99867299a0281b6442&sign_type=MD5";
        url8 = "https://www.mo9.com/gateway/mobile.shtml?m=ctnTranction&mobile=18600678470&invoice=BABFLBLPNNALLLHL&dealcode=WAAEJAJPNEJOKOEH&amount=1.00&sign=E78EB29367A19A018461398DB129AAE8";
        url9 = "https://www.mo9.com/gateway/wap_gateway.shtml?m=showPayResult";
        url10 = "http://test.g.kuaiazs.com/foreign/recharge/callback.php?_payType=mo9_wap&orderId=1612209900002000";
        url11 = "http://api.mobile.youigongcha.com/recharge_res.php?orderid=1612209900002000";

        testURLs = new ArrayList<>();
        testURLs.add(url1);
        testURLs.add(url2);
        testURLs.add(url3);
        testURLs.add(url4);
        testURLs.add(url5);
        testURLs.add(url6);
        testURLs.add(url7);
        testURLs.add(url8);
        testURLs.add(url9);
        testURLs.add(url10);
        testURLs.add(url11);
    }

    @Test
    public void test_url11() {
        System.out.println(url11.contains(M_URL));
        String[] split = url11.split("=");
        for (String s : split) {
            System.out.println(s);
        }
    }

    @Test
    public void test_url_full() {
        for (String url : testURLs) {
            Matcher m = compileURL.matcher(url);
            if (m.lookingAt()) {
                System.out.println("Found value: " + m.group(0));
                System.out.println("Found value: " + m.group(1));
                System.out.println("Found value: " + m.group(2));
            } else {
                System.out.println("NO MATCH  at: " + url);
            }
            if (url.matches(IS_URL)) {
                System.out.println("is match url: " + url);
            }
        }
    }
}
