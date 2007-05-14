package de.uka.ipd.sdq.simucom.behaviour;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;

import antlr.RecognitionException;
import de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.CollectionParameterUsage;
import de.uka.ipd.sdq.pcm.parameter.ParameterUsage;
import de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisationType;
import de.uka.ipd.sdq.pcm.seff.CollectionParametricParameterUsage;
import de.uka.ipd.sdq.pcm.seff.ParametricParameterUsage;
import de.uka.ipd.sdq.pcm.seff.PrimitiveParametricParameterUsage;
import de.uka.ipd.sdq.simucom.stochastics.RandomVariableHelper;

class PrimitiveParameterAbstractionComplexKey
{
	private String parameterName;
	private de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisationType type;
	
	public PrimitiveParameterAbstractionComplexKey(String parameterName, PrimitiveParameterCharacterisationType type)
	{
		this.parameterName = parameterName;
		this.type = type;
	}

	@Override
	public int hashCode()
	{
		return this.parameterName.hashCode();
	}
	
	@Override
	public boolean equals(Object other)
	{
		PrimitiveParameterAbstractionComplexKey otherKey = (PrimitiveParameterAbstractionComplexKey) other;
		if (otherKey.parameterName.equals(this.parameterName) && otherKey.type.equals(this.type))
			return true;
		return false;
	}

}

class CollectionParameterAbstractionComplexKey
{
	private String parameterName;
	private CollectionParameterCharacterisationType type;
	
	public CollectionParameterAbstractionComplexKey(String parameterName, CollectionParameterCharacterisationType type)
	{
		this.parameterName = parameterName;
		this.type = type;
	}
	
	@Override
	public int hashCode()
	{
		return this.parameterName.hashCode();
	}
	
	@Override
	public boolean equals(Object other)
	{
		CollectionParameterAbstractionComplexKey otherKey = (CollectionParameterAbstractionComplexKey) other;
		if (otherKey.parameterName.equals(this.parameterName) && otherKey.type.equals(this.type))
			return true;
		return false;
	}
}

public class SimulatedStackFrame {

	protected HashMap<PrimitiveParameterAbstractionComplexKey, Object> primitiveParameterAbstraction = new HashMap<PrimitiveParameterAbstractionComplexKey, Object>();
	protected HashMap<CollectionParameterAbstractionComplexKey, Object> collectionParameterAbstraction = new HashMap<CollectionParameterAbstractionComplexKey, Object>();
	protected HashMap<String, ParameterUsage> collectionInnerParameterAbstraction = new HashMap<String, ParameterUsage>();
	private SimulatedStackFrame parentFrame = null;
	
	public SimulatedStackFrame() 
	{
	}
	
	public SimulatedStackFrame(SimulatedStackFrame parent)
	{
		this.parentFrame = parent;
	}
	
	public Object getPrimitiveParameterCharacterisation(String parameterName, PrimitiveParameterCharacterisationType type)
	{
		return primitiveParameterAbstraction.get(
				new PrimitiveParameterAbstractionComplexKey(parameterName,type));
	}
	
	public Object getCollectionParameterCharacterisation(String parameterName, CollectionParameterCharacterisationType type)
	{
		return collectionParameterAbstraction.get(
				new CollectionParameterAbstractionComplexKey(parameterName,type));
	}

	public ParameterUsage getInnerParameter(String collectionName)
	{
		return collectionInnerParameterAbstraction.get(collectionName);
	}
	
	private void addPrimitiveParameterAbstraction(String parameterName, PrimitiveParameterCharacterisationType type, Object value)
	{
		primitiveParameterAbstraction.put(
				new PrimitiveParameterAbstractionComplexKey(parameterName,type),value);
	}
	private void addCollectionParameterAbstraction(String parameterName, CollectionParameterCharacterisationType type, Object value)
	{
		collectionParameterAbstraction.put(
				new CollectionParameterAbstractionComplexKey(parameterName,type),value);
	}
	
	/**
	 * @param call
	 * @param callContext
	 * @throws Exception
	 */
	public void buildParameterContext(EList parameterUsages) throws Exception {
		Iterator parameterUsagesIterator = parameterUsages.iterator();
		while(parameterUsagesIterator.hasNext())
		{
			ParameterUsage specifiedUsage = (ParameterUsage) parameterUsagesIterator.next();
			storeParameterAbstractionValues(specifiedUsage);
		}
	}

	/**
	 * @param specifiedParameter
	 * @return
	 * @throws Exception
	 */
	private void storeParameterAbstractionValues(ParameterUsage specifiedParameter) throws Exception {
		if (specifiedParameter instanceof CollectionParameterUsage)
		{
			CollectionParameterUsage collectionParameter = (CollectionParameterUsage)specifiedParameter;
			storeCollectionParameterAbstractionValues(collectionParameter);
		} else if (specifiedParameter instanceof ParameterUsage) {
			ParameterUsage parameter = (ParameterUsage)specifiedParameter;
			storePrimitiveParameterAbstractionValues(parameter);
		}
		else
			throw new Exception ("unknown parameter usage");
	}

	/**
	 * @param call
	 * @param callContext
	 * @throws Exception
	 */
	public void buildParametricParameterContext(EList parametricParameterUsages,SimulatedStackFrame stackFrame) throws Exception {
		Iterator parameterUsagesIterator = parametricParameterUsages.iterator();
		while(parameterUsagesIterator.hasNext())
		{
			ParametricParameterUsage specifiedUsage = (ParametricParameterUsage) parameterUsagesIterator.next();
			storeParametricParameterAbstractionValues(specifiedUsage,stackFrame);
		}
	}

	/**
	 * @param specifiedParameter
	 * @return
	 * @throws Exception
	 */
	private void storeParametricParameterAbstractionValues(ParametricParameterUsage specifiedParameter,SimulatedStackFrame stackFrame) throws Exception {
		if (specifiedParameter instanceof CollectionParametricParameterUsage)
		{
			CollectionParametricParameterUsage collectionParameter = (CollectionParametricParameterUsage)specifiedParameter;
			storeCollectionParametricParameterAbstractionValues(collectionParameter,stackFrame);
		} else if (specifiedParameter instanceof PrimitiveParametricParameterUsage) {
			PrimitiveParametricParameterUsage parameter = (PrimitiveParametricParameterUsage)specifiedParameter;
			storePrimitiveParametricParameterAbstractionValues(parameter,stackFrame);
		}
		else
			throw new Exception ("unknown parametric parameter usage");
	}
	
	private void storePrimitiveParametricParameterAbstractionValues(PrimitiveParametricParameterUsage usage,SimulatedStackFrame stackFrame) {
		try {
			this.addPrimitiveParameterAbstraction(
				usage.getCharacterisedParameter_ParametricParameterUsage().getParameterName(), 
				usage.getType(),
				RandomVariableHelper.getSample(usage.getSpecification(),stackFrame) );
			} catch (RecognitionException e) {
				e.printStackTrace();
				System.exit(-1);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
		}
	}

	private void storePrimitiveParameterAbstractionValues(ParameterUsage usage) {
		Iterator specifiedCharacterisations = usage.getParameterCharacterisation_ParameterUsage().iterator();

		while (specifiedCharacterisations.hasNext())
		{
			PrimitiveParameterCharacterisation specifiedCharacterisation = (PrimitiveParameterCharacterisation)specifiedCharacterisations.next();
			try {
				this.addPrimitiveParameterAbstraction(
						usage.getParameter_ParameterUsage().getParameterName(), 
						specifiedCharacterisation.getType(),
						RandomVariableHelper.getSample(specifiedCharacterisation.getSpecification(),this) );
			} catch (RecognitionException e) {
				e.printStackTrace();
				System.exit(-1);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}

	private void storeCollectionParameterAbstractionValues(CollectionParameterUsage usage) {
		Iterator specifiedCharacterisations = usage.getParameterCharacterisation_CollectionParameterUsage().iterator();

		while (specifiedCharacterisations.hasNext())
		{
			CollectionParameterCharacterisation specifiedCharacterisation = (CollectionParameterCharacterisation)specifiedCharacterisations.next();
			try {
				this.addCollectionParameterAbstraction(
						usage.getParameter_ParameterUsage().getParameterName(), 
						specifiedCharacterisation.getType(),
						RandomVariableHelper.getSample(specifiedCharacterisation.getSpecification(),this) );
				 collectionInnerParameterAbstraction.put(
						 usage.getParameter_ParameterUsage().getParameterName(),
						 usage.getInnerElement_ParameterUsage());
			} catch (RecognitionException e) {
				e.printStackTrace();
				System.exit(-1);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}
	
	private void storeCollectionParametricParameterAbstractionValues(CollectionParametricParameterUsage usage,SimulatedStackFrame stackFrame) {			
		try {
				this.addCollectionParameterAbstraction(
						usage.getCharacterisedParameter_ParametricParameterUsage().getParameterName(), 
						usage.getType(),
						RandomVariableHelper.getSample(usage.getSpecification(),stackFrame) );
				// TODO: Modell incorect, collection inner kann auch wieder
				// spezifiziert werden
// collectionInnerParameterAbstraction.put(
// usage.getParameter_ParameterUsage().getParameterName(),
// usage.getInnerElement_ParameterUsage());
			} catch (RecognitionException e) {
				e.printStackTrace();
				System.exit(-1);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
		}
	}
}
