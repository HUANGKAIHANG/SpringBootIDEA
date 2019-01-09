package com.hkh.SpringBootIDEA.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewUserRepository extends JpaRepository<NewUser, Long> {
    NewUser findById(long id);

    Long deleteById(Long id);
}
