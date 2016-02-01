package ua.goit.andre.lab9;

public class Caesar {

	private static final int NUM_LETTERS = 90;
	private static final int MIN_ASCII = 33;
	private static final int MAX_ASCII = 122;
	
	private static final int MIN_RUS_ASCII = 1025;
	private static final int MAX_RUS_ASCII = 1114;
	

	
	public static char encodeChar(char c, int shift) {
		
		int code=(int) c;
		if ((code >= MIN_ASCII) && (code <= MAX_ASCII)) {
			code = (code+shift);
			if (code > MAX_ASCII) code=code-NUM_LETTERS;
			if (code < MIN_ASCII) code=code+NUM_LETTERS;
		}

		if ((code >= MIN_RUS_ASCII) && (code <= MAX_RUS_ASCII)) {
			code = (code+shift);
			if (code > MAX_RUS_ASCII) code=code-NUM_LETTERS;
			if (code < MIN_RUS_ASCII) code=code+NUM_LETTERS;
		}

		return (char) code;
	}
	
	public static String encodeDecode (String sourceString, int shift) {
		if ((shift<-NUM_LETTERS) || (shift>NUM_LETTERS)) throw new IllegalArgumentException("Shift must be between 0 and " + NUM_LETTERS); 
		char[] ch = sourceString.toCharArray();
		for (int i=0; i < ch.length; i++) {
			ch[i] = encodeChar(ch[i], shift);
		}
		return String.valueOf(ch);
	}
	
	public static String encode (String sourceString, int shift) {
		return encodeDecode (sourceString, shift);
	}

	public static String decode (String sourceString, int shift) {
		return encodeDecode (sourceString, -shift);
	}

}
