//package de.uka.ipd.sdq.pcmsolver.transformations.pcm2capra;
//
//import de.uka.ipd.sdq.capra.CapraFactory;
//import de.uka.ipd.sdq.capra.CapraModel;
//import de.uka.ipd.sdq.capra.ReplicatedProcess;
//import de.uka.ipd.sdq.capra.core.CapraExpression;
//import de.uka.ipd.sdq.capra.simulator.tools.CapraTools;
//import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
//import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
//import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
//import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch;
//import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
//import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
//
//public class Pcm2CapraStrategy implements SolverStrategy {
//
//	CapraModel capraModel;
//	
//	private UsagemodelSwitch<Integer> wlSwitch = new UsagemodelSwitch<Integer>(){
//		@Override
//		public Integer caseClosedWorkload(ClosedWorkload object) {
//			return object.getPopulation();
//		}
//		
//		@Override
//		public Integer caseOpenWorkload(OpenWorkload object) {
//			throw new UnsupportedOperationException();
//		}
//	};
//	
//	public Pcm2CapraStrategy(){
//		capraModel = CapraFactory.eINSTANCE.createCapraModel();
//	}
//	
//	
//	@Override
//	public void loadTransformedModel(String fileName) {
//		capraModel = (CapraModel) CapraTools.loadFromXMI(fileName);
//	}
//
//	@Override
//	public void storeTransformedModel(String fileName) {
//		CapraTools.saveToXMI(capraModel, fileName);
//	}
//
//	@Override
//	public void solve() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void transform(PCMInstance model) {
//		resourceManager = transformResource(model);
//		transformBehaviour(model, resourceManager);
//		
//		
//		// TODO Auto-generated method stub
//
//	}
//
//
//	private ResourceManager transformResource(PCMInstance model) {
//		ResourceManager resourceManager = new ResourceManager(capraModel.getResources());
//		
//		CapraResourceVisitor resourceVisitor = new CapraResourceVisitor(resourceManager);
//		resourceVisitor.doSwitch(model.getResourceEnvironment());
//
//		return resourceManager;
//	}
//
//
//	private void transformBehaviour(PCMInstance model, ResourceManager resources) {
//		for (UsageScenario us : model.getUsageModel().getUsageScenario_UsageModel()){
//			CapraUsageModelVisitor visitor = new CapraUsageModelVisitor();
//
//			CapraExpression behaviour = visitor.doSwitch(us);
//			int numReplicas = wlSwitch.doSwitch(us.getWorkload_UsageScenario());
//			ReplicatedProcess process = createReplicatedProcess(numReplicas,behaviour);
//			capraModel.getProcesses().add(process);
//		}
//	}
//
//
//	private ReplicatedProcess createReplicatedProcess(int numReplicas,
//			CapraExpression behaviour) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
