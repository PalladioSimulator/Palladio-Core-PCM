using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Connects the RequiresInterfaces of one component to the ProvidesInterfaces
	/// of another.
	/// </summary>
	public interface IInterfaceBinding : IInterfaceConnection
	{
		#region Properties

		/// <summary>
		/// Description of the services provided 
		/// by one of the compontents to the other.
		/// </summary>
		ProvidesInterface ProvIface 
		{ 
			get;
		}

		/// <summary>
		/// Description of the services required by one of the
		/// components from the other.
		/// </summary>
		RequiresInterface ReqIface 
		{ 
			get;
		}
		#endregion

		#region Methods

		/// <summary>
		/// Checks if the needs specified in the RequiresInterfaces can be fulfilled 
		/// by the ProvidesInterfaces.
		/// </summary>
		/// <returns>True, if as much is provided as required.</returns>
		bool CheckInteroperability();

		/// <summary>
		/// Checks if the needs specified in the RequiresInterfaces can be fulfilled 
		/// by the ProvidesInterfaces.
		/// </summary>
		/// <param name="anErrorList">List of errors occured during the interoperability check.</param>
		/// <returns>True, if as much is provided as required.</returns>
		bool CheckInteroperability(out IList anErrorList) ;

		#endregion
	}
}
