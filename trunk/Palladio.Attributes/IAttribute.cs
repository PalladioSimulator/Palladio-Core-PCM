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
	/// Revision 1.1  2005/02/21 13:05:49  joemal
	/// initial import
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IAttribute
	{
		//todo: both methods are removed in time
		void Serialize(System.Xml.XmlTextWriter writer);
		void Deserialize(System.Xml.XmlNode element);
	}
}
