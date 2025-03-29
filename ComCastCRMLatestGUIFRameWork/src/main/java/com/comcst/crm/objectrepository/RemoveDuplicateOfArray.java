package com.comcst.crm.objectrepository;

import java.util.LinkedHashMap;
import java.util.Set;

public class RemoveDuplicateOfArray {
	public static void main(String[] args) {
		String [] s = {"cat", "mat", "bat","rat","mat", "cot"};
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		for(int i=0; i<s.length;i++) {
			//			System.out.println(s[i]);
			String s1 = s[i];
			if(map.containsKey(s[i])) {
				map.put(s1, map.get(s1)+1);
			}
			else {
				map.put(s1, 1);
			}
		}
		System.out.println(map.keySet());
		Set<String> li = map.keySet();
		System.out.println(li);
	}
}
