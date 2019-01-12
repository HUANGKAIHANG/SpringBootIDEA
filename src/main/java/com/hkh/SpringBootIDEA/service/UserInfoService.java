package com.hkh.SpringBootIDEA.service;

import com.hkh.SpringBootIDEA.domain.UserInfo;

public interface UserInfoService {

    public UserInfo findByUsername(String username);
}
