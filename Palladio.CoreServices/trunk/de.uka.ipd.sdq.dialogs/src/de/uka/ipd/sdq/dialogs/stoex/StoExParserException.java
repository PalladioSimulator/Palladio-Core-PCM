package de.uka.ipd.sdq.dialogs.stoex;

import java.util.ArrayList;

import org.antlr.runtime.RecognitionException;

import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.ErrorEntry;

public class StoExParserException extends Exception {

	private ArrayList<ErrorEntry> errorList;

	public StoExParserException(ArrayList<ErrorEntry> errorList2) {
		this.errorList = errorList2;
	}

	public ArrayList<ErrorEntry> getErrorList() {
		return errorList;
	}

}
