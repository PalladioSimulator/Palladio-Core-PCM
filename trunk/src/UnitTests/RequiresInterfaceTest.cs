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
	public class RequiresInterfaceTest
	{
		RequiresInterface rqOne, rqOne1, rqTwo;
		
		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			FSMFactory factory = new FSMFactory();
			IFiniteStateMachine fsmOne = factory.CreateFSMFromFile("../../data/se_d1.xml");
			IFiniteStateMachine fsmOne1 = factory.CreateFSMFromFile("../../data/se_d1.xml");
			IFiniteStateMachine fsmTwo = factory.CreateFSMFromFile("../../data/se_d2.xml");

			ProtocolIModel modelOne = new ProtocolIModel(fsmOne, Helper.SigListFromInputAlphabet(fsmOne.InputAlphabet));
			ProtocolIModel modelOne1 = new ProtocolIModel(fsmOne, Helper.SigListFromInputAlphabet(fsmOne.InputAlphabet));
			ProtocolIModel modelTwo = new ProtocolIModel(fsmTwo, Helper.SigListFromInputAlphabet(fsmTwo.InputAlphabet));

			rqOne = new RequiresInterface(modelOne,"one");
			rqOne1 = new RequiresInterface(modelOne1,"one");
			rqTwo = new RequiresInterface(modelTwo,"two");

		}

		/// <summary>
		/// </summary>
		[Test] public void Equals()
		{
			Assert.IsTrue(rqOne.Equals(rqOne1));
			Assert.IsFalse(rqOne.Equals(rqTwo));
		}

		/// <summary>
		/// </summary>
		[Test] public void Clone()
		{
			RequiresInterface rq = (RequiresInterface) rqOne.Clone();
			Assert.IsTrue(rq.Equals(rqOne1));
			((SignatureListIModel)rq.IModel).SignatureList.RemoveAt(0);
			Assert.IsFalse(rq.Equals(rqOne));
		}
	}
}
