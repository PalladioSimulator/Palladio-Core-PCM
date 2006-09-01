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

using Palladio.Identifier;
using Palladio.ComponentModel;
using Palladio.Editor.Common.EntityProxies;
using Palladio.Editor.Common.EntityProxies.Collections;

namespace Palladio.Editor.Common.Commands
{
	/// <summary>
	/// Zusammenfassung für ChangeSignatureCmd.
	/// </summary>
	public class ChangeSignatureCmd : AbstractCommand
	{
		private ISignature _oldSignature;
		private ISignature _newSignature;
		private ISignature _receiver;
		private InterfaceProxy _interface;
		private string _newName;
		private string _newType;
		private ParameterProxyCollection _newParameters;

		public ChangeSignatureCmd(ISignature signature, InterfaceProxy iface, string name, string type, ParameterProxyCollection parameters, string blu)
		{
			this._oldSignature = signature;
			this._interface = iface;
			this._newName = name;
			this._newType = type;
			this._newParameters = parameters;
		}

		#region ICommand Member

		public override bool Execute()
		{
			if (this._interface.HasSignatureID(this._oldSignature.ID))
			{
				SignatureProxy sig = this._interface.GetSignatureByID(this._oldSignature.ID);
				this._interface.RemoveSignature(sig);

				string name = (this._newName == null) ? this._oldSignature.Name : this._newName;
				string type = (this._newType == null) ? this._oldSignature.ReturnType.ToString() : this._newType;

				IParameter[] paramArray = null;
				if (this._newParameters == null)
					paramArray = this._oldSignature.Parameters;
				else
				{
					paramArray = new IParameter[this._newParameters.Count];
					for(int i = 0; i < this._newParameters.Count; i++)
					{
						IParameter param = ComponentFactory.CreateParameter(this._newParameters[i].Type,this._newParameters[i].Name);
						paramArray[i] = param;
					}
				}

				this._newSignature = ComponentFactory.CreateSignature(
					type,
					name,
					paramArray );

				this._interface.AddSignature(this._newSignature);
			
				this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
					EntityChangeReason.PROPERTY_CHANGED,
					null);

				this._receiver = this._newSignature;

				return true;
			}
			return false;
		}

		public override bool CanUndo
		{
			get
			{
				return true;
			}
		}

		public override bool Undo()
		{
			if (this._interface.HasSignatureID(this._newSignature.ID))
			{
				SignatureProxy sig = this._interface.GetSignatureByID(this._newSignature.ID);
				this._interface.RemoveSignature(sig);

				this._interface.AddSignature(this._oldSignature);

				this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
					EntityChangeReason.PROPERTY_CHANGED,
					null);

				this._receiver = this._oldSignature;

				return true;
			}
			return false;
		}

		public override object Receiver
		{
			get
			{
				return this._receiver;
			}
		}

		public override object Clone()
		{
			return new ChangeSignatureCmd(this._oldSignature, this._interface, this._newName, this._newType, null, null);
		}

		public InterfaceProxy Interface
		{
			get
			{
				return this._interface;
			}
		}
		#endregion
	}
}
