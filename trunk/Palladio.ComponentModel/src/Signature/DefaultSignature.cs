using System;
using Palladio.Identifier;
using Palladio.Attributes;
using Palladio.Utils.Collections;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Simple implementation of the ISignature interface for methods.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/02/24 20:13:05  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:49:17  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
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
			get { return (IParameter[])parameters.ToArray(typeof(IParameter)); } 
		}
		
		public IType[] Exceptions {
			get { return (IType[])exceptions.ToArray(typeof(IType)); }
		}
		public AttributeHash Attributes {
			get {
				return attributes;
			}
		}
		
		public IIdentifier ID
		{
			get
			{
				return IdentifiableFactory.CreateStringID(this.GetHashCode().ToString());
//				string sigID = this.name+"(";
//				if (this.Parameters.Length > 0) 
//				{
//					foreach (IParameter p in this.Parameters) 
//					{
//						sigID += p.Type+",";
//					}
//					sigID = sigID.TrimEnd(new char[]{','});
//				}
//				sigID += ")";
//				return IdentifiableFactory.CreateStringID(sigID);
			}
		}
		#endregion

		#region Methods
		
		public bool Match(IMatchable other)
		{
			return false;
			//Todo: implement proper matching algorithm
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new DefaultSignature(this);
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
		/// <param name="aType">A return type</param>
		/// <param name="aName">The name of the signature</param>
		/// <param name="aParamArray">Parameters of the signature</param>
		/// <param name="anExceptArray">Exceptions of the signature</param>
		public DefaultSignature(AttributeHash anAttribHash, IType aType, string aName, IParameter[] aParamArray, IType[] anExceptArray
		)
		{
			attributes = anAttribHash;
			type = aType;
			name = aName;
			parameters = new Vector(aParamArray);
			exceptions = new Set(anExceptArray);
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aSig">Signature to copy.</param>
		public DefaultSignature(DefaultSignature  aSig) : 
			this(aSig.Attributes, aSig.ReturnType, aSig.Name, aSig.Parameters, aSig.Exceptions
						
			)
		{
		}
		#endregion

		#region Data
		
		private string name;
		private IType  type;
		private Vector parameters;
		private Set exceptions;
		private AttributeHash attributes;

		#endregion
	}
}
