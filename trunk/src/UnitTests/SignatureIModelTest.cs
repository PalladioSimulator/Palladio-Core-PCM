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
		SignatureListIModel modelOne, modelTwo, modelThree;

		[SetUp] public void Init() 
		{
			one = new SimpleSignature("one");
			two = new SimpleSignature("two");
			three = new SimpleSignature("three");
			four = new SimpleSignature("four");
			sigListOne = new ArrayList();
			sigListTwo = new ArrayList();
			sigListOne.Add(one);
			sigListOne.Add(two);
			sigListOne.Add(three);
			sigListTwo.Add(three);
			sigListTwo.Add(four);
			modelOne = new SignatureListIModel(sigListOne);
			modelTwo = new SignatureListIModel(sigListTwo);
			modelThree = new SignatureListIModel(new ArrayList(sigListOne));
		}


		[Test] public void SignatureList() 
		{
		}

		[Test] public void Equals()
		{
			Assert.IsTrue(modelOne.Equals(modelThree));
			Assert.IsFalse(modelOne.Equals(modelTwo));
		}

		[Test] public void Clone()
		{
			SignatureListIModel model = (SignatureListIModel) modelTwo.Clone();
			Assert.IsTrue(model.Equals(modelTwo));
		}

		[Test] public void Intersect()
		{
		}

		[Test] public void IsSubSetOf()
		{
		}

		[Test] public void Merge()
		{
		}

	}
}
