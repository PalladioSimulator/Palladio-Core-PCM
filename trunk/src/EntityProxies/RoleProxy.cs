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
		#region Fields
		/// <summary>
		/// The role instance behind this proxy.</summary>
		protected IRole _role;

		/// <summary>
		/// A proxy to the interface attached to this role.</summary>
		protected InterfaceProxy _interface;

		/// <summary>
		/// A proxy to the component to which this role is attached to.</summary>
		protected ComponentProxy _component;
		#endregion

		#region Constructors
		/// <summary>
		/// 
		/// </summary>
		/// <param name="role"></param>
		/// <param name="comp"></param>
		/// <param name="iface"></param>
		/// <param name="cmdHandler"></param>
		public RoleProxy(IRole role, ComponentProxy comp, InterfaceProxy iface, CommandHandler cmdHandler)
			: base(cmdHandler)
		{
			this._role = role;
			this._interface = iface;
			this._component = comp;
		}
		#endregion

		#region Public Properties
		/// <summary>
		/// 
		/// </summary>
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

		/// <summary>
		/// 
		/// </summary>
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

		/// <summary>
		/// 
		/// </summary>
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

		/// <summary>
		/// 
		/// </summary>
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

			pds.Add(TypeDescriptor.GetProperties(this, true)["ID"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["Name"]);

			pds.Add(TypeDescriptor.GetProperties(this, true)["Component"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["Interface"]);

			return pds;
		}

		#endregion

	}
}
