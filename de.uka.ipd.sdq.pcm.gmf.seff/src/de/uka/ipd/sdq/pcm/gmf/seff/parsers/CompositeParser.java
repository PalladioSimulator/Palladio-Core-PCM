/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.parsers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;

/**
 * The Class CompositeParser.
 *
 * @generated
 */
public class CompositeParser implements IParser {

    /** The reader. @generated */
    private final IParser reader;

    /** The writer. @generated */
    private final IParser writer;

    /**
     * Instantiates a new composite parser.
     *
     * @param reader the reader
     * @param writer the writer
     * @generated
     */
    public CompositeParser(IParser reader, IParser writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Checks if is affecting event.
     *
     * @param event the event
     * @param flags the flags
     * @return true, if is affecting event
     * @generated
     */
    public boolean isAffectingEvent(Object event, int flags) {
        return reader.isAffectingEvent(event, flags);
    }

    /**
     * Gets the prints the string.
     *
     * @param adapter the adapter
     * @param flags the flags
     * @return the prints the string
     * @generated
     */
    public String getPrintString(IAdaptable adapter, int flags) {
        return reader.getPrintString(adapter, flags);
    }

    /**
     * Gets the edits the string.
     *
     * @param adapter the adapter
     * @param flags the flags
     * @return the edits the string
     * @generated
     */
    public String getEditString(IAdaptable adapter, int flags) {
        return reader.getEditString(adapter, flags);
    }

    /**
     * Checks if is valid edit string.
     *
     * @param adapter the adapter
     * @param editString the edit string
     * @return the i parser edit status
     * @generated
     */
    public IParserEditStatus isValidEditString(IAdaptable adapter, String editString) {
        return writer.isValidEditString(adapter, editString);
    }

    /**
     * Gets the parses the command.
     *
     * @param adapter the adapter
     * @param newString the new string
     * @param flags the flags
     * @return the parses the command
     * @generated
     */
    public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
        return writer.getParseCommand(adapter, newString, flags);
    }

    /**
     * Gets the completion processor.
     *
     * @param adapter the adapter
     * @return the completion processor
     * @generated
     */
    public IContentAssistProcessor getCompletionProcessor(IAdaptable adapter) {
        return writer.getCompletionProcessor(adapter);
    }
}
