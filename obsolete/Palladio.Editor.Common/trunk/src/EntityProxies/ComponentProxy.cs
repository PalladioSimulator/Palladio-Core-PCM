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
using System.Drawing.Design;
using System.ComponentModel;

using Palladio.Identifier;
using Palladio.ComponentModel;
using Palladio.Editor.Common.Commands;
using Palladio.Editor.Common.EntityProxies.Collections;
using Palladio.Editor.Common.EntityProxies.UITypeEditors;

namespace Palladio.Editor.Common.EntityProxies
{
	/// <summary>
	/// A proxy for an IComponent instance.
	/// </summary>
	public abstract class ComponentProxy : EntityProxy, ICustomTypeDescriptor
	{
		/// <summary>
		/// The wrapped component</summary>
		protected Palladio.ComponentModel.IComponent _component;

		/// <summary>
		/// Proxy collection for roles that the wrapped component provides.</summary>
		protected RoleProxyCollection _providesRoles;

		/// <summary>
		/// Proxy collection for roles that the wrapped component requires.</summary>
		protected RoleProxyCollection _requiresRoles;

		#region Constructors
		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <param name="cmdHandler"></param>
		/// <param name="provides"></param>
		/// <param name="requires"></param>
		/// <param name="attrProvider"></param>
		public ComponentProxy(Palladio.ComponentModel.IComponent component, CommandHandler cmdHandler, RoleProxy[] provides, RoleProxy[] requires, AttributeProvider attrProvider)
			: base(cmdHandler, component, attrProvider)
		{
			this._component = component;
			this._providesRoles = new RoleProxyCollection();
			this._requiresRoles = new RoleProxyCollection();

			this._providesRoles.AddRange(provides);
			this._requiresRoles.AddRange(requires);
		}
		#endregion

		#region Public Properties
		/// <summary>
		/// The component's globally unique ID
		/// </summary>
		[ ReadOnly(true),
		  TypeConverter(typeof(StringConverter)),
		  Category("Default"),
		  DescriptionAttribute("The globally unique ID (GUID) of this component.") ]
		public override IIdentifier ID
		{
			get
			{
				return (IIdentifier)this._component.ID.Clone();
			}
		}

		/// <summary>
		/// The component's name
		/// </summary>
		[ ReadOnly(false),
		  TypeConverter(typeof(StringConverter)),
		  Category("Default"),
		  DescriptionAttribute("The name describing this component.") ]
		public string Name
		{
			get
			{
				return this._component.Name;
			}
			set
			{
				ChangeFCENameCmd command = new ChangeFCENameCmd(this._component as FirstClassEntity, value);
				this.FireCommandIssued( command );
			}
		}

		/// <summary>
		/// 
		/// </summary>
		[ ReadOnly(false),
		TypeConverter(typeof(RoleProxyCollection)),
		Editor(typeof(RoleProxyCollectionTypeEditor), typeof(UITypeEditor)),
		Category("Roles"),
		DescriptionAttribute("A list of provided roles") ]
		public RoleProxyCollection ProvidedRoles
		{
			get
			{
				return this._providesRoles;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		[ ReadOnly(false),
		TypeConverter(typeof(System.Collections.CollectionBase)),
		Editor(typeof(RoleProxyCollectionTypeEditor), typeof(UITypeEditor)),
		Category("Roles"),
		DescriptionAttribute("A list of required roles") ]
		public RoleProxyCollection RequiredRoles
		{
			get
			{
				return this._requiresRoles;
			}
		}
		#endregion

		#region Public Methods
		/// <summary>
		/// 
		/// </summary>
		/// <param name="rolename">A name for the new role</param>
		/// <param name="ifacename">A name for the new interface</param>
		public void AddProvidesInterface(string rolename, string ifacename)
		{
			AddProvidesInterfaceCmd command = new AddProvidesInterfaceCmd(this._component, rolename, ifacename);
			this.FireCommandIssued( command );
		}

		/// <summary>
		/// 
		/// </summary>
		public void AddProvidesInterfaceWithDialog()
		{
			Dialogs.AddInterface dialog = new Dialogs.AddInterface();
			if (dialog.ShowDialog() == System.Windows.Forms.DialogResult.OK)
			{
				AddProvidesInterfaceCmd command = new AddProvidesInterfaceCmd(this._component, dialog.GetRoleName(), dialog.GetInterfaceName());
				this.FireCommandIssued( command );
			}
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="rolename">A name for the new role</param>
		/// <param name="ifacename">A name for the new interface</param>
		public void AddRequiresInterface(string rolename, string ifacename)
		{
			AddRequiresInterfaceCmd command = new AddRequiresInterfaceCmd(this._component, rolename, ifacename);
			this.FireCommandIssued( command );
		}

		/// <summary>
		/// 
		/// </summary>
		public void AddRequiresInterfaceWithDialog()
		{
			Dialogs.AddInterface dialog = new Dialogs.AddInterface();
			if (dialog.ShowDialog() == System.Windows.Forms.DialogResult.OK)
			{
				AddRequiresInterfaceCmd command = new AddRequiresInterfaceCmd(this._component, dialog.GetRoleName(), dialog.GetInterfaceName());
				this.FireCommandIssued( command );
			}
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="id"></param>
		/// <returns></returns>
		public RoleProxy GetProvidesRoleByInterfaceID(IIdentifier id)
		{
			foreach (RoleProxy role in this._providesRoles)
				if (role.Interface.ID.Equals(id))
					return role;
			return null;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="id"></param>
		/// <returns></returns>
		public RoleProxy GetRequiresRoleByInterfaceID(IIdentifier id)
		{
			foreach (RoleProxy role in this._requiresRoles)
				if (role.Interface.ID.Equals(id))
					return role;
			return null;
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

			foreach (PropertyDescriptor pd in base.GetProperties())
				pds.Add(pd);

			pds.Add(TypeDescriptor.GetProperties(this, true)["ID"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["Name"]);

			pds.Add(TypeDescriptor.GetProperties(this, true)["ProvidedRoles"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["RequiredRoles"]);

			return pds;
		}

		#endregion
	}
}
