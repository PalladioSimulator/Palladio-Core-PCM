package de.uka.ipd.sdq.pcmbench.ui.provider;

import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.util.RepositorySwitch;

public class RepositoryPrinter extends RepositorySwitch {

	public RepositoryPrinter() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.repository.util.RepositorySwitch#caseParameter(de.uka.ipd.sdq.pcm.repository.Parameter)
	 */
	@Override
	public Object caseParameter(Parameter object) {
		String result = "";
		result += object.getParameterName();
		return result;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.repository.util.RepositorySwitch#casePrimitiveDataType(de.uka.ipd.sdq.pcm.repository.PrimitiveDataType)
	 */
	@Override
	public Object casePrimitiveDataType(PrimitiveDataType object) {
		String result = "";
		result += object.getType();
		return result;
	}
	
	

}
