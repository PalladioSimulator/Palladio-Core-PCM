using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Connection between a requires interface of component A and
	/// a provides interface of component B. Both components stand on
	/// the same level. (none is including the other)
	/// </summary>
	public interface IBinding : IConnection
	{
		/// <summary>
		/// Provides interface of component B.
		/// </summary>
		ProvidesInterface ProvIFace 
		{ 
			get;
		}

		/// <summary>
		/// Component B. Owner of the provides interface.
		/// </summary>
		IComponent ProvComp 
		{ 
			get;
		}

		/// <summary>
		/// Requires interface of component A.
		/// </summary>
		RequiresInterface ReqIFace 
		{ 
			get;
		}

		/// <summary>
		/// Component A. Owner of the requires interface.
		/// </summary>
		IComponent ReqComp 
		{ 
			get;
		}

		bool CheckInteroperability ();

		bool CheckInteroperability ( out IList anErrorList );
		
	}
}
