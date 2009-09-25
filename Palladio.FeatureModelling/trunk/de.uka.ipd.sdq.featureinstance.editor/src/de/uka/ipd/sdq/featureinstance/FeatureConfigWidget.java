package de.uka.ipd.sdq.featureinstance;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
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
import de.uka.ipd.sdq.featureconfig.provider.featureconfigItemProviderAdapterFactory;
import de.uka.ipd.sdq.featuremodel.ChildRelation;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.FeatureDiagram;
import de.uka.ipd.sdq.featuremodel.FeatureGroup;
import de.uka.ipd.sdq.featuremodel.Simple;
import de.uka.ipd.sdq.featuremodel.provider.featuremodelItemProviderAdapterFactory;
import de.uka.ipd.sdq.identifier.provider.IdentifierItemProviderAdapterFactory;

public class FeatureConfigWidget {

	private Composite parent;
	private String sourceInput;
	private String targetInput;
	private int style;
	protected AdapterFactoryEditingDomain editingDomain;
	protected ComposedAdapterFactory adapterFactory;
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

	public FeatureConfigWidget(Composite parent) {
		this.parent = parent;
		initializeEditingDomain();
	}

	public void setSourceInput(String sourceInput) {
		this.sourceInput = sourceInput;
	}

	public void setTargetInput(String targetInput) {
		this.targetInput = targetInput;
	}

	/**
	 * Initializes the adapterFactory, the commandStack and with these objects
	 * the editingDomain
	 */
	protected void initializeEditingDomain() {
		adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new featureconfigItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new featuremodelItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new IdentifierItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		BasicCommandStack commandStack = new BasicCommandStack();

		editingDomain = new AdapterFactoryEditingDomain(adapterFactory,
				commandStack, new HashMap<Resource, Boolean>());
	}

	public boolean createPages() {
		boolean valid = checkValid();
		if (valid) {
			createResource();
			createEditor();
		} else {
			return false;
		}
		return true;
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
		Configuration configuration = getConfiguration(resource);

		EList<FeatureConfig> tempOverrides = configuration.getConfigOverrides();
		FeatureConfig tempDefault = configuration.getDefaultConfig();

		// Both FeatureConfigs are null
		if ((tempOverrides == null || tempOverrides.isEmpty())
				&& tempDefault == null) {
			return false;
		} else if (tempOverrides == null && tempDefault != null) { // default
																	// exists
			EList<ConfigNode> configList = tempDefault.getConfignode();

			if (!configList.isEmpty()) {
				// Try to reference the Feature Diagram object and create a new
				// overrides from it
				featureDiagram = navigateToFeatureDiagram((Feature) configList
						.iterator().next().getOrigin());

				// start wizard an ask for a new file location
				// *.featureconfig with only a default config shall only be used
				// as template
				URI newResourceURI = URI.createPlatformResourceURI(targetInput,
						true);
				createNewConfigResource(newResourceURI, featureDiagram,
						tempDefault);
			} else {
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
				featureDiagram = navigateToFeatureDiagram((Feature) configList
						.iterator().next().getOrigin());
				overridesConfig = featureConfig;
				URI newResourceURI = URI.createPlatformResourceURI(targetInput,
						true);
				doSaveAs(newResourceURI);
			} else {
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
					featureDiagram = navigateToFeatureDiagram((Feature) configList
							.iterator().next().getOrigin());
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
					featureDiagram = navigateToFeatureDiagram((Feature) configList
							.iterator().next().getOrigin());
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

		}
		treeViewer.setInput(root);
		treeViewer.expandAll();

		if (root != null) {
			treeViewer.setGrayed(root.getRootFeature(), true);

			// Gray FeatureGroups
			Feature curRoot = root.getRootFeature();
			grayFeatureGroups(curRoot.getChildrelation());
		}

		if (defaultConfig != null) {
			markDefaultConfig();
		}
		if (overridesConfig != null) {
			markOverridesConfig();
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
					if ((event.getElement() instanceof Feature)
							&& (checkMandatory((Feature) event.getElement()))) {
						if (parent instanceof ChildRelation) {
							parent = editingDomain.getParent(parent);
						}

						if (treeViewer.getChecked(parent)) {
							treeViewer.setChecked(event.getElement(), true);
						}
					}
					// check if node is NOT the root node
					if (parent != null && !(parent instanceof FeatureDiagram)) {
						if (treeViewer.getGrayed(event.getElement())) {
							treeViewer.setGrayed(event.getElement(), false);
						}

						// check/uncheck recursively
						if (event.getChecked()) {
							uncheckInModel((Feature) event.getElement(), true);
							checkParents(event.getElement());
						} else {
							uncheckInModel((Feature) event.getElement(), false);
							uncheckParents(event.getElement());
						}
					}
					// make root node readonly
					else {
						treeViewer.setChecked(event.getElement(), !(event
								.getChecked()));
					}
				}
			}
		};

		treeViewer.addCheckStateListener(listener);
		// createContextMenuFor(treeViewer);

		// Selects all mandatory Features
		if (root != null) {
			Feature curRoot = root.getRootFeature();
			selectMandatoryFeatures(curRoot.getChildrelation());
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
	 * Checks if the Configuration object can be accessed in the loaded resource
	 * and returns it if possible
	 * 
	 * @param resource
	 *            The resource from which the Configuration-object can be
	 *            accessed (a *.featureconfig-file)
	 * @return Returns a Configuration-object or null, if it can be accessed
	 *         (e.g. no *.featureconfig-file)
	 */
	private Configuration getConfiguration(Resource resource) {
		System.out.println("Get Configuration: begin");

		EList<EObject> tempList = resource.getContents();
		System.out.println("Get Configuration: got contents");
		Iterator<EObject> tempIterator = tempList.iterator();
		EObject newResource;
		if (tempIterator.hasNext()) {
			System.out.println("Get Configuration: iterator has elements");
			newResource = tempIterator.next();
		} else {
			System.out.println("Get Configuration: contents empty");
			return null;
		}

		if (!(newResource instanceof Configuration)) {
			return null;
		}
		return (Configuration) newResource;
	}

	// TODO: Change to validate functionality
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
			return false;
		}
		return true;
	}

	/**
	 * Navigates to the FeatureDiagram from a given Feature-object
	 * 
	 * @param feature
	 *            A Feature-object
	 * @return the parent FeatureDiagram to the given Feature-object
	 */
	protected FeatureDiagram navigateToFeatureDiagram(Feature feature) {
		Object parent = editingDomain.getParent(feature);

		while (parent != null && !(parent instanceof FeatureDiagram)) {
			parent = editingDomain.getParent(parent);
		}

		// FIXME: handle the case when no parent was found
		return (FeatureDiagram) parent;
	}

	/**
	 * Checks if a newly loaded featureconfig-file references the opened
	 * FeatureDiagram resource
	 * 
	 * @param existingResource
	 *            Newly loaded Resource-object (should be a featureconfig-file)
	 * @return <code>false</code>, if existingResource doesn't include a
	 *         Configuration-object or if no ConifgNode references to the opened
	 *         model <code>true</code> otherwise
	 */
	protected boolean isFeatureDiagramReferenceCorrect(Resource existingResource) {
		Configuration configuration = getConfiguration(existingResource);

		boolean correct = false;

		if (configuration == null) {
			return correct;
		} else {
			EList<FeatureConfig> tempOverrides = configuration
					.getConfigOverrides();
			FeatureConfig tempDefault = configuration.getDefaultConfig();

			if (tempOverrides != null && !tempOverrides.isEmpty()) {
				EList<ConfigNode> configList = tempOverrides.get(0)
						.getConfignode(); // Assumption: Every config references
											// the same Feature Diagram
				if (!(configList.isEmpty())) {
					Iterator<ConfigNode> configIterator = configList.iterator();
					while (configIterator.hasNext()) {
						if (configIterator.next().getOrigin() != null) {
							correct = true;
						}
					}
				}
			}

			if (!correct && tempDefault != null) {
				EList<ConfigNode> configList = tempDefault.getConfignode();
				if (!(configList.isEmpty())) {
					Iterator<ConfigNode> configIterator = configList.iterator();
					while (configIterator.hasNext()) {
						if (configIterator.next().getOrigin() != null) {
							correct = true;
						}
					}
				}
			}
		}
		return correct;
	}

	/**
	 * Selects recursively the mandatory Features
	 * 
	 * @param curRelation
	 *            The ChildRelation, where the selecting should start
	 */
	protected void selectMandatoryFeatures(ChildRelation curRelation) {
		if (curRelation != null) {
			if (curRelation instanceof FeatureGroup) {
				EList<Feature> nodes = ((FeatureGroup) curRelation)
						.getChildren();
				Iterator<Feature> nodesIter = nodes.iterator();
				while (nodesIter.hasNext()) {
					selectMandatoryFeatures(nodesIter.next().getChildrelation());
				}
			} else if (curRelation instanceof Simple) {
				EList<Feature> mandFeatures = ((Simple) curRelation)
						.getMandatoryChildren();
				EList<Feature> optFeatures = ((Simple) curRelation)
						.getOptionalChildren();

				Iterator<Feature> featureIter = mandFeatures.iterator();
				while (featureIter.hasNext()) {
					Feature next = featureIter.next();
					treeViewer.setChecked(next, true);
					uncheckInModel(next, true);
					selectMandatoryFeatures(next.getChildrelation());
				}

				featureIter = optFeatures.iterator();
				while (featureIter.hasNext()) {
					selectMandatoryFeatures(featureIter.next()
							.getChildrelation());
				}
			}
		}
	}

	/**
	 * Registers changes made in the TreeViewer to the resource
	 * 
	 * @param element
	 *            The changed Feature
	 * @param state
	 *            The checked/unchecked state
	 */
	protected void uncheckInModel(Feature element, boolean state) {
		dirtyFlag = true;
		// firePropertyChange(IEditorPart.PROP_DIRTY);
		int hash = element.hashCode();
		boolean found = false;
		Iterator<ConfigNode> tempIter = overridesConfig.getConfignode()
				.iterator();

		// search for existing ConfigNodes in the overridesConfig and register
		// changes
		while (tempIter.hasNext()) {
			ConfigNode next = tempIter.next();
			if (next.getOrigin().hashCode() == hash) {
				found = true;
				if (state) {
					next.setConfigState(ConfigState.SELECTED);
				} else {
					next.setConfigState(ConfigState.ELIMINATED);
				}
			}
		}

		// if no ConfigNode exists, create new one
		if (!(found)) {
			featureconfigFactoryImpl factory = new featureconfigFactoryImpl();
			ConfigNode newConfig = factory.createConfigNode();
			newConfig.setOrigin(element);

			if (state) {
				newConfig.setConfigState(ConfigState.SELECTED);
			} else {
				newConfig.setConfigState(ConfigState.ELIMINATED);
			}
			overridesConfig.getConfignode().add(newConfig);
		}
	}

	/**
	 * Checks/unchecks the defaultConfiguration in the Viewer
	 */
	protected void markDefaultConfig() {
		// mark all default configNodes
		EList<ConfigNode> defaultNodes = defaultConfig.getConfignode();
		Iterator<ConfigNode> tempIter = defaultNodes.iterator();
		ConfigNode next;
		Feature referenced;
		while (tempIter.hasNext()) {
			next = tempIter.next();
			referenced = (Feature) next.getOrigin();

			// selected
			if (next.getConfigState().getValue() == 0) {
				treeViewer.setGrayChecked(referenced, true);
			}
			// eliminated
			else if (next.getConfigState().getValue() == 1) {
				treeViewer.setGrayChecked(referenced, false);
			}
		}
	}

	/**
	 * Checks/unchecks the configurationOverrides in the Viewer
	 */
	protected void markOverridesConfig() {
		// mark all overrides configNodes
		EList<ConfigNode> overridesNodes = overridesConfig.getConfignode();
		Iterator<ConfigNode> tempIter = overridesNodes.iterator();
		ConfigNode next;
		Feature referenced;
		while (tempIter.hasNext()) {
			next = tempIter.next();
			referenced = (Feature) next.getOrigin();

			// selected
			if (next.getConfigState().getValue() == 0) {
				treeViewer.setGrayed(referenced, false);
				treeViewer.setChecked(referenced, true);
			}
			// eliminated
			else if (next.getConfigState().getValue() == 1) {
				treeViewer.setGrayed(referenced, false);
				treeViewer.setChecked(referenced, false);
			}
		}
	}

	/**
	 * Unchecks recursively parent nodes, if no children nodes are checked
	 * 
	 * @param current
	 *            The unchecked Feature
	 */
	protected void uncheckParents(Object current) {
		boolean checked = getAnyChecked(current);

		if (!checked) {
			Object parent = editingDomain.getParent(current);

			if (parent != null && !(parent instanceof FeatureDiagram)) {
				treeViewer.setChecked(parent, false);

				if (parent instanceof Feature) {
					uncheckInModel((Feature) parent, false);
				}
				uncheckParents(parent);
			}
		}
	}

	/**
	 * Checks recursively parent nodes, if a Node is checked
	 * 
	 * @param current
	 *            The checked Feature
	 */
	protected void checkParents(Object current) {
		Object parent = editingDomain.getParent(current);
		if (parent != null) {
			if (!(treeViewer.getChecked(parent))) {
				if (!(parent instanceof FeatureGroup)) {
					treeViewer.setChecked(parent, true);
				}

				if (parent instanceof Feature) {
					uncheckInModel((Feature) parent, true);
				}
				checkParents(parent);
			}
		}
	}

	/**
	 * Checks, if any siblings of the selected Node are also selected
	 * 
	 * @param current
	 * @return <code>true</code> if there are any siblings of current checked
	 *         <code>false</code> otherwise
	 */
	protected boolean getAnyChecked(Object current) {
		Object parent = editingDomain.getParent(current);

		boolean checked = false;

		if (parent instanceof FeatureGroup) {
			EList<Feature> children = ((FeatureGroup) parent).getChildren();
			Iterator<Feature> tempIter = children.iterator();
			Feature next;
			while (tempIter.hasNext()) {
				next = tempIter.next();
				if (treeViewer.getChecked(next)) {
					checked = true;
				}
			}
		} else if (parent instanceof Feature) {
			ChildRelation childRel = ((Feature) parent).getChildrelation();
			if (!(childRel instanceof FeatureGroup)) {
				EList<Feature> childrenMan = ((Simple) childRel)
						.getMandatoryChildren();
				EList<Feature> childrenOpt = ((Simple) childRel)
						.getOptionalChildren();

				Iterator<Feature> manIter = childrenMan.iterator();
				Feature next;
				while (manIter.hasNext()) {
					next = manIter.next();
					if (treeViewer.getChecked(next)) {
						checked = true;
					}
				}
				if (!checked) {
					Iterator<Feature> optIter = childrenOpt.iterator();
					while (optIter.hasNext()) {
						next = optIter.next();
						if (treeViewer.getChecked(next)) {
							checked = true;
						}
					}
				}
			}
		}

		return checked;
	}

	/**
	 * Checks if a Feature `node` is a mandatory Feature
	 * 
	 * @param node
	 *            The Feature which needs to be checked
	 * @return <code>true</code>, if node is a mandatory Feature
	 *         <code>false</code>, else
	 */
	protected boolean checkMandatory(Feature node) {
		Object parent = editingDomain.getParent(node);

		boolean mandatory = false;

		if (parent instanceof Simple) {
			EList<Feature> featureList = ((Simple) parent)
					.getMandatoryChildren();

			for (Feature current : featureList) {
				if (current == node) {
					mandatory = true;
				}
			}
		}

		return mandatory;
	}

	/**
	 * Grays out the FeatureGroups in the treeViewer
	 * 
	 * @param curRoot
	 *            The current ChildRelation
	 */
	protected void grayFeatureGroups(ChildRelation curRelation) {
		if (curRelation != null) {
			if (curRelation instanceof FeatureGroup) {
				treeViewer.setGrayed(curRelation, true);
				EList<Feature> nodes = ((FeatureGroup) curRelation)
						.getChildren();
				Iterator<Feature> nodesIter = nodes.iterator();
				while (nodesIter.hasNext()) {
					grayFeatureGroups(nodesIter.next().getChildrelation());
				}
			} else if (curRelation instanceof Simple) {
				EList<Feature> mandFeatures = ((Simple) curRelation)
						.getMandatoryChildren();
				EList<Feature> optFeatures = ((Simple) curRelation)
						.getOptionalChildren();

				Iterator<Feature> featureIter = mandFeatures.iterator();
				while (featureIter.hasNext()) {
					grayFeatureGroups(featureIter.next().getChildrelation());
				}

				featureIter = optFeatures.iterator();
				while (featureIter.hasNext()) {
					grayFeatureGroups(featureIter.next().getChildrelation());
				}
			}
		}
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
					if ((first || !resource.getContents().isEmpty() || isPersisted(resource))
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

	/**
	 * This returns whether something has been persisted to the URI of the
	 * specified resource. The implementation uses the URI converter from the
	 * editor's resource set to try to open an input stream. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected boolean isPersisted(Resource resource) {
		boolean result = false;
		try {
			InputStream stream = editingDomain.getResourceSet()
					.getURIConverter().createInputStream(resource.getURI());
			if (stream != null) {
				result = true;
				stream.close();
			}
		} catch (IOException e) {
			// Ignore
		}
		return result;
	}

	protected void doSaveAs(URI uri) {
		(editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
		IProgressMonitor progressMonitor = new NullProgressMonitor();
		doSave(progressMonitor);
	}

	public boolean isSaveAsAllowed() {
		return true;
	}

}
