using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// </summary>
	public class NoBindingFoundException : Exception
	{
		public NoBindingFoundException(RequiresInterface aReqIFace) : 
			base ("No binding found for: "+aReqIFace.Name)
		{
		}
	}
}
