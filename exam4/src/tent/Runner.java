package tent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Runner {

	private static List<Tent> listOfTents;
	
	private static final int NUM_PEOPLE = 10;
	private static final int MAX_TENT_INDEX = 1;
	private static final int MIN_HEIGHT = 17;
	private static final int MAX_HEIGHT = 20;
	
	public static void main(String[] args) {
		
		listOfTents = Arrays.asList(
				new Tent(10, 10, 15, 17),
				new Tent(15, 12, 20, 22),
				new Tent(9, 5, 30, 20),
				new Tent(22, 20, 25, 15),
				new Tent(5, 20, 32, 15),
				new Tent(3, 12, 5, 10),
				new Tent(10, 10, 8, 20),
				new Tent(14, 8, 13, 17),
				new Tent(30, 9, 15, 16),
				new Tent(15, 10, 15, 22)
				);
		
		handleQuestion1();
		
		printOriginalList();
		
		handleQuestion2();	
		
		handleQuestion3();
		
		handleQuestion4();
		
		handleQuestion5();
	}
	
	public static void printOriginalList() {
		System.out.println("\nOriginal list:");
		System.out.println("==============");
		listOfTents.forEach(System.out::println);
	}
	
	// Question 1 
	public static List<Tent> getCopySortedByArea(List<Tent> originalList){
		List<Tent> copyList = new ArrayList<>(originalList);
		
		return copyList
		.stream()
		.sorted((tent1,tent2) ->  (tent1.width * tent1.length) - (tent2.width * tent2.length))
		.collect(Collectors.toList());
	}
	
	public static void handleQuestion1() {
		System.out.println("Sorted By Area:");
		System.out.println("===============");
		List<Tent> copyListSortedByArea = getCopySortedByArea(listOfTents);
		copyListSortedByArea.forEach(System.out::println);
	}
	
	// Question 2 
	public static List<Tent> getSortedTentsWithNumPeople(List<Tent> listOfTents, int numPeople){
		return listOfTents
				.stream()
				.filter(tent -> tent.numPeople >= numPeople)
				.sorted((tent1,tent2) -> tent1.numPeople - tent2.numPeople)
				.collect(Collectors.toList());
	}
	
	public static void handleQuestion2() {
		System.out.println("\nTents with numPeople >= to " + NUM_PEOPLE + " , sorted by numPeople:");
		System.out.println("====================================================");
		List<Tent> list = getSortedTentsWithNumPeople(listOfTents, NUM_PEOPLE);
		list.forEach(System.out::println);
	}
	
	// Question 3	
	public static boolean isTheHighest(List<Tent> listOfTents, Tent maxTent) {
		if(!listOfTents.contains(maxTent)) {
			System.out.println("The tent is not part of the list.");
			return false;
		}
		
		List<Integer> heights = 
		listOfTents
		.stream()
		.map(tent -> tent.height)
		.collect(Collectors.toList());
		
		return  maxTent.height >= Collections.max(heights);
	}
	
	public static void handleQuestion3() {
		Tent maxTent = listOfTents.get(MAX_TENT_INDEX);
		
		System.out.println("\nIs The Highest Tent?");
		System.out.println("======================");
		System.out.println(maxTent);
		System.out.println("Answer: " + isTheHighest(listOfTents, maxTent));
	}
	
	// Question 4
	public static Map<Integer, List<Tent>> getListsByHeight(List<Tent> listOfTents){
		
		Set<Integer> setOfHeights = listOfTents
		.stream()
		.map(tent -> tent.height)
		.distinct()
		.collect(Collectors.toSet());
		
		Map<Integer, List<Tent>> map = new HashMap<>(setOfHeights.size());
		Iterator<Integer> iterator = setOfHeights.iterator();
		
		while(iterator.hasNext()) {
			int height = iterator.next();
			List<Tent> list = listOfTents
					.stream()
					.filter(tent -> tent.height == height)
					.collect(Collectors.toList());
			map.put(height, list);
		}
		
		return map;
	}
	
	public static void handleQuestion4() {
		Map<Integer, List<Tent>> map = getListsByHeight(listOfTents);
		
		System.out.println("\nMap of heights and its tents:");
		System.out.println("=============================");
		map.forEach((key,list) -> {
			System.out.println("height: "+ key);
			list.forEach(System.out::println);
			System.out.println("");
		});
	}
	
	// Question 5 
	public static List<Tent> getTentsInHeightRange(Map<Integer, List<Tent>> map, int minHeight, int maxHeight) {
		List<Tent> tentsInRangeHeight = new LinkedList<>();
        Set<Integer> heights = map.keySet();
        Iterator<Integer> iterator = heights.iterator();
        
        while(iterator.hasNext()) {
        	int height = iterator.next();
        	
        	if(height >= minHeight && height <= maxHeight) {
        		tentsInRangeHeight.addAll(map.get(height));
        	}
        }     
        
        return tentsInRangeHeight;
	}
	
	public static void handleQuestion5() {
		Map<Integer, List<Tent>> map = getListsByHeight(listOfTents);
		List<Tent> tentsInRangeHeight = getTentsInHeightRange(map, MIN_HEIGHT, MAX_HEIGHT);
		
		System.out.printf("\nTents in height range between %d and %d :\n",MIN_HEIGHT,MAX_HEIGHT);
		System.out.println("========================================");
		tentsInRangeHeight.forEach(System.out::println);
	}
}
