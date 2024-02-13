//package app.core.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import app.core.entities.Media;
//import app.core.entities.Media.Category;
//import app.core.entities.Friend;
//import app.core.exceptions.MediasException;
//import app.core.exceptions.FriendsException;
//import app.core.repositories.MediaRepo;
//import app.core.repositories.FriendRepo;
//
//@Service
//@Scope("prototype")
//@Transactional
//public class FriendService extends ClientService {
//
//	@Autowired
//	private FriendRepo friendRepo;
//
//	@Autowired
//	private MediaRepo mediaRepo;
//
//
//	public List<Media> getAllMedias(){
//		return mediaRepo.findAll();
//	}
//	
//	public Media purchaseMedia(int friendId, int mediaId) {
//		Friend friend = friendRepo.findById(friendId)
//				.orElseThrow(() -> new FriendsException("purchase failed - friend not found"));
//		Media media = mediaRepo.findById(mediaId)
//				.orElseThrow(() -> new MediasException("purchase failed -media not found"));
//		if (media.getAge() > 0 && !friend.getMedias().contains(media)) {
//			friend.addMedia(media);
//			int x = media.getAge() - 1;
//			media.setAge(x);
//			mediaRepo.flush();
//			return media;
//		} else {
//			throw new MediasException("purchaseMedia faild - friend already has this media or media amount zero");
//		}
//	}
//
//	/**
//	 * @param mediaId
//	 * @return
//	 * @throws MediasException if the specified media not exists
//	 */
//	public Media getMediaById(int friendId, int mediaId) throws MediasException {
//		return mediaRepo.findById(mediaId)
//				.orElseThrow(() -> new MediasException("getMediaById failed - not found" + mediaId));
//	}
//
//	public List<Media> getFriendMedias(int friendId) {
//		List<Media> medias = friendRepo.findById(friendId).get().getMedias();
//		return medias;
//	}
//
//	 public List<Media>getFriendMediasByCategory(int friendId, Category category){
//	       
//		 return mediaRepo.findAllByFriendsAndCategory(friendRepo.findById(friendId).get(), category);
//    }
//		
//
//	public Friend friendDetails(int friendId) {
//		return friendRepo.findById(friendId)
//				.orElseThrow(() -> new FriendsException("getFriendDetails failed - not found"));
//	}
//
//}
