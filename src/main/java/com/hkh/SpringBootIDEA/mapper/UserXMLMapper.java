package com.hkh.SpringBootIDEA.mapper;

import com.hkh.SpringBootIDEA.domain.mybatisxml.UserEntityXML;

import java.util.List;

public interface UserXMLMapper {
    List<UserEntityXML> getAll();

    UserEntityXML getOne(Long id);

    void insert(UserEntityXML user);

    void update(UserEntityXML user);

    void delete(Long id);
}
