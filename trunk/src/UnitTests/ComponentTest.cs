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
	public class ComponentTest
	{
		Component comOne, comOne1, comTwo;

		/// <summary>
		/// </summary>
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
			ProtocolIModel modelProvidesTwo = new ProtocolIModel(fsmProvidesTwo, Helper.SigListFromInputAlphabet(fsmProvidesTwo.InputAlphabet));

			ISignature sigOne = new SimpleSignature("d1");
			ISignature sigTwo = new SimpleSignature("d2");
			ISignature sigThree = new SimpleSignature("d3");

			Service srvOne = new Service(modelOne, sigOne);
			Service srvTwo = new Service(modelTwo, sigTwo);
			Service srvThree = new Service(modelThree, sigThree);

			IList srvListOne = new Vector();
			IList srvListTwo = new Vector();
			IList srvListThree = new Vector();
			srvListOne.Add(srvOne.Clone());
			srvListOne.Add(srvTwo.Clone());
			srvListTwo.Add(srvTwo.Clone());
			srvListTwo.Add(srvThree.Clone());
			srvListThree.Add(srvOne.Clone());
			srvListThree.Add(srvTwo.Clone());
			srvListThree.Add(srvThree.Clone());

			ProvidesInterface piOne = new ProvidesInterface(modelProvides,srvListOne,"one");
			ProvidesInterface piTwo = new ProvidesInterface(modelProvidesTwo,srvListOne,"one");

			RequiresInterface rqOne = new RequiresInterface(modelOne,"one");
			RequiresInterface rqTwo = new RequiresInterface(modelTwo,"two");

			IList provListOne = new Vector();
			IList provListOne1 = new Vector();
			IList provListTwo = new Vector();
			provListOne.Add(piOne);
			provListOne.Add(piTwo);
			provListOne1.Add(piOne.Clone());
			provListOne1.Add(piTwo.Clone());
			provListTwo.Add(piOne);

			IList reqListOne = new Vector();
			IList reqListOne1 = new Vector();
			IList reqListTwo = new Vector();
			reqListOne.Add(rqOne);
			reqListOne.Add(rqTwo);
			reqListOne1.Add(rqOne.Clone());
			reqListOne1.Add(rqTwo.Clone());
			reqListTwo.Add(rqOne);

			comOne = new Component(provListOne,reqListOne);
			comOne1 = new Component(provListOne1,reqListOne1);
			comTwo = new Component(provListTwo,reqListTwo);
		}

		/// <summary>
		/// </summary>
		[Test] public void Equals()
		{
			Assert.IsTrue(comOne.Equals(comOne1));
			Assert.IsFalse(comOne.Equals(comTwo));
		}

		/// <summary>
		/// </summary>
		[Test] public void Clone()
		{
			Component com = (Component)comOne.Clone();
			Assert.IsTrue(com.Equals(comOne1));
			com.GetProvidesIfaceList().RemoveAt(0);
			Assert.IsFalse(com.Equals(comOne));
		}
	}
}
