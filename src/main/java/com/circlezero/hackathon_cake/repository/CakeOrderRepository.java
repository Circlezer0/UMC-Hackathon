package com.circlezero.hackathon_cake.repository;

import com.circlezero.hackathon_cake.domain.mapping.CakeStoreImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CakeOrderRepository extends JpaRepository<CakeStoreImage, Long> {
}