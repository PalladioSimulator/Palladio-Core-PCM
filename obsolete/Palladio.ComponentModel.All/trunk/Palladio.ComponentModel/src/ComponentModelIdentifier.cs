using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// This class contains several static methods to create id for the components entities using a given guid as key.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2005/07/29 16:04:13  joemal
	/// add identifier of seffs and sefftypes
	///
	/// Revision 1.3  2005/07/23 18:59:57  joemal
	/// IType now is implemented in external object. Plugins for serializer are created.
	///
	/// Revision 1.2  2005/05/08 12:04:23  joemal
	/// implementation of xml serialization
	///
	/// Revision 1.1  2005/04/10 15:32:44  joemal
	/// initial class creation
	///
	///
	/// </pre>
	/// </remarks>
	public class ComponentModelIdentifier
	{
		/// <summary>
		/// called to create a new component identifier using the given guid as key
		/// </summary>
		/// <param name="guid">the guid</param>
		/// <returns>the identifier</returns>
		public static IComponentIdentifier CreateComponentID(string guid)
		{
			return new InternalEntityIdentifier(guid).AsComponentIdentifier();
		}

		/// <summary>
		/// called to create a new interface identifier using the given guid as key
		/// </summary>
		/// <param name="guid">the guid</param>
		/// <returns>the identifier</returns>
		public static IInterfaceIdentifier CreateInterfaceID(string guid)
		{
			return new InternalEntityIdentifier(guid).AsInterfaceIdentifier();
		}
		/// <summary>
		/// called to create a new connection identifier using the given guid as key
		/// </summary>
		/// <param name="guid">the guid</param>
		/// <returns>the identifier</returns>
		public static IConnectionIdentifier CreateConnectionID(string guid)
		{
			return new InternalEntityIdentifier(guid).AsConnectionIdentifier();
		}

		/// <summary>
		/// called to create a new signature identifier using the given guid as key
		/// </summary>
		/// <param name="guid">the guid</param>
		/// <returns>the identifier</returns>
		public static ISignatureIdentifier CreateSignatureID(string guid)
		{
			return new InternalEntityIdentifier(guid).AsSignatureIdentifier();
		}

		/// <summary>
		/// called to create a new protocol identifier using the given guid as key
		/// </summary>
		/// <param name="guid">the guid</param>
		/// <returns>the identifier</returns>
		public static IProtocolIdentifier CreateProtocolID(string guid)
		{
			return new InternalEntityIdentifier(guid).AsProtocolIdentifier();
		}

		/// <summary>
		/// called to create a new protocoltype identifier using the given guid as key
		/// </summary>
		/// <param name="guid">the guid</param>
		/// <returns>the identifier</returns>
		public static IProtocolTypeIdentifier CreateProtocolTypeID(string guid)
		{
			return new InternalEntityIdentifier(guid).AsProtocolTypeIdentifier();
		}

		/// <summary>
		/// called to create a new type identifier using the given guid as key
		/// </summary>
		/// <param name="guid">the guid</param>
		/// <returns>the identifier</returns>
		public static ITypeIdentifier CreateTypeID(string guid)
		{
			return new InternalEntityIdentifier(guid);
		}
		
		/// <summary>
		/// called to create a new seff identifier using the given guid as key
		/// </summary>
		/// <param name="guid">the guid</param>
		/// <returns>the identifier</returns>
		public static ISeffIdentifier CreateSeffID(string guid)
		{
			return new InternalEntityIdentifier(guid);
		}

		/// <summary>
		/// called to create a new type identifier for seffs using the given guid as key
		/// </summary>
		/// <param name="guid">the guid</param>
		/// <returns>the identifier</returns>
		public static ISeffTypeIdentifier CreateSeffTypeID(string guid)
		{
			return new InternalEntityIdentifier(guid);
		}
	}
}
