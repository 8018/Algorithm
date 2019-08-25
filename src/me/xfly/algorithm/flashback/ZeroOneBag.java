package me.xfly.algorithm.flashback;

public class ZeroOneBag {
	int maxValue = Integer.MIN_VALUE;
	int capacity = 100;
	static int[] products = { 10, 50, 39, 66, 88, 190, 34, 8, 55, 29, 1, 68 };

	public static void main(String[] args) {
		int alreadyAdd = 0;
		new ZeroOneBag().addToBag(alreadyAdd, products, 0);

	}

	void addToBag(int alreadyAdded, int[] products, int index) {
		if (index == products.length || alreadyAdded == capacity) {

			if (alreadyAdded > maxValue) {
				maxValue = alreadyAdded;
				System.out.println(maxValue);
			}
			System.out.println(alreadyAdded);
			return;
		}

		/*
		 * addToBag(alreadyAdded, products, index+1);
		 * 
		 * if (alreadyAdded + products[index] <= capacity) { alreadyAdded +=
		 * products[index]; addToBag(alreadyAdded, products, index + 1); }
		 */

		for (int i = index; i < products.length; i++) {
			if (alreadyAdded + products[index] <= capacity) {
				alreadyAdded += products[index];
				addToBag(alreadyAdded, products, index + 1);
			}
		}
	}
}
