package de.uka.ipd.sdq.simucomframework;

import java.util.Collection;

/**
 * TODO Comment this class!
 * TODO Maybe an interface would be better?
 * 
 * @author Philipp Merkle
 * 
 */
public abstract class AIndependenceVerifier<T> {

	public AIndependenceVerifier() {
		super();
	}

	public boolean verifyIndependence(Collection<T> data) {
		return verifyIndependence(data, 1);
	}
	
	abstract boolean verifyIndependence(Collection<T> data, int lag);

}
