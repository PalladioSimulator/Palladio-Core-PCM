#region Universität Oldenburg
//////////////////////////////////////////////////////////////////////////
//	Universität Oldenburg
//	Department für Informatik, Software Engineering
//	-----------------------------------------------------------------
//	Master-Arbeit "Entwicklung eines Editors für die modellgetriebene
//	Konstruktion komponentenbasierter Software-Architekturen"
//	Autor: Matthias Uflacker, 2004
//	eMail: matthias.uflacker@informatik.uni-oldenburg.de
//////////////////////////////////////////////////////////////////////////
#endregion

using System;
using System.Collections;
using System.Text;
using System.ComponentModel; 

using Palladio.Editor.Common.EntityProxies.Collections;

namespace Palladio.Editor.Common.EntityProxies.UITypeEditors
{
	/// <summary>
	/// Zusammenfassung für InterfaceTypeConverter.
	/// </summary>
	internal class InterfaceTypeConverter : ExpandableObjectConverter
	{
		public override object ConvertTo(ITypeDescriptorContext context, System.Globalization.CultureInfo culture, object value, Type destType )
		{
			if( destType == typeof(string) && value is InterfaceProxy )
			{
				return ((InterfaceProxy)value).Name;
			}
			return base.ConvertTo(context,culture,value,destType);
		}
	}

	/// <summary>
	/// Zusammenfassung für ComponentTypeConverter.
	/// </summary>
	internal class ComponentTypeConverter : TypeConverter
	{
		public override object ConvertTo(ITypeDescriptorContext context, System.Globalization.CultureInfo culture, object value, Type destType )
		{
			if( destType == typeof(string) && value is ComponentProxy )
			{
				return ((ComponentProxy)value).Name;
			}
			return base.ConvertTo(context,culture,value,destType);
		}
	}

	/// <summary>
	/// Zusammenfassung für RoleTypeConverter.
	/// </summary>
	internal class RoleTypeConverter : TypeConverter
	{
		public override object ConvertTo(ITypeDescriptorContext context, System.Globalization.CultureInfo culture, object value, Type destType )
		{
			if( destType == typeof(string) && value is RoleProxy )
			{
				return ((RoleProxy)value).Name;
			}
			return base.ConvertTo(context,culture,value,destType);
		}
	}

	/// <summary>
	/// Zusammenfassung für SignatureListTypeConverter.
	/// </summary>
	internal class SignatureListTypeConverter : ExpandableObjectConverter
	{
		public override object ConvertTo(ITypeDescriptorContext context, System.Globalization.CultureInfo culture, object value, Type destType )
		{
			if( destType == typeof(string) && value is SignatureProxyCollection )
			{
				return "List of Services...";
			}
			return base.ConvertTo(context,culture,value,destType);
		}
	}

	/// <summary>
	/// Zusammenfassung für SignatureTypeConverter.
	/// </summary>
	internal class SignatureTypeConverter : ExpandableObjectConverter
	{
		public override object ConvertTo(ITypeDescriptorContext context, System.Globalization.CultureInfo culture, object value, Type destType )
		{
			if( destType == typeof(string) && value is SignatureProxy )
			{
				SignatureProxy sig = value as SignatureProxy;
				StringBuilder sb = new StringBuilder();
				sb.Append("(");
				for(int i = 0; i < sig.Parameters.Count; i++)
				{
					if (i > 0)
						sb.Append(", ");
					sb.Append(sig.Parameters[i].Type);
					sb.Append(" ");
					sb.Append(sig.Parameters[i].Name);
				}
				sb.Append(") ");
				return sb.ToString();
			}
			return base.ConvertTo(context,culture,value,destType);
		}
	}

	/// <summary>
	/// Zusammenfassung für ParameterListTypeConverter.
	/// </summary>
	internal class ParameterListTypeConverter : ExpandableObjectConverter
	{
		public override object ConvertTo(ITypeDescriptorContext context, System.Globalization.CultureInfo culture, object value, Type destType )
		{
			if( destType == typeof(string) && value is ParameterProxyCollection )
			{
				return "List of Parameters...";
			}
			return base.ConvertTo(context,culture,value,destType);
		}
	}

	/// <summary>
	/// Zusammenfassung für ParameterTypeConverter.
	/// </summary>
	internal class ParameterTypeConverter : ExpandableObjectConverter
	{
		public override object ConvertTo(ITypeDescriptorContext context, System.Globalization.CultureInfo culture, object value, Type destType )
		{
			if( destType == typeof(string) && value is ParameterProxy )
			{
				return "-";
			}
			return base.ConvertTo(context,culture,value,destType);
		}
	}

	internal class AttributeHashtableTypeConverter : ExpandableObjectConverter
	{
		public override object ConvertTo(ITypeDescriptorContext context, System.Globalization.CultureInfo culture, object value, Type destType )
		{
			if( destType == typeof(string) && value is AttributeHashtable )
			{
				return "Attached Attributes...";
			}
			return base.ConvertTo(context,culture,value,destType);
		}
	}

	/// <summary>
	/// Zusammenfassung für ServiceEffectListTypeConverter.
	/// </summary>
	internal class ServiceEffectListTypeConverter : ExpandableObjectConverter
	{
		public override object ConvertTo(ITypeDescriptorContext context, System.Globalization.CultureInfo culture, object value, Type destType )
		{
			if( destType == typeof(string) && value is ServiceEffectSpecificationProxyCollection )
			{
				return "List of Service Effects";
			}
			return base.ConvertTo(context,culture,value,destType);
		}
	}

	/// <summary>
	/// Zusammenfassung für ServiceEffectListTypeConverter.
	/// </summary>
	internal class ServiceEffectTypeConverter : ExpandableObjectConverter
	{
		public override object ConvertTo(ITypeDescriptorContext context, System.Globalization.CultureInfo culture, object value, Type destType )
		{
			if( destType == typeof(string) && value is ServiceEffectSpecificationProxyCollection )
			{
				return "bluz";
			}
			return base.ConvertTo(context,culture,value,destType);
		}
	}
}
