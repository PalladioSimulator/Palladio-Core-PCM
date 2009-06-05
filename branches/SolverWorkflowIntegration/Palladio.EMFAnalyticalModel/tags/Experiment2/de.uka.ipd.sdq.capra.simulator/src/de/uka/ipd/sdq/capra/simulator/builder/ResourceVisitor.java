package de.uka.ipd.sdq.capra.simulator.builder;

import de.uka.ipd.sdq.capra.extension.PassiveResource;
import de.uka.ipd.sdq.capra.extension.util.ExtensionSwitch;
import de.uka.ipd.sdq.capra.resources.DelayResource;
import de.uka.ipd.sdq.capra.resources.ProcessingResource;
import de.uka.ipd.sdq.capra.resources.Resource;
import de.uka.ipd.sdq.capra.resources.util.ResourcesSwitch;



public class ResourceVisitor {
	private ResourceTransformer resTransformer;
	
	public ResourceVisitor(ResourceTransformer resTransformer) {
		this.resTransformer = resTransformer;
	}
	
	public void visit(Resource resource) {
		if (rSwitch.doSwitch(resource) == null){
			if (eSwitch.doSwitch(resource) == null){
				System.out.println("Unknown resource type: "+ resource.eClass().getName());
			}
		}
	}
	
	
	ResourcesSwitch<Boolean> rSwitch = new ResourcesSwitch<Boolean>() {
		@Override
		public Boolean caseDelayResource(DelayResource object) {
			resTransformer.transformDelayResource(object);
			return true;
		}
		
		@Override
		public Boolean caseProcessingResource(ProcessingResource object) {
			resTransformer.transformProcessingResource(object);
			return true;
		}		
	};
	
	ExtensionSwitch<Boolean> eSwitch = new ExtensionSwitch<Boolean>() {
		@Override
		public Boolean casePassiveResource(PassiveResource object) {
			resTransformer.transformPassiveResource(object);
			return true;
		}
	};
}
