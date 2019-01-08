package com.hkh.SpringBootIDEA.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);

    User findByUserNameOrEmail(String userName, String email);

    User findTopByOrderByIdDesc();

    //    @Transactional(timeout = 10)
    @Query("select u from User u where u.nickName=?1")
    User findByNickName(String nickName);

    @Transactional
    @Modifying
    @Query("update User u set u.email=?1 where u.nickName=?2")
    int modifyEmailByNickName(String email, String nickName);

}
