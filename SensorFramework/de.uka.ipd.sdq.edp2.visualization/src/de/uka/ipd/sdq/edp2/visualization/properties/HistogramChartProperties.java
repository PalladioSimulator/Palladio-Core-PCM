/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import de.uka.ipd.sdq.edp2.visualization.editors.HistogramEditorInput;
import de.uka.ipd.sdq.edp2.visualization.properties.sections.HistogramChartPropertiesComposite;

/**
 * Wrapper class to handle changes in the chart's properties via the "Display"
 * property section.
 * 
 * @author Dominik Ernst
 * 
 */
public class HistogramChartProperties extends SpecificChartProperties {
	
	/**
	 * UUID.
	 */
	private static final long serialVersionUID = -2053315828380687395L;

	/**
	 * The number of bins.
	 */
	private int numberOfBins;
	
	/**
	 * The associated {@link HistogramEditorInput}.
	 */
	private HistogramEditorInput input;

	/**
	 * Empty constructor;
	 */
	public HistogramChartProperties() {
		super();
	}

	/**
	 * Default constructor.
	 * 
	 * @param input
	 *            the input of the associated {@link HistogramEditorInput}.
	 */
	public HistogramChartProperties(HistogramEditorInput input) {
		super();
		setInput(input);
		this.numberOfBins = Integer.parseInt(input.getProperties().get("numberOfBins").toString());
	}

	/**
	 * @return the numberOfBins
	 */
	public int getNumberOfBins() {
		return numberOfBins;
	}

	/**
	 * @param numberOfBins
	 *            the numberOfBins to set
	 */
	public void setNumberOfBins(int numberOfBins) {
		this.numberOfBins = numberOfBins;
		input.updateChartProperties();
	}
	
	/**
	 * @return the input
	 */
	public HistogramEditorInput getInput() {
		return input;
	}

	/**
	 * @param input the input to set
	 */
	public void setInput(HistogramEditorInput input) {
		this.input = input;
	}
	
	@Override
	public Composite retrieveComposite(Composite parent) {
		return new HistogramChartPropertiesComposite(parent, STYLE, this);
	}

}
