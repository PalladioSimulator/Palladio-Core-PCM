using System;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of a component model entity.
	/// <summary>
	/// 
	/// </summary>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/13 17:06:02  kelsaka
	/// - added further support for building signatures
	///
	/// </pre>
	/// </remarks>
	public abstract class AbstractEntityBuilder : IEntityBuilder
	{
		#region data

		private string name;

		#endregion

		#region methods

		/// <summary>
		/// Initializes the Builder. Has to be called by implementing members at construction time.
		/// </summary>
		/// <param name="name"></param>
		public void Init(string name)
		{
		}

		#endregion

		#region Properties

		/// <summary>
		/// The name of the entity
		/// </summary>
		public string Name
		{
			get { return this.name; }
			set { this.name = value; }
		}

		#endregion

		/// <summary>
		/// has to be fired when the name is changed
		/// </summary>
		public event StaticAttributeChangedEventHandler NameChangedEvent;
	}
}
