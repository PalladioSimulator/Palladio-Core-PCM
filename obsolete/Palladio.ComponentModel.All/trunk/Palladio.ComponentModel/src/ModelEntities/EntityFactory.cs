using System;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities.Impl;

namespace Palladio.ComponentModel.ModelEntities
{
	/// <summary>
	/// Factory for creating the entities of the componentmodel. This factory is only used from internal classes
	/// like the builders.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/07/23 18:59:57  joemal
	/// IType now is implemented in external object. Plugins for serializer are created.
	///
	/// Revision 1.2  2005/04/20 18:27:45  kelsaka
	/// - made classes internal
	/// - removed unused init-methods
	/// - use of InternalEntityIdentifier for creating new Identifiers
	///
	/// Revision 1.1  2005/03/15 12:31:23  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	internal class EntityFactory
	{
		#region CreateComponent

		/// <summary>
		/// called to create a new component that is using a new identifier. Use this to create a new component.
		/// </summary>
		/// <param name="type">the type of the component</param>
		/// <param name="name">the name of the component</param>
		/// <returns>the component</returns>
		public static IComponent CreateComponent(ComponentType type, string name)
		{
			return new DefaultComponent(new InternalEntityIdentifier(),type,name);
		}

		/// <summary>
		/// called to create a new component that is using the given identifier key. Use this to restore an existing component.
		/// </summary>
		/// <param name="identifier">the components identifier</param>
		/// <param name="type">the type of the component</param>
		/// <param name="name">the name of the component</param>
		/// <returns>the component</returns>
		public static IComponent CreateComponent(IComponentIdentifier identifier, ComponentType type, string name)
		{
			return new DefaultComponent(new InternalEntityIdentifier(identifier.Key),type,name);
		}

		#endregion

		#region CreateInterface

		/// <summary>
		/// called to create a new interface that is using a new identifier. Use this to create a new interface.
		/// </summary>
		/// <param name="name">the name of the interface</param>
		/// <returns>the interface</returns>
		public static IInterface CreateInterface(string name)
		{
			return new DefaultInterface(new InternalEntityIdentifier(),name);
		}

		/// <summary>
		/// called to create a new interface that is using the given identifier key. Use this to restore an existing interface.
		/// </summary>
		/// <param name="identifier">the key of the components identifier</param>
		/// <param name="name">the name of the interface</param>
		/// <returns>the interface</returns>
		public static IInterface CreateInterface(IInterfaceIdentifier identifier, string name)
		{
			return new DefaultInterface(new InternalEntityIdentifier(identifier.Key),name);
		}

		#endregion 

		#region CreateConnection
		
		/// <summary>
		/// called to create a new connection that is using a new identifier. Use this to create a new connection.
		/// </summary>
		/// <param name="name">the name of the connection</param>
		/// <returns>the connection</returns>
		public static IConnection CreateConnection(string name)
		{
			return new DefaultConnection(new InternalEntityIdentifier(),name);
		}

		/// <summary>
		/// called to create a new connection that is using the given identifier key. Use this to restore an existing connection.
		/// </summary>
		/// <param name="identifier">the components identifier</param>
		/// <param name="name">the name of the connection</param>
		/// <returns>the connection</returns>
		public static IConnection CreateConnection(IConnectionIdentifier identifier, string name)
		{
			return new DefaultConnection(new InternalEntityIdentifier(identifier.Key),name);
		}

		#endregion

		#region CreateSignature

		/// <summary>
		/// called to create a new signature that is using a new identifier. Use this to create a new signature.
		/// </summary>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="description">the description of the signature</param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(string aName, SignatureDescription description)
		{
			return new DefaultSignature(new InternalEntityIdentifier(),aName,description);
		}

		/// <summary>
		/// called to create a new signature that is using the given identifier key. Use this to restore an existing signature.
		/// </summary>
		/// <param name="identifier">the key of the components identifier</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="description">the description of the signature</param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(ISignatureIdentifier identifier, string aName, SignatureDescription description)
		{
			return new DefaultSignature(new InternalEntityIdentifier(identifier.Key),aName,description);
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
		/// <returns>A new IParameter instance.</returns>
		public static IParameter CreateParameter(IType aType, string aName)
		{
			return CreateParameter(aType,aName,ParameterModifierEnum.NONE);
		}

		#endregion

		#region create void type 

		/// <summary>
		/// called to create a void type that is used as return type void
		/// </summary>
		/// <returns>the void type</returns>
		public static IType CreateVoidType()
		{
			return new VoidType();
		}

		#endregion
	}
}
