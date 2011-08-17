package de.uka.ipd.sdq.cip.runtime.dialogs;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;

import de.uka.ipd.sdq.cip.completions.RegisteredCompletion;
import de.uka.ipd.sdq.cip.completions.RegisteredCompletions;
import de.uka.ipd.sdq.cip.configuration.Transformation;
import de.uka.ipd.sdq.cip.configuration.TransformationType;
import de.uka.ipd.sdq.cip.runtime.ConstantsContainer;

@Deprecated
public class EditCompletionDialog_OLD extends TitleAreaDialog {

	private Button featureconfig;
	private Text featureconfigLocation;
	private Button annotated;
	private Text annotationLocation;
	private Text annotationCompletionType;
	private Text plainCompletionType;
	private Button plain;
	private Button plainQVTO;
	private Text plainQVTOCompletionType;
	private Transformation transformation;

	public EditCompletionDialog_OLD(Shell parentShell,Transformation transformation) {
		super(parentShell);
		this.transformation = transformation;
		setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE | SWT.APPLICATION_MODAL);
	}

	@Override
	protected void okPressed() {
		if(featureconfig.getSelection()) {
			transformation.setType(TransformationType.FEATURE);
			transformation.setFeatureFileURI(featureconfigLocation.getText());
		}
		else if(annotated.getSelection()) {
			transformation.setType(TransformationType.ANNOTATED);
			transformation.setConfigFileURI(annotationLocation.getText());
			transformation.setQVTFileURI(annotationCompletionType.getText());
		}
		else if(plain.getSelection()) {
			transformation.setType(TransformationType.PLAIN);
			transformation.setQVTFileURI(plainCompletionType.getText());
		} 
		/*else if(plainQVTO.getSelection()) {
			transformation.setType(TransformationType.PLAINQVTO);
			transformation.setQVTFileURI(plainQVTOCompletionType.getText());
		} */

		super.okPressed();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Select completion type");
		setMessage("Select one completion type and configure it");
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout(1,false);
		container.setLayout(layout);
		
		featureconfig = createRadioButton(container, "Feature Config");
		featureconfigLocation = createFileLocation(container, "Feature &Config File",new String[] {"*.featureconfig"});
		
		annotated = createRadioButton(container, "Annotated Completion");
		annotationCompletionType = createFileLocation(container, "Completion",null);
		annotationLocation = createFileLocation(container, "Annotation File", new String[] {"*.*"});
		
		plain = createRadioButton(container, "Plain Completion");
		plainCompletionType = createFileLocation(container, "Completion",null);
		
		plainQVTO = createRadioButton(container, "Plain QVTO Completion");
		plainQVTOCompletionType = createFileLocation(container, "Completion",null);
		
		featureconfig.setSelection(true);
		activateGroup(featureconfig);
		
		//container.getShell().setSize(500, 400);
		return container;
	}
	
	Button createRadioButton(Composite parent, String caption) {
		Button radio = new Button(parent, SWT.RADIO);
		radio.setText(caption);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		radio.setLayoutData(gd);
		radio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				activateGroup(e.widget);
			}
		});
		return radio;
	}
	
	protected void activateGroup(Widget widget) {
		if(widget == featureconfig){
			featureconfigLocation.getParent().setVisible(true);
			annotationCompletionType.getParent().setVisible(false);
			annotationLocation.getParent().setVisible(false);
			plainCompletionType.getParent().setVisible(false);
		}
		else if(widget == annotated){
			featureconfigLocation.getParent().setVisible(false);
			annotationCompletionType.getParent().setVisible(true);
			annotationLocation.getParent().setVisible(true);
			plainCompletionType.getParent().setVisible(false);
		}
		else if(widget == plain){
			featureconfigLocation.getParent().setVisible(false);
			annotationCompletionType.getParent().setVisible(false);
			annotationLocation.getParent().setVisible(false);
			plainCompletionType.getParent().setVisible(true);
		}
		else if(widget == plainQVTO){
			featureconfigLocation.getParent().setVisible(false);
			annotationCompletionType.getParent().setVisible(false);
			annotationLocation.getParent().setVisible(false);
			plainQVTOCompletionType.getParent().setVisible(true);
		}
		
	}

	Text createFileLocation(Composite parent, String caption, final String[] fileExtensions) {
		Composite comp = new Composite(parent, SWT.BORDER);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.horizontalIndent = 20;
		comp.setLayoutData(gd);
		GridLayout layout = new GridLayout(2,false);
		comp.setLayout(layout);
		
		Label label = new Label(comp, SWT.LEFT);
		label.setText(caption);
		gd = new GridData();
		gd.horizontalSpan = 2;
		label.setLayoutData(gd);
		final Text text = new Text(comp, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		text.setLayoutData(gd);
		
		Button edit = new Button(comp, SWT.PUSH);
		edit.setText("...");
		edit.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileSelectionDialog editDialog = new FileSelectionDialog(getShell(), text.getText(),fileExtensions);
				if(editDialog.open() == FileSelectionDialog.OK) {
					text.setText(editDialog.getFileLocation());
				}
			}
		});
		
		return text;
	}
	
	static class FileSelectionDialog extends Dialog {

		private String fileLocation;
		private String[] fileExtensions;
		final String tooltipTemplate;

		protected FileSelectionDialog(Shell parentShell,String fileLocation, String[] fileExtensions) {
			super(parentShell);
			this.fileLocation = fileLocation;
			this.fileExtensions = fileExtensions;
			StringBuffer contentOfFile = null;
			try {
				BufferedReader br = new BufferedReader(
				           new InputStreamReader(
				        		   getClass().getResourceAsStream(ConstantsContainer.HTML_TOOLTIP))); 
				contentOfFile = new StringBuffer();
				String line;
				while ((line = br.readLine()) != null) {
				    contentOfFile.append(line);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(contentOfFile != null)
				tooltipTemplate = contentOfFile.toString();
			else
				tooltipTemplate = null;
			
		}
	
		@Override
		protected Control createDialogArea(Composite parent) {
			Composite comp =  (Composite) super.createDialogArea(parent);
			GridLayout layout = new GridLayout();
			comp.setLayout(layout);
			
			Composite upperContainer = new Composite(comp, SWT.None);
			GridData gd = new GridData();
			gd.horizontalAlignment = SWT.FILL;
			gd.grabExcessHorizontalSpace = true;
			gd.verticalAlignment = SWT.FILL;
			gd.grabExcessVerticalSpace = true;
			upperContainer.setLayoutData(gd);
			GridLayout upperLayout = new GridLayout();
			upperContainer.setLayout(upperLayout);
			
			Label label = new Label(upperContainer, SWT.LEFT);
			label.setText("Completion Library:");
			gd = new GridData();
	        gd.grabExcessHorizontalSpace = true;
	        gd.horizontalAlignment = GridData.FILL;
	        label.setLayoutData(gd);

			
			final TableViewer tableViewer = new TableViewer(upperContainer);
			gd = new GridData();
		    gd.grabExcessHorizontalSpace = true;
		    gd.horizontalAlignment = GridData.FILL;
		    gd.grabExcessVerticalSpace = true;
		    gd.verticalAlignment = GridData.FILL;
		    gd.heightHint = 200;
		    gd.widthHint = 350;
		    tableViewer.getTable().setLayoutData(gd);

			
			Composite lowerContainer = new Composite(comp, SWT.None);
			gd = new GridData();
			gd.horizontalAlignment = SWT.FILL;
			gd.grabExcessHorizontalSpace = true;
			lowerContainer.setLayoutData(gd);
			GridLayout lowerLayout = new GridLayout(4,false);
			lowerContainer.setLayout(lowerLayout);
			
			final Text text = new Text(parent,SWT.BORDER);

			label = new Label(lowerContainer, SWT.LEFT);
			label.setText("Path:");
			gd = new GridData();
	    	label.setLayoutData(gd);

			//Button browseWorkspaceButton = DialogHelper.createBrowseWorkspaceButton(lowerContainer, text);
			gd = new GridData();
			//browseWorkspaceButton.setLayoutData(gd);

		
			//Button browseFileSystemButton = DialogHelper.createBrowseFileSystemButton(lowerContainer, text, fileExtensions);
			gd = new GridData();
			//browseFileSystemButton.setLayoutData(gd);
			
			//text = new Text(comp,SWT.BORDER);
			text.setParent(lowerContainer);
			text.setText(fileLocation);
			gd = new GridData();
			gd.horizontalSpan = 4;
			gd.horizontalAlignment = SWT.FILL;
			gd.grabExcessHorizontalSpace = true;
			text.setLayoutData(gd);
			
			text.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent e) {
					fileLocation = text.getText();					
				}
			});
			
			tableViewer.setContentProvider(new ArrayContentProvider());
			tableViewer.setLabelProvider(RegisteredCompletions.getLabelProvider());
			tableViewer.setInput(RegisteredCompletions.getCompletions());
			tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
				
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					IStructuredSelection selection = (IStructuredSelection) event.getSelection();
					RegisteredCompletion rc = (RegisteredCompletion) selection.getFirstElement();
					text.setText(rc.getQvtscript());
					
				}
			});
			
			final Listener labelListener = new Listener () {
				
				@Override
				public void handleEvent (Event event) {
					Composite composite = (Composite)event.widget;
					Shell shell = composite.getShell ();
					switch (event.type) {
						case SWT.MouseDown:
							Event e = new Event ();
							e.item = (TableItem) composite.getData ("_TABLEITEM");
							// Assuming table is single select, set the selection as if
							// the mouse down event went through to the table
							tableViewer.getTable().setSelection (new TableItem [] {(TableItem) e.item});
							tableViewer.getTable().notifyListeners (SWT.Selection, e);
							shell.dispose ();
							tableViewer.getTable().setFocus();
							break;
						case SWT.MouseExit:
							shell.dispose ();
							break;
					}
				}
			};

			
			Listener tableListener = new Listener() {
				
				@Override
				public void handleEvent(Event event) {
					Shell tip = null;
					Composite composite = null;

					switch (event.type) {
						case SWT.Dispose:
						case SWT.KeyDown:
						case SWT.MouseMove: {
							if (tip == null) break;
							tip.dispose ();
							tip = null;
							composite = null;
							break;
						}
						case SWT.MouseHover: {
							Point coords = new Point(event.x, event.y);
							TableItem item = tableViewer.getTable().getItem(coords);
							if (item != null) {
								int columns = tableViewer.getTable().getColumnCount();

							for (int i = 0; i < columns || i == 0; i++) {
								if (item.getBounds(i).contains(coords)) {
									if (tip != null  && !tip.isDisposed ()) tip.dispose ();
									tip = new Shell (tableViewer.getTable().getShell(), SWT.ON_TOP | SWT.NO_FOCUS | SWT.TOOL);
									tip.setBackground (tableViewer.getTable().getDisplay().getSystemColor (SWT.COLOR_INFO_BACKGROUND));
									FillLayout layout = new FillLayout ();
									layout.marginWidth = 2;
									tip.setLayout (layout);
									composite = new Composite (tip, SWT.NONE);
									composite.setForeground (tableViewer.getTable().getDisplay().getSystemColor (SWT.COLOR_INFO_FOREGROUND));
									composite.setBackground (tableViewer.getTable().getDisplay().getSystemColor (SWT.COLOR_INFO_BACKGROUND));
									composite.setData ("_TABLEITEM", item);
									//composite.setText ("Tooltip: " + item.getData()+ " => Column: " + i);
									populateTip(composite,(RegisteredCompletion)item.getData());
									composite.addListener (SWT.MouseExit, labelListener);
									composite.addListener (SWT.MouseDown, labelListener);
									//Point size = tip.computeSize (SWT.DEFAULT, SWT.DEFAULT);
									//Rectangle rect = item.getBounds (i);
									//Point pt = tableViewer.getTable().toDisplay (rect.x, rect.y);
									//tip.setBounds (pt.x, pt.y, size.x, size.y);
									//tip.setVisible (true);
									break;
								}
							}
						}
					}
				}

					
				}
				
				class SizeCallbackFunction extends BrowserFunction {
					SizeCallbackFunction (Browser browser, String name) {
						super (browser, name);
					}
					public Object function (Object[] arguments) {
						int width = ((Double)arguments[0]).intValue();
						int height = ((Double)arguments[1]).intValue();
						Shell tip = getBrowser().getShell();
						TableItem item = (TableItem) getBrowser().getParent().getData ("_TABLEITEM");
						tip.setSize(new Point(width, height));						
						Point size = tip.computeSize (SWT.DEFAULT, SWT.DEFAULT);
						Rectangle rect = item.getBounds (0);
						Point pt = tableViewer.getTable().toDisplay (rect.x, rect.y);
						tip.setBounds (pt.x, pt.y, size.x, size.y);
						getBrowser().getShell().setVisible (true);
						return null;
					}
				}



				private void populateTip(Composite composite,
						RegisteredCompletion data) {
					composite.setLayout(new GridLayout());
					Browser browser;
					try {
						browser = new Browser(composite, SWT.NONE);
					} catch (SWTError e) {
						System.out.println("Could not instantiate Browser: " + e.getMessage());
						return;
					}
					
					GridData gd = new GridData();
					gd.horizontalAlignment = GridData.FILL;
					gd.verticalAlignment = GridData.FILL;
					gd.grabExcessHorizontalSpace = true;
					gd.grabExcessVerticalSpace = true;
					gd.widthHint = 1000;
					gd.heightHint = 600;
					browser.setLayoutData(gd);
					//browser.setSize(600, height))
					
					StringBuffer categories = new StringBuffer();
					Iterator<String> iterator = data.getCategories().iterator();
					while(iterator.hasNext()) {
						categories.append("<li>");
						categories.append(iterator.next());
						categories.append("</li>");
					}
					
					browser.setText(
							tooltipTemplate
								.replace("{image}", data.getImage())
								.replace("{caption}", data.getName())
								.replace("{description}", data.getDescription())
								.replace("{categories}", categories));
					
					new SizeCallbackFunction (browser, "setBrowserSize");
				}
			};
			
			tableViewer.getTable().addListener (SWT.Dispose, tableListener);
			tableViewer.getTable().addListener (SWT.KeyDown, tableListener);

			tableViewer.getTable().addListener (SWT.MouseMove, tableListener);
			tableViewer.getTable().addListener (SWT.MouseHover, tableListener);

			
			return comp;
		}


		public String getFileLocation() {
			return fileLocation;
		}
		
		@Override
		protected boolean isResizable() {
			return true;
		}

		
	}
}
