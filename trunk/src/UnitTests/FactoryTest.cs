/*
 * Created by SharpDevelop.
 * User: sliver
 * Date: 17.05.2004
 * Time: 20:39
 * 
 */
#if TEST

using System;
using NUnit.Framework;
using Palladio.ComponentModel.Exceptions;

namespace Palladio.ComponentModel.Tests
{
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
			Assert.IsTrue(param[2].Type.ID == "Palladio.ComponentModel.Tests.FactoryTest");
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
		
		[ExpectedException(typeof(SignatureHasNoServEffSpec))]
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
			basicComponent.AddProvidesInterface(sigList,GetServiceEffect());
		}

		[Test] public void SignatureHashCode()
		{
			ISignature[] sigs1 = GetSignatureList("Role1");
			ISignature[] sigs2 = GetSignatureList("Role1");

			for (int i = 0; i < sigs1.Length; i++)
			{
				Assert.AreEqual(sigs1[i].GetHashCode(),sigs2[i].GetHashCode());
			}
		}

		[TestFixtureSetUp]
		public void Init()
		{
			// TODO: Add Init code.
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
			sigList[2] = ComponentFactory.CreateSignature(role,ComponentFactory.CreateTypeFromSystemType(typeof(string)),"Funktion3",GetParameterList());
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
	}
}
#endif
