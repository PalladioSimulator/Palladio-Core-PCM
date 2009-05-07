package org.somox.ui;

import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Preferences;
import org.somox.configuration.ConfigurationDefinition;
import org.somox.controller.SoMoXCoreController;
import org.somox.controller.SoMoXCoreControllerListener;
import org.somox.controller.events.StartAnalyzerEvent;
import org.somox.controller.events.StartExtractorEvent;
import org.somox.core.SoMoXCore;

/**
 * The SoMoX Core Controller
 *
 * @author Benjamin Klatt
 *
 */
public class GUISoMoXCoreController implements SoMoXCoreController {

	// ---------------------------------
	// Static Data Fields
	// ---------------------------------


	// ---------------------------------
	// Data fields
	// ---------------------------------

	/** Internal list of available somox core controller listenern */
	private LinkedList<SoMoXCoreControllerListener> soMoXCoreControllerListenerList = new LinkedList<SoMoXCoreControllerListener>();

	/** The link to the SoMoXCore */
	private SoMoXCore soMoXCore = null;


	// ---------------------------------
	// Constructor
	// ---------------------------------

	/** Constructor publishing this controller to the Activator */
	public GUISoMoXCoreController() {
		Activator.getDefault().setGuiSoMoXCoreController(this);
	}


	// ---------------------------------
	// Business Methods
	// ---------------------------------

	/**
	 * Create a start extraction event and fire it to all controller listeners
	 *
	 * @param progressMonitor The progress monitor to hand over
	 */
	public void startExtraction(IProgressMonitor progressMonitor, Preferences preferences){
		Iterator<SoMoXCoreControllerListener> iterator = soMoXCoreControllerListenerList.iterator();
		StartExtractorEvent event = new StartExtractorEvent(progressMonitor,preferences);
		while(iterator.hasNext()){
			SoMoXCoreControllerListener listener = iterator.next();
			listener.handle(event);
		}
	}

	/**
	 * Start the model analysis process step
	 *
	 * @param progressMonitor
	 */
	public void startAnalyze(String analyzerID, IProgressMonitor progressMonitor, Preferences preferences) {
		Iterator<SoMoXCoreControllerListener> iterator = soMoXCoreControllerListenerList.iterator();
		StartAnalyzerEvent event = new StartAnalyzerEvent(analyzerID, progressMonitor,preferences);
		while(iterator.hasNext()){
			SoMoXCoreControllerListener listener = iterator.next();
			listener.handle(event);
		}
	}


	@Override
	public void register(SoMoXCoreControllerListener listener) {
		SoMoXUILogger.logInfo("register listener: "+listener);
		this.soMoXCoreControllerListenerList.add(listener);
	}

	@Override
	public void unregister(SoMoXCoreControllerListener listener) {
		SoMoXUILogger.logInfo("unregister listener: "+listener);
		this.soMoXCoreControllerListenerList.remove(listener);
	}


	// ---------------------------------
	// Getters / Setters
	// ---------------------------------

	@Override
	public void setSoMoXCore(SoMoXCore somoxCore) {
		this.soMoXCore = somoxCore;
	}

	public LinkedList<ConfigurationDefinition> getConfigurationDefinitions(){
		return soMoXCore.getConfigurationDefinitions();
	}
	
	public LinkedList<ConfigurationDefinition> getGlobalConfigurationDefinitions(){
		return soMoXCore.getGlobalConfigurationDefinitions();
	}
}
