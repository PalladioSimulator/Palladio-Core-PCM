/*
 * $Id$
 * 
 * $Log$
 * Revision 1.5  2004/11/04 08:52:13  sliver
 * added regular expressions
 *
 * Revision 1.4  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 * Revision 1.3  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
 * Revision 1.2  2004/09/09 04:07:53  sliver
 * code refactored
 * vs.net project files created
 *
 * Revision 1.1  2004/07/12 06:33:04  sliver
 * Initial checkin
 * 
 */

#if TEST

using NUnit.Framework;
using Palladio.FiniteStateMachines;
using Palladio.Reliability.Math;
using Palladio.Reliability.TypedCollections;

namespace Palladio.Reliability.Tests
{
	[TestFixture]
	public class ServiceReliabilityTest
	{
		[Test]
		public void ValueReliability()
		{
			ServiceReliability sr = new ServiceReliability(0.99);
			Assert.IsFalse(sr.HasVariables);
			Assert.AreEqual(0.99, sr.Expression.Calculate());
		}

		[Test]
		public void FSMReliability()
		{
			ServiceReliability sr = new ServiceReliability(markovModel, reliabilityHashtable);
			Assert.IsFalse(sr.HasVariables);
			Assert.AreEqual(1.0, sr.Expression.Calculate(), 0.0000001);
		}

		[Test]
		public void ValueVarReliability()
		{
			ServiceReliability sr = new ServiceReliability("x");
			Assert.IsTrue(sr.HasVariables);
			Assert.IsTrue(sr.Variables.Length == 1);
			Assert.IsTrue(sr.VariableSet.Count == 1);
			Assert.IsFalse(sr.Expression.IsConstant);
			Assert.IsTrue(sr.Variables[0].VariableName == "x");
		}


		[Test]
		public void FSMVarReliability()
		{
			ServiceReliability sr = new ServiceReliability(markovModel, varRelHashtable);
			Assert.IsTrue(sr.HasVariables);
			Assert.IsTrue(sr.Variables.Length == 1);
			Assert.IsTrue(sr.VariableSet.Count == 1);
			Assert.IsFalse(sr.Expression.IsConstant);
			Assert.IsTrue(sr.Variables[0].VariableName == "x");
			Helper.SetValue(ref sr.Variables[0], 1.0);
			Assert.AreEqual(1.0, sr.Expression.Calculate());
			sr.Variables[0].IsThreatenedAsVariable = true;
		}


		[Test]
		public void FSMVarReliabilityDeep()
		{
			ServiceReliability sr = new ServiceReliability(markovModel, varRelHashtable);
			ReliabilityHashtable deepRelHashtable = new ReliabilityHashtable(reliabilityHashtable);
			deepRelHashtable[fsm.InputAlphabet[0].ID] = sr;

			ServiceReliability sr2 = new ServiceReliability(markovModel, deepRelHashtable);

			Assert.IsTrue(sr2.HasVariables);
			Assert.IsTrue(sr2.Variables.Length == 1);
			Assert.IsTrue(sr2.VariableSet.Count == 1);
			Assert.IsFalse(sr2.Expression.IsConstant);
			Assert.IsTrue(sr2.Variables[0].VariableName == "x");
			Helper.SetValue(ref sr2.Variables[0], 1.0);
			Assert.AreEqual(1.0, sr2.Expression.Calculate(), 0.000000001);
		}


		[Test]
		public void TestMethod()
		{
		}

		[TestFixtureSetUp]
		public void Init()
		{
			fsm = TestBuilder.CreateTestFSM1();
			reliabilityHashtable = new ReliabilityHashtable();
			foreach (IInput i in fsm.InputAlphabet)
			{
				reliabilityHashtable.Add(i.ID, new ServiceReliability(1.0));
			}
			markovModel = new MarkovModel(fsm);
			transitionMatrix = new TransitionMatrix(markovModel);

			varRelHashtable = new ReliabilityHashtable(reliabilityHashtable);
			IMatchable key = fsm.InputAlphabet[0].ID;
			varRelHashtable.Remove(key);
			varRelHashtable.Add(key, new ServiceReliability("x"));
		}

		private IFiniteStateMachine fsm;
		private ReliabilityHashtable reliabilityHashtable;
		private ReliabilityHashtable varRelHashtable;
		private IMarkovModel markovModel;
		private ITransitionMatrix transitionMatrix;
	}
}

#endif