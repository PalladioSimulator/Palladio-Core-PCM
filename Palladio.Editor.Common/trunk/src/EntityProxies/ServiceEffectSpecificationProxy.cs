using System.Drawing.Design;
using System;
using System.Text;
using System.ComponentModel;

using Palladio.ComponentModel;
using Palladio.Identifier;
using Palladio.Editor.Common.Commands;
using Palladio.Editor.Common.EntityProxies.Collections;
using Palladio.Editor.Common.EntityProxies.UITypeEditors;

namespace Palladio.Editor.Common.EntityProxies
{
	/// <summary>
	/// Zusammenfassung für ServiceEffectSpecificationProxy.
	/// </summary>
	[TypeConverter(typeof(UITypeEditors.ServiceEffectTypeConverter))]
	public class ServiceEffectSpecificationProxy : EntityProxy
	{
		private IServiceEffectSpecification _serviceEffect;
		private IService _service;

		private SignatureProxyCollection _requiredServices;
		private BasicComponentProxy _component;

		private SignatureProxy _lastAddedService;

		
		public ServiceEffectSpecificationProxy(IServiceEffectSpecification sef, BasicComponentProxy comp, IService service, CommandHandler sefCmdHandler, AttributeProvider attrProv)
			: base(sefCmdHandler, sef, attrProv)
		{
			this._serviceEffect = sef;
			this._service = service;
			this._component = comp;

			this._requiredServices = new SignatureProxyCollection();
			//this._signatures.AddRange(signatures);
		}

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
		TypeConverter(typeof(SignatureListTypeConverter)),
		Editor(typeof(ServiceListEditor), typeof(UITypeEditor)),
		Category("Service List"),
		DescriptionAttribute("A list of required services.") ]
		public SignatureProxyCollection ServiceList
		{
			get
			{
				return this._requiredServices;
			}
		}

		public BasicComponentProxy Component
		{
			get
			{
				return this._component;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		public IIdentifier InterfaceID
		{
			get
			{ 
				return this._service.Interface.ID;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		public IIdentifier SignatureID
		{
			get
			{
				return this._service.Signature.ID;
			}
		}

		public string DisplayName
		{
			get
			{
				StringBuilder sb = new StringBuilder();
				sb.Append(this._service.Interface.Name);
				sb.Append(".");
				sb.Append(this._service.Signature.Name);
				sb.Append("(");
				for(int i = 0; i < this._service.Signature.Parameters.Length; i++)
				{
					if (i > 0)
						sb.Append(", ");
					sb.Append(this._service.Signature.Parameters[i].Type);
					sb.Append(" ");
					sb.Append(this._service.Signature.Parameters[i].Name);
				}
				sb.Append(") ");
				return sb.ToString();
			}
		}

		public void AddServiceToServiceList(SignatureProxy sig)
		{	
			this._lastAddedService = sig;
			this._component.AddServiceToServiceEffectSpecification(this, sig);
		}

		public void AddServiceToServiceList(IService service)
		{
			AddServiceToServiceEffectCmd command = new AddServiceToServiceEffectCmd(this._serviceEffect, service, this._lastAddedService);
			this.FireCommandIssued( command );
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

			foreach (PropertyDescriptor pd in base.GetProperties())
				pds.Add(pd);

			pds.Add(TypeDescriptor.GetProperties(this, true)["ServiceList"]);

			return pds;
		}
		#endregion
	}

	/// <summary>
	/// 
	/// </summary>
	internal class ServiceEffectSpecificationProxyDescriptor : PropertyDescriptor
	{
		private ServiceEffectSpecificationProxyCollection collection = null;
		private int index = -1;

		public ServiceEffectSpecificationProxyDescriptor(ServiceEffectSpecificationProxyCollection coll, int idx) : 
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
				return this.collection[index].DisplayName;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		public override string Description
		{
			get
			{
				return "The Service Effect Specification for "+this.collection[index].DisplayName;
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
