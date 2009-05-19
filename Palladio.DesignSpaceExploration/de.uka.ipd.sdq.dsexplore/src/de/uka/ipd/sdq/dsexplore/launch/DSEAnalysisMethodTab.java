package de.uka.ipd.sdq.dsexplore.launch;

import java.util.ArrayList;
import java.util.Arrays;
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
import de.uka.ipd.sdq.dsexplore.helper.LaunchHelper;
import de.uka.ipd.sdq.dsexplore.qualityAttributes.QualityAttribute;

/**
 * This class represents the launch configuration tab "Analyis Method". It
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
	
	private Combo methodCombo;
	
	private Map<String, IExtension> nameExtensionMap;
	
	private Map<IExtension, CTabFolder> extensionTabFolderMap;
	
	private Map<IExtension, ILaunchConfigurationTabGroup> extensionTabGroupMap;

	private AnalysisMethodListener listener = new AnalysisMethodListener();

	private String qualityAttribute;
	

	public DSEAnalysisMethodTab(String qualityAttribute) {
		super();
		
		this.qualityAttribute = qualityAttribute;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControl(Composite parent) {
		List<IExtension> extensions = ExtensionHelper.loadAnalysisExtensions(qualityAttribute);

		// Map extensions to their analyis method names
		nameExtensionMap = new HashMap<String, IExtension>();
		for (IExtension ext : extensions) {
			String name = loadAnalysisMethodName(ext);
			nameExtensionMap.put(name, ext);
		}
		
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout(1, true));
		
		List<String> methodNames = loadAnalysisMethodNames(extensions);
		Collections.sort(methodNames);
		methodCombo = new Combo(container, SWT.READ_ONLY);
		methodCombo.setItems(methodNames.toArray(methodCombo.getItems()));
		methodCombo.addSelectionListener(listener);
		methodCombo.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		
		Composite tabFolderContainer = new Composite(container, SWT.NONE);
		layout = new StackLayout();
		tabFolderContainer.setLayout(layout);
		tabFolderContainer.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));
				
		// create tab folders from tab groups provided by available analysis extensions
		extensionTabFolderMap = new HashMap<IExtension, CTabFolder>();
		Iterator<Entry<IExtension, ILaunchConfigurationTabGroup>> it = getExtensionTabGroupMap()
				.entrySet().iterator();
		while (it.hasNext()) {
			Entry<IExtension, ILaunchConfigurationTabGroup> entry = it.next();
			IExtension extension = entry.getKey();
			ILaunchConfigurationTabGroup tabGroup = entry.getValue();
			
			CTabFolder tabFolder = LaunchHelper.createTabFolder(tabGroup,
					getLaunchConfigurationDialog(),
					getLaunchConfigurationDialog().getMode(),
					tabFolderContainer, SWT.BORDER | SWT.FLAT);
			
			// Map tab folder to their corresponding extension
			extensionTabFolderMap.put(extension, tabFolder);
		}
	}

	/**
	 * Returns a mapping between analysis extensions and their associated tab
	 * groups.
	 * <p>
	 * At first invocation, the method loads all tab groups provided by the
	 * available analysis extensions. Also creates the tabs associated with each
	 * tab group.
	 * 
	 * @return
	 */
	private Map<IExtension, ILaunchConfigurationTabGroup> getExtensionTabGroupMap() {
		if (extensionTabGroupMap == null) {
			extensionTabGroupMap = new HashMap<IExtension, ILaunchConfigurationTabGroup>();
			
			List<IExtension> extensions = ExtensionHelper.loadAnalysisExtensions(qualityAttribute);
			for (IExtension ext : extensions) {
			
				ILaunchConfigurationTabGroup tabGroup = null;
				try {
					// Load tab group associated with the current extension
					tabGroup = (ILaunchConfigurationTabGroup) ExtensionHelper
							.loadExecutableAttribute(ext, "analysis",
									"launchConfigContribution");
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tabGroup.createTabs(getLaunchConfigurationDialog(),
						getLaunchConfigurationDialog().getMode());
				extensionTabGroupMap.put(ext, tabGroup);
			}
		}
		
		return extensionTabGroupMap;
	}
	
	/**
	 * Displays the tab folder for the analysis method represented by the passed
	 * String.
	 * 
	 * @param name
	 *            the analysis method name specified by the "name"-attribute of
	 *            the extension
	 */
	private void setVisibleMethodOptions(String name) {
		IExtension selExt = nameExtensionMap.get(name);
		CTabFolder selTabFolder = extensionTabFolderMap.get(selExt);
		layout.topControl = selTabFolder;
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
	 * extension.
	 * 
	 * @param extension
	 * @return the analysis method's name; null if the passed extension is not
	 *         an analysis extension or the name attribute is not set.
	 */
	private String loadAnalysisMethodName(IExtension extension) {
		IConfigurationElement[] elements = extension.getConfigurationElements();
		for (IConfigurationElement element : elements) {
			if (element.getName().equals("analysis")) {
				return element.getAttribute("name");
			}
		}
		
		return null;
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return this.qualityAttribute.substring(this.qualityAttribute.lastIndexOf(".")+1) + " Analysis Method";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try{
			String method = configuration.getAttribute(DSEConstantsContainer.getAnalysisMethod(this.qualityAttribute), 
					""); // TODO: Set default string for analysis method
			String[] items = methodCombo.getItems();
			for (int i=0; i<items.length; i++){
				String str = items[i];
				if (str.equals(method)){
					methodCombo.select(i);
					setVisibleMethodOptions(method);
				}
			}
		} catch(CoreException e){
			methodCombo.select(0);
		}
		
		Iterator<Entry<IExtension, ILaunchConfigurationTabGroup>> it = getExtensionTabGroupMap()
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
		configuration.setAttribute(DSEConstantsContainer.getAnalysisMethod(this.qualityAttribute), methodCombo.getText());
		
		Iterator<Entry<IExtension, ILaunchConfigurationTabGroup>> it = getExtensionTabGroupMap()
				.entrySet().iterator();
		while(it.hasNext()) {
			it.next().getValue().performApply(configuration);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// Set the first discovered analysis extension as default analysis method
		List<IExtension> extensions = ExtensionHelper.loadAnalysisExtensions(qualityAttribute);
		if (extensions.size() > 0) {
			configuration.setAttribute(DSEConstantsContainer.getAnalysisMethod(this.qualityAttribute),
					loadAnalysisMethodName(extensions.get(0)));
		}
		
		Iterator<Entry<IExtension, ILaunchConfigurationTabGroup>> it = getExtensionTabGroupMap()
				.entrySet().iterator();
		while (it.hasNext()) {
			it.next().getValue().setDefaults(configuration);
		}
		
	}
	
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		// Check whether an available analysis method is selected
		String methodStr = methodCombo.getText();
		IExtension methodExt = nameExtensionMap.get(methodStr);
		if (methodExt == null) {
			setErrorMessage("Choose an analysis method.");
			return false;
		}
		
		// delegate validation to subtabs 
		ILaunchConfigurationTabGroup tabGroup = getExtensionTabGroupMap()
				.get(nameExtensionMap.get(methodStr));
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

	private class AnalysisMethodListener extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent e) {
			String selectedText = ((Combo)e.getSource()).getText();
			setVisibleMethodOptions(selectedText);
			updateLaunchConfigurationDialog();
		}
		
	}
	
}
