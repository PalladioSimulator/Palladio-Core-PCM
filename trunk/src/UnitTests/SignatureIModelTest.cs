using System;
using System.Collections;
using System.Reflection;
using NUnit.Framework;
using Utils.Collections;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// </summary>
	[TestFixture]
	public class SignatureIModelTest
	{
		ISignature one, two, three, four;
		IList sigListOne, sigListTwo;
		SignatureListIModel modelOne, modelTwo, modelThree, expectedIsec, expectedMerge, corrupted;

		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			one = new SimpleSignature("one");
			two = new SimpleSignature("two");
			three = new SimpleSignature("three");
			four = new SimpleSignature("four");
			sigListOne = new Vector();
			sigListTwo = new Vector();
			sigListOne.Add(one);
			sigListOne.Add(two);
			sigListOne.Add(three);
			sigListTwo.Add(three);
			sigListTwo.Add(four);
			modelOne = new SignatureListIModel(new Vector(sigListOne));
			modelTwo = new SignatureListIModel(new Vector(sigListTwo));
			modelThree = new SignatureListIModel(new Vector(sigListOne));

			IList iSecList = new Vector();
			iSecList.Add(three);
			expectedIsec = new SignatureListIModel(iSecList);

			sigListOne.Add(four);
			expectedMerge = new SignatureListIModel(new Vector(sigListOne));

			sigListOne.Remove(four);
			sigListOne.Add(three);
			corrupted = new SignatureListIModel(new Vector(sigListOne));
		}


		/// <summary>
		/// </summary>
		[Test] public void SignatureList() 
		{
		}

		/// <summary>
		/// </summary>
		[Test] public void Equals()
		{
			Assert.IsTrue(modelOne.Equals(modelThree));
			Assert.IsFalse(modelOne.Equals(modelTwo));
		}

		/// <summary>
		/// </summary>
		[Test] public void Clone()
		{
			SignatureListIModel model = (SignatureListIModel) modelTwo.Clone();
			Assert.IsTrue(model.Equals(modelTwo));
			model.SignatureList.RemoveAt(0);
			Assert.IsFalse(model.Equals(modelTwo));
		}

		/// <summary>
		/// </summary>
		[Test] public void GetIntersection()
		{
			SignatureListIModel isec = (SignatureListIModel)modelOne.GetIntersection(modelTwo);
			Assert.AreEqual(expectedIsec,isec);
			Assert.IsFalse(expectedIsec.Equals(modelOne));
			Assert.IsFalse(expectedIsec.Equals(modelTwo));
		}

		/// <summary>
		/// </summary>
		[Test] public void IsSubSetOf()
		{
			Assert.IsTrue(expectedIsec.IsSubSetOf(modelOne));
			Assert.IsTrue(expectedIsec.IsSubSetOf(modelTwo));
			Assert.IsFalse(modelOne.IsSubSetOf(modelTwo));
			Assert.IsFalse(modelTwo.IsSubSetOf(modelOne));
		}

		/// <summary>
		/// </summary>
		[Test] public void Merge()
		{
			SignatureListIModel merged = (SignatureListIModel)modelOne.Merge(modelTwo);
			Assert.AreEqual(expectedMerge,merged);
		}

		/// <summary>
		/// </summary>
		[ExpectedException(typeof(AmbiguousMatchException))]
		[Test] public void CorruptedMerge()
		{
			IInterfaceModel result = corrupted.Merge(modelOne);
		}
	}
}
