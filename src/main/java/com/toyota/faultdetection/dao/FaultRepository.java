package com.toyota.faultdetection.dao;

import com.toyota.faultdetection.domain.Fault;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaultRepository extends JpaRepository<Fault, Long> {

}

