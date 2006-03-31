package de.uka.ipd.simucom;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.Activity;
import org.eclipse.uml2.Element;
import org.eclipse.uml2.Package;

import de.uka.ipd.simucom.component.Component;
import de.uka.ipd.simucom.component.Method;
import de.uka.ipd.simucom.component.ServiceEffect;
import de.uka.ipd.siucom.config.ConfigFileReaderFactory;
import de.uka.ipd.siucom.config.IConfig;
import desmoj.core.simulator.Model;

public class ModelSetup {
	
	protected Model m;
	protected Package umlModel = null;
	protected IConfig myConfig = null;
	
	public ModelSetup(Model m, String configFileName) {
		this.m = m;
		try {
			myConfig = new ConfigFileReaderFactory(configFileName).getConfig();
		} catch (Exception e) {
			System.out.println("Error reading config file "+e.getLocalizedMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		UMLLoader.registerResourceFactories();
		UMLLoader.registerPathmaps(URI.createURI(myConfig.getUMLRessourceURI()));
		umlModel = UMLLoader.load(myConfig.getUMLModelURI());
	}
	
	public Component getStartComponent(){
		Component outer = new Component("SC1");
		outer.AddMethod(newMethod("a"));
		outer.AddMethod(newMethod("b"));
		
		return outer;
	}
	
	public Method newMethod(String ID) {
		Method result = new Method(ID,m);
		result.setServiceEffectSpecification(newServiceEffect("SE1"));
		return result;
	}
	
	
	public ServiceEffect newServiceEffect(String ID) {
		ServiceEffect result = new ServiceEffect(ID,m);
		List elements = umlModel.getOwnedElements();
		Iterator i = elements.iterator(); Element e = null;
		while((e = (Element)i.next())!=null)
		{
			if (e instanceof Activity)
				break;
		}
		result.setActivity((Activity)e);
		return result;
	}
}
