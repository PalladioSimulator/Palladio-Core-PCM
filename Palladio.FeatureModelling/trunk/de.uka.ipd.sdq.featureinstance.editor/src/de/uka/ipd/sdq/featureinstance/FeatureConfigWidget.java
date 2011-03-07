package de.uka.ipd.sdq.featureinstance;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.PropertySheetPage;

import de.uka.ipd.sdq.dialogs.error.ErrorDisplayDialog;
import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.featureconfig.impl.featureconfigFactoryImpl;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.FeatureDiagram;
import de.uka.ipd.sdq.featuremodel.FeatureGroup;

public class FeatureConfigWidget {

	private Composite parent;
	private String sourceInput;
	private String targetInput;
	protected AdapterFactoryEditingDomain editingDomain;
	protected CheckboxTreeViewer treeViewer;
	protected PropertySheetPage propertySheetPage;
	protected ICheckStateListener listener;
	protected Resource resource;
	protected FeatureDiagram featureDiagram;
	protected Object root;
	protected TreeViewer contentOutlineViewer;
	protected IContentOutlinePage contentOutlinePage;
	protected boolean dirtyFlag = false;
	protected FeatureConfig defaultConfig;
	protected FeatureConfig overridesConfig;
	private List<ICheckStateListener> checkStateListeners;
	private String errorMessage;
	private InstanceValidateAction validateAction;
	private FeatureConfigFunctionality functions;

	public FeatureConfigWidget(Composite parent) {
		this.parent = parent;
		checkStateListeners = new LinkedList<ICheckStateListener>();
		validateAction = new InstanceValidateAction();
		
		functions = new FeatureConfigFunctionality();
		editingDomain = functions.initializeEditingDomain();
	}

	public void setSourceInput(String sourceInput) {
		this.sourceInput = sourceInput;
	}

	public void setTargetInput(String targetInput) {
		this.targetInput = targetInput;
	}
	
	public void validate () {
		validateAction.setConfiguration(functions.getConfiguration(resource));
		validateAction.setShell(parent.getShell());
		validateAction.run();
	}

	public boolean createPages() {
		boolean valid = checkValid();
		if (valid) {
			createResource();
			
			if (resource == null) {
				errorMessage = "Resource couldn't be loaded";
				return false;
			}
			
			return createEditor();
		} else {
			return false;
		}
	}

	/**
	 * Creates the editor layout and content
	 */
	protected boolean createEditor() {
		// handles the different cases of opened files and model/configuration
		// cases
		boolean valid = handleConfigCases();

		if (featureDiagram != null && overridesConfig != null && valid) {

			createViewer(featureDiagram);
			// //set the needed attributes for the validation in the
			// actionBarContributor
			// EditingDomainActionBarContributor contrib =
			// getActionBarContributor();
			// if (contrib instanceof FeatureModelInstanceContributor) {
			// ((FeatureModelInstanceContributor)contrib).setConfiguration(getConfiguration(resource));
			// ((FeatureModelInstanceContributor)contrib).setShell(getContainer().getShell());
			// }
			return valid;
			//	      
		} else {
			errorMessage = "FeatureDiagram couldn't be referenced";
			return false;
		}
	}

	/**
	 * Handles the different cases for a loaded *.featureconfig-resource
	 * http://sdqweb.ipd.uka.de/mediawiki/images/6/61/Check_Cases.png
	 * 
	 * @param resource
	 *            The resource in which the configuration object should be
	 *            stored
	 * @return The resource object which stores the (prop. new) overrides config
	 *         object
	 */
	private boolean handleConfigCases() {

		// Check if featureconfig file is valid (Configuration object can be
		// referenced)
		Configuration configuration = functions.getConfiguration(resource);

		EList<FeatureConfig> tempOverrides = configuration.getConfigOverrides();
		FeatureConfig tempDefault = configuration.getDefaultConfig();

		// Both FeatureConfigs are null
		if ((tempOverrides == null || tempOverrides.isEmpty())
				&& tempDefault == null) {
			errorMessage = "Model contains no FeatureConfig object";
			return false;
		} else if (tempOverrides == null && tempDefault != null) { // default
																	// exists
			EList<ConfigNode> configList = tempDefault.getConfignode();

			if (!configList.isEmpty()) {
				// Try to reference the Feature Diagram object and create a new
				// overrides from it
				featureDiagram = functions.navigateToFeatureDiagram((Feature) configList
						.iterator().next().getOrigin(), editingDomain);

				// start wizard an ask for a new file location
				// *.featureconfig with only a default config shall only be used
				// as template
				URI newResourceURI = URI.createPlatformResourceURI(targetInput,
						true);
				createNewConfigResource(newResourceURI, featureDiagram,
						tempDefault);
			} else {
				errorMessage = "FeatureConfig objects are empty";
				return false;
			}
		} else if (tempOverrides != null && !tempOverrides.isEmpty()
				&& tempDefault == null) {
			FeatureConfig featureConfig = tempOverrides.get(0); // assumption:
																// only one
																// feature
																// diagram
																// present
			EList<ConfigNode> configList = featureConfig.getConfignode();

			// Try to reference the Feature Diagram object
			if (!configList.isEmpty()) {
				featureDiagram = functions.navigateToFeatureDiagram((Feature) configList
						.iterator().next().getOrigin(), editingDomain);
				overridesConfig = featureConfig;
				URI newResourceURI = URI.createPlatformResourceURI(targetInput,
						true);
				doSaveAs(newResourceURI);
			} else {
				errorMessage = "FeatureConfig objects are empty";
				return false;
			}
		} else {
			// both configs are present
			boolean configPresent = false;
			EList<ConfigNode> configList;

			// Check for OverridesConfig
			if (!tempOverrides.isEmpty()) {
				FeatureConfig featureConfig = tempOverrides.get(0); // assumption:
																	// only one
																	// feature
																	// diagram
																	// present
				configList = featureConfig.getConfignode();

				// Try to reference the Feature Diagram object
				if (!(configList.isEmpty())) {
					featureDiagram = functions.navigateToFeatureDiagram((Feature) configList
							.iterator().next().getOrigin(), editingDomain);
					overridesConfig = featureConfig;
					configPresent = true;
				}
			}

			// Check for DefaultConfig
			configList = tempDefault.getConfignode();

			if (!(configList.isEmpty())) {
				// if the feature diagram is already referenced, just save the
				// default config
				if (configPresent) {
					defaultConfig = tempDefault;
					URI newResourceURI = URI.createPlatformResourceURI(
							targetInput, true);
					doSaveAs(newResourceURI);
				}
				// else, try to reference the feature config object by using the
				// default config
				// and ask for new save location (see case that only a default
				// config is present)
				else {
					featureDiagram = functions.navigateToFeatureDiagram((Feature) configList
							.iterator().next().getOrigin(), editingDomain);
					URI newResourceURI = URI.createPlatformResourceURI(
							targetInput, true);
					createNewConfigResource(newResourceURI, featureDiagram,
							tempDefault);
				}
			} else {
				if (configPresent) {
					URI newResourceURI = URI.createPlatformResourceURI(
							targetInput, true);
					doSaveAs(newResourceURI);
				} else {
					errorMessage = "FeatureConfig objects are empty";
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Creates a treeViewer of the given FeatureDiagram
	 * 
	 * @param root
	 *            The FeatureDiagram-object which shall be displayed
	 */
	public void createViewer(FeatureDiagram root) {
		if (treeViewer == null) {
			treeViewer = new CheckboxTreeViewer(parent);
			treeViewer.setContentProvider(new TreeContentProvider());
			treeViewer.setLabelProvider(new TreeLabelProvider());
			
			for (ICheckStateListener currentListener : checkStateListeners) {
				treeViewer.addCheckStateListener(currentListener);
			}
		}
		treeViewer.setInput(root);
		treeViewer.expandAll();

		if (root != null) {
			treeViewer.setGrayed(root.getRootFeature(), true);

			// Gray FeatureGroups
			Feature curRoot = root.getRootFeature();
			functions.grayFeatureGroups(curRoot.getChildrelation(), treeViewer);
		}

		if (defaultConfig != null) {
			functions.markDefaultConfig(defaultConfig,treeViewer);
		}
		if (overridesConfig != null) {
			functions.markOverridesConfig(overridesConfig,treeViewer);
		}

		listener = new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {

				// make FeatureGroups readonly
				if (event.getElement() instanceof FeatureGroup) {
					treeViewer.setChecked(event.getElement(), !(event
							.getChecked()));
				} else {
					Object parent = editingDomain.getParent(event.getElement());

					// automatically unchecks Feature again, if its a mandatory
					// Feature and the parent node is selected
					if ((event.getElement() instanceof Feature)) {
						
						if ((functions.checkMandatory((Feature) event.getElement(), editingDomain))) {
						treeViewer.setChecked(event.getElement(), true);
						functions.uncheckInModel((Feature)event.getElement(), true, overridesConfig);
						} 
						// check if node is NOT the root node
						else if (parent != null && !(parent instanceof FeatureDiagram)) {
							if (treeViewer.getGrayed(event.getElement())) {
								treeViewer.setGrayed(event.getElement(), false);
							}

							// check/uncheck recursively
							if (event.getChecked()) {
								functions.uncheckInModel((Feature) event.getElement(), true, overridesConfig);
								functions.checkParents(event.getElement(),treeViewer,overridesConfig,editingDomain);
							} else {
								functions.uncheckInModel((Feature) event.getElement(), false, overridesConfig);
								functions.uncheckParents(event.getElement(),treeViewer,overridesConfig,editingDomain);
							}
						}
						// make root node readonly
						else {
							treeViewer.setChecked(event.getElement(), !(event
									.getChecked()));
						}
						dirtyFlag = true;
					}
				}
			}
		};

		treeViewer.addCheckStateListener(listener);
		// createContextMenuFor(treeViewer);

		// Selects all mandatory Features
		if (root != null) {
			Feature curRoot = root.getRootFeature();
			functions.selectMandatoryFeatures(curRoot.getChildrelation(), treeViewer, overridesConfig);
		}
	}

	/**
	 * Loads the resource-object through the editingDomain
	 */
	protected void createResource() {
		URI resourceURI = URI.createPlatformResourceURI(sourceInput, true);

		// Try to load the resource through the editingDomain.
		resource = null;
		try {
			resource = editingDomain.getResourceSet().getResource(resourceURI,
					true);
		} catch (Exception e) {
			resource = editingDomain.getResourceSet().getResource(resourceURI,
					false);
		}
	}

	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// */
	// public EditingDomainActionBarContributor getActionBarContributor() {
	// return
	// (EditingDomainActionBarContributor)getEditorSite().getActionBarContributor();
	// }

	/**
	 * Creates a new Configuration-Resource with the given newResourceURI
	 * corresponding to the given featureDiagram Overrides the old
	 * (*.featuremodel) resource-object
	 * 
	 * @param newResourceURI
	 *            The URI for the new Resource
	 * @param featureDiagram
	 *            A FeatureDiagram-object to which the new Configuration should
	 *            reference
	 * @param defaultRef
	 *            A reference to the defaultConfig object or null, if none
	 *            exists
	 */
	protected void createNewConfigResource(URI newResourceURI,
			FeatureDiagram featureDiagram, FeatureConfig defaultRef) {
		if (newResourceURI == null) {
			throw new NullPointerException("No Config file stored in resource!");
		} else {
			// Create new featureconfig-resource and change current resource
			resource = resource.getResourceSet().createResource(newResourceURI);

			featureconfigFactoryImpl factory = new featureconfigFactoryImpl();
			Configuration newConfig = factory.createConfiguration();
			newConfig.setName(featureDiagram.getName() + "_config");

			FeatureConfig newOverrides = factory.createFeatureConfig();
			newConfig.getConfigOverrides().add(newOverrides);

			// set reference to default
			if (defaultRef == null) {
				defaultRef = factory.createFeatureConfig();
			}
			newConfig.setDefaultConfig(defaultRef);

			ConfigNode rootConfigNode = factory.createConfigNode();
			rootConfigNode.setConfigState(ConfigState.ELIMINATED);
			rootConfigNode.setOrigin((Feature) (featureDiagram)
					.getRootFeature());

			newOverrides.getConfignode().add(rootConfigNode);

			resource.getContents().add(newConfig);

			defaultConfig = defaultRef;
			overridesConfig = newOverrides;

			try {
				resource.load(Collections.EMPTY_MAP);
				resource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				ErrorDisplayDialog errord = new ErrorDisplayDialog(parent
						.getShell(), new Throwable(
						"Could not load or save the Resource!"));
				errord.open();
			}
		}
	}

	/**
	 * Handles the different file types for the loaded resource.
	 * 
	 * @param fileExtension
	 *            The file extension of the loaded resource
	 * @param path
	 *            The complete path to the file including the fileName
	 * @param fileName
	 *            The filename
	 */
	private boolean checkValid() {
		if (sourceInput == null || targetInput == null
				|| !sourceInput.endsWith(".featureconfig")
				|| !targetInput.endsWith(".featureconfig")) {
			errorMessage = "Empty Source/Target file or wrong file ending";
			return false;
		}
		return true;
	}

	public boolean isDirty() {
		return dirtyFlag;
	}

	public void doSave(IProgressMonitor progressMonitor) {
		// Save only resources that have actually changed.
		//
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
				Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		// Do the work within an operation because this is a long running
		// activity that modifies the workbench.
		//
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			// This is the method that gets invoked when the operation runs.
			//
			@Override
			public void execute(IProgressMonitor monitor) {
				// Save the resources to the file system.
				//
				boolean first = true;
				for (Resource resource : editingDomain.getResourceSet()
						.getResources()) {
					if ((first || !resource.getContents().isEmpty() || functions.isPersisted(resource, editingDomain))
							&& !editingDomain.isReadOnly(resource)) {
						try {
							resource.save(saveOptions);
						} catch (IOException exception) {
							ErrorDisplayDialog errord = new ErrorDisplayDialog(
									parent.getShell(),
									new Throwable(
											"Resource couldn't be loaded or saved!"));
							errord.open();
						}
						first = false;
					}
				}
			}
		};

		try {
			// This runs the options, and shows progress.
			//
			new ProgressMonitorDialog(parent.getShell()).run(true, false,
					operation);

			// Refresh the necessary state.
			//
			((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();
			dirtyFlag = false;
			// firePropertyChange(IEditorPart.PROP_DIRTY);
		} catch (InvocationTargetException e) {
			ErrorDisplayDialog errord = new ErrorDisplayDialog(parent
					.getShell(), new Throwable("Resource couldn't be saved!"));
			errord.open();
		} catch (InterruptedException e) {
			ErrorDisplayDialog errord = new ErrorDisplayDialog(parent
					.getShell(), new Throwable("Resource couldn't be saved!"));
			errord.open();
		}
	}

	protected void doSaveAs(URI uri) {
		(editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
		IProgressMonitor progressMonitor = new NullProgressMonitor();
		doSave(progressMonitor);
	}

	public boolean isSaveAsAllowed() {
		return true;
	}

	public void addCheckStateListener(ICheckStateListener iCheckStateListener) {
		checkStateListeners.add(iCheckStateListener);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
