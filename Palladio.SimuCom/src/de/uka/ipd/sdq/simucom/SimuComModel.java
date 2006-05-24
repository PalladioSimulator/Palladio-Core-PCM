package de.uka.ipd.sdq.simucom;

import java.util.Vector;

import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.Package;
import org.eclipse.uml2.UML2Package;

import com.sun.security.auth.login.ConfigFile;

import de.uka.ipd.sdq.simucom.user.User;
import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimTime;

public class SimuComModel extends Model {

	protected ModelSetup setup;
	protected String configFile = null;
	Vector<User> users = null;
	protected DistributionObjectsStorage distributionStorage = null;
	
	public SimuComModel(Model arg0, String arg1, boolean arg2, boolean arg3, String configFile) {
		super(arg0, arg1, arg2, arg3);
		this.configFile = configFile;
		this.distributionStorage = new DistributionObjectsStorage(this);
	}

	@Override
	public String description() {
		return "SimuCom Simulation";
	}

	@Override
	public void doInitialSchedules() {
		for (User u : users)
		{
			u.activate(new SimTime(0));
		}
	}

	@Override
	public void init() {
		setup =  new ModelSetup(this, configFile);
		users = setup.getUser();
	}

	public DistributionObjectsStorage getDistributionObjectsStorage()
	{
		return distributionStorage;
	}
}
