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
	/// Zusammenfassung für InterfaceProxy.
	/// </summary>
	public class InterfaceProxy : EntityProxy, ICustomTypeDescriptor
	{
		protected IInterfaceModel _interface;
		protected SignatureProxyCollection _signatures;

		public InterfaceProxy(IInterfaceModel iface, CommandHandler cmdHandler, SignatureProxy[] signatures)
			: base(cmdHandler)
		{
			this._interface = iface;
			this._signatures = new SignatureProxyCollection();
			this._signatures.AddRange(signatures);
		}

		[ ReadOnly(true),
		TypeConverter(typeof(StringConverter)),
		Category("Default"),
		DescriptionAttribute("The globally unique ID (GUID) of this interface.") ]
		public override IIdentifier ID
		{
			get
			{
				return (IIdentifier)this._interface.ID.Clone();
			}
		}

		[ ReadOnly(false),
		TypeConverter(typeof(StringConverter)),
		Category("Default"),
		DescriptionAttribute("The name which describes this interface.") ]
		public string Name
		{
			get
			{
				return this._interface.Name;
			}
			set
			{
				ChangeFCENameCmd command = new ChangeFCENameCmd(this._interface as FirstClassEntity, value);
				this.FireCommandIssued( command );
			}
		}

		[ ReadOnly(false),
		TypeConverter(typeof(SignatureListTypeConverter)),
		Editor(typeof(SignatureProxyCollectionTypeEditor), typeof(UITypeEditor)),
		Category("Context"),
		DescriptionAttribute("A list of services this interface offers.") ]
		public SignatureProxyCollection Signatures
		{
			get
			{
				return this._signatures;
			}
		}

		public IIdentifier AddSignature()
		{
			AddSignatureCmd command = new AddSignatureCmd(
				this._interface, 
				"Service"+(this._interface.SignatureList.Count+1),
				"System.Void",
				new IParameter[]{});

			this.FireCommandIssued( command );

			//return ID of added component
			return command.EventArgs.AssociatedID;
		}

		public IIdentifier AddSignature(ISignature sig)
		{
			AddSignatureCmd command = new AddSignatureCmd(this._interface, sig);

			this.FireCommandIssued( command );

			//return ID of added component
			return command.EventArgs.AssociatedID;
		}

		public IIdentifier RemoveSignature(SignatureProxy sig)
		{
			RemoveSignatureCmd command = new RemoveSignatureCmd(
				this._interface,
				sig.ID);

			this.FireCommandIssued( command );

			return command.EventArgs.AssociatedID;
		}

		public bool HasSignatureID(IIdentifier id)
		{
			foreach (SignatureProxy sig in this.Signatures)
			{
				if (sig.ID.Equals(id))
					return true;
			}
			return false;
		}

		public SignatureProxy GetSignatureByID(IIdentifier id)
		{
			foreach (SignatureProxy sig in this.Signatures)
			{
				if (sig.ID.Equals(id))
					return sig;
			}
			return null;
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

			pds.Add(TypeDescriptor.GetProperties(this, true)["Signatures"]);

			return pds;
		}

		#endregion
	}
}
