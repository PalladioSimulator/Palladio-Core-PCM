package edu.kit.ipd.sdq.completionfeaturemodel.ui.wizard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.jar.Attributes.Name;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.URIConverterImpl;
import org.eclipse.emf.ecore.xmi.impl.ElementHandlerImpl;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PatternFilter;

public class ModelElementSelectionPage<Element extends ENamedElement> extends WizardPage {

	private CheckboxTableViewer checkBoxTableViewer;
	private Collection<EPackage> selectedModel;
	private final Class<Element> type;
	private String filter;
	PatternFilter paternFilter;

	public ModelElementSelectionPage(String pageName, Class<Element> type) {
		super(pageName);
		this.type = type;
		setFilter("*");
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		//composite.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_VERTICAL));
		composite.setLayout(new FormLayout());
		setControl(composite);
		
		final Text filtertext = new Text(composite, SWT.BORDER);
		filtertext.setText(filter);
		filtertext.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				 paternFilter.setPattern(filtertext.getText());
				 checkBoxTableViewer.refresh();
			}
        });

        filtertext.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.keyCode == SWT.ARROW_DOWN) {
                	checkBoxTableViewer.getTable().setFocus();
				}
            }

            public void keyReleased(KeyEvent e) {
            }
        });

		final FormData formData = new FormData();
		formData.right = new FormAttachment(100, 0);
		formData.top = new FormAttachment(0, 0);
		formData.left = new FormAttachment(0, 0);
		filtertext.setLayoutData(formData);
		
		AdapterFactory adapterFactory = new AdapterFactoryImpl();
		Composite tableComposite = new Composite(composite, SWT.NONE);
		final FormData formData_1 = new FormData();
		formData_1.bottom = new FormAttachment(100, 0);
		formData_1.right = new FormAttachment(100, 0);
		formData_1.top = new FormAttachment(filtertext, 10 , SWT.BOTTOM);
		formData_1.left = new FormAttachment(0, 0);
		tableComposite.setLayoutData(formData_1);
		TableColumnLayout tableColumnLayout = new TableColumnLayout();
		tableComposite.setLayout(tableColumnLayout);
		checkBoxTableViewer = CheckboxTableViewer.newCheckList(tableComposite, SWT.BORDER);
		checkBoxTableViewer.setColumnProperties(new String[] {"Element Name", "Package", "File Name"});
		paternFilter = new PatternFilter(){

			@Override
			protected boolean isParentMatch(Viewer viewer, Object element) {
				return viewer instanceof AbstractTreeViewer && super.isParentMatch(viewer, element);
			}};
		paternFilter.setPattern(getFilter());
		checkBoxTableViewer.addFilter(paternFilter);
		checkBoxTableViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		checkBoxTableViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory)  {

			@Override
			public String getText(Object object) {
				return ((ENamedElement) object).getName();
			}

			@Override
			public Image getColumnImage(Object object, int columnIndex) {
				switch (columnIndex) {
				case 0:{
					EClass eclass = ((ENamedElement)object).eClass();
					return ExtendedImageRegistry.INSTANCE.getImage(EcoreEditPlugin.INSTANCE.getImage("full/obj16/"+eclass.getName()));
				}
				default:
					return null;
				}
			}

			@Override
			public String getColumnText(Object object, int columnIndex) {
				switch (columnIndex) {
				case 0:
					return ((ENamedElement) object).getName();
				case 1:
				{
					EPackage ePackage = getEcoreParentPackageName((ENamedElement)object);
					return ePackage == null ? "": ePackage.getName();
				}
				case 2:
					EPackage ePackage = getEcoreParentPackageName((ENamedElement)object);
					if(ePackage == null) ePackage = object instanceof EPackage ? (EPackage)object : null; 
					return getEcoreFileName(ePackage);
				default:
					return null;
				}
			}
			
		});
		
		final Table table = checkBoxTableViewer.getTable();
		table.setHeaderVisible(true);
		
		/*final TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(200);
		tableColumn.setText("Element Name");
		
		final TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(250);
		tableColumn_1.setText("Package");
		
		final TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(250);
		tableColumn_2.setText("File Name");*/
	}

	protected EPackage getEcoreParentPackageName(ENamedElement namedElement) {
		if (namedElement instanceof ETypedElement) {
			namedElement = ((ETypedElement)namedElement).getEType();
		}
		
		if(namedElement instanceof EClassifier) {
			return ((EClassifier)namedElement).getEPackage();
		}
		else if(namedElement instanceof EPackage) {
			return ((EPackage)namedElement).getESuperPackage();
		}
		
		return null;
		
	}

	protected String getEcoreFileName(EPackage ePackage) {
		if(ePackage == null) return null;
		
		String name = ePackage.getName();
		int index = name.lastIndexOf(".");
		if (index != -1)
		{
			name = name.substring(index + 1);
			name += ".ecore";
		}
		if(ePackage.eResource() != null) {
			URIConverter converter = new ExtensibleURIConverterImpl();
			URI uri = ePackage.eResource().getURI();
			URI normalizedUri = converter.normalize(uri);
			name = normalizedUri.toString();//.lastSegment();
		}
		return name;
	}

	@Override
	public void setVisible(boolean visible) {
		if(visible) {
			Collection<EPackage> model = ((IModelSelectionWizard) getWizard()).getSelectedModelPackages();
			if(model != selectedModel) {
				selectedModel = model;
				List<EObject> objectList = new ArrayList<EObject>();
				for(EPackage ePackage: model) {
					TreeIterator<EObject> iterator = ePackage.eAllContents();
					while(iterator.hasNext()){
						EObject object = iterator.next();
						if(type.isInstance(object))
							objectList.add(object);
					}
				}
				checkBoxTableViewer.setInput(new ItemProvider(objectList));
			}
		}
		super.setVisible(visible);
	}

	public void filterPackagesTable(Boolean reloadObjects) {
		if(checkBoxTableViewer != null) {
			if(reloadObjects) {
				
			}
			checkBoxTableViewer.setInput(new ItemProvider());
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Element> getSelectedElements() {
		Object[] objectArray = checkBoxTableViewer.getCheckedElements();
		ArrayList<Element> elements = new ArrayList<Element>(objectArray.length);
		for(Object obj: objectArray){
			if(type.isInstance(obj))
				elements.add((Element)obj);
		}
		return elements;
		
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getFilter() {
		return filter;
	}
}
