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
	[TestFixture]
	public class FSMProtocolTest
	{
		IFSMProtocol protocol1 = null;
		IFSMProtocol protocol2 = null;
		IFSMProtocol protocol3 = null;

		[SetUp] public void Init()
		{
			IEditableFiniteStateMachine editFSM1, editFSM2;

			protocol1 = CreateProvidesInterface();
			protocol2 = CreateServiceEffectD1();
			protocol3 = CreateServiceEffectD2();
		}

		public static IFSMProtocol CreateProvidesInterface()
		{
			IEditableFiniteStateMachine editFSM1;

			IFSMProtocol result = ComponentFactory.CreateFSMProtocolInterface("ProvIF");

			editFSM1 = result.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1","2"); 
			ISignature[] signatures = ComponentFactory.CreateSignatureArray("ProvIF","d1","d2");
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

		public static IFSMProtocol CreateServiceEffectD1()
		{
			IEditableFiniteStateMachine editFSM1;

			IFSMProtocol result = ComponentFactory.CreateFSMProtocolServiceEffect();

			editFSM1 = result.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1","2"); 
			ISignature[] signatures = ComponentFactory.CreateSignatureArray("Ext1","e1","e2");
			editFSM1.AddStates(states1.StoredStates);
			editFSM1.StartState = states1["1"];
			editFSM1.FinalStates = new IState[] {states1["2"]};
			editFSM1.AddInputSymbols(FSMFactory.CreateInputFromList(signatures).StoredInputs);
			editFSM1.AddTransition("1",signatures[0],"2");
			editFSM1.AddTransition("2",signatures[1],"1");
			
			return result;
		}

		public static IFSMProtocol CreateServiceEffectD2()
		{
			IEditableFiniteStateMachine editFSM1;

			IFSMProtocol result = ComponentFactory.CreateFSMProtocolServiceEffect();

			editFSM1 = result.EditFSM;
			StateHash states1 = FSMFactory.CreateStatesFromList("1","2"); 
			ISignature[] signatures = ComponentFactory.CreateSignatureArray("Ext1","e3");
			editFSM1.AddStates(states1.StoredStates);
			editFSM1.StartState = states1["1"];
			editFSM1.FinalStates = new IState[] {states1["2"]};
			editFSM1.AddInputSymbols(FSMFactory.CreateInputFromList(signatures).StoredInputs);
			editFSM1.AddTransition("1",signatures[0],"2");
			
			return result;
		}

		[Test] public void ProtocolEquals()
		{
			Assert.AreEqual(CreateProvidesInterface(),protocol1);
		}

		[Test] public void ProtocolClone()
		{
			IFSMProtocol clone = (IFSMProtocol)protocol1.Clone();
			Assert.AreEqual(protocol1,clone);
			clone.EditFSM.AddStates(FSMFactory.CreateDefaultState("3"));
			Assert.IsFalse(protocol1.Equals(clone));
		}

		[Test] public void AddDeleteSignature()
		{
			ISignature sig = ComponentFactory.CreateSignatureArray("ProvIF","a")[0];
			protocol1.AddSignatures(sig);
			Assert.IsTrue(protocol1.ContainsSignature(sig));
			protocol1.DeleteSignatures(sig);
			Assert.IsFalse(protocol1.ContainsSignature(sig));
		}
	}
}
#endif
			