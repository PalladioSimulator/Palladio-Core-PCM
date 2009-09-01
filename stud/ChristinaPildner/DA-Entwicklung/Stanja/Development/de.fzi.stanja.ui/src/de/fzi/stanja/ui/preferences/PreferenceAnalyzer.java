package de.fzi.stanja.ui.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.preference.IPreferenceStore;

import de.fzi.stanja.core.access.JdtHelper;
import de.fzi.stanja.ui.StanjaUiConstants;

/**
 * @author Christina
 *
 */
public final class PreferenceAnalyzer {

	private static final List<PreferenceAnalyzer> analyzerList = new ArrayList<PreferenceAnalyzer>();

	/*creates the list of the analyzers. this list is going to be used for the preferences set*/
	static {
		IConfigurationElement[] analyzerElements = JdtHelper.getAnalyzerArrayFromExtentions();
		for (IConfigurationElement analyzerElement : analyzerElements){
			IPreferenceStore store = StanjaUiConstants.STANJA_UI_PREFERENCE_STORE;
			String id = analyzerElement.getAttribute("id");
			String name = analyzerElement.getAttribute("name");
			boolean active = store.getBoolean("ANALYZER_"+id);
			PreferenceAnalyzer preferenceAnalyzer = new PreferenceAnalyzer(active, id, name);
			analyzerList.add(preferenceAnalyzer);
		}

	}

	/* the attributes of an analyzer */
	private boolean active;
	private String id;
	private String name;
	/**
	 * the preference store the analyzer objects are made;
	 */
	private PreferenceAnalyzer(boolean active, String id, String name) {
		this.active = active;
		this.id = id;
		this.name = name;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	
	public static List<PreferenceAnalyzer> getAnalyzerlist() {
		return analyzerList;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}




	public void finalize() {
		analyzerList.remove(this);
	}
}
