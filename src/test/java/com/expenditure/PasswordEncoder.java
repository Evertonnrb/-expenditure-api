package com.expenditure;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    @Test
    public void showEncoder(){
        //user1 $2a$10$xqQ2cT1ByV2TgzEENfWY8.d72JQ0bFBlS1f4GJ30vAOLqohrFPHdi
        //admin $2a$10$IwDZFhxWAnmcOb/3kqotj.qbxD2vTMnk.aE6BzAMyvctBclSMKA9e

        BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
        System.out.println(pass.encode("admin"));
    }
}
