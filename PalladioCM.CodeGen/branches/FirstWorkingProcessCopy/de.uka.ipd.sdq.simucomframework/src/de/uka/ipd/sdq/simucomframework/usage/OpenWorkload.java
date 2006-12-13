package de.uka.ipd.sdq.simucomframework.usage;

import java.io.StringReader;

import antlr.RecognitionException;
import antlr.TokenStreamException;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExParser;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.stoexvisitor.PCMStoExEvaluationVisitor;
import de.uka.ipd.sdq.simucomframework.stoexvisitor.SimulationExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsLexer;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;


public class OpenWorkload extends SimProcess implements IWorkloadDriver {

	private String interArrivalTime;
	private IUserFactory userFactory;

	public OpenWorkload(SimuComModel model, IUserFactory userFactory, String interArrivalTime) {
		super(model,"OpenWorkloadUserMaturationChamber",true);
		this.interArrivalTime = interArrivalTime;
		this.userFactory = userFactory;
	}

	public void run() {
		this.activate(SimTime.NOW);
	}

	@Override
	public void lifeCycle() {
		while(true) {
			generateUser();
			waitForNextUser();
		}
	}

	private void waitForNextUser() {
		double interArrivalTimeSample = (Double)Context.evaluate(interArrivalTime,Double.class,null);
		this.hold(new SimTime(interArrivalTimeSample));
	}

	private void generateUser() {
		userFactory.createUser().startUserLife();
	}	
}
