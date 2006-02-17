#if TEST

using System;
using NUnit.Framework;
using Palladio.ComponentModel.Exceptions;
using System.Collections;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3.2.1  2004/11/16 13:37:47  uffi
	/// Initial commit of the 2.0 version of the component model. BETA!!! See the techreport (to be updated) for details.
	/// Documentation needs fixing. Some unittests fail.
	///
	/// Revision 1.3  2004/06/09 12:36:31  sbecker
	/// Fixed documentation and renamed IService
	///
	/// Revision 1.2  2004/06/03 14:37:29  sbecker
	/// Added the possibility to attach auxiliary specifications to a basic component
	///
	/// Revision 1.1  2004/06/02 14:50:26  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.4  2004/05/24 15:03:14  sliver
	/// added tests for fsmprotocols in a basic component
	///
	/// Revision 1.3  2004/05/24 13:54:07  sbecker
	/// Added GetSignaturesByName
	///
	/// Revision 1.2  2004/05/24 13:19:57  sbecker
	/// Added requires protocols
	/// Added signature test
	///
	/// Revision 1.1  2004/05/24 12:44:30  sbecker
	/// Added test cases for creating protocol interfaces
	///
	/// Revision 1.1  2004/05/23 16:03:56  sliver
	/// completed unit tests
	///
	/// </pre>
	/// </remarks>
	/// <exclude />
	[TestFixture]
	public class FSMProtocolTest
	{
		IFSMInterface protocol1 = null;
		IFSMServiceEffect protocol2 = null;
		IFSMServiceEffect protocol3 = null;

		[SetUp] public void Init()
		{
			protocol1 = CreateProvidesInterface();
			protocol2 = CreateServiceEffectD1();
			protocol3 = CreateServiceEffectD2();
		}

		public static IFSMInterface CreateProvidesInterface()
		{
			IEditableFiniteStateMachine editFSM1;

			IFSMInterface result = ComponentFactory.CreateFSMProtocolInterface();

			editFSM1 = result.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1","2"); 
			ISignature[] signatures = ComponentFactory.CreateSignatureArray("d1","d2");
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

		public static IFSMServiceEffect CreateServiceEffectD1()
		{
			IEditableFiniteStateMachine editFSM1;

			IFSMServiceEffect result = ComponentFactory.CreateFSMProtocolServiceEffect();

			ISignatureList sigList = ComponentFactory.CreateSignatureList("f1", "f2" );
			IInterfaceModel iReq = ComponentFactory.CreateInterfaceModel(sigList, "iReq2");

			editFSM1 = result.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1","2"); 
			IService[] signatures = ComponentFactory.CreateServiceArray(iReq, sigList[0].ID, sigList[1].ID);
			editFSM1.AddStates(states1.StoredStates);
			editFSM1.StartState = states1["1"];
			editFSM1.FinalStates = new IState[] {states1["2"]};
			editFSM1.AddInputSymbols(FSMFactory.CreateInputFromList(signatures).StoredInputs);
			editFSM1.AddTransition("1",signatures[0],"2");
			editFSM1.AddTransition("2",signatures[1],"1");
			
			return result;
		}

		public static IFSMServiceEffect CreateServiceEffectD2()
		{
			IEditableFiniteStateMachine editFSM1;

			IFSMServiceEffect result = ComponentFactory.CreateFSMProtocolServiceEffect();

			ISignatureList sigList = ComponentFactory.CreateSignatureList("e1", "e2" );
			IInterfaceModel iReq = ComponentFactory.CreateInterfaceModel(sigList, "iReq1");

			editFSM1 = result.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1","2"); 
			IService[] signatures = ComponentFactory.CreateServiceArray(iReq, sigList[0].ID);
			editFSM1.AddStates(states1.StoredStates);
			editFSM1.StartState = states1["1"];
			editFSM1.FinalStates = new IState[] {states1["2"]};
			editFSM1.AddInputSymbols(FSMFactory.CreateInputFromList(signatures).StoredInputs);
			editFSM1.AddTransition("1",signatures[0],"2");
			
			return result;
		}

		public static IFSMInterface CreateRequires()
		{
			IEditableFiniteStateMachine editFSM1;

			IFSMInterface result = ComponentFactory.CreateFSMProtocolInterface();

			editFSM1 = result.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1","2"); 
			ISignature[] signatures = ComponentFactory.CreateSignatureArray("e1", "e2", "e3");
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

		[Test] public void ProtocolEquals()
		{
			Assert.AreEqual(CreateProvidesInterface(),protocol1);
		}

		[Test] public void ProtocolClone()
		{
			IFSMInterface clone = (IFSMInterface)protocol1.Clone();
			Assert.AreEqual(protocol1,clone);
			clone.EditFSM.AddStates(FSMFactory.CreateDefaultState("3"));
			Assert.IsFalse(protocol1.Equals(clone));
		}
	}
}
#endif
			