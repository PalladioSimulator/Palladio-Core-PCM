using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Connects the RequiresInterfaces of one component to the ProvidesInterfaces
	/// of another.
	/// </summary>
	public interface IComponentBinding : IComponentConnection
	{
		#region Properties

		/// <summary>
		/// Component providing several services.
		/// </summary>
		IComponent ProvComponent
		{
			get;
		}

		/// <summary>
		/// Component requiring the services of ProvComponent.
		/// </summary>
		IComponent ReqComponent
		{
			get;
		}

		/// <summary>
		/// The bindings between the interfaces of both components.
		/// </summary>
		IInterfaceBinding[] IfaceBindings
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
		bool CheckInteroperability ();

		/// <summary>
		/// Checks if the needs specified in the RequiresInterfaces can be fulfilled 
		/// by the ProvidesInterfaces.
		/// </summary>
		/// <param name="anErrorList">List of errors occured during the interoperability check.</param>
		/// <returns>True, if as much is provided as required.</returns>
		bool CheckInteroperability ( out IList anErrorList );

		#endregion
	}
}
