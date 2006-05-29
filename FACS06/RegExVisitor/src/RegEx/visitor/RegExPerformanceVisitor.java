package RegEx.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import RegEx.*;

public class RegExPerformanceVisitor extends ReflectionBasedVisitor {
	
	private TimeConsumption[] resultCpuTimes = null;
	public TimeConsumption symTime = null;
	private int numCPUs;
	
	public RegExPerformanceVisitor(Expression expr, int numCPUs) {
		this.numCPUs = numCPUs;
		visit(expr);
		resultCpuTimes = (TimeConsumption[]) expr.getCpuTimes().toArray();
	}
	
	public TimeConsumption[] getResultCpuTimes(){
		return resultCpuTimes;
	}
	
	public void visitAlternative(Alternative alt){
		visit(alt.getAltOne());
		visit(alt.getAltTwo());
		IVisitHandler handler = new AlternativeHandler(alt.getProbOne(), alt.getProbTwo());
		process(alt, alt.getAltOne(), alt.getAltTwo(), handler);		
	}
	
	
	public void visitLoop(Loop loop){
		visit(loop.getInner());
		IVisitHandler handler = new LoopHandler(loop.getIterations());
		process(loop, loop.getInner(), handler);
	}	
	

	@SuppressWarnings("unchecked")
	public void visitParallel(Parallel par){
		par.getTaskOne().setFatherParallel(true);
		par.getTaskTwo().setFatherParallel(true);
		visit(par.getTaskOne());
		visit(par.getTaskTwo());
				
		IParallelHandler handler = new ParallelHandler(numCPUs);
		handler.handle(par);
		
		Tools.printExpr(par);		
	}
	

	public void visitSequence(Sequence seq){
		visit(seq.getPre());
		visit(seq.getPost());
		
		IVisitHandler handler = new SequenceHandler();
		process(seq, seq.getPre(), seq.getPost(), handler);				
	}
	

	@SuppressWarnings("unchecked")
	public void visitSymbol(Symbol sym){	
		int i = 0;
		List<TimeConsumption> cpuTimes = sym.getCpuTimes();
		for(Iterator<TimeConsumption> it1 = cpuTimes.iterator(); it1.hasNext(); ){
			TimeConsumption tc = it1.next();
			DistributionFunction df = tc.getNormDF().adjustDistance(Tools.DISTANCE);
			df.expandTo(Tools.ACCURACY);
			tc.setNormDF(df);
			i++;
			
			if (symTime == null)
				symTime = tc;
		}
		// set the computation times for all other cpus to zero
		while(i < numCPUs){
			DistributionFunction df = Tools.getDiracImpulse(Tools.ACCURACY, Tools.DISTANCE);
			TimeConsumption tc = RegExFactory.eINSTANCE.createTimeConsumption();
			tc.setNormDF(df);
			cpuTimes.add(tc);
			i++;
		}
	}
	

	@SuppressWarnings("unchecked")
	public void process(Expression current, Expression ex1, Expression ex2, IVisitHandler handler){
		Iterator<TimeConsumption> it1 = ex1.getCpuTimes().iterator();
		Iterator<TimeConsumption> it2 = ex2.getCpuTimes().iterator();
		List<TimeConsumption> resultTimes = current.getCpuTimes();
		resultTimes.clear();
		
		for (int i = 0; i < numCPUs; i++) {
			TimeConsumption tc = handler.handle(it1.next(), it2.next());			
			resultTimes.add(tc);
		}		
	}	

	@SuppressWarnings("unchecked")
	public void process(Expression current, Expression ex1, IVisitHandler handler){
		Iterator<TimeConsumption> it1 = ex1.getCpuTimes().iterator();
		List<TimeConsumption> resultTimes = current.getCpuTimes();
		resultTimes.clear();
		
		for (int i = 0; i < numCPUs; i++) {
			TimeConsumption tc = handler.handle(it1.next());			
			resultTimes.add(tc);
		}		
	}	
	
	public static Complex[] getPointArray(DistributionFunction df){
		return (Complex[]) df.getPoints().toArray();
	}
}
