using Palladio.ComponentModel.Identifier;
using Palladio.Identifier;

namespace Palladio.ComponentModel.ModelEntities
{
	/// <summary>
	/// A Protocol is an additional specification data attached to a certain
	/// interface. For example protocols specified by the means
	/// of FSMs, Petri Nets, .... or constraints given as pre- and postconditions or
	/// OCL constraints.<br />
	/// Implement this interface if you want to add further additional specification data
	/// to an interface.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2005/05/08 12:04:23  joemal
	/// implementation of xml serialization
	///
	/// Revision 1.1  2005/03/15 12:31:23  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public interface IProtocol : IIdentifiable
	{
		/// <summary>
		/// returns the typed id of the protocol
		/// </summary>
		IProtocolIdentifier ProtocolID
		{
			get;
		}

		/// <summary>
		/// returns the id of the type of protocol (fsm, ...)
		/// </summary>
		IProtocolTypeIdentifier ProtocolTypeID
		{
			get;
		}
	}
}
