using System;
using System.Collections;
using Palladio.Utils.Collections;
using System.Reflection;
using Palladio.ComponentModel.Connections;

namespace Palladio.ComponentModel.Collections
{
	/// <summary>
	/// </summary>
	internal class ConnectionHash : ICloneable 
	{
		#region Methods

		public void Add(IComponent aComponent, string aRoleID, IConnection aConnection)
		{
			Hashtable strHash = (Hashtable) innerHash[aComponent];
			if (strHash == null)
				strHash = new Hashtable();
			strHash[aRoleID] = aConnection;
			innerHash[aComponent] = strHash;
		}

		public void Add(IConnection aConnection, params AttachedInterface[] anIfaceArray )
		{
			foreach (AttachedInterface iface in anIfaceArray)
			{
				Add(iface.Component, iface.RoleID, aConnection);
			}
		}

		public IConnection Get(IComponent aComponent, string aRoleID)
		{
			Hashtable strHash = (Hashtable)innerHash[aComponent];
			if ( strHash != null) 
			{
				return (IConnection) strHash[aRoleID];
			}
			return null;
		}

		public IConnection Get(AttachedInterface anInterface)
		{

			return Get(anInterface.Component, anInterface.RoleID);
		}

		public IConnection[] Get(IComponent aComponent)
		{
			ArrayList result = new ArrayList();
			Hashtable strHash = (Hashtable)innerHash[aComponent];
			if ( strHash != null) 
			{
				result.AddRange(strHash.Values);
			}
			return (IConnection[]) result.ToArray(typeof(IConnection));
		}

		public IConnection[] Get()
		{
			ArrayList result = new ArrayList();
			foreach (DictionaryEntry e in innerHash)
			{
				result.AddRange( ((Hashtable) e.Value).Values );
			}
			return (IConnection[]) result.ToArray(typeof(IConnection));
		}

		public void Delete(IComponent aComponent, string aRoleID)
		{
			Hashtable strHash = (Hashtable)innerHash[aComponent];
			if (strHash != null)
			{
				strHash.Remove(aRoleID);
			}
		}

		public void Delete(params AttachedInterface[] anIfaceArray)
		{
			foreach ( AttachedInterface iface in anIfaceArray )
			{
				Delete(iface.Component, iface.RoleID);
			}
		}


		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new ConnectionHash(this);
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
			return innerHash.GetHashCode ();
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
			innerHash = new Hashtable();
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aConnectionHash">ConnectionHash to copy.</param>
		public ConnectionHash( ConnectionHash aConnectionHash ) :
			this ( )
		{
			innerHash = new Hashtable( aConnectionHash.innerHash );
		}

		#endregion

		#region Data
		Hashtable innerHash;
		#endregion
	}
}
