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
	public class ServiceTest
	{
		Service srvOne, srvTwo, srvThree;
		
		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			FSMFactory factory = new FSMFactory();
			IFiniteStateMachine fsmOne = factory.CreateFSMFromFile("../../data/se_d1.xml");
			IFiniteStateMachine fsmTwo = factory.CreateFSMFromFile("../../data/se_d2.xml");
			IFiniteStateMachine fsmThree = factory.CreateFSMFromFile("../../data/se_d1.xml");

			ProtocolIModel modelOne = new ProtocolIModel(fsmOne, Helper.SigListFromInputAlphabet(fsmOne.InputAlphabet));
			ProtocolIModel modelTwo = new ProtocolIModel(fsmTwo, Helper.SigListFromInputAlphabet(fsmTwo.InputAlphabet));
			ProtocolIModel modelThree = new ProtocolIModel(fsmThree, Helper.SigListFromInputAlphabet(fsmThree.InputAlphabet));

			ISignature sigOne = new SimpleSignature("d1");
			ISignature sigTwo = new SimpleSignature("d2");
			ISignature sigThree = new SimpleSignature("d1");

			srvOne = new Service(modelOne, sigOne);
			srvTwo = new Service(modelTwo, sigTwo);
			srvThree = new Service(modelThree, sigThree);
		}

		/// <summary>
		/// </summary>
		[Test] public void Equals()
		{
			Assert.IsTrue(srvOne.Equals(srvThree));
			Assert.IsFalse(srvTwo.Equals(srvOne));
		}

		/// <summary>
		/// </summary>
		[Test] public void Clone()
		{
			Service srv = (Service)srvOne.Clone();
			srv.Equals(srvThree);
		}
	}
}
