package de.uka.ipd.sdq.cip.completions;

import java.util.ArrayList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.cip.ConstantsContainer;


public class RegisteredCompletion {

	protected final String id;
	protected final String name;
	protected final String image;
	protected final String description;
	protected final String featuremodel;
	protected String metamodel;
	protected final String qvtscript;
	protected final ArrayList<String> categories;
	
	public RegisteredCompletion(String id, String name, String image,
			String description, String featuremodel, String metamodel, String qvtscript,
			ArrayList<String> categories) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.description = description;
		this.featuremodel = featuremodel;
		this.metamodel = metamodel;
		this.qvtscript = qvtscript;
		this.categories = categories;
	}

	public static RegisteredCompletion parseCompletion(
			IConfigurationElement element, String contributor) {
		String featuremodel = null;
		String metamodel = null;
		String qvtscript = null;
		String image = null;
		
		String id = element.getAttribute(ConstantsContainer.ATT_COMPLETION_ID);
		String name = element.getAttribute(ConstantsContainer.ATT_COMPLETION_NAME);
		
		if((image = element.getAttribute(ConstantsContainer.ATT_COMPLETION_IMAGE)) != null)
			image = URI.createPlatformPluginURI("/" + contributor + "/" + image,false).toString();
		
		if((featuremodel = element.getAttribute(ConstantsContainer.ATT_COMPLETION_FEATUREMODEL)) != null)		
			featuremodel = URI.createPlatformPluginURI("/" + contributor + "/" + featuremodel,false).toString();
		
		if((metamodel = element.getAttribute(ConstantsContainer.ATT_COMPLETION_METAMODEL)) != null)
			metamodel = URI.createPlatformPluginURI("/" + contributor + "/" + metamodel,false).toString();
		
		if((qvtscript = element.getAttribute(ConstantsContainer.ATT_COMPLETION_QVTSCRIPT)) != null)
			qvtscript = URI.createPlatformPluginURI("/" + contributor + "/" + qvtscript,false).toString();
		
		IConfigurationElement[] description_node = element.getChildren(ConstantsContainer.NODE_DESCRIPTION);
		String description = description_node[0].getValue();
		
		IConfigurationElement[] categorie_node = element.getChildren(ConstantsContainer.NODE_CATEGORY);
		ArrayList<String> categories = new ArrayList<String>(); 
		for(int i = 0; i < categorie_node.length; ++i) {
			IConfigurationElement category = categorie_node[i];
			categories.add(category.getAttribute(ConstantsContainer.ATT_COMPLETION_NAME));
		}
		

		if(id == null || name == null || description == null || !(featuremodel == null ^ qvtscript == null) || categories.size() < 1)
			return null;
		RegisteredCompletion rc = new RegisteredCompletion(id, name, image, description, featuremodel, metamodel, qvtscript,  categories);
		return rc;
	}
	
	public String getImage() {
		return image;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getFeaturemodel() {
		return featuremodel;
	}

	public String getMetamodel() {
		return metamodel;
	}

	public String getQvtscript() {
		return qvtscript;
	}

	public ArrayList<String> getCategories() {
		return categories;
	}

	public boolean containsCategory(String category) {
		for(String search_category : categories) {
			if(search_category.equals(category))
				return true;
		}
		return false;
	}

}
