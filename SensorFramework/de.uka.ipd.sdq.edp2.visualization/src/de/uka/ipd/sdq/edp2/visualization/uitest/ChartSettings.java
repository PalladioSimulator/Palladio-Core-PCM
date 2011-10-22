package de.uka.ipd.sdq.edp2.visualization.uitest;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.layout.grouplayout.LayoutStyle;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.core.databinding.beans.PojoObservables;

public class ChartSettings extends Composite {
	private DataBindingContext m_bindingContext;

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtCaption;
	private Text txtXaxisText;
	private Text txtYaxisText;
	private Button btnShowCaption;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ChartSettings(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		
		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		toolkit.adapt(tabFolder);
		toolkit.paintBordersFor(tabFolder);
		
		TabItem tbtmCaption = new TabItem(tabFolder, SWT.NONE);
		tbtmCaption.setText("Caption");
		
		Composite compositeCaption = new Composite(tabFolder, SWT.NONE);
		tbtmCaption.setControl(compositeCaption);
		toolkit.paintBordersFor(compositeCaption);
		
		Group grpCaption = new Group(compositeCaption, SWT.NONE);
		grpCaption.setText("Caption");
		grpCaption.setBounds(10, 0, 208, 170);
		toolkit.adapt(grpCaption);
		toolkit.paintBordersFor(grpCaption);
		
		txtCaption = new Text(grpCaption, SWT.BORDER);
		txtCaption.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				handleCaptionTextChanged();
			}
		});
		txtCaption.setBounds(51, 46, 106, 21);
		txtCaption.setText("Caption");
		toolkit.adapt(txtCaption, true, true);
		
		Label lblCaptionText = new Label(grpCaption, SWT.NONE);
		lblCaptionText.setBounds(20, 49, 25, 15);
		toolkit.adapt(lblCaptionText, true, true);
		lblCaptionText.setText("Text:");
		
		btnShowCaption = new Button(grpCaption, SWT.CHECK);
		btnShowCaption.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				handleShowCaptionChanged();
			}
		});
		btnShowCaption.setBounds(10, 21, 93, 16);
		toolkit.adapt(btnShowCaption, true, true);
		btnShowCaption.setText("Show caption");
		
		Group grpXaxis = new Group(compositeCaption, SWT.NONE);
		grpXaxis.setText("x-Axis");
		grpXaxis.setBounds(223, 0, 193, 82);
		toolkit.adapt(grpXaxis);
		toolkit.paintBordersFor(grpXaxis);
		
		Button btnShowXaxisTitle = new Button(grpXaxis, SWT.CHECK);
		btnShowXaxisTitle.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnShowXaxisTitle.setBounds(10, 20, 103, 16);
		btnShowXaxisTitle.setText("Show axis title");
		toolkit.adapt(btnShowXaxisTitle, true, true);
		
		Label lblXaxisText = new Label(grpXaxis, SWT.NONE);
		lblXaxisText.setText("Text:");
		lblXaxisText.setBounds(20, 45, 25, 15);
		toolkit.adapt(lblXaxisText, true, true);
		
		txtXaxisText = new Text(grpXaxis, SWT.BORDER);
		txtXaxisText.setText("x-Axis");
		txtXaxisText.setBounds(53, 42, 106, 21);
		toolkit.adapt(txtXaxisText, true, true);
		
		Group grpYaxis = new Group(compositeCaption, SWT.NONE);
		grpYaxis.setText("y-Axis");
		grpYaxis.setBounds(224, 88, 192, 82);
		toolkit.adapt(grpYaxis);
		toolkit.paintBordersFor(grpYaxis);
		
		Button btnShowYaxisTitle = new Button(grpYaxis, SWT.CHECK);
		btnShowYaxisTitle.setBounds(10, 21, 95, 16);
		btnShowYaxisTitle.setText("Show axis title");
		toolkit.adapt(btnShowYaxisTitle, true, true);
		
		txtYaxisText = new Text(grpYaxis, SWT.BORDER);
		txtYaxisText.setText("y-Axis");
		txtYaxisText.setBounds(53, 43, 106, 21);
		toolkit.adapt(txtYaxisText, true, true);
		
		Label lblYaxisText = new Label(grpYaxis, SWT.NONE);
		lblYaxisText.setText("Text:");
		lblYaxisText.setBounds(20, 46, 25, 15);
		toolkit.adapt(lblYaxisText, true, true);
		
		TabItem tbtmDiagram = new TabItem(tabFolder, SWT.NONE);
		tbtmDiagram.setText("Diagram");
		
		TabItem tbtmOther = new TabItem(tabFolder, SWT.NONE);
		tbtmOther.setText("Other");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.LEADING)
				.add(groupLayout.createSequentialGroup()
					.add(11)
					.add(tabFolder, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.LEADING)
				.add(groupLayout.createSequentialGroup()
					.add(13)
					.add(tabFolder, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
		m_bindingContext = initDataBindings();

	}

	protected void handleCaptionTextChanged() {
		// TODO Auto-generated method stub
		
	}

	protected void handleShowCaptionChanged() {
		// TODO Auto-generated method stub
		
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		return bindingContext;
	}
}
