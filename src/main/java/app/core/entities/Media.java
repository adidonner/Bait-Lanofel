package app.core.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
@EqualsAndHashCode(of = {"id"})
//@ToString(exclude = {"casualties"} )
//@ToString(exclude = {"company", "customers"} )
//@ToString(exclude = {"companyId", "customers"} )
@Entity
public class Media {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "casualty_id")
	private Casualty casualty;
	
//	private int casualtyId;

	@Enumerated(EnumType.STRING)
	private Category category;
	@Column(unique = true, nullable = false)
	private String title;
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate mediaTakenDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate mediaUploadedDate;
	private int age;
	private String image;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(

			name = "friend_media",

			joinColumns = @JoinColumn(name = "media_id"),

			inverseJoinColumns = @JoinColumn(name = "friend_id")

	)
	private List<Friend> friends;
	
	public enum Category {
		BABY, KID, PRIMERY_SCHOOL, HIGH_SCHOOL, ARMY_SERVICE, HIGH_EDUCATION, MARRIAGE, VACATIONS, HOLIDAYS, WORK, VOLUNTARY_WORK, GRADUATION, OTHER ; 
	}
	
	private int sourceId;
	private boolean mediaSourceFamily;
	 
//	public enum MediaSource{
//		 FAMILY, FRIEND, OTHER;
//	 }

}