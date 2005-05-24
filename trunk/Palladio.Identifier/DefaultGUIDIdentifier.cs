using System;

namespace Palladio.Identifier
{
	/// <summary>
	/// This is a default implementation of IIdentifier. It uses the string representation of a guid
	/// as id.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/05/24 16:53:15  joemal
	/// fix bug in method gethashkey
	///
	/// Revision 1.2  2005/04/19 16:45:45  joemal
	/// reimplement the equals method
	///
	/// Revision 1.1  2005/03/15 12:34:33  joemal
	/// initial class creation
	///
	///
	/// </pre>
	/// </remarks>
	public class DefaultGUIDIdentifier : IIdentifier
	{
		#region data

		/// <summary>
		/// holds the guid of this identifier
		/// </summary>
		protected Guid guid;

		#endregion

		#region constructors
		
		/// <summary>
		/// call to create a DefaultIdentifier using a new Guid.
		/// </summary>
		public DefaultGUIDIdentifier()
		{
			this.guid = Guid.NewGuid();
		}

		/// <summary>
		/// call to create a DefaultIdentifier using the given guid
		/// </summary>
		/// <param name="guid">the string representation of a guid</param>
		/// <exception cref="ArgumentNullException">thrown if the paramater is null</exception>
		/// <exception cref="FormatException">thrown if the paramater is not a valid guid</exception>
		public DefaultGUIDIdentifier(string guid)
		{
			this.guid = new Guid(guid);
		}

		/// <summary>
		/// call to create a DefaultIdentifier using the given guid
		/// </summary>
		/// <param name="guid">the guid to be used</param>
		public DefaultGUIDIdentifier(Guid guid)
		{
			this.guid = guid;
		}		

		/// <summary>
		/// call to create a copy from given identifier
		/// </summary>
		/// <param name="identifier">the identifier which has to be copied</param>
		public DefaultGUIDIdentifier(DefaultGUIDIdentifier identifier)
		{
			this.guid = identifier.guid;
		}		

		#endregion

		#region properties

		/// <summary>
		/// returns the string representation of the guid
		/// </summary>
		public string Key
		{
			get
			{
				return this.guid.ToString();
			}
		}

		#endregion 

		#region methods

		/// <summary>
		/// determ whether the given key matchs to this identifiers guid.
		/// </summary>
		/// <param name="key">the key</param>
		/// <returns>true, if the key matchs to this identifiers guid</returns>
		public bool Match(string key)
		{
			return this.guid.ToString().Equals(key);
		}

		/// <summary>
		/// called to create a hashcode for this object
		/// </summary>
		/// <returns>the hashcode</returns>
		public override int GetHashCode()
		{
			return guid.GetHashCode() & 0x70F0F0F0;
		}


		/// <summary>
		/// returns true, if the given object is from type IIdentifier and if the keys of both do match.
		/// </summary>
		/// <param name="obj">the object</param>
		/// <returns>returns true, if the given object is from type IIdentifier and if the keys of both do match.</returns>
		public override bool Equals(object obj)
		{
			if (!(obj is IIdentifier)) return false;
			return this.Match(((IIdentifier)obj).Key);
		}

		/// <summary>
		/// called to create a copy of this identifier
		/// </summary>
		/// <returns>the copy of this identifier</returns>
		public object Clone()
		{
			return new DefaultGUIDIdentifier(this);
		}

		#endregion
	}
}
