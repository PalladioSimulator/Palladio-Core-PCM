package de.uka.ipd.sdq.pcmbench.ui.provider;

import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.pcm.repository.PrimitiveDataType;
import org.palladiosimulator.pcm.repository.util.RepositorySwitch;

public class RepositoryPrinter extends RepositorySwitch {

	public RepositoryPrinter() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.palladiosimulator.pcm.repository.util.RepositorySwitch#caseParameter(org.palladiosimulator.pcm.repository.Parameter)
	 */
	@Override
	public Object caseParameter(Parameter object) {
		String result = "";
		result += object.getParameterName();
		return result;
	}

	/* (non-Javadoc)
	 * @see org.palladiosimulator.pcm.repository.util.RepositorySwitch#casePrimitiveDataType(org.palladiosimulator.pcm.repository.PrimitiveDataType)
	 */
	@Override
	public Object casePrimitiveDataType(PrimitiveDataType object) {
		String result = "";
		result += object.getType();
		return result;
	}
	
	

}
