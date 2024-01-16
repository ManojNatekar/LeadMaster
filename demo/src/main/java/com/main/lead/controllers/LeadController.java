package com.main.lead.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.lead.ExceptionHandler.LeadNotFoundException;
import com.main.lead.enitites.LeadEntity;
import com.main.lead.mapper.LeadMapper;
import com.main.lead.models.LeadDTO;
import com.main.lead.response.ErrorResponseDto;
import com.main.lead.response.ResponseDto;
import com.main.lead.services.LeadService;

import jakarta.validation.Valid;

@RestController
public class LeadController {

	@Autowired
	private LeadService leadService;

	@Autowired
	private LeadMapper leadMapper;
	 
	@PostMapping("/create")
	public ResponseEntity<?> createLead(@Valid @RequestBody LeadDTO leadDTO,BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) {
		        bindingResult.getAllErrors().forEach(error -> System.out.println(error));
		        return ResponseEntity.badRequest().body("Validation error");
		    }
		
		if (leadService.existsById(leadDTO.getLeadId())) {
			ErrorResponseDto errorResponse = new ErrorResponseDto("E10010",
					"Lead Already Exists in the database with the lead id");
			return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		LeadEntity entity = leadMapper.toEntity(leadDTO);
		leadService.saveLead(entity);
		ResponseDto response = new ResponseDto("success", "Created Leads Successfully");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	};
	
	
	@GetMapping("/fetch")
	public ResponseEntity<ResponseDto> fetchLead(@RequestParam String mobileNumber)
	{ 
		 List<LeadEntity> leads = leadService.findByMobileNumber(mobileNumber);

	        if (leads.isEmpty()) {
	            // No leads found for the given mobile number
	           throw new LeadNotFoundException("No leads found for the provided mobile number.");
	        }
	        ResponseDto responseDto = new ResponseDto("success", leads);
	        return ResponseEntity.ok(responseDto);
	    }
	

}
