using System;
using Palladio.Attributes;
using Palladio.ComponentModel.Signature;
using Palladio.ComponentModel.InterfaceModels;
using Palladio.ComponentModel.Components;
using Palladio.ComponentModel.Connections;
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
	/// Revision 1.9.2.1  2004/11/16 13:37:46  uffi
	/// Initial commit of the 2.0 version of the component model. BETA!!! See the techreport (to be updated) for details.
	/// Documentation needs fixing. Some unittests fail.
	///
	/// Revision 1.9  2004/09/02 12:50:05  uffi
	/// Added XML Serialization and Deserialization functionality
	///
	/// Revision 1.8  2004/07/13 07:48:21  sbecker
	/// Made AttributesFactory static
	///
	/// Revision 1.7  2004/07/05 09:21:44  sbecker
	/// Added further creation methods for programmers convinience
	/// Removed an unnessesary method
	///
	/// Revision 1.6  2004/06/09 12:36:30  sbecker
	/// Fixed documentation and renamed IExternalSignature
	///
	/// Revision 1.5  2004/06/04 01:53:56  sliver
	/// rework of composite component
	///
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
		/// Creates a new ISignature with System.Void as return type.
		/// </summary>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <param name="anExceptionNameArray">Unorderd Array of the names of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(string aName, IParameter[] aParamArray,params string[] anExceptionNameArray)
		{
			IType[] exceptionArray = CreateTypeArray(anExceptionNameArray);
			return CreateSignature(aName, aParamArray, exceptionArray);
		}

		/// <summary>
		/// Creates a new ISignature with System.Void as return type, empty parameter and empty
		/// exception list
		/// </summary>
		/// <param name="aName">Name of the Signature.</param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(string aName)
		{
			return CreateSignature(aName, new IParameter[0], new IType[0]);
		}

		/// <summary>
		/// Creates a new ISignature with System.Void as return type.
		/// </summary>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <param name="exceptionArray">Unorderd Array of the names of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(string aName, IParameter[] aParamArray,params IType[] exceptionArray)
		{
			IType returnType = CreateType("System.Void");
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
		public static IService CreateService(IInterfaceModel iface, IIdentifier signatureID )
		{
			if (!iface.SignatureList.ContainsSignatureID(signatureID))
				throw new Exceptions.SignatureNotFoundException(signatureID);
			return new DefaultService(signatureID, iface);
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
		/// <returns>An array of <see cref="IExternalSignature"/></returns>
		public static IService[] CreateServiceArray(IInterfaceModel iface, params IIdentifier[] sigIDs)
		{
			IService[] result = new IService[sigIDs.Length];
			for (int i=0; i < sigIDs.Length; i++)
			{
				result[i] = CreateService(iface,sigIDs[i]);
			}
			return result;
		}

		/// <summary>
		/// Create an array of signatures all of them having the same role
		/// </summary>
		/// <param name="roleID">The roleID to be assigned to the signatures</param>
		/// <param name="sigs">The signatures to which a role is added</param>
		/// <returns>An array of <see cref="IExternalSignature"/></returns>		
		public static IService[] CreateServiceArray(IRole role, params IIdentifier[] sigIDs)
		{
			return CreateServiceArray(role.Interface,sigIDs);
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
		public static IServiceList CreateServiceList(params IService[] signatures)
		{
			return new DefaultServiceList(CreateAttributeHash(), signatures);
		}

		#endregion

		#region CreateXXXInterfaceModel
		/// <summary>
		/// Construct a new interface model
		/// </summary>
		/// <returns>The newly created interface model</returns>
		public static IInterfaceModel CreateInterfaceModel(ISignatureList aSigList, string name)
		{
			IInterfaceModel model = new DefaultInterfaceModel(AttributesFactory.Default.CreateAttributeHash(),aSigList, name, IdentifiableFactory.CreateGUID() as GloballyUniqueIdentifier);
			ModelPersistencyService.Instance.RegisterEntity(model, ModelPersistencyInfo.ATTACHED);
			return model;
		}
		
		/// <summary>
		/// Construct a new interface model
		/// </summary>
		/// <returns>The newly created interface model</returns>
		public static IInterfaceModel CreateInterfaceModel(string name, GloballyUniqueIdentifier ID, ModelPersistencyInfo info)
		{
			IInterfaceModel model = new DefaultInterfaceModel(AttributesFactory.Default.CreateAttributeHash(), name, ID);
			ModelPersistencyService.Instance.RegisterEntity(model, info);
			return model;
		}

		/// <summary>
		/// Construct a new interface model containing the given signatures
		/// </summary>
		/// <param name="aSigList">The signatures to be added to the interface initialy</param>
		/// <returns>The newly created interface model</returns>
		public static IInterfaceModel CreateInterfaceModel(ISignatureList aSigList, string name, GloballyUniqueIdentifier ID, ModelPersistencyInfo info)
		{
			IInterfaceModel model = new DefaultInterfaceModel(AttributesFactory.Default.CreateAttributeHash(),aSigList, name, ID);
			ModelPersistencyService.Instance.RegisterEntity(model, info);
			return model;
		}

		public static IInterfaceModel CreateInterfaceModel(string name)
		{
			IInterfaceModel model = new DefaultInterfaceModel(AttributesFactory.Default.CreateAttributeHash(), name, IdentifiableFactory.CreateGUID() as GloballyUniqueIdentifier);
			ModelPersistencyService.Instance.RegisterEntity(model, ModelPersistencyInfo.ATTACHED);
			return model;
		}
		
		/// <summary>
		/// Construct an empty service effect specification
		/// </summary>
		/// <returns>A newly created service effect specification</returns>
		public static IServiceEffectSpecification CreateServiceEffectSpecification()
		{
			return new DefaultServiceEffectSpecification(AttributesFactory.Default.CreateAttributeHash());
		}

		/// <summary>
		/// Construct an service effect specification containing the given external signatures
		/// </summary>
		/// <param name="aSigList">The external signatures contained in the service effect initialy</param>
		/// <returns>A newly created service effect specification</returns>
		public static IServiceEffectSpecification CreateServiceEffectSpecification(IServiceList aSigList)
		{
			return new DefaultServiceEffectSpecification(AttributesFactory.Default.CreateAttributeHash(),aSigList);
		}
		#endregion

		#region CreateRole
		internal static IRole CreateRole(IInterfaceModel anInterface, IComponent aComponent)
		{
			return new DefaultRole(aComponent,anInterface);
		}
		#endregion

		#region CreateFSMProtocol
		/// <summary>
		/// Create a FSM containing ISignatures as input symbols to specify
		/// the allowed order of service calls.
		/// </summary>
		/// <returns>A newly created FSM interface protocol automaton</returns>
		public static IFSMInterface CreateFSMProtocolInterface()
		{
			return new FSMInterface(CreateAttributeHash(), FSMFactory.CreateEmptyFSM());
		}

		/// <summary>
		/// Create a FSM containing IExternalSignatures as input symbols to specify
		/// the allowed order of service calls.
		/// </summary>
		/// <returns>A newly created FSM servive effect specification protocol automaton</returns>
		public static IFSMServiceEffect CreateFSMProtocolServiceEffect()
		{
			return new FSMServiceEffect(CreateAttributeHash(), FSMFactory.CreateEmptyFSM());
		}
		#endregion

		#region CreateBasicComponent

		/// <summary>
		/// Create a new, empty IBasicComponent with the attributes specified in anAttrHash.
		/// </summary>
		/// <param name="anAttrHash">AttributeHash associated with the new component.</param>
		/// <param name="name">Name of the component to create.</param>
		/// <returns>New IBasicComponent instance.</returns>
		public static IBasicComponent CreateBasicComponent(IAttributeHash anAttrHash, string name)
		{
			IBasicComponent comp = new BasicComponent(anAttrHash, name, IdentifiableFactory.CreateGUID() as GloballyUniqueIdentifier);
			ModelPersistencyService.Instance.RegisterEntity(comp, ModelPersistencyInfo.ATTACHED);
			return comp;
		}

		/// <summary>
		/// Create a new, empty IBasicComponent.
		/// </summary>
		/// <returns>New IBasicComponent instance.</returns>
		public static IBasicComponent CreateBasicComponent(string name)
		{
			IBasicComponent comp = new BasicComponent(CreateAttributeHash(), name, IdentifiableFactory.CreateGUID() as GloballyUniqueIdentifier);
			ModelPersistencyService.Instance.RegisterEntity(comp, ModelPersistencyInfo.ATTACHED);
			return comp;
		}

		/// <summary>
		/// Create a new, empty IBasicComponent with the attributes specified in anAttrHash.
		/// </summary>
		/// <param name="anAttrHash">AttributeHash associated with the new component.</param>
		/// <param name="name">Name of the component to create.</param>
		/// <param name="ID">ID of the component to create.</param>
		/// <returns>New IBasicComponent instance.</returns>
		public static IBasicComponent CreateBasicComponent(IAttributeHash anAttrHash, string name, GloballyUniqueIdentifier ID, ModelPersistencyInfo info)
		{
			IBasicComponent comp = new BasicComponent(anAttrHash,name,ID);
			ModelPersistencyService.Instance.RegisterEntity(comp, info);
			return comp;
		}

		/// <summary>
		/// Create a new, empty IBasicComponent.
		/// </summary>
		/// <returns>New IBasicComponent instance.</returns>
		public static IBasicComponent CreateBasicComponent(string name, GloballyUniqueIdentifier ID, ModelPersistencyInfo info)
		{
			IBasicComponent comp = new BasicComponent(CreateAttributeHash(), name, ID);
			ModelPersistencyService.Instance.RegisterEntity(comp, info);
			return comp;
		}
		#endregion

		#region CompositeComponent
		/// <summary>
		/// Create a new, empty IBasicComponent with the attributes given by anAttributeHash.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new Component.</param>
		/// <param name="name">A name for the component</param>
		/// <returns>New IBasicComponent instance.</returns>
		public static ICompositeComponent CreateCompositeComponent(IAttributeHash anAttrHash, string name)
		{
			ICompositeComponent comp = new CompositeComponent(anAttrHash, name, IdentifiableFactory.CreateGUID() as GloballyUniqueIdentifier);
			ModelPersistencyService.Instance.RegisterEntity(comp, ModelPersistencyInfo.ATTACHED);
			return comp;
		}

		/// <summary>
		/// Create a new, empty instance of ICompositeComponent.
		/// </summary>
		/// <returns>A new ICompositeComponent instance.</returns>
		public static ICompositeComponent CreateCompositeComponent(string name)
		{
			ICompositeComponent comp = new CompositeComponent(CreateAttributeHash(), name, IdentifiableFactory.CreateGUID() as GloballyUniqueIdentifier);
			ModelPersistencyService.Instance.RegisterEntity(comp, ModelPersistencyInfo.ATTACHED);
			return comp;
		}

		/// <summary>
		/// Create a new, empty IBasicComponent with the attributes given by anAttributeHash.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new Component.</param>
		/// <param name="ID">An string identifier for the component</param>
		/// <returns>New IBasicComponent instance.</returns>
		public static ICompositeComponent CreateCompositeComponent(IAttributeHash anAttrHash, string name, GloballyUniqueIdentifier ID, ModelPersistencyInfo info)
		{
			ICompositeComponent comp = new CompositeComponent(anAttrHash, name, ID);
			ModelPersistencyService.Instance.RegisterEntity(comp, info);
			return comp;
		}

		/// <summary>
		/// Create a new, empty instance of ICompositeComponent.
		/// </summary>
		/// <returns>A new ICompositeComponent instance.</returns>
		public static ICompositeComponent CreateCompositeComponent(string name, GloballyUniqueIdentifier ID, ModelPersistencyInfo info)
		{
			ICompositeComponent comp = new CompositeComponent(CreateAttributeHash(), name, ID);
			ModelPersistencyService.Instance.RegisterEntity(comp, info);
			return comp;
		}

		#endregion

		#region CreateConnections

		#if true

		/// <summary>
		/// Create a new IBinding instance.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new binding.</param>
		/// <param name="provComponent">Providing component of the binding relation.</param>
		/// <param name="provRoleID">Providing role of provComp.</param>
		/// <param name="reqComponent">Requiring component of the binding relation.</param>
		/// <param name="reqRoleID">Requiring role of reqComp.</param>
		/// <returns>New IBinding instance</returns>
		public static IBinding CreateBinding(IAttributeHash anAttrHash, IComponent reqComponent,
			IIdentifier reqRoleID, IComponent provComponent, IIdentifier provRoleID)
		{
			return new DefaultBinding(
				anAttrHash,
				reqComponent.GetRole(reqRoleID),
				provComponent.GetRole(provRoleID));
		}

		/// <summary>
		/// Create a new IBinding instance.
		/// </summary>
		/// <param name="provComponent">Providing component of the binding relation.</param>
		/// <param name="provRoleID">Providing role of provComp.</param>
		/// <param name="reqRoleID">Requiring role of reqComp.</param>
		/// <param name="reqComponent">Requiring component of the binding relation.</param>
		/// <returns>New IBinding instance</returns>
		public static IBinding CreateBinding(IComponent reqComponent, IIdentifier reqRoleID,
			IComponent provComponent, IIdentifier provRoleID)
		{
			return new DefaultBinding(
				CreateAttributeHash(),
				reqComponent.GetRole(reqRoleID),
				provComponent.GetRole(provRoleID));
		}

		/// <summary>
		/// Create a new IBinding instance.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new binding.</param>
		/// <param name="provRole">Providing role of the binding relation.</param>
		/// <param name="reqRole">Requiring role of the binding relation.</param>
		/// <returns>New IBinding instance</returns>
		public static IBinding CreateBinding(IAttributeHash anAttrHash, IRole reqRole, IRole provRole)
		{
			return new DefaultBinding( anAttrHash, reqRole, provRole);
		}
#endif 

#if true
		/// <summary>
		/// Create a new IMapping instance.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new Mapping.</param>
		/// <param name="anOuterRoleID">RoleID of the outer interface.</param>
		/// <param name="anOuterComponent">The outer component the inner component maps to.</param>
		/// <param name="anInnerComponent">The inner component the outer interface is mapped onto.</param>
		/// <param name="anInnerRoleID">The RoleID of the inner component the outer interface is mapped onto.</param>
		/// <returns>A new IMapping instance.</returns>
		public static IMapping CreateProvidesMapping(IAttributeHash anAttrHash, IComponent anOuterComponent, 
			IIdentifier anOuterRoleID, IComponent anInnerComponent, IIdentifier anInnerRoleID)
		{
			return new DefaultMapping(anAttrHash, anOuterComponent.GetRole(anOuterRoleID), anInnerComponent.GetRole(anInnerRoleID), MappingTypeEnum.PROVIDES_MAPPING);
		}

		/// <summary>
		/// Create a new IMapping instance.
		/// </summary>
		/// <param name="anOuterRoleID">RoleID of the outer interface.</param>
		/// <param name="anInnerComponent">The inner component the outer interface is mapped onto.</param>
		/// <param name="anInnerRoleID">The RoleID of the inner component the outer interface is mapped onto.</param>
		/// <param name="anOuterComponent">The outer component to which the inner component is mapped to</param>
		/// <returns>A new IMapping instance.</returns>
		public static IMapping CreateProvidesMapping(IComponent anOuterComponent, IIdentifier anOuterRoleID, 
			IComponent anInnerComponent, IIdentifier anInnerRoleID)
		{
			return CreateProvidesMapping(CreateAttributeHash(), anOuterComponent, anOuterRoleID, anInnerComponent, anInnerRoleID);
		}

		/// <summary>
		/// Create a new IMapping instance.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new Mapping.</param>
		/// <param name="anOuterRole">RoleID of the outer interface.</param>
		/// <param name="anInnerRole">The inner role anOuterRole is mapped onto.</param>
		/// <returns>A new IMapping instance.</returns>
		public static IMapping CreateProvidesMapping(IAttributeHash anAttrHash, IRole anOuterRole, IRole anInnerRole)
		{
			return new DefaultMapping(anAttrHash, anOuterRole, anInnerRole, MappingTypeEnum.PROVIDES_MAPPING);
		}
		
		/// <summary>
		/// Create a new IMapping instance.
		/// </summary>
		/// <param name="anOuterRole">RoleID of the outer interface.</param>
		/// <param name="anInnerRole">The inner role anOuterRole is mapped onto.</param>
		/// <returns>A new IMapping instance.</returns>
		public static IMapping CreateProvidesMapping(IRole anOuterRole, IRole anInnerRole)
		{
			return new DefaultMapping(CreateAttributeHash(), anOuterRole, anInnerRole, MappingTypeEnum.PROVIDES_MAPPING);
		}
		
		/// <summary>
		/// Create a new IMapping instance.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new Mapping.</param>
		/// <param name="anOuterRoleID">RoleID of the outer interface.</param>
		/// <param name="anInnerComponent">The inner component the outer interface is mapped onto.</param>
		/// <param name="anOuterComponent">The outer component to which the inner compoent is mapped to.</param>
		/// <param name="anInnerRoleID">The RoleID of the inner component the outer interface is mapped onto.</param>
		/// <returns>A new IMapping instance.</returns>
		public static IMapping CreateRequiresMapping(IAttributeHash anAttrHash, IComponent anInnerComponent, 
			IIdentifier anInnerRoleID, IComponent anOuterComponent, IIdentifier anOuterRoleID)
		{
			return new DefaultMapping(anAttrHash, anInnerComponent.GetRole(anInnerRoleID), anOuterComponent.GetRole(anOuterRoleID), MappingTypeEnum.REQUIRES_MAPPING);
		}

		/// <summary>
		/// Create a new IMapping instance.
		/// </summary>
		/// <param name="anOuterRoleID">RoleID of the outer interface.</param>
		/// <param name="anInnerComponent">The inner component the outer interface is mapped onto.</param>
		/// <param name="anOuterComponent">The outer component to which the inner compoent is mapped to.</param>
		/// <param name="anInnerRoleID">The RoleID of the inner component the outer interface is mapped onto.</param>
		/// <returns>A new IMapping instance.</returns>
		public static IMapping CreateRequiresMapping(IComponent anInnerComponent, IIdentifier anInnerRoleID, IComponent anOuterComponent, IIdentifier anOuterRoleID)
		{
			return CreateRequiresMapping(CreateAttributeHash(), anInnerComponent, anInnerRoleID, anOuterComponent, anOuterRoleID);
		}

		/// <summary>
		/// Create a new IMapping instance.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new Mapping.</param>
		/// <param name="anOuterRole">RoleID of the outer interface.</param>
		/// <param name="anInnerRole">The inner interface anOuterRole is mapped onto.</param>
		/// <returns>A new IMapping instance.</returns>
		public static IMapping CreateRequiresMapping(IAttributeHash anAttrHash, 
			IRole anInnerRole, IRole anOuterRole)
		{
			return new DefaultMapping(anAttrHash, anInnerRole, anOuterRole, MappingTypeEnum.REQUIRES_MAPPING);
		}
		
		/// <summary>
		/// Create a new IMapping instance.
		/// </summary>
		/// <param name="anOuterRole">RoleID of the outer interface.</param>
		/// <param name="anInnerRole">The inner role anOuterRole is mapped onto.</param>
		/// <returns>A new IMapping instance.</returns>
		public static IMapping CreateRequiresMapping(IRole anInnerRole, IRole anOuterRole)
		{
			return new DefaultMapping(CreateAttributeHash(), anInnerRole, anOuterRole, MappingTypeEnum.REQUIRES_MAPPING);
		}

#endif
		#endregion

		/// <summary>
		/// Creates a new, empty AttributeHash.
		/// </summary>
		/// <returns>New IAttributeHash instance.</returns>
		public static IAttributeHash CreateAttributeHash()
		{
			return AttributesFactory.Default.CreateAttributeHash();
		}
	}
}
