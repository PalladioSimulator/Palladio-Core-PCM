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
	public class ServiceReliabilityTest
	{
		[Test]
		public void ValueReliability()
		{
			ServiceReliability sr = new ServiceReliability(0.99);
			Assert.IsFalse( sr.HasVariables );
			Assert.AreEqual( 0.99, sr.Expression.Calculate() );
		}
		
		[Test]
		public void FSMReliability()
		{
			ServiceReliability sr = new ServiceReliability( fsmSeff.FSM, reliabilityHash );
			Assert.IsFalse( sr.HasVariables );
			Assert.AreEqual( 1.0, sr.Expression.Calculate(), 0.0000001 );
		}
		
		[Test]
		public void ValueVarReliability()
		{
			ServiceReliability sr = new ServiceReliability("x");
			Assert.IsTrue( sr.HasVariables );
			Assert.IsTrue( sr.Variables.Length == 1 );
			Assert.IsTrue( sr.VariableSet.Count == 1 );
			Assert.IsFalse( sr.Expression.IsConstant );
			Assert.IsTrue( sr.Variables[0].VariableName == "x" );
		}
		
		
		[Test]
		public void FSMVarReliability()
		{
			ServiceReliability sr = new ServiceReliability( fsmSeff.FSM, varRelHash );
			Assert.IsTrue( sr.HasVariables );
			Assert.IsTrue( sr.Variables.Length == 1 );
			Assert.IsTrue( sr.VariableSet.Count == 1 );
			Assert.IsFalse( sr.Expression.IsConstant );
			Assert.IsTrue( sr.Variables[0].VariableName == "x" );
			Helper.SetValue(ref sr.Variables[0], 1.0);
			Assert.AreEqual( 1.0, sr.Expression.Calculate());
			sr.Variables[0].IsThreatenedAsVariable = true;
		}
		
		
		[Test]
		public void FSMVarReliabilityDeep()
		{
			ServiceReliability sr = new ServiceReliability( fsmSeff.FSM, varRelHash );
			ReliabilityHash deepRelHash = new ReliabilityHash(reliabilityHash);
			deepRelHash[ fsmSeff.Signatures[0] ] = sr;
			
			ServiceReliability sr2 = new ServiceReliability( fsmSeff.FSM, deepRelHash );
			
			Assert.IsTrue( sr2.HasVariables );
			Assert.IsTrue( sr2.Variables.Length == 1 );
			Assert.IsTrue( sr2.VariableSet.Count == 1 );
			Assert.IsFalse( sr2.Expression.IsConstant );
			Assert.IsTrue( sr2.Variables[0].VariableName == "x" );
			Helper.SetValue(ref sr2.Variables[0], 1.0);
			Assert.AreEqual( 1.0, sr2.Expression.Calculate());
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
				reliabilityHash.Add(s, new ServiceReliability(1.0));
			}
			fsmSeff = (IFSMServiceEffect)seff.GetAuxiliarySpecification( typeof( IFSMServiceEffect ) );
			
			varRelHash = new ReliabilityHash(reliabilityHash);
			IExternalSignature sig = null;
			foreach( IExternalSignature s in varRelHash.Keys )
			{
				sig = s;	
				break;
			}
			varRelHash.Remove(sig);
			varRelHash.Add(sig, new ServiceReliability("x"));
		}
		
		IServiceEffectSpecification seff;
		ReliabilityHash reliabilityHash;
		ReliabilityHash varRelHash;
		IFSMServiceEffect fsmSeff;
	}
}
#endif
