package com.main.lead.response;

import java.util.List;

import com.main.lead.enitites.LeadEntity;

public class ResponseDto {

	private String status;
	private Object data;

	public ResponseDto(String status, String data) {
		this.status = status;
		this.data = data;
	}

	public ResponseDto(String status, List<LeadEntity> leads) {
		this.status=status;
		data=leads;
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

}
