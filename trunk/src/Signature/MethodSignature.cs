using System;
using System.Reflection;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel.Signature
{
	/// <summary>
	/// Simple implementation of the ISignature interface for methods.
	/// </summary>
	internal class MethodSignature : ISignature
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
		public virtual object Clone()
		{
			return new MethodSignature(this);
		}


		#endregion

		#region Constructors

		/// <summary>
		/// Creates a new Signature with the name aName and the return type aType.
		/// </summary>
		/// <param name="aType">Return type of the Signature.</param>
		/// <param name="aName">Name of the new Signature.</param>
		/// <param name="aParamList">List of parameters of the signature</param>
		public MethodSignature(IAttributeHash anAttribHash, string aRoleID, IType aType, string aName, IParameter[] aParamArray, IType[] anExceptArray)
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
		public MethodSignature(MethodSignature  aSig) : 
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
