#if TEST

using System;
using NUnit.Framework;
using Palladio.ComponentModel.Exceptions;
using System.Collections;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 13:47:43  joemal
	/// initial import
	///
	/// Revision 1.3  2004/07/05 09:30:12  sbecker
	/// Changes due to the refactorings after the first review
	///
	/// Revision 1.2  2004/06/09 12:36:31  sbecker
	/// Fixed documentation and renamed IExternalSignature
	///
	/// Revision 1.1  2004/06/02 14:50:26  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.4  2004/05/23 16:03:56  sliver
	/// completed unit tests
	///
	/// </pre>
	/// </remarks>
	/// <exclude />
	[TestFixture]
	public class FactoryTest
	{

		[Test] public void CreateParameter()
		{
			IParameter[] param = GetParameterList();
			Assert.IsTrue(param[0].Name == "A");
			Assert.IsTrue(param[1].Name == "B");
			Assert.IsTrue(param[2].Name == "C");
			Assert.IsTrue(param[0].Type.ID == "System.String");
			Assert.IsTrue(param[1].Type.ID == "System.Int32");
			Assert.IsTrue(param[2].Type.ID == "Palladio.ComponentModel.UnitTests.FactoryTest");
			Assert.IsTrue(param[0].Modifier == ParameterModifierEnum.NONE);
			Assert.IsTrue(param[1].Modifier == ParameterModifierEnum.NONE);
			Assert.IsTrue(param[2].Modifier == ParameterModifierEnum.OUT);
		}
		
		[Test] public void CreateSignature()
		{
			ISignature[] sigs = GetSignatureList();
			Assert.IsTrue(sigs[0].ReturnType.ID == "System.Void");
			Assert.IsTrue(sigs[0].Name == "Funktion1");
			Assert.IsTrue(sigs[0].Parameters.Length == 3);
			Assert.IsTrue(sigs[0].Exceptions.Length == 0);
			Assert.IsTrue(sigs[1].ReturnType.ID == "System.Void");
			Assert.IsTrue(sigs[1].Name == "Funktion2");
			Assert.IsTrue(sigs[1].Parameters.Length == 0);
			Assert.IsTrue(sigs[1].Exceptions.Length == 0);
			Assert.IsTrue(sigs[2].ReturnType.ID == "System.String");
			Assert.IsTrue(sigs[2].Name == "Funktion3");
			Assert.IsTrue(sigs[2].Parameters.Length == 3);
			Assert.IsTrue(sigs[2].Exceptions.Length == 0);
			Console.WriteLine(sigs[0]+Environment.NewLine+sigs[1]+Environment.NewLine+sigs[2]);
		}
	
		[Test] public void CreateSignatureList()
		{
			ISignature[] sigs = GetSignatureList();
			ISignatureList sigList = ComponentFactory.CreateSignatureList(sigs);
			for (int i = 0; i < sigs.Length; i++)
			{
				Assert.IsTrue(sigList[i].Equals(sigs[i]));
			}
			Assert.IsFalse(sigList[0].Equals(sigs[1]));
		}

		[Test] public void SignatureHashCode()
		{
			ISignature[] sigs1 = GetSignatureList();
			ISignature[] sigs2 = GetSignatureList();

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

		[Test] public void SignatureEquals()
		{
			ISignature[] sigs1 = GetSignatureList();
			ISignature[] sigs2 = GetSignatureList();

			for (int i = 0; i < sigs1.Length; i++)
			{
				Assert.AreEqual(sigs1[i],sigs2[i]);
			}
			IType returnType = ComponentFactory.CreateType(typeof(string));
			IType ex1 = ComponentFactory.CreateType(typeof(Exception));
			IType ex2 = ComponentFactory.CreateType(typeof(ApplicationException));
			ISignature s1 = ComponentFactory.CreateSignature(returnType,"Funktion1",GetParameterList(),ex1,ex2);
			ISignature s2 = ComponentFactory.CreateSignature(returnType,"Funktion1",GetParameterList(),ex2,ex1);
			Assert.AreEqual(s1,s2);

			IParameter[] parameters = GetParameterList();
			s1 = ComponentFactory.CreateSignature("F1",parameters[0],parameters[1]);
			s2 = ComponentFactory.CreateSignature("F1",parameters[1],parameters[0]);
			Assert.IsFalse(s1.Equals(s2));
		}

		[TestFixtureSetUp]
		public void Init()
		{
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

		private ISignature[] GetSignatureList()
		{
			ISignature[] sigList = new ISignature[3];
			sigList[0] = ComponentFactory.CreateSignature("Funktion1",GetParameterList());
			sigList[1] = ComponentFactory.CreateSignature("Funktion2");
			sigList[2] = ComponentFactory.CreateSignature(ComponentFactory.CreateType(typeof(string)),"Funktion3",GetParameterList());
			return sigList;
		}
	}
}
#endif
