using System;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;


namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// Builder for Composite Components.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/04/08 10:41:18  kelsaka
	/// - added return of IDs
	/// - added implementation of defined interfaces
	/// - redefined interfaces for builder-context
	/// - added CC-levels
	///
	/// Revision 1.2  2005/04/06 19:06:58  kelsaka
	/// - added new builder interfaces to support the levels of the component model
	/// - added basic set of methods to interfaces
	///
	/// Revision 1.1  2005/03/17 19:54:12  kelsaka
	/// - added builder-interfaces
	///
	/// </pre>
	/// </remarks>
	public interface ICompositeComponentBuilder : IComponentBuilder, ICompositeBaseBuilder
	{
		/// <summary>
		/// called to add a delegationconnector from the provides interface of an component to the provides 
		/// interface of an inner component.
		/// Creates a new connector.
		/// </summary>
		/// <param name="connectionName">the new connections name</param>
		/// <param name="outerIFaceID">the id of the outer component</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the inner components interface</param>
		void AddProvidesDelegationConnector(string connectionName,  
			IInterfaceIdentifier outerIFaceID, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID);


		/// <summary>
		/// called to add a delegationconnector from the requires interface of an component to the requires 
		/// interface of its parent component
		/// </summary>
		/// <param name="connectionName">the new connections name</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the inner components interface</param>
		/// <param name="outerIFaceID">the id of the outer component</param>
		void AddRequiresDelegationConnector(string connectionName, IComponentIdentifier innerCompID, 
			IInterfaceIdentifier innerIFaceID, IInterfaceIdentifier outerIFaceID);

	}
}
