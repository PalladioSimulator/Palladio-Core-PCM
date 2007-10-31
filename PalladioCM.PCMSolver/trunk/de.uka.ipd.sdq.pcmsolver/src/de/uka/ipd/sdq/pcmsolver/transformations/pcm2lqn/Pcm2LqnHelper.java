package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

public class Pcm2LqnHelper {

	public static String fixGUID(String id) {
		return id.replaceAll("-", "x");
	}
	
}
