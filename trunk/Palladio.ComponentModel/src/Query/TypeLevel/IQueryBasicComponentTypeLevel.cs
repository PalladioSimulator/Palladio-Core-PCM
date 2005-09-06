using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.Query.TypeLevel
{
	/// <summary>
	/// This interface defines several query methods to find the entities that are contained in and 
	/// belong to a basic component.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/09/06 15:01:05  joemal
	/// add query method for seffs
	///
	/// Revision 1.2  2005/07/30 15:43:48  joemal
	/// add basiccomponent queries (for seffs)
	///
	/// Revision 1.1  2005/04/18 08:50:50  joemal
	/// initial creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IQueryBasicComponentTypeLevel : IQueryComponentTypeLevel
	{
		/// <summary>
		/// called to return an array with ids of the seffs that are contained in the bc
		/// </summary>
		/// <returns>an array with seff ids that belong to the bc</returns>
		ISeffIdentifier[] GetServiceEffectSpecifications();

		/// <summary>
		/// called to query a seff from this basic component. The interface and signature must be specified. If no service
		/// effect specification can be found, null is returned. 
		/// </summary>
		/// <param name="ifaceId">the interface</param>
		/// <param name="sigId">the signature</param>
		/// <returns>the identifier of the service effect specification</returns>
		ISeffIdentifier GetServiceEffectSpecification(IInterfaceIdentifier ifaceId, ISignatureIdentifier sigId);
		
		/// <summary>
		/// returns true, if the seff with given id exists and belongs to the bc
		/// </summary>
		/// <param name="seffID">the id of the seff</param>
		/// <returns>true, if the seff belongs to the bc</returns>
		bool IsSeffFromBasicComponent(ISeffIdentifier seffID);
	}
}
