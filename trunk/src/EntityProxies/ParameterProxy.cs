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
		/// <summary>
		/// </summary>
		protected IParameter _parameter;

		/// <summary>
		/// </summary>
		protected SignatureProxy _signature;

		/// <summary>
		/// </summary>
		private string _name;

		/// <summary>
		/// </summary>
		private string _type;

		#region Constructors
		/// <summary>
		/// 
		/// </summary>
		/// <param name="param"></param>
		/// <param name="signature"></param>
		public ParameterProxy(IParameter param, SignatureProxy signature)
		{
			this._parameter = param;
			this._signature = signature;
			this._name = param.Name;
			this._type = param.Type.ToString();
		}
		#endregion

		#region Public Properties
		/// <summary>
		/// 
		/// </summary>
		public override IIdentifier ID
		{
			get
			{
				return null;
			}
		}

		/// <summary>
		/// 
		/// </summary>
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
				this._signature.UpdateParameterList();
			}
		}

		/// <summary>
		/// 
		/// </summary>
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
			}
		}
		#endregion

		#region ICustomTypeDescriptor Member Overrides
		/// <summary>
		/// 
		/// </summary>
		/// <param name="attributes"></param>
		/// <returns></returns>
		public override PropertyDescriptorCollection GetProperties(Attribute[] attributes)
		{
			return GetProperties();
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
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

	/// <summary>
	/// 
	/// </summary>
	internal class ParameterProxyCollectionDescriptor : PropertyDescriptor
	{
		private ParameterProxyCollection collection = null;
		private int index = -1;

		/// <summary>
		/// 
		/// </summary>
		/// <param name="coll"></param>
		/// <param name="idx"></param>
		public ParameterProxyCollectionDescriptor(ParameterProxyCollection coll, int idx) : 
			base( "#"+idx.ToString(), null )
		{
			this.collection = coll;
			this.index = idx;
		} 

		/// <summary>
		/// 
		/// </summary>
		public override AttributeCollection Attributes
		{
			get 
			{ 
				return new AttributeCollection(null);
			}
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <returns></returns>
		public override bool CanResetValue(object component)
		{
			return true;
		}

		/// <summary>
		/// 
		/// </summary>
		public override Type ComponentType
		{
			get 
			{ 
				return this.collection.GetType();
			}
		}

		/// <summary>
		/// 
		/// </summary>
		public override string DisplayName
		{
			get 
			{
				return this.collection[index].Name;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		public override string Description
		{
			get
			{
				ParameterProxy param = this.collection[index];
				return param.Type+" "+param.Name;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <returns></returns>
		public override object GetValue(object component)
		{
			return this.collection[index];
		}

		/// <summary>
		/// 
		/// </summary>
		public override bool IsReadOnly
		{
			get { return false;  }
		}

		/// <summary>
		/// 
		/// </summary>
		public override string Name
		{
			get { return "#"+index.ToString(); }
		}

		/// <summary>
		/// 
		/// </summary>
		public override Type PropertyType
		{
			get { return this.collection[index].GetType(); }
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		public override void ResetValue(object component)
		{
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <returns></returns>
		public override bool ShouldSerializeValue(object component)
		{
			return true;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <param name="value"></param>
		public override void SetValue(object component, object value)
		{
			// this.collection[index] = value;
		}
	}
}
