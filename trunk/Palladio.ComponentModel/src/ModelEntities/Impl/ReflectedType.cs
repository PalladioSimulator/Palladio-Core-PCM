using System;
using Palladio.ComponentModel.Exceptions;

namespace Palladio.ComponentModel.ModelEntities.Impl
{
	/// <summary>
	/// IType describes the types of parameters and return values of
	/// signatures. It can be compared with System.Type.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/15 12:31:37  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	internal class ReflectedType : IType
	{
		#region Methods

		/// <summary>
		/// Checks if this PalladioType is a subtype of aType.
		/// </summary>
		/// <param name="aType">Another PalladioType.</param>
		/// <returns>True, if this instance is a subtye of aType, false otherwise.</returns>
		public bool IsSubtypeOf (IType aType) 
		{
			bool result = false;
			if (aType is ReflectedType)
			{
				Type otherRefType = ( (ReflectedType) aType).reflectedType;
				if (otherRefType.IsInterface) 
				{
					Type[] interfaces = reflectedType.GetInterfaces();
					foreach ( Type iface in interfaces)
					{
						if (iface.Equals(otherRefType))
						{
							result = true;
							break;
						}
					}
				}
				else
				{
					result = reflectedType.IsSubclassOf(otherRefType);
				}
			}
			return result;
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new ReflectedType(this);
		}

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			return reflectedType.FullName;
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates new ReflectedType using aReflectedType.
		/// </summary>
		/// <param name="aReflectedType">Sytem.Type describing the new ReflectedType</param>
		public ReflectedType ( Type aReflectedType )
		{
			reflectedType = aReflectedType;
		}

		/// <summary>
		/// Creates new ReflectedType using its name.
		/// </summary>
		/// <param name="aTypeName">Name describing the Type. It has to be a valid
		/// name of an existing type.</param>
		public ReflectedType ( string aTypeName )
		{
			if( Type.GetType(aTypeName) == null )
				throw new TypeNotFoundException(aTypeName);
			
			reflectedType = Type.GetType(aTypeName);
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aReflectedType">ReflectedType to copy</param>
		public ReflectedType ( ReflectedType aReflectedType ):
			this ( aReflectedType.reflectedType )
		{
		}
		#endregion

		#region Data

		//holds the type
		private Type reflectedType;
		#endregion

	}
}
