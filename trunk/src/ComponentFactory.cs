using System;
using Palladio.Attributes;
using Palladio.ComponentModel.Signature;
using Palladio.ComponentModel.InterfaceModels;
using Palladio.ComponentModel.Components;
using Palladio.ComponentModel.Connections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// TODO - Add class summary
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2004/05/23 16:03:55  sliver
	/// completed unit tests
	///
	/// </pre>
	/// </remarks>
	public class ComponentFactory
	{																							

		#region CreateType

		public static IType CreateType(System.Type aType)
		{
			return new ReflectedType(aType);
		}

		public static IType CreateType(string aTypeName)
		{
			return new ReflectedType(aTypeName);
		}

		public static IType[] CreateTypeArray(params System.Type[] aTypeArray)
		{
			IType[] result = new IType[aTypeArray.Length];
			int index = 0;
			foreach( System.Type t in aTypeArray)
				result[index++] = CreateType(t);
			return result;
		}

		public static IType[] CreateTypeArray(params string[] aTypeNameArray)
		{
			IType[] result = new IType[aTypeNameArray.Length];
			int index = 0;
			foreach( string s in aTypeNameArray)
				result[index++] = CreateType(s);
			return result;
		}

		#endregion

		#region CreateParameter

		public static IParameter CreateParameter(IType aType, string aName, ParameterModifierEnum modifier)
		{
			return new Parameter(aType,aName,modifier);
		}

		public static IParameter CreateParameter(System.Type aType, string aName, ParameterModifierEnum modifier)
		{
			IType itype = CreateType(aType);
			return CreateParameter(itype,aName,modifier);
		}

		public static IParameter CreateParameter(string aTypeName, string aName, ParameterModifierEnum modifier)
		{
			IType itype = CreateType(aTypeName);
			return CreateParameter(itype,aName,modifier);
		}

		public static IParameter CreateParameter(IType aType, string aName)
		{
			return CreateParameter(aType,aName,ParameterModifierEnum.NONE);
		}

		public static IParameter CreateParameter(System.Type aType, string aName)
		{
			IType itype = CreateType(aType);
			return CreateParameter(itype,aName);
		}

		public static IParameter CreateParameter(string aTypeName, string aName)
		{
			IType itype = CreateType(aTypeName);
			return CreateParameter(itype,aName);
		}

		#endregion

		#region CreateSignature

		public static ISignature CreateSignature(IAttributeHash anAttributeHash, string aRoleID, IType aReturnType, string aName, IParameter[] aParamArray, IType[] anExceptionArray)
		{
			return new DefaultSignature(anAttributeHash, aRoleID, aReturnType, aName, aParamArray, anExceptionArray);
		}

		public static ISignature CreateSignature(string aRoleID, IType aReturnType, string aName, IParameter[] aParamArray,params IType[] anExceptionArray)
		{
			IAttributeHash attributeHash = CreateAttributeHash();
			return CreateSignature(attributeHash, aRoleID, aReturnType, aName, aParamArray, anExceptionArray);
		}

		public static ISignature CreateSignature(string aRoleID, System.Type aReturnType, string aName, IParameter[] aParamArray,params System.Type[] anExceptionArray)
		{
			IType returnType = CreateType(aReturnType);
			IType[] exceptionArray = CreateTypeArray(anExceptionArray);
			return CreateSignature(aRoleID, returnType, aName, aParamArray, exceptionArray);
		}

		public static ISignature CreateSignature(string aRoleID, string aReturnTypeName, string aName, IParameter[] aParamArray,params string[] anExceptionNameArray)
		{
			IType returnType = CreateType(aReturnTypeName);
			IType[] exceptionArray = CreateTypeArray(anExceptionNameArray);
			return CreateSignature(aRoleID, returnType, aName, aParamArray, exceptionArray);
		}

		public static ISignature CreateSignature(string aRoleID, IType aReturnType, string aName, params IParameter[] aParamArray)
		{
			IType[] exceptionArray = new IType[0];
			return CreateSignature(aRoleID, aReturnType, aName, aParamArray, exceptionArray);
		}

		public static ISignature CreateSignature(string aRoleID, System.Type aReturnType, string aName, params IParameter[] aParamArray)
		{
			IType returnType = CreateType(aReturnType);
			return CreateSignature(aRoleID, returnType, aName, aParamArray);
		}

		public static ISignature CreateSignature(string aRoleID, string aReturnTypeName, string aName, params IParameter[] aParamArray)
		{
			IType returnType = CreateType(aReturnTypeName);
			return CreateSignature(aRoleID, returnType, aName, aParamArray);
		}

		public static ISignature CreateSignature(string aRoleID, string aName, params IParameter[] aParamArray)
		{
			IType returnType = CreateType(typeof(void));
			return CreateSignature(aRoleID, returnType, aName, aParamArray);
		}

		public static ISignature CreateSignature(string aRoleID, IType aReturnType, string aName, params IType[] anExceptionArray)
		{
			IParameter[] paramArray = new IParameter[0];
			return CreateSignature(aRoleID, aReturnType, aName, paramArray, anExceptionArray);
		}

		public static ISignature CreateSignature(string aRoleID, System.Type aReturnType, string aName, params System.Type[] anExceptionArray)
		{
			IType returnType = CreateType(aReturnType);
			IType[] exceptionArray = CreateTypeArray(anExceptionArray);
			return CreateSignature(aRoleID, returnType, aName, exceptionArray);
		}

		public static ISignature CreateSignature(string aRoleID, string aReturnTypeName, string aName, params string[] anExceptionNameArray)
		{
			IType returnType = CreateType(aReturnTypeName);
			IType[] exceptionArray = CreateTypeArray(anExceptionNameArray);
			return CreateSignature(aRoleID, returnType, aName, exceptionArray);
		}

		public static ISignature[] CreateSignatureArray(string aRoleID, params string[] aNameArray)
		{
			ISignature[] result = new ISignature[aNameArray.Length];
			int index = 0;
			foreach (string name in aNameArray)
				result[index++] = CreateSignature(aRoleID,name);
			return result;
		}

		#endregion

		#region CreateSignatureListXXX

		public static ISignatureList CreateSignatureListInterface(string roleID, params ISignature[] signatures)
		{
			return new SignatureList(CreateAttributeHash(), roleID, signatures);
		}

		public static ISignatureList CreateSignatureListInterface(string roleID, params string[] signatureNames)
		{
			return new SignatureList(CreateAttributeHash(), roleID, CreateSignatureArray(roleID, signatureNames) );
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
			return new SignatureList(CreateAttributeHash(), "", signatures);
		}

		#endregion

		#region CreateServiceEffectMapping
		
		public static IServiceEffectMapping CreateServiceEffectMapping(ISignature aSignature, ISignatureList aInterfaceSpec)
		{																							 
			return new ServiceEffectMapping(aSignature,aInterfaceSpec);
		}

		public static IServiceEffectMapping CreateServiceEffectMapping(ISignature aSignature)
		{
			return new ServiceEffectMapping(aSignature,CreateSignatureListInterface("", new string[0]));
		}

		#endregion

		#region CreateXXXComponent

		public static IBasicComponent CreateBasicComponent(IAttributeHash anAttrHash)
		{
			return new BasicComponent(anAttrHash);
		}

		public static IBasicComponent CreateBasicComponent()
		{
			return new BasicComponent(CreateAttributeHash());
		}

		public static ICompositeComponent CreateCompositeComponent(IAttributeHash anAttrHash)
		{
			return new CompositeComponent(anAttrHash);
		}

		public static ICompositeComponent CreateCompositeComponent()
		{
			return new CompositeComponent(CreateAttributeHash());
		}

		#endregion

		#region CreateConnections

		public static IBinding CreateBinding(IAttributeHash anAttrHash, IComponent provComp, string provRole, IComponent reqComp, string reqRole)
		{
			return new Binding(
				anAttrHash,
				new AttachedInterface(provRole,provComp), 
				new AttachedInterface(reqRole,reqComp));
		}

		public static IBinding CreateBinding(IComponent provComp, string provRole, IComponent reqComp, string reqRole)
		{
			return CreateBinding(CreateAttributeHash(), provComp, provRole, reqComp, reqRole);
		}

		public static IBinding CreateBinding(IAttributeHash anAttrHash, AttachedInterface provInterface, AttachedInterface reqInterface)
		{
			return CreateBinding(anAttrHash, provInterface.Component, provInterface.RoleID, reqInterface.Component, reqInterface.RoleID);
		}

		public static IBinding CreateBinding(AttachedInterface provInterface, AttachedInterface reqInterface)
		{
			return CreateBinding(CreateAttributeHash(), provInterface.Component, provInterface.RoleID, reqInterface.Component, reqInterface.RoleID);
		}

		public static IMapping CreateMapping(IAttributeHash anAttrHash, string anOuterRole, IComponent anInnerComponent, string anInnerRole)
		{
			return new Mapping(anAttrHash, new AttachedInterface(anInnerRole,anInnerComponent), anOuterRole );
		}

		public static IMapping CreateMapping(string anOuterRole, IComponent anInnerComponent, string anInnerRole)
		{
			return CreateMapping(CreateAttributeHash(), anOuterRole, anInnerComponent, anInnerRole);
		}

		public static IMapping CreateMapping(IAttributeHash anAttrHash, string anOuterRole, AttachedInterface anInnerInterface)
		{
			return CreateMapping( anAttrHash, anOuterRole, anInnerInterface.Component, anInnerInterface.RoleID );
		}
		
		public static IMapping CreateMapping(string anOuterRole, AttachedInterface anInnerInterface)
		{
			return CreateMapping( CreateAttributeHash() , anOuterRole, anInnerInterface.Component, anInnerInterface.RoleID );
		}
		#endregion

		public static IAttributeHash CreateAttributeHash()
		{
			return attributesFactory.Default.CreateAttributeHash();
		}
		
		private static AttributesFactory attributesFactory = new AttributesFactory();
	}
}
