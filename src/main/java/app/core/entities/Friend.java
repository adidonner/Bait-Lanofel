package app.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "medias" )
@EqualsAndHashCode(of = "id")
@Entity
public class Friend {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 9, unique = true, nullable = false)
	private String tz;
	private String firstName;
	private String lastName;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(length = 4)
	private String password;
	
	@ManyToMany
	@JoinTable(

			name = "friend_media",

			joinColumns = @JoinColumn(name = "friend_id"),

			inverseJoinColumns = @JoinColumn(name = "media_id")

	)
	private List<Media> medias;

	public void addMedia(Media media) {
		if (medias == null) {
			medias = new ArrayList<>();
		}
		medias.add(media);
	}
	
}
