using System;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// The RootBuilder for the component model. Allows to build sub-builders. This builder only allows
	/// to build the structure of the component model.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/17 18:30:35  kelsaka
	/// - added first builder-interfaces
	///
	/// </pre>
	/// </remarks>
	public interface IRootBuilder
	{
	
		/// <summary>
		/// Creates a new <see cref="IBasicComponentBuilder"/>, which allows to create new components.
		/// </summary>
		/// <returns>The new ComponentBuilder.</returns>
		IBasicComponentBuilder AddBasicComponent(string name);


		IBasicComponentBuilder AddCompositeComponent(string name);
		

		/// <summary>
		/// called to add an assemblyConnector from a requires interfaces of a component to a provides interface of 
		/// another component. Both components must have the same parent component or must be placed at the top level of the
		/// model.
		/// </summary>
		/// <param name="connection">the connection to be added</param>
		/// <param name="reqCompID">the id of the incoming component</param>
		/// <param name="reqIFaceID">the incoming components interface</param>
		/// <param name="provCompID">the id of the outgoing component</param>
		/// <param name="provIFaceID">the outgoing components interface</param>
		void AddAssemblyConnector(IConnection connection, IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID,
			IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID);

		



		/// <summary>
		/// Creates a new <see cref="IInterfaceBuilder"/>, which allows to create new interfaces.
		/// </summary>
		/// <returns>A new InterfaceBuilder.</returns>
		IInterfaceBuilder CreateInterface();






	}
}
