using System;
using System.Collections;
using Palladio.Attributes;
using Palladio.Identifier;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// An IInterfaceModel is the description of an interface (of a component).
	/// In our case an interface is a set of signatures
	/// which can be somehow related to each other.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 13:50:51  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface IInterfaceModel : ICloneable, IAttributable, IIdentifiable, ISerializable
	{
		/// <summary>
		/// The name of the IInterfaceModel
		/// </summary>
		string Name { get; set; }

		/// <summary>
		/// A list of signatures contained in this IInterfaceModel
		/// </summary>
		ISignatureList SignatureList
		{
			get;
		}
		
		/// <summary>
		/// Additional specification data like FSMs, Petri Nets, ....
		/// </summary>
		IProtocolInformation[] ProtocolInformations
		{
			get;
		}
		
		/// <summary>
		/// Add a new specification aspect to this interface, like a protocol spec.
		/// </summary>
		/// <param name="info">Additional specification data</param>
		void AddProtocolInformation(IProtocolInformation info);

		/// <summary>
		/// Get the additional information from given type
		/// </summary>
		/// <param name="type">Type of the additional information to retrieve</param>
		/// <returns>The requested information or an exception if the information is not
		/// available</returns>
		IProtocolInformation GetProtocolInformation(System.Type type);
	}
}