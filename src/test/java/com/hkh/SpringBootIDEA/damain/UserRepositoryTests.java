package com.hkh.SpringBootIDEA.damain;

import com.hkh.SpringBootIDEA.domain.User;
import com.hkh.SpringBootIDEA.domain.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

//        userRepository.save(new User("userA","aaaaaa","aaa@qq.com","a",formattedDate));
//        userRepository.save(new User("userB","bbbbbb","bbb@qq.com","b",formattedDate));
//        userRepository.save(new User("userC","cccccc","ccc@qq.com","c",formattedDate));

//        System.out.println(userRepository.findAll().size());
//        Assert.assertEquals(3, userRepository.findAll().size());
//
//        System.out.println(userRepository.findByUserNameOrEmail("userB","bbb@qq.com"));
//        System.out.println(userRepository.findByUserNameOrEmail("userB"," "));
//        Assert.assertEquals("b", userRepository.findByUserNameOrEmail("userB","bbb@qq.com").getNickName());

//        userRepository.delete(userRepository.findByUserName("userA"));
    }
}
