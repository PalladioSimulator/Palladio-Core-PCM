using System;
using System.Collections;
using ReflectionBasedVisitor;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Connects the RequiresInterface of one component to the ProvidesInterfaces
	/// of another.
	/// </summary>
	public interface IBinding : IConnection, IVisitable
	{
		#region Properties

		/// <summary>
		/// Description of the services provided 
		/// by one of the compontents to the other.
		/// </summary>
		AttachedInterface ProvidesInterface
		{ 
			get;
		}

		/// <summary>
		/// Description of the services required by one of the
		/// components from the other.
		/// </summary>
		AttachedInterface RequiresInterface
		{ 
			get;
		}

		#endregion
	}
}
