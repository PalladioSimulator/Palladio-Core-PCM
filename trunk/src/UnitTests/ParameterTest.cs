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
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2004/05/24 15:20:45  sliver
	/// added cvs log
	///
	/// </pre>
	/// </remarks>
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

		[Test] public void GetHashCode()
		{
			Assert.IsTrue(pOne.GetHashCode() == pOne1.GetHashCode());
			Assert.IsFalse(pTwo.GetHashCode() == pOne.GetHashCode());
		}
	}
}

#endif
