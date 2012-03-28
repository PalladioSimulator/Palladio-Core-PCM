/**
 *
 */
package de.uka.ipd.sdq.sensorframework.visualisation.birt;

import java.util.List;

import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.model.attribute.DataType;
import org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider;

/**
 * @author admin
 *
 */
public class DataServiceProvider implements IDataServiceProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#dispose()
	 */
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#getAllDataSets()
	 */
	public String[] getAllDataSets() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#getAllStyleDisplayNames()
	 */
	public String[] getAllStyleDisplayNames() {
		return new String[]{};
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#getAllStyles()
	 */
	public String[] getAllStyles() {
		return new String[]{};
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#getBoundDataSet()
	 */
	public String getBoundDataSet() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#getCurrentStyle()
	 */
	public String getCurrentStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#getDataForColumns(java.lang.String[], int, boolean)
	 */

	public Object[] getDataForColumns(String[] expressions, int maxRecords,
			boolean byRow) throws ChartException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#getDataType(java.lang.String)
	 */

	public DataType getDataType(String expression) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#getPreviewData()
	 */

	public List getPreviewData() throws ChartException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#getPreviewHeader()
	 */

	public String[] getPreviewHeader() throws ChartException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#getReportDataSet()
	 */

	public String getReportDataSet() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#invoke(int)
	 */

	public int invoke(int command) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#isInvokingSupported()
	 */

	public boolean isInvokingSupported() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#isLivePreviewEnabled()
	 */

	public boolean isLivePreviewEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#setContext(java.lang.Object)
	 */

	public void setContext(Object context) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#setDataSet(java.lang.String)
	 */

	public void setDataSet(String datasetName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider#setStyle(java.lang.String)
	 */

	public void setStyle(String styleName) {
		// TODO Auto-generated method stub

	}


	public boolean isEclipseModeSupported() {
		// TODO Auto-generated method stub
		return false;
	}


	public String[] getAllReportItemReferences() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getReportItemReference() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setReportItemReference(String arg0) {
		// TODO Auto-generated method stub

	}

}
