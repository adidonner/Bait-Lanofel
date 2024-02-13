package app.core.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import app.core.entities.Casualty;
import app.core.entities.Family;
import app.core.entities.Friend;
import app.core.exceptions.CasualitiesException;
import app.core.exceptions.FamiliesException;
import app.core.exceptions.FriendsException;
import app.core.repositories.CasualityRepo;
import app.core.repositories.FamilyRepo;
import app.core.repositories.FriendRepo;

/**
 * @author adido
 *
 */
@Service
@Transactional
public class AdminService extends ClientService {

	@Value("${admin.email}")
	private String adminEmail;
	@Value("${admin.password}")
	private String adminPassword;
	@Autowired
	private CasualityRepo casualityRepo;
	@Autowired
	private FamilyRepo familyRepo;
	@Autowired
	private FriendRepo friendRepo;


	
	// tp must be unique
	public Casualty addCasuality(Casualty casualty) throws CasualitiesException {
		if (!this.casualityRepo.existsByTp(casualty.getTp())) {
			this.casualityRepo.save(casualty);
			return casualty;
		} else {
			throw new CasualitiesException(
					"addCasuality failed - a casuality with this casuality tp already exists: " + casualty.getTp());
		}
	}
	// tz must be unique
	public Family addFamily(Family family) throws FamiliesException {
		if (!this.familyRepo.existsByTz(family.getTz())) {
			this.familyRepo.save(family);
			return family;
		} else {
			throw new FamiliesException(
					"addFamily failed - a family with this casuality tz already exists: " + family.getTz());
		}
	}

	// tz must be unique
	public Friend addFriend(Friend friend) throws FriendsException {
		if (!this.friendRepo.existsByTz(friend.getTz())) {
			this.friendRepo.save(friend);;
			return friend;
		} else {
			throw new FriendsException("add friend failed - a friend with this tz already exists: "
					+ friend.getTz());
		}
	}

	public Casualty getCasualtyById(int casualtyId) throws CasualitiesException {
		return this.casualityRepo.findById(casualtyId)
				.orElseThrow(() -> new CasualitiesException("get get Casualty By Id failed - not found" + casualtyId));
	}
	/**
	 * @param familyId
	 * @return
	 * @throws FamiliesException if specified family not found
	 */
	public Family getFamilyById(int familyId) throws FamiliesException {
		return this.familyRepo.findById(familyId)
				.orElseThrow(() -> new FamiliesException("get familyById failed - not found" + familyId));
	}
	
	/**
	 * @param friendId
	 * @return
	 * @throws FriendsException if specified friend not found
	 */
	public Friend getFriendById(int friendId) throws FriendsException {
		return this.friendRepo.findById(friendId)
				.orElseThrow(() -> new FriendsException("get Friend By Id failed - not found " + friendId));
	}

	public List<Casualty> getAllCasualties() {
		return casualityRepo.findAll();
	}
	
	public List<Family> getAllFamilies() {
		return familyRepo.findAll();
	}
	
	public List<Friend> getAllFriends() {
		return friendRepo.findAll();
	}

	public Casualty updateCasualty(Casualty casualty) throws CasualitiesException {
		if (this.casualityRepo.existsById(casualty.getId())) {
			System.out.println(casualty.getId());
			return this.casualityRepo.save(casualty);
		} else {
			throw new CasualitiesException("update casualty failed - not found" + casualty.getId());
		}
	}
	
	/**
	 * @param family
	 * @return
	 * @throws FamiliesException if specified family not found
	 */
	public Family updateFamily(Family family) throws FamiliesException {
		if (this.familyRepo.existsById(family.getId())) {
			System.out.println(family.getId());
			return this.familyRepo.save(family);
		} else {
			throw new FamiliesException("updateFamily failed - not found" + family.getId());
		}
	}
	
	/**
	 * @param friend
	 * @return
	 * @throws FriendsException if specified friend not found
	 */
	public Friend updateFriend(Friend friend) throws FriendsException {
		if (this.friendRepo.existsById(friend.getId())) {
			return this.friendRepo.save(friend);
		}
		throw new FriendsException("updateFriend failed - not found" + friend.getId());
	}

	

	public void deleteCasualtyById(int casualtyId) throws CasualitiesException {
		if (this.familyRepo.existsById(casualtyId)) {
			this.familyRepo.deleteById(casualtyId);
		} else {
			throw new CasualitiesException("delete casualty By Id failed - not found: " + casualtyId);
		}
	}
	
	/**
	 * @param familyId
	 * @throws FamiliesException if specified family not found
	 */
	public void deleteFamilyById(int familyId) throws FamiliesException {
		if (this.familyRepo.existsById(familyId)) {
			this.familyRepo.deleteById(familyId);
		} else {
			throw new FamiliesException("delete Family By Id failed - not found: " + familyId);
		}
	}

	/**
	 * @param friendId
	 * @throws FriendsException if specified friend not found
	 */
	public void deleteFriendById(int friendId) throws FriendsException {
		if (this.friendRepo.existsById(friendId)) {
			this.friendRepo.deleteById(friendId);
		} else {
			throw new FriendsException("deleteFriend failed - not found: " + friendId);
		}
	}

}
