package com.xing.xing.repository;

import com.xing.xing.entity.HomeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeJpa extends JpaRepository<HomeInfo, Long> {
    HomeInfo findByPlatform(String platform);
}
