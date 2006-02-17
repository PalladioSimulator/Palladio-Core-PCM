using System;
using System.Reflection;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Simple implementation of the ISignature interface for methods.
	/// </summary>
	public class MethodSignature : ISignature
	{
		#region Properties

		/// <summary>
		/// The name of the signature without any additional
		/// information like the return type or parameters.
		/// </summary>
		public string Name
		{
			set { name = value; }
			get { return name; }
		}

		/// <summary>
		/// Type of the return value.
		/// </summary>
		public IType ReturnType 
		{ 
			set { type = value; } 
			get { return type; } 
		}

		/// <summary>
		/// Parameters required by this signature. If
		/// no parameters are needed Parameters is set to 'null'.
		/// </summary>
		public IParameter[] Parameters
		{ 
			set {	parameters = value;	} 
			get { return parameters; } 
		}

		#endregion

		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new MethodSignature(this);
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
			if (obj is ISignature) 
			{
				ISignature sig = (ISignature) obj;
				bool equalPar = true;
				if (sig.Parameters.Length == Parameters.Length)
				{
					for ( int i=0; i<Parameters.Length; i++)
					{
						if (! sig.Parameters[i].Equals( Parameters[i] ))
						{
							equalPar = false;
							break;
						}
					}
				} 
				else 
				{
					equalPar = false;
				}
				return (
					equalPar &&
					sig.Name.Equals(Name) &&
					sig.ReturnType.Equals(ReturnType)
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
			return this.Name.GetHashCode();
		}

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			string result = ReturnType + " " + Name + " (";
			bool first = true;
			foreach (IParameter p in Parameters)
			{
				if(first) 
				{
					result += " " + p;
					first = false;
				}
				else
				{
					result += ", " + p;
				}
			}
			if (first)
			{
				result += ");";
			}
			else
			{
				result += " );";
			}
			return result;
		}
		#endregion

		#region Constructors

		/// <summary>
		/// Creates a new Signature with the name aName.
		/// </summary>
		/// <param name="aName">Name of the new Signature.</param>
		public MethodSignature(string aName)
		{
			name = aName;
			type = new ReflectedType(typeof(void));
			parameters = new IParameter[0];
		}


		/// <summary>
		/// Creates a new Signature with the name aName and the return type aType.
		/// </summary>
		/// <param name="aType">Return type of the Signature.</param>
		/// <param name="aName">Name of the new Signature.</param>
		public MethodSignature(IType aType, string aName)
		{
			name = aName;
			type = aType;
			parameters = new IParameter[0];
		}

		/// <summary>
		/// Creates a new Signature with the name aName and the return type aType.
		/// </summary>
		/// <param name="aType">Return type of the Signature.</param>
		/// <param name="aName">Name of the new Signature.</param>
		/// <param name="aParamList">List of parameters of the signature</param>
		public MethodSignature(IType aType, string aName, params IParameter[] aParamList)
		{
			name = aName;
			type = aType;
			parameters = new IParameter[aParamList.Length];
			aParamList.CopyTo(parameters,0);
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aSig">Signature to copy.</param>
		public MethodSignature(MethodSignature  aSig) : 
			this(aSig.ReturnType, aSig.Name, aSig.Parameters) 
		{
		}
		#endregion

		#region Data
		
		private string name;
		private IType  type;
		private IParameter[] parameters;
		#endregion
	}
}
