package org.somox.analyzer;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

import de.fzi.gast.accesses.provider.accessesItemProviderAdapterFactory;
import de.fzi.gast.annotations.provider.annotationsItemProviderAdapterFactory;
import de.fzi.gast.core.Root;
import de.fzi.gast.core.provider.coreItemProviderAdapterFactory;
import de.fzi.gast.functions.provider.functionsItemProviderAdapterFactory;
import de.fzi.gast.statements.provider.statementsItemProviderAdapterFactory;
import de.fzi.gast.types.provider.typesItemProviderAdapterFactory;
import de.fzi.gast.variables.provider.variablesItemProviderAdapterFactory;

public class ModelAnalyzerTabGroupBlackboard {
	
	private Root root;

	static int idCounter = 0;
	private int myId = 0;

	public ModelAnalyzerTabGroupBlackboard() {
		idCounter++;
		myId = idCounter;
	}

	public int getId() {
		return myId;
	}

	private String somoxAnalyzerInputFile = null;

	public String getSomoxAnalyzerInputFile() {
		return somoxAnalyzerInputFile;
	}

	public void setSomoxAnalyzerInputFile(String somoxAnalyzerInputFile) {
		if (this.somoxAnalyzerInputFile == null) {
			this.somoxAnalyzerInputFile = somoxAnalyzerInputFile;
			if (this.somoxAnalyzerInputFile != null) {
				if (somoxAnalyzerInputFile.endsWith(".gast")) {
					loadModel();
				}
			}
			fireBlackboardChanged();
		} else if (this.somoxAnalyzerInputFile != null && !this.somoxAnalyzerInputFile.equals(somoxAnalyzerInputFile)) {
			this.somoxAnalyzerInputFile = somoxAnalyzerInputFile;
			if (this.somoxAnalyzerInputFile != null) {
				if (somoxAnalyzerInputFile.endsWith(".gast")) {
					loadModel();
				}
			}
			fireBlackboardChanged();
		}
	}

	private void loadModel() {
		String platformPath = Platform.getInstanceLocation().getURL().getPath();
		platformPath = platformPath + somoxAnalyzerInputFile;
		
		URI fileURI = URI.createFileURI(new File(platformPath).getAbsolutePath());
		
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new statementsItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new coreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new annotationsItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new typesItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new functionsItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new accessesItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new variablesItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		BasicCommandStack commandStack = new BasicCommandStack();

		AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
		
		// Register the default resource factory -- only needed for stand-alone!
		editingDomain.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		//Try to load the resource through the editingDomain.
		Resource resource = null;
		try {
			resource = editingDomain.getResourceSet().getResource(fileURI, true);
		}
		catch (Exception e) {
			resource = editingDomain.getResourceSet().getResource(fileURI, false);
		}
		
		EList<EObject> contents = resource.getContents();
		
		for (EObject current : contents) {
			if (current instanceof Root) {
				root = (Root)current;
				break;
			}
		}
	}
	
	public Root getRoot () {
		return root;
	}

	//
	// Event handling
	//
	private transient Vector<BlackboardListener> blackboardListeners;

	/** Register a listener for Blackboard events */
	synchronized public void addBlackboardListener(BlackboardListener listener) {
		if (blackboardListeners== null) {
			blackboardListeners= new Vector<BlackboardListener>();
		}
		blackboardListeners.addElement(listener);
	}

	synchronized public void removeBlackboardListener(BlackboardListener listener) {
		if (blackboardListeners == null) {
			blackboardListeners= new Vector<BlackboardListener>();
		}
		blackboardListeners.removeElement(listener);
	}

	/** Fire to all registered listeners */
	@SuppressWarnings("unchecked")
	public void fireBlackboardChanged() {
		// If we have no listeners, do nothing.
		if ((blackboardListeners!= null) && !blackboardListeners.isEmpty()) {
			// Make a copy of the listener list in case anyone adds or removes
			// listeners.
			Vector<BlackboardListener> targets;
			synchronized (blackboardListeners) {
				targets = (Vector<BlackboardListener>) blackboardListeners.clone();
			}
			// Walk through the listener list and call the listener method in
			// each.
			Enumeration<BlackboardListener> e = targets.elements();
			while (e.hasMoreElements()) {
				BlackboardListener l = (BlackboardListener) e.nextElement();
				l.blackboardChanged();
			}
		}
	}

}
