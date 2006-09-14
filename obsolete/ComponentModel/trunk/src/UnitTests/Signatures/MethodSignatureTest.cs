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
		MethodSignature sigOne, sigOne1, sigOne2, sigOne3, sigTwo;
		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			sigOne = Helper.CreateSignature(typeof(string),"ToString");
			sigOne1 = Helper.CreateSignature(typeof(string),"ToString");
			sigOne2 =	Helper.CreateSignature(typeof(string),"ToString", 
				Helper.CreateParameter(typeof(string),"tabs")
				);
			sigOne3 =	Helper.CreateSignature(typeof(string),"ToString", 
				Helper.CreateParameter(typeof(int),"lenth")
				);
			sigTwo =	Helper.CreateSignature(typeof(object),"Clone");
		}
		
		/// <summary>
		/// </summary>
		[Test] public void Equals()
		{
			Assert.IsTrue(sigOne.Equals(sigOne1));
			Assert.IsFalse(sigOne.Equals(sigTwo));
			Assert.IsFalse(sigOne.Equals(sigOne2));
			Assert.IsFalse(sigOne2.Equals(sigOne3));
		}

		/// <summary>
		/// </summary>
		[Test] public void Clone()
		{
			MethodSignature clone = (MethodSignature)sigOne2.Clone();
			Assert.IsTrue(clone.Equals(sigOne2));
			clone.Name = "dummy";
			Assert.IsFalse(clone.Equals(sigOne2));
			clone = (MethodSignature)sigOne2.Clone();
			clone.ReturnType = new ReflectedType(typeof(void));
			Assert.IsFalse(clone.Equals(sigOne2));
			clone = (MethodSignature)sigOne2.Clone();
			clone.Parameters = new IParameter[0];
			Assert.IsFalse(clone.Equals(sigOne2));
		}
	}
}
