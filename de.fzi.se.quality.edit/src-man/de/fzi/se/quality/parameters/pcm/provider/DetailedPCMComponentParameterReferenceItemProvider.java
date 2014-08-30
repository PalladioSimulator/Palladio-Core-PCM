/**
 * 
 */
package de.fzi.se.quality.parameters.pcm.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProvider;

/**Detailed information for {@link PCMComponentParameterReference}.
 * @author groenda
 *
 */
public class DetailedPCMComponentParameterReferenceItemProvider extends
		PCMComponentParameterReferenceItemProvider {

	public DetailedPCMComponentParameterReferenceItemProvider(
			AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		StringBuilder text = new StringBuilder(getString("_UI_PCMRequiredBusinessOperationReturnParameterReference_type"));
		PCMComponentParameterReference target = (PCMComponentParameterReference) object;
		if (target.getImplementationComponentType() != null) {
			text.append(" component=" + new PalladioItemProvider(getAdapterFactory()).getText(target.getImplementationComponentType()));
		}
		if (target.getVariableUsage() != null) {
			text.append(" parameter=" + target.getVariableUsage().getNamedReference__VariableUsage().getReferenceName());
		}
		return text.toString();
	}
}
