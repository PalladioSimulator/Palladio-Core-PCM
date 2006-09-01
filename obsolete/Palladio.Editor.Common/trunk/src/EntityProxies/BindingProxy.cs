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

using Palladio.ComponentModel;
using Palladio.Identifier;
using Palladio.Editor.Common.EntityProxies.UITypeEditors;

namespace Palladio.Editor.Common.EntityProxies
{
	/// <summary>
	/// Zusammenfassung für BindingProxy.
	/// </summary>
	public class BindingProxy : ConnectionProxy, ICustomTypeDescriptor
	{
		protected IBinding _binding;

		private RoleProxy _provRole;
		private RoleProxy _reqRole;

		public BindingProxy(IBinding binding, RoleProxy provRole, RoleProxy reqRole, CommandHandler cmdHandler, AttributeProvider attrProv)
			: base(cmdHandler, binding, attrProv)
		{
			this._binding = binding;
			this._provRole = provRole;
			this._reqRole = reqRole;
		}

		#region Public Properties
		/// <summary>
		/// 
		/// </summary>
		[ ReadOnly(true),
		TypeConverter(typeof(StringConverter)),
		Category("Default"),
		DescriptionAttribute("The internal ID of this binding.") ]
		public override IIdentifier ID
		{
			get
			{
				return (IIdentifier)this._binding.ID.Clone();
			}
		}

		[ ReadOnly(true),
		TypeConverter(typeof(RoleTypeConverter)),
		Category("Default"),
		DescriptionAttribute("The provides role of this binding.") ]
		public RoleProxy ProvidesRole
		{
			get
			{
				return this._provRole;
			}
		}

		[ ReadOnly(true),
		TypeConverter(typeof(RoleTypeConverter)),
		Category("Default"),
		DescriptionAttribute("The requires role of this binding.") ]
		public RoleProxy RequiresRole
		{
			get
			{
				return this._reqRole;
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
			pds.Add(TypeDescriptor.GetProperties(this, true)["ProvidesRole"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["RequiresRole"]);

			return pds;
		}

		#endregion
	}
}
