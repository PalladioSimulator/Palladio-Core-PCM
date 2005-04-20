using Palladio.Attributes;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// Interface implemented by all component model builders that create entities.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2005/04/20 21:02:35  kelsaka
	/// - added first methods for constraints
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
	/// Revision 1.1  2005/04/12 18:08:35  kelsaka
	/// - added events to builders
	///
	/// </pre>
	/// </remarks>
	public interface IEntityBuilder
	{
		#region methods

		/// <summary>
		/// Adds a <see cref="IAttribute"/> to the AttributeHash.
		/// </summary>
		/// <param name="attributeType">The attributes type to add.</param>
		/// <param name="attribute">The attribute to add.</param>
		void AddAttribute(IAttributeType attributeType, IAttribute attribute);

		/// <summary>
		/// Removes a <see cref="IAttribute"/> from the AttributeHash.
		/// </summary>
		/// <param name="attributeType">The attribute to remove.</param>
		void RemoveAttribute(IAttributeType attributeType);

		/// <summary>
		/// Adds the given EventHandler to listen for NameChangedEvents. These events are
		/// fired if the entities <see cref="Name"/> changes.
		/// </summary>
		/// <param name="nameChangedListener">The
		/// <see cref="StaticAttributeChangedEventHandler"/> to add.</param>
		void AddNameChangedEventHandler(StaticAttributeChangedEventHandler nameChangedListener);

		/// <summary>
		/// Removes the given EventHandler from listening for NameChangedEvents.
		/// </summary>
		/// <param name="nameChangedListener">The
		/// <see cref="StaticAttributeChangedEventHandler"/> to remove.</param>
		void RemoveNameChangedEventHandler(StaticAttributeChangedEventHandler nameChangedListener);

		#endregion

		#region properties

		/// <summary>
		/// Gets a copy (!) of the value of the attribute with the specified type.
		/// To change the value, get a copy, change it and then add it again to the table.
		/// </summary>
		IAttribute this [IAttributeType type] { get; }

		/// <summary>
		/// The name of the entity
		/// </summary>
		string Name { get; set; }

		#endregion		
	}
}
