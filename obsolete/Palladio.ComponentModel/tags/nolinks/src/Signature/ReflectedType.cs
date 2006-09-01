using System;
using System.Collections;
using Palladio.Utils.Collections;
using System.Reflection;
using System.Diagnostics;
using Palladio.ComponentModel.Exceptions;

namespace Palladio.ComponentModel.Signature
{
	/// <summary>
	/// IType describes the types of parameters and return values of
	/// signatures. It can be compared with System.Type.
	/// </summary>
	internal class ReflectedType : IType
	{
		#region Properties

		/// <summary>
		/// Name describing this type.
		/// </summary>
		public string ID { 
			get
			{
				return reflectedType.FullName;
			}
		}
		#endregion

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
					System.Type[] interfaces = reflectedType.GetInterfaces();
					foreach ( System.Type iface in interfaces)
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
			if (obj is ReflectedType)
			{
				Type otherRefType = ((ReflectedType)obj).reflectedType;
				return reflectedType.Equals(otherRefType);
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
			return (reflectedType != null ? reflectedType.GetHashCode () : 0);
		}

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			return ID;
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates new ReflectedType using aReflectedType.
		/// </summary>
		/// <param name="aReflectedType">Sytem.Type describing the new ReflectedType</param>
		public ReflectedType ( System.Type aReflectedType )
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
			if( System.Type.GetType(aTypeName) == null )
				throw new TypeNotFoundException(aTypeName);
			
			reflectedType = System.Type.GetType(aTypeName);
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

		private System.Type reflectedType;
		#endregion

	}
}
