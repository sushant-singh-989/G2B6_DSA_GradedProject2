package com.gl.javafsd.dsaAssignment.building;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class SkyScraper {
	
	public void ConstructionSite() {

		int noOfFloors;
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> distinctFloor = new LinkedList<Integer>();
		LinkedList<Integer> floorSize = new LinkedList<Integer>();
		LinkedList<Integer> floorSizeTemp = new LinkedList<Integer>();

		System.out.println("Enter the total  no of Floors in the Building");
		noOfFloors = sc.nextInt();
		for (int i = 0; i < noOfFloors; i++) {
			System.out.println("enter the floor size given on day : " + (i + 1));
			int value = sc.nextInt();
			floorSize.add(i, value);

		}
		int floorValue;
		floorValue = noOfFloors;
		floorSizeTemp.addAll(floorSize);
		for (int j = 0; j < noOfFloors; j++) {
			System.out.println("Day:" + (j + 1));
			floorSizeTemp.remove((Integer) floorSize.get(j));

			if (floorValue == (Integer) floorSize.get(j)) {
				if (!distinctFloor.contains(floorValue) && floorValue != (Integer) floorSize.get(j)) {
					System.out.println();
					distinctFloor.add((Integer) floorSize.get(j));
				} else {
					LinkedList<Integer> distinctFloor1 = selectRequiredSize(distinctFloor, floorValue, floorSizeTemp);

					System.out.print(floorSize.get(j));
					floorValue = floorValue - 1;
					if (!distinctFloor1.isEmpty()) {
						Collections.sort(distinctFloor1, Collections.reverseOrder());
						for (int l = 0; l < distinctFloor1.size(); l++) {
							System.out.print(" " + distinctFloor1.get(l));
							floorValue = floorValue - 1;
						}
					}
					System.out.println();

				}
			} else {
				System.out.println();
				distinctFloor.add((Integer) floorSize.get(j));
			}

		}
	}

	LinkedList<Integer> selectRequiredSize(LinkedList<Integer> flrSize, int currentSize, LinkedList<Integer> remainingFloorSize) {
		LinkedList<Integer> requiredSize = new LinkedList<Integer>();
		LinkedList<Integer> tempSize = new LinkedList<Integer>();
		LinkedList<Integer> tempValue = new LinkedList<Integer>();
		int value, minSize = 0;

		tempValue.addAll(remainingFloorSize);
		if (!remainingFloorSize.isEmpty()) {
			Collections.sort(tempValue, Collections.reverseOrder());
			minSize = (Integer) tempValue.getFirst();
		}
		tempSize.addAll(flrSize);
		for (int k = 0; k < tempSize.size(); k++) {
			value = (Integer) tempSize.get(k);
			if (value <= currentSize && value >= minSize) {
				requiredSize.add(value);
			}
		}
		flrSize.removeAll(requiredSize);
		return requiredSize;
	
}
}
