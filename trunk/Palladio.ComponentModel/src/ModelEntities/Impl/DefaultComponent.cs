using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.ModelEntities.Impl
{
	/// <summary>
	/// Default Component class. The component has a name, an id, a type and an attribute hashmap.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/15 12:31:37  joemal
	/// initial class creation
	///
	/// 
	/// </pre>
	/// </remarks>
	internal class DefaultComponent : AbstractEntity, IComponent
	{
		#region Properties

		/// <summary>
		/// returns the typed id of this component
		/// </summary>
		public IComponentIdentifier ComponentID
		{
			get
			{
				return (IComponentIdentifier) id;
			}
		}

		/// <summary>
		/// set or get the type of the component
		/// </summary>
		public ComponentType Type
		{
			get
			{
				return this.type;
			}
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a component from given type with given name and given id. 
		/// </summary>
		/// <param name="aID">ID of the component</param>
		/// <param name="name">the name of the component</param>
		/// <param name="type">the type of the component</param>
		public DefaultComponent(IComponentIdentifier aID, ComponentType type, string name) : base(aID,name)
		{
			this.type = type;
		}		

		#endregion

		#region Data

		//holds the type of the component
		private ComponentType type;

		#endregion
	}
}