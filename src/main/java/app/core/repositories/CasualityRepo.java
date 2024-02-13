package app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Casualty;

public interface CasualityRepo extends JpaRepository<Casualty, Integer> {

	boolean existsByTp(String tp);


}
