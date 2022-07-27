package com.freesoft.md5;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;

public class CreateMD5 {
    @Test
    public void createPassword() {
        String ps = new Md5Hash("admin", "salt", 2).toString();
        System.out.println(ps);
    }
}
