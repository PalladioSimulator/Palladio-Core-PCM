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

namespace Palladio.Editor.Common.Commands
{
	/// <summary>
	/// Zusammenfassung für AddSignatureCmd.
	/// </summary>
	public class AddSignatureCmd : AbstractCommand
	{
		private IInterfaceModel _targetInterface;
		private string _name;
		private string _type;
		private ISignature _newSignature;
		private IParameter[] _parameters;

		public AddSignatureCmd(IInterfaceModel iface, string name, string type, IParameter[] parameters)
		{
			this._targetInterface = iface;
			this._name = name;
			this._type = type;
			this._parameters = parameters;
		}

		public AddSignatureCmd(IInterfaceModel iface, ISignature newSig)
		{
			this._targetInterface = iface;
			this._newSignature = newSig;
		}

		#region ICommand Member

		public override bool Execute()
		{
			if (this._newSignature == null)
			{
				this._newSignature = ComponentFactory.CreateSignature(
					this._type,
					this._name, 
					this._parameters );
			}
			this._targetInterface.SignatureList.AddSignatures(this._newSignature);

			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.SIGNATURE_ADDED,
				this._newSignature.ID.Clone() as IIdentifier);

			return true;
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
			this._targetInterface.SignatureList.DeleteSignatures(this._newSignature);

			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.SIGNATURE_REMOVED,
				this._newSignature.ID.Clone() as IIdentifier);

			return true;
		}

		public override Palladio.Editor.Common.EntityProxies.EventArgs EventArgs
		{
			get
			{
				return this._evtArgs;
			}
		}

		public override object Receiver
		{
			get
			{
				return this._targetInterface;
			}
		}

		public override object Clone()
		{
			return new AddSignatureCmd(this._targetInterface, this._name, this._type, this._parameters);
		}
		#endregion
	}
}
