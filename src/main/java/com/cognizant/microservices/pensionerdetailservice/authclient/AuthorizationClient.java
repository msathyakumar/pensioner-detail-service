package com.cognizant.microservices.pensionerdetailservice.authclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
//${AUTHSERVICEURL}
//@FeignClient(name="auth-service",url = "http://localhost:8081}")
//@FeignClient(name = "authorizationService", url = "http://localhost:9090")
@FeignClient(name="authorizationService",url = "${AUTHSERVICEURL:http://localhost:9090}")
public interface AuthorizationClient {
	

	//validating jwt token with authorization microservice
	@GetMapping("/authorize")
	public Boolean authorization(@RequestHeader("Authorization") String token1);
	//final update

}
