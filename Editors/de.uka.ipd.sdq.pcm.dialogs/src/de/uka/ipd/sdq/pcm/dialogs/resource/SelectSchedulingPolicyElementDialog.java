package de.uka.ipd.sdq.pcm.dialogs.resource;


import org.eclipse.jface.dialogs.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;


import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;

public class SelectSchedulingPolicyElementDialog extends TitleAreaDialog{

	private SchedulingPolicy policy = null;
	private Button CANCELbutton;
	
	public SelectSchedulingPolicyElementDialog(Shell parentShell/*, SchedulingPolicy policy*/) {
		super(parentShell);
		//this.policy = policy;
	}

	public boolean close() {
		return super.close();
	}
	
	protected Control createContents(Composite parent) {
	    Control contents = super.createContents(parent);

	    // Set the title
	    setTitle("Scheduling Policy");

	    // Set the message
	    setMessage("Select a scheduling policy", IMessageProvider.INFORMATION);
	    return contents;
	  }
	
	protected Control createDialogArea(Composite parent) {
	    Composite composite = (Composite) super.createDialogArea(parent);

	    // Create a table
	    final Table table = new Table(composite, SWT.FULL_SELECTION | SWT.BORDER);
	    table.setLayoutData(new GridData(GridData.FILL_BOTH));

	    // Create two columns and show
	    TableColumn one = new TableColumn(table, SWT.LEFT);
	    one.setText("Scheduling Policy");

	    table.setHeaderVisible(true);

	    // Add data to table
	    TableItem item;
	    for (SchedulingPolicy pol : SchedulingPolicy.VALUES) {
	    	item = new TableItem(table, SWT.NONE);
	    	item.setText(0,pol.getName());
	    }
	    one.pack();
	    
	    table.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event e) {
	          TableItem[] selection = table.getSelection();
	          policy = SchedulingPolicy.get(selection[0].getText());
	        }
	      });
	    table.addListener(SWT.DefaultSelection, new Listener() {
	        public void handleEvent(Event e) {
	          TableItem[] selection = table.getSelection();
	          policy = SchedulingPolicy.get(selection[0].getText());
	          close();
	        }
	      });

	    return composite;
	  }
	
	protected void createButtonsForButtonBar(Composite parent) {
		CANCELbutton = createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
		CANCELbutton.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				policy = null;
			}
		});
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}
	
	public SchedulingPolicy getResult() {
		return policy;
	}

}
