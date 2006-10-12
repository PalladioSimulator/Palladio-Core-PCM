package de.uka.ipd.sdq.fixit.simplify;

import java.util.Stack;

import de.uka.ipd.sdq.analysis.model.*;
import de.uka.ipd.sdq.fixit.simplify.exceptions.InvalidStackStateException;
import de.uka.ipd.sdq.fixit.simplify.exceptions.OperationExpectedException;

public class SimplificationProcessor implements RegExProcessor {
	
	// the top element contains the already parsed left-hand-side of the (sub-) regular expression
	// each time a new sub expression needs to be parsed (e.g. if an open braces is read) a new expression
	// is pushed to the stack.
	Stack<RegularExpression> regExStack;
	
	// if true, the next input must be an operation otherwise a symbol is expected.
	boolean operationExpected;
	
	ModelFactory factory;
	
	
	public SimplificationProcessor(){
		factory = ModelFactory.eINSTANCE;
		regExStack = new Stack<RegularExpression>();
		regExStack.push(null);
		operationExpected = false;
	}
	
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.fixit.simplify.RegExProcessor#processAcquire(de.uka.ipd.sdq.regexp.model.Acquire)
	 */
	public void processAcquire(Acquire acquire){
		System.out.print("ac("+acquire.getResource().getName()+")");
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.fixit.simplify.RegExProcessor#processRelease(de.uka.ipd.sdq.regexp.model.Release)
	 */
	public void processRelease(Release release){
		System.out.print("rel("+release.getResource().getName()+")");		
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.fixit.simplify.RegExProcessor#processSleep(de.uka.ipd.sdq.regexp.model.Sleep)
	 */
	public void processSleep(Sleep sleep) throws OperationExpectedException{
		if (operationExpected)
			throw new OperationExpectedException();
		RegularExpression topRegEx = regExStack.pop();
		if(topRegEx == null){
			topRegEx = sleep;
		} else {
			addRight(topRegEx,sleep);
		}
		regExStack.push(topRegEx);
		operationExpected = true;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.fixit.simplify.RegExProcessor#processTerminal(de.uka.ipd.sdq.regexp.model.Terminal)
	 */
	public void processTerminal(Terminal terminal) throws OperationExpectedException{
		if (operationExpected)
			throw new OperationExpectedException();
		RegularExpression topRegEx = regExStack.pop();
		if(topRegEx == null){
			topRegEx = terminal;
		} else {
			addRight(topRegEx,terminal);
		}
		regExStack.push(topRegEx);
		operationExpected = true;
	}
	
	private void addRight(RegularExpression topRegEx, RegularExpression rightExpr) {
		if (topRegEx instanceof Alternative) {
			Alternative alt = (Alternative) topRegEx;
			alt.getRightOption().setRegexp(rightExpr);
		} else if (topRegEx instanceof Sequence) {
			Sequence seq = (Sequence) topRegEx;
			seq.setRightRegExp(rightExpr);
		} else if (topRegEx instanceof Parallel) {
			Parallel par = (Parallel) topRegEx;
			par.setRightTask(rightExpr);
		} 
	}


	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.fixit.simplify.RegExProcessor#processSequence(de.uka.ipd.sdq.regexp.model.Sequence)
	 */
	public void processSequence(Sequence sequence) throws OperationExpectedException, InvalidStackStateException{
		if (!operationExpected)
			throw new OperationExpectedException();
		RegularExpression topRegEx = regExStack.pop();
		if(topRegEx == null){
			throw new InvalidStackStateException();
		} else {
			Sequence newSeqence = factory.createSequence();
			newSeqence.setLeftRegExp(topRegEx);
			topRegEx = newSeqence;
		}
		regExStack.push(topRegEx);
		operationExpected = false;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.fixit.simplify.RegExProcessor#processAlternative(de.uka.ipd.sdq.regexp.model.Alternative)
	 */
	public void processAlternative(Alternative alternative) throws OperationExpectedException, InvalidStackStateException{
		if (!operationExpected)
			throw new OperationExpectedException();
		RegularExpression topRegEx = regExStack.pop();
		if(topRegEx == null){
			throw new InvalidStackStateException();
		} else {
			Alternative newAlternative = factory.createAlternative();
			Option leftOption = factory.createOption();
			leftOption.setProbability(alternative.getLeftOption().getProbability());
			leftOption.setRegexp(topRegEx);
			newAlternative.setLeftOption(leftOption);
			Option rightOption = factory.createOption();
			rightOption.setProbability(alternative.getRightOption().getProbability());
			newAlternative.setRightOption(rightOption);
			topRegEx = newAlternative;
		}
		regExStack.push(topRegEx);
		operationExpected = false;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.fixit.simplify.RegExProcessor#processLoop(de.uka.ipd.sdq.regexp.model.Loop)
	 */
	public void processLoop(Loop loop) throws OperationExpectedException, InvalidStackStateException{
		if (!operationExpected)
			throw new OperationExpectedException();
		RegularExpression topRegEx = regExStack.pop();
		if(topRegEx == null){
			throw new InvalidStackStateException();
		} else {
			Loop newLoop = factory.createLoop();
			newLoop.setRegExp(topRegEx);
			topRegEx = newLoop;
		}
		regExStack.push(topRegEx);
		operationExpected = true; // loop is an unary operator and does not require another terminal
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.fixit.simplify.RegExProcessor#processParallel(de.uka.ipd.sdq.regexp.model.Parallel)
	 */
	public void processParallel(Parallel parallel) throws OperationExpectedException, InvalidStackStateException{
		if (!operationExpected)
			throw new OperationExpectedException();
		RegularExpression topRegEx = regExStack.pop();
		if(topRegEx == null){
			throw new InvalidStackStateException();
		} else {
			Parallel newParallel = factory.createParallel();
			newParallel.setLeftTask(topRegEx);
			topRegEx = newParallel;
		}
		regExStack.push(topRegEx);
		operationExpected = false;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.fixit.simplify.RegExProcessor#openBrace()
	 */
	public void openBrace() throws OperationExpectedException{
		if (operationExpected)
			throw new OperationExpectedException();
		regExStack.push(null); // start a new sub-regular expression
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.fixit.simplify.RegExProcessor#closeBrace()
	 */
	public void closeBrace() throws OperationExpectedException, InvalidStackStateException{
		if (!operationExpected)
			throw new OperationExpectedException();
		RegularExpression innerExpression = regExStack.pop();
		RegularExpression topRegEx = regExStack.pop();
		if(innerExpression == null){
			throw new InvalidStackStateException();
		} else {
			if(topRegEx == null){
				topRegEx = innerExpression;
			} else { // handling of acquire and release operations within the sub-expression??
				addRight(topRegEx, innerExpression);
			}
		}
		regExStack.push(topRegEx);	
	}
	
	public RegularExpression getResult() throws InvalidStackStateException{
		RegularExpression topRegEx = regExStack.pop();
		if(!regExStack.isEmpty())
			throw new InvalidStackStateException();
		return topRegEx;
	}

}
