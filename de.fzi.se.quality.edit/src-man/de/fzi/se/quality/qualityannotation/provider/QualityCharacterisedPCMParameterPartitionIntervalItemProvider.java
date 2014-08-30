/**
 * 
 */
package de.fzi.se.quality.qualityannotation.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval;

/**
 * @author groenda
 *
 */
public class QualityCharacterisedPCMParameterPartitionIntervalItemProvider extends
		CharacterisedPCMParameterPartitionIntervalItemProvider {

	public QualityCharacterisedPCMParameterPartitionIntervalItemProvider(
			AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		StringBuilder text = new StringBuilder();
		if (object != null) {
			if (object instanceof CharacterisedPCMParameterPartitionInterval) {
				CharacterisedPCMParameterPartitionInterval c = (CharacterisedPCMParameterPartitionInterval) object;
				if (c.getQualifiedElementName() != null && c.getQualifiedElementName().length() > 0) {
					text.append(c.getQualifiedElementName() + ".");
				}
				text.append(c.getForCharacterisation().getName());
				if (c.getFrom() != null && c.getTo() != null) {
					text.append(" = ");
					text.append("[" + c.getFrom().getSpecification() + "," + c.getTo().getSpecification() + "]");
				}
			}
		}
		return text.toString();
	}
}
