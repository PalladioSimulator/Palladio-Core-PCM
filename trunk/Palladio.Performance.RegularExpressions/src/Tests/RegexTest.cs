/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2005/08/12 07:59:20  helgeh
 * Initial impot after refactoring.
 *
 * Math:
 * - Added DiscretePDFunction.
 * - Added Fast Fourier Transformation and FourierFunction.
 * - Changed operations of DiscreteFunction. The operations are independent of the sampling rate. For a probability density  function the sum of function values is a value in [0,1].
 * - Added to interface IDiscreteFunction: Sum,ExpandDomainPo2, Crop, NumberOfNullValues, AdjustSamplingRate,  FunctionWithNValues, ToFile, ValueAt, DismissValuesSmalerThanN, ValueOf, MaximumDataValue
 * - Altered MEthods: ExpandDomain, Scale, GetScaled, Convolution, Add
 *
 * FSMTransformer:
 * - Method SEFFValidity added.
 * - The Method FSMWithIntermediateState now returns a FSM, where all time consumption is contained by the input symbols of the  transitions.
 *
 * WebserverSeffFactory:
 * - All service effect automaton are now IFiniteStateMachines. No use of the PAlladio.ComponentModel.
 *
 * WebserverAnalyser:
 * - Data class for configuration added.
 * - ConfigReader added.
 *
 * RegExASTVisitor:
 * - There are now two visitors. One for the calculation in time domain and one for the calculation in frequency domain.
 *
 * RegularExpressions:
 * - No changes.
 *
 * XmlSeffParser:
 * - Data class for configuration added.
 * - ConfigReader added.
 *
 * PerformanceCalculator:
 * - Added interface IPerformanceCalculator. Added CalculatorFactory.
 *
 * Unit Tests added.
 * Updated documentation.
 *
 * Revision 1.1  2005/06/03 09:33:42  helgeh
 * *** empty log message ***
 *
 * Revision 1.1  2005/05/18 21:35:08  helgeh
 * *** empty log message ***
 *
 * Revision 1.1  2005/03/16 11:55:26  helgeh
 * initial checkin
 *
 * Revision 1.1  2004/12/15 00:05:14  sliver
 * initial checkin after some major refactorings
 *
 * Revision 1.2  2004/11/08 03:50:06  sliver
 * *** empty log message ***
 *
 * Revision 1.1  2004/11/04 08:52:14  sliver
 * added regular expressions
 *
 */



using NUnit.Framework;
using Palladio.FiniteStateMachines;
using Palladio.Performance.Attributes;
using Palladio.RegularExpressions.GNFA;

#if TEST
namespace Palladio.RegularExpressions.Tests
{
	[TestFixture]
	public class RegexTest
	{
		[Test]
		public void TestFactory()
		{
			IFiniteStateMachine fsm = TestBuilder.CreateTestRegexFSMSimple();
			IRegEx regEx = RegexFactory.FSMToRegex(fsm);
			Assert.AreEqual("(a|b)*c", regEx.ToString());
		}

		[Test]
		public void TestSymbol()
		{
			IInput symbol = FSMFactory.CreateDefaultInput("a");
			ISymbol regex = RegexFactory.Symbol(symbol);
			Assert.AreEqual(symbol, regex.InputSymbol);
			Assert.AreEqual("a", regex.ToString());
		}

		[Test]
		public void TestLoop()
		{
			IInput symbol = FSMFactory.CreateDefaultInput("a");
			ISymbol regexSymbol = RegexFactory.Symbol(symbol);
			ILoop regex = RegexFactory.Loop(regexSymbol);
			Assert.AreEqual(regexSymbol, regex.InnerExpression);
			Assert.AreEqual("a*", regex.ToString());
		}

		[Test]
		public void TestSequence()
		{
			InputSymbolHash sh = FSMFactory.CreateInputFromList("a", "b");
			ISymbol a = RegexFactory.Symbol(sh["a"]);
			ISymbol b = RegexFactory.Symbol(sh["b"]);
			ISequence regex = RegexFactory.Sequence(a, b);
			Assert.AreEqual(a, regex.Predecessor);
			Assert.AreEqual(b, regex.Successor);
			Assert.AreEqual("ab", regex.ToString());
		}

		[Test]
		public void TestAlternative()
		{
			InputSymbolHash sh = FSMFactory.CreateInputFromList("a", "b");
			ISymbol a = RegexFactory.Symbol(sh["a"]);
			ISymbol b = RegexFactory.Symbol(sh["b"]);
			IAlternative regex = RegexFactory.Alternative(a, b);
			Assert.AreEqual(a, regex.AlternativeOne);
			Assert.AreEqual(b, regex.AlternativeTwo);
			Assert.AreEqual("a|b", regex.ToString());
		}

		[Test]
		public void TestComplexExpression()
		{
			ISequence abcLd = GenerateComplexExpression();
			Assert.AreEqual("((a|b)c)*d", abcLd.ToString());
		}

		[Test]
		public void TestEquals()
		{
			ISequence s1 = GenerateComplexExpression();
			ISequence s2 = GenerateComplexExpression();
			Assert.AreEqual(s1, s2);
		}

		private static ISequence GenerateComplexExpression()
		{
			InputSymbolHash sh = FSMFactory.CreateInputFromList("a", "b", "c", "d");
			ISymbol a = RegexFactory.Symbol(sh["a"]);
			ISymbol b = RegexFactory.Symbol(sh["b"]);
			ISymbol c = RegexFactory.Symbol(sh["c"]);
			ISymbol d = RegexFactory.Symbol(sh["d"]);
			IAlternative ab = RegexFactory.Alternative(a, b);
			ISequence abc = RegexFactory.Sequence(ab, c);
			ILoop abcL = RegexFactory.Loop(abc);
			return RegexFactory.Sequence(abcL, d);
		}

		[Test]
		public void TestCreateGNFA()
		{
			IFiniteStateMachine fsm = TestBuilder.CreateTestMarkovModel();
			IFiniteStateMachine gnfa = FSMToRegexConverter.CreateGNFA(fsm);
			foreach (ITransition transition in fsm.Transitions)
			{
				IInput gnfaInput = RegexFactory.Symbol(transition.InputSymbol);
				ITransition gnfaTransition = gnfa.GetNextTransition(transition.SourceState, gnfaInput);
				Assert.AreEqual(transition.SourceState, gnfaTransition.SourceState);
				Assert.AreEqual(transition.DestinationState, gnfaTransition.DestinationState);
				Assert.AreEqual(transition.InputSymbol.ToString(), gnfaTransition.InputSymbol.ToString());
			}
			ITransition[] outgoing = gnfa.GetOutgoingTransitions(gnfa.StartState);
			Assert.AreEqual(1, outgoing.Length);
			Assert.AreEqual(fsm.StartState, outgoing[0].DestinationState);
			Assert.AreEqual(1, gnfa.FinalStates.Length);
			foreach (IState finalState in fsm.FinalStates)
			{
				Assert.IsFalse(gnfa.IsFinalState(finalState));
				bool toFinal = false;
				foreach (ITransition outgoingTransition in gnfa.GetOutgoingTransitions(finalState))
				{
					if (gnfa.IsFinalState(outgoingTransition.DestinationState))
					{
						toFinal = true;
						break;
					}
				}
				Assert.IsTrue(toFinal);
			}
		}

		[Test]
		public void TestMelting()
		{
			IFiniteStateMachine fsm = TestBuilder.CreateTestMeltingFSM();

			IEditableFiniteStateMachine gnfa = FSMToRegexConverter.CreateGNFA(fsm);
			FSMToRegexConverter.MeltTransitions(ref gnfa);

			ITransition[] outgoing = gnfa.GetOutgoingTransitions(fsm.StartState);
			Assert.AreEqual(2, outgoing.Length);
			foreach (ITransition transition in outgoing)
			{
				if (transition.DestinationState.ToString().Equals("2"))
				{
					Assert.AreEqual("a|b|c", transition.InputSymbol.ToString());
				}
				if (transition.DestinationState.ToString().Equals("3"))
				{
					Assert.AreEqual("d|e", transition.InputSymbol.ToString());
				}
			}
		}

		[Test]
		public void TestFSM1()
		{
			IFiniteStateMachine fsm = TestBuilder.CreateTestRegexFSM1();
			IRegEx regEx = RegexFactory.FSMToRegex(fsm);
			Assert.AreEqual("(ab|e|(af|c)d)*(af|c)", regEx.ToString());
		}

		[Test]
		public void TestFSMComplex()
		{
			IFiniteStateMachine fsm = TestBuilder.CreateTestRegexFSMComplex();
			IRegEx regEx = RegexFactory.FSMToRegex(fsm);
			Assert.AreEqual("(ab|cd|e)*(cf|ah)((ib|gd)(ab|cd|e)*(cf|ah)|ih|gf)*", regEx.ToString());
		}

		[Test]
		public void CreateTestFSMWithAttributes()
		{
			IFiniteStateMachine fsm = TestBuilder.CreateTestFSMWithAttributes();
			foreach(ITransition transition in fsm.Transitions)
			{
				Assert.IsTrue(transition.Attributes.Contains(RandomVariable.AttributeType));
			}
			foreach(IState state in fsm.States)
			{
				Assert.IsTrue(state.Attributes.Contains(RandomVariable.AttributeType));
			}
		}
		[Test]
		public void TestLoopFSM()
		{
			IFiniteStateMachine fsm = TestBuilder.CreateLoopFSM();
			IRegEx regex = RegexFactory.FSMToRegex(fsm);
			Assert.AreEqual("a*",regex.ToString());
		}

		[TestFixtureSetUp]
		public void Init()
		{
		}
	}
}
#endif
