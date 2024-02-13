package app.core.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" })
//@ToString(exclude = {"casualties"})
@Entity
public class Family {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 9, unique = true, nullable = false)
	private String tz;
	private String name;
	private String email;
	@Column(length = 5)
	private String password;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "casualty_id") // Adjust the column name accordingly
	private Casualty casualty;
	
	


}
