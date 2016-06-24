package cc.tonny.springclouddemo.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.tonny.springclouddemo.ui.domain.Person;
import cc.tonny.springclouddemo.ui.service.PersonHystrixService;
import cc.tonny.springclouddemo.ui.service.SomeHystrixService;

@RestController
@EnableResourceServer
public class UiController {
	@Autowired
	private SomeHystrixService someHystrixService;
	
	@Autowired
	private PersonHystrixService personHystrixService;

	@RequestMapping("/dispatch")
	public List<Person> sendMessage(@RequestBody String personName) {
		return personHystrixService.save(personName);
	}
	
	@RequestMapping(value = "/getsome",produces={MediaType.TEXT_PLAIN_VALUE})
	public String getSome(){
		return someHystrixService.getSome();
	}
}
