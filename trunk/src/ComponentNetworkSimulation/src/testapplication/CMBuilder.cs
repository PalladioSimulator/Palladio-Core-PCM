using System;
using Palladio.FiniteStateMachines;
using Palladio.ComponentModel;
using ComponentNetworkSimulation.Structure.Elements;
using ComponentNetworkSimulation.Structure;
using Palladio.Identifier;

namespace Palladio.CM.Example
{
	/// <summary>
	/// Zusammenfassung für CMBuilder.
	/// </summary>
	public class CMBuilder
	{
		public static IComponent CreateCompositeComponent()
		{
			ICompositeComponent cc = ComponentFactory.CreateCompositeComponent("CompCom");
			IComponent[] comps = new IComponent[2];
			comps[0] = CreateC1();
			comps[1] = CreateC2();
			cc.AddComponents(comps);
			cc.AddProvidesInterface(ID("P1"),CreateProvidesInterfaceP1());

			IBinding binding = ComponentFactory.CreateBinding(comps[0],ID("R1"),comps[1],ID("P2"));
			cc.AddBindings(binding);
			IMapping mapping = ComponentFactory.CreateProvidesMapping(
				cc,ID("P1"),comps[0],ID("P1"));
			cc.AddProvidesMappings(mapping);

			return cc;
		}

		public static IComponent CreateC2()
		{
			IBasicComponent c2 = ComponentFactory.CreateBasicComponent("C2");
			IInterfaceModel provides = CreateProvidesInterfaceP2();
			c2.AddProvidesInterface(ID("P2"),provides);

			c2.AddServiceEffectSpecification(ID("P2"),provides.SignatureList.GetSignaturesByID(ID("e1"))[0],CreateEmptyServiceEffect("e1"));
			c2.AddServiceEffectSpecification(ID("P2"),provides.SignatureList.GetSignaturesByID(ID("e2"))[0],CreateEmptyServiceEffect("e2"));
			c2.AddServiceEffectSpecification(ID("P2"),provides.SignatureList.GetSignaturesByID(ID("e3"))[0],CreateEmptyServiceEffect("e3"));
			c2.AddServiceEffectSpecification(ID("P2"),provides.SignatureList.GetSignaturesByID(ID("e4"))[0],CreateEmptyServiceEffect("e4"));

			return c2;
		}
		
		public static IComponent CreateC1()
		{
			IBasicComponent c1 = ComponentFactory.CreateBasicComponent("C1");
			IInterfaceModel provides = CreateProvidesInterfaceP1();
			c1.AddProvidesInterface(ID("P1"),provides);

			c1.AddServiceEffectSpecification(ID("P1"),provides.SignatureList.GetSignaturesByID(ID("d1"))[0],CreateServiceEffectD1());
			c1.AddServiceEffectSpecification(ID("P1"),provides.SignatureList.GetSignaturesByID(ID("d2"))[0],CreateServiceEffectD2());

			c1.AddRequiresInterface(ID("R1"),CreateRequires());
			return c1;
		}

		public static IInterfaceModel CreateRequires()
		{
			IEditableFiniteStateMachine editFSM1;
			
			IInterfaceModel ifModel = ComponentFactory.CreateInterfaceModel();
			ifModel.AddAuxiliarySpecification (ComponentFactory.CreateFSMProtocolInterface());
			IFSMInterface fsmProtocol = (IFSMInterface)ifModel.GetAuxiliarySpecification(typeof(IFSMInterface));

			ISignature[] signatures = ComponentFactory.CreateSignatureArray("e1","e2","e3");
			ifModel.SignatureList.AddSignatures(signatures);

			editFSM1 = fsmProtocol.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1","2"); 
			editFSM1.AddStates(states1.StoredStates);
			editFSM1.StartState = states1["1"];
			editFSM1.FinalStates = new IState[] {states1["2"]};
			editFSM1.AddTransition("1",signatures[0],"2");
			editFSM1.AddTransition("1",signatures[2],"1");
			editFSM1.AddTransition("2",signatures[2],"2");
			editFSM1.AddTransition("2",signatures[1],"1");
			
			return ifModel;
		}

		public static IInterfaceModel CreateProvidesInterfaceP1()
		{
//			IEditableFiniteStateMachine editFSM1;
			
			IInterfaceModel ifModel = ComponentFactory.CreateInterfaceModel();
	//		ifModel.AddAuxiliarySpecification (ComponentFactory.CreateFSMProtocolInterface());
//			IFSMInterface fsmProtocol = (IFSMInterface)ifModel.GetAuxiliarySpecification(typeof(IFSMInterface));

			ISignature[] signatures = ComponentFactory.CreateSignatureArray("d1","d2");
			ifModel.SignatureList.AddSignatures(signatures);

/*			editFSM1 = fsmProtocol.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1","2"); 
			editFSM1.AddStates(states1.StoredStates);
			editFSM1.StartState = states1["1"];
			editFSM1.FinalStates = new IState[] {states1["2"]};
			editFSM1.AddTransition("1",signatures[0],"2");
			editFSM1.AddTransition("1",signatures[1],"1");
			editFSM1.AddTransition("2",signatures[1],"2");*/
			
			return ifModel;
		}

		public static IInterfaceModel CreateProvidesInterfaceP2()
		{
			IEditableFiniteStateMachine editFSM1;
			
			IInterfaceModel ifModel = ComponentFactory.CreateInterfaceModel();
			ifModel.AddAuxiliarySpecification (ComponentFactory.CreateFSMProtocolInterface());
			IFSMInterface fsmProtocol = (IFSMInterface)ifModel.GetAuxiliarySpecification(typeof(IFSMInterface));

			ISignature[] signatures = ComponentFactory.CreateSignatureArray("e1","e2","e3","e4");
			ifModel.SignatureList.AddSignatures(signatures);

			editFSM1 = fsmProtocol.EditFSM;

			IState singleState = FSMFactory.CreateDefaultState("1"); 
			editFSM1.AddStates(singleState);
			editFSM1.StartState = singleState;
			editFSM1.FinalStates = new IState[] {singleState};
			editFSM1.AddTransition("1",signatures[0],"1");
			editFSM1.AddTransition("1",signatures[1],"1");
			editFSM1.AddTransition("1",signatures[2],"1");
			editFSM1.AddTransition("1",signatures[3],"1");
			
			return ifModel;
		}

		public static IServiceEffectSpecification CreateServiceEffectD1()
		{
			IEditableFiniteStateMachine editFSM1;

			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			seff.AddAuxiliarySpecification (ComponentFactory.CreateFSMProtocolServiceEffect());
			IFSMServiceEffect fsmProtocol = (IFSMServiceEffect)seff.GetAuxiliarySpecification(typeof(IFSMServiceEffect));

			IExternalSignature[] signatures = ComponentFactory.CreateExternalSignatureArray("R1",
				ComponentFactory.CreateSignatureArray("e1","e2","e4"));
			seff.SignatureList.AddSignatures(signatures);

			editFSM1 = fsmProtocol.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("d1->1","d1->2","d1->3"); 
			editFSM1.AddStates(states1.StoredStates);
			editFSM1.StartState = states1["d1->1"];
			editFSM1.FinalStates = new IState[] {states1["d1->2"]};
			editFSM1.AddTransition("d1->1",signatures[0],"d1->2");
			editFSM1.AddTransition("d1->2",signatures[1],"d1->1");
			editFSM1.AddTransition("d1->1",signatures[2],"d1->3");
			
			return seff;
		}

		public static IServiceEffectSpecification CreateEmptyServiceEffect(String service)
		{
			IEditableFiniteStateMachine editFSM1;

			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			seff.AddAuxiliarySpecification (ComponentFactory.CreateFSMProtocolServiceEffect());
			IFSMServiceEffect fsmProtocol = (IFSMServiceEffect)seff.GetAuxiliarySpecification(typeof(IFSMServiceEffect));
			
			editFSM1 = fsmProtocol.EditFSM;
			StaticTimeStateParams parms = new StaticTimeStateParams("C2->"+service+"->1",DefaultRandomStrategy.getInstance(),
				LoggingType_t.LOG_BOTH,10);

			IState singleState = new DefaultStaticTimeState(parms);//FSMFactory.CreateDefaultState("C2->"+service+"->1"); 
			editFSM1.AddStates(singleState);
			editFSM1.StartState = singleState;
			editFSM1.FinalStates = new IState[] {singleState};
			
			return seff;
		}

		public static IServiceEffectSpecification CreateServiceEffectD2()
		{
			IEditableFiniteStateMachine editFSM1;

			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			seff.AddAuxiliarySpecification (ComponentFactory.CreateFSMProtocolServiceEffect());
			IFSMServiceEffect fsmProtocol = (IFSMServiceEffect)seff.GetAuxiliarySpecification(typeof(IFSMServiceEffect));

			IExternalSignature[] signatures = ComponentFactory.CreateExternalSignatureArray("R1",
				ComponentFactory.CreateSignatureArray("e3"));
			seff.SignatureList.AddSignatures(signatures);

			editFSM1 = fsmProtocol.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("d2->1","d2->2"); 
			editFSM1.AddStates(states1.StoredStates);
			editFSM1.StartState = states1["d2->1"];
			editFSM1.FinalStates = new IState[] {states1["d2->2"]};
			editFSM1.AddTransition("d2->1",signatures[0],"d2->2");
			
			return seff;
		}

		public static IIdentifier ID(string id)
		{
			return IdentifiableFactory.CreateStringID(id);
		}
	}
}
