#if TEST

using System;
using System.Collections;
using System.Reflection;
using NUnit.Framework;
using Palladio.Utils.Collections;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// </summary>
	[TestFixture]
	public class ParameterTest
	{
		private IParameter pOne, pOne1, pTwo;
		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			pOne = ComponentFactory.CreateParameter (typeof(IType), "aType");
			pOne1 = ComponentFactory.CreateParameter (typeof(IType), "aType");
			pTwo = ComponentFactory.CreateParameter (typeof(string), "aName");
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
			IParameter clone = (IParameter)pOne.Clone();
			Assert.IsTrue(clone.Equals(pOne1));
		}

		[Test] public void GetHashCodeTest()
		{
			Assert.IsTrue(pOne.GetHashCode() == pOne1.GetHashCode());
			Assert.IsFalse(pTwo.GetHashCode() == pOne.GetHashCode());
		}
	}
}

#endif
