package Construction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class ConstructionsFloor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the total number of floors in the building: ");
		int totalFloors = scanner.nextInt();
		
		TreeMap<Integer, List<Integer>> floorMap = new TreeMap<>(Collections.reverseOrder());
		for (int day = 1; day <= totalFloors; day++) {
			System.out.print("Enter the floor size given on day" + day+ ": ");
			int floorSize = scanner.nextInt();
			
			if (!floorMap.containsKey(floorSize)) {
				floorMap.put(floorSize, new ArrayList<>());
		  }
			floorMap.get(floorSize).add(day);
			
			List<Integer> assembledFloors = new ArrayList<>();
			
			for(Map.Entry<Integer, List<Integer>> entry : floorMap.entrySet()) {
				if(entry.getKey() == day) {
					assembledFloors.addAll(entry.getValue());
				}
				else if(entry.getKey() < day) {
					break;
				}
			}
			
			System.out.print("Day: " + day);
			if(!assembledFloors.isEmpty()) {
				for (int assembledFloor : assembledFloors) {
                    System.out.print(" " + assembledFloor);
                }
			}
			
			System.out.println();
	
		}
		scanner.close();

	}

}
