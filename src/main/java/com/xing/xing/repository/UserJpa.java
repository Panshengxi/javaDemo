package com.xing.xing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xing.xing.entity.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpa extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByCk(String ck);
    User findByMobile(String mobile);
    User findByMobileAndPassword(String mobile,String password);
}
