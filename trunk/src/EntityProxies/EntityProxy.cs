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
	public enum EntityChangeReason
	{
		PROPERTY_CHANGED,
		ROLEPROPERTY_CHANGED,
		PROVIDESINTERFACE_ADDED,
		PROVIDESINTERFACE_REMOVED,
		REQUIRESINTERFACE_ADDED,
		REQUIRESINTERFACE_REMOVED,
		SIGNATURE_ADDED,
		SIGNATURE_REMOVED,
		COMPONENT_ADDED,
		COMPONENT_REMOVED,
		UNSPECIFIED
	}

	/// <summary>
	/// Zusammenfassung für EntityProxy.
	/// </summary>
	public abstract class EntityProxy : ICustomTypeDescriptor, IIdentifiable
	{
		protected event CommandHandler CommandIssued;

		public EntityProxy()
		{
		}

		public EntityProxy(CommandHandler cmdHandler)
		{
			this.CommandIssued += cmdHandler;
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
