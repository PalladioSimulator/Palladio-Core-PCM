package RegEx.visitor;

import RegEx.TimeConsumption;

public interface IVisitHandler {

	public abstract TimeConsumption handle(TimeConsumption tc1,
			TimeConsumption tc2);

	public abstract TimeConsumption handle(TimeConsumption tc1);
}