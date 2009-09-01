package de.fzi.stanja.ui.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.preference.IPreferenceStore;

import de.fzi.stanja.core.access.JdtHelper;
import de.fzi.stanja.ui.StanjaUiConstants;

public class PreferencePolicy {
	
	private static final List<PreferencePolicy> policiesList = new ArrayList<PreferencePolicy>();

	static {
		List<IConfigurationElement> policyElements = JdtHelper.getAllPoliciesListFromExtentions();
		for (IConfigurationElement policyElement : policyElements){
			IPreferenceStore store = StanjaUiConstants.STANJA_UI_PREFERENCE_STORE;
			String id = policyElement.getAttribute("id");
			String name = policyElement.getAttribute("name");
			String analyzerId =(( IConfigurationElement) policyElement.getParent()).getAttribute("id");
			boolean active = store.getBoolean("POLICY_"+id);
			PreferencePolicy preferencePolicy = new PreferencePolicy(active, id, name, analyzerId);
			policiesList.add(preferencePolicy);
		}
	}
	


	private boolean active; 
	private String id;
	private String name;
	private String analyzerId;
	
	
	private PreferencePolicy(boolean active,String id, String name, String analyzerId){
		this.active = active;
		this.id = id; 
		this.name = name; 
		this.analyzerId = analyzerId; 
	}

	
	public boolean isActive() {
		return active;
	}
	
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	public static List<PreferencePolicy> getPolicieslist() {
		return policiesList;
	}
	
	
	public String getId() {
		return id;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public String getAnalyzerId() {
		return analyzerId;
	}
}
