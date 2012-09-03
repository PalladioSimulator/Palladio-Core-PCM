/**
 * 
 */
package de.fzi.se.quality.qualityannotation.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import util.Helper;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;

/**QualityAnnotationItemProvider with meaningful text.
 * 
 * @author groenda
 *
 */
public class DetailedQualityAnnotationItemProvider extends
		QualityAnnotationItemProvider {

	public DetailedQualityAnnotationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		StringBuilder text = new StringBuilder(getString("_UI_QualityAnnotation_type"));
		if (object != null) {
			if (object instanceof QualityAnnotation) {
				QualityAnnotation target = (QualityAnnotation) object;
				if (target.getForServiceSpecification() != null) {
					text.append(" " + Helper.getText(adapterFactory, target.getForServiceSpecification()));
				}
				if (target.getId() != null) {
					text.append(" " + target.getId());
				}
			} 
		}
		return text.toString();
	}
}
