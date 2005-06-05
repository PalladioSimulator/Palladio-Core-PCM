using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.Identifier;

namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This interface defines methods to query all events that are provides by the componentmodel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/06/05 10:40:06  joemal
	/// - components now can be added to more than one container
	///
	/// Revision 1.1  2005/03/29 13:05:37  joemal
	/// initial class creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IEventInterface
	{
		/// <summary>
		/// called to register to one of the repository events
		/// </summary>
		/// <returns>the class that holds the events of the repository</returns>
		RepositoryEvents GetRepositoryEvents();

		/// <summary>
		/// called to register to one of the static view's events
		/// </summary>
		/// <returns>the class that holds the events of the static view</returns>
		StaticViewEvents GetStaticViewEvents();

		/// <summary>
		/// called to register to one of the events of the componentmodels entities
		/// </summary>
		/// <param name="entityID">the id of the entity</param>
		/// <returns>the class that holds the events of an entity</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		EntityEvents GetEntityEvents(IIdentifier entityID);

		/// <summary>
		/// called to register to one of the events of a component
		/// </summary>
		/// <param name="componentID">the id of the component</param>
		/// <returns>the class that holds the events of a component</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		ComponentEvents GetComponentEvents(IComponentIdentifier componentID);

		/// <summary>
		/// called to register to one of the events of a composite component
		/// </summary>
		/// <param name="ccID">the id of the composite component</param>
		/// <returns>the class that holds the events of a composite component</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		/// <exception cref="WrongComponentTypeException">the component with given id is not a composite component</exception>
		CompositeComponentEvents GetCompositeComponentEvents(IComponentIdentifier ccID);

		/// <summary>
		/// called to register to one of the events of a basic component
		/// </summary>
		/// <param name="bcID">the id of the basic component</param>
		/// <returns>the class that holds the events of a basic component</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		/// <exception cref="WrongComponentTypeException">the component with given id is not a basic component</exception>
		BasicComponentEvents GetBasicComponentEvents(IComponentIdentifier bcID);

		/// <summary>
		/// called to register to one of the events of an interface
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		/// <returns>the class that holds the events of an interface</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		InterfaceEvents GetInterfaceEvents(IInterfaceIdentifier ifaceID);

		/// <summary>
		/// called to register to one of the events of a signature
		/// </summary>
		/// <param name="sigID">the id of the signature</param>
		/// <returns>the class that holds the events of a signature</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		SignatureEvents GetSignatureEvents(ISignatureIdentifier sigID);
		
		/// <summary>
		/// called to register to one of the events of a connection
		/// </summary>
		/// <param name="conID">the id of the connection</param>
		/// <returns>the class that holds the events of a connection</returns>
		/// <exception cref="EntityNotFoundException">the entity with given id could not be found in cm</exception>
		ConnectionEvents GetConnectionEvents(IConnectionIdentifier conID);
	}
}
