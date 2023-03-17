package com.AdvancedMapping.Mapping.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NoUserErrorDetails {
	
	private LocalDate dateTimeStamp;
	private String message;
	private String details;
	public LocalDate getDateTimeStamp() {
		return dateTimeStamp;
	}
	public void setDateTimeStamp(LocalDate dateTimeStamp) {
		this.dateTimeStamp = dateTimeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public NoUserErrorDetails(LocalDate dateTimeStamp, String message, String details) {
		super();
		this.dateTimeStamp = dateTimeStamp;
		this.message = message;
		this.details = details;
	}
	public NoUserErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}


