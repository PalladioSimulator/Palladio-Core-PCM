using System;
using System.Collections;
using System.Reflection;
using NUnit.Framework;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// </summary>
	[TestFixture]
	public class ProtocolIModelTest
	{
		IFiniteStateMachine fsmOne, fsmTwo, fsmThree;
		ProtocolIModel modelOne, modelTwo, modelThree;

		[SetUp] public void Init() 
		{
			FSMFactory factory = new FSMFactory();
			fsmOne = factory.CreateFSMFromFile("../../data/se_d1.xml");
			fsmTwo = factory.CreateFSMFromFile("../../data/se_d2.xml");
			fsmThree = factory.CreateFSMFromFile("../../data/se_d1.xml");

			modelOne = new ProtocolIModel(fsmOne, Helper.SigListFromInputAlphabet(fsmOne.InputAlphabet));
			modelTwo = new ProtocolIModel(fsmTwo, Helper.SigListFromInputAlphabet(fsmTwo.InputAlphabet));
			modelThree = new ProtocolIModel(fsmThree, Helper.SigListFromInputAlphabet(fsmThree.InputAlphabet));
		}

		[Test] public void Equals()
		{
			Assert.IsTrue(modelOne.Equals(modelThree));
			Assert.IsFalse(modelOne.Equals(modelTwo));
		}

		[Test] public void Clone()
		{
			ProtocolIModel model = (ProtocolIModel) modelOne.Clone();
			Assert.IsTrue(model.Equals(modelOne));
			IState start = model.Protocol.StartState;
			Input input = (Input) model.Protocol.InputAlphabet[1];
			IState dest = (IState) model.Protocol.FinalStates[0];
			ITransition t = new Transition(start,input,dest);
			model.Protocol.AddTransition(t);
			Assert.IsTrue( modelOne.Protocol.GetNextState(start, input).Equals(modelOne.Protocol.ErrorState));
		}

	}
}
