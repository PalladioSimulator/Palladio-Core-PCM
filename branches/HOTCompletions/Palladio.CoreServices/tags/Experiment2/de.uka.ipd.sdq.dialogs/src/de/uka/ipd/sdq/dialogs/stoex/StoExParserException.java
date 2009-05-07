package de.uka.ipd.sdq.dialogs.stoex;

import java.util.ArrayList;

import org.antlr.runtime.RecognitionException;

import de.uka.ipd.sdq.errorhandling.IIssue;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.ErrorEntry;

public class StoExParserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7815748573923222680L;
	
	private ArrayList<IIssue> errorList;

	public StoExParserException(ArrayList<IIssue> errorList2) {
		this.errorList = errorList2;
	}

	public ArrayList<IIssue> getIssuesList() {
		return errorList;
	}

}
