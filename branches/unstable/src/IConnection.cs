using System;
using System.Collections;
using Palladio.Attributes;
using Palladio.Identifier;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Connects two interfaces of different componetens to each other.
	/// </summary>
	public interface IConnection : IAttributable, ICloneable, ISerializable, IIdentifiable
	{
		#region Properties

		/// <summary>
		/// Description of the services provided 
		/// by one of the compontents to the other.
		/// </summary>
		IRole ProvidingRole
		{ 
			get;
		}

		/// <summary>
		/// Description of the services required by one of the
		/// components from the other.
		/// </summary>
		IRole RequiringRole
		{ 
			get;
		}

		#endregion
	}
}