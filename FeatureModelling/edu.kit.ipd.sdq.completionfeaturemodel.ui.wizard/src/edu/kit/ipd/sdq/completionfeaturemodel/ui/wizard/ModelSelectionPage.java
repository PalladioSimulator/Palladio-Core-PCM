package edu.kit.ipd.sdq.completionfeaturemodel.ui.wizard;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.eclipse.ui.internal.ReopenEditorMenu;

import edu.kit.ipd.sdq.completionfeaturemodel.ui.wizard.internal.RegisteredPackageDialog;

public class ModelSelectionPage extends WizardPage implements Listener {

	private Button modelLocationBrowseFileSystemButton;
	private Button modelLocationBrowseWorkspaceButton;
	private Button modelLocationBrowseRegisteredPackagesButton;
	private Text modelLocationText;
	private Button loadButton;
	
	protected Set<EPackage> registeredPackages = new LinkedHashSet<EPackage>();
	

	public ModelSelectionPage(String pageName) {
		super(pageName);
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_VERTICAL));
		
		GridLayout layout = new GridLayout();
		layout.verticalSpacing = 8;
	    composite.setLayout(layout);
	 
	    createModelLocationControl(composite);
	 
	    updateLoadButton();
	    setControl(composite);

	}
	
	private void createModelLocationControl(Composite parent) {
		 Composite composite = new Composite(parent, SWT.NONE);
		 composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		 {
		   GridLayout layout = new GridLayout(2, false);
		   layout.marginLeft = -5;
		   layout.marginRight = -5;
		   composite.setLayout(layout);
		 }
		 
		 Label modelLocationLabel = new Label(composite, SWT.LEFT);
		 modelLocationLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		 modelLocationLabel.setText("Model &URI:");
		 
		 Composite buttonComposite = new Composite(composite, SWT.NONE);
		 buttonComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.HORIZONTAL_ALIGN_END));
		 {
		   RowLayout layout = new RowLayout();
		   layout.justify = true;
		   layout.pack = true;
		   layout.spacing = 5;
		   layout.marginRight = 0;
		   buttonComposite.setLayout(layout);
		 }
		 
		 modelLocationBrowseRegisteredPackagesButton = new Button(buttonComposite, SWT.PUSH);
		 modelLocationBrowseRegisteredPackagesButton.setText("Browse &Registered Packages...");
		 modelLocationBrowseRegisteredPackagesButton.addListener(SWT.Selection, this);
		 
		 modelLocationBrowseFileSystemButton = new Button(buttonComposite, SWT.PUSH);
		 modelLocationBrowseFileSystemButton.setText("Browse &File System...");
		 modelLocationBrowseFileSystemButton.addListener(SWT.Selection, this);
		 
		 modelLocationBrowseWorkspaceButton = new Button(buttonComposite, SWT.PUSH);
		 modelLocationBrowseWorkspaceButton.setText("Browse &Workspace...");
		 modelLocationBrowseWorkspaceButton.addListener(SWT.Selection, this);
		 
		 Composite modelLocationComposite = new Composite(parent, SWT.NONE);
		 modelLocationComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		 {
		   GridLayout layout = new GridLayout(2, false);
		   layout.marginTop = -5;
		   layout.marginLeft = -5;
		   layout.marginRight = -5;
		   modelLocationComposite.setLayout(layout);
		 }
		 
		 modelLocationText = new Text(modelLocationComposite, SWT.SINGLE | SWT.BORDER);
		 modelLocationText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		 /*if (getModelImporter().getModelLocation() != null)
		 {
		   modelLocationText.setText(getModelImporter().getModelLocation());
		 }*/
		 modelLocationText.addListener(SWT.Modify, this);
		 
		 loadButton = new Button(modelLocationComposite, SWT.PUSH);
		 loadButton.setText("&Load");
		 {
			 GridData data = new GridData(GridData.END);
			 data.widthHint = 50;
			 loadButton.setLayoutData(data);
		 }
		 loadButton.addListener(SWT.Selection, this);

	}

	private void updateLoadButton() {
		if(loadButton != null) {
			String modelText = modelLocationText.getText();
			loadButton.setEnabled(modelText != null && modelText.trim().length() > 0);
		}
	}
	
	@Override
	public void handleEvent(Event event) {
		if (event.type == SWT.Modify && event.widget == modelLocationText) {
			setErrorMessage(null);
			setMessage(null);
			updateLoadButton();
		}
		else if (event.type == SWT.Selection && event.widget == loadButton) {
			refreshModel();
		}
		else if (event.type == SWT.Selection && event.widget == modelLocationBrowseRegisteredPackagesButton) {
			browseRegisteredPackages();
		}
		else if (event.type == SWT.Selection && event.widget == modelLocationBrowseFileSystemButton) {
			browseFileSystem();
		}
		else if (event.type == SWT.Selection && event.widget == modelLocationBrowseWorkspaceButton) {
			browseWorkspace();
		}
		getContainer().updateButtons();
	}

	private void refreshModel() {
		WorkspaceModifyOperation initModelOperation = new WorkspaceModifyOperation() {
			
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException,
					InvocationTargetException, InterruptedException {
				try {
					refreshModel(monitor);
				}
				catch(Exception exception) {
					
				}
				finally {
					monitor.done();
				}
			}
		};
		
		try
		{
			getContainer().run(false, false, initModelOperation);
		}
		catch (Exception  exception)
		{
		
		}
		
		
	}

	protected void refreshModel(IProgressMonitor monitor) {
		
		registeredPackages.clear();
		ResourceSet resourceSet = new ResourceSetImpl();
		monitor.beginTask("Import Packages", getURIs().size());
		for(URI uri : getURIs()) {
			Resource resource = resourceSet.getResource(uri, true);
			for (EPackage ePackage : getAllPackages(resource)) {
				registeredPackages.add(ePackage);
			}
			monitor.worked(1);
        }
		monitor.done();
	}

	private List<URI> getURIs() {
		List<URI> uris = new ArrayList<URI>();
	    for (StringTokenizer stringTokenizer = new StringTokenizer(modelLocationText.getText()); stringTokenizer.hasMoreTokens(); )
	    {
	      String uri = stringTokenizer.nextToken();
	      uris.add(URI.createURI(uri));
	    }      
	    return uris;
	}

	private boolean browseWorkspace() {
		ResourceSelectionDialog resourceSelectionDialog = new ResourceSelectionDialog(
		  getShell(),
		  ResourcesPlugin.getWorkspace().getRoot(),
		  "File Selection");
		
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
		  modelLocationText.setText(text.toString());
		  refreshModel();
		  return true;
		}
		return false;
	}

	private boolean browseFileSystem() {
		FileDialog fileDialog = new FileDialog(getShell(), SWT.OPEN | SWT.MULTI );
		fileDialog.setFilterExtensions(new String[]{"*.*"});
		
		/*URI modelURI = getModelImporter().getFirstModelLocationURI(true);
		if (modelURI != null)
		{
		  fileDialog.setFileName(modelURI.toFileString());
		}*/
		
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
		  modelLocationText.setText(text.toString());
		  refreshModel();
		  return true;
		}
		return false;
	}

	private boolean browseRegisteredPackages() {
		RegisteredPackageDialog registeredPackageDialog = new RegisteredPackageDialog(getShell());
		registeredPackageDialog.open();
        Object [] result = registeredPackageDialog.getResult();
        if (result != null)
        {
          StringBuffer uris = new StringBuffer();
          List<?> nsURIs = Arrays.asList(result);
          if (registeredPackageDialog.isDevelopmentTimeVersion())
          {
            ResourceSet resourceSet = new ResourceSetImpl();
            resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());
            
            Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
            for (int i = 0, length = result.length; i < length; i++)
            {
              URI location = ePackageNsURItoGenModelLocationMap.get(result[i]);
              Resource resource = resourceSet.getResource(location, true);
              EcoreUtil.resolveAll(resource);
            }
            for (Resource resource : resourceSet.getResources())
            {
              for (EPackage ePackage : getAllPackages(resource))
              {
                if (nsURIs.contains(ePackage.getNsURI()))
                {
                  uris.append(resource.getURI());
                  uris.append("  ");
                  break;
                }
              }
            }
            
          }
          else
          {
            for (int i = 0, length = result.length; i < length; i++)
            {
              uris.append(result[i]);
              uris.append("  ");
            }
          }
          modelLocationText.setText((modelLocationText.getText() + "  " + uris.toString()).trim());
          refreshModel();
          return true;
        }
        return false;
	}

	protected Collection<EPackage> getAllPackages(Resource resource)
    {
      List<EPackage> result = new ArrayList<EPackage>();
      for (TreeIterator<?> j = 
             new EcoreUtil.ContentTreeIterator<Object>(resource.getContents())
             {
               private static final long serialVersionUID = 1L;

               @Override
               protected Iterator<? extends EObject> getEObjectChildren(EObject eObject)
               {
                 return 
                   eObject instanceof EPackage ? 
                     ((EPackage)eObject).getESubpackages().iterator() : 
                       Collections.<EObject>emptyList().iterator();
               }
             };
           j.hasNext(); )
      {
        Object content = j.next();
        if (content instanceof EPackage)
        {
          result.add((EPackage)content);
        }
      }
      return result;
    }

	public Collection<EPackage> getSelectedModelPackages() {
		return registeredPackages;
	}
}
