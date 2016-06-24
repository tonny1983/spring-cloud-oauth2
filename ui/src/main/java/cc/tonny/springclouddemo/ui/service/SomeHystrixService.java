package cc.tonny.springclouddemo.ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class SomeHystrixService {

	@Autowired
	private OAuth2RestOperations restTemplate;

	@HystrixCommand(fallbackMethod = "fallbackSome", commandProperties = { @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")}) //2
	public String getSome() {
		return restTemplate.getForObject("http://some/getsome", String.class);
	}
	
	public String fallbackSome(){ 
		return "some service模块故障";
	}
}
