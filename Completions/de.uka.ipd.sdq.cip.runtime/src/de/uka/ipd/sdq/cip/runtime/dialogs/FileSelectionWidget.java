/**
 * 
 */
package de.uka.ipd.sdq.cip.runtime.dialogs;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;

class FileSelectionWidget extends Composite{

	private Label label;
	private Text textfield;
	private Button workspaceButton;
	private Button filesystemButton;
	
	private String[] fileExtensions;

	public FileSelectionWidget(Composite parent, int style) {
		super(parent, style);
		GridLayout layout = new GridLayout(3,false);
		setLayout(layout);
		
		label = new Label(this, SWT.LEFT);
		label.setText("DUMMY");
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		label.setLayoutData(gd);
		
		workspaceButton = createButton(this, WORKSPACE);
		gd = new GridData();
		workspaceButton.setLayoutData(gd);
		
		filesystemButton = createButton(this, FILESYSTEM);
		gd = new GridData();
		filesystemButton.setLayoutData(gd);
		
		textfield = new Text(this,SWT.BORDER);
		gd = new GridData();
		gd.horizontalSpan = layout.numColumns;
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.verticalAlignment = SWT.TOP;
		textfield.setLayoutData(gd);
		
	}
	
	public void setCaption(String caption) {
		label.setText(caption);
	}
	public void setFileExtensions(String[] fileExtensions) {
		this.fileExtensions = fileExtensions;
	}
	
	public void setText(String text) {
		textfield.setText(text);
	}
	
	public String getText() {
		return textfield.getText();
	}
	
	private final static int FILESYSTEM = 2;
	private final static int WORKSPACE = 1;
	
	private Button createButton(Composite parent, int style) {
		Button button = new Button(parent,SWT.PUSH);
		if((style & WORKSPACE) == WORKSPACE) {
			button.setText("Browse &Workspace...");
		}
		else {
			button.setText("Browse &File System...");
			
		}
		button.addSelectionListener(new ButtonSelectionListener(this,style));
		return button;
	}

	public boolean browseWorkspace() {
		/*ResourceSelectionDialog resourceSelectionDialog = new ResourceSelectionDialog(
		  getShell(),
		  ResourcesPlugin.getWorkspace().getRoot(),
		  "File Selection");*/
		
		FilteredResourcesSelectionDialog resourceSelectionDialog = new FilteredResourcesSelectionDialog(getShell(), false, ResourcesPlugin.getWorkspace().getRoot(),IResource.DEPTH_INFINITE | IResource.FILE);
		resourceSelectionDialog.open();
		Object [] result = resourceSelectionDialog.getResult();
		if (result != null)
		{
		  StringBuffer  text = new StringBuffer ();
		  int length = result.length;
		  for (int i = 0; i < length; ++i)
		  {
		    IResource resource = (IResource)result[i];
		    //if (isValidWorkspaceResource(resource))
		    {
		      text.append(URI.createURI(URI.createPlatformResourceURI(resource.getFullPath().toString(),true).toString(), true));
		      text.append(" ");
		    }
		  }
		  textfield.setText(text.toString().trim());
		  return true;
		}
		return false;
	}

	private boolean browseFileSystem() {
		FileDialog fileDialog = new FileDialog(getShell(), SWT.OPEN | SWT.MULTI );
		fileDialog.setFilterExtensions(fileExtensions);
		
		if (textfield.getText() != null)
		{
		  fileDialog.setFileName(textfield.getText());
		}
		
		if (fileDialog.open() != null && fileDialog.getFileNames().length > 0)
		{
		  String [] fileNames = fileDialog.getFileNames();
		  StringBuffer  text = new StringBuffer ();
		  for (int i = 0; i < fileNames.length; ++i)
		  {
		    String  filePath = fileDialog.getFilterPath() + File.separator + fileNames[i];
		    text.append(URI.createFileURI(filePath).toString());
		    text.append(" ");
		  }
		  textfield.setText(text.toString().trim());
		  
		  return true;
		}
		return false;
	}
	
	private class ButtonSelectionListener implements SelectionListener {
		FileSelectionWidget widget;
		int style;

		public ButtonSelectionListener(FileSelectionWidget fileSelectionWidget, int style) {
			widget = fileSelectionWidget;
			this.style = style;
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			if((style & WORKSPACE) == WORKSPACE) {
				widget.browseWorkspace();
			}
			else {
				widget.browseFileSystem();
				
			}
		}
		
	}
}