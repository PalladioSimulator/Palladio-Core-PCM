/**
 * 
 */
package de.fzi.se.quality.parameters.pcm.provider;

import org.eclipse.emf.common.notify.Adapter;

import de.fzi.se.quality.parameters.pcm.PCMParameterReference;
import de.fzi.se.quality.parameters.pcm.provider.PCMItemProviderAdapterFactory;

/**Adapter factory providing detailed information on {@link PCMParameterReference} instances.
 * @author groenda
 *
 */
public class DetailedPCMItemProviderAdapterFactory extends
		PCMItemProviderAdapterFactory {

	@Override
	public Adapter createPCMOperationParameterReferenceAdapter() {
		if (this.pcmOperationParameterReferenceItemProvider == null) {
			this.pcmOperationParameterReferenceItemProvider = new DetailedPCMOperationParameterReferenceItemProvider(this);
		}
		return pcmOperationParameterReferenceItemProvider;
	}
	
	@Override
	public Adapter createPCMRequiredBusinessOperationReturnParameterReferenceAdapter() {
		if (this.pcmRequiredBusinessOperationReturnParameterReferenceItemProvider == null) {
			this.pcmRequiredBusinessOperationReturnParameterReferenceItemProvider = new DetailedPCMRequiredBusinessOperationReturnParameterReferenceItemProvider(this);
		}
		return this.pcmRequiredBusinessOperationReturnParameterReferenceItemProvider;
	}
	
	@Override
	public Adapter createPCMComponentParameterReferenceAdapter() {
		if (this.pcmComponentParameterReferenceItemProvider == null) {
			this.pcmComponentParameterReferenceItemProvider = new DetailedPCMComponentParameterReferenceItemProvider(this);
		}
		return this.pcmComponentParameterReferenceItemProvider;
	}
}
