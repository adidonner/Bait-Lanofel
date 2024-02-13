package app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Family;

public interface FamilyRepo extends JpaRepository<Family, Integer> {

//	Optional<Family> findByEmailAndPassword(String email, String password);
//	Optional<Family> findByIdEmailAndPassword(int id, String email, String password);

	boolean existsByTz(String tz);


}
