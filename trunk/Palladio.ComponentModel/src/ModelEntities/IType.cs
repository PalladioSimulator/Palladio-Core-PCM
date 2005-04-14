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
	/// Revision 1.2  2005/04/14 08:19:28  kelsaka
	/// - added new Equals semantic for IType
	/// - added new GetType-method for IType
	///
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

		/// <summary>
		/// Overloaded. Overridden. Determines if the underlying system type of the current
		/// Type is the same as the underlying system type of the specified Object or Type.
		/// </summary>
		/// <param name="type">The Type whose underlying system type is to be compared
		/// with the underlying system type of the current Type.</param>
		/// <returns>True, if the underlying Types are the same; otherwise, false.</returns>
		bool Equals(IType type);
		
		/// <summary>
		/// Gets the underlying <see cref="Type"/> of the current instance.
		/// </summary>
		/// <remarks>
		/// Does not return an <see cref="IType"/>.
		/// </remarks>
		/// <returns>The Type instance that represents the underlying
		/// ReflectedType of the current instance.</returns>
		Type GetType();

		#endregion
	}
}
