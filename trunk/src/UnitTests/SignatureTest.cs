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
	public class SignatureTest
	{
		ISignature one, one1, two, three, four;
		IList sigListDouble, sigListOne1, sigList;

		[SetUp] public void Init() 
		{
			one = new SimpleSignature("one");
			one1 = new SimpleSignature("one");
			two = new SimpleSignature("two");
			three = new SimpleSignature("three");
			four = new SimpleSignature("four");
			sigList = new Vector();
			sigList.Add(two);
			sigList.Add(three);
			sigList.Add(four);
			sigListOne1 = new Vector(sigList);
			sigListOne1.Add(one1);
			sigListDouble = new Vector(sigListOne1);
			sigListDouble.Add(one);
		}
		
		[Test] public void Match() 
		{
			Assert.IsTrue(one.Match(one1));
			Assert.IsFalse(one.Match(two));
		}

		[Test] public void HasMatches() 
		{
			Assert.IsTrue(one.HasMatches(sigListOne1));
			Assert.IsFalse(one.HasMatches(sigList));
			IList matchList;
			one.HasMatches(sigListDouble,out matchList);
			Assert.IsTrue(matchList.Count == 2);
		}

		[Test] public void HasOneMatch() 
		{
			Assert.IsTrue(one.HasOneMatch(sigListOne1));
			Assert.IsFalse(one.HasOneMatch(sigList));
			Assert.IsFalse(one.HasOneMatch(sigListDouble));
		}

		[Test] public void Equals()
		{
			Assert.IsTrue(one.Equals(one1));
			Assert.IsFalse(one.Equals(two));
		}

		[Test] public void Clone()
		{
			ISignature sig = (ISignature)one.Clone();
			Assert.IsTrue(sig.Equals(one1));
		}
	}
}
