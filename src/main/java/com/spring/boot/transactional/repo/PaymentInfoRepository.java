package com.spring.boot.transactional.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.transactional.model.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {

}
