package me.xfly.algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZoneSelect {
	public static void main(String[] args) {
		List<Zone> zones = new ArrayList<Zone>();
		
		
		zones.add(new Zone(1, 5));
		zones.add(new Zone(2, 4));
		zones.add(new Zone(3, 5));
		zones.add(new Zone(5, 9));
		zones.add(new Zone(6, 8));
		zones.add(new Zone(8, 10));
		zones.add(new Zone(8, 15));
		zones.add(new Zone(10, 13));
		zones.add(new Zone(13, 14));
		
		ArrayList<Zone> results = selectZones(zones, new Zone(1, 15));
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i).toString());
		}
		
	}
	
	static ArrayList<Zone> selectZones(List<Zone> zones,Zone section) {
		ArrayList<Zone> results = new ArrayList<Zone>();
		
		Collections.sort(zones);
		
		
		
		while (section.left < section.right) {
			Zone zone = getCorrectZone(zones, section.left,section.right);
			if (zone == null) {
				break;
			}
			
			results.add(zone);
			section.left = zone.right;
		}
		
		return results;
	}
	
	static Zone getCorrectZone(List<Zone> zones,int left,int right) {
		
		Zone zone = null;
		for (int i = 0; i < zones.size(); i++) {
			if (zone == null) {
				if (zones.get(i).left >= left & zones.get(i).right < right) {
					zone = zones.get(i);
				}
			}else {
				if (zones.get(i).left >= zone.left & zones.get(i).right < zone.right) {
					zone = zones.get(i);
				}
			}
		}
		return zone;
		
	}
}

class Zone implements Comparable<Zone>{
	int left;
	int right;
	
	public Zone(int left,int right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(Zone o) {
		
		if (this.left > o.left) {
			return 1;
		}else if (this.left < o.left) {
			return -1;
		}else {
			return this.right > o.right ? 1:-1;	
		}
		
		
	}
	
	@Override
	public String toString() {
		return "left =="+left+"  right=="+right;
	}
}
