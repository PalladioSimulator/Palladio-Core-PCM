using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.Query.TypeLevel
{
	/// <summary>
	/// This interface defines several query methods to find the entities that are contained in and 
	/// belong to a composite component.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/05/08 12:04:23  joemal
	/// implementation of xml serialization
	///
	/// Revision 1.2  2005/04/19 16:47:41  joemal
	/// implement query methods
	///
	/// Revision 1.1  2005/04/18 08:50:50  joemal
	/// initial creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IQueryCompositeComponentTypeLevel : IQueryComponentTypeLevel
	{
		/// <summary>
		/// returns the ids of the components that are contained in this component.
		/// </summary>
		/// <returns>the ids of the components</returns>
		IComponentIdentifier[] GetComponents();

		/// <summary>
		/// returns true, if the component that belongs to given id is part of this component
		/// </summary>
		/// <param name="compID">the id of the component</param>
		/// <returns>true, if the component that belongs to the given id is part of this component.</returns>
		bool IsChildren(IComponentIdentifier compID);

		/// <summary>
		/// returns the ids of the connections that are contained in this component.
		/// </summary>
		/// <returns>the ids of the connections</returns>
		IConnectionIdentifier[] GetConnections();

		/// <summary>
		/// returns true, if the connection that belongs to given id is part of this component.
		/// </summary>
		/// <param name="connectionID">the id of the connection</param>
		/// <returns>true, if the connection that belongs to given id is part of this component</returns>
		bool IsConnectionFromComponent(IConnectionIdentifier connectionID);

		/// <summary>
		/// returns the identifier of the provides delegation that connects this components interface with
		/// the inner components interface.
		/// </summary>
		/// <param name="outerIfaceID">the id of this components provides interface</param>
		/// <param name="innerCompID">the id the inner component</param>
		/// <param name="innerIfaceID">the id of the inner components provides interface</param>
		/// <returns>the id of the connection</returns>
		IConnectionIdentifier GetProvidesDelegationConnector(IInterfaceIdentifier outerIfaceID,
			IComponentIdentifier innerCompID, IInterfaceIdentifier innerIfaceID);

		/// <summary>
		/// returns the identifier of the requires delegation that connects this components interface with
		/// the inner components interface.
		/// </summary>
		/// <param name="outerIfaceID">the id of this components requires interface</param>
		/// <param name="innerCompID">the id the inner component</param>
		/// <param name="innerIfaceID">the id of the inner components requires interface</param>
		/// <returns>the id of the connection</returns>
		IConnectionIdentifier GetRequiresDelegationConnector(IInterfaceIdentifier outerIfaceID,
			IComponentIdentifier innerCompID, IInterfaceIdentifier innerIfaceID);

		/// <summary>
		/// called to return the assembly connector that connects the two given components.
		/// </summary>
		/// <param name="reqCompID">the id of the requiring component</param>
		/// <param name="reqIFaceID">the id of the requires interface</param>
		/// <param name="provCompID">the id of the provides component</param>
		/// <param name="provIFaceID">the id of the provides interface</param>
		/// <returns>the id of the connection</returns>
		IConnectionIdentifier GetAssemblyConnector(IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID,
			IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID);

		/// <summary>
		/// returns the ids of all basic components that are contained in this composite component
		/// </summary>
		/// <returns>the ids</returns>
		IComponentIdentifier[] getBasicComponents();

		/// <summary>
		/// returns the ids of all composite components that are contained in this composite component
		/// </summary>
		/// <returns>the ids</returns>
		IComponentIdentifier[] getCompositeComponents();
	}
}
