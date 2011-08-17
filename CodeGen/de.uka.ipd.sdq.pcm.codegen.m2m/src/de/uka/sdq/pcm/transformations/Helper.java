package de.uka.sdq.pcm.transformations;

public class Helper {
	public static String removeAllSpecialChars(String s) {
		return s.replace('\n',' ').replace('\t', ' ').replace('\r', ' ');
	}
}
