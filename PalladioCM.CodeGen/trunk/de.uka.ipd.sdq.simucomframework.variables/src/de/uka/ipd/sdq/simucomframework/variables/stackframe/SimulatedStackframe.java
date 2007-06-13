package de.uka.ipd.sdq.simucomframework.variables.stackframe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

public class SimulatedStackframe <T> implements Serializable {

	private static Logger logger = 
		Logger.getLogger(SimulatedStackframe.class.getName());
	
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
	
	public ArrayList<Entry<String,T>> getContents()
	{
		return getContentsRecursive(new HashMap<String, T>());
	}
	
	private ArrayList<Entry<String,T>> getContentsRecursive(HashMap<String,T> alreadyFound) {
		ArrayList<Entry<String,T>> result = new ArrayList<Entry<String,T>>();
		for (Entry<String,T> e : contents.entrySet()) {
			if (!alreadyFound.containsKey(e.getKey())) {
				alreadyFound.put(e.getKey(),e.getValue());
				result.add(e);
			}
		}
		if (parentFrame != null)
			result.addAll(parentFrame.getContentsRecursive(alreadyFound));
		return result;
	}

	public void addVariables(SimulatedStackframe<T> callResult) {
		logger.debug("Adding "+callResult.getContents().size()+" value(s) to own stackframe");
		for (Entry<String,T> e : callResult.contents.entrySet()) {
			logger.debug("Adding "+e.getKey()+" with "+e.getValue());
			this.addValue(e.getKey(), e.getValue());
		}
		
	}
	
	public SimulatedStackframe<Object> getByteSizeOfFrame(){
		Double result = 0.0;
		List<Entry<String,T>> stackFrameContents = getContents();
		for (Entry<String,T> e : stackFrameContents){
			String key = e.getKey();
			
			if (key.endsWith("INNER.BYTESIZE")){ //Collection
				String variableReference = key.substring(0, key.length()-15);
				double numberOfElements = 0;
				try {
					numberOfElements = ((Number)this.getValue(variableReference+".NUMBER_OF_ELEMENTS")).doubleValue();
				} catch (ValueNotInFrameException e1) {
					e1.printStackTrace();
				}
				result += numberOfElements * ((Number)e.getValue()).doubleValue();
			} else if (key.endsWith("BYTESIZE")){ // Primitive & Composite
				result += ((Number)e.getValue()).doubleValue();
			}
		
		}
		
		SimulatedStackframe<Object> resultFrame = new SimulatedStackframe<Object>();
		resultFrame.addValue("transferData.BYTESIZE", result);
		
		return resultFrame;
	}
}
