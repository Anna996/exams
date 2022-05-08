package food_and_dragon;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DragonTest {

	@Test
	@DisplayName("check if setBirthDate throws a TooYoungException if the birth date is after 8/8/888")
	void checkSetBirthDate() {
		assertThrows(TooYoungException.class, ()-> new Dragon("Dragon", LocalDate.of(900, 5, 12), 8));
		assertThrows(TooYoungException.class, ()-> new Dragon("Dragon", LocalDate.of(888, 8, 9), 8));
		assertDoesNotThrow(() -> new Dragon("Dragon", LocalDate.of(500, 5, 12), 8));
		assertDoesNotThrow(() -> new Dragon("Dragon", LocalDate.of(888, 8, 8), 8));
	}
}
