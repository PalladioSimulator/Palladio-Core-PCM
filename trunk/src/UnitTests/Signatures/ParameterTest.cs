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
	public class ParameterTest
	{
		Parameter pOne, pOne1, pTwo;
		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			pOne = new Parameter(new ReflectedType(typeof(IType)), "aType");
			pOne1 = new Parameter(new ReflectedType(typeof(IType)), "aType");
			pTwo = new Parameter(new ReflectedType(typeof(string)), "aName");
		}

		/// <summary>
		/// </summary>
		[Test] public void Equals()
		{
			Assert.IsTrue(pOne.Equals(pOne1));
			Assert.IsFalse(pOne.Equals(pTwo));
		}

		/// <summary>
		/// </summary>
		[Test] public void Clone()
		{
			Parameter clone = (Parameter)pOne.Clone();
			Assert.IsTrue(clone.Equals(pOne1));
			clone.Name = "anders";
			Assert.IsFalse(clone.Equals(pOne));
			clone = (Parameter)pOne.Clone();
			clone.Type = new ReflectedType(typeof(void));
			Assert.IsFalse(clone.Equals(pOne));
		}
	}
}
