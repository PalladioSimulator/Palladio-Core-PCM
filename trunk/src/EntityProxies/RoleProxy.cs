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
using Palladio.Editor.Common.EntityProxies.UITypeEditors;

namespace Palladio.Editor.Common.EntityProxies
{
	/// <summary>
	/// Zusammenfassung für RoleProxy.
	/// </summary>
	public class RoleProxy : EntityProxy, ICustomTypeDescriptor
	{
		protected IRole _role;
		protected InterfaceProxy _interface;
		protected ComponentProxy _component;

		public RoleProxy(IRole role, ComponentProxy comp, InterfaceProxy iface, CommandHandler cmdHandler)
			: base(cmdHandler)
		{
			this._role = role;
			this._interface = iface;
			this._component = comp;
		}

		[ ReadOnly(true),
		TypeConverter(typeof(StringConverter)),
		Category("Default"),
		DescriptionAttribute("The ID of this interface.") ]
		public override IIdentifier ID
		{
			get
			{
				return (IIdentifier)this._role.ID.Clone();
			}
		}

		[ ReadOnly(false),
		TypeConverter(typeof(StringConverter)),
		Category("Default"),
		DescriptionAttribute("The name which describes this role.") ]
		public string Name
		{
			get
			{
				return (string)this._role.Name.Clone();
			}
			set
			{
				this._role.Name = value;
//				base.FireEntityChanged(
//					this, 
//					new EventArgs(EntityChangeReason.PROPERTY_CHANGED, null) );
			}
		}

		[ ReadOnly(false),
		TypeConverter(typeof(InterfaceTypeConverter)),
		Category("Context"),
		DescriptionAttribute("The interface attached to this role.") ]
		public InterfaceProxy Interface
		{
			get
			{
				return this._interface;
			}
		}

		[ ReadOnly(true),
		TypeConverter(typeof(ComponentTypeConverter)),
		Category("Context"),
		DescriptionAttribute("The component to which this role is attached.") ]
		public ComponentProxy Component
		{
			get
			{
				return this._component;
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

			pds.Add(TypeDescriptor.GetProperties(this, true)["ID"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["Name"]);

			pds.Add(TypeDescriptor.GetProperties(this, true)["Component"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["Interface"]);

			return pds;
		}

		#endregion

	}
}
