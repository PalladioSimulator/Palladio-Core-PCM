package de.uka.ipd.sdq.pcm.dialogs.variableusage;

import java.util.ArrayList;

import de.uka.ipd.sdq.pcm.repository.EventType;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.ParameterModifier;

/**
 * This content provider collects the parameters of a parent object
 * to be used in a variable usage.
 * 
 * @author Benjamin Klatt
 */
public class VariableUsageInputParameterContentProvider extends
		VariableUsageContentProvider {

	@Override
	public Object[] getChildren(Object parent) {
		/**
		 * Operation Signature Parametter
		 */
		if (parent instanceof OperationSignature) {
			OperationSignature signature = (OperationSignature) parent;
			ArrayList<Parameter> inputParameter = new ArrayList<Parameter>();
			for (Parameter p : signature.getParameters__OperationSignature()) {
				if (p.getModifier__Parameter() == ParameterModifier.NONE || 
					p.getModifier__Parameter() == ParameterModifier.IN || 
					p.getModifier__Parameter() == ParameterModifier.INOUT){
					inputParameter.add(p);
				}
			}
			return inputParameter.toArray();
		
		/**
		 * Event Type Parameter
		 */
		} else	if (parent instanceof EventType) {
				EventType eventType = (EventType) parent;
				return new Object[]{eventType.getParameter__EventType()};
		} else 
			return super.getChildren(parent);
	}

}
