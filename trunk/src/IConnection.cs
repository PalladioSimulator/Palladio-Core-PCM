using System;
using System.Collections;

namespace ComponentModel {
	/// <summary>
	/// General representation of connection between two interfaces.
	/// </summary>
	public interface IConnection {

		/// <summary>
		/// Checks if the interfaces are compatible with each other. 
		/// Interoperability depends on the specific roles of both 
		/// IInterfaceModels.
		/// </summary>
		/// <returns>
		/// True if the IInterfaceModel match, false otherwise.
		/// </returns>
		bool CheckInteroperability ();

		/// <summary>
		/// Checks if the interfaces are compatible with each other. 
		/// Interoperability depends on the specific roles of both 
		/// IInterfaceModels.
		/// </summary>
		/// <param name="anErrorList">
		/// List of IInterOperabilityErrors found during the check.
		/// </param>
		/// <returns>
		/// True if the IInterfaceModel match, false otherwise.
		/// </returns>
		bool CheckInteroperability ( out IList anErrorList );

		
		/// <summary>
		/// Returns an IInterfaceModel representing the lowest common denominator
		/// of both IInterfaceModels involved in the connection.
		/// </summary>
		/// <returns>
		/// IInterfaceModel of highest possible level.
		/// </returns>
		IInterfaceModel GetIntersection ();
	}
}
