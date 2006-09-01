using NUnit.Framework;
using Palladio.FiniteStateMachines;
using Palladio.Performance.Attributes;

#if TEST
namespace Palladio.Performance.XmlSeffParser.Test
{
	[TestFixture]
	public class XmlSeffParserTest
	{
		string testfile="../../../TestData/ExampleSeff.xml";
		IEditableFiniteStateMachine other;

		[Test]
		public void TestXmlSeffParser()
		{
			XmlSeffParser parser = new XmlSeffParser(testfile);
			IFiniteStateMachine fsm = parser.Seff;

			Assert.IsTrue(fsm.HasFinalStates);
			Assert.IsTrue(fsm.HasStartState);

			Assert.AreEqual(other.StartState, fsm.StartState);

			foreach (IState state in fsm.States)
			{
				IState otherState = other.GetState(state.ID);
				Assert.AreEqual(otherState,state);
				Assert.AreEqual(RandomVariable.GetAttribute(otherState),
					RandomVariable.GetAttribute(state));
				ITransition[] outgoingTransitions = fsm.GetOutgoingTransitions(state);
				ITransition[] otherOutgoingTransitions = 
					other.GetOutgoingTransitions(other.GetState(state.ID));
				for (int i=0;i<outgoingTransitions.Length;i++)
				{
					Assert.IsTrue(ContainsTransition(outgoingTransitions[i],otherOutgoingTransitions));
				}

				if(fsm.IsFinalState(state))
				{
					Assert.IsTrue(other.IsFinalState(other.GetState(state.ID)));
				}
			}

		}
		
		private bool ContainsTransition(ITransition t1, ITransition[] other)
		{
			for(int i=0;i<other.Length;i++)
			{
				if(t1.Equals(other[i])) return true;
			}
			return false;
		}

		[TestFixtureSetUp]
		public void Init()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			StateHash stateHash = FSMFactory.CreateStatesFromList("Start","ServicesKnown",
			"AirlineInformationObtained","GotFirstDetails", "GotSecondDetails", "GotThirdDetails");
			fsm.AddStates(stateHash.StoredStates);
			fsm.StartState=stateHash["Start"];
			fsm.FinalStates = new IState[] {fsm.GetState("GotThirdDetails"), fsm.GetState("ServicesKnown")};

			InputSymbolHash inputSymbolHash = FSMFactory.CreateInputFromList("GetAirlineWebServices",
				"GetFlights1", "GetFlights2", "GetAirlineInformation","GetDetails1","GetDetails2",
				"GetDetails3");

			AddTransitions(fsm, inputSymbolHash, stateHash);

			foreach(IState state in fsm.States)
			{
				QMLAttribute qml = new QMLAttribute(new double[]{100},new long[]{100} );
				state.Attributes.Add(RandomVariable.AttributeType,AttributeTransformer.Qml2RandomVariable(qml));
			}
			other = fsm;
		}

		private void AddTransitions(IEditableFiniteStateMachine fsm, InputSymbolHash inputSymbolHash, StateHash stateHash)
		{
			fsm.AddInputSymbols(inputSymbolHash.StoredInputs);
	
			ITransition t1 = CreateTransitionWithAttributes(stateHash["Start"],
			                                                inputSymbolHash["GetAirlineWebServices"],stateHash["ServicesKnown"],
			                                                1,new double[] {40,75,100},new long[]{500,1000,2000});
	
			ITransition t2 = CreateTransitionWithAttributes(stateHash["ServicesKnown"],
			                                                inputSymbolHash["GetFlights1"],stateHash["ServicesKnown"],
			                                                0.72,new double[] {50,75,100},new long[]{1500,2000,4000});
	
			ITransition t3 = CreateTransitionWithAttributes(stateHash["AirlineInformationObtained"],
			                                                inputSymbolHash["GetFlights2"],stateHash["ServicesKnown"],
			                                                1,new double[] {50,75,100},new long[]{1500,2000,4000});
	
			ITransition t4 = CreateTransitionWithAttributes(stateHash["ServicesKnown"],
			                                                inputSymbolHash["GetAirlineInformation"],stateHash["AirlineInformationObtained"],
			                                                0.08,new double[] {50,75,100},new long[]{400,1000,2000});
	
			ITransition t5 = CreateTransitionWithAttributes(stateHash["ServicesKnown"],
			                                                inputSymbolHash["GetDetails1"],stateHash["GotFirstDetails"],
			                                                0.198,new double[] {70,100},new long[]{500,1500});
	
			ITransition t6 = CreateTransitionWithAttributes(stateHash["GotFirstDetails"],
			                                                inputSymbolHash["GetDetails2"],stateHash["GotSecondDetails"],
			                                                1,new double[] {70,100},new long[]{500,1500});
	
			ITransition t7 = CreateTransitionWithAttributes(stateHash["GotSecondDetails"],
			                                                inputSymbolHash["GetDetails3"],stateHash["GotThirdDetails"],
			                                                1,new double[] {70,100},new long[]{500,1500});
	
			fsm.AddTransitions(t1,t2,t3,t4,t5,t6,t7);
		}

		private ITransition CreateTransitionWithAttributes(IState source, IInput input, IState destination, double probability, double[] percentile, long[] timeValues)
		{
			ITransition transition = FSMFactory.CreateDefaultTransition(source,input,destination);

			QMLAttribute qml = new QMLAttribute(percentile,timeValues);

			transition.Attributes.Add(RandomVariable.AttributeType,
				AttributeTransformer.Qml2RandomVariable(qml));
			transition.Attributes.Add(ProbabilityAttribute.AttributeType,
				new ProbabilityAttribute(probability));

			return transition;
		}

	}
}
#endif