using System;
using Palladio.FiniteStateMachines;
using Palladio.ComponentModel;

namespace Palladio.CM.Example
{
	/// <summary>
	/// Zusammenfassung für CMBuilder.
	/// </summary>
	public class CMBuilder
	{

		public static IComponent CreateCompositeComponent()
		{
			ICompositeComponent cc = ComponentFactory.CreateCompositeComponent();
			IComponent[] comps = new IComponent[2];
			comps[0] = CreateC1();
			comps[1] = CreateC2();
			cc.AddComponents(comps);
			cc.AddProvidesInterfaces(CreateProvidesInterfaceP1());
			IBinding binding = ComponentFactory.CreateBinding(comps[1],"P2",comps[0],"R1");
			cc.AddBindings(binding);
			IMapping mapping = ComponentFactory.CreateMapping("P1",comps[0],"P1");
			cc.AddProvidesMappings(mapping);

			return cc;
		}

		public static IComponent CreateC2()
		{
			IBasicComponent c2 = ComponentFactory.CreateBasicComponent();
			IFSMProtocol provides = CreateProvidesInterfaceP2();
			IServiceEffectMapping[] mappings = new IServiceEffectMapping[3];
			mappings[0] = ComponentFactory.CreateServiceEffectMapping(provides.GetSignaturesByName("e1")[0],CreateEmptyServiceEffect());
			mappings[1] = ComponentFactory.CreateServiceEffectMapping(provides.GetSignaturesByName("e2")[0],CreateEmptyServiceEffect());
			mappings[2] = ComponentFactory.CreateServiceEffectMapping(provides.GetSignaturesByName("e3")[0],CreateEmptyServiceEffect());
			c2.AddProvidesInterface(provides,mappings);
			return c2;
		}
		
		public static IComponent CreateC1()
		{
			IBasicComponent c1 = ComponentFactory.CreateBasicComponent();
			IFSMProtocol provides = CreateProvidesInterfaceP1();
			IServiceEffectMapping[] mappings = new IServiceEffectMapping[2];
			mappings[0] = ComponentFactory.CreateServiceEffectMapping(provides.GetSignaturesByName("d1")[0],CreateServiceEffectD1());
			mappings[1] = ComponentFactory.CreateServiceEffectMapping(provides.GetSignaturesByName("d2")[0],CreateServiceEffectD2());
			c1.AddProvidesInterface(CreateProvidesInterfaceP1(),mappings);
			c1.AddRequiresInterfaces(CreateRequires());
			return c1;
		}

		public static IFSMProtocol CreateRequires()
		{
			IEditableFiniteStateMachine editFSM1;

			IFSMProtocol result = ComponentFactory.CreateFSMProtocolInterface("R1");

			editFSM1 = result.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1","2"); 
			ISignature[] signatures = ComponentFactory.CreateSignatureArray("R1","e1", "e2", "e3");
			editFSM1.AddStates(states1.StoredStates);
			editFSM1.StartState = states1["1"];
			editFSM1.FinalStates = new IState[] {states1["2"]};
			editFSM1.AddInputSymbols(FSMFactory.CreateInputFromList(signatures).StoredInputs);
			editFSM1.AddTransition("1",signatures[0],"2");
			editFSM1.AddTransition("1",signatures[2],"1");
			editFSM1.AddTransition("2",signatures[2],"2");
			editFSM1.AddTransition("2",signatures[1],"1");
			return result;
		}

		public static IFSMProtocol CreateProvidesInterfaceP1()
		{
			IEditableFiniteStateMachine editFSM1;

			IFSMProtocol result = ComponentFactory.CreateFSMProtocolInterface("P1");

			editFSM1 = result.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1","2"); 
			ISignature[] signatures = ComponentFactory.CreateSignatureArray("P1","d1","d2");
			InputSymbolHash inputs = FSMFactory.CreateInputFromList(signatures);
			editFSM1.AddStates(states1.StoredStates);
			editFSM1.StartState = states1["1"];
			editFSM1.FinalStates = new IState[] {states1["2"]};
			editFSM1.AddInputSymbols(inputs.StoredInputs);
			editFSM1.AddTransition("1",signatures[0],"2");
			editFSM1.AddTransition("1",signatures[1],"1");
			editFSM1.AddTransition("2",signatures[1],"2");
			
			return result;
		}

		public static IFSMProtocol CreateProvidesInterfaceP2()
		{
			IEditableFiniteStateMachine editFSM1;

			IFSMProtocol result = ComponentFactory.CreateFSMProtocolInterface("P2");

			editFSM1 = result.EditFSM;
			IState singleState = FSMFactory.CreateDefaultState("1"); 
			ISignature[] signatures = ComponentFactory.CreateSignatureArray("P2","e1","e2","e3");
			InputSymbolHash inputs = FSMFactory.CreateInputFromList(signatures);
			editFSM1.AddStates(singleState);
			editFSM1.StartState = singleState;
			editFSM1.FinalStates = new IState[] {singleState};
			editFSM1.AddInputSymbols(inputs.StoredInputs);
			editFSM1.AddTransition("1",signatures[0],"1");
			editFSM1.AddTransition("1",signatures[1],"1");
			editFSM1.AddTransition("1",signatures[2],"1");
			
			return result;
		}

		public static IFSMProtocol CreateServiceEffectD1()
		{
			IEditableFiniteStateMachine editFSM1;

			IFSMProtocol result = ComponentFactory.CreateFSMProtocolServiceEffect();

			editFSM1 = result.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1","2"); 
			ISignature[] signatures = ComponentFactory.CreateSignatureArray("R1","e1","e2");
			editFSM1.AddStates(states1.StoredStates);
			editFSM1.StartState = states1["1"];
			editFSM1.FinalStates = new IState[] {states1["2"]};
			editFSM1.AddInputSymbols(FSMFactory.CreateInputFromList(signatures).StoredInputs);
			editFSM1.AddTransition("1",signatures[0],"2");
			editFSM1.AddTransition("2",signatures[1],"1");
			
			return result;
		}

		public static IFSMProtocol CreateEmptyServiceEffect()
		{
			IEditableFiniteStateMachine editFSM1;

			IFSMProtocol result = ComponentFactory.CreateFSMProtocolInterface("P2");

			editFSM1 = result.EditFSM;
			IState singleState = FSMFactory.CreateDefaultState("1"); 
			editFSM1.AddStates(singleState);
			editFSM1.StartState = singleState;
			editFSM1.FinalStates = new IState[] {singleState};
			
			return result;
		}

		public static IFSMProtocol CreateServiceEffectD2()
		{
			IEditableFiniteStateMachine editFSM1;

			IFSMProtocol result = ComponentFactory.CreateFSMProtocolServiceEffect();

			editFSM1 = result.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1","2"); 
			ISignature[] signatures = ComponentFactory.CreateSignatureArray("R1","e3");
			editFSM1.AddStates(states1.StoredStates);
			editFSM1.StartState = states1["1"];
			editFSM1.FinalStates = new IState[] {states1["2"]};
			editFSM1.AddInputSymbols(FSMFactory.CreateInputFromList(signatures).StoredInputs);
			editFSM1.AddTransition("1",signatures[0],"2");
			
			return result;
		}
	}
}
