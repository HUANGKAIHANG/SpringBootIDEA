package com.hkh.SpringBootIDEA.service;

import com.hkh.SpringBootIDEA.domain.NewUser;

import java.util.List;

public interface NewUserService {

    public List<NewUser> getNewUserList();

    public NewUser findNewUserById(long id);

    public void save(NewUser newUser);

    public void edit(NewUser newUser);

    public void delete(long id);
}
