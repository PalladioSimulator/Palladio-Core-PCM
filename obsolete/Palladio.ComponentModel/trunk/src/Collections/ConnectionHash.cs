using System;
using System.Collections;
using Palladio.Utils.Collections;
using Palladio.ComponentModel.Connections;

namespace Palladio.ComponentModel.Collections
{
	/// <summary>
	/// ConnectionHash maps a component and a role onto a connection.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/06/02 14:50:24  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.4  2004/05/23 16:03:55  sliver
	/// completed unit tests
	///
	/// </pre>
	/// </remarks>
	internal class ConnectionHash : ICloneable 
	{
		#region Methods

		/// <summary>
		/// Add aConnection to the ConnectionHash and associate it with
		/// aComponent and the aRoleID.
		/// </summary>
		/// <param name="aComponent">Component key.</param>
		/// <param name="aRoleID">RoleID key.</param>
		/// <param name="aConnection">Connection value.</param>
		public void Add(IComponent aComponent, string aRoleID, IConnection aConnection)
		{
			Hashmap strHash = (Hashmap) innerHash[aComponent];
			if (strHash == null)
				strHash = new Hashmap();
			strHash[aRoleID] = aConnection;
			innerHash[aComponent] = strHash;
		}

		/// <summary>
		/// Add aConnection to the ConnectionHash and associate it with the
		/// component and role of anInterface.
		/// </summary>
		/// <param name="anInterface">Interface key.</param>
		/// <param name="aConnection">Connection value.</param>
		public void Add(AttachedInterface anInterface, IConnection aConnection)
		{
				Add(anInterface.Component, anInterface.RoleID, aConnection);
		}


		/// <summary>
		/// Get the connection associated with aComponent and aRoleID.
		/// </summary>
		/// <param name="aComponent">Component key.</param>
		/// <param name="aRoleID">RoleID key.</param>
		/// <returns>Connection of aComponent and aRoleID</returns>
		public IConnection Get(IComponent aComponent, string aRoleID)
		{
			Hashmap strHash = (Hashmap)innerHash[aComponent];
			if ( strHash != null) 
			{
				return (IConnection) strHash[aRoleID];
			}
			return null;
		}

		/// <summary>
		/// Get the connection associated with anInterface.
		/// </summary>
		/// <param name="anInterface">Interface key.</param>
		/// <returns>Connection of anInterface.</returns>
		public IConnection Get(AttachedInterface anInterface)
		{

			return Get(anInterface.Component, anInterface.RoleID);
		}

		/// <summary>
		/// Get all connections of aComponent.
		/// </summary>
		/// <param name="aComponent">Component key.</param>
		/// <returns>Connections associated with aComponent.</returns>
		public ArrayList Get(IComponent aComponent)
		{
			ArrayList result = new ArrayList();
			Hashmap strHash = (Hashmap)innerHash[aComponent];
			if ( strHash != null) 
			{
				result.AddRange(strHash.Values);
			}
			return result;
		}

		/// <summary>
		/// Get all connections of the hash.
		/// </summary>
		/// <returns>All connections contained by the hash.</returns>
		public ArrayList Get()
		{
			ArrayList result = new ArrayList();
			foreach (DictionaryEntry e in innerHash)
			{
				result.AddRange( ((Hashmap) e.Value).Values );
			}
			return result;
		}

		/// <summary>
		/// Delete the connection associated with aComponent and aRoleID.
		/// </summary>
		/// <param name="aComponent">Component key.</param>
		/// <param name="aRoleID">RoleID key.</param>
		public void Delete(IComponent aComponent, string aRoleID)
		{
			Hashmap strHash = (Hashmap)innerHash[aComponent];
			if (strHash != null)
			{
				strHash.Remove(aRoleID);
			}
		}

		/// <summary>
		/// Delete the connection associated with anInterface.
		/// </summary>
		/// <param name="anInterface">Interface key.</param>
		public void Delete(AttachedInterface anInterface)
		{
			Delete(anInterface.Component, anInterface.RoleID);
		}


		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public ConnectionHash Clone()
		{
			return new ConnectionHash(this);
		}

		object System.ICloneable.Clone()
		{
			return Clone();
		}

		/// <summary>
		/// The Equals method determines whether the specified 
		/// System.Object is equal to the current System.Object.
		/// </summary>
		/// <param name="obj">Contains the Object to compare with 
		/// the current object.</param>
		/// <returns>Returns true if the specified object is equal 
		/// to the current objector or false if the obejcts 
		/// are not equal.</returns>
		public override bool Equals(object obj)
		{
			if (obj is ConnectionHash)
			{
				ConnectionHash hash = (ConnectionHash)obj;
				return innerHash.Equals(hash.innerHash);
			}
			return false;
		}

		/// <summary>
		/// The GetHashCode method serves as a hash function 
		/// for a particular type, suitable for use in hashing 
		/// algorithms and data structures like a hash table.
		/// </summary>
		/// <returns>A hash value for the current object.</returns>
		public override int GetHashCode()
		{
			return innerHash.GetHashCode();
		}

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			return innerHash.ToString();
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a new ConnectionHash.
		/// </summary>
		public ConnectionHash ()
		{
			innerHash = new Hashmap();
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aConnectionHash">ConnectionHash to copy.</param>
		public ConnectionHash( ConnectionHash aConnectionHash ) :
			this ( )
		{
			innerHash = aConnectionHash.innerHash.Clone();
		}

		#endregion
																										 
		#region Data
		Hashmap innerHash;
		#endregion
	}
}
