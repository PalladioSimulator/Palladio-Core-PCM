using Palladio.ComponentModel.Identifier;
using Palladio.Identifier;

namespace Palladio.ComponentModel.ModelEntities
{
	/// <summary>
	/// Declares a service effect specification like FSMs that can be added to a basic component.
	/// Service effect specifications belong to an interface and a signature of this 
	/// interface. More than one seff can be added to one signature. 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2005/07/29 16:00:56  joemal
	/// initial creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public interface IServiceEffectSpecification : IIdentifiable
	{
		/// <summary>
		/// returns the typed id of the seff
		/// </summary>
		ISeffIdentifier SeffID
		{
			get;
		}

		/// <summary>
		/// returns the type id of the seff. 
		/// </summary>
		ISeffTypeIdentifier SeffTypeID
		{
			get;
		}
	}
}
