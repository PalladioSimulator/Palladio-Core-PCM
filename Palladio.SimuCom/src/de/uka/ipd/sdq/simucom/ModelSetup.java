package de.uka.ipd.sdq.simucom;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.EList;
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
import de.uka.ipd.sdq.simucom.model.simucom.SimulatedUser;
import de.uka.ipd.sdq.simucom.model.simucom.SimulatedWorld;
import de.uka.ipd.sdq.simucom.user.User;
import desmoj.core.simulator.Model;

public class ModelSetup {
	
	protected Model m;
	protected Package umlModel = null;
	protected IConfig myConfig = null;
	protected SimulatedArchitecture simulatedArchitecture = null;
	protected SimulatedWorld simulatedWorld = null;
	
	protected Hashtable<String,Component> simulatedComponents = new Hashtable<String,Component>();
	
	public ModelSetup(Model m, String configFileName) {
		this.m = m;
		try {
			myConfig = new ConfigFileReaderFactory(configFileName).getConfig();
		} catch (Exception e) {
			System.out.println("Error reading config file "+e.getLocalizedMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		ModelLoader.registerResourceFactories();
		ModelLoader.registerPathmaps(URI.createURI(myConfig.getUMLRessourceURI()));
		try{
			simulatedWorld = ModelLoader.loadSimuComModel(myConfig.getSimuComModelURI());
			simulatedArchitecture = simulatedWorld.getArchitecture();
		} catch (Exception e){
			System.out.println("Error while loading simulation model: "+e.getLocalizedMessage());
			System.exit(-1);
		}
	}
	
	public Component getStartComponent(){
		return getSimulatedComponent("Upload Handler");
	}
	
	public Component getSimulatedComponent(String name){
		if (!simulatedComponents.containsKey(name))
		{
			SimulatedComponent simComponent = getComponentFromModel(name);
			Component c = new Component(simComponent.getName());
			for (Iterator i=simComponent.getMethods().iterator(); i.hasNext(); )
			{
				SimulatedMethod m = (SimulatedMethod) i.next();
				c.AddMethod(newMethod(m));
			}
			simulatedComponents.put(name,c);
			return c;
		}
		else
			return simulatedComponents.get(name);
	}
	
	private SimulatedComponent getComponentFromModel(String name) {
		EList components = simulatedArchitecture.getComponents();
		for (Iterator i=components.iterator(); i.hasNext(); )
		{
			SimulatedComponent component = (SimulatedComponent)i.next();
			if (component.getName().equals(name))
				return component;
		}
		return null;
	}

	public Method newMethod(SimulatedMethod method) {
		Method result = new Method(method.getName());
		result.setServiceEffectSpecification(newServiceEffect(method.getServiceEffect()));
		return result;
	}
	
	public ServiceEffect newServiceEffect(de.uka.ipd.sdq.simucom.model.simucom.ServiceEffect serviceEffect) {
		ServiceEffect result = new ServiceEffect();
		result.setActivity(serviceEffect.getActivity());
		return result;
	}
	
	public Vector<User> getUser()
	{
		Vector<User> users = new Vector<User>();
		
		for(Iterator i = simulatedWorld.getUsers().iterator(); i.hasNext(); )
		{
			SimulatedUser user = (SimulatedUser) i.next();
			// TODO: Add user replication
			
			User newUser = new User(m, user.getName(), true);
			newUser.init(user.getActivity(),user.getThinkTime(),user.isThinkFirst(),getStartComponent());
			users.add(newUser);
		}
		return users;
	}
}

