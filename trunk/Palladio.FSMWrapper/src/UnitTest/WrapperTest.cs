#if DEBUG

using System;
using System.IO;
using NUnit.Framework;
using Palladio.ComponentModel;
using Palladio.ComponentModel.Identifier;
using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Serializer;
using Palladio.FiniteStateMachines.Serializer.DefaultImplementation;
using Palladio.FiniteStateMachines.Serializer.Interfaces;
using Palladio.FSMWrapper.src;

namespace Palladio.FSMWrapper.UnitTest
{
	/// <summary>
	/// Zusammenfassung für WrapperTest.
	/// </summary>
	[TestFixture]
	public class WrapperTest
	{
		public WrapperTest()
		{
		}

		[SetUp]
		public void Init()
		{
			
		}

		[Test]
		[ExpectedException(typeof(InputNotSupportedException))]
		public void WriteWithoutPlugins()
		{
			IFiniteStateMachine fsm = WrapperTest.CreateFSM();
			IXMLSerializer fsmSerializer = new XMLSerializer();
			fsmSerializer.Save(new FileInfo("testXml.xml"),fsm);
		}

		[Test]
		public void WriteFSMWithSignatureCalls()
		{
			IFiniteStateMachine fsm = WrapperTest.CreateFSM();
			IXMLSerializer fsmSerializer = new XMLSerializer();
			fsmSerializer.AddInputSerializerPlugin(new FSMWrapperInputSerializer());
			fsmSerializer.Save(new FileInfo("testXml.xml"),fsm);
		}
		
		[Test]
		public void WriteNReadFSMWithSignatureCalls()
		{
			WriteFSMWithSignatureCalls();
			IXMLSerializer fsmSerializer = new XMLSerializer();
			fsmSerializer.AddInputSerializerPlugin(new FSMWrapperInputSerializer());
			fsmSerializer.Load(new FileInfo("testXml.xml"));
		}

		public static IFiniteStateMachine CreateFSM()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.GetEditableFSM(FSMFactory.CreateEmptyFSM());
			StateHash states = FSMFactory.CreateStatesFromList("S1","S2","S3");
			fsm.AddStateList(states.StoredStates);
			fsm.StartState = states["S1"];
			fsm.FinalStates = new IState[]{states["S3"]};

			IInput[] inps = new IFSMSignatureCall[]{
					CreateNewFSMSignatureCall(),
					CreateNewFSMSignatureCall(),
					CreateNewFSMSignatureCall()
				};

			fsm.AddInputSymbols(inps);
			fsm.AddTransition("S1",inps[0].ID,"S2");
			fsm.AddTransition("S1",inps[1].ID,"S3");
			fsm.AddTransition("S2",inps[2].ID,"S3");

			return fsm;
		}

		private static IFSMSignatureCall CreateNewFSMSignatureCall()
		{
			IInterfaceIdentifier ifaceID = ComponentModelIdentifier.CreateInterfaceID(Guid.NewGuid().ToString());
			ISignatureIdentifier sigID = ComponentModelIdentifier.CreateSignatureID(Guid.NewGuid().ToString());

			return FSMWrapperFactory.CreateSignatureCall(ifaceID,sigID);
		}
	}
}
#endif 