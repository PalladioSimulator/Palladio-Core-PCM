/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 * Revision 1.1  2004/09/23 00:44:14  sliver
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
	public class MarkovModelTest
	{
		[Test]
		public void Assertion()
		{
//			IFiniteStateMachine fsm = TestBuilder.CreateTestFSM1();
//			fsm.Transitions[0].Attributes.Add(MarkovAttribute.AttributeType,null);
//			MarkovModel mm = new MarkovModel(fsm);
		}

		[Test]
		public void AllRowsOne()
		{
			for (int i = 0; i < transitionMatrix.LengthY - 1; i++)
				Assert.AreEqual(1.0, Helper.SumUpRow(transitionMatrix.Matrix, i));
		}

		[Test]
		public void LastRowZero()
		{
			Assert.AreEqual(0.0, Helper.SumUpRow(transitionMatrix.Matrix, transitionMatrix.LengthY - 1));
		}

		[Test]
		public void ReliabilityInfluence()
		{
			for (int i = 0; i < transitionMatrix.LengthY - 1; i++)
			{
				double sum = Helper.SumUpRow(transitionMatrix.Matrix, i);
				Assert.IsTrue(sum > 0);
				Assert.IsTrue(sum <= 1);
			}
		}

		[Test]
		public void Shrink()
		{
			int[] indices = new int[] {0, 1, 2, 5};
			ITransitionMatrix tMx = transitionMatrix.ShrinkTo(indices);
			for (int i = 0; i < indices.Length; i++)
				for (int j = 0; j < indices.Length; j++)
				{
					Assert.AreEqual(tMx.Matrix[i, j], transitionMatrix.Matrix[indices[i], indices[j]]);
				}
			Assert.AreEqual(indices.Length, tMx.Rank);
			Assert.AreEqual(0, tMx.StartStateIndex);
			Assert.AreEqual(indices.Length - 1, tMx.FinalStateIndex);
		}

		[TestFixtureSetUp]
		public void Init()
		{
			fsm = TestBuilder.CreateTestFSM1();
			reliabilityHashmap = new ReliabilityHashmap();
			foreach (IInput i in fsm.InputAlphabet)
			{
				reliabilityHashmap.Add(i.ID, new ServiceReliability(0.5));
			}
			markovModel = new MarkovModel(fsm);
			transitionMatrix = new TransitionMatrix(markovModel);
		}

		private IFiniteStateMachine fsm;
		private ReliabilityHashmap reliabilityHashmap;
		private IMarkovModel markovModel;
		private ITransitionMatrix transitionMatrix;
	}
}

#endif