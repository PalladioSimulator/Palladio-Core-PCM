package de.uka.ipd.sdq.spa.basicsolver.visitor;

import java.util.Hashtable;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInFrequencyDomainException;
import de.uka.ipd.sdq.spa.basicsolver.visitor.perfhandler.PerformanceAlternativeHandler;
import de.uka.ipd.sdq.spa.basicsolver.visitor.perfhandler.PerformanceHandlerFactory;
import de.uka.ipd.sdq.spa.basicsolver.visitor.perfhandler.PerformanceLoopHandler;
import de.uka.ipd.sdq.spa.basicsolver.visitor.perfhandler.PerformanceSequenceHandler;
import de.uka.ipd.sdq.spa.basicsolver.visitor.perfhandler.PerformanceSymbolHandler;
import de.uka.ipd.sdq.spa.expression.Alternative;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.Loop;
import de.uka.ipd.sdq.spa.expression.Sequence;
import de.uka.ipd.sdq.spa.expression.Symbol;
import de.uka.ipd.sdq.spa.expression.util.ExpressionSwitch;

public class PerformanceVisitor {

	private PerformanceAlternativeHandler altHandler;

	private PerformanceLoopHandler loopHandler;

	private PerformanceSequenceHandler seqHandler;

	private PerformanceSymbolHandler symHandler;

	private Hashtable<Expression, IProbabilityDensityFunction> pdfTable;
	
	private ExpressionSwitch exprswitch = new ExpressionSwitch() {

		@Override
		public Object caseAlternative(Alternative alternative) {
			doSwitch(alternative.getLeftOption().getRegexp());
			doSwitch(alternative.getRightOption().getRegexp());
			altHandler.handle(alternative);
			return alternative;
		}

		@Override
		public Object caseLoop(Loop loop) {
			doSwitch(loop.getRegExp());
			loopHandler.handle(loop);
			return loop;
		}

		@Override
		public Object caseSequence(Sequence sequence) {
			doSwitch(sequence.getLeftRegExp());
			doSwitch(sequence.getRightRegExp());
			seqHandler.handle(sequence);
			return sequence;
		}

		@Override
		public Object caseSymbol(Symbol symbol) {
			symHandler.handle(symbol);
			return symbol;
		}

	};

	
	private PerformanceVisitor(){
		super();
	}

	public PerformanceVisitor(PerformanceAlternativeHandler altHandler,
			PerformanceLoopHandler loopHandler,
			PerformanceSequenceHandler seqHandler,
			PerformanceSymbolHandler symHandler, Hashtable<Expression, IProbabilityDensityFunction> pdfTable) {
		this();
		this.altHandler = altHandler;
		this.loopHandler = loopHandler;
		this.seqHandler = seqHandler;
		this.symHandler = symHandler;
		this.pdfTable = pdfTable;
	}

	public PerformanceVisitor(PerformanceHandlerFactory factory) {
		this();
		this.altHandler = factory.createAlternativeHandler();
		this.seqHandler = factory.createSequenceHandler();
		this.loopHandler = factory.createLoopHandler();
		this.symHandler = factory.createSymbolHandler();
		pdfTable = factory.getPdfTable();
	}

	public IProbabilityDensityFunction getResponseTime(
			Expression expression) {
		try {
			if (pdfTable.get(expression) == null) {
				exprswitch.doSwitch(expression);
			}
			return pdfTable.get(expression).getInverseFourierTransform();
		} catch (FunctionNotInFrequencyDomainException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

	public void reset() {
		pdfTable.clear();
	}

	public void setPDFTable(
			Hashtable<Expression, IProbabilityDensityFunction> pdfTable) {
		this.pdfTable = pdfTable;
		loopHandler.setPdfTable(pdfTable);
		altHandler.setPdfTable(pdfTable);
		seqHandler.setPdfTable(pdfTable);
		symHandler.setPdfTable(pdfTable);
	}

	public AlternativeHandler getAltHandler() {
		return altHandler;
	}

	public void setAltHandler(PerformanceAlternativeHandler altHandler) {
		this.altHandler = altHandler;
	}

	public LoopHandler getLoopHandler() {
		return loopHandler;
	}

	public void setLoopHandler(PerformanceLoopHandler loopHandler) {
		this.loopHandler = loopHandler;
	}

	public SequenceHandler getSeqHandler() {
		return seqHandler;
	}

	public void setSeqHandler(PerformanceSequenceHandler seqHandler) {
		this.seqHandler = seqHandler;
	}

	public SymbolHandler getSymHandler() {
		return symHandler;
	}

	public void setSymHandler(PerformanceSymbolHandler symHandler) {
		this.symHandler = symHandler;
	}
}
