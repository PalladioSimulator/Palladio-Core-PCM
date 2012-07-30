/**
 * 
 */
package de.fzi.se.quality.qualityannotation.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

/**Text: Exactly As Specified
 * @author groenda
 *
 */
public class DetailedExactylAsSpecifiedPrecisionItemProvider extends
		ExactlyAsSpecifiedPrecisionItemProvider {

	public DetailedExactylAsSpecifiedPrecisionItemProvider(
			AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public String getText(Object object) {
		return "Exactly As Specified";
	};
}
