package com.freesoft.md5;

import com.freesoft.util.MD5Util;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;

public class CreateMD5 {
    @Test
    public void createPassword() {
        String ps = new Md5Hash("admin", "salt", 2).toString();
        System.out.println(ps);
        String ps2 = "21232f297a57a5a743894a0e4a801fc3";

        System.out.println(ps2);
    }
}
