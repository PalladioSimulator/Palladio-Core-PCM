using System;
using Palladio.Identifier;

namespace Palladio.ComponentModel.Identifier
{
	/// <summary>
	/// This is the implementation of all identifiers used by the models entities. Therefore it implements all
	/// interfaces of the entity identifiers, which are used to create type save identifiers.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/06 21:01:28  joemal
	/// rename filename EntityIdentifier.cs to InternalEntityIdentifier.cs
	///
	/// Revision 1.2  2005/03/15 22:03:02  joemal
	/// add to string method
	///
	/// Revision 1.1  2005/03/15 12:30:24  joemal
	/// initial class creation
	///
	///
	/// </pre>
	/// </remarks>
	internal class InternalEntityIdentifier : DefaultGUIDIdentifier, IComponentIdentifier, IConnectionIdentifier,
		ISignatureIdentifier,IInterfaceIdentifier, IProtocolIdentifier
	{
		#region constructors
		
		/// <summary>
		/// call to create a InternalEntityIdentifier using a new Guid.
		/// </summary>
		public InternalEntityIdentifier() : base() 
		{
		}

		/// <summary>
		/// call to create a InternalEntityIdentifier using the given guid
		/// </summary>
		/// <param name="guid">the string representation of a guid</param>
		/// <exception cref="ArgumentNullException">thrown if the paramater is null</exception>
		/// <exception cref="FormatException">thrown if the paramater is not a valid guid</exception>
		public InternalEntityIdentifier(string guid) : base(guid)
		{
		}

		/// <summary>
		/// call to create a InternalEntityIdentifier using the given guid
		/// </summary>
		/// <param name="guid">the guid to be used</param>
		public InternalEntityIdentifier(Guid guid) : base(guid)
		{
		}		

		/// <summary>
		/// call to create a copy from given identifier
		/// </summary>
		/// <param name="identifier">the identifier which has to be copied</param>
		public InternalEntityIdentifier(InternalEntityIdentifier identifier) : base(identifier)
		{
		}		

		#endregion		

		#region methods

		/// <summary>
		/// called to create a componentidentifier from this identifier.
		/// </summary>
		/// <returns>the component identifier</returns>
		public IComponentIdentifier AsComponentIdentifier()
		{
			return this;
		}

		/// <summary>
		/// called to create a connection identifier from this identifier.
		/// </summary>
		/// <returns>the connection identifier</returns>
		public IConnectionIdentifier AsConnectionIdentifier()
		{
			return this;
		}

		/// <summary>
		/// called to create an interface identifier from this identifier.
		/// </summary>
		/// <returns>the interface identifier</returns>
		public IInterfaceIdentifier AsInterfaceIdentifier()
		{
			return this;
		}

		/// <summary>
		/// called to create a signature identifier from this identifier.
		/// </summary>
		/// <returns>the signature identifier</returns>
		public ISignatureIdentifier AsSignatureIdentifier()
		{
			return this;
		}

		/// <summary>
		/// called to create a protocol identifier from this identifier.
		/// </summary>
		/// <returns>the protocol identifier</returns>
		public IProtocolIdentifier AsProtocolIdentifier()
		{
			return this;
		}

		/// <summary>
		/// override to return the key of the identifier.
		/// </summary>
		/// <returns>the key of the identifier</returns>
		public override string ToString()
		{
			return this.Key;
		}


		#endregion
	}
}
