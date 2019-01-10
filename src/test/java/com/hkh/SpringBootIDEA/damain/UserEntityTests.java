package com.hkh.SpringBootIDEA.damain;

import com.hkh.SpringBootIDEA.domain.mybatis.UserEntity;
import com.hkh.SpringBootIDEA.enums.UserSexEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityTests {

    @Test
    public void testUserEntityToString() {
        UserEntity userEntity = new UserEntity("username", "passowrd", UserSexEnum.MAN);
        userEntity.setNickName("nn");
        System.out.println(userEntity.toString());
    }
}
