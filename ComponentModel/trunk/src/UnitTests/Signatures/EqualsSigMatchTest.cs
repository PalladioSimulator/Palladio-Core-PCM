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
	public class EqualsSigMatchTest
	{
		ISignature one, one1, two, three, four;
		IList sigListDouble, sigListOne1, sigList;

		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			one = new MethodSignature("one");
			one1 = new MethodSignature("one");
			two = new MethodSignature("two");
			three = new MethodSignature("three");
			four = new MethodSignature("four");
			sigList = new Vector();
			sigList.Add(two);
			sigList.Add(three);
			sigList.Add(four);
			sigListOne1 = new Vector(sigList);
			sigListOne1.Add(one1);
			sigListDouble = new Vector(sigListOne1);
			sigListDouble.Add(one);
		}
		
//		/// <summary>
//		/// </summary>
//		[Test] public void Match() 
//		{
//			Assert.IsTrue(one.Match(one1));
//			Assert.IsFalse(one.Match(two));
//		}
//
//		/// <summary>
//		/// </summary>
//		[Test] public void HasMatches() 
//		{
//			Assert.IsTrue(one.HasMatches(sigListOne1));
//			Assert.IsFalse(one.HasMatches(sigList));
//			IList matchList;
//			one.HasMatches(sigListDouble,out matchList);
//			Assert.IsTrue(matchList.Count == 2);
//		}
//
//		/// <summary>
//		/// </summary>
//		[Test] public void HasOneMatch() 
//		{
//			Assert.IsTrue(one.HasOneMatch(sigListOne1));
//			Assert.IsFalse(one.HasOneMatch(sigList));
//			Assert.IsFalse(one.HasOneMatch(sigListDouble));
//		}
//
//		/// <summary>
//		/// </summary>
//		[Test] public void Equals()
//		{
//			Assert.IsTrue(one.Equals(one1));
//			Assert.IsFalse(one.Equals(two));
//		}
//
//		/// <summary>
//		/// </summary>
//		[Test] public void Clone()
//		{
//			ISignature sig = (ISignature)one.Clone();
//			Assert.IsTrue(sig.Equals(one1));
//		}
	}
}
