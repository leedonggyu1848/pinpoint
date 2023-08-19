package naver.pinpoint.example.controller;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PingRepository extends JpaRepository<Ping, Long> {
	Optional<Ping> findByName(String name);
}
