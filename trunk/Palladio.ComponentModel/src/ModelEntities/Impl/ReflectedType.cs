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
	/// Revision 1.2  2005/04/14 08:19:28  kelsaka
	/// - added new Equals semantic for IType
	/// - added new GetType-method for IType
	///
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

		/// <summary>
		/// Overloaded. Overridden. Determines if the underlying system type of the current
		/// Type is the same as the underlying system type of the specified Object or Type.
		/// </summary>
		/// <remarks>Neccessary to override because collections use Equals.</remarks>
		/// <param name="obj">The Object whose underlying system type is to be compared
		/// with the underlying system type of the current Type.</param>
		/// <returns>true if the underlying system type of <see cref="obj"/> is the same as
		/// the underlying system type of the current Type; otherwise, false. This method
		/// also returns false if the object specified by the <see cref="obj"/> parameter
		/// is not a Type.
		/// </returns>
		public override bool Equals(object obj)
		{		
			if(obj is IType)
			{
				if(this.Equals((IType)obj))
				{
					return true;
				}
			}
			return false;
		}

		/// <summary>
		/// Overloaded. Overridden. Determines if the underlying system type of the current
		/// Type is the same as the underlying system type of the specified Object or Type.
		/// </summary>
		/// <param name="type">The Type whose underlying system type is to be compared
		/// with the underlying system type of the current Type.</param>
		/// <returns>True, if the underlying Types are the same; otherwise, false.</returns>
		public bool Equals(IType type)
		{			
			if(this.GetType() == type.GetType())
			{
				return true;
			}
			return false;
		}

		/// <summary>
		/// Gets the underlying <see cref="Type"/> of the current instance.
		/// </summary>
		/// <remarks>
		/// Does not return an <see cref="IType"/>.
		/// </remarks>
		/// <returns>The Type instance that represents the underlying
		/// ReflectedType of the current instance.</returns>
		public Type GetType()
		{
			return this.reflectedType;
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
		/// <exception cref="TypeNotFoundException">Thrown if <see cref="aTypeName"/> is not a
		/// valid type.</exception>
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
