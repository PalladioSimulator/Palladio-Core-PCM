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
	/// Revision 1.1  2004/06/02 14:50:26  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.4  2004/05/23 16:03:56  sliver
	/// completed unit tests
	///
	/// </pre>
	/// </remarks>
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
			ISignature[] sigs = GetSignatureList("Role1");
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
			ISignature[] sigs = GetSignatureList("Role1");
			ISignatureList sigList = ComponentFactory.CreateSignatureListInterface("Role1",sigs);
			Assert.IsTrue(sigList.RoleID == "Role1");
			for (int i = 0; i < sigs.Length; i++)
			{
				Assert.IsTrue(sigList.Signatures[i].Equals(sigs[i]));
			}
			Assert.IsFalse(sigList[0].Equals(sigs[1]));
		}

		[ExpectedException(typeof(RoleIDMissmatchException))]
		[Test] public void CreateInvalidRoleInSignatureList()
		{
			ISignature[] sigs = GetSignatureList("Role2");
			ISignatureList sigList = ComponentFactory.CreateSignatureListInterface("Role1",sigs);
		}

		[Test] public void CreateServiceEffect()
		{
			IServiceEffectMapping[] seMapping = GetServiceEffect();
		}
		
		[ExpectedException(typeof(SignatureHasNoServEffSpecException))]
		[Test] public void CreateBasicComponentWithoutServiceEffect()
		{
			ISignature[] sigs = GetSignatureList("Role1");
			ISignatureList sigList = ComponentFactory.CreateSignatureListInterface("Role1",sigs);
			IBasicComponent basicComponent = ComponentFactory.CreateBasicComponent();
			basicComponent.AddProvidesInterface(sigList);
		}

		[Test] public void CreateBasicComponent()
		{
			ISignature[] sigs = GetSignatureList("Role1");
			ISignatureList sigList = ComponentFactory.CreateSignatureListInterface("Role1",sigs);
			IBasicComponent basicComponent = ComponentFactory.CreateBasicComponent();
			IServiceEffectMapping[] srvEffect = GetServiceEffect();
			basicComponent.AddRequiresInterfaces(GetSaverInterface(), GetLoaderInterface());
			basicComponent.AddProvidesInterface(sigList,srvEffect);

			Assert.IsTrue( sigList.Equals( basicComponent.GetProvidesInterface("Role1") ) );
		}

		[ExpectedException(typeof(RoleIDNotFoundException))]
		[Test] public void UnknownRoleId()
		{
			IBasicComponent cmp = CreateComponent();
			cmp.GetProvidesInterface("not here");
		}

		[Test] public void AccessServiceEffect()
		{
			IBasicComponent cmp = CreateComponent();
			ISignatureList sigList = cmp.GetProvidesInterface("Role1");
			ISignatureList se = cmp.GetServiceEffectSpecification( sigList[1] );
			Console.WriteLine(se.RoleID);
			foreach (ISignature s in se.Signatures)
			{
				Console.WriteLine(s.RoleID + "  " + s);
			}
		}

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
			ISignature s1 = ComponentFactory.CreateSignature("R",returnType,"Funktion1",GetParameterList(),ex1,ex2);
			ISignature s2 = ComponentFactory.CreateSignature("R",returnType,"Funktion1",GetParameterList(),ex2,ex1);
			Assert.AreEqual(s1.GetHashCode(),s2.GetHashCode());
		}

		[Test] public void SignatureEquals()
		{
			ISignature[] sigs1 = GetSignatureList("Role1");
			ISignature[] sigs2 = GetSignatureList("Role1");

			for (int i = 0; i < sigs1.Length; i++)
			{
				Assert.AreEqual(sigs1[i],sigs2[i]);
			}
			IType returnType = ComponentFactory.CreateType(typeof(string));
			IType ex1 = ComponentFactory.CreateType(typeof(Exception));
			IType ex2 = ComponentFactory.CreateType(typeof(ApplicationException));
			ISignature s1 = ComponentFactory.CreateSignature("R",returnType,"Funktion1",GetParameterList(),ex1,ex2);
			ISignature s2 = ComponentFactory.CreateSignature("R",returnType,"Funktion1",GetParameterList(),ex2,ex1);
			Assert.AreEqual(s1,s2);

			IParameter[] parameters = GetParameterList();
			s1 = ComponentFactory.CreateSignature("R","F1",parameters[0],parameters[1]);
			s2 = ComponentFactory.CreateSignature("R","F1",parameters[1],parameters[0]);
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

		private ISignature[] GetSignatureList(string role)
		{
			ISignature[] sigList = new ISignature[3];
			sigList[0] = ComponentFactory.CreateSignature(role,"Funktion1",GetParameterList());
			sigList[1] = ComponentFactory.CreateSignature(role,"Funktion2");
			sigList[2] = ComponentFactory.CreateSignature(role,ComponentFactory.CreateType(typeof(string)),"Funktion3",GetParameterList());
			return sigList;
		}

		private IServiceEffectMapping[] GetServiceEffect()
		{
			IServiceEffectMapping[] seMappings = new IServiceEffectMapping[3];
			ISignature[] sigs = GetSignatureList("Role1");
			ISignature ext1 = ComponentFactory.CreateSignature("Loader","Load");
			ISignature ext2 = ComponentFactory.CreateSignature("Saver","Save");
			ISignatureList loaderInterface = ComponentFactory.CreateSignatureListServiceEffect(ext1);
			ISignatureList saverInterface = ComponentFactory.CreateSignatureListServiceEffect(ext1,ext2);
			seMappings[0] = ComponentFactory.CreateServiceEffectMapping(sigs[0]);
			seMappings[1] = ComponentFactory.CreateServiceEffectMapping(sigs[1],loaderInterface);
			seMappings[2] = ComponentFactory.CreateServiceEffectMapping(sigs[2],saverInterface);
			return seMappings;
		}

		private IBasicComponent CreateComponent()
		{
			ISignature[] sigs = GetSignatureList("Role1");
			ISignatureList sigList = ComponentFactory.CreateSignatureListInterface("Role1",sigs);
			IBasicComponent basicComponent = ComponentFactory.CreateBasicComponent();
			basicComponent.AddRequiresInterfaces(GetSaverInterface(), GetLoaderInterface());
			basicComponent.AddProvidesInterface(sigList,GetServiceEffect());
			return basicComponent;
		}

		private ISignature[] CreateSignatures(string aRoleID, params string[] strList)
		{
			ISignature[] result = new ISignature[strList.Length];
			int index = 0;
			foreach (string str in strList)
			{
				result[index++] = ComponentFactory.CreateSignature(aRoleID,str);
			}
			return result;
		}

		private ISignatureList CreateSigList(string aRoleID, params string[] strList)
		{
			return ComponentFactory.CreateSignatureListInterface(aRoleID, CreateSignatures(aRoleID, strList) );
		}

		private ISignatureList GetLoaderInterface()
		{
			return ComponentFactory.CreateSignatureListInterface("Loader","Load");
		}

		private ISignatureList GetSaverInterface()
		{
			return ComponentFactory.CreateSignatureListInterface("Saver","Save");
		}
	}
}
#endif
