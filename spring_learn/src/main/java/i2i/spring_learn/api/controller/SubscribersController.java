package i2i.spring_learn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import i2i.spring_learn.business.abstracts.SubscriberService;
import i2i.spring_learn.entities.concretes.Subscriber;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/subscribers")
@CrossOrigin
public class SubscribersController {
	
	@Autowired
	private SubscriberService subscriberService;
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() Subscriber subscriber) {
		System.out.println(subscriber.getSubsc_id());
		this.subscriberService.add(subscriber);
	}
	
	@GetMapping()
	public List<Subscriber> getAll(){
		return this.subscriberService.getAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int subsc_id) {
		this.subscriberService.delete(subsc_id);
	}
	
	@GetMapping("/{id}")
	public Subscriber getById(@PathVariable int subsc_id) {
		return this.subscriberService.getById(subsc_id);
	}
	
	
}
