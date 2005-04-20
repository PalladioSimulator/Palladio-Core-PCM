using System;
using Palladio.Attributes;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of a component model entity.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2005/04/20 17:55:54  kelsaka
	/// - added methods for deserialization
	///
	/// Revision 1.4  2005/04/15 08:29:46  kelsaka
	/// - fixed errors on xml-comments
	///
	/// Revision 1.3  2005/04/14 06:16:34  kelsaka
	/// - fixed bug on listening to name changed events.
	///
	/// Revision 1.2  2005/04/13 20:24:08  kelsaka
	/// - added enitity methods
	///
	/// Revision 1.1  2005/04/13 17:06:02  kelsaka
	/// - added further support for building signatures
	///
	/// </pre>
	/// </remarks>
	internal abstract class AbstractEntityBuilder : IEntityBuilder
	{
		#region data

		private string name;
		private IComponentModelEntity entity;

		#endregion

		#region methods

		/// <summary>
		/// Initializes the Builder. Has to be called by implementing members at construction time.
		/// </summary>
		/// <param name="entity">The enitity instance.</param>
		public void Init(IComponentModelEntity entity)
		{
			this.entity = entity;
		}

		/// <summary>
		/// Adds a <see cref="IAttribute"/> to the AttributeHash.
		/// </summary>
		/// <param name="attributeType">The attributes type to add.</param>
		/// <param name="attribute">The attribute to add.</param>
		public void AddAttribute (IAttributeType attributeType, IAttribute attribute)
		{
			entity.Attributes.Add(attributeType, attribute);			
		}

		/// <summary>
		/// Removes a <see cref="IAttribute"/> from the AttributeHash.
		/// </summary>
		/// <param name="attributeType">The attribute type to remove.</param>
		public void RemoveAttribute (IAttributeType attributeType)
		{
			entity.Attributes.Remove(attributeType);
		}

		/// <summary>
		/// Adds the given EventHandler to listen for NameChangedEvents. These events are
		/// fired if the entities <see cref="Name"/> changes.
		/// </summary>
		/// <param name="nameChangedListener">The
		/// <see cref="StaticAttributeChangedEventHandler"/> to add.</param>
		public void AddNameChangedEventHandler(StaticAttributeChangedEventHandler nameChangedListener)
		{
			this.entity.NameChangedEvent += new StaticAttributeChangedEventHandler(nameChangedListener);
		}

		/// <summary>
		/// Removes the given EventHandler from listening for NameChangedEvents.
		/// </summary>
		/// <param name="nameChangedListener">The
		/// <see cref="StaticAttributeChangedEventHandler"/> to remove.</param>
		public void RemoveNameChangedEventHandler(StaticAttributeChangedEventHandler nameChangedListener)
		{
			this.entity.NameChangedEvent -= new StaticAttributeChangedEventHandler(nameChangedListener);
		}

		#endregion

		#region Properties

		/// <summary>
		/// Gets a copy (!) of the value of the attribute with the specified type.
		/// To change the value, get a copy, change it and then add it again to the table.
		/// </summary>
		public IAttribute this [IAttributeType type]
		{
			get
			{
				return entity.Attributes[type];
			}
		}

		/// <summary>
		/// The name of the entity
		/// </summary>
		public string Name
		{
			get
			{
				return this.name;
			}
			set
			{
				this.name = value;
			}
		}

		#endregion		

	}
}
