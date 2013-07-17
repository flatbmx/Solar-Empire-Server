package com.podts.solarserver;

import java.text.NumberFormat;
import java.util.Random;

public class Util {
	
	private static Random rand = new Random();
	
	public static Random getRandom() {
		return rand;
	}
	
	public static boolean between(Number n, Number min, Number max) {
		return n.doubleValue() <= min.doubleValue() && n.doubleValue() >= max.doubleValue();
	}
	
	public static String titleCase(String in) {
		String s = in.toLowerCase();
		StringBuilder titlecase = new StringBuilder();
		boolean nextTitleCase = true;
		for (char c : s.toCharArray()) {
			if (Character.isSpaceChar(c)) {
				nextTitleCase = true;
			} else if (nextTitleCase) {
				c = Character.toTitleCase(c);
				nextTitleCase = false;
			}
			titlecase.append(c);
		}
		return titlecase.toString();
	}
	
	public static String formatNumber(Number number) {
		return NumberFormat.getInstance().format(number);
	}
	
}
