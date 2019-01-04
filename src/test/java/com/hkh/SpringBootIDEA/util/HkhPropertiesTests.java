package com.hkh.SpringBootIDEA.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HkhPropertiesTests {

    @Autowired
    private HkhProperties hkhProperties;

    @Test
    public void getProperties() {
        System.out.println(hkhProperties.getTitle());
        System.out.println(hkhProperties.getDescription());
        Assert.assertEquals(hkhProperties.getTitle(), "SpringBoot学习项目");
        Assert.assertEquals(hkhProperties.getDescription(), "基于纯洁的微笑");
    }
}
