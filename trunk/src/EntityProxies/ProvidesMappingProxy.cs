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

namespace Palladio.Editor.Common.EntityProxies
{
	/// <summary>
	/// Zusammenfassung für BindingProxy.
	/// </summary>
	public class ProvidesMappingProxy : EntityProxy, ICustomTypeDescriptor
	{
		protected IMapping _mapping;

		public ProvidesMappingProxy(IMapping mapping, CommandHandler cmdHandler)
			: base(cmdHandler)
		{
			this._mapping = mapping;
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

			return pds;
		}

		#endregion
	}
}
