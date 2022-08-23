package com.cognizant.microservices.pensionerdetailservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cognizant.microservices.pensionerdetailservice.models.PensionerDetail;

@Service
public interface PensionerDetailRepository extends JpaRepository<PensionerDetail, String> {

}
