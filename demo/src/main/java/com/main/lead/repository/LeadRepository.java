package com.main.lead.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.lead.enitites.LeadEntity;


@Repository
public interface LeadRepository extends JpaRepository<LeadEntity, Long> {

	List<LeadEntity> findByMobileNumber(String mobileNumber);
	

}
