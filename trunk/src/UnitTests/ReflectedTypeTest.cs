#if TEST

using System;
using System.Collections;
using System.Reflection;
using NUnit.Framework;
using Palladio.Utils.Collections;
using Palladio.ComponentModel.Signature;
using Palladio.ComponentModel.Exceptions;


namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// </summary>
	[TestFixture]
	public class ReflectedTypeTest
	{
		ReflectedType tOne, tOne1, tTwo, tThree, tVoid;
		
		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			tOne = new ReflectedType(typeof(ReflectedTypeTest));
			tOne1 = new ReflectedType("Palladio.ComponentModel.UnitTests.ReflectedTypeTest");
			tTwo = new ReflectedType(typeof(ReflectedType));
			tThree = new ReflectedType(typeof(IType));
			tVoid = new ReflectedType(typeof(void));
		}

		/// <summary>
		/// </summary>
		[Test] public void Equals()
		{
			Assert.IsTrue(tOne.Equals(tOne1));
			Assert.IsFalse(tOne.Equals(tTwo));
		}

		/// <summary>
		/// </summary>
		[Test] public void Clone()
		{
			ReflectedType clone = (ReflectedType)tOne.Clone();
			Assert.IsTrue(clone.Equals(tOne1));
		}
		
		/// <summary>
		/// </summary>
		[ExpectedException(typeof(TypeNotFoundException))]
		[Test] public void TypeCannotBeResolved()
		{
			ReflectedType exceptionType = new ReflectedType("void");
		}

		/// <summary>
		/// </summary>
		[Test] public void GetHashCode()
		{
			Assert.IsTrue( tOne.GetHashCode() == tOne1.GetHashCode() );
			Assert.IsTrue( tOne.GetHashCode() != tTwo.GetHashCode() );
		}

		/// <summary>
		/// </summary>
		[Test] public void IsSubtypeOf()
		{
			ReflectedType tObject = new ReflectedType(typeof(object));
			ReflectedType tIParameter = new ReflectedType(typeof(IParameter));
			ReflectedType tIClonable = new ReflectedType(typeof(ICloneable));
			ReflectedType tParameter = new ReflectedType(typeof(Parameter));

			Assert.IsTrue(tParameter.IsSubtypeOf(tObject));
			Assert.IsTrue(tParameter.IsSubtypeOf(tIParameter));
			Assert.IsTrue(tParameter.IsSubtypeOf(tIClonable));
			Assert.IsTrue(tIParameter.IsSubtypeOf(tIClonable));

			Assert.IsFalse(tIParameter.IsSubtypeOf(tIParameter));
			Assert.IsFalse(tParameter.IsSubtypeOf(tParameter));
			Assert.IsFalse(tObject.IsSubtypeOf(tIParameter));
			Assert.IsFalse(tObject.IsSubtypeOf(tParameter));
		}
	}
}
#endif
