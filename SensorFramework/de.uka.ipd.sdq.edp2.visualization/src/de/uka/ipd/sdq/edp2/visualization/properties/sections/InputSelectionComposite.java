package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;

import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInputHandle;

public class InputSelectionComposite extends Composite {

	private ComboViewer comboViewer;
	private Combo combo_1;
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public InputSelectionComposite(Composite parent, int style,
			final JFreeChartEditorInputHandle inputHandle) {
		super(parent, SWT.EMBEDDED);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(null);

		comboViewer = new ComboViewer(this, SWT.NONE);

		comboViewer.setLabelProvider(new ILabelProvider() {

			@Override
			public void removeListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean isLabelProperty(Object element, String property) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void dispose() {
				// TODO Auto-generated method stub

			}

			@Override
			public void addListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub

			}

			@Override
			public String getText(Object element) {
				return ((JFreeChartEditorInput) element).getInputName();
			}

			@Override
			public Image getImage(Object element) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		comboViewer.setContentProvider(new IStructuredContentProvider() {
			public Object[] getElements(Object inputElement) {
				return ((JFreeChartEditorInputHandle) inputElement).getInputs()
						.toArray();
			}

			public void dispose() {
			}

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}
		});
		comboViewer.setInput(inputHandle);
		combo_1 = comboViewer.getCombo();
		combo_1.setBounds(0, 0, 177, 23);
		toolkit.paintBordersFor(combo_1);

	}

	public JFreeChartEditorInput getInputSelection() {
		IStructuredSelection selection = (IStructuredSelection) comboViewer
				.getSelection();
		return (JFreeChartEditorInput) selection.getFirstElement();
	}

	/**
	 * @return the combo_1
	 */
	public Combo getComboBox() {
		return combo_1;
	}
}
