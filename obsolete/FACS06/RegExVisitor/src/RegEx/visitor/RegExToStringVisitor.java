package RegEx.visitor;

import RegEx.*;

public class RegExToStringVisitor extends ReflectionBasedVisitor {
	
	Expression expression;
	
	public RegExToStringVisitor(Expression expr) {
		expression = expr;
		visit(expression);
	}
	
	public String getResult(){
		return expression.getAsString();
	}
	
	public void visitAlternative(Alternative alt){
		visit(alt.getAltOne());
		visit(alt.getAltTwo());
		String result ="(";
		result += alt.getAltOne().getAsString();
		result +=")|(";
		result += alt.getAltTwo().getAsString();
		result +=")";
		alt.setAsString(result);
	
	}
	
	public void visitLoop(Loop loop){
		visit(loop.getInner());
		String result ="(";
		result += loop.getInner().getAsString();
		result +=")*";
		loop.setAsString(result);
	}
	
	public void visitParallel(Parallel par){
		visit(par.getTaskOne());
		visit(par.getTaskTwo());		
		String result ="(";
		result += par.getTaskOne().getAsString();
		result +="||";
		result += par.getTaskTwo().getAsString();
		result +=")";
		par.setAsString(result);
	}
	
	public void visitSequence(Sequence seq){
		visit(seq.getPre());
		visit(seq.getPost());
		String result = seq.getPre().getAsString();
		result +=";";
		result += seq.getPost().getAsString();
		seq.setAsString(result);
	}
	
	public void visitSymbol(Symbol sym){
		sym.setAsString(sym.getName());
	}	

}
