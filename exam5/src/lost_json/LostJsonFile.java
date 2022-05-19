package lost_json;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class LostJsonFile {

	private static final String FILE_NAME = "myFiles\\lostFile.json";

	public static List<House> parseFromLostJson() {
		File file = new File(FILE_NAME);

		try (FileReader reader = new FileReader(file);) {

			JsonReader jsonReader = new JsonReader(reader);
			Gson gson = new Gson();
			Type listType = new TypeToken<List<House>>() {}.getType();
			List<House> houses = gson.fromJson(jsonReader, listType);
			return houses;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
