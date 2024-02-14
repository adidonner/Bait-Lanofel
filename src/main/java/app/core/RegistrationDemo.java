package app.core;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import app.core.entities.ArmyUnit;
import app.core.entities.Casualty;
import app.core.entities.Family;
import app.core.entities.Friend;
import app.core.entities.Media;
import app.core.entities.Media.Category;
import app.core.services.AdminService;
import app.core.services.AppService;
import app.core.services.FamilyService;

@Component
@Order(1)
public class RegistrationDemo implements CommandLineRunner {

	@Autowired
	private AdminService adminService;
	@Autowired
	private FamilyService familyService;

	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\n\t\t\t\t==================================== ");
		System.out.println("\t\t\t\t============ REGISTRATION DEMO ============ ");
		System.out.println("\t\t\t\t==================================== ");

		System.out.println("\n========== ADMIN CREATE FAMILY CONTACT ==========");
		Casualty casualty1 = new Casualty();
		casualty1.setTp("000011111");
		casualty1.setName("Eli");
		casualty1.setFamilyName("Cohen");
		casualty1.setResidence("Bat Yam");
		casualty1.setSchool("Faruk");
		casualty1.setHeroImage("https://upload.wikimedia.org/wikipedia/commons/1/10/EliCohen.jpg");
		casualty1.setBirthDate(LocalDate.of(1924, 12, 6));
		casualty1.setDemiseDate(LocalDate.of(1965, 05, 18));
		casualty1.setArmyUnit(ArmyUnit.INTELLIGENCE);

		Family family1 = ctx.getBean(Family.class);
		family1.setTz("012345678");
		family1.setName("Moshe");
		family1.setEmail("cohen@mail");
		family1.setPassword("cohen");
		family1.setCasualty(casualty1);
		
		Casualty casualty2 = new Casualty();
		casualty2.setTp("000022222");
		casualty2.setName("Yonatan");
		casualty2.setFamilyName("Netanyahu");
		casualty2.setResidence("Jerusalem");
		casualty2.setSchool("Rehavia Gymnasium");
		casualty2.setBirthDate(LocalDate.of(1946, 03, 13));
		casualty2.setDemiseDate(LocalDate.of(1976, 07, 4));
		casualty2.setArmyUnit(ArmyUnit.SPECIAL_FORCES);
		casualty2.setHeroImage(
				"https://upload.wikimedia.org/wikipedia/he/a/ac/Yonin.jpg");
	
		Family family2 = ctx.getBean(Family.class);
		family2.setTz("022345678");
		family2.setName("Yona");
		family2.setEmail("netan@mail");
		family2.setPassword("netan");
		family2.setCasualty(casualty2);
		
		Casualty casuality3 = new Casualty();
		casuality3.setTp("000033333");
		casuality3.setName("Moshe");
		casuality3.setFamilyName("Biterman");
		casuality3.setResidence("Galil Yam");
		casuality3.setSchool("Ort");
		casuality3.setBirthDate(LocalDate.of(1954, 2, 1));
		casuality3.setDemiseDate(LocalDate.of(1973, 10, 8));
		casuality3.setArmyUnit(ArmyUnit.GOLANI);
		casuality3.setHeroImage("https://izkorcdn.azureedge.net/Data/korot/Image/093777.jpg");

		Family family3 = ctx.getBean(Family.class);
		family3.setTz("032345678");
		family3.setName("Shoshi");
		family3.setEmail("rhein@mail");
		family3.setPassword("rhein");
		family3.setCasualty(casuality3);

//		System.out.println(family1);
//		System.out.println(family2);
//		System.out.println(family3);
		System.out.println("\n1. " + adminService.addFamily(family1)); // Family register at repository with media
		System.out.println("\n2. " + adminService.addFamily(family2));// Family register at repository with media no. 2
		System.out.println("\n3. " + adminService.addFamily(family3));// Family register at repository with media no. 2
		System.out.println(adminService.getAllFamilies());
		System.out.println(adminService.getAllCasualties());
		

		System.out.println("\n========== ADD MEDIA TO CASUALITY ==========");
		Media media1 = ctx.getBean(Media.class);
		media1.setCasualty(casualty1);
		media1.setCategory(app.core.entities.Media.Category.BABY);
		media1.setTitle("In the Tent");
		media1.setDescription("Tent for 3 people: Father, Mom and the little baby");
		media1.setMediaTakenDate(LocalDate.of(2023, 1, 1));
		media1.setMediaUploadedDate(LocalDate.of(2023, 12, 31));
		media1.setAge(1);
		media1.setImage(
				"https://drive.google.com/file/d/1yoJGfztPQi65SO5CxfjK6b9KXyoWdnbV/view?usp=sharing");
//		casualty1.addMedia(media1);
//		System.out.println(media1);
		familyService.addMediaToFamily(1, media1);

		Media media2 = ctx.getBean(Media.class);
		media2.setCasualty(casualty1);
		media2.setCategory(Category.KID);
		media2.setTitle("Sandwich");
		media2.setDescription("eating his sandwich in kinder Garden");
		media2.setMediaTakenDate(LocalDate.of(2023, 1, 1));
		media2.setMediaUploadedDate(LocalDate.of(2023, 12, 31));
		media2.setAge(5);
		media2.setImage("https://drive.google.com/file/d/1h3IPdtK9TG4cxjBj9KOHnRkmqSbPejXY/view?usp=sharing");
		casualty1.addMedia(media2);		
//		System.out.println(media2);
		familyService.addMediaToFamily(1, media2);

		Media media3 = ctx.getBean(Media.class);
		media3.setCasualty(casualty2);
		media3.setCategory(Category.HOLIDAYS);
		media3.setTitle("Purim");
		media3.setDescription("Purim costume in 2003");
		media3.setMediaTakenDate(LocalDate.of(2023, 1, 1));
		media3.setMediaUploadedDate(LocalDate.of(2023, 12, 10));
		media3.setAge(9);
		media3.setImage("https://drive.google.com/file/d/1cDLLvOSmVJasJydLuuJmI43mD9HJldsp/view?usp=sharing");
		casualty2.addMedia(media3);
		System.out.println("media3 " + media3);
		familyService.addMediaToFamily(1, media3);
		
		System.out.println(casualty1.getMedias());

		System.out.println("\n==========ADMIN ADD FRIENDS ==========");
		Friend friend1 = ctx.getBean(Friend.class);
		friend1.setTz("111222333");
		friend1.setFirstName("Dina");
		friend1.setLastName("Levi");
		friend1.setEmail("dina@gmail.com");
		friend1.setPassword("dina");
		adminService.addFriend(friend1);

		Friend friend2 = ctx.getBean(Friend.class);
		friend2.setTz("211222333");
		friend2.setFirstName("Dan");
		friend2.setLastName("Ramon");
		friend2.setEmail("ramon@mail");
		friend2.setPassword("ramo");
		adminService.addFriend(friend2);

		Friend friend3 = ctx.getBean(Friend.class);
		friend3.setTz("311222333");
		friend3.setFirstName("Richard");
		friend3.setLastName("Badash");
		friend3.setEmail("richard@gmail.com");
		friend3.setPassword("rich");
		adminService.addFriend(friend3);

		System.out.println("\nRegistred Friends: ");
		System.out.println(adminService.getAllFriends());

	}
}