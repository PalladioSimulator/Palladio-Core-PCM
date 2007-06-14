package de.uka.ipd.sdq.pcm.stochasticexpressions.parser;

import org.antlr.runtime.RecognitionException;

public class ErrorEntry {
	private RecognitionException ex = null;
	private String errorText = null;
	public ErrorEntry(RecognitionException ex, String errorText) {
		super();
		this.ex = ex;
		this.errorText = errorText;
	}
	public RecognitionException getEx() {
		return ex;
	}
	public String getErrorText() {
		return errorText;
	}
}
