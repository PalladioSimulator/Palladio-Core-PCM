using System;
using Palladio.Attributes;
using Palladio.ComponentModel.Signature;
using Palladio.ComponentModel.InterfaceModels;
using Palladio.ComponentModel.Components;
//using Palladio.ComponentModel.Connections;
using Palladio.FiniteStateMachines;
using Palladio.Identifier;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Factory for creating components and component models.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2004/06/03 14:37:28  sbecker
	/// Added the possibility to attach auxiliary specifications to a basic component
	///
	/// Revision 1.3  2004/06/02 19:41:31  sbecker
	/// Fixed docu
	///
	/// Revision 1.2  2004/06/02 15:41:13  sbecker
	/// Fixed Compiler Warnings
	///
	/// Revision 1.1  2004/06/02 14:50:24  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.7  2004/05/24 21:57:16  sbecker
	/// Added Signature Copy Method with role rewriting
	///
	/// Revision 1.6  2004/05/24 12:42:34  sbecker
	/// Added test cases for creating protocol interfaces
	///
	/// Revision 1.5  2004/05/23 19:00:07  sliver
	/// added comments
	///
	/// Revision 1.4  2004/05/23 16:03:55  sliver
	/// completed unit tests
	///
	/// </pre>
	/// </remarks>
	public class ComponentFactory
	{																							

		#region CreateType

		/// <summary>
		/// Create an IType instance using System.Type of the .Net Reflection API.
		/// </summary>
		/// <param name="aType">Type instance of the .Net Reflection API.</param>
		/// <returns>A Palladio IType instance equivalent to aType.</returns>
		public static IType CreateType(System.Type aType)
		{
			return new ReflectedType(aType);
		}

		/// <summary>
		/// Create an IType instance by using the .Net Reflection API to
		/// resolve aTypeName.
		/// </summary>
		/// <param name="aTypeName">Name of an existing type.</param>
		/// <returns>A Palladio IType instance representing aTypeName.</returns>
		public static IType CreateType(string aTypeName)
		{
			return new ReflectedType(aTypeName);
		}

		/// <summary>
		/// Create an array of IType instances using System.Type of the .Net Reflection API.
		/// </summary>
		/// <param name="aTypeArray">Array of Type instances of the .Net Reflection API.</param>
		/// <returns>An Array of Palladio IType instances equivalent to aTypeArray.</returns>
		public static IType[] CreateTypeArray(params System.Type[] aTypeArray)
		{
			IType[] result = new IType[aTypeArray.Length];
			int index = 0;
			foreach( System.Type t in aTypeArray)
				result[index++] = CreateType(t);
			return result;
		}

		/// <summary>
		/// Create an array of IType instances by using the .Net Reflection API to
		/// resolve each type name of aTypeNameArray.
		/// </summary>
		/// <param name="aTypeNameArray">Array of Names of an existing types.</param>
		/// <returns>An Array of Palladio IType instances representing the types listed in aTypeNameArray.</returns>
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

		/// <summary>
		/// Create a new parameter for a signature. 
		/// </summary>
		/// <param name="aType">Type of the parameter.</param>
		/// <param name="aName">Name of the parameter.</param>
		/// <param name="modifier">Modifier of the parameter.</param>
		/// <returns>A new IParameter instance.</returns>
		public static IParameter CreateParameter(IType aType, string aName, ParameterModifierEnum modifier)
		{
			return new Parameter(aType,aName,modifier);
		}

		/// <summary>
		/// Create a new parameter for a signature. 
		/// </summary>
		/// <param name="aType">Type of the parameter.</param>
		/// <param name="aName">Name of the parameter.</param>
		/// <param name="modifier">Modifier of the parameter.</param>
		/// <returns>A new IParameter instance.</returns>
		public static IParameter CreateParameter(System.Type aType, string aName, ParameterModifierEnum modifier)
		{
			IType itype = CreateType(aType);
			return CreateParameter(itype,aName,modifier);
		}

		/// <summary>
		/// Create a new parameter for a signature. 
		/// </summary>
		/// <param name="aTypeName">Name of the type of the parameter.</param>
		/// <param name="aName">Name of the parameter.</param>
		/// <param name="modifier">Modifier of the parameter.</param>
		/// <returns>A new IParameter instance.</returns>
		public static IParameter CreateParameter(string aTypeName, string aName, ParameterModifierEnum modifier)
		{
			IType itype = CreateType(aTypeName);
			return CreateParameter(itype,aName,modifier);
		}

		/// <summary>
		/// Create a new parameter for a signature. 
		/// </summary>
		/// <param name="aType">Type of the parameter.</param>
		/// <param name="aName">Name of the parameter.</param>
		/// <returns>A new IParameter instance.</returns>
		public static IParameter CreateParameter(IType aType, string aName)
		{
			return CreateParameter(aType,aName,ParameterModifierEnum.NONE);
		}

		/// <summary>
		/// Create a new parameter for a signature. 
		/// </summary>
		/// <param name="aType">Type of the parameter.</param>
		/// <param name="aName">Name of the parameter.</param>
		/// <returns>A new IParameter instance.</returns>
		public static IParameter CreateParameter(System.Type aType, string aName)
		{
			IType itype = CreateType(aType);
			return CreateParameter(itype,aName);
		}

		/// <summary>
		/// Create a new parameter for a signature. 
		/// </summary>
		/// <param name="aTypeName">Name of the type of the parameter.</param>
		/// <param name="aName">Name of the parameter.</param>
		/// <returns>A new IParameter instance.</returns>
		public static IParameter CreateParameter(string aTypeName, string aName)
		{
			IType itype = CreateType(aTypeName);
			return CreateParameter(itype,aName);
		}

		#endregion

		#region CreateSignature

		/// <summary>
		/// Creates a new ISignature. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="anAttributeHash">Attributes of the signature.</param>
		/// <param name="aReturnType">Type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <param name="anExceptionArray">Unorderd Array of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(IAttributeHash anAttributeHash, IType aReturnType, string aName, IParameter[] aParamArray, IType[] anExceptionArray)
		{
			return new DefaultSignature(anAttributeHash, aReturnType, aName, aParamArray, anExceptionArray);
		}

		/// <summary>
		/// Creates a new ISignature. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnType">Type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <param name="anExceptionArray">Unorderd Array of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(IType aReturnType, string aName, IParameter[] aParamArray,params IType[] anExceptionArray)
		{
			IAttributeHash attributeHash = CreateAttributeHash();
			return CreateSignature(attributeHash, aReturnType, aName, aParamArray, anExceptionArray);
		}

		/// <summary>
		/// Creates a new ISignature. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnType">Type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <param name="anExceptionArray">Unorderd Array of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(System.Type aReturnType, string aName, IParameter[] aParamArray,params System.Type[] anExceptionArray)
		{
			IType returnType = CreateType(aReturnType);
			IType[] exceptionArray = CreateTypeArray(anExceptionArray);
			return CreateSignature(returnType, aName, aParamArray, exceptionArray);
		}

		/// <summary>
		/// Creates a new ISignature. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnTypeName">Name of the type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <param name="anExceptionNameArray">Unorderd Array of the names of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(string aReturnTypeName, string aName, IParameter[] aParamArray,params string[] anExceptionNameArray)
		{
			IType returnType = CreateType(aReturnTypeName);
			IType[] exceptionArray = CreateTypeArray(anExceptionNameArray);
			return CreateSignature(returnType, aName, aParamArray, exceptionArray);
		}

		/// <summary>
		/// Creates a new ISignature without exceptions. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnType">Type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(IType aReturnType, string aName, params IParameter[] aParamArray)
		{
			IType[] exceptionArray = new IType[0];
			return CreateSignature(aReturnType, aName, aParamArray, exceptionArray);
		}

		/// <summary>
		/// Creates a new ISignature without exceptions. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnType">Type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(System.Type aReturnType, string aName, params IParameter[] aParamArray)
		{
			IType returnType = CreateType(aReturnType);
			return CreateSignature(returnType, aName, aParamArray);
		}

		/// <summary>
		/// Creates a new ISignature without exceptions. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnTypeName">Name of the type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(string aReturnTypeName, string aName, params IParameter[] aParamArray)
		{
			IType returnType = CreateType(aReturnTypeName);
			return CreateSignature(returnType, aName, aParamArray);
		}

		/// <summary>
		/// Creates a new ISignature without exceptions and the return type 'void'. 
		/// It can only be added to interfaces with the roleID aRoleID.
		/// </summary>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(string aName, params IParameter[] aParamArray)
		{
			IType returnType = CreateType(typeof(void));
			return CreateSignature(returnType, aName, aParamArray);
		}

		/// <summary>
		/// Creates a new ISignature without parameters. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnType">Type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="anExceptionArray">Unorderd Array of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(IType aReturnType, string aName, IType[] anExceptionArray)
		{
			IParameter[] param = new IParameter[0];
			return CreateSignature(aReturnType,aName,param,anExceptionArray);
		}
		
		/// <summary>
		/// Create an container containing a signature and an associated role. Those signatures
		/// have to be used if refering to external services.
		/// </summary>
		/// <param name="aRoleID">The role ID of the external interface</param>
		/// <param name="aSig">The signature of the service in the external interface</param>
		/// <returns>A container object containing a signature and an associated role</returns>
		public static ISignatureWithRole CreateSignatureWithRole(string aRoleID, ISignature aSig )
		{
			return new DefaultSignatureWithRole(aSig,IdentifiableFactory.CreateStringID(aRoleID));
		}

		/// <summary>
		/// Create an container containing a signature and an associated role. Those signatures
		/// have to be used if refering to external services.
		/// </summary>
		/// <param name="aRoleID">The role ID of the external interface</param>
		/// <param name="aSig">The signature of the service in the external interface</param>
		/// <returns>A container object containing a signature and an associated role</returns>
		public static ISignatureWithRole CreateSignatureWithRole(IIdentifier aRoleID, ISignature aSig )
		{
			return new DefaultSignatureWithRole(aSig,aRoleID);
		}

		/// <summary>
		/// Creates a new ISignature without parameters. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnType">Type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="anExceptionArray">Unorderd Array of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(System.Type aReturnType, string aName, params System.Type[] anExceptionArray)
		{
			IType returnType = CreateType(aReturnType);
			IType[] exceptionArray = CreateTypeArray(anExceptionArray);
			return CreateSignature(returnType, aName, exceptionArray);
		}

		/// <summary>
		/// Creates a new ISignature without parameters. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnTypeName">Name of the type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="anExceptionNameArray">Unorderd Array of the names of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(string aReturnTypeName, string aName, params string[] anExceptionNameArray)
		{
			IType returnType = CreateType(aReturnTypeName);
			IType[] exceptionArray = CreateTypeArray(anExceptionNameArray);
			return CreateSignature(returnType, aName, exceptionArray);
		}

		/// <summary>
		/// Creates an array of ISignatures. For each name in aNameArray a new ISignature
		/// without parameters and exceptions is created. The return type of each 
		/// new ISignature is 'void' and its roleID is aRoleID.
		/// </summary>
		/// <param name="aNameArray">Names of the new Signatures.</param>
		/// <returns>An Array of new ISignatures.</returns>
		public static ISignature[] CreateSignatureArray(params string[] aNameArray)
		{
			ISignature[] result = new ISignature[aNameArray.Length];
			int index = 0;
			foreach (string name in aNameArray)
				result[index++] = CreateSignature(name);
			return result;
		}

		/// <summary>
		/// Create an array of signatures all of them having the same role
		/// </summary>
		/// <param name="roleID">The roleID to be assigned to the signatures</param>
		/// <param name="sigs">The signatures to which a role is added</param>
		/// <returns>An array of <see cref="ISignatureWithRole"/></returns>
		public static ISignatureWithRole[] CreateExternalSignatureArray(IIdentifier roleID, params ISignature[] sigs)
		{
			ISignatureWithRole[] result = new ISignatureWithRole[sigs.Length];
			for (int i=0; i < sigs.Length; i++)
			{
				result[i] = CreateSignatureWithRole(roleID,sigs[i]);
			}
			return result;
		}

		/// <summary>
		/// Create an array of signatures all of them having the same role
		/// </summary>
		/// <param name="roleID">The roleID to be assigned to the signatures</param>
		/// <param name="sigs">The signatures to which a role is added</param>
		/// <returns>An array of <see cref="ISignatureWithRole"/></returns>		
		public static ISignatureWithRole[] CreateExternalSignatureArray(string roleID, params ISignature[] sigs)
		{
			return CreateExternalSignatureArray(IdentifiableFactory.CreateStringID(roleID),sigs);
		}
		#endregion

		#region CreateSignatureListXXX

		/// <summary>
		/// Create a new ISignatureList with aSignatureArray
		/// aSignatureArray.
		/// </summary>
		/// <param name="aSignatureArray">Signatures contained by the new interface.</param>
		/// <returns>A new ISignatureList.</returns>
		public static ISignatureList CreateSignatureList(params ISignature[] aSignatureArray)
		{
			return new DefaultSignatureList(CreateAttributeHash(), aSignatureArray);
		}

		/// <summary>
		/// Create a new ISignatureList with the role aRoleID and a new set of signatures
		/// created using the names contained in aSignatureNameArray.
		/// </summary>
		/// <param name="aSignatureNameArray">Names of the Signature of the interface.</param>
		/// <returns>A new ISignature instance.</returns>
		public static ISignatureList CreateSignatureList(params string[] aSignatureNameArray)
		{
			return new DefaultSignatureList(CreateAttributeHash(), CreateSignatureArray(aSignatureNameArray) );
		}

		/// <summary>
		/// Create an Interface WITHOUT a RoleID! This is required as service effect specifications have no
		/// Role.
		/// Currently implemented by setting RoleID to an empty string and disabling constraint checking in this case.
		/// TODO: Should probably be implemented with a decorater for the RoleID
		/// </summary>
		/// <param name="signatures"></param>
		/// <returns></returns>
		public static ISignatureWithRoleList CreateExternalSignatureList(params ISignatureWithRole[] signatures)
		{
			return new DefaultSignatureWithRoleList(CreateAttributeHash(), signatures);
		}

		#endregion

		#region CreateXXXInterfaceModel
		/// <summary>
		/// Construct a new interface model
		/// </summary>
		/// <returns>The newly created interface model</returns>
		public static IInterfaceModel CreateInterfaceModel()
		{
			return new DefaultInterfaceModel(attributesFactory.Default.CreateAttributeHash());
		}

		/// <summary>
		/// Construct a new interface model containing the given signatures
		/// </summary>
		/// <param name="aSigList">The signatures to be added to the interface initialy</param>
		/// <returns>The newly created interface model</returns>
		public static IInterfaceModel CreateInterfaceModel(ISignatureList aSigList)
		{
			return new DefaultInterfaceModel(attributesFactory.Default.CreateAttributeHash(),aSigList);
		}
		
		/// <summary>
		/// Construct an empty service effect specification
		/// </summary>
		/// <returns>A newly created service effect specification</returns>
		public static IServiceEffectSpecification CreateServiceEffectSpecification()
		{
			return new DefaultServiceEffectSpecification(attributesFactory.Default.CreateAttributeHash());
		}

		/// <summary>
		/// Construct an service effect specification containing the given external signatures
		/// </summary>
		/// <param name="aSigList">The external signatures contained in the service effect initialy</param>
		/// <returns>A newly created service effect specification</returns>
		public static IServiceEffectSpecification CreateServiceEffectSpecification(ISignatureWithRoleList aSigList)
		{
			return new DefaultServiceEffectSpecification(attributesFactory.Default.CreateAttributeHash(),aSigList);
		}
		#endregion

		#region CreateRole
		internal static IRole CreateAttachedInterface(IInterfaceModel anInterface, IIdentifier aRole)
		{
			return new DefaultRole(aRole,anInterface);
		}
		#endregion

		#region CreateFSMProtocol
		public static IFSMInterface CreateFSMProtocolInterface()
		{
			return new FSMInterface(CreateAttributeHash(), FSMFactory.CreateEmptyFSM());
		}

		public static IFSMServiceEffect CreateFSMProtocolServiceEffect()
		{
			return new FSMServiceEffect(CreateAttributeHash(), FSMFactory.CreateEmptyFSM());
		}
		#endregion

		#region CreateXXXComponent

		/// <summary>
		/// Create a new, empty IBasicComponent with the attributes specified in anAttrHash.
		/// </summary>
		/// <param name="anAttrHash">AttributeHash associated with the new component.</param>
		/// <param name="ID">ID of the component to create.</param>
		/// <returns>New IBasicComponent instance.</returns>
		public static IBasicComponent CreateBasicComponent(IAttributeHash anAttrHash, string ID)
		{
			return new BasicComponent(anAttrHash,IdentifiableFactory.CreateStringID(ID));
		}

		/// <summary>
		/// Create a new, empty IBasicComponent.
		/// </summary>
		/// <returns>New IBasicComponent instance.</returns>
		public static IBasicComponent CreateBasicComponent(string ID)
		{
			return new BasicComponent(CreateAttributeHash(),IdentifiableFactory.CreateStringID(ID));
		}
		#endregion
#if false
		#region CompositeComponent
		/// <summary>
		/// Create a new, empty IBasicComponent with the attributes given by anAttributeHash.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new Component.</param>
		/// <returns>New IBasicComponent instance.</returns>
		public static ICompositeComponent CreateCompositeComponent(IAttributeHash anAttrHash)
		{
			return new CompositeComponent(anAttrHash);
		}

		/// <summary>
		/// Create a new, empty instance of ICompositeComponent.
		/// </summary>
		/// <returns>A new ICompositeComponent instance.</returns>
		public static ICompositeComponent CreateCompositeComponent()
		{
			return new CompositeComponent(CreateAttributeHash());
		}

		#endregion

		#region CreateConnections

		/// <summary>
		/// Create a new IBinding instance.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new binding.</param>
		/// <param name="provComp">Providing component of the binding relation.</param>
		/// <param name="provRole">Providing role of provComp.</param>
		/// <param name="reqComp">Requiring component of the binding relation.</param>
		/// <param name="reqRole">Requiring role of reqComp.</param>
		/// <returns>New IBinding instance</returns>
		public static IBinding CreateBinding(IAttributeHash anAttrHash, IComponent provComp, string provRole, IComponent reqComp, string reqRole)
		{
			return new Binding(
				anAttrHash,
				new AttachedInterface(provComp, provRole), 
				new AttachedInterface(reqComp, reqRole));
		}

		/// <summary>
		/// Create a new IBinding instance.
		/// </summary>
		/// <param name="provComp">Providing component of the binding relation.</param>
		/// <param name="provRole">Providing role of provComp.</param>
		/// <param name="reqComp">Requiring component of the binding relation.</param>
		/// <param name="reqRole">Requiring role of reqComp.</param>
		/// <returns>New IBinding instance</returns>
		public static IBinding CreateBinding(IComponent provComp, string provRole, IComponent reqComp, string reqRole)
		{
			return CreateBinding(CreateAttributeHash(), provComp, provRole, reqComp, reqRole);
		}

		/// <summary>
		/// Create a new IBinding instance.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new binding.</param>
		/// <param name="provInterface">Providing interface of the binding relation.</param>
		/// <param name="reqInterface">Requiring inteface of the binding relation.</param>
		/// <returns>New IBinding instance</returns>
		public static IBinding CreateBinding(IAttributeHash anAttrHash, AttachedInterface provInterface, AttachedInterface reqInterface)
		{
			return CreateBinding(anAttrHash, provInterface.Component, provInterface.RoleID, reqInterface.Component, reqInterface.RoleID);
		}

		/// <summary>
		/// Create a new IBinding instance.
		/// </summary>
		/// <param name="provInterface">Providing interface of the binding relation.</param>
		/// <param name="reqInterface">Requiring inteface of the binding relation.</param>
		/// <returns>New IBinding instance</returns>
		public static IBinding CreateBinding(AttachedInterface provInterface, AttachedInterface reqInterface)
		{
			return CreateBinding(CreateAttributeHash(), provInterface.Component, provInterface.RoleID, reqInterface.Component, reqInterface.RoleID);
		}

		/// <summary>
		/// Create a new IMapping instance.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new Mapping.</param>
		/// <param name="anOuterRole">RoleID of the outer interface.</param>
		/// <param name="anInnerComponent">The inner component the outer interface is mapped onto.</param>
		/// <param name="anInnerRole">The RoleID of the inner component the outer interface is mapped onto.</param>
		/// <returns>A new IMapping instance.</returns>
		public static IMapping CreateMapping(IAttributeHash anAttrHash, string anOuterRole, IComponent anInnerComponent, string anInnerRole)
		{
			return new Mapping(anAttrHash, new AttachedInterface( anInnerComponent, anInnerRole ), anOuterRole );
		}

		/// <summary>
		/// Create a new IMapping instance.
		/// </summary>
		/// <param name="anOuterRole">RoleID of the outer interface.</param>
		/// <param name="anInnerComponent">The inner component the outer interface is mapped onto.</param>
		/// <param name="anInnerRole">The RoleID of the inner component the outer interface is mapped onto.</param>
		/// <returns>A new IMapping instance.</returns>
		public static IMapping CreateMapping(string anOuterRole, IComponent anInnerComponent, string anInnerRole)
		{
			return CreateMapping(CreateAttributeHash(), anOuterRole, anInnerComponent, anInnerRole);
		}

		/// <summary>
		/// Create a new IMapping instance.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new Mapping.</param>
		/// <param name="anOuterRole">RoleID of the outer interface.</param>
		/// <param name="anInnerInterface">The inner interface anOuterRole is mapped onto.</param>
		/// <returns>A new IMapping instance.</returns>
		public static IMapping CreateMapping(IAttributeHash anAttrHash, string anOuterRole, AttachedInterface anInnerInterface)
		{
			return CreateMapping( anAttrHash, anOuterRole, anInnerInterface.Component, anInnerInterface.RoleID );
		}
		
		/// <summary>
		/// Create a new IMapping instance.
		/// </summary>
		/// <param name="anOuterRole">RoleID of the outer interface.</param>
		/// <param name="anInnerInterface">The inner interface anOuterRole is mapped onto.</param>
		/// <returns>A new IMapping instance.</returns>
		public static IMapping CreateMapping(string anOuterRole, AttachedInterface anInnerInterface)
		{
			return CreateMapping( CreateAttributeHash() , anOuterRole, anInnerInterface.Component, anInnerInterface.RoleID );
		}
		#endregion
#endif

		/// <summary>
		/// Creates a new, empty AttributeHash.
		/// </summary>
		/// <returns>New IAttributeHash instance.</returns>
		public static IAttributeHash CreateAttributeHash()
		{
			return attributesFactory.Default.CreateAttributeHash();
		}
		
		private static AttributesFactory attributesFactory = new AttributesFactory();
	}
}
