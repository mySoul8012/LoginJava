package com.ming.Util;

import org.junit.Test;

import static org.junit.Assert.*;

public class TokenUtilTest {

    @Test
    public void getTokenUtil() {
        for(int i = 0; i < 100000; i ++) {
            TokenUtil tokenUtil = TokenUtil.getTokenUtil();
            System.out.println(tokenUtil.toToken());
        }
    }
}