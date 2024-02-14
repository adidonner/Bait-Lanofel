package app.core.entities;

import java.time.LocalDate;
import java.util.ArrayList;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString(exclude = { "medias", "families" })
@Entity
public class Casualty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 9, unique = true, nullable = false)
	private String tp;

	// meta data
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String familyName;
	private String residence;
	private String school;
	private String heroImage;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate demiseDate;
	@Enumerated(EnumType.STRING)
	private ArmyUnit armyUnit;

	 @OneToMany(mappedBy = "casualty", cascade = CascadeType.ALL)
	    private List<Family> families;
	 
	 @OneToMany(mappedBy = "casualty",

			cascade = { CascadeType.DETACH, 
						
						CascadeType.MERGE, 
						
						CascadeType.PERSIST, 

						CascadeType.REMOVE, 
						
						CascadeType.REFRESH }) 
	@JsonIgnore
	private List<Media> medias;

	public void addMedia(Media media) {
		if (this.medias == null) {
			this.medias = new ArrayList<>();
		}
//		media.setCasualty(this);
		media.setCasualty(this);
		medias.add(media);

	}

}
