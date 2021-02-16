package me.xfly.algorithm.flashback;

import java.util.ArrayList;
import java.util.List;

public class Bag {
	public static void main(String[] args) {

		int[] prodects = { 11, 21, 31, 41, 51, 61, 71, 81, 91, 101, 111, 121, 131 };
		List<Integer> bag = new ArrayList<Integer>();
		int alreadyAdd = 0;
		new Bag().addProdect(100, prodects, bag, alreadyAdd, 0);
	}

	public int maxW = Integer.MIN_VALUE;
	public int keyIndex = 0;

	private void addProdect(int bagCapacity, int[] prodects, List<Integer> bag, int alreadyAdded, int index) {
		if (alreadyAdded == bagCapacity || index == prodects.length) {
			if (alreadyAdded >= maxW) {
				maxW = alreadyAdded;
				System.out.println(maxW);
			}

			if (index == prodects.length && alreadyAdded != bagCapacity) {
				if (bag.size() != 0) {
					bag.remove(bag.size() - 1);
				}
			}

			if (alreadyAdded == bagCapacity) {
				for (int i = 0; i < bag.size(); i++) {
					System.out.println(bag.get(i));
				}
				System.out.println("===============");
			}

			return;
		}

		addProdect(bagCapacity, prodects, bag, alreadyAdded, index + 1);

		if (alreadyAdded + prodects[index] <= bagCapacity) {
			alreadyAdded += prodects[index];
			bag.add(prodects[index]);
			addProdect(bagCapacity, prodects, bag, alreadyAdded, index + 1);

		}
	}

}
