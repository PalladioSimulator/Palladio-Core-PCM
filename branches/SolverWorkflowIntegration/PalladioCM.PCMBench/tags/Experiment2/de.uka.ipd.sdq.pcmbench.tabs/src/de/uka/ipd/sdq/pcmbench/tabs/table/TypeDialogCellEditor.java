package de.uka.ipd.sdq.pcmbench.tabs.table;

import java.text.MessageFormat;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import de.uka.ipd.sdq.dialogs.datatype.CallDataTypeDialog;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Repository;

/**
 * @author admin
 * 
 */
public class TypeDialogCellEditor extends DialogCellEditor {

	 /**
     * The editor control.
     */
    private Composite editor;

    /**
     * The current contents.
     */
    private Control contents;

    /**
     * The button.
     */
    private Button selButton;
    private Button delButton;
    
    /**
	 * Listens for 'focusLost' events and  fires the 'apply' event as long
	 * as the focus wasn't lost because the dialog was opened.
	 */
	private FocusListener buttonFocusListener;
	
	/**
     * The value of this cell editor; initially <code>null</code>.
     */
    private Object value = null;
	
	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */

	protected TransactionalEditingDomain editingDomain = null; // TransactionalEditingDomain.Registry.INSTANCE
	//		.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);
	

	/* @See org.eclipse.jface.viewers.DialogCellEditor#DialogCellEditor(org.eclipse.swt.widgets.Control
	 *      parent)
	 */
	public TypeDialogCellEditor(Composite parent) {
		super(parent, SWT.DEL);
	}

	public void setEditingDomain(TransactionalEditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.DialogCellEditor#openDialogBox(org.eclipse.swt.widgets.Control)
	 */
	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
		
		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(DataType.class);
		filterList.add(Repository.class);
		ArrayList<Object> additionalReferences = new ArrayList<Object>();

		CallDataTypeDialog dialog = new CallDataTypeDialog(
				cellEditorWindow.getShell(),
				filterList,
				additionalReferences,
				editingDomain.getResourceSet());
		dialog.setProvidedService(DataType.class);
		dialog.open();

		if (!(dialog.getResult() instanceof DataType))
			return null;
		
		return dialog.getResult();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.DialogCellEditor#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createControl(Composite parent) {

		Font font = parent.getFont();
		Color bg = parent.getBackground();

		editor = new Composite(parent, getStyle());
		editor.setFont(font);
		editor.setBackground(bg);

		contents = createContents(editor);
		updateContents(value);


		delButton = new Button(editor, SWT.DOWN);
		delButton.setText("X");
		delButton.setFont(font);
		delButton.addSelectionListener(new DeleteCellValueListener());

		selButton = createButton(editor);
		selButton.setFont(font);
		editor.setLayout(new DialogCellLayout(contents, selButton, delButton));
		selButton.addKeyListener(new KeyAdapter() {
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.KeyListener#keyReleased(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyReleased(KeyEvent e) {
				if (e.character == '\u001b') { // Escape
					fireCancelEditor();
				}
			}
		});

		selButton.addFocusListener(getButtonFocusListener());
		selButton.addSelectionListener(new SelectionAdapter() {
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent event) {
				// Remove the button's focus listener since it's guaranteed
				// to lose focus when the dialog opens
				selButton.removeFocusListener(getButtonFocusListener());

				Object newValue = openDialogBox(editor);

				// Re-add the listener once the dialog closes
				selButton.addFocusListener(getButtonFocusListener());

				if (newValue != null) {
					boolean newValidState = isCorrect(newValue);
					if (newValidState) {
						markDirty();
						doSetValue(newValue);
					} else {
						// try to insert the current value into the error
						// message.
						setErrorMessage(MessageFormat.format(getErrorMessage(),
								new Object[] { newValue.toString() }));
					}
					fireApplyEditorValue();
				}
			}
		});

		setValueValid(true);

		return editor;
	}
	

	 /**
	 * Return a listener for button focus.
	 * 
	 * @return FocusListener
	 */
	private FocusListener getButtonFocusListener() {
		if (buttonFocusListener == null) {
			buttonFocusListener = new FocusListener() {

				/* (non-Javadoc)
				 * @see org.eclipse.swt.events.FocusListener#focusGained(org.eclipse.swt.events.FocusEvent)
				 */
				public void focusGained(FocusEvent e) {
					// Do nothing
				}

				/* (non-Javadoc)
				 * @see org.eclipse.swt.events.FocusListener#focusLost(org.eclipse.swt.events.FocusEvent)
				 */
				public void focusLost(FocusEvent e) {
					TypeDialogCellEditor.this.focusLost();
				}
			};
		}

		return buttonFocusListener;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.DialogCellEditor#doSetFocus()
	 */
	@Override
	protected void doSetFocus() {
		 selButton.setFocus();
	        
	     // add a FocusListener to the button
	     //selButton.addFocusListener(getButtonFocusListener());
	}

	@Override
	protected void doSetValue(Object value) {
		super.doSetValue(value);
	}

}
