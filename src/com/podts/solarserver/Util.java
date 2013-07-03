package com.podts.solarserver;

import java.util.Random;

public class Util {
	
	private static Random rand = new Random();
	
	public static Random getRandom() {
		return rand;
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
	
	public static float getAngle(float x1, float y1, float x2, float y2) {
	    float angle = (float) Math.toDegrees(Math.atan2(x2 - x1, y2 - y1));

	    if(angle < 0){
	        angle += 360;
	    }

	    return angle;
	}
	
	public static float getAngleRads(float x1, float y1, float x2, float y2) {
	    float angle = (float) Math.atan2(x2 - x1, y2 - y1);

	    return angle;
	}
	
}
