package app.core.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Friend;



public interface FriendRepo extends JpaRepository<Friend, Integer> {

	Optional<Friend> findByEmailAndPassword(String email, String password);

	boolean existsByTz(String tz);

}
