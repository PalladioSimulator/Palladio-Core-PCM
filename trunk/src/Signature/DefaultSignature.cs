using System;
using System.Reflection;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel.Signature
{
	/// <summary>
	/// Simple implementation of the ISignature interface for methods.
	/// </summary>
	internal class DefaultSignature : ISignature
	{
		#region Properties

		/// <summary>
		/// The name of the signature without any additional
		/// information like the return type or parameters.
		/// </summary>
		public string Name
		{
			get { return name; }
		}

		/// <summary>
		/// Type of the return value.
		/// </summary>
		public IType ReturnType 
		{ 
			get { return type; } 
		}

		/// <summary>
		/// Parameters required by this signature.
		/// </summary>
		public IParameter[] Parameters
		{ 
			get { return parameters; } 
		}
		
		public string RoleID {
			get {
				return roleID;
			}
		}
		
		public IType[] Exceptions {
			get {
				return exceptions;
			}
		}
		public IAttributeHash Attributes {
			get {
				return attributes;
			}
		}
		
		#endregion

		#region Methods
		
		public bool Match(IMatchable other)
		{
			return false;
			//TODO implement proper matching algorithm
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new DefaultSignature(this);
		}

		public override bool Equals(object obj)
		{
			if (!(obj is ISignature)) return false;
			ISignature sig = (ISignature)obj;

			if (!(sig.Name.Equals(this.Name) && 
						sig.ReturnType.Equals(this.ReturnType) &&
						sig.RoleID.Equals(this.RoleID) &&
						(sig.Parameters.Length == this.Parameters.Length) &&
						(sig.Exceptions.Length == this.Exceptions.Length)
					))
				return false;

			for (int i = 0; i < this.Parameters.Length; i++)
			{
				if (!sig.Parameters[i].Equals(this.Parameters[i]))
					return false;
			}

			foreach (IType ex in this.Exceptions)
			{
				if (Array.IndexOf(sig.Exceptions, ex) < 0)
					return false;
			}

			return true;
		}

		public override int GetHashCode()
		{
			return	
				(RoleID != null ? RoleID.GetHashCode()	: 0) ^ 
				(Name		!= null ? Name.GetHashCode() : 0) ^ 
				(ReturnType != null ? ReturnType.GetHashCode() : 0) ^ 
				(Parameters != null ? Parameters.GetHashCode() : 0) ^ 
				(Exceptions != null ? Exceptions.GetHashCode() : 0);
		}

		public override string ToString()
		{
			string result = ReturnType + " " + Name + "(";
			string parameters = "";
			string exceptions = "";
			foreach(IParameter p in Parameters)
			{
				parameters += p.ToString() + ", ";
			}
			if (parameters.Length != 0) 
				parameters = parameters.Substring(0,parameters.Length-2);
			foreach(IType e in Exceptions)
			{
				exceptions += e.ToString() + ", ";
			}
			if (exceptions.Length != 0) 
				exceptions = exceptions.Substring(0,exceptions.Length-2);
			result += parameters + ")";
			if (exceptions.Length > 0)
				result += "throws " + exceptions;
			return result;
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a new signature.
		/// </summary>
		/// <param name="anAttribHash">Attributes of the Signature.</param>
		/// <param name="aRoleID">Role the signature</param>
		/// <param name="aType"></param>
		/// <param name="aName"></param>
		/// <param name="aParamArray"></param>
		/// <param name="anExceptArray"></param>
		public DefaultSignature(IAttributeHash anAttribHash, string aRoleID, IType aType, string aName, IParameter[] aParamArray, IType[] anExceptArray)
		{
			attributes = anAttribHash;
			roleID = aRoleID;
			type = aType;
			name = aName;
			parameters = new IParameter[aParamArray.Length];
			aParamArray.CopyTo(parameters,0);
			exceptions = new IType[anExceptArray.Length];
			anExceptArray.CopyTo(exceptions,0);
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aSig">Signature to copy.</param>
		public DefaultSignature(DefaultSignature  aSig) : 
			this(aSig.Attributes, aSig.RoleID, aSig.ReturnType, aSig.Name, aSig.Parameters, aSig.Exceptions) 
		{
		}
		#endregion

		#region Data
		
		private string name;
		private string roleID;
		private IType  type;
		private IParameter[] parameters;
		private IType[] exceptions;
		private IAttributeHash attributes;

		#endregion
	}
}
