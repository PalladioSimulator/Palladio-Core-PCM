package de.uka.ipd.sdq.pcm.dialogs.variablenames;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.StoexFactory;

public class SetOutputVariableNameDialog extends TitleAreaDialog {

    private String DIALOG_TITLE = "Enter Local Variable Name for Storing Output Variable";
    private Text setNameText;
    private String result;

    private class SetNameValidationListener extends SelectionAdapter implements ModifyListener {
        public void modifyText(ModifyEvent e) {

            result = setNameText.getText();
        }
    }

    private SetNameValidationListener listener = new SetNameValidationListener();

    public SetOutputVariableNameDialog(Shell parentShell) {
        super(parentShell);
        // TODO Auto-generated constructor stub

    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        // container.setLayout(new FillLayout());
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        this.setTitle(DIALOG_TITLE);

        final GridLayout myGL = new GridLayout();
        myGL.numColumns = 2;
        container.setLayout(myGL);

        Label setNameLabel = new Label(container, SWT.NONE);
        setNameLabel.setText("Enter Local Variable Name:");
        setNameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

        setNameText = new Text(container, SWT.SINGLE | SWT.BORDER);
        setNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        setNameText.addModifyListener(listener);

        return super.createDialogArea(parent);
    }

    public String getResult() {
        return result;
    }

    @Override
    protected void cancelPressed() {
        // TODO Auto-generated method stub
        super.cancelPressed();
        result = null;
    }

    public AbstractNamedReference getOutputVariableReference() {
        String[] enteredNameSplitted = result.split("\\.");
        AbstractNamedReference namedReference = referenceFactory(enteredNameSplitted[enteredNameSplitted.length - 1],
                true);

        for (int i = enteredNameSplitted.length - 2; i >= 0; i--) {
            NamespaceReference nr = (NamespaceReference) referenceFactory(enteredNameSplitted[i], false);
            nr.setInnerReference_NamespaceReference(namedReference);
            namedReference = nr;
        }
        return namedReference;
    }

    /**
     * Create the AbstractNamedReference and set a string parameter
     */
    private AbstractNamedReference referenceFactory(String string, boolean shouldGenerateVariableReference) {
        AbstractNamedReference parameterReference = null;
        if (shouldGenerateVariableReference) {
            parameterReference = StoexFactory.eINSTANCE.createVariableReference();
        } else {
            parameterReference = StoexFactory.eINSTANCE.createNamespaceReference();
        }
        parameterReference.setReferenceName(string);
        return parameterReference;
    }

}
