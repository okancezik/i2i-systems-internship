package i2i.spring_learn.business.abstracts;

import i2i.spring_learn.entities.concretes.Subscriber;
import java.util.List;


public interface SubscriberService {

	void add(Subscriber subscriber);
	void delete(int subsc_id);
	List<Subscriber> getAll();
	Subscriber getById(int subsc_id);
}
