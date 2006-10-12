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
import de.uka.ipd.sdq.regexp.visitor.ReflectionBasedVisitor;

public class SimplificationVisitor extends ReflectionBasedVisitor {
	RegExProcessor processor;
	
	public SimplificationVisitor(RegExProcessor processor) {
		this.processor = processor;
	}
		
	/**
	 * visits a Sequence (calls the handle methode defined in the SequenceHandler).
	 * 
	 * @param seq the Sequence instance.
	 */
	public void visitSequence(Sequence seq) {
		visit(seq.getLeftRegExp());
		try {
			processor.processSequence(seq);
		} catch (OperationExpectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidStackStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		visit(seq.getRightRegExp());
	}
	
	/**
	 * visits an Alternative (calls the handle methode defined in the AlternativeHandler).
	 * 
	 * @param alt Alternative instance to visite.
	 */
	public void visitAlternative(Alternative alt) {
		try {
			processor.openBrace();
			visit(alt.getLeftOption().getRegexp());
			processor.closeBrace();
			processor.processAlternative(alt);
			processor.openBrace();
			visit(alt.getRightOption().getRegexp());
			processor.closeBrace();
		} catch (OperationExpectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidStackStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * visits a Loop (calls the handle methode defined in the LoopHandler).
	 * 
	 * @param loop the Loop instance to visit.
	 */
	public void visitLoop(Loop loop) {
		try {
			processor.openBrace();
			visit(loop.getRegExp());
			processor.closeBrace();
			processor.processLoop(loop);
		} catch (OperationExpectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidStackStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void visitParallel(Parallel parallel){
		try {
			processor.openBrace();
			visit(parallel.getLeftTask());
			processor.closeBrace();
			processor.processParallel(parallel);
			processor.openBrace();
			visit(parallel.getRightTask());
			processor.closeBrace();
		} catch (OperationExpectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidStackStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void visitTerminal(Terminal terminal){
		try {
			processor.processTerminal(terminal);
		} catch (OperationExpectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void visitAcquire(Acquire acquire){
		processor.processAcquire(acquire);
	}
	
	public void visitRelease(Release release){
		processor.processRelease(release);
	}
	
	public void visitSleep(Sleep sleep){
		try {
			processor.processSleep(sleep);
		} catch (OperationExpectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
