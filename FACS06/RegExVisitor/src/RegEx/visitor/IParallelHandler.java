package RegEx.visitor;

import RegEx.Parallel;

public interface IParallelHandler {

	@SuppressWarnings("unchecked")
	public abstract void handle(Parallel par);

}