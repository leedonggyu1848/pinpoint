package naver.pinpoint.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PingController {
	private final PingService service;

	@GetMapping("/ping")
	public Ping ping(@RequestParam("name") String name) {
		return service.create(name);
	}

	@GetMapping("/increase")
	public Ping increase(@RequestParam("name") String name) {
		return service.increaseCount(name);
	}

	@GetMapping("/decrease")
	public Ping decrease(@RequestParam("name") String name) {
		return service.decreaseCount(name);
	}

}
