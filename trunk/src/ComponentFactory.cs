using System;
using Palladio.Attributes;
using Palladio.ComponentModel.Signature;
using Palladio.ComponentModel.InterfaceModels;
using Palladio.ComponentModel.Components;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// TODO - Add class summary
	/// </summary>
	/// <remarks>
	/// 	created by - sliver
	/// 	created on - 17.05.2004 20:30:05
	/// </remarks>
	public class ComponentFactory
	{
		public static ISignature CreateSignature( IAttributeHash anAttributeHash, string aRoleID, IType aReturnType, string aName, IParameter[] aParamArray, params IType[] anExceptionArray)
		{
			return new DefaultSignature(anAttributeHash, aRoleID, aReturnType, aName, aParamArray, anExceptionArray);
		}
		
		public static ISignature CreateSignature( string aRoleID, IType aReturnType, string aName, IParameter[] aParamArray, params IType[] anExceptionArray)
		{
			return new DefaultSignature( attributesFactory.Default.CreateAttributeHash(), aRoleID, aReturnType, aName, aParamArray, anExceptionArray);
		}

		public static ISignature CreateSignature( string aRoleID, string aName, params IParameter[] aParamArray )
		{
			return new DefaultSignature(attributesFactory.Default.CreateAttributeHash(), aRoleID, new ReflectedType(typeof(void)), aName, aParamArray, new IType[0]);
		}
		
		public static IParameter CreateParameter(System.Type aType, string aName, ParameterModifierEnum modifier)
		{
			IType anIType = new ReflectedType(aType);
			return new Parameter(anIType,aName,modifier);
		}

		public static IParameter CreateParameter(System.Type aType, string aName)
		{
			return CreateParameter(aType,aName,ParameterModifierEnum.NONE);
		}

		public static IType CreateTypeFromSystemType(System.Type aType)
		{
			return new ReflectedType(aType);
		}

		public static ISignatureList CreateSignatureListInterface(string roleID, params ISignature[] signatures)
		{
			return new SignatureList(roleID,attributesFactory.Default.CreateAttributeHash(),signatures);
		}

		/// <summary>
		/// Create an Interface WITHOUT a RoleID! This is required as service effect specifications have no
		/// Role.
		/// Currently implemented by setting RoleID to an empty string and disabling constraint checking in this case.
		/// TODO: Should probably be implemented with a decorater for the RoleID
		/// </summary>
		/// <param name="signatures"></param>
		/// <returns></returns>
		public static ISignatureList CreateSignatureListServiceEffect(params ISignature[] signatures)
		{
			return new SignatureList("",attributesFactory.Default.CreateAttributeHash(),signatures);
		}

		public static IServiceEffectMapping CreateServiceEffectMapping(ISignature aSignature, ISignatureList aInterfaceSpec)
		{
			return new ServiceEffectMapping(aSignature,aInterfaceSpec);
		}

		public static IServiceEffectMapping CreateServiceEffectMapping(ISignature aSignature)
		{
			return new ServiceEffectMapping(aSignature,CreateSignatureListInterface(""));
		}

		public static IBasicComponent CreateBasicComponent()
		{
			return new BasicComponent(attributesFactory.Default.CreateAttributeHash());
		}

		private static AttributesFactory attributesFactory = new AttributesFactory();
	}
}
