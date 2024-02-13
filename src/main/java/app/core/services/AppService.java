package app.core.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Media;
import app.core.entities.Friend;
import app.core.exceptions.MediasException;
import app.core.exceptions.FriendsException;
import app.core.repositories.MediaRepo;
import app.core.repositories.FriendRepo;

@Service
@Transactional
public class AppService {
	
	@Autowired
	private FriendRepo friendRepo;
	@Autowired
	private MediaRepo mediaRepo;

	public Media purchaseMedia(int friendId, int mediaId) throws Exception {
		Optional<Friend> optFriend = Optional.of(friendRepo.findById(friendId)
				.orElseThrow(() -> new FriendsException(
						"purchaseMedia faild - friendId: " + friendId + "not found")));
		Optional<Media> optMedia = Optional.of(mediaRepo.findById(mediaId)
				.orElseThrow(() -> new MediasException(
						"purchaseMedia faild - mediaId: " + mediaId + "not found")));
		if (optMedia.isPresent() && optFriend.isPresent()) {
			Friend friend = optFriend.get();
			Media media = optMedia.get();
			friend.addMedia(media);
			return media;
		} else {
			throw new MediasException("purchaseMedia faild - friend already has this media or media amount zero");
		}
	}

}
