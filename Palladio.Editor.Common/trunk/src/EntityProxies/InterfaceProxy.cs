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
		#region Fields
		/// <summary>
		/// 
		/// </summary>
		protected IInterfaceModel _interface;
		/// <summary>
		/// 
		/// </summary>
		protected SignatureProxyCollection _signatures;
		#endregion

		#region Constructors
		/// <summary>
		/// 
		/// </summary>
		/// <param name="iface"></param>
		/// <param name="cmdHandler"></param>
		/// <param name="signatures"></param>
		/// <param name="attrProvider"></param>
		public InterfaceProxy(IInterfaceModel iface, CommandHandler cmdHandler, SignatureProxy[] signatures, AttributeProvider attrProvider)
			: base(cmdHandler, iface, attrProvider)
		{
			this._interface = iface;
			this._signatures = new SignatureProxyCollection();
			this._signatures.AddRange(signatures);
		}
		#endregion

		#region Public Properties
		/// <summary>
		/// 
		/// </summary>
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

		/// <summary>
		/// 
		/// </summary>
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

		/// <summary>
		/// 
		/// </summary>
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
		#endregion

		#region Public Methods
		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public IIdentifier AddSignature()
		{
			AddSignatureCmd command = new AddSignatureCmd(
				this._interface, 
				"Service"+(this._interface.SignatureList.Count+1),
				"System.Void",
				new IParameter[]{});

			this.FireCommandIssued( command );

			this.FireEntityChanged();
			//return ID of added component
			return command.EventArgs.AssociatedID;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="sig"></param>
		/// <returns></returns>
		public IIdentifier AddSignature(ISignature sig)
		{
			AddSignatureCmd command = new AddSignatureCmd(this._interface, sig);

			this.FireCommandIssued( command );

			//return ID of added component
			return command.EventArgs.AssociatedID;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="sig"></param>
		/// <returns></returns>
		public IIdentifier RemoveSignature(SignatureProxy sig)
		{
			RemoveSignatureCmd command = new RemoveSignatureCmd(
				this._interface,
				sig.ID);

			this.FireCommandIssued( command );

			this.FireEntityChanged();

			return command.EventArgs.AssociatedID;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="id"></param>
		/// <returns></returns>
		public bool HasSignatureID(IIdentifier id)
		{
			foreach (SignatureProxy sig in this.Signatures)
			{
				if (sig.ID.Equals(id))
					return true;
			}
			return false;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="id"></param>
		/// <returns></returns>
		public SignatureProxy GetSignatureByID(IIdentifier id)
		{
			foreach (SignatureProxy sig in this.Signatures)
			{
				if (sig.ID.Equals(id))
					return sig;
			}
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

			pds.Add(TypeDescriptor.GetProperties(this, true)["Signatures"]);

			return pds;
		}

		#endregion
	}
}
