using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// </summary>
	public interface IProvidesMapping : IMapping
	{
		ProvidesInterface InnerProvIFace 
		{ 
			get;
		}

		ProvidesInterface OuterProvIFace 
		{ 
			get;
		}
	}
}
