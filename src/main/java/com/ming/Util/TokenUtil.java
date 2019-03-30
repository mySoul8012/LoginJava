package com.ming.Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author ming
 * 生成Token工具类
 */
public class TokenUtil {
    // 采用单例模式生成唯一的对象
    private static TokenUtil tokenUtil = new TokenUtil();
    private TokenUtil(){

    }

    // 获取Token对象
    public static TokenUtil getTokenUtil(){
        return tokenUtil;
    }

    // 生成Token
    // 采用哈希编码生成
    public String toToken(){
        // 获取当前日志管理类
        Logger logger = LogManager.getLogger();
        // 获取当前时间戳
        String timeStamp = Long.toString(System.currentTimeMillis());
        String hashtext = null;
        try{
            // 生成信息摘要
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            // 进行哈希运算
            byte[] bytesMessageDigets = messageDigest.digest(timeStamp.getBytes());
            // 转换为大整数包装类型,并且为正数
            BigInteger bigInteger = new BigInteger(1, bytesMessageDigets);
            // 再次转化为字符串类型  返回16进制
            hashtext = bigInteger.toString(16);
            // 若长度不足进行补齐
            while(hashtext.length() < 32){
                hashtext = 0 + hashtext;
            }
        }catch (Exception e){
            logger.error(e);
        }
        return hashtext;
    }
}
