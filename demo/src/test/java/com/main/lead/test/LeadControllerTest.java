package com.main.lead.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.main.lead.controllers.LeadController;
import com.main.lead.enitites.LeadEntity;
import com.main.lead.mapper.LeadMapper;
import com.main.lead.models.LeadDTO;
import com.main.lead.response.ResponseDto;
import com.main.lead.services.LeadService;

public class LeadControllerTest {
	

    @Mock
    private LeadService leadService;

    @Mock
    private LeadMapper leadMapper;

    @InjectMocks
    private LeadController leadController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateLead() {
        // Mocking the behavior of LeadService
        when(leadService.existsById(any())).thenReturn(false);

        // Your test data
        LeadDTO leadDTO = new LeadDTO();
        leadDTO.setEmail("vi@gmail.com");
        leadDTO.setFirstName("Vineet");
        BindingResult bindingResult = mock(BindingResult.class);

        // Executing the controller method
        ResponseEntity<?> responseEntity = leadController.createLead(leadDTO, bindingResult);

        // Verifying the behavior
        verify(leadService).existsById(any());
        verify(leadMapper).toEntity(any());
        verify(leadService).saveLead(any());

        // Assertions based on the expected behavior
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("success", ((ResponseDto) responseEntity.getBody()).getStatus());
        assertEquals("Created Leads Successfully", ((ResponseDto) responseEntity.getBody()).getData());
    }

    @Test
    void testFetchLead() {
        // Mocking the behavior of LeadService
        String mobileNumber = "8877887788";
		LeadEntity leadEntity1 = new LeadEntity();
		leadEntity1.setDOB("15/10/2022");
		leadEntity1.setEmail("vi@gmail.com");
		leadEntity1.setFirstName("Vineet");
		leadEntity1.setLastName("KV");
		leadEntity1.setGender("Male");
		leadEntity1.setMobileNumber("8877887788");
		
        List<LeadEntity> mockLeads = Collections.singletonList(leadEntity1);

        when(leadService.findByMobileNumber(mobileNumber)).thenReturn(mockLeads);

        // Executing the controller method
        ResponseEntity<ResponseDto> responseEntity = leadController.fetchLead(mobileNumber);

        // Verifying the behavior
        verify(leadService).findByMobileNumber(mobileNumber);

        // Assertions based on the expected behavior
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("success", responseEntity.getBody().getStatus());
        assertEquals(mockLeads, responseEntity.getBody().getData());
    }

}
