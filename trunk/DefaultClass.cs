using System;
using System.Collections;
using Utils.Collections;
using System.Reflection;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// </summary>
	public class DefaultClass : ICloneable 
	{
		#region Properties

		#endregion

		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new DefaultClass(this);
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
			if (obj is DefaultClass)
			{
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
			return base.GetHashCode ();
		}

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			return "Not yet implemented!";
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a new DefaultClass.
		/// </summary>
		public DefaultClass ()
		{
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aDefaultClass">DefaultClass to copy.</param>
		public DefaultClass( DefaultClass aDefaultClass ) :
			this ( )
		{
		}

		#endregion

		#region Data

		#endregion
	}
}
