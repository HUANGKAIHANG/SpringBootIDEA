package com.hkh.SpringBootIDEA.service;

import com.hkh.SpringBootIDEA.domain.NewUser;
import com.hkh.SpringBootIDEA.domain.NewUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewUserServiceImpl implements NewUserService {
    @Autowired
    private NewUserRepository newUserRepository;

    @Override
    public List<NewUser> getNewUserList() {
        return newUserRepository.findAll();
    }

    @Override
    public NewUser findNewUserById(long id) {
        return newUserRepository.findById(id);
    }

    @Override
    public void save(NewUser newUser) {
        newUserRepository.save(newUser);
    }

    @Override
    public void edit(NewUser newUser) {
        newUserRepository.save(newUser);
    }

    @Override
    public void delete(long id) {
        newUserRepository.delete(id);
    }
}