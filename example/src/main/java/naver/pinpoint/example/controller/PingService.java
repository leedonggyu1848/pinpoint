package naver.pinpoint.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class PingService {
	private final PingRepository repository;

	public Ping create(String name) {
		return repository.findByName(name).orElseGet(() -> repository.save(new Ping(name)));
	}

	public Ping increaseCount(String name) {
		Ping ping = repository.findByName(name).orElseThrow(() -> new IllegalArgumentException("Invalid name: " + name));
		ping.increaseCount();
		return repository.save(ping);
	}

	public Ping decreaseCount(String name) {
		Ping ping = repository.findByName(name).orElseThrow(() -> new IllegalArgumentException("Invalid name: " + name));
		ping.decreaseCount();
		return repository.save(ping);
	}
}
