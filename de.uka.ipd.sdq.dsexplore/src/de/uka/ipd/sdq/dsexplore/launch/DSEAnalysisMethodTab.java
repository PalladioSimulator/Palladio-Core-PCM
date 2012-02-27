package de.uka.ipd.sdq.dsexplore.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTabGroup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import de.uka.ipd.sdq.dsexplore.helper.ExtensionHelper;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer.QualityAttribute;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;

/**
 * This class represents the launch configuration tab "Analysis Method". It
 * provides a selection of the concrete analysis method to be used in design
 * exploration runs.
 * <p>
 * Also the represented tab serves as container for tabs provided by a concrete
 * analysis method. By providing tabs, a analysis method can contribute controls
 * to the GUI whereby further configuration can be offered.
 * <p>
 * The available analysis methods are automatically discovered by the eclipse
 * extension point mechanism.
 * 
 * @author pmerkle
 * 
 */
public class DSEAnalysisMethodTab extends AbstractLaunchConfigurationTab {

	private StackLayout layout;
	
	private Composite tabFolderContainer;
	
	private Combo methodCombo;
	
	private boolean methodComboEnabled = true;
	
	private Map<String, IConfigurationElement> nameExtensionElementMap;
	
	private Map<IConfigurationElement, CTabFolder> extensionElementTabFolderMap;
	
	private Map<IConfigurationElement, ILaunchConfigurationTabGroup> extensionElementTabGroupMap;

	private AnalysisMethodListener listener = new AnalysisMethodListener();
	
	private QualityAttribute qualityAttributeId;
	
	public DSEAnalysisMethodTab(QualityAttribute qualityAttribute) {
		super();
		
		//XXX here not the dimension (e.g. response time) should be the name but the quality attribute (e.g. performance), because one analysis approach can determine several aspects (dimensions) of its quality attribute.  
		this.qualityAttributeId = qualityAttribute;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId(){
		return this.qualityAttributeId.getName();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControl(Composite parent) {
		List<IExtension> extensions = ExtensionHelper.loadAnalysisExtensions(qualityAttributeId);

		// Map extension elements to their analysis method names
		nameExtensionElementMap = new HashMap<String, IConfigurationElement>();
		for (IExtension ext : extensions) {
			IConfigurationElement[] elements = ext.getConfigurationElements();
			for (IConfigurationElement element : elements) {
				String name = loadAnalysisMethodName(element);
				nameExtensionElementMap.put(name, element);	
		}
		}
		
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout(1, true));
		
		List<String> methodNames = loadAnalysisMethodNames(extensions);
		Collections.sort(methodNames);
		
		//methodNames.add(DSEConstantsContainer.NONE);
		methodCombo = new Combo(container, SWT.READ_ONLY);
		methodCombo.setItems(methodNames.toArray(methodCombo.getItems()));
		methodCombo.addSelectionListener(listener);
		methodCombo.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
				
		tabFolderContainer = new Composite(container, SWT.NONE);
		layout = new StackLayout();
		tabFolderContainer.setLayout(layout);
		tabFolderContainer.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));
				
		// create tab folders from tab groups provided by available analysis extension elements
		extensionElementTabFolderMap = new HashMap<IConfigurationElement, CTabFolder>();
		Iterator<Entry<IConfigurationElement, ILaunchConfigurationTabGroup>> it = getExtensionElementTabGroupMap()
				.entrySet().iterator();
		while (it.hasNext()) {
			Entry<IConfigurationElement, ILaunchConfigurationTabGroup> entry = it.next();
			IConfigurationElement element = entry.getKey();
			ILaunchConfigurationTabGroup tabGroup = entry.getValue();
			
			CTabFolder tabFolder = TabHelper.createTabFolder(tabGroup,
					getLaunchConfigurationDialog(),
					getLaunchConfigurationDialog().getMode(),
					tabFolderContainer, SWT.BORDER | SWT.FLAT);
			
			// Map tab folder to their corresponding extension element
			extensionElementTabFolderMap.put(element, tabFolder);
		}
	}

	/**
	 * Returns a mapping between analysis extension elements and their associated tab
	 * groups.
	 * <p>
	 * At first invocation, the method loads all tab groups provided by the
	 * available analysis extension elements. Also creates the tabs associated with each
	 * tab group.
	 * 
	 * @return
	 */
	private Map<IConfigurationElement, ILaunchConfigurationTabGroup> getExtensionElementTabGroupMap() {
		if (extensionElementTabGroupMap == null) {
			extensionElementTabGroupMap = new HashMap<IConfigurationElement, ILaunchConfigurationTabGroup>();
			
			List<IExtension> extensions = ExtensionHelper.loadAnalysisExtensions(qualityAttributeId);
			for (IExtension ext : extensions) {
				try {
					// Obtain all extension elements
					IConfigurationElement[] elements = ext.getConfigurationElements();
					for (IConfigurationElement element : elements) {
						ILaunchConfigurationTabGroup tabGroup = (ILaunchConfigurationTabGroup) ExtensionHelper
								.loadExecutableAttribute(element, "launchConfigContribution");
						// create contained tabs
						tabGroup.createTabs(getLaunchConfigurationDialog(),
								getLaunchConfigurationDialog().getMode());
						extensionElementTabGroupMap.put(element, tabGroup);
					}
			
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return extensionElementTabGroupMap;
	}
	
	/**
	 * Displays the tab folder for the analysis method represented by the passed
	 * String.
	 * 
	 * @param name
	 *            the analysis method name specified by the "name"-attribute of
	 *            the extension element
	 */
	private void setVisibleMethodOptions(String name) {
		IConfigurationElement selElement = nameExtensionElementMap.get(name);
		CTabFolder selTabFolder = extensionElementTabFolderMap.get(selElement);
		layout.topControl = selTabFolder;
		tabFolderContainer.layout();
		
	}

	/**
	 * Loads the names of all analysis methods represented by the passed
	 * extensions.
	 * 
	 * @param extensions
	 * @return
	 */
	private List<String> loadAnalysisMethodNames(List<IExtension> extensions) {
		List<String> names = new ArrayList<String>(); 
		for (int i=0; i < extensions.size(); i++) {
			IExtension extension = extensions.get(i);
			IConfigurationElement[] elements = extension.getConfigurationElements();
			for (IConfigurationElement element : elements) {
				if (element.getName().equals("analysis")) {
					names.add(element.getAttribute("name"));
				}
			}
		}
		
		return names;
	}

	/**
	 * Loads the name of a single analysis method represented by the passed
	 * extension element.
	 * 
	 * @param extension element
	 * @return the analysis method's name; null if the name attribute is not set.
	 */
	private String loadAnalysisMethodName(IConfigurationElement element) {
				return element.getAttribute("name");
			}
		

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return this.qualityAttributeId.getPrettyName() + " Analysis Method";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try{
			String method = configuration.getAttribute(DSEConstantsContainer.getAnalysisMethod(this.qualityAttributeId), 
					DSEConstantsContainer.NONE); // TODO: Set default string for analysis method
			String[] items = methodCombo.getItems();
			for (int i=0; i<items.length; i++){
				String str = items[i];
				if (str.equals(method)){
					methodCombo.select(i);
					if(methodComboEnabled) {
						setVisibleMethodOptions(method);
					} else {
						setVisibleMethodOptions(DSEConstantsContainer.NONE);
					}
				}
			}
		} catch(CoreException e){
			methodCombo.select(0);
		}
		
		Iterator<Entry<IConfigurationElement, ILaunchConfigurationTabGroup>> it = getExtensionElementTabGroupMap()
				.entrySet().iterator();
		while(it.hasNext()) {			
			it.next().getValue().initializeFrom(configuration);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(DSEConstantsContainer.getAnalysisMethod(this.qualityAttributeId), methodCombo.getText());
		
		// delegate performApply to subtabs. Pay attention to delegate only to
		// those tabs that are part of the selected analysis method tab group.
		// Otherwise the local performApply methods will mutually override their
		// configuration values if the different tab groups contain equal tabs.
		String methodStr = methodCombo.getText();
		ILaunchConfigurationTabGroup tabGroup = getExtensionElementTabGroupMap()
				.get(nameExtensionElementMap.get(methodStr));
		if (tabGroup != null) {
			tabGroup.performApply(configuration);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// Set the first discovered analysis extension element as default analysis method
		List<IExtension> extensions = ExtensionHelper.loadAnalysisExtensions(qualityAttributeId);
		
		Iterator<Entry<IConfigurationElement, ILaunchConfigurationTabGroup>> it = getExtensionElementTabGroupMap()
			.entrySet().iterator();
		while (it.hasNext()) {
			it.next().getValue().setDefaults(configuration);
		}
		
		if (extensions.size() > 0) {
			IConfigurationElement defaultElement = extensions.get(0).getConfigurationElements()[0];
			configuration.setAttribute(DSEConstantsContainer.getAnalysisMethod(this.qualityAttributeId),
					loadAnalysisMethodName(defaultElement));
		} else {
			configuration.setAttribute(DSEConstantsContainer.getAnalysisMethod(this.qualityAttributeId),
					DSEConstantsContainer.NONE);
		}
		

		
	}
	
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		// Check whether an available analysis method is selected
		String methodStr = methodCombo.getText();
		IConfigurationElement methodElement = nameExtensionElementMap.get(methodStr);
		if (methodElement == null && !methodStr.equals(DSEConstantsContainer.NONE)) {
			setErrorMessage("Choose an analysis method.");
			return false;
		}
		
		// delegate validation to subtabs 
		ILaunchConfigurationTabGroup tabGroup = getExtensionElementTabGroupMap()
				.get(nameExtensionElementMap.get(methodStr));
		if (tabGroup != null) {
			ILaunchConfigurationTab[] tabs = tabGroup.getTabs();
			for (ILaunchConfigurationTab tab : tabs) {
				boolean valid = tab.isValid(launchConfig);
				if (!valid) {
					// treat sub tabs' errors as own errors
					if (tab.getErrorMessage() != null) {
						setErrorMessage("[" + tab.getName() + "]: "
								+ tab.getErrorMessage());
					}
					return false;
				}
			}
		}
		
		setErrorMessage(null);
		return true;
	}

	@Override
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
		// Leave this method empty to prevent unnecessary invocation of
		// initializeFrom() and multiple resulting invocations of
		// performApply().
	}

	@Override
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {}

	public void deactivate(){

		if(!methodComboEnabled) {
			return;
		}
		this.methodCombo.removeAll();
		this.methodCombo.add(DSEConstantsContainer.NONE);
		this.methodCombo.select(0);
		methodCombo.setEnabled(false);
		setVisibleMethodOptions(DSEConstantsContainer.NONE);
		methodComboEnabled = false;
	}
	
	public void activate(List<IExtension> extensions){
//		List<IExtension> extensions = ExtensionHelper.loadAnalysisExtensions(qualityAttribute);
//		this.methodCombo.removeAll();
//		List<String> methodNames = loadAnalysisMethodNames(extensions);
//		Collections.sort(methodNames);
//		String[] items = methodNames.toArray(methodCombo.getItems());
//		methodCombo.setItems(items);
//		this.methodCombo.select(0);
		
		List<String> methodNames = loadAnalysisMethodNames(extensions);
		Collections.sort(methodNames);
		
		methodCombo.setItems(methodNames.toArray(new String[1]));
		
		if(methodComboEnabled) {
			return;
		}
		
		methodCombo.setEnabled(true);
		int selection = methodCombo.getSelectionIndex();
		if(methodCombo.getSelectionIndex()> -1) {
			setVisibleMethodOptions(methodCombo.getItem(selection));
		}
		methodComboEnabled = true;
	}
	
	private class AnalysisMethodListener extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent e) {
			String selectedText = ((Combo)e.getSource()).getText();
			IConfigurationElement selElement = nameExtensionElementMap.get(selectedText);
			if (selElement != layout.topControl) {
			setVisibleMethodOptions(selectedText);
			updateLaunchConfigurationDialog();
		}
		}
		
	}
	
}
