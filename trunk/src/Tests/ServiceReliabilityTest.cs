/*
 * $Id$
 * 
 * $Log$
 * Revision 1.6  2004/11/18 06:53:17  sliver
 * *** empty log message ***
 *
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
			Assert.AreEqual(0.99, sr.Expression);
		}

		[Test]
		public void FSMReliability()
		{
			ServiceReliability sr = new ServiceReliability(markovModel, reliabilityHashtable);
			Assert.AreEqual(1.0, sr.Expression, 0.0000001);
		}



		[Test]
		public void FSMVarReliabilityDeep()
		{
			ServiceReliability sr = new ServiceReliability(markovModel, reliabilityHashtable);
			ReliabilityHashtable deepRelHashtable = new ReliabilityHashtable(reliabilityHashtable);
			deepRelHashtable[fsm.InputAlphabet[0].ID] = sr.Expression;

			ServiceReliability sr2 = new ServiceReliability(markovModel, deepRelHashtable);

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
				reliabilityHashtable.Add(i.ID, 1.0);
			}
			markovModel = new MarkovModel(fsm);
		}

		private IFiniteStateMachine fsm;
		private ReliabilityHashtable reliabilityHashtable;
		private IMarkovModel markovModel;
	}
}

#endif