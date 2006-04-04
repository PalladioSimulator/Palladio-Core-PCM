package de.uka.ipd.sdq.simucom;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.Activity;
import org.eclipse.uml2.Element;
import org.eclipse.uml2.Package;

import de.uka.ipd.sdq.simucom.component.Component;
import de.uka.ipd.sdq.simucom.component.Method;
import de.uka.ipd.sdq.simucom.component.ServiceEffect;
import de.uka.ipd.sdq.simucom.config.ConfigFileReaderFactory;
import de.uka.ipd.sdq.simucom.config.IConfig;
import de.uka.ipd.sdq.simucom.model.simucom.SimulatedArchitecture;
import de.uka.ipd.sdq.simucom.model.simucom.SimulatedComponent;
import de.uka.ipd.sdq.simucom.model.simucom.SimulatedMethod;

import desmoj.core.simulator.Model;

public class ModelSetup {
	
	protected Model m;
	protected Package umlModel = null;
	protected IConfig myConfig = null;
	protected SimulatedArchitecture sa = null;
	
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
		sa = UMLLoader.loadSimuComModel("C:/Dokumente und Einstellungen/Snowball/runtime-workbench-workspace/p/My.simucom");
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
		// result.setActivity((Activity)e);
		SimulatedComponent sc = (SimulatedComponent)sa.getComponents().get(0);
		SimulatedMethod sm = (SimulatedMethod) sc.getMethods().get(0);
		result.setActivity((Activity)sm.getServiceEffect().getActivity().get(0));
		return result;
	}
}
