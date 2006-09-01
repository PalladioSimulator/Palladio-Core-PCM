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
using System.Collections;

using Palladio.Attributes;
using Palladio.Identifier;
using Palladio.Editor.Common;
using Palladio.Editor.Common.Commands;
using Palladio.Editor.Common.EntityProxies.UITypeEditors;
using Palladio.Editor.Common.EntityProxies.Collections;

namespace Palladio.Editor.Common.EntityProxies
{
	/// <summary>
	/// 
	/// </summary>
	public enum EntityChangeReason
	{
		/// <summary> </summary>
		PROPERTY_CHANGED,
		/// <summary> </summary>
		ROLEPROPERTY_CHANGED,
		/// <summary> </summary>
		PROVIDESINTERFACE_ADDED,
		/// <summary> </summary>
		PROVIDESINTERFACE_REMOVED,
		/// <summary> </summary>
		REQUIRESINTERFACE_ADDED,
		/// <summary> </summary>
		REQUIRESINTERFACE_REMOVED,
		/// <summary> </summary>
		SIGNATURE_ADDED,
		/// <summary> </summary>
		SIGNATURE_REMOVED,
		/// <summary> </summary>
		COMPONENT_ADDED,
		/// <summary> </summary>
		COMPONENT_REMOVED,
		/// <summary> </summary>
		BINDING_ADDED,
		/// <summary> </summary>
		BINDING_REMOVED,
		/// <summary> </summary>
		PROVIDESMAPPING_ADDED,
		/// <summary> </summary>
		PROVIDESMAPPING_REMOVED,
		/// <summary> </summary>
		REQUIRESMAPPING_ADDED,
		/// <summary> </summary>
		REQUIRESMAPPING_REMOVED,
		/// <summary> </summary>
		SERVICEEFFECTSPECS_CHANGED,
		/// <summary> </summary>
		SERVICE_IN_SEFFSPEC_ADDED,
		/// <summary> </summary>
		SERVICE_IN_SEFFSPEC_REMOVED,
		/// <summary> </summary>
		UNSPECIFIED
	}

	public delegate AbstractAttributeType[] AttributeProvider();

	/// <summary>
	/// Zusammenfassung für EntityProxy.
	/// </summary>
	public abstract class EntityProxy : ICustomTypeDescriptor, IIdentifiable
	{
		private IAttributable _entity;
		protected AttributeHashtable _attributes;
		private AttributeProvider _attrProv;

		/// <summary>
		/// </summary>
		protected event CommandHandler CommandIssued;

		/// <summary>
		/// </summary>
		public event EntityChangedHandler EntityChanged;

		#region Constructors
		/// <summary>
		/// 
		/// </summary>
		public EntityProxy()
		{
			this._attributes = new AttributeHashtable();
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="cmdHandler"></param>
		public EntityProxy(CommandHandler cmdHandler)
		{
			this.CommandIssued += cmdHandler;
			this._attributes = new AttributeHashtable();
		}

		/// <summary>
		/// Registers a cmdHandler with the <see cref="CommandIssued"/> event.
		/// </summary>
		/// <param name="cmdHandler"></param>
		/// <param name="entity"></param>
		/// <param name="provider"></param>
		public EntityProxy(CommandHandler cmdHandler, IAttributable entity, AttributeProvider provider)
		{
			this.CommandIssued += cmdHandler;
			this._entity = entity;
			this._attributes = new AttributeHashtable();
			this._attrProv = provider;
		}
		#endregion

		/// <summary>
		/// 
		/// </summary>
		[ ReadOnly(false),
		TypeConverter(typeof(AttributeHashtableTypeConverter)),
		Editor(typeof(AttributeCollectionTypeEditor), typeof(UITypeEditor)),
		Category("Attributes"),
		DescriptionAttribute("A list of attributes attached to this entity") ]
		public AttributeHashtable Attributes
		{
			get
			{
				return this._attributes;
			}
		}

		public AbstractAttributeType[] AvailableAttributes
		{
			get
			{
				return this._attrProv();
			}
		}

		public void AttachAttribute(AbstractAttributeType attrType)
		{
			AbstractAttribute attr = Activator.CreateInstance(attrType.ValueType) as AbstractAttribute;
			this._attributes[attrType] = attr;
			this._entity.Attributes.Add(attrType, attr);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="command"></param>
		protected void FireCommandIssued(ICommand command)
		{
			if (this.CommandIssued != null)
				this.CommandIssued(this, command);
		}

		protected void FireEntityChanged()
		{
			if (this.EntityChanged != null)
				this.EntityChanged(this, this, new Palladio.Editor.Common.EntityProxies.EventArgs(EntityChangeReason.UNSPECIFIED, null));
		}

		#region ICustomTypeDescriptor Member

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public TypeConverter GetConverter()
		{
			return TypeDescriptor.GetConverter(this, true);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="attributes"></param>
		/// <returns></returns>
		public EventDescriptorCollection GetEvents(Attribute[] attributes)
		{
			return TypeDescriptor.GetEvents(this, attributes, true);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public EventDescriptorCollection GetEvents()
		{
			return TypeDescriptor.GetEvents(this, true);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public string GetComponentName()
		{
			return TypeDescriptor.GetComponentName(this, true);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="pd"></param>
		/// <returns></returns>
		public object GetPropertyOwner(PropertyDescriptor pd)
		{
			return this;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public AttributeCollection GetAttributes()
		{
			return TypeDescriptor.GetAttributes(this,true);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="attributes"></param>
		/// <returns></returns>
		public virtual PropertyDescriptorCollection GetProperties(Attribute[] attributes)
		{
			return GetProperties();
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public virtual PropertyDescriptorCollection GetProperties()
		{
			// Create a new collection object PropertyDescriptorCollection
			PropertyDescriptorCollection pds = new PropertyDescriptorCollection(null);

			pds.Add(TypeDescriptor.GetProperties(this, true)["Attributes"]);

			return pds;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="editorBaseType"></param>
		/// <returns></returns>
		public object GetEditor(Type editorBaseType)
		{
			return TypeDescriptor.GetEditor(this, editorBaseType, true);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public PropertyDescriptor GetDefaultProperty()
		{
			return TypeDescriptor.GetDefaultProperty(this, true);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public EventDescriptor GetDefaultEvent()
		{
			return TypeDescriptor.GetDefaultEvent(this, true);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public string GetClassName()
		{
			return TypeDescriptor.GetClassName(this,true);
		}

		#endregion

		#region IIdentifiable Member
		/// <summary>
		/// 
		/// </summary>
		public abstract IIdentifier ID { get; }
		#endregion
	}

	/// <summary>
	/// 
	/// </summary>
	public class EventArgs : System.EventArgs
	{
		private EntityChangeReason _reason;
		private IIdentifier _id;

		/// <summary>
		/// 
		/// </summary>
		/// <param name="reason"></param>
		/// <param name="id"></param>
		public EventArgs(EntityChangeReason reason, IIdentifier id)
		{
			this._reason = reason;
			this._id = id;
		}

		/// <summary>
		/// 
		/// </summary>
		public EntityChangeReason Reason
		{
			get
			{
				return this._reason;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		public IIdentifier AssociatedID
		{
			get
			{
				return this._id;
			}
		}
	}
}
