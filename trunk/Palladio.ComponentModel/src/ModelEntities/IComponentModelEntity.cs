using System;
using Palladio.Attributes;
using Palladio.Identifier;

namespace Palladio.ComponentModel.ModelEntities
{
	/// <summary>
	/// This interface is the base interfaces of all entities of the componentmodel.
	/// </summary>
	public interface IComponentModelEntity : IIdentifiable, IAttributable
	{
		#region methods

		/// <summary>
		/// This methods has ever to be called, when attributes have been changed to update all observer of the models
		/// changes.
		/// </summary>
		void AttributesChanged();

		#endregion
	}
}
