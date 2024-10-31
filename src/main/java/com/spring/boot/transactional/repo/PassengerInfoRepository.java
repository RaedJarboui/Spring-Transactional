package com.spring.boot.transactional.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.transactional.model.PassengerInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {

}
