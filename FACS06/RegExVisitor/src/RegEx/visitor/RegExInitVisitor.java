package RegEx.visitor;

import RegEx.Alternative;
import RegEx.DistributionFunction;
import RegEx.Expression;
import RegEx.Loop;
import RegEx.Parallel;
import RegEx.RegExFactory;
import RegEx.Sequence;
import RegEx.Symbol;
import RegEx.TimeConsumption;


import org.eclipse.emf.ecore.util.EcoreUtil;

public class RegExInitVisitor extends ReflectionBasedVisitor {
	
	private DistributionFunction distFunc = null;
	
	public RegExInitVisitor(Expression expr, DistributionFunction dF) {
		this.distFunc = dF;
		visit(expr);
	}
	
	public void visitAlternative(Alternative alt){
		visit(alt.getAltOne());
		visit(alt.getAltTwo());
	}
	
	
	public void visitLoop(Loop loop){
		visit(loop.getInner());
	}	

	@SuppressWarnings("unchecked")
	public void visitParallel(Parallel par){
		par.getTaskOne().setFatherParallel(true);
		par.getTaskTwo().setFatherParallel(true);
		visit(par.getTaskOne());
		visit(par.getTaskTwo());
	}
	

	public void visitSequence(Sequence seq){
		visit(seq.getPre());
		visit(seq.getPost());
	}
	

	@SuppressWarnings("unchecked")
	public void visitSymbol(Symbol sym){	
		TimeConsumption tc = RegExFactory.eINSTANCE.createTimeConsumption();
		DistributionFunction distFuncCopy = (DistributionFunction)EcoreUtil.copy(distFunc);
		tc.setNormDF(distFuncCopy);
		
		sym.getCpuTimes().clear();
		sym.getCpuTimes().add(tc);
	}
	

}
