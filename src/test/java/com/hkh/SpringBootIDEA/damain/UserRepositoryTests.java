package com.hkh.SpringBootIDEA.damain;

import com.hkh.SpringBootIDEA.domain.User;
import com.hkh.SpringBootIDEA.domain.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
//        String formattedDate = dateFormat.format(date);

//        userRepository.save(new User("userA","aaaaaa","aaa@qq.com","a",formattedDate));
//        userRepository.save(new User("userB","bbbbbb","bbb@qq.com","b",formattedDate));
//        userRepository.save(new User("userC","cccccc","ccc@qq.com","c",formattedDate));

//        Assert.assertEquals(3, userRepository.findAll().size());
//        Assert.assertEquals("b", userRepository.findByUserNameOrEmail("userB","bbb@qq.com").getNickName());

//        userRepository.delete(userRepository.findByUserName("userA"));
    }

    @Test
    public void testPageQuery() throws Exception {
        int page = 0, size = 2;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<User> userPage = userRepository.findAll(pageable);
        System.out.println(userPage.getSize());
        System.out.println(userPage.getContent().get(0).getUserName()
        );
    }

    @Test
    public void testLimitedQuery() {
        System.out.println(userRepository.findTopByOrderByIdDesc().getEmail());
    }

    @Test
    public void testCustomerSQL() {
        String nickName = "b";
        System.out.println(userRepository.findByNickName(nickName).getEmail());
    }

    @Test
    public void testCustomerModifySQL() {
        String nickName = "b";
        String newEmail = "newbbb@qq.com";
        System.out.println(userRepository.modifyEmailByNickName(newEmail, nickName));
    }
}
