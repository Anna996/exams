package lost_json;

import java.util.List;

public class Runner {

	public static void main(String[] args) {
		List<House> houses = LostJsonFile.parseFromLostJson();
		houses.forEach(System.out::println);
	}
}
