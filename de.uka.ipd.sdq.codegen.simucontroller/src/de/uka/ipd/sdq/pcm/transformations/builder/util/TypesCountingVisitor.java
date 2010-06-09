package de.uka.ipd.sdq.pcm.transformations.builder.util;

import java.util.Stack;

import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.util.RepositorySwitch;

public class TypesCountingVisitor extends RepositorySwitch<String> {

	private PrimitiveDataType type;
	private Stack<String> prefixes = new Stack<String>();

	public TypesCountingVisitor(Variable p, PrimitiveDataType type) {
		this.type = type;
		prefixes.push(p.getEntityName());
	}

	public TypesCountingVisitor(String name, PrimitiveDataType type) {
		this.type = type;
		prefixes.push(name);
	}

	@Override
	public String caseCollectionDataType(CollectionDataType object) {
	    String innerStoEx = this.doSwitch(object.getInnerDataType__CollectionDataType());
	    if (innerStoEx != null) {
	    	if (innerStoEx.equals("1")){
	    		return getPrefix() + ".NUMBER_OF_ELEMENTS";
	    	} else {
	    		//TODO: use sum instead for correct stochastic processing!
	    		return getPrefix() + ".NUMBER_OF_ELEMENTS * ("+innerStoEx+")";
	    	}
	    } else
	    	return null;
	}

	private String getPrefix() {
		String result = "";
		for (String s : prefixes) {
			result += s +".";
		}
		return result.substring(0, result.length()-1);
	}

	@Override
	public String caseCompositeDataType(CompositeDataType object) {
		return super.caseCompositeDataType(object);
	}

	@Override
	public String casePrimitiveDataType(PrimitiveDataType object) {
		if (object == this.type)
			return "1";
		return super.casePrimitiveDataType(object);
	}
}
