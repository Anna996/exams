package food_and_dragon;

import java.io.Serializable;

public class Food implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 973603985780690163L;
	private String name;
	private Taste taste;
	private Macronutrients macronutrients;

	public Food(String name, Taste taste, Macronutrients macronutrients) throws NonCapatilizedException {
		setName(name);
		this.taste = taste;
		this.macronutrients = macronutrients;
	}

	public boolean isDesert() {
		return taste == Taste.SWEET && macronutrients == Macronutrients.CARBOHYDRATE;
	}

	private void setName(String name) throws NonCapatilizedException {
		if (!Character.isUpperCase(name.charAt(0))) {
			throw new NonCapatilizedException("The name must start with a capital letter.", name);
		}
		this.name = name;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", taste=" + taste + ", macronutrients=" + macronutrients + "]";
	}
}
