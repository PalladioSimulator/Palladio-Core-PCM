using Palladio.ComponentModel.Identifier;
using Palladio.FiniteStateMachines;

namespace Palladio.FSMWrapper
{
	/// <summary>
	/// This interfaces extends the fsm interface <code>IInput</code> to provide inputsymbols
	/// for fsm transitions that hold the componentmodels interface and a signature of this interface.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/07/29 15:59:16  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	public interface IFSMSignatureCall : IInput
	{		
		/// <summary>
		/// returns the id of the interface
		/// </summary>
		IInterfaceIdentifier IFaceId
		{
			get;
		}

		/// <summary>
		/// returns the id of the signature
		/// </summary>
		ISignatureIdentifier SignatureId
		{
			get;
		}
	}
}
