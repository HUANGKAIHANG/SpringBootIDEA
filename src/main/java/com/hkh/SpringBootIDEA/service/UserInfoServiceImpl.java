package com.hkh.SpringBootIDEA.service;

import com.hkh.SpringBootIDEA.domain.UserInfo;
import com.hkh.SpringBootIDEA.domain.UserInfoDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("service实现类的找UserInfo方法启动。。。");
        return userInfoDao.findByUsername(username);
    }
}
