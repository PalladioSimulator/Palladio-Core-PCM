using System;
using System.ComponentModel;
using Palladio.Attributes;

namespace Palladio.Editor.Common
{
	/// <summary>
	/// Zusammenfassung für AbstractAttribute.
	/// </summary>
	[TypeConverter(typeof(AbstractAttributeConverter))]
	public abstract class AbstractAttribute : IAttribute
	{
		public AbstractAttribute()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}
		#region IAttribute Member

		public abstract void Serialize(System.Xml.XmlTextWriter writer);

		public abstract void Deserialize(System.Xml.XmlNode element);
		#endregion
	}

	public class AbstractAttributeConverter : TypeConverter
	{
		public override object ConvertTo(ITypeDescriptorContext context, System.Globalization.CultureInfo culture, object value, Type destType )
		{
			return ((AbstractAttributeTypeDescriptor)context.PropertyDescriptor).TypeConverter.ConvertTo(context,culture,value,destType);
		}

		public override object ConvertFrom(ITypeDescriptorContext context, System.Globalization.CultureInfo culture, object value)
		{
			return ((AbstractAttributeTypeDescriptor)context.PropertyDescriptor).TypeConverter.ConvertFrom(context,culture,value);
		}


		public override bool CanConvertFrom(ITypeDescriptorContext context, Type sourceType)
		{
			return ((AbstractAttributeTypeDescriptor)context.PropertyDescriptor).TypeConverter.CanConvertFrom(context, sourceType);
		}

		public override bool CanConvertTo(ITypeDescriptorContext context, Type destinationType)
		{
			return ((AbstractAttributeTypeDescriptor)context.PropertyDescriptor).TypeConverter.CanConvertTo(context, destinationType);
		}

	}
}
