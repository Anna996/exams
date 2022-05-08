package food_and_dragon;

import java.io.Serializable;
import java.time.LocalDate;

public class Dragon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3709234887033541105L;
	private String name;
	private LocalDate birthDate;
	private int flameIntensity;
	
	private final int MIN_FLAME_INTENSITY = 0;
	private final int MAX_FLAME_INTENSITY = 10;
	private final LocalDate MIN_BIRTH_DATE = LocalDate.of(888, 8, 8);
	
	
	public Dragon(String name, LocalDate birthDate, int flameIntensity) {
		this.name = name;
		setBirthDate(birthDate);
		setFlameIntensity(flameIntensity);
	}
	
	private void setFlameIntensity(int flameIntensity) {
		this.flameIntensity = flameIntensity >= MIN_FLAME_INTENSITY && flameIntensity <= MAX_FLAME_INTENSITY ? flameIntensity : MAX_FLAME_INTENSITY;
	}
	
	private void setBirthDate(LocalDate birthDate) {
		if(birthDate.isAfter(MIN_BIRTH_DATE)) {
			throw new TooYoungException("You must be older than " + MIN_BIRTH_DATE,birthDate);
		}
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Dragon [name=" + name + ", birthDate=" + birthDate + ", flameIntensity=" + flameIntensity + "]";
	}
}
