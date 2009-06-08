package org.somox.analyzer;

import java.util.Enumeration;
import java.util.Vector;

public class ModelAnalyzerTabGroupBlackboard {

	static int idCounter = 0;
	private int myId = 0;

	public ModelAnalyzerTabGroupBlackboard() {
		idCounter++;
		myId = idCounter;
	}

	public int getId() {
		return myId;
	}

	private String somoxAnalyzerInputFile = null;

	public String getSomoxAnalyzerInputFile() {
		return somoxAnalyzerInputFile;
	}

	public void setSomoxAnalyzerInputFile(String somoxAnalyzerInputFile) {
		this.somoxAnalyzerInputFile = somoxAnalyzerInputFile;
		fireBlackboardChanged();
	}

	//
	// Event handling
	//
	private transient Vector<BlackboardListener> blackboardListeners;

	/** Register a listener for Blackboard events */
	synchronized public void addBlackboardListener(BlackboardListener listener) {
		if (blackboardListeners== null) {
			blackboardListeners= new Vector<BlackboardListener>();
		}
		blackboardListeners.addElement(listener);
	}

	synchronized public void removeBlackboardListener(BlackboardListener listener) {
		if (blackboardListeners == null) {
			blackboardListeners= new Vector<BlackboardListener>();
		}
		blackboardListeners.removeElement(listener);
	}

	/** Fire to all registered listeners */
	@SuppressWarnings("unchecked")
	public void fireBlackboardChanged() {
		// If we have no listeners, do nothing.
		if ((blackboardListeners!= null) && !blackboardListeners.isEmpty()) {
			// Make a copy of the listener list in case anyone adds or removes
			// listeners.
			Vector<BlackboardListener> targets;
			synchronized (blackboardListeners) {
				targets = (Vector<BlackboardListener>) blackboardListeners.clone();
			}
			// Walk through the listener list and call the listener method in
			// each.
			Enumeration<BlackboardListener> e = targets.elements();
			while (e.hasMoreElements()) {
				BlackboardListener l = (BlackboardListener) e.nextElement();
				l.blackboardChanged();
			}
		}
	}

}
