package i2i.spring_learn.entities.concretes;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="SUBSCRIBERS")
public class Subscriber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subsc_id")
	private int subsc_id;
	
	@Column(name = "subsc_name")
	private String subsc_name;
	
	@Column(name = "subsc_surname")
	private String subsc_surname;
	
	@Column(name = "msisdn")
	private String msisdn;
	
	@Column(name = "tariff_id")
	private int tariff_id;
	
	@Column(name = "start_date")
	private LocalDateTime start_date = LocalDateTime.now();
}
