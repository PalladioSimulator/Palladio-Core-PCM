/*
 * $Id$
 * 
 * $Log$
 * Revision 1.4  2004/09/09 04:07:53  sliver
 * code refactored
 * vs.net project files created
 *
 * Revision 1.3  2004/07/19 04:37:48  sliver
 * extracted attributes
 *
 * Revision 1.2  2004/07/13 02:14:52  sliver
 * Added comments
 *
 * Revision 1.1  2004/07/12 06:33:04  sliver
 * Initial checkin
 * 
 */


using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;
using Palladio.Reliability.Attributes;

namespace Palladio.Reliability.Tests
{
	/// <summary>
	/// Description of TestCMBuilder.	
	/// </summary>
	public class CMBuilder : Helper
	{
		public static ICompositeComponent CreateCM()
		{
			ICompositeComponent rootCC = ComponentFactory.CreateCompositeComponent("root");
			ICompositeComponent innerCC = ComponentFactory.CreateCompositeComponent("inner");
			IComponent c1 = CreateC1();
			IComponent c2 = CreateC2();

			innerCC.AddProvidesInterface(ID("P1"), c1.GetProvidesInterface(c1.ProvidedRoles[0]));
			innerCC.AddRequiresInterface(ID("R1"), c1.GetRequiresInterface(c1.RequiredRoles[0]));
			innerCC.AddComponents(c1);

			IMapping pm = ComponentFactory.CreateProvidesMapping(innerCC, ID("P1"), c1, ID("P1"));
			IMapping rm = ComponentFactory.CreateRequiresMapping(c1, ID("R1"), innerCC, ID("R1"));

			innerCC.AddProvidesMappings(pm);
			innerCC.AddRequiresMappings(rm);

			rootCC.AddComponents(innerCC, c2);

			rootCC.AddProvidesInterface(ID("P1"), CreateProvidesInterfaceP1());

			IBinding binding = ComponentFactory.CreateBinding(innerCC, ID("R1"), c2, ID("P2"));
			rootCC.AddBindings(binding);
			IMapping mapping = ComponentFactory.CreateProvidesMapping(
				rootCC, ID("P1"), innerCC, ID("P1"));
			rootCC.AddProvidesMappings(mapping);

			return rootCC;
		}

		public static IComponent CreateC2()
		{
			IBasicComponent c2 = ComponentFactory.CreateBasicComponent("C2");
			IInterfaceModel provides = CreateProvidesInterfaceP2();
			c2.AddProvidesInterface(ID("P2"), provides);

			c2.AddServiceEffectSpecification(ID("P2"), provides.SignatureList.GetSignaturesByID(ID("e1"))[0], CreateEmptyServiceEffect());
			c2.AddServiceEffectSpecification(ID("P2"), provides.SignatureList.GetSignaturesByID(ID("e2"))[0], CreateEmptyServiceEffect());
			c2.AddServiceEffectSpecification(ID("P2"), provides.SignatureList.GetSignaturesByID(ID("e3"))[0], CreateEmptyServiceEffect());
			c2.AddServiceEffectSpecification(ID("P2"), provides.SignatureList.GetSignaturesByID(ID("e4"))[0], CreateEmptyServiceEffect());

			return c2;
		}

		public static IComponent CreateC1()
		{
			IBasicComponent c1 = ComponentFactory.CreateBasicComponent("C1");
			IInterfaceModel provides = CreateProvidesInterfaceP1();
			c1.AddProvidesInterface(ID("P1"), provides);

			c1.AddServiceEffectSpecification(ID("P1"), provides.SignatureList.GetSignaturesByID(ID("d1"))[0], CreateServiceEffectD1());
			c1.AddServiceEffectSpecification(ID("P1"), provides.SignatureList.GetSignaturesByID(ID("d2"))[0], CreateServiceEffectD2());

			c1.AddRequiresInterface(ID("R1"), CreateRequires());
			return c1;
		}

		public static IInterfaceModel CreateRequires()
		{
			IEditableFiniteStateMachine editFSM1;

			IInterfaceModel ifModel = ComponentFactory.CreateInterfaceModel();
			ifModel.AddAuxiliarySpecification(ComponentFactory.CreateFSMProtocolInterface());
			IFSMInterface fsmProtocol = (IFSMInterface) ifModel.GetAuxiliarySpecification(typeof (IFSMInterface));

			ISignature[] signatures = ComponentFactory.CreateSignatureArray("e1", "e2", "e3");
			ifModel.SignatureList.AddSignatures(signatures);

			editFSM1 = fsmProtocol.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1", "2");
			editFSM1.AddStates(states1.StoredStates);
			editFSM1.StartState = states1["1"];
			editFSM1.FinalStates = new IState[] {states1["2"]};
			editFSM1.AddTransition("1", signatures[0], "2");
			editFSM1.AddTransition("1", signatures[2], "1");
			editFSM1.AddTransition("2", signatures[2], "2");
			editFSM1.AddTransition("2", signatures[1], "1");

			return ifModel;
		}

		public static IInterfaceModel CreateProvidesInterfaceP1()
		{
			IEditableFiniteStateMachine editFSM1;

			IInterfaceModel ifModel = ComponentFactory.CreateInterfaceModel();
			ifModel.AddAuxiliarySpecification(ComponentFactory.CreateFSMProtocolInterface());
			IFSMInterface fsmProtocol = (IFSMInterface) ifModel.GetAuxiliarySpecification(typeof (IFSMInterface));

			ISignature[] signatures = ComponentFactory.CreateSignatureArray("d1", "d2");
			ifModel.SignatureList.AddSignatures(signatures);

			editFSM1 = fsmProtocol.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1", "2");
			editFSM1.AddStates(states1.StoredStates);
			editFSM1.StartState = states1["1"];
			editFSM1.FinalStates = new IState[] {states1["2"]};
			editFSM1.AddTransition("1", signatures[0], "2");
			editFSM1.AddTransition("1", signatures[1], "1");
			editFSM1.AddTransition("2", signatures[1], "2");

			return ifModel;
		}

		public static IInterfaceModel CreateProvidesInterfaceP2()
		{
			IEditableFiniteStateMachine editFSM1;

			IInterfaceModel ifModel = ComponentFactory.CreateInterfaceModel();
			ifModel.AddAuxiliarySpecification(ComponentFactory.CreateFSMProtocolInterface());
			IFSMInterface fsmProtocol = (IFSMInterface) ifModel.GetAuxiliarySpecification(typeof (IFSMInterface));

			ISignature[] signatures = ComponentFactory.CreateSignatureArray("e1", "e2", "e3", "e4");
			ifModel.SignatureList.AddSignatures(signatures);

			signatures[0].Attributes.Add(ServiceReliabilityAttribute.AttributeType, new ServiceReliabilityAttribute(0.9));
			signatures[1].Attributes.Add(ServiceReliabilityAttribute.AttributeType, new ServiceReliabilityAttribute("x"));
			signatures[2].Attributes.Add(ServiceReliabilityAttribute.AttributeType, new ServiceReliabilityAttribute(0.7));
			signatures[3].Attributes.Add(ServiceReliabilityAttribute.AttributeType, new ServiceReliabilityAttribute(0.1));

			editFSM1 = fsmProtocol.EditFSM;

			IState singleState = FSMFactory.CreateDefaultState("1");
			editFSM1.AddStates(singleState);
			editFSM1.StartState = singleState;
			editFSM1.FinalStates = new IState[] {singleState};
			editFSM1.AddTransition("1", signatures[0], "1");
			editFSM1.AddTransition("1", signatures[1], "1");
			editFSM1.AddTransition("1", signatures[2], "1");
			editFSM1.AddTransition("1", signatures[3], "1");

			return ifModel;
		}

		public static IServiceEffectSpecification CreateServiceEffectD1()
		{
			IEditableFiniteStateMachine editFSM1;

			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			seff.AddAuxiliarySpecification(ComponentFactory.CreateFSMProtocolServiceEffect());
			IFSMServiceEffect fsmProtocol = (IFSMServiceEffect) seff.GetAuxiliarySpecification(typeof (IFSMServiceEffect));

			IExternalSignature[] signatures = ComponentFactory.CreateExternalSignatureArray("R1",
			                                                                                ComponentFactory.CreateSignatureArray("e1", "e2", "e4"));
			seff.SignatureList.AddSignatures(signatures);

			editFSM1 = fsmProtocol.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1", "2", "3");
			editFSM1.AddStates(states1.StoredStates);
			editFSM1.StartState = states1["1"];
			editFSM1.FinalStates = new IState[] {states1["2"], states1["3"]};

			ITransition t;
			t = CMBuilder.CreateTransition("1", signatures[0], "2");
			t.Attributes.Add(MarkovProbabilityAttribute.AttributeType, new MarkovProbabilityAttribute(0.5));
			editFSM1.AddTransitions(t);

			t = CMBuilder.CreateTransition("2", signatures[1], "1");
			t.Attributes.Add(MarkovProbabilityAttribute.AttributeType, new MarkovProbabilityAttribute(0.5));
			editFSM1.AddTransitions(t);

			t = CMBuilder.CreateTransition("1", signatures[2], "3");
			t.Attributes.Add(MarkovProbabilityAttribute.AttributeType, new MarkovProbabilityAttribute(0.5));
			editFSM1.AddTransitions(t);

			return seff;
		}

		public static IServiceEffectSpecification CreateEmptyServiceEffect()
		{
			IEditableFiniteStateMachine editFSM1;

			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			seff.AddAuxiliarySpecification(ComponentFactory.CreateFSMProtocolServiceEffect());
			IFSMServiceEffect fsmProtocol = (IFSMServiceEffect) seff.GetAuxiliarySpecification(typeof (IFSMServiceEffect));

			editFSM1 = fsmProtocol.EditFSM;
			IState singleState = FSMFactory.CreateDefaultState("1");
			editFSM1.AddStates(singleState);
			editFSM1.StartState = singleState;
			editFSM1.FinalStates = new IState[] {singleState};

			return seff;
		}

		public static IServiceEffectSpecification CreateServiceEffectD2()
		{
			IEditableFiniteStateMachine editFSM1;

			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			seff.AddAuxiliarySpecification(ComponentFactory.CreateFSMProtocolServiceEffect());
			IFSMServiceEffect fsmProtocol = (IFSMServiceEffect) seff.GetAuxiliarySpecification(typeof (IFSMServiceEffect));

			IExternalSignature[] signatures = ComponentFactory.CreateExternalSignatureArray("R1",
			                                                                                ComponentFactory.CreateSignatureArray("e3"));
			seff.SignatureList.AddSignatures(signatures);

			editFSM1 = fsmProtocol.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1", "2");
			editFSM1.AddStates(states1.StoredStates);
			editFSM1.StartState = states1["1"];
			editFSM1.FinalStates = new IState[] {states1["2"]};

			ITransition t;
			t = CreateTransition("1", signatures[0], "2");
			t.Attributes.Add(MarkovProbabilityAttribute.AttributeType, new MarkovProbabilityAttribute(1.0));
			editFSM1.AddTransitions(t);

			return seff;
		}

	}
}