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
	/// Revision 1.6  2005/04/23 11:00:44  kelsaka
	/// - removed Init-Methods from AbstractBuilder - created constructors
	///
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

		#region constructors

		/// <summary>
		/// Initializes the Builder.
		/// </summary>
		/// <param name="entity">The enitity instance.</param>
		public AbstractEntityBuilder(IComponentModelEntity entity)
		{
			this.entity = entity;
		}

		#endregion

		#region methods

		#endregion

		#region Properties

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
