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
using System.Drawing.Design;

using Palladio.Identifier; 
using Palladio.ComponentModel;
using Palladio.Editor.Common.Commands;
using Palladio.Editor.Common.EntityProxies.Collections;
using Palladio.Editor.Common.EntityProxies.UITypeEditors;

namespace Palladio.Editor.Common.EntityProxies
{
	/// <summary>
	/// Zusammenfassung für BasicComponentProxy.
	/// </summary>
	public class BasicComponentProxy : ComponentProxy
	{
		/// <summary>
		/// </summary>
		protected new IBasicComponent _component;

		private ServiceEffectSpecificationProxyCollection _serviceEffects;

		#region Constructors
		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <param name="cmdHandler"></param>
		/// <param name="provided"></param>
		/// <param name="required"></param>
		/// <param name="serviceEffects"></param>
		/// <param name="attrProv"></param>
		public BasicComponentProxy(
			IBasicComponent component, 
			CommandHandler cmdHandler, 
			RoleProxy[] provided, 
			RoleProxy[] required, 
			ServiceEffectSpecificationProxy[] serviceEffects, 
			AttributeProvider attrProv)
			: base(component, cmdHandler, provided, required, attrProv)
		{
			this._component = component;

			this._serviceEffects = new ServiceEffectSpecificationProxyCollection();
			this._serviceEffects.AddRange(serviceEffects);
		}
		#endregion


		/// <summary>
		/// 
		/// </summary>
		[ ReadOnly(false),
		TypeConverter(typeof(ServiceEffectListTypeConverter)),
		Editor(typeof(ServiceEffectSpecificationProxyCollectionTypeEditor), typeof(UITypeEditor)),
		Category("Service Effects"),
		DescriptionAttribute("A list service effect specifications") ]
		public ServiceEffectSpecificationProxyCollection ServiceEffects
		{
			get
			{
				return this._serviceEffects;
			}
		}

		public void AddServiceEffectSpecification(SignatureProxy sig)
		{
			AddServiceEffectCmd command = new AddServiceEffectCmd(this._component, sig.Interface.ID, sig.ID);
			this.FireCommandIssued( command );
		}

		public void AddServiceToServiceEffectSpecification(ServiceEffectSpecificationProxy sef, SignatureProxy sig)
		{
			IService service = ComponentFactory.CreateService( this._component.GetRequiresRoleByInterfaceID(sig.Interface.ID).Interface, sig.ID );
			sef.AddServiceToServiceList(service);
		}

		public ServiceEffectSpecificationProxy GetServiceEffectSpecification(IIdentifier ifaceID, IIdentifier sigID)
		{
			foreach(ServiceEffectSpecificationProxy sefProxy in this.ServiceEffects)
			{
				if (sefProxy.InterfaceID.Equals(ifaceID) && sefProxy.SignatureID.Equals(sigID))
					return sefProxy;
			}
			return null;
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

			pds.Add(TypeDescriptor.GetProperties(this, true)["ServiceEffects"]);

			return pds;
		}
		#endregion
	}
}
