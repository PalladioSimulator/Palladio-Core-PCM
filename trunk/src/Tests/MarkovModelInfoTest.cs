/*
 * $Id$
 * 
 * $Log$
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

using cdrnet.Lib.MathLib.Core;
using NUnit.Framework;
using Palladio.ComponentModel;
using Palladio.Identifier;
using Palladio.Reliability.Math;
using Palladio.Reliability.TypedCollections;

namespace Palladio.Reliability.Tests
{
	[TestFixture]
	public class MarkovModelInfoTest
	{
		[Test]
		public void AllRowsOne()
		{
			MarkovModelInfo modelInfo = new MarkovModelInfo(new Context(), fsmSeff.FSM);
			for (int i = 0; i < modelInfo.TransitionMatrix.LengthY - 1; i++)
				Assert.AreEqual(1.0, Helper.SumUpRow(modelInfo.TransitionMatrix, i));
		}

		public void LastRowZero()
		{
			MarkovModelInfo modelInfo = new MarkovModelInfo(new Context(), fsmSeff.FSM);
			Assert.AreEqual(0.0, Helper.SumUpRow(modelInfo.TransitionMatrix, modelInfo.TransitionMatrix.LengthY - 1));
		}

		[Test]
		public void ReliabilityInfluence()
		{
			MarkovModelInfo modelInfo = new MarkovModelInfo(new Context(), fsmSeff.FSM, reliabilityHashmap);
			for (int i = 0; i < modelInfo.TransitionMatrix.LengthY - 1; i++)
			{
				double sum = Helper.SumUpRow(modelInfo.TransitionMatrix, i);
				Assert.IsTrue(sum > 0);
				Assert.IsTrue(sum <= 1);
			}
		}

		[Test]
		public void TestMethod()
		{
		}

		[TestFixtureSetUp]
		public void Init()
		{
			seff = CMBuilder.CreateServiceEffectD1();
			reliabilityHashmap = new ReliabilityHashmap();
			foreach (IIdentifiable sig in seff.SignatureList)
			{
				reliabilityHashmap.Add(sig, new ServiceReliability(0.5));
			}
			fsmSeff = (IFSMServiceEffect) seff.GetAuxiliarySpecification(typeof (IFSMServiceEffect));
		}


		private IServiceEffectSpecification seff;
		private ReliabilityHashmap reliabilityHashmap;
		private IFSMServiceEffect fsmSeff;
	}
}

#endif