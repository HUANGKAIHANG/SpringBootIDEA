package com.hkh.SpringBootIDEA.mapper;

import com.hkh.SpringBootIDEA.domain.mybatisxml.UserEntityXML;
import com.hkh.SpringBootIDEA.enums.UserSexEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserXMLMapperTests {

    @Autowired(required = false)
    private UserXMLMapper userXMLMapper;

    @Test
    public void testInsert() {
        userXMLMapper.insert(new UserEntityXML("ee", "e123456", UserSexEnum.MAN));
        userXMLMapper.insert(new UserEntityXML("ff", "f123456", UserSexEnum.WOMAN));
        userXMLMapper.insert(new UserEntityXML("gg", "g123456", UserSexEnum.WOMAN));
        System.out.println(userXMLMapper.getAll().size());
    }

    @Test
    public void testQuery() {
        System.out.println(userXMLMapper.getAll().size());
        System.out.println(userXMLMapper.getOne(29L));
    }

    @Test
    public void testUpdate() {
        UserEntityXML userEntityXML = userXMLMapper.getOne(33L);
        System.out.println(userEntityXML.toString());
        userEntityXML.setNickName("燕燕");
        userXMLMapper.update(userEntityXML);
    }

    @Test
    public void testDelete() {
        userXMLMapper.delete(34L);
        System.out.println(userXMLMapper.getAll().size());
    }
}
