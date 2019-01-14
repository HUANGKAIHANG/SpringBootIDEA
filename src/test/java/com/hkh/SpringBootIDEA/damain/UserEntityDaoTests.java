package com.hkh.SpringBootIDEA.damain;

import com.hkh.SpringBootIDEA.domain.UserEntity;
import com.hkh.SpringBootIDEA.domain.UserEntityDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityDaoTests {
    @Autowired
    private UserEntityDao userEntityDao;

    @Test
    public void testSaveUser(){
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUserName("航123");
        user.setPassWord("123456");
        userEntityDao.saveUser(user);
    }

    @Test
    public void findUserByUserName(){
        UserEntity user = userEntityDao.findUserByUserName("hang");
        System.out.println(user.toString());
    }

    @Test
    public void updateUser(){
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUserName("hang");
        user.setPassWord("hang");
        userEntityDao.updateUser(user);
    }

    @Test
    public void deleteUserById(){
        userEntityDao.deleteUserById(1L);
    }
}
