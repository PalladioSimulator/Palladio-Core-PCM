package de.fzi.stanja.core.model;

import java.util.ArrayList;

public class OutputProvider {
	// STATIC ATTRIBUTES
	static private OutputProvider instance;

	// STATIC ATTRIBUTES GETTER AND SETTER
	public static OutputProvider getInstance() {
		return instance;
	}

	// STATIC FUNCTIONS

	// CONSTRUCTORS
	private OutputProvider() {
		if (instance == null) {
			// initialize the Attributes
			this.outputs = new OutputList();
		}
	}

// OBJECT ATTRIBUTES
	private ArrayList<AbstractOutput> outputs;

	// OBJECT ATTRIBUTES GETTER AND SETTER
	public ArrayList<AbstractOutput>  getOutputs() {
		return this.outputs;
	}

	// OBJECT FUNCTIONS

	// INTERNAL CLASSES
	/**
	 * The AnalyserList provides the function to manipulate the List of Outputs.
	 * Output list shall contain only Objects of Type Output
	 */
	// TODO: suppress serialization
	class OutputList extends ArrayList<AbstractOutput> {
		
		public boolean add(AbstractOutput Output) {
			return super.add(Output);
		}
		
	}

	// OVERRIDE FUNCTIONS FOR SECURITY
	protected final void finalize() {
	}

	protected final OutputProvider clone() {
		return this;
	}
}
