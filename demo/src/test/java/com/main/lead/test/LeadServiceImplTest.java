package com.main.lead.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.main.lead.enitites.LeadEntity;
import com.main.lead.repository.LeadRepository;
import com.main.lead.services.LeadServiceImpl;

public class LeadServiceImplTest {
	
	
	@InjectMocks
	LeadServiceImpl leadService;
	
	@Mock
	LeadRepository leadRepository;
	
	
	@BeforeEach
	void setUp()
	{
		MockitoAnnotations.initMocks(this);
	};
	
	
	@Test
	final void findByMobileNumber()
	{
		List<LeadEntity> li = new ArrayList<>();
		LeadEntity leadEntity1 = new LeadEntity();
		leadEntity1.setDOB("15/10/2022");
		leadEntity1.setEmail("vi@gmail.com");
		leadEntity1.setFirstName("Vineet");
		leadEntity1.setLastName("KV");
		leadEntity1.setGender("Male");
		leadEntity1.setMobileNumber("8877887788");
		li.add(leadEntity1);
		
		when(leadRepository.findByMobileNumber(any())).thenReturn(li);
		
		List<LeadEntity> leadEntity = leadService.findByMobileNumber("8877887788");
				assertNotNull(leadEntity);
	            assertEquals(li.get(0).getFirstName(), leadEntity.get(0).getFirstName());
		
}
	
	

}
