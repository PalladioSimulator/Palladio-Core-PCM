/**
 *
 */
package de.uka.ipd.sdq.sensorframework.visualisation.birt;

import java.util.List;

import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.ui.swt.interfaces.IUIServiceProvider;

/**
 * @author admin
 *
 */
public class UIServiceProvider implements IUIServiceProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IUIServiceProvider#getConvertedValue(double, java.lang.String, java.lang.String)
	 */

	public double getConvertedValue(double originalValue, String fromUnits,
			String toUnits) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IUIServiceProvider#getRegisteredKeys()
	 */

	public List getRegisteredKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IUIServiceProvider#getValue(java.lang.String)
	 */

	public String getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IUIServiceProvider#invoke(java.lang.String, java.lang.Object, java.lang.String)
	 */

	public String invoke(String expression, Object Context, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IUIServiceProvider#invoke(java.lang.String, java.lang.Object, java.lang.String, boolean)
	 */

	public String invoke(String expression, Object Context, String title,
			boolean isChartProvider) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IUIServiceProvider#invoke(int, java.lang.String, java.lang.Object, java.lang.String)
	 */

	public String invoke(int command, String value, Object context, String title)
			throws ChartException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IUIServiceProvider#isInvokingSupported()
	 */

	public boolean isInvokingSupported() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IUIServiceProvider#validate(org.eclipse.birt.chart.model.Chart, java.lang.Object)
	 */

	public String[] validate(Chart chartModel, Object context) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean isEclipseModeSupported() {
		// TODO Auto-generated method stub
		return false;
	}

}
