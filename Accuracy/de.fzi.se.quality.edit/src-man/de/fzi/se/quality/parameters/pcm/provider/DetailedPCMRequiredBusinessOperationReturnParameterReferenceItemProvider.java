/**
 * 
 */
package de.fzi.se.quality.parameters.pcm.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.fzi.se.quality.parameters.pcm.PCMRequiredBusinessOperationReturnParameterReference;
import de.uka.ipd.sdq.pcmbench.ui.provider.SignaturePrinter;

/**Item provider with details for {@link PCMRequiredBusinessOperationReturnParameterReference}.
 * @author groenda
 *
 */
public class DetailedPCMRequiredBusinessOperationReturnParameterReferenceItemProvider
		extends
		PCMRequiredBusinessOperationReturnParameterReferenceItemProvider {

	public DetailedPCMRequiredBusinessOperationReturnParameterReferenceItemProvider(
			AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		StringBuilder text = new StringBuilder(getString("_UI_PCMRequiredBusinessOperationReturnParameterReference_type"));
		PCMRequiredBusinessOperationReturnParameterReference target = (PCMRequiredBusinessOperationReturnParameterReference) object;
		if (target.getRequiredRole() != null) {
			text.append(" Role=" + target.getRequiredRole().getEntityName());
		}
		if (target.getSignature() != null) {
			text.append(" Signature=" + new SignaturePrinter().doSwitch(target.getSignature()));
		}
		return text.toString();
	}
}
