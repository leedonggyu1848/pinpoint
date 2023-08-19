package naver.pinpoint.example.controller;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long count;
	private String name;

	public Ping(String name) {
		this.name = name;
		this.count = 0L;
	}

	public Ping() {

	}

	public void increaseCount() {
		this.count++;
	}

	public void decreaseCount() {
		this.count--;
	}

	public Long getCount() {
		return this.count;
	}
}
