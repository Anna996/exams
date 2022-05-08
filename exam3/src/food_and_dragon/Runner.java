package food_and_dragon;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Random;

public class Runner {
	
	private static String fileName = "src/food_and_dragon/randomObjects.dat";
	private static int size = 2;
	private static boolean isFirst = true;

	public static void main(String[] args) throws NonCapatilizedException {
		
		Food charry = new Food("Charry", Taste.SWEET, Macronutrients.CARBOHYDRATE);
		Food sushi = new Food("Sushi", Taste.SALTY, Macronutrients.PROTEIN);

		Dragon benni = new Dragon("Benni", LocalDate.of(500, 5, 12), 8);
		Dragon or = new Dragon("Or", LocalDate.of(700, 1, 29), 3);

		for (int i = 0; i < size; i++) {
			writeRandomObject(new Object[] { charry, sushi, benni, or });
		}
		
		readObjects();
	}

	
	public static void writeRandomObject(Object[] objectArray) {
		Random random = new Random();
		int index = random.nextInt(objectArray.length);
		Object[] existedObjects;
		
		if(isFirst) {
			existedObjects = new Object[size];
			isFirst = false;
		}else {
			existedObjects = getExistedObjects();
		}
		
		try (FileOutputStream file = new FileOutputStream(fileName);
				ObjectOutputStream output = new ObjectOutputStream(file)) {
			
			for(Object obj : existedObjects) {
				if(obj != null) {
					output.writeObject(obj);
				}
			}
			
			output.writeObject(objectArray[index]);

		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	private static Object[] getExistedObjects() {
		Object[] existedObjects = new Object[size];
		int idx = 0;
		
		try (FileInputStream file = new FileInputStream(fileName);
				ObjectInputStream input = new ObjectInputStream(file)) {

			boolean hasObject = true;
			do {
				try {
					existedObjects[idx++] = input.readObject();
				} catch (EOFException e) {
					hasObject = false;
				}
			} while (hasObject);

		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return existedObjects;
	}
	
	public static void readObjects() {
		Object[] existedObjects = getExistedObjects();
		
		for(Object obj : existedObjects) {
			if(obj != null) {
				System.out.println(obj);
			}
		}
		
	}
}
