//#if TEST

using System;
using System.Collections;
using System.Reflection;
using NUnit.Framework;
using Palladio.Utils.Collections;
using Palladio.ComponentModel.Exceptions;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// </summary>
	[TestFixture]
	public class SignatureListTest
	{
		protected ISignatureList modelOne, modelOne1, modelTwo, modelThree;

		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			modelOne = ComponentFactory.CreateSignatureListInterface("role A","d1","d2","d3");		
			modelOne1 = ComponentFactory.CreateSignatureListInterface("role A","d2","d1","d3");		
			modelTwo = ComponentFactory.CreateSignatureListInterface("role B","d2","d1","d3");		
			modelThree = ComponentFactory.CreateSignatureListInterface("role B","e2","e1","d3");		
		}	

		/// <summary>
		/// </summary>
		[Test] public void Equals()
		{
			Assert.IsTrue(modelOne.Equals(modelOne1));
			Assert.IsFalse(modelOne.Equals(modelTwo));
			Assert.IsFalse(modelTwo.Equals(modelThree));
		}

		/// <summary>
		/// </summary>
		[Test] public void Clone()
		{
			ISignatureList model = (ISignatureList) modelOne.Clone();
			Assert.IsTrue(model.Equals(modelOne));
			model.DeleteSignatures(model[0]);
			Assert.IsFalse(model.Equals(modelOne));
		}

		[Test] public void ContentComplete()
		{
			Assert.AreEqual( 3,  modelOne.Signatures.Length );
			Assert.AreEqual( "role A", modelOne.RoleID );
			ISignature[] sigs = modelOne.Signatures;
			Assert.IsTrue( Array.IndexOf( sigs, ComponentFactory.CreateSignature("role A", "d1")) >= 0);
			Assert.IsTrue( Array.IndexOf( sigs, ComponentFactory.CreateSignature("role A", "d2")) >= 0);
			Assert.IsTrue( Array.IndexOf( sigs, ComponentFactory.CreateSignature("role A", "d3")) >= 0);
		}

		[Test] public void AddSignature()
		{
			modelOne.AddSignatures( ComponentFactory.CreateSignatureArray("role A","d3","d4","d5") );
			ISignature[] sigs = modelOne.Signatures;
			Assert.AreEqual( 5, sigs.Length );
			Assert.IsTrue( Array.IndexOf( sigs, ComponentFactory.CreateSignature("role A", "d1")) >= 0);
			Assert.IsTrue( Array.IndexOf( sigs, ComponentFactory.CreateSignature("role A", "d2")) >= 0);
			Assert.IsTrue( Array.IndexOf( sigs, ComponentFactory.CreateSignature("role A", "d3")) >= 0);
			Assert.IsTrue( Array.IndexOf( sigs, ComponentFactory.CreateSignature("role A", "d4")) >= 0);
			Assert.IsTrue( Array.IndexOf( sigs, ComponentFactory.CreateSignature("role A", "d5")) >= 0);
		}

		[ExpectedException(typeof(RoleIDMissmatchException))]
		[Test] public void AddSignatureWithDifferentRole()
		{
			modelOne.AddSignatures( ComponentFactory.CreateSignatureArray("role B","d3","d4","d5") );
		}

		[Test] public void DeleteSignature()
		{
			modelOne.AddSignatures( ComponentFactory.CreateSignatureArray("role A","d3","d4","d5") );
			modelOne.DeleteSignatures( ComponentFactory.CreateSignatureArray("role A", "d4", "d5") );
			Assert.AreEqual( modelOne1, modelOne);
			modelOne.DeleteSignatures( ComponentFactory.CreateSignature("role B", "d1" ) );
			Assert.AreEqual( modelOne1, modelOne);
			modelOne.DeleteSignatures( ComponentFactory.CreateSignatureArray("role A", "d4", "d5") );
			Assert.AreEqual( modelOne1, modelOne);
		}

		[Test] public void CreateServiceEffectSigList()
		{
			ISignatureList se = ComponentFactory.CreateSignatureListServiceEffect();
			se.AddSignatures ( ComponentFactory.CreateSignature("role A","d1") );
			se.AddSignatures ( ComponentFactory.CreateSignature("role B","d1") );
			se.AddSignatures ( ComponentFactory.CreateSignature("role B","d2") );
			Assert.AreEqual( 3, se.Signatures.Length);
		}

	}
}

//#endif																																							 