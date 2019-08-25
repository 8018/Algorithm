package me.xfly.algorithm.flashback;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ZeroOneBag {
	int maxValue = Integer.MIN_VALUE;
	int capacity = 100;
	static int[] products = { 10, 50, 39, 66, 88, 190, 34, 8, 55, 29, 1, 68 };

	public static void main(String[] args) {
		int alreadyAdd = 0;
		// 背包 用来存添加进去的结果

		HashMap<Integer, Integer> bag = new HashMap<Integer, Integer>();

		new ZeroOneBag().addToBag(alreadyAdd, products, 0, bag);

	}

	void addToBag(int alreadyAdded, int[] products, int index, HashMap<Integer, Integer> bag) {
		if (index == products.length || alreadyAdded == capacity) {

			if (alreadyAdded >= maxValue) {
				maxValue = alreadyAdded;
			}

			if (alreadyAdded == capacity) {
				printBag(bag);
			}

			return;
		}

		/*
		 * addToBag(alreadyAdded, products, index + 1,bag);
		 * 
		 * if (alreadyAdded + products[index] <= capacity) { alreadyAdded +=
		 * products[index]; bag.put(index, products[index]); addToBag(alreadyAdded,
		 * products, index + 1,bag); }
		 */

		// 这种写法不行，出栈的时候新栈顶还会保留原来的数，并继续添加新的数进去

		for (int i = index; i < products.length; i++) {
			int temp = alreadyAdded + products[i];
			boolean ss = alreadyAdded + products[i] <= capacity;
			if (alreadyAdded + products[i] <= capacity) {
				alreadyAdded += products[i];
				bag.put(i, products[i]);
				addToBag(alreadyAdded, products, i + 1, bag);
				alreadyAdded -= products[i];
				bag.remove(i);
			}
		}

	}

	void printBag(HashMap<Integer, Integer> bag) {
		Iterator<Entry<Integer, Integer>> entries = bag.entrySet().iterator();
		while (entries.hasNext()) {
			Entry<Integer, Integer> entry = entries.next();
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			System.out.print(key + ":" + value + "   ");
		}

		System.out.println();
	}
}
