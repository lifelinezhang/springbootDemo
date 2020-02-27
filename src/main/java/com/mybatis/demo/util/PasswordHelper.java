package com.mybatis.demo.util;

import com.mybatis.demo.pojo.User;
import org.springframework.util.DigestUtils;

public class PasswordHelper {
    public static final String ALGORITHM_NAME = "md5"; // 基础散列算法
    public static final int HASH_ITERATIONS = 0; // 自定义散列次数

    // 因为这个地方生成密码的时候没有进行散列，所以上面的散列次数为0
    public static User encryptUser(User user) {
        String password = DigestUtils.md5DigestAsHex((user.getPhone() + user.getPassword()).getBytes());
        user.setPassword(password);
        return user;
    }
}
