package food_and_dragon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class FoodTest {

	@Test
	@DisplayName("check if isDesert returns true if food is sweet and carbohydrate")
	void checkIsDesert() throws NonCapatilizedException {
		Food desert =  new Food("Food", Taste.SWEET, Macronutrients.CARBOHYDRATE);
		assertTrue(desert.isDesert());
		
		Food notDesert1 =  new Food("Food", Taste.SOUR, Macronutrients.CARBOHYDRATE);
		assertFalse(notDesert1.isDesert());
		
		Food notDesert2 =  new Food("Food", Taste.SWEET, Macronutrients.PROTEIN);
		assertFalse(notDesert2.isDesert());
		
		Food notDesert3 =  new Food("Food", Taste.BITTER, Macronutrients.FAT);
		assertFalse(notDesert3.isDesert());
	}
	
	@Test
	@DisplayName("check if setName throws a NonCapatilizedException if the name doesn’t start with a capital letter")
	void checkSetName() {
		assertThrows(NonCapatilizedException.class, () -> new Food("food", Taste.SWEET, Macronutrients.CARBOHYDRATE));
		assertDoesNotThrow(() -> new Food("Food", Taste.SWEET, Macronutrients.CARBOHYDRATE));
	}
}
