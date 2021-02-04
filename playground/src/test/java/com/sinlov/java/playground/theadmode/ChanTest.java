package com.sinlov.java.playground.theadmode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChanTest extends TheadTestTemp {
    private static final String TYPE_SUCCESS = "success";
    private static final String TYPE_TIME_OUT = "timeout";
    private CatchChan<ChanMessage<Integer>> chaneMsg;

    @Before
    public void setUp() throws Exception {
        chaneMsg = new CatchChan<>(2);
    }

    @Test
    public void test_message_select() {
        go(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("One F put TYPE_SUCCESS = " + i);
                chaneMsg.put(new ChanMessage<>(TYPE_SUCCESS, i));
            }
        });

        go(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("TWO F put TYPE_SUCCESS = " + i);
                chaneMsg.put(new ChanMessage<>(TYPE_SUCCESS, i));
            }
        });
        go(() -> {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            chaneMsg.put(new ChanMessage<>(TYPE_TIME_OUT, -1));
        });


        go(() -> {
            while (true) {
                ChanMessage<Integer> selectMsg = chaneMsg.pop();
                switch (selectMsg.getType()) {
                    default:
                        break;
                    case TYPE_SUCCESS:
                        System.out.println("csp TYPE_SUCCESS selectMsg.getData() = " + selectMsg.getData());
                        break;
                    case TYPE_TIME_OUT:
                        System.out.println("csp TYPE_TIME_OUT selectMsg.getData() = " + selectMsg.getData());
                        return;
                }
            }
        });
    }
}