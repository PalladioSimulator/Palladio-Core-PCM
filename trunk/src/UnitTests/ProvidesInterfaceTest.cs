using System;
using System.Collections;
using System.Reflection;
using NUnit.Framework;
using Utils.Collections;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// </summary>
	[TestFixture]
	public class ProvidesInterfaceTest
	{
		ProvidesInterface piOne, piOne1, piTwo;
		
		[SetUp] public void Init() 
		{
			FSMFactory factory = new FSMFactory();
			IFiniteStateMachine fsmOne = factory.CreateFSMFromFile("../../data/se_d1.xml");
			IFiniteStateMachine fsmTwo = factory.CreateFSMFromFile("../../data/se_d2.xml");
			IFiniteStateMachine fsmThree = factory.CreateFSMFromFile("../../data/se_d3.xml");
			IFiniteStateMachine fsmProvides = factory.CreateFSMFromFile("../../data/provides.xml");
			IFiniteStateMachine fsmProvidesTwo = factory.CreateFSMFromFile("../../data/provides2.xml");


			ProtocolIModel modelOne = new ProtocolIModel(fsmOne, Helper.SigListFromInputAlphabet(fsmOne.InputAlphabet));
			ProtocolIModel modelTwo = new ProtocolIModel(fsmTwo, Helper.SigListFromInputAlphabet(fsmTwo.InputAlphabet));
			ProtocolIModel modelThree = new ProtocolIModel(fsmThree, Helper.SigListFromInputAlphabet(fsmThree.InputAlphabet));
			ProtocolIModel modelProvides = new ProtocolIModel(fsmProvides, Helper.SigListFromInputAlphabet(fsmProvides.InputAlphabet));
			ProtocolIModel modelProvides1 = new ProtocolIModel(fsmProvides, Helper.SigListFromInputAlphabet(fsmProvides.InputAlphabet));
			ProtocolIModel modelProvidesTwo = new ProtocolIModel(fsmProvidesTwo, Helper.SigListFromInputAlphabet(fsmProvidesTwo.InputAlphabet));

			ISignature sigOne = new SimpleSignature("d1");
			ISignature sigTwo = new SimpleSignature("d2");
			ISignature sigThree = new SimpleSignature("d3");

			Service srvOne = new Service(modelOne, sigOne);
			Service srvTwo = new Service(modelTwo, sigTwo);
			Service srvThree = new Service(modelThree, sigThree);

			IList srvListOne = new Vector();
			IList srvListOne1 = new Vector();
			IList srvListTwo = new Vector();
			IList srvListThree = new Vector();
			srvListOne.Add(srvOne.Clone());
			srvListOne.Add(srvTwo.Clone());
			srvListOne1.Add(srvOne.Clone());
			srvListOne1.Add(srvTwo.Clone());
			srvListTwo.Add(srvTwo.Clone());
			srvListTwo.Add(srvThree.Clone());
			srvListThree.Add(srvOne.Clone());
			srvListThree.Add(srvTwo.Clone());
			srvListThree.Add(srvThree.Clone());

			

			piOne = new ProvidesInterface(modelProvides,srvListOne);
			piOne1 = new ProvidesInterface(modelProvides1,srvListOne1);
			piTwo = new ProvidesInterface(modelProvidesTwo,srvListOne);

		}

		[Test] public void Equals()
		{
			Assert.IsTrue(piOne.Equals(piOne1));
			Assert.IsFalse(piOne.Equals(piTwo));
		}

		[Test] public void Clone()
		{
			ProvidesInterface pIFace = (ProvidesInterface) piOne.Clone();
			Assert.IsTrue(pIFace.Equals(piOne1));
			pIFace.ServiceList.RemoveAt(0);
			Assert.IsFalse(pIFace.Equals(piOne));
		}
	}
}
