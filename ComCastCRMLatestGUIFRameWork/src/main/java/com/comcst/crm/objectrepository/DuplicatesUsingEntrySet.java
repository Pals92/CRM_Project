package com.comcst.crm.objectrepository;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class DuplicatesUsingEntrySet {
	public static void main(String[] args) {
		String s = "baa baa black sheep sheep";
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		
		String str[] = s.split(" ");
		
		for(int i=0; i<str.length; i++) {
			String s1 = str[i];
			if(map.containsKey(s1))
				map.put(s1, map.get(s1)+1);
			else
				map.put(s1, 1);
		}
		System.out.println("map is "+map);
		
		for(Entry<String, Integer> ref:map.entrySet()) {
		if(ref.getValue()>0)
			System.out.println(ref.getKey()+"===>"+ref.getValue());
		}
	}

}
