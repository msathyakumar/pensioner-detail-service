package com.cognizant.microservices.pensionerdetailservice.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.microservices.pensionerdetailservice.exception.ResourceNotFoundException;
import com.cognizant.microservices.pensionerdetailservice.models.Bank;
import com.cognizant.microservices.pensionerdetailservice.models.PensionerDetail;
import com.cognizant.microservices.pensionerdetailservice.repository.PensionerDetailRepository;



@Service
public class PensionarDetailServiceImpl {
	

	private static final Logger LOGGER = LoggerFactory.getLogger(PensionarDetailServiceImpl.class);
	private PensionerDetailRepository pensionerDetailRepository;

	@Autowired
	public PensionarDetailServiceImpl(PensionerDetailRepository pensionerDetailRepository) {

		this.pensionerDetailRepository = pensionerDetailRepository;
	}

	/*reading pensioner details from csv file
	 * 
	adding all details to database*/
	
	@PostConstruct
	public void savePensionerData() {
		LOGGER.info("STARTED - savePensionerData");
		List<PensionerDetail> pensionerDetailList = new ArrayList<>();

		try {

			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/details.csv"));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				PensionerDetail pensionerDetail = new PensionerDetail();
				pensionerDetail.setAadhaarNumber(data[0]);
				pensionerDetail.setName(data[1]);
				pensionerDetail.setDateOfBirth(data[2]);
				pensionerDetail.setPanNumber(data[3]);
				pensionerDetail.setSalary(Double.parseDouble(data[4]));
				pensionerDetail.setAllowance(Double.parseDouble(data[5]));
				pensionerDetail.setPensionType(data[6]);
				pensionerDetail.setBank(new Bank(data[7], data[8], data[9]));
				//add data to pension
				
				pensionerDetailList.add(pensionerDetail);

			}

		} catch (IOException e) {
			LOGGER.error("EXCEPTION - savePensionerData");
			throw new ResourceNotFoundException("pensioner detail not added");
		}
		
		pensionerDetailRepository.saveAll(pensionerDetailList);
		LOGGER.info("END - savePensionerData");
	}


}
