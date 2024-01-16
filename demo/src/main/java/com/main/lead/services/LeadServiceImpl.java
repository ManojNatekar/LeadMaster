package com.main.lead.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.lead.enitites.LeadEntity;
import com.main.lead.repository.LeadRepository;


@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepository;

	@Override
	public void saveLead(LeadEntity lead) {
		leadRepository.save(lead);
	}

	@Override
	public boolean existsById(Long userId) {
		return leadRepository.existsById(userId);
	}

	@Override
	public List<LeadEntity> findByMobileNumber(String mobileNumber) {
		return leadRepository.findByMobileNumber(mobileNumber);
	}
	
	

}
