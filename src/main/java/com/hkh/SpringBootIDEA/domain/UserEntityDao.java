package com.hkh.SpringBootIDEA.domain;

public interface UserEntityDao {
    public void saveUser(UserEntity user);

    public UserEntity findUserByUserName(String userName);

    public int updateUser(UserEntity user);

    public void deleteUserById(Long id);
}
