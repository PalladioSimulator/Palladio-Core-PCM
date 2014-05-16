package edu.kit.ipd.sdq.simcomp.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import edu.kit.ipd.sdq.simcomp.component.IActiveResource;
import edu.kit.ipd.sdq.simcomp.component.IPassiveResource;
import edu.kit.ipd.sdq.simcomp.ui.data.SimulationComponentMetaData;
import edu.kit.ipd.sdq.simcomp.ui.data.SimulationComponentType;
import edu.kit.ipd.sdq.simcomp.ui.data.SimulationContextField;

public class SimulationComponentConfigTab extends AbstractLaunchConfigurationTab {

	private List<SimulationComponentType> simCompTypes;

	public SimulationComponentConfigTab() {
		simCompTypes = new ArrayList<SimulationComponentType>();
		// TODO (SimComp): Fetch simulation component and context information from middleware (extension points)

		SimulationComponentType activeResType = new SimulationComponentType(IActiveResource.class, "Active Resource Simulation");
		// specify the context fields
		SimulationContextField resourceType = new SimulationContextField("resource.type", "Resource Type");
		resourceType.addPossibleValue("HDD");
		resourceType.addPossibleValue("CPU");
		activeResType.addContextField(resourceType);
		SimulationContextField container = new SimulationContextField("resource.container", "Resource Container");
		container.addPossibleValue("Container 1");
		container.addPossibleValue("Container 2");
		container.addPossibleValue("Container 3");
		container.addPossibleValue("Container 4");
		container.addPossibleValue("Container 5");
		activeResType.addContextField(container);
		// specify the meta data about available components
		activeResType.addAvailableComponent(new SimulationComponentMetaData("resource.active.eventsim", "EventSim Active Resource"));
		activeResType.addAvailableComponent(new SimulationComponentMetaData("resource.active.alternative", "Alternative Active Resource Sim"));
		simCompTypes.add(activeResType);

		SimulationComponentType pasiveResType = new SimulationComponentType(IPassiveResource.class, "Pasive Resource Simulation");
		// specify the context fields
		SimulationContextField assemblyContext = new SimulationContextField("resource.assemblyCtx", "Assembly Context");
		assemblyContext.addPossibleValue("Assembly Ctx 1");
		assemblyContext.addPossibleValue("Assembly Ctx 2");
		assemblyContext.addPossibleValue("Assembly Ctx 3");
		pasiveResType.addContextField(assemblyContext);
		// specify the meta data about available components
		pasiveResType.addAvailableComponent(new SimulationComponentMetaData("resource.passive.eventsim", "EventSim Passive Resource"));
		pasiveResType.addAvailableComponent(new SimulationComponentMetaData("resource.passive.alternative", "Alternative Passive Resource Sim"));
		simCompTypes.add(pasiveResType);
	}

	@Override
	public void createControl(Composite parent) {
		
		Composite simCompConfig = new Composite(parent, SWT.NONE);
		simCompConfig.setLayout(new GridLayout(1, false));

		Label label = new Label(simCompConfig, SWT.NONE);
		label.setText("Advanced Simulation Component Configuration:");

		// create rule editor for each type
		for (SimulationComponentType simCompType : this.simCompTypes) {
			new SimulationComponentRuleEditor(simCompConfig, simCompType);
		}

		setControl(simCompConfig);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		// TODO (SimComp): Init GUI from the current config. Check if we can
		// check here on ever tab change if the PCM files where selected
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// TODO (SimComp): Store GUI data to config data structure
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO (SimComp): Store default values to config data structure
	}

	@Override
	public String getName() {
		return "Simulation Components";
	}

}
