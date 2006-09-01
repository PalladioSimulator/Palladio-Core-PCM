using System;
using System.Collections;
using Palladio.Utils.Collections;
using System.Reflection;

namespace Palladio.ComponentModel.Signature
{
	/// <summary>
	/// Parameter contains the information describing a parameter
	/// of a signature. It consits of a parameter name and a parameter type.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.6  2004/05/24 15:20:45  sliver
	/// added cvs log
	///
	/// </pre>
	/// </remarks>
	internal class Parameter : IParameter 
	{
		#region Properties
		/// <summary>
		/// Parameter name.
		/// </summary>
		public string Name 
		{ 
			get{ return name; }
		}

		/// <summary>
		/// Parameter Type.
		/// </summary>
		public IType Type 
		{ 
			get{ return type; }
		}

		public ParameterModifierEnum Modifier {
			get {
				return modifier;
			}
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
					par.Type.Equals ( Type ) &&
					par.Modifier.Equals ( Modifier )
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
			return 
				(
				(name != null ? name.GetHashCode() : 0) ^ 
				(type != null ? type.GetHashCode() : 0) ^
				modifier.GetHashCode()
				);
		}

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			if (modifier != ParameterModifierEnum.NONE)
				return modifier + " " + type + " " + name;
			else
				return type + " " + name;
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a new Parameter with the name aName and the
		/// type aType.
		/// </summary>
		/// <param name="aType">Type of the parameter.</param>
		/// <param name="aName">Name of the parameter.</param>
		/// <param name="aModifier">Modifier of the parameter.</param>
		public Parameter(IType aType, string aName, ParameterModifierEnum aModifier)
		{
			type = aType;
			name = aName;
			modifier = aModifier;
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aParameter">Parameter to copy.</param>
		public Parameter( Parameter aParameter ) :
			this ( aParameter.Type, aParameter.Name, aParameter.Modifier )
		{
		}

		#endregion

		#region Data

		private string name;
		private IType type;
		private ParameterModifierEnum modifier;
		#endregion
	}
}
