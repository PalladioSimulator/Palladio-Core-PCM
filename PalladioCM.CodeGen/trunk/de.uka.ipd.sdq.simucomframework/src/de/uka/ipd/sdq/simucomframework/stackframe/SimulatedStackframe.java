package de.uka.ipd.sdq.simucomframework.stackframe;

import java.util.HashMap;

public class SimulatedStackframe <T> {
	
	private SimulatedStackframe<T> parentFrame = null;
	
	// Stackframe: Maps ID->Value
	private HashMap<String, T> contents = new HashMap<String, T>();
	
	public SimulatedStackframe (SimulatedStackframe<T> parent)
	{
		this.parentFrame = parent;
	}

	public SimulatedStackframe ()
	{
		this.parentFrame = null;
	}

	public void addValue(String id, T value)
	{
		contents.put(id,value);
	}
	
	public T getValue(String id) throws ValueNotInFrameException
	{
		if (this.contents.containsKey(id))
			return this.contents.get(id);
		if (parentFrame != null)
			return parentFrame.getValue(id);
		throw new ValueNotInFrameException("Identifier "+id+" not found in stackframe!");
	}
	
	public SimulatedStackframe<T> copyFrame()
	{
		SimulatedStackframe<T> copy = new SimulatedStackframe<T>();
		for (String key : this.contents.keySet()) {
			copy.addValue(key, contents.get(key));
		}
		if (parentFrame != null)
			copy.setParentFrame(parentFrame.copyFrame());
		return copy;
	}

	private void setParentFrame(SimulatedStackframe<T> frame) {
		this.parentFrame = frame;
	}
}
