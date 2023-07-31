package i2i.spring_learn.data_access.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import i2i.spring_learn.entities.concretes.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, Integer>{

}
