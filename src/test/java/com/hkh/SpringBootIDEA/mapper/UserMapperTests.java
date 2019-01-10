package com.hkh.SpringBootIDEA.mapper;

import com.hkh.SpringBootIDEA.domain.mybatis.UserEntity;
import com.hkh.SpringBootIDEA.enums.UserSexEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

    @Autowired(required = false) //不加required也没事
    private UserMapper userMapper;

    @Test
    public void testInsert() {
//        userMapper.insert(new UserEntity("aa","a123456", UserSexEnum.MAN));
//        userMapper.insert(new UserEntity("bb","b123456", UserSexEnum.WOMAN));
//        userMapper.insert(new UserEntity("cc","c123456", UserSexEnum.WOMAN));
//        Assert.assertEquals(3,userMapper.getAll().size());
        userMapper.insert(new UserEntity("dd", "d123456", UserSexEnum.WOMAN));
    }

    @Test
    public void testQuery() {
        List<UserEntity> users = userMapper.getAll();
        System.out.println(users.toString());
        System.out.println();
        UserEntity user = userMapper.getOne((long) 28);
        System.out.println(user.toString());
    }

    @Test
    public void testUpdate() {
        UserEntity userEntity = userMapper.getOne(28L);
        System.out.println(userEntity.toString());
        userEntity.setNickName("航");
        userMapper.update(userEntity);
//        Assert.assertTrue("hkh".equals(userMapper.getOne(28L).getNickName()));
    }

    @Test
    public void testDelete() {
        userMapper.delete(31L);
        System.out.println(userMapper.getAll().size());
    }
}
