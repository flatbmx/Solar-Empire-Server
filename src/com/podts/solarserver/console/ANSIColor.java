package com.podts.solarserver.console;

public enum ANSIColor {
	
	/**
	* Resets all styles to default.
	*/
	RESET(0),
	/**
	* Sets the style to bold.
	*/
	BOLD(1),
	/**
	* Sets the style to italic.
	*/
	ITALICS(3),
	/**
	* Sets the style to underline.
	*/
	UNDERLINE(4),
	/**
	* Sets the color to black.
	*/
	BLACK(30),
	/**
	* Sets the color to red.
	*/
	RED(31),
	/**
	* Sets the color to green.
	*/
	GREEN(32),
	/**
	* Sets the color to yellow.
	*/
	YELLOW(33),
	/**
	* Sets the color to blue.
	*/
	BLUE(34),
	/**
	* Sets the color to purple.
	*/
	PURPLE(35),
	/**
	* Sets the color to cyan.
	*/
	CYAN(36),
	/**
	* Sets the color to white.
	*/
	WHITE(37),
	/**
	* Sets the background color to black.
	*/
	BACKGROUND_BLACK(40),
	/**
	* Sets the background color to red.
	*/
	BACKGROUND_RED(41),
	/**
	* Sets the background color to green.
	*/
	BACKGROUND_GREEN(42),
	/**
	* Sets the background color to yellow.
	*/
	BACKGROUND_YELLOW(43),
	/**
	* Sets the background color to blue.
	*/
	BACKGROUND_BLUE(44),
	/**
	* Sets the background color to purple.
	*/
	BACKGROUND_PURPLE(45),
	/**
	* Sets the background color to cyan.
	*/
	BACKGROUND_CYAN(46),
	/**
	* Sets the background color to white.
	*/
	BACKGROUND_WHITE(47);
	
	private int id;
	
	@Override
		public String toString() {
		return "\u001B[" + id + "m";
	}
	
	private ANSIColor(int s) {
		id = s;
	}
	
}
