/**
 * 
 */
package de.fzi.se.quality.qualityannotation.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

/**Text: none
 * @author groenda
 *
 */
public class DetailedNoPrecisionItemProvider extends NoPrecisionItemProvider {

	public DetailedNoPrecisionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public String getText(Object object) {
		return "None";
	};
}
