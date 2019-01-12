package com.hkh.SpringBootIDEA.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserInfoDao extends CrudRepository<UserInfo, Long> {

    public UserInfo findByUsername(String username);
}
