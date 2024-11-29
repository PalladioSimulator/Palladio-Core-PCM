package org.palladiosimulator.pcm.stochasticexpressions.parser;

import org.antlr.runtime.RecognitionException;

import de.uka.ipd.sdq.errorhandling.core.IIssue;
import de.uka.ipd.sdq.errorhandling.core.SeverityEnum;

public class ErrorEntry implements IIssue {
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

    public String getMessage() {
        return errorText;
    }

    public SeverityEnum getSeverity() {
        return SeverityEnum.ERROR;
    }
}
