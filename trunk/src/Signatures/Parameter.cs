using System;
using System.Collections;
using Utils.Collections;
using System.Reflection;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Parameter contains the information describing a parameter
	/// of a signature. It consits of a parameter name and a parameter type.
	/// </summary>
	public class Parameter : IParameter 
	{
		#region Properties
		/// <summary>
		/// Parameter name.
		/// </summary>
		public string Name 
		{ 
			set{ name = value; }
			get{ return name; }
		}

		/// <summary>
		/// Parameter Type.
		/// </summary>
		public IType Type 
		{ 
			set{ type = value; }
			get{ return type; }
		}

		#endregion

		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new Parameter(this);
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
			if (obj is Parameter)
			{
				Parameter par = (Parameter)obj;
				return ( 
					par.Name.Equals ( Name ) &&
					par.Type.Equals ( Type )
				);
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
			return name.GetHashCode ();
		}

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			return type + " " + name;
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a new Parameter with the name aName and the
		/// type aType.
		/// </summary>
		/// <param name="aType">Type of the Parameter.</param>
		/// <param name="aName">Name of the Parameter.</param>
		public Parameter( IType aType, string aName)
		{
			Type = aType;
			Name = aName;
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aParameter">Parameter to copy.</param>
		public Parameter( Parameter aParameter ) :
			this ( aParameter.Type, aParameter.Name )
		{
		}

		#endregion

		#region Data

		private string name;
		private IType type;
		#endregion
	}
}
