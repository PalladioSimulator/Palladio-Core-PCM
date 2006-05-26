package RegEx.visitor;

import RegEx.*;

public class RegExToStringVisitor extends ReflectionBasedVisitor {
	
	private String result = "";

	public RegExToStringVisitor(Expression expr) {
		visit(expr);
	}
	
	public String getResult(){
		return result;
	}
	
	public void visitAlternative(Alternative alt){
		result +="(";
		visit(alt.getAltOne());
		result +=")|(";
		visit(alt.getAltTwo());
		result +=")";
	}
	
	public void visitLoop(Loop loop){
		result +="(";
		visit(loop.getInner());
		result +=")*";
	}
	
	public void visitParallel(Parallel par){
		result +="(";
		visit(par.getTaskOne());
		result +="||";
		visit(par.getTaskTwo());		
		result +=")";
	}
	
	public void visitSequence(Sequence seq){
		visit(seq.getPre());
		result +=";";
		visit(seq.getPost());
		
	}
	
	public void visitSymbol(Symbol sym){
		result +=sym.getName();
	}	

}
