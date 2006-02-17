using Palladio.Attributes;
using Palladio.ComponentModel.ModelEventManagement;
using Palladio.Identifier;

namespace Palladio.ComponentModel.ModelEntities.Impl
{
	/// <summary>
	/// This abstract class is the base class of all entities in the component model. It
	/// holds the name, the id and the attributehash of the entity.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/06/05 10:39:51  joemal
	/// remove unused method
	///
	/// Revision 1.2  2005/04/05 14:24:00  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.1  2005/03/15 12:31:37  joemal
	/// initial class creation
	///
	/// 
	/// </pre>
	/// </remarks>
	internal abstract class AbstractEntity : IComponentModelEntity
	{
		#region data

		//holds the name
		protected string name;

		//holds the attribute hashtable
		protected IAttributeHash attributeHash;

		//holds the id
		protected IIdentifier id;

		#endregion

		#region constructor

		/// <summary>
		/// called to create a new AbstractEntity
		/// </summary>
		/// <param name="name">the name of the entity</param>
		/// <param name="id">the id of the entity</param>
		public AbstractEntity(IIdentifier id, string name)
		{
			this.id = id;
			this.name = name;
			this.attributeHash = new DefaultAttributeHash();
		}

		#endregion

		#region properties

		/// <summary>
		/// The Identifier describing the identified object
		/// </summary>
		public virtual IIdentifier ID
		{
			get
			{
				return this.id;
			}
		}

		/// <summary>
		/// get or set the name of the entity
		/// </summary>
		public virtual string Name
		{
			get
			{
				return this.name;
			}

			set
			{
				this.name = value;
				if (NameChangedEvent != null) NameChangedEvent(this);
			}
		}

		/// <summary>
        /// return the attribute hashtable of the entity
        /// </summary>
		public IAttributeHash Attributes
		{
			get
			{
				return this.attributeHash;
			}
		}

		#endregion

		#region events

		/// <summary>
		/// has to be fired when the name is changed
		/// </summary>
		public event StaticAttributeChangedEventHandler NameChangedEvent;

		#endregion
	}
}
