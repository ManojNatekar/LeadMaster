package com.main.lead.services;


import java.util.List;

import com.main.lead.enitites.LeadEntity;

public interface LeadService {
	
	  public void saveLead(LeadEntity lead) ;
	  
	  boolean existsById(Long userId);
	  
	  List<LeadEntity>  findByMobileNumber(String mobileNumber);

}
