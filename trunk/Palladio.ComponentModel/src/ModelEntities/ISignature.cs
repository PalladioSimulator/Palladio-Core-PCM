using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities.Impl;

namespace Palladio.ComponentModel.ModelEntities
{
	/// <summary>
	/// A Signature describes the calling conventions of a service.
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
	public interface ISignature : IComponentModelEntity
	{		
		#region Properties

		/// <summary>
		/// the typed id of the signature
		/// </summary>
		ISignatureIdentifier SignaturID { get; }

		/// <summary>
		/// set or get the whole description of a signature with parameters, returntype and exceptions
		/// </summary>
		SignatureDescription Description { get; set;} 
		
		/// <summary>
		/// Type of the return value. 
		/// </summary>
		IType ReturnType { get; set;}

		/// <summary>
		/// Parameters required by this signature. 
		/// </summary>
		IParameter[] Parameters { get; set;}

		/// <summary>
		/// An unordered set of exceptions thrown by the methods implementing this signature.
		/// </summary>
		IType[] Exceptions { get; set;}

		#endregion

	}

	/// <summary>
	/// this class describes a signature.
	/// </summary>
	public class SignatureDescription
	{

		/// <summary>
		/// the default value of the return value
		/// </summary>
		public readonly static IType DEFAULT_RETURNTYPE = new ReflectedType(typeof(void));

		/// <summary>
		/// the default value of the parameter list
		/// </summary>
		public readonly static IParameter[] DEFAULT_PARAMETERS = new IParameter[0];

		/// <summary>
		/// the default value of the exception list
		/// </summary>
		public readonly static IType[] DEFAULT_EXCEPTIONS = new IType[0];

		/// <summary>
		/// called to create a new signature description using default values
		/// </summary>
		public SignatureDescription()
		{
		}
        
		/// <summary>
		/// called to create a new signature description using given description parameters.
		/// </summary>
		/// <param name="returnType">the returntype of the signature</param>
		/// <param name="parameters">a list of parameters</param>
		/// <param name="exceptions">a list of exceptions</param>
		public SignatureDescription(IType returnType, IParameter[] parameters, IType[] exceptions)
		{
			this.Parameters = parameters;
			this.Exceptions = exceptions;
			this.ReturnType = returnType;
		}

		/// <summary>
		/// the returntype of the signature
		/// </summary>
		public IType ReturnType = DEFAULT_RETURNTYPE;

		/// <summary>
		/// the array of parameters
		/// </summary>
		public IParameter[] Parameters = DEFAULT_PARAMETERS;

		/// <summary>
		/// the array of exceptions
		/// </summary>
		public IType[] Exceptions = DEFAULT_EXCEPTIONS;
	}
}
