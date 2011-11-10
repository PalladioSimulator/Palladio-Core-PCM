/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.properties;

import java.io.Serializable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Dominik Ernst
 *
 */
public abstract class SpecificChartProperties implements Serializable {
	
	/**
	 * Default style for composites.
	 */
	protected static final int STYLE = SWT.EMBEDDED;
	/**
	 * Serial UUID.
	 */
	private static final long serialVersionUID = 6520860186613737249L;

	/**
	 * Empty Constructor.
	 */
	public SpecificChartProperties() {
	}
	/**
	 * Returns a composite, which is responsible for displaying the properties in an appropriate way.
	 * @return
	 */
	public abstract Composite retrieveComposite(Composite parent);
	

}
