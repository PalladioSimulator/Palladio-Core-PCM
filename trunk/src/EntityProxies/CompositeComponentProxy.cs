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
using System.ComponentModel.Design;

using Palladio.Identifier;
using Palladio.ComponentModel;
using Palladio.Editor.Common.Commands;
using Palladio.Editor.Common.EntityProxies.Collections;
using Palladio.Editor.Common.EntityProxies.UITypeEditors;

namespace Palladio.Editor.Common.EntityProxies
{
	/// <summary>
	/// Zusammenfassung für CompositeComponentProxy.
	/// </summary>
	public class CompositeComponentProxy : ComponentProxy
	{
		#region Fields
		/// <summary>
		/// </summary>
		protected new ICompositeComponent _component;

		/// <summary>
		/// </summary>
		private CompositeComponentProxyCollection _compositeComponents;

		/// <summary>
		/// </summary>
		private BasicComponentProxyCollection _basicComponents;

		/// <summary>
		/// </summary>
		private BindingProxyCollection _bindings;

		/// <summary>
		/// </summary>
		private ProvidesMappingProxyCollection _providesMappings;

		/// <summary>
		/// </summary>
		private RequiresMappingProxyCollection _requiresMappings;
		#endregion

		#region Constructors
		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <param name="cmdHandler"></param>
		/// <param name="provided"></param>
		/// <param name="required"></param>
		/// <param name="components"></param>
		public CompositeComponentProxy(ICompositeComponent component, CommandHandler cmdHandler, RoleProxy[] provided, RoleProxy[] required, ComponentProxy[] components)
			: base(component, cmdHandler, provided, required)
		{
			this._component = component;
			this._compositeComponents = new CompositeComponentProxyCollection();
			this._basicComponents = new BasicComponentProxyCollection();
			this._bindings = new BindingProxyCollection();
			this._providesMappings = new ProvidesMappingProxyCollection();
			this._requiresMappings = new RequiresMappingProxyCollection();

			foreach(ComponentProxy comp in components)
			{
				if (comp is CompositeComponentProxy)
					this._compositeComponents.Add(comp as CompositeComponentProxy);
				if (comp is BasicComponentProxy)
					this._basicComponents.Add(comp as BasicComponentProxy);
			}
		}
		#endregion

		#region Public Properties
		/// <summary>
		/// 
		/// </summary>
		[ ReadOnly(false),
		TypeConverter(typeof(CompositeComponentProxyCollection)),
		Editor(typeof(ComponentProxyCollectionTypeEditor), typeof(UITypeEditor)),
		Category("Composition"),
		DescriptionAttribute("A list of aggregated composite components") ]
		public CompositeComponentProxyCollection CompositeComponents
		{
			get
			{
				return this._compositeComponents;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		[ ReadOnly(false),
		TypeConverter(typeof(BasicComponentProxyCollection)),
		Editor(typeof(ComponentProxyCollectionTypeEditor), typeof(UITypeEditor)),
		Category("Composition"),
		DescriptionAttribute("A list of aggregated basic components") ]
		public BasicComponentProxyCollection BasicComponents
		{
			get
			{
				return this._basicComponents;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		public ComponentProxyCollection Components
		{
			get 
			{
				ComponentProxyCollection coll = new ComponentProxyCollection();
				coll.AddRange( this._compositeComponents.ToArray() );
				coll.AddRange( this._basicComponents.ToArray() );
				return coll;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		[ ReadOnly(false),
		//TypeConverter(typeof(BasicComponentProxyCollection)),
		//Editor(typeof(ComponentProxyCollectionTypeEditor), typeof(UITypeEditor)),
		Category("Connections"),
		DescriptionAttribute("A list of contained component bindings") ]
		public BindingProxyCollection Bindings
		{
			get
			{
				return this._bindings;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		[ ReadOnly(false),
		//TypeConverter(typeof(BasicComponentProxyCollection)),
		//Editor(typeof(ComponentProxyCollectionTypeEditor), typeof(UITypeEditor)),
		Category("Connections"),
		DescriptionAttribute("A list of contained mappings between provides interfaces") ]
		public ProvidesMappingProxyCollection ProvidesMappings
		{
			get
			{
				return this._providesMappings;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		[ ReadOnly(false),
		//TypeConverter(typeof(BasicComponentProxyCollection)),
		//Editor(typeof(ComponentProxyCollectionTypeEditor), typeof(UITypeEditor)),
		Category("Connections"),
		DescriptionAttribute("A list of contained mappings between requires interfaces") ]
		public RequiresMappingProxyCollection RequiresMappings
		{
			get
			{
				return this._requiresMappings;
			}
		}
		#endregion

		#region Public Methods
		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public IIdentifier AddCompositeComponent()
		{
			return AddCompositeComponent("New CompositeComponent");
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="name"></param>
		/// <returns></returns>
		public IIdentifier AddCompositeComponent(string name)
		{
			AddCompositeComponentCmd command = new AddCompositeComponentCmd(this._component, name);
			this.FireCommandIssued( command );

			//return ID of added component
			return command.EventArgs.AssociatedID;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public IIdentifier AddCompositeComponentWithDialog()
		{
			Dialogs.AddCompositeComponent dialog = new Dialogs.AddCompositeComponent();
			if (dialog.ShowDialog() == System.Windows.Forms.DialogResult.OK)
			{
				AddCompositeComponentCmd command = new AddCompositeComponentCmd(this._component, dialog.GetName());
				this.FireCommandIssued( command );

				//return ID of added component
				return command.EventArgs.AssociatedID;				
			}
			return null;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public IIdentifier AddBasicComponent()
		{
			return AddBasicComponent("New BasicComponent");
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="name"></param>
		/// <returns></returns>
		public IIdentifier AddBasicComponent(string name)
		{
			AddBasicComponentCmd command = new AddBasicComponentCmd(this._component, name);
			this.FireCommandIssued( command );

			//return ID of added component
			return command.EventArgs.AssociatedID;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public IIdentifier AddBasicComponentWithDialog()
		{
			Dialogs.AddBasicComponent dialog = new Dialogs.AddBasicComponent();
			if (dialog.ShowDialog() == System.Windows.Forms.DialogResult.OK)
			{
				AddBasicComponentCmd command = new AddBasicComponentCmd(this._component, dialog.GetName());
				this.FireCommandIssued( command );

				//return ID of added component
				return command.EventArgs.AssociatedID;
			}
			return null;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="id"></param>
		public void RemoveComponent(IIdentifier id)
		{
			RemoveComponentCmd command = new RemoveComponentCmd(this._component, id);
			this.FireCommandIssued( command );
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="role1"></param>
		/// <param name="role2"></param>
		public void AddBinding(RoleProxy role1, RoleProxy role2)
		{
			AddBindingCmd command = new AddBindingCmd(this._component, role1.Component.ID, role1.ID, role2.Component.ID, role2.ID);
			this.FireCommandIssued( command );
		}

		public void AddProvidesMapping(RoleProxy role1, RoleProxy role2)
		{
			AddProvidesMappingCmd command = new AddProvidesMappingCmd(this._component, role1.ID, role2.Component.ID, role2.ID);
			this.FireCommandIssued( command );
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="role1"></param>
		/// <param name="role2"></param>
		public void AddRequiresMapping(RoleProxy role1, RoleProxy role2)
		{
			AddRequiresMappingCmd command = new AddRequiresMappingCmd(this._component, role2.ID, role1.Component.ID, role1.ID);
			this.FireCommandIssued( command );
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="id"></param>
		/// <returns></returns>
		public ComponentProxy GetComponentByID(IIdentifier id)
		{
			foreach (ComponentProxy proxy in this.Components)
			{
				if (proxy.ID.Equals(id))
					return proxy;
			}
			return null;
		}

		public BindingProxy GetBindingByID(IIdentifier id)
		{
			foreach (BindingProxy proxy in this.Bindings)
			{
				if (proxy.ID.Equals(id))
					return proxy;
			}
			return null;
		}

		public ProvidesMappingProxy GetProvidesMappingByID(IIdentifier id)
		{
			foreach (ProvidesMappingProxy proxy in this.ProvidesMappings)
			{
				if (proxy.ID.Equals(id))
					return proxy;
			}
			return null;
		}

		public RequiresMappingProxy GetRequiresMappingByID(IIdentifier id)
		{
			foreach (RequiresMappingProxy proxy in this.RequiresMappings)
			{
				if (proxy.ID.Equals(id))
					return proxy;
			}
			return null;
		}
		#endregion

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

			pds.Add(TypeDescriptor.GetProperties(this, true)["CompositeComponents"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["BasicComponents"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["Bindings"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["ProvidesMappings"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["RequiresMappings"]);

			return pds;
		}

		#endregion

	}
}
