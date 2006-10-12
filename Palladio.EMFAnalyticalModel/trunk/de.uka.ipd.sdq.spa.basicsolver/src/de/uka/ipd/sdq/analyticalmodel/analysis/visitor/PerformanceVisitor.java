package de.uka.ipd.sdq.analyticalmodel.analysis.visitor;

import java.util.Hashtable;

import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.perfhandler.PerformanceAlternativeHandler;
import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.perfhandler.PerformanceHandlerFactory;
import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.perfhandler.PerformanceLoopHandler;
import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.perfhandler.PerformanceSequenceHandler;
import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.perfhandler.PerformanceSymbolHandler;
import de.uka.ipd.sdq.model.analysis.expression.Alternative;
import de.uka.ipd.sdq.model.analysis.expression.Loop;
import de.uka.ipd.sdq.model.analysis.expression.RegularExpression;
import de.uka.ipd.sdq.model.analysis.expression.Sequence;
import de.uka.ipd.sdq.model.analysis.expression.Symbol;
import de.uka.ipd.sdq.model.analysis.expression.util.ExpressionSwitch;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;

public class PerformanceVisitor {

	private PerformanceAlternativeHandler altHandler;

	private PerformanceLoopHandler loopHandler;

	private PerformanceSequenceHandler seqHandler;

	private PerformanceSymbolHandler symHandler;

	private Hashtable<RegularExpression, IProbabilityDensityFunction> pdfTable;

	private ExpressionSwitch exprswitch = new ExpressionSwitch() {

		@Override
		public Object caseAlternative(Alternative alternative) {
			doSwitch(alternative.getLeftOption());
			doSwitch(alternative.getRightOption());
			altHandler.handle(alternative);
			return alternative;
		}

		@Override
		public Object caseLoop(Loop loop) {
			try {
				doSwitch(loop.getRegExp());
				loopHandler.handle(loop);
				return loop;
			} catch (UnknownPDFTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FunctionNotInTimeDomainException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FunctionsInDifferenDomainsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

	public PerformanceVisitor(PerformanceAlternativeHandler altHandler,
			PerformanceLoopHandler loopHandler,
			PerformanceSequenceHandler seqHandler,
			PerformanceSymbolHandler symHandler) {
		super();
		this.altHandler = altHandler;
		this.loopHandler = loopHandler;
		this.seqHandler = seqHandler;
		this.symHandler = symHandler;
	}

	public PerformanceVisitor(PerformanceHandlerFactory factory) {
		this.altHandler = factory.createAlternativeHandler();
		this.seqHandler = factory.createSequenceHandler();
		this.loopHandler = factory.createLoopHandler();
		this.symHandler = factory.createSymbolHandler();
	}

	public IProbabilityDensityFunction getResponseTime(
			RegularExpression expression) {
		if (pdfTable.get(expression) == null) {
			exprswitch.doSwitch(expression);
		}
		return pdfTable.get(expression);
	}

	public void reset() {
		pdfTable.clear();
	}

	public void setPDFTable(
			Hashtable<RegularExpression, IProbabilityDensityFunction> pdfTable) {
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
