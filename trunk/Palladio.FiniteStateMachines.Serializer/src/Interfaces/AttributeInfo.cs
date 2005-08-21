using Palladio.Attributes;

namespace Palladio.FiniteStateMachines.Serializer.Interfaces
{
	/// <summary>
	/// Structure that collects an <see cref="IAttribute"/> and its <see cref="IAttributeType"/>.
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/08/21 15:34:54  kelsaka
	/// - completed handling of attributes (deserialisation)
	///
	/// </code>
	/// </remarks>
	public struct AttributeInfo
	{
		private IAttribute attribute;
		private IAttributeType attributeType;
		
		/// <summary>
		/// Use this constructor, not the default constructor...
		/// </summary>
		/// <param name="attribute">The attribute to store.</param>
		/// <param name="attributeType">The attributeType to store.</param>
		public AttributeInfo(IAttribute attribute, IAttributeType attributeType) 
		{
			this.attribute = attribute;
			this.attributeType = attributeType;
		}

		/// <summary>
		/// Read the internal Attribute.
		/// </summary>
		public IAttribute Attribute
		{
			get
			{
				return this.attribute;
			}
		}

		/// <summary>
		/// Read the internal AttributeType
		/// </summary>
		public IAttributeType AttributeType
		{
			get
			{
				return this.attributeType;
			}
		}
	}
}
