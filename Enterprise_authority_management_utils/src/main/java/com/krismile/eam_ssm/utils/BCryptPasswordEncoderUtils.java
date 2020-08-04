package com.krismile.eam_ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author krismile
 * @Create 2020-07-27 17:08
 */
public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // 加密
    public static String encode(String src){
        return encoder.encode(src);
    }


    public static void main(String[] args) {
        String src = "krismile";
        //$2a$10$nffJSyeJaKczaQuWFT6v1uhKpjWOX/smaMsjcx0o7nPCf.dy3zps.
        //$2a$10$47nsO/rk0Zwy8sfY0EAk/urFXQHEwpq9Q5Y9.FJTtEz8DQd6jxs8e
        System.out.println(encoder.encode(src));
    }
}
