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
using Palladio.Editor.Common;
using Palladio.Editor.Common.Commands;

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
		UNSPECIFIED
	}

	/// <summary>
	/// Zusammenfassung für EntityProxy.
	/// </summary>
	public abstract class EntityProxy : ICustomTypeDescriptor, IIdentifiable
	{
		/// <summary>
		/// 
		/// </summary>
		protected event CommandHandler CommandIssued;

		public event EntityChangedHandler EntityChanged;

		#region Constructors
		/// <summary>
		/// 
		/// </summary>
		public EntityProxy()
		{
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="cmdHandler"></param>
		public EntityProxy(CommandHandler cmdHandler)
		{
			this.CommandIssued += cmdHandler;
		}
		#endregion

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
			return TypeDescriptor.GetProperties(this,true);
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
