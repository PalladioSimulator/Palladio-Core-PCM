using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.ModelEntities
{
	/// <summary>
	/// A Component in the componentmodel has a name, an id and a hashtable of attributes.
	/// The component can be from type composite meaning that it may be the parent of other components. The type
	/// basic makes a component not to contain any other component but implementation specifications of the services.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/15 12:31:23  joemal
	/// initial class creation
	///
	///
	/// </pre>
	/// </remarks>
	public interface IComponent : IComponentModelEntity
	{
		/// <summary>
		/// returns the typed id of the component
		/// </summary>
		IComponentIdentifier ComponentID {get;}

		/// <summary>
		/// set or get the name of the component
		/// </summary>
		string Name { get; set; }

		/// <summary>
		/// set or get the type of the component
		/// </summary>
		ComponentType Type {get;}
	}

	/// <summary>
	/// this declares the two types of a component
	/// </summary>
	public enum ComponentType
	{
		/// <summary>
		/// the component is a basic component
		/// </summary>
		BASIC,
		/// <summary>
		/// the component is a composite component
		/// </summary>
		COMPOSITE
	};
}
