using System;
using System.Collections;
using Palladio.Utils.Collections;
using System.Reflection;
using Palladio.ComponentModel.Connections;

namespace Palladio.ComponentModel.Collections
{
	/// <summary>
	/// </summary>
	internal class MultipleConnectionHash : ICloneable 
	{
		#region Methods

		public void Add(IComponent aComponent, string aRoleID, IConnection aConnection)
		{
			Hashtable strHash = (Hashtable) innerHash[aComponent];
			if (strHash == null)
				strHash = new Hashtable();
			Set connectionSet = (Set)strHash[aRoleID];
			if (connectionSet == null)
				connectionSet = new Set();
			connectionSet.Add( aConnection );
			strHash[aRoleID] = connectionSet;
			innerHash[aComponent] = strHash;
		}

		public void Add(AttachedInterface anInterface, IConnection aConnection )
		{
				Add(anInterface.Component, anInterface.RoleID, aConnection);
		}

		public IConnection[] Get(IComponent aComponent, string aRoleID)
		{
			Hashtable strHash = (Hashtable)innerHash[aComponent];
			if ( strHash != null) 
			{
				Set connectionSet = (Set)strHash[aRoleID];
				if (connectionSet != null)
					return (IConnection[]) connectionSet.ToArray(typeof(IConnection));
			}
			return null;
		}

		public IConnection[] Get(AttachedInterface anInterface)
		{

			return Get(anInterface.Component, anInterface.RoleID);
		}

		public IConnection[] Get(IComponent aComponent)
		{
			ArrayList result = new ArrayList();
			Hashtable strHash = (Hashtable)innerHash[aComponent];
			if ( strHash != null) 
			{
				foreach( DictionaryEntry e in strHash )
				{
					result.AddRange( (Set)e.Value );
				}
			}
			return (IConnection[]) result.ToArray(typeof(IConnection));
		}

		public IConnection[] Get()
		{
			ArrayList result = new ArrayList();
			foreach (DictionaryEntry e in innerHash)
			{
				Hashtable strHash = (Hashtable)e.Value;
				foreach (DictionaryEntry f in strHash)
				{
					result.AddRange( (Set) f.Value );
				}
			}
			return (IConnection[]) result.ToArray(typeof(IConnection));
		}

		public void Delete(IComponent aComponent, string aRoleID, IConnection aConnection)
		{
			Hashtable strHash = (Hashtable)innerHash[aComponent];
			if (strHash != null)
			{
				Set connectionSet = (Set)strHash[aRoleID];
				if ( connectionSet != null )
					connectionSet.Remove(aConnection);
			}
		}

		public void Delete(AttachedInterface anInterface, IConnection aConnection)
		{
				Delete(anInterface.Component, anInterface.RoleID, aConnection);
		}


		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new MultipleConnectionHash(this);
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
			if (obj is MultipleConnectionHash)
			{
				MultipleConnectionHash hash = (MultipleConnectionHash)obj;
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
		public MultipleConnectionHash ()
		{
			innerHash = new Hashtable();
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aConnectionHash">ConnectionHash to copy.</param>
		public MultipleConnectionHash( MultipleConnectionHash aConnectionHash ) :
			this ( )
		{
			innerHash = new Hashtable( aConnectionHash.innerHash );
		}

		#endregion

		#region Data
		protected Hashtable innerHash;
		#endregion
	}
}
