using System;

namespace Palladio.Attributes
{
	/// <summary>
	/// This is the base interface of an attribute. 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/04/05 14:30:39  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.2  2005/02/24 20:13:06  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:05:49  joemal
	/// initial import
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IAttribute: ICloneable
	{
	}
}
