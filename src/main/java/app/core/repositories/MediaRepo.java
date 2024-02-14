package app.core.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Friend;
import app.core.entities.Media;
import app.core.entities.Media.Category;

public interface MediaRepo extends JpaRepository<Media, Integer> {

	List<Media> findAllByFriendsAndCategory(Friend friend, Category category);

//	boolean existsByTitle(String title);

//	List<Media> findAllByFamilyIdAndCategory(int id, Category category);


//	Optional<Media> findByIdAndFamilyId(int couponId, int id);


//	List<Media> findAllByFriendsAndCategory(Friend customers, Category category);
	
}
