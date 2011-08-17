package de.uka.ipd.sdq.featureinstance;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.jface.viewers.CheckboxTreeViewer;

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

public class FeatureConfigFunctionality {
	
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
	public Configuration getConfiguration(Resource resource) {
		EList<EObject> tempList = resource.getContents();
		Iterator<EObject> tempIterator = tempList.iterator();
		EObject newResource;
		if (tempIterator.hasNext()) {
			newResource = tempIterator.next();
		} else {
			return null;
		}

		if (!(newResource instanceof Configuration)) {
			return null;
		}
		return (Configuration) newResource;
	}
	

	/**
	 * Unchecks recursively parent nodes, if no children nodes are checked
	 * 
	 * @param current
	 *            The unchecked Feature
	 */
	public void uncheckParents(Object current, CheckboxTreeViewer treeViewer, FeatureConfig overridesConfig, AdapterFactoryEditingDomain editingDomain) {
		boolean checked = getAnyChecked(current, treeViewer, editingDomain);

		if (!checked) {
			Object parent = editingDomain.getParent(current);

			if (parent != null && !(parent instanceof FeatureDiagram)) {
				treeViewer.setChecked(parent, false);

				if (parent instanceof Feature) {
					uncheckInModel((Feature) parent, false, overridesConfig);
				}
				uncheckParents(parent, treeViewer,overridesConfig, editingDomain);
			}
		}
	}
	
	/**
	 * Checks, if any siblings of the selected Node are also selected
	 * 
	 * @param current
	 * @return <code>true</code> if there are any siblings of current checked
	 * 		   <code>false</code> otherwise
	 */
	private boolean getAnyChecked (Object current, CheckboxTreeViewer treeViewer, AdapterFactoryEditingDomain editingDomain) {
		Object parent = editingDomain.getParent(current);

		boolean checked = false;

		if (parent instanceof FeatureGroup) {
			EList<Feature> children = ((FeatureGroup) parent).getChildren();
			Iterator<Feature> tempIter = children.iterator();
			Feature next;
			while(tempIter.hasNext()) {
				next = tempIter.next();
				if (treeViewer.getChecked(next)) {
					checked = true;
				}
			}
		}
		else if (parent instanceof Feature) {
			ChildRelation childRel = ((Feature) parent).getChildrelation();
			if (!(childRel instanceof FeatureGroup)) {
				EList<Feature> childrenMan = ((Simple)childRel).getMandatoryChildren();
				EList<Feature> childrenOpt = ((Simple)childRel).getOptionalChildren();
				
				Iterator<Feature> manIter = childrenMan.iterator();
				Feature next;
				while(manIter.hasNext()) {
					next = manIter.next();
					if (treeViewer.getChecked(next)) {
						checked = true;
					}
				}
				if (!checked) {
					Iterator<Feature> optIter = childrenOpt.iterator();
					while(optIter.hasNext()) {
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
	 * Checks recursively parent nodes, if a Node is checked
	 * 
	 * @param current
	 *            The checked Feature
	 */
	protected void checkParents(Object current, CheckboxTreeViewer treeViewer, FeatureConfig overridesConfig, AdapterFactoryEditingDomain editingDomain) {
		Object parent = editingDomain.getParent(current);
		if (parent != null) {
			if (!(treeViewer.getChecked(parent))) {
				if (!(parent instanceof FeatureGroup)) {
					treeViewer.setChecked(parent, true);
				}

				if (parent instanceof Feature) {
					uncheckInModel((Feature) parent, true, overridesConfig);
				}
				checkParents(parent, treeViewer, overridesConfig, editingDomain);
			}
		}
	}
	
	/**
	 * Navigates to the FeatureDiagram from a given Feature-object
	 * 
	 * @param feature
	 *            A Feature-object
	 * @param editingDomain The necessary editingDomain
	 * @return the parent FeatureDiagram to the given Feature-object
	 */
	public FeatureDiagram navigateToFeatureDiagram(Feature feature, AdapterFactoryEditingDomain editingDomain) {
		Object parent = editingDomain.getParent(feature);

		while (parent != null && !(parent instanceof FeatureDiagram)) {
			parent = editingDomain.getParent(parent);
		}

		return (FeatureDiagram) parent;
	}
	
	/**
	 * Initializes the adapterFactory, the commandStack and with these objects
	 * the editingDomain
	 */
	public AdapterFactoryEditingDomain initializeEditingDomain() {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
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

		return new AdapterFactoryEditingDomain(adapterFactory,
				commandStack, new HashMap<Resource, Boolean>());
	}
	
	/**
	 * Checks if a newly loaded featureconfig-file references the opened FeatureDiagram resource
	 * 
	 * @param existingResource Newly loaded Resource-object (should be a featureconfig-file)
	 * @return <code>false</code>, if existingResource doesn't include a Configuration-object or if no ConifgNode references to the opened model
	 * 		   <code>true</code> otherwise
	 */
	public boolean isFeatureDiagramReferenceCorrect (Resource existingResource) {
		Configuration configuration = getConfiguration(existingResource);
		
		boolean correct = false;
		
		if (configuration == null) {
			return correct;
		}
		else {
			EList<FeatureConfig> tempOverrides = configuration.getConfigOverrides();
			FeatureConfig tempDefault = configuration.getDefaultConfig();
			
			if (tempOverrides != null && !tempOverrides.isEmpty()) {				
				EList <ConfigNode> configList = tempOverrides.get(0).getConfignode(); //Assumption: Every config references the same Feature Diagram 
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
				EList <ConfigNode> configList = tempDefault.getConfignode();
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
	public void selectMandatoryFeatures(ChildRelation curRelation, CheckboxTreeViewer treeViewer, FeatureConfig overridesConfig) {
		if (curRelation != null) {
			if (curRelation instanceof FeatureGroup) {
				EList<Feature> nodes = ((FeatureGroup) curRelation)
						.getChildren();
				Iterator<Feature> nodesIter = nodes.iterator();
				while (nodesIter.hasNext()) {
					selectMandatoryFeatures(nodesIter.next().getChildrelation(), treeViewer, overridesConfig);
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
					uncheckInModel(next, true, overridesConfig);
					selectMandatoryFeatures(next.getChildrelation(), treeViewer, overridesConfig);
				}

				featureIter = optFeatures.iterator();
				while (featureIter.hasNext()) {
					selectMandatoryFeatures(featureIter.next()
							.getChildrelation(), treeViewer, overridesConfig);
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
	public void uncheckInModel(Feature element, boolean state, FeatureConfig overridesConfig) {
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
	public void markDefaultConfig(FeatureConfig defaultConfig, CheckboxTreeViewer treeViewer) {
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
	public void markOverridesConfig(FeatureConfig overridesConfig, CheckboxTreeViewer treeViewer) {
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
	 * Checks if a Feature `node` is a mandatory Feature
	 * 
	 * @param node
	 *            The Feature which needs to be checked
	 * @return <code>true</code>, if node is a mandatory Feature
	 *         <code>false</code>, else
	 */
	public boolean checkMandatory(Feature node, AdapterFactoryEditingDomain editingDomain) {
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
	 * @param curRoot The current ChildRelation
	 */
	public void grayFeatureGroups (ChildRelation curRelation, CheckboxTreeViewer treeViewer) {
		if (curRelation != null) {
			if (curRelation instanceof FeatureGroup) {
				treeViewer.setGrayed(curRelation, true);
				EList<Feature> nodes = ((FeatureGroup)curRelation).getChildren();
				Iterator<Feature> nodesIter = nodes.iterator();
				while (nodesIter.hasNext()) {
					grayFeatureGroups(nodesIter.next().getChildrelation(), treeViewer);
				}
			}
			else if(curRelation instanceof Simple) {
				EList<Feature> mandFeatures = ((Simple)curRelation).getMandatoryChildren();
				EList<Feature> optFeatures = ((Simple)curRelation).getOptionalChildren();
				
				Iterator<Feature> featureIter = mandFeatures.iterator();
				while (featureIter.hasNext()) {
					grayFeatureGroups(featureIter.next().getChildrelation(), treeViewer);
				}
				
				featureIter = optFeatures.iterator();
				while (featureIter.hasNext()) {
					grayFeatureGroups(featureIter.next().getChildrelation(), treeViewer);
				}
			}
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
	protected boolean isPersisted(Resource resource, AdapterFactoryEditingDomain editingDomain) {
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
}
