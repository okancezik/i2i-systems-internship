package i2i.spring_learn.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import i2i.spring_learn.business.abstracts.SubscriberService;
import i2i.spring_learn.data_access.abstracts.SubscriberRepository;
import i2i.spring_learn.entities.concretes.Subscriber;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class SubscriberManager implements SubscriberService {

	@Autowired
	private SubscriberRepository subscriberRepository;

	@Override
	public void add(Subscriber subscriber) {
		this.subscriberRepository.save(subscriber);

	}

	@Override
	public void delete(int subsc_id) {
		this.subscriberRepository.deleteById(subsc_id);

	}

	@Override
	public List<Subscriber> getAll() {
		return this.subscriberRepository.findAll();
	}

	@Override
	public Subscriber getById(int subsc_id) {
		return this.subscriberRepository.findById(subsc_id).orElseThrow();
	}

}
