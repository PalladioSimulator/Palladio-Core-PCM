using System;
using System.Collections;
using Palladio.Utils.Collections;
using System.Reflection;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// IType describes a general type. It is comparable to System.Type.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 13:50:51  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface IType : ICloneable 
	{
		#region Properties

		/// <summary>
		/// Unique identifier of this type.
		/// </summary>
		string ID { get; }

		#endregion

		#region Methods

		/// <summary>
		/// Checks if this type is a subtype of aType.
		/// </summary>
		/// <param name="aType">Another type.</param>
		/// <returns>True, if this instance is a subtye of aType, false otherwise.</returns>
		bool IsSubtypeOf (IType aType);
		#endregion
	}
}
