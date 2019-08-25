package me.xfly.algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

public class CashBack {
	public static void main(String[] args) {
		int[] moneys = {100,50,20,10,5,2,1};
		int cashBack = 99;
		
		List<Integer> backResults = new ArrayList<Integer>();
		
		cashBack(backResults, moneys, cashBack);
		
		for (int i = 0; i < backResults.size(); i++) {
			System.out.println(backResults.get(i));
		}
	}
	
	static void cashBack(List<Integer> backs,int[] moneys,int cashBack) {
		for (int i = 0; i < moneys.length; i++) {
			while (cashBack/moneys[i] >= 1) {
				System.out.println(cashBack/moneys[i]);
				backs.add(moneys[i]);
				cashBack = cashBack - moneys[i];
				if (cashBack == 0) {
					return;
				}
			}
		}
	}
	
	
}
