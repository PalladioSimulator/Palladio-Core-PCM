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
using System.ComponentModel;

using Palladio.Identifier;
using Palladio.ComponentModel;
using Palladio.Editor.Common.EntityProxies.Collections;

namespace Palladio.Editor.Common.EntityProxies
{
	/// <summary>
	/// Zusammenfassung für ParameterProxy.
	/// </summary>
	[TypeConverter(typeof(UITypeEditors.ParameterTypeConverter))]
	public class ParameterProxy : EntityProxy, ICustomTypeDescriptor
	{
		protected IParameter _parameter;

		private string _name;
		private string _type;

		public ParameterProxy(IParameter param)
		{
			this._parameter = param;
			this._name = param.Name;
			this._type = param.Type.ToString();

		}

		public override IIdentifier ID
		{
			get
			{
				return null;
			}
		}

		[ ReadOnly(false),
		TypeConverter(typeof(StringConverter)),
		Category("Default"),
		DescriptionAttribute("The name of the parameter.") ]
		public string Name
		{
			get
			{
				return this._name;
			}
			set
			{
				this._name = value;
//				base.FireEntityChanged(
//					this, 
//					new EventArgs(EntityChangeReason.PROPERTY_CHANGED, null) );
			}
		}

		[ ReadOnly(false),
		TypeConverter(typeof(StringConverter)),
		Category("Default"),
		DescriptionAttribute("The type of the parameter.") ]
		public string Type
		{
			get
			{
				return this._type;
			}
			set
			{
				this._type = value;
//				base.FireEntityChanged(
//					this, 
//					new EventArgs(EntityChangeReason.PROPERTY_CHANGED, null) );
			}
		}

		#region ICustomTypeDescriptor Member Overrides

		public override PropertyDescriptorCollection GetProperties(Attribute[] attributes)
		{
			return GetProperties();
		}

		public override PropertyDescriptorCollection GetProperties()
		{
			// Create a new collection object PropertyDescriptorCollection
			PropertyDescriptorCollection pds = new PropertyDescriptorCollection(null);

			pds.Add(TypeDescriptor.GetProperties(this, true)["Name"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["Type"]);

			return pds;
		}

		#endregion
	}

	internal class ParameterProxyCollectionDescriptor : PropertyDescriptor
	{
		private ParameterProxyCollection collection = null;
		private int index = -1;

		public ParameterProxyCollectionDescriptor(ParameterProxyCollection coll, int idx) : 
			base( "#"+idx.ToString(), null )
		{
			this.collection = coll;
			this.index = idx;
		} 

		public override AttributeCollection Attributes
		{
			get 
			{ 
				return new AttributeCollection(null);
			}
		}

		public override bool CanResetValue(object component)
		{
			return true;
		}

		public override Type ComponentType
		{
			get 
			{ 
				return this.collection.GetType();
			}
		}

		public override string DisplayName
		{
			get 
			{
				return this.collection[index].Name;
			}
		}

		public override string Description
		{
			get
			{
				ParameterProxy param = this.collection[index];
				return param.Type+" "+param.Name;
			}
		}

		public override object GetValue(object component)
		{
			return this.collection[index];
		}

		public override bool IsReadOnly
		{
			get { return false;  }
		}

		public override string Name
		{
			get { return "#"+index.ToString(); }
		}

		public override Type PropertyType
		{
			get { return this.collection[index].GetType(); }
		}

		public override void ResetValue(object component)
		{
		}

		public override bool ShouldSerializeValue(object component)
		{
			return true;
		}

		public override void SetValue(object component, object value)
		{
			// this.collection[index] = value;
		}
	}
}
