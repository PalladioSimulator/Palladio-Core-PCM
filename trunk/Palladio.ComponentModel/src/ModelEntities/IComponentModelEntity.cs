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
	}
}
