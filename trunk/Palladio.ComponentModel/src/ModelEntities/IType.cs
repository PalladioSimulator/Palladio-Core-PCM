using System;

namespace Palladio.ComponentModel.ModelEntities
{
	/// <summary>
	/// IType is defines a wrapper class for a general type.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/15 12:31:23  joemal
	/// initial class creation
	///
	///
	/// </pre>
	/// </remarks>
	public interface IType: ICloneable
	{
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
