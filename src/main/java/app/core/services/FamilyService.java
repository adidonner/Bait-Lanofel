package app.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Family;
import app.core.entities.Media;
import app.core.exceptions.FamiliesException;
import app.core.exceptions.MediasException;
import app.core.repositories.FamilyRepo;
import app.core.repositories.MediaRepo;

/**
 * @author adido
 *
 */
@Service
@Transactional
public class FamilyService extends ClientService {

	@Autowired
	private FamilyRepo familyRepo;
	@Autowired
	private MediaRepo mediaRepo;

//	public Media addMediaToFamily(int familyId, Media media) throws MediasException {
	public Media familyAddMedia(int familyId, Media media) throws MediasException {
		if (!this.mediaRepo.existsById(media.getId())) {
			Family family = familyRepo.findById(familyId)
					.orElseThrow(() -> new FamiliesException("Family id: " + familyId + " not found"));
//			media.setMediaSource(MediaSource.FAMILY);
			media.setMediaSourceFamily(true);
			media.setSourceId(familyId);
			media.setCasualty(family.getCasualty());
			mediaRepo.save(media);
			family.getCasualty().addMedia(media);
			familyRepo.save(family);
//			media.setFamily(family);
			return media;
		} else {
			throw new MediasException(
					"addMediaToFamily failed - a media with this id already exists" + media.getId());
		}
	}


	//****** needs to be arranged ************
	
//	public Media updateMedia(int familyId, Media media) throws MediasException {
//		media.setFamily(getFamilyDetails(familyId));
//		media.setFriends(getMediaById(familyId, media.getId()).getFriends());
//		return mediaRepo.save(media);
//	}

	/**
	 * @param mediaId
	 * @return media
	 * @throws MediasException if the specified media not exists
	 */
	public Media getMediaById(int familyId, int mediaId) throws MediasException {
		Media media = mediaRepo.findById(mediaId)
				.orElseThrow(() -> new MediasException("Media Id: " + mediaId + " not found "));
//		if (media.getFamilyId() != familyId) {
//			throw new MediasException("This media does not belong to family id: " + familyId);
//		}
		return media;
	}

	public void deleteMediaById(int familyId, int mediaId) throws MediasException {
		Media media = mediaRepo.findById(mediaId)
				.orElseThrow(() -> new MediasException("Media Id: " + mediaId + " not found "));
//		if (media.getFamilyId() != familyId) {
//			throw new MediasException("This media does not belong to family id: " + familyId);
//		}
		mediaRepo.delete(media);
	}

	//****** needs to be arranged ************
	
//	public List<Media> getMediasForFamily(int familyId) {
//		return familyRepo.findById(familyId).get().getMedias();
//	}

//	public List<Media> getAllFamilyMediasByCategory(int familyId, Category category) {
//		return mediaRepo.findAllByFamilyIdAndCategory(familyId, category);
//	}


	/**
	 * @param media
	 * @return
	 * @throws MediasException if the specified media not exists
	 */

	//****** needs to be arranged ************
	
//	public Family getFamilyDetails(int familyId) throws CompaniesException {
//		return familyRepo.findById(familyId)
//				.orElseThrow(() -> new FamiliesException("getFamilyDetails failed - not found"));
//	}

}
