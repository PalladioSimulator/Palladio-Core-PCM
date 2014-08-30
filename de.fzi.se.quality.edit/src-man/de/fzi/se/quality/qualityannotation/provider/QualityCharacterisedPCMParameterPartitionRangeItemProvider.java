/**
 * 
 */
package de.fzi.se.quality.qualityannotation.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionRange;

/**
 * @author groenda
 *
 */
public class QualityCharacterisedPCMParameterPartitionRangeItemProvider extends
		CharacterisedPCMParameterPartitionRangeItemProvider {

	public QualityCharacterisedPCMParameterPartitionRangeItemProvider(
			AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		StringBuilder text = new StringBuilder();
		if (object != null) {
			if (object instanceof CharacterisedPCMParameterPartitionRange) {
				CharacterisedPCMParameterPartitionRange c = (CharacterisedPCMParameterPartitionRange) object;
				if (c.getQualifiedElementName() != null && c.getQualifiedElementName().length() > 0) {
					text.append(c.getQualifiedElementName() + ".");
				}
				text.append(c.getForCharacterisation().getName() + " = ");
				for (int i =0; i < c.getValues().size(); i++) {
					text.append(c.getValues().get(i).getSpecification());
					if (i < c.getValues().size() - 1) {
						text.append(",");
					}
				}
			}
		}
		return text.toString();
	}
}
