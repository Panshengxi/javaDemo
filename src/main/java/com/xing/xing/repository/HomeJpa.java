package com.xing.xing.repository;

import com.xing.xing.entity.HomeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeJpa extends JpaRepository<HomeInfo, Long> {
    HomeInfo findByPlatform(String platform);
}
