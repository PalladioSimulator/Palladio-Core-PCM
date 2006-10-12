package de.uka.ipd.sdq.fixit.simplify;

import de.uka.ipd.sdq.analysis.model.Acquire;
import de.uka.ipd.sdq.analysis.model.Alternative;
import de.uka.ipd.sdq.analysis.model.Loop;
import de.uka.ipd.sdq.analysis.model.Parallel;
import de.uka.ipd.sdq.analysis.model.Release;
import de.uka.ipd.sdq.analysis.model.Sequence;
import de.uka.ipd.sdq.analysis.model.Sleep;
import de.uka.ipd.sdq.analysis.model.Terminal;
import de.uka.ipd.sdq.fixit.simplify.exceptions.InvalidStackStateException;
import de.uka.ipd.sdq.fixit.simplify.exceptions.OperationExpectedException;

public interface RegExProcessor {

	public abstract void processAcquire(Acquire acquire);

	public abstract void processRelease(Release release);

	public abstract void processSleep(Sleep sleep) throws OperationExpectedException;

	public abstract void processTerminal(Terminal terminal) throws OperationExpectedException;

	public abstract void processSequence(Sequence sequence) throws OperationExpectedException, InvalidStackStateException;

	public abstract void processAlternative(Alternative alternative) throws OperationExpectedException, InvalidStackStateException;

	public abstract void processLoop(Loop loop) throws OperationExpectedException, InvalidStackStateException;

	public abstract void processParallel(Parallel parallel) throws OperationExpectedException, InvalidStackStateException;

	public abstract void openBrace() throws OperationExpectedException;

	public abstract void closeBrace() throws OperationExpectedException, InvalidStackStateException;

}