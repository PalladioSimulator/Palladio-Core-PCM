#if TEST

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
	/// <exclude />
	[TestFixture]
	public class SignatureListTest
	{
		protected ISignatureList modelOne, modelOne1, modelThree;

		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			modelOne = ComponentFactory.CreateSignatureList("d1","d2","d3");		
			modelOne1 = ComponentFactory.CreateSignatureList("d2","d1","d3");		
			modelThree = ComponentFactory.CreateSignatureList("e2","e1","d3");		
		}	

		/// <summary>
		/// </summary>
		[Test] public void Equals()
		{
			Assert.IsTrue(modelOne.Equals(modelOne1));
			Assert.IsFalse(modelOne.Equals(modelThree));
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
			ISignature[] sigs = modelOne.Signatures;
			Assert.IsTrue( Array.IndexOf( sigs, ComponentFactory.CreateSignature("d1")) >= 0);
			Assert.IsTrue( Array.IndexOf( sigs, ComponentFactory.CreateSignature("d2")) >= 0);
			Assert.IsTrue( Array.IndexOf( sigs, ComponentFactory.CreateSignature("d3")) >= 0);
		}

		[Test] public void AddSignature()
		{
			modelOne.AddSignatures( ComponentFactory.CreateSignatureArray("d3","d4","d5") );
			ISignature[] sigs = modelOne.Signatures;
			Assert.AreEqual( 5, sigs.Length );
			Assert.IsTrue( Array.IndexOf( sigs, ComponentFactory.CreateSignature("d1")) >= 0);
			Assert.IsTrue( Array.IndexOf( sigs, ComponentFactory.CreateSignature("d2")) >= 0);
			Assert.IsTrue( Array.IndexOf( sigs, ComponentFactory.CreateSignature("d3")) >= 0);
			Assert.IsTrue( Array.IndexOf( sigs, ComponentFactory.CreateSignature("d4")) >= 0);
			Assert.IsTrue( Array.IndexOf( sigs, ComponentFactory.CreateSignature("d5")) >= 0);
		}

		[Test] public void DeleteSignature()
		{
			modelOne.AddSignatures( ComponentFactory.CreateSignatureArray("d3","d4","d5") );
			modelOne.DeleteSignatures( ComponentFactory.CreateSignatureArray("d4", "d5") );
			Assert.AreEqual( modelOne1, modelOne);
			modelOne.DeleteSignatures( ComponentFactory.CreateSignatureArray("d4", "d5") );
			Assert.AreEqual( modelOne1, modelOne);
		}

		[Test] public void CreateServiceEffectSigList()
		{
			IExternalSignatureList se = ComponentFactory.CreateExternalSignatureList();
			se.AddSignatures ( ComponentFactory.CreateSignatureWithRole("role A",
								ComponentFactory.CreateSignature("d1")) );
			se.AddSignatures ( ComponentFactory.CreateSignatureWithRole("role B",
								ComponentFactory.CreateSignature("d2")) );
			se.AddSignatures ( ComponentFactory.CreateSignatureWithRole("role B",
								ComponentFactory.CreateSignature("d3")) );
			Assert.AreEqual( 3, se.Signatures.Length);
		}

	}
}

#endif																																							 