using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// </summary>
	public interface IRequiresMapping : IMapping
	{
		RequiresInterface InnerReqIFace 
		{ 
			get;
		}

		RequiresInterface OuterReqIFace 
		{ 
			get;
		}
	}
}
