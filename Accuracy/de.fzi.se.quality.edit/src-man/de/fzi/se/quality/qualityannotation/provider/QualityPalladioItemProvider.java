/**
 * 
 */
package de.fzi.se.quality.qualityannotation.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProvider;

/**
 * @author groenda
 *
 */
public class QualityPalladioItemProvider extends PalladioItemProvider {

	public QualityPalladioItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		String result = "";
		if (object instanceof Parameter) {
			Parameter p = (Parameter) object;
			if (p.getEventType__Parameter() != null) {
				result = p.getEventType__Parameter().getEventGroup__EventType().getEntityName() + "::" + p.getEventType__Parameter().getEntityName();
			}
			if (p.getResourceSignature__Parameter() != null) {
				result = p.getResourceSignature__Parameter().getResourceInterface__ResourceSignature().getEntityName() + "::" + p.getResourceSignature__Parameter().getEntityName();
			}
			if (p.getOperationSignature__Parameter() != null) {
				result = p.getOperationSignature__Parameter().getInterface__OperationSignature().getEntityName() + "::" + p.getOperationSignature__Parameter().getEntityName();
			}
			if (p.getInfrastructureSignature__Parameter() != null) {
				result = p.getInfrastructureSignature__Parameter().getInfrastructureInterface__InfrastructureSignature().getEntityName() + "::" + p.getInfrastructureSignature__Parameter().getEntityName();
			}
			result = result + ":" + super.getText(p.getDataType__Parameter()) + " " + p.getParameterName();
		} else {
			result = super.getText(object);
		}
		return result;
	}
}
