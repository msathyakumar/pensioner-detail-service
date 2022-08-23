package com.cognizant.microservices.pensionerdetailservice.models;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
	
	private String bankName;					// Bank Name of the Pensioner Eg. SBI, HDFC etc.
	private String accountNumber;				// Account Number of the Pensioner
	private String bankType;

}
