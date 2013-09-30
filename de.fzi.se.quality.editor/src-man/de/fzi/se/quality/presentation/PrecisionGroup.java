/**
 * 
 */
package de.fzi.se.quality.presentation;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision;
import de.fzi.se.quality.qualityannotation.Precision;
import de.fzi.se.quality.qualityannotation.QualityAnnotationFactory;

/**Creates a SWT Group for {@link Precision} selection.
 * @author groenda
 *
 */
public class PrecisionGroup implements SelectionListener {
	/** Name of the group. */
	private String groupName;
	
	/** Text field containing the absolute precision. */
	private Text textAbsolute;
	/** Text field containing the relative precision. */
	private Text textRelative;
	
	private Group grp;
	private Button btnNoAccuracy;
	private Button btnExactylAsSpecified;
	private Button btnLimitedDeviationPrecision;
	private final ModifyListener listener;
	
	/**Creates a new instance.
	 * @param groupName Name used for the group
	 */
	PrecisionGroup(String groupName, ModifyListener listener) {
		this.groupName = groupName;
		this.listener = listener;
	}
	
	/**Creates all controls for the group in the given parent.
	 * @param parent Parent control.
	 */
	public void createGroup(Composite parent) {
		grp = new Group(parent, SWT.NONE);
		grp.setText(groupName);
		grp.setLayout(new GridLayout(1, false));
		
		btnNoAccuracy = new Button(grp, SWT.RADIO);
		btnNoAccuracy.setSelection(true);
		btnNoAccuracy.setText("No Precision");
		
		btnExactylAsSpecified = new Button(grp, SWT.RADIO);
		btnExactylAsSpecified.setText("Exactly As Specified");
		
		btnLimitedDeviationPrecision = new Button(grp, SWT.RADIO);
		btnLimitedDeviationPrecision.addSelectionListener(this);
		btnLimitedDeviationPrecision.setText("Limited Deviation Precision");
		
		Composite composite = new Composite(grp, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		composite.setLayout(new GridLayout(2, false));
		
		textAbsolute = new Text(composite, SWT.BORDER);
		textAbsolute.setEnabled(false);
		textAbsolute.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textAbsolute.setToolTipText("Provide the absolute deviation. This is a value greater or equal to 0.");
		textAbsolute.addModifyListener(listener);
		
		Label lblAbsoluteDeviation = new Label(composite, SWT.NONE);
		lblAbsoluteDeviation.setText("Absolute");
		
		textRelative = new Text(composite, SWT.BORDER);
		textRelative.setEnabled(false);
		textRelative.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textRelative.setToolTipText("Provide the relative deviation. This is a value in the interval (0,1].");
		textRelative.addModifyListener(listener);
		
		Label lblRelative = new Label(composite, SWT.NONE);
		lblRelative.setText("Relative");
	}

	/**Provides an instance according to the selection.
	 * @return Selected {@link Precision} 
	 */
	public Precision getPrecision() {
		if (btnNoAccuracy.getSelection()) {
			return QualityAnnotationFactory.eINSTANCE.createNoPrecision();
		}
		if (btnExactylAsSpecified.getSelection()) {
			return QualityAnnotationFactory.eINSTANCE.createExactlyAsSpecifiedPrecision();
		}
		if (btnLimitedDeviationPrecision.getSelection()) {
			LimitedDeviationPrecision precision = QualityAnnotationFactory.eINSTANCE.createLimitedDeviationPrecision();
			precision.setAbsolute(new Double(textAbsolute.getText()));
			precision.setRelative(new Double(textRelative.getText()));
			return precision;
		}
		throw new IllegalStateException("Selection state not know to the implementation.");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		if (btnLimitedDeviationPrecision.getSelection() == true) {
			textAbsolute.setEnabled(true);
			textRelative.setEnabled(true);
		} else {
			textAbsolute.setEnabled(false);
			textAbsolute.setText("");
			textRelative.setEnabled(false);
			textRelative.setText("");
		}
		listener.modifyText(null);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// do nothing
	}

	/**Checks if the selection is valid.
	 * @return <code>true</code> if it is valid, false otherwise.
	 */
	public boolean isValid() {
		return getErrorMessage() == null;
	}
	
	/**Provides an error message if the selection is not valid.
	 * @return Error message or <code>null</code> if there is no error.
	 */
	public String getErrorMessage() {
		if (btnLimitedDeviationPrecision.getSelection() == true) {
			if (textAbsolute.getText().isEmpty()) {
				return "Enter a value for the absolute precision.";
			}
			if (textRelative.getText().isEmpty()) {
				return "Enter a value for the relative precision.";
			}
			try {
				if (new Double(textAbsolute.getText()) < 0) {
					return "The absolute precision must be greater or equal to one.";
				} 
			} catch (NumberFormatException nfe) {
				return "Absolute precision is not a number.";
			}
			try {
				if (new Double(textRelative.getText()) <= 0) {
					return "The relative precision must be greater than 0.";
				}
				if (new Double(textRelative.getText()) > 1) {
					return "The relative precision must be smaller or equal to 1.";
				}
			} catch (NumberFormatException nfe) {
				return "Relative precision is not a number.";
			}
		}
		return null;
	}
	
	/**Disposes all created listeners.
	 */
	public void dispose() {
		btnLimitedDeviationPrecision.removeSelectionListener(this);
		textAbsolute.removeModifyListener(listener);
		textRelative.removeModifyListener(listener);
	}
}
