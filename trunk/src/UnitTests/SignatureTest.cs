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
	[TestFixture]
	public class SignatureTest
	{
		ISignature sigOne1, sigOne2, sigTwo1, sigTwo2, sigThree1, sigThree2;
		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			sigOne1 = ComponentFactory.CreateSignature(typeof(string), "ToString", 
				new IParameter[] { ComponentFactory.CreateParameter(typeof(string),"tabs") },
				typeof(TypeNotFoundException), typeof(RoleIDMissmatchException));
			sigOne2 = ComponentFactory.CreateSignature(typeof(string), "ToString", 
				new IParameter[] { ComponentFactory.CreateParameter(typeof(string),"tabs") },
				typeof(RoleIDMissmatchException), typeof(TypeNotFoundException));
			sigTwo1 =	ComponentFactory.CreateSignature(typeof(string),"ToString", 
				new IParameter[] { ComponentFactory.CreateParameter(typeof(string),"tabs"),
													 ComponentFactory.CreateParameter(typeof(string),"end") },
				typeof(TypeNotFoundException), typeof(RoleIDMissmatchException)
				);
			sigTwo2 =	ComponentFactory.CreateSignature(typeof(string),"ToString", 
				new IParameter[] { ComponentFactory.CreateParameter(typeof(string),"end"),
													 ComponentFactory.CreateParameter(typeof(string),"tabs") },
				typeof(TypeNotFoundException), typeof(RoleIDMissmatchException)
				);
		}
		
		/// <summary>
		/// </summary>
		[Test] public void Equals()
		{
			Assert.IsTrue(sigOne1.Equals(sigOne2));
			Assert.IsFalse(sigOne1.Equals(sigTwo1));
			Assert.IsFalse(sigTwo1.Equals(sigTwo2));
		}

		/// <summary>
		/// </summary>
		[Test] public void Clone()
		{
			ISignature clone = (ISignature)sigTwo1.Clone();
			Assert.IsTrue(clone.Equals(sigTwo1));
		}

		/// <summary>
		/// </summary>
		[Test] public void GetHashCode()
		{
			Assert.AreEqual(sigOne1.GetHashCode(), sigOne2.GetHashCode());
			Assert.IsFalse(sigTwo1.GetHashCode() == sigOne1.GetHashCode());
		}

		/// <summary>
		/// </summary>
		[Test] public void ContainsAll()
		{
			Assert.AreEqual("System.String", sigTwo1.ReturnType.ID);
			Assert.AreEqual("ToString", sigTwo1.Name);
			Assert.AreEqual(2, sigTwo1.Parameters.Length);
			Assert.AreEqual("tabs", sigTwo1.Parameters[0].Name);
			Assert.AreEqual("end", sigTwo1.Parameters[1].Name);
			Assert.AreEqual(2, sigTwo1.Exceptions.Length);
			Assert.IsTrue( Array.IndexOf( sigTwo1.Exceptions, ComponentFactory.CreateType(typeof(RoleIDMissmatchException) )) >= 0);
			Assert.IsTrue( Array.IndexOf( sigTwo1.Exceptions, ComponentFactory.CreateType(typeof(TypeNotFoundException) )) >= 0);
		}

		/// <summary>
		/// </summary>
		[Test] public void SignatureHashCode()
		{
			ISignature[] sigs1 = GetSignatureList("Role1");
			ISignature[] sigs2 = GetSignatureList("Role1");

			for (int i = 0; i < sigs1.Length; i++)
			{
				Assert.AreEqual(sigs1[i].GetHashCode(),sigs2[i].GetHashCode());
			}
			IType returnType = ComponentFactory.CreateType(typeof(string));
			IType ex1 = ComponentFactory.CreateType(typeof(Exception));
			IType ex2 = ComponentFactory.CreateType(typeof(ApplicationException));
			ISignature s1 = ComponentFactory.CreateSignature(returnType,"Funktion1",GetParameterList(),ex1,ex2);
			ISignature s2 = ComponentFactory.CreateSignature(returnType,"Funktion1",GetParameterList(),ex2,ex1);
			Assert.AreEqual(s1.GetHashCode(),s2.GetHashCode());
		}

		private ISignature[] GetSignatureList(string role)
		{
			ISignature[] sigList = new ISignature[3];
			sigList[0] = ComponentFactory.CreateSignature("Funktion1",GetParameterList());
			sigList[1] = ComponentFactory.CreateSignature("Funktion2");
			sigList[2] = ComponentFactory.CreateSignature(ComponentFactory.CreateType(typeof(string)),"Funktion3",GetParameterList());
			return sigList;
		}

		private IParameter[] GetParameterList()
		{
			IParameter[] list = new IParameter[3];
			list[0] = ComponentFactory.CreateParameter(typeof(string),"A");
			list[1] = ComponentFactory.CreateParameter(typeof(int),"B");
			list[2] = ComponentFactory.CreateParameter(this.GetType(),"C",
				ParameterModifierEnum.OUT);
			return list;
		}
	}
}

#endif