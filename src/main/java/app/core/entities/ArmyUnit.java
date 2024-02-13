package app.core.entities;

public enum ArmyUnit {
	  // חילות היבשה
	  INFANTRY("חיל רגלים"),
	  GOLANI("גולני"),
      PARATROOPERS("צנחנים"),
      NAHAL("נח`ל"),
      GIVATI("גבעתי"),
	  ARMORED("חיל השריון"),
	  ARTILLERY("חיל התותחנים"),
	  ENGINEERING("חיל ההנדסה"),
	  INTELLIGENCE("חיל המודיעין"),
	  SIGNALS("חיל הקשר"),
	  C4I("חיל התקשוב"),
	  MP("משטרה צבאית"),
	  HOME_FRONT_COMMAND("פיקוד העורף"),

	  // חיל האוויר
	  AIR_FORCE("חיל האוויר"),

	  // חיל הים
	  NAVY("חיל הים"),

	  // יחידות מיוחדות
	  GENERAL_STAFF("אגף המטה הכללי"),
	  SPECIAL_FORCES("כוחות מיוחדים"),

	  // Other
	  UNDEFINED("לא מוגדר");
	
	private final String hebrewName;

    ArmyUnit(String hebrewName) {
        this.hebrewName = hebrewName;
    }

    public String getHebrewName() {
        return hebrewName;
    }

	}
