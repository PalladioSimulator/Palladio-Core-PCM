/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/07/12 06:33:04  sliver
 * Initial checkin
 * 
 */

#if TEST

using System;
using NUnit.Framework;

using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;
using Palladio.Reliability;
using Palladio.Reliability.TypedCollections;
using Palladio.Reliability.Math;

using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;
using cdrnet.Lib.MathLib.Parsing;
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Tools;


namespace Palladio.Reliability.Tests
{
	[TestFixture]
	public class MarkovMatrixTest
	{
		[Test]
		public void AllRowsOne()
		{
			MarkovMatrix matrix = new MarkovMatrix(new Context(), fsmSeff.FSM);
			for( int i = 0; i < matrix.Matrix.LengthY-1; i++ )
				Assert.AreEqual( 1.0, Helper.SumUpRow( matrix.Matrix, i ) );
		}
		
		public void LastRowZero()
		{
			MarkovMatrix matrix = new MarkovMatrix(new Context(), fsmSeff.FSM);
			Assert.AreEqual( 0.0, Helper.SumUpRow( matrix.Matrix, matrix.Matrix.LengthY-1 ) );
		}		
		
		[Test]
		public void ReliabilityInfluence()
		{
			MarkovMatrix matrix = new MarkovMatrix(new Context(), fsmSeff.FSM, reliabilityHash);
			for( int i = 0; i < matrix.Matrix.LengthY-1; i++ )
			{
				double sum = Helper.SumUpRow( matrix.Matrix, i );
				Assert.IsTrue( sum > 0 );
				Assert.IsTrue( sum <= 1 );
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
			reliabilityHash = new ReliabilityHash();
			foreach (IExternalSignature s in seff.SignatureList)
			{
				reliabilityHash.Add(s, new ServiceReliability(0.5));
			}
			fsmSeff = (IFSMServiceEffect)seff.GetAuxiliarySpecification( typeof( IFSMServiceEffect ) );
		}
		
		
		private IServiceEffectSpecification seff;
		private ReliabilityHash reliabilityHash;		
		private IFSMServiceEffect fsmSeff;
	}
}
#endif
