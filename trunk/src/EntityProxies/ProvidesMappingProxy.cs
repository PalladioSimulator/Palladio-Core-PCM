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
	public class ProvidesMappingProxy : ConnectionProxy, ICustomTypeDescriptor
	{
		protected IMapping _mapping;

		private RoleProxy _innerRole;
		private RoleProxy _outerRole;

		public ProvidesMappingProxy(IMapping mapping, RoleProxy innerRole, RoleProxy outerRole, CommandHandler cmdHandler, AttributeProvider attrProv)
			: base(cmdHandler, mapping, attrProv)
		{
			this._mapping = mapping;
			this._innerRole = innerRole;
			this._outerRole = outerRole;
		}

		#region Public Properties
		/// <summary>
		/// 
		/// </summary>
		[ ReadOnly(true),
		TypeConverter(typeof(StringConverter)),
		Category("Default"),
		DescriptionAttribute("The internal ID of this mapping.") ]
		public override IIdentifier ID
		{
			get
			{
				return (IIdentifier)this._mapping.ID.Clone();
			}
		}

		[ ReadOnly(true),
		TypeConverter(typeof(RoleTypeConverter)),
		Category("Default"),
		DescriptionAttribute("The inner role of this provides mapping.") ]
		public RoleProxy InnerRole
		{
			get
			{
				return this._innerRole;
			}
		}

		[ ReadOnly(true),
		TypeConverter(typeof(RoleTypeConverter)),
		Category("Default"),
		DescriptionAttribute("The outer role of this provides mapping.") ]
		public RoleProxy OuterRole
		{
			get
			{
				return this._outerRole;
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

			foreach (PropertyDescriptor pd in base.GetProperties())
				pds.Add(pd);

			pds.Add(TypeDescriptor.GetProperties(this, true)["ID"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["InnerRole"]);
			pds.Add(TypeDescriptor.GetProperties(this, true)["OuterRole"]);

			return pds;
		}

		#endregion
	}
}
