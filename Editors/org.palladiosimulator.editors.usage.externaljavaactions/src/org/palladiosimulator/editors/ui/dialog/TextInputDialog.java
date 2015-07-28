package org.palladiosimulator.editors.ui.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TextInputDialog extends Dialog {
    
    private String textToDisplay;
    private String result = null;

    public TextInputDialog(Shell parent, int style, String text) {
        super(parent, style);
        setText("Edit stoachstic expression");
        this.textToDisplay = text;
    }

    public Object open() {        
        Shell parent = getParent();
        Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
        shell.setText(getText());
        shell.setSize(500, 250);
        GridLayout g = new GridLayout();
        g.numColumns = 1;
        shell.setLayout(g);

        Label l = new Label(shell, SWT.NONE);
        l.setText("Edit a stochastic expression");
        Text t = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
        t.setLayoutData(new GridData(GridData.FILL_BOTH));
        t.setText(textToDisplay);

        Composite buttonCmp = new Composite(shell, SWT.EMBEDDED);
        FillLayout fl = new FillLayout();
        fl.marginWidth = shell.getSize().x / 2;
        buttonCmp.setLayout(fl);

        Button btnOk = new Button(buttonCmp, SWT.NONE);
        Button btnClose = new Button(buttonCmp, SWT.NONE);

        btnOk.setText("Okay");
        btnOk.setSize(200, btnOk.getSize().y);
        btnClose.setText("Close");
        btnClose.setSize(200, btnClose.getSize().y);
        btnClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
                result = null;
                shell.dispose();
            }
        });
        btnOk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
                result = t.getText();
                shell.dispose();
            }
        });

        shell.open();
        Display display = parent.getDisplay();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        return result;
    }
}
