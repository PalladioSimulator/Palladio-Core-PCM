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
	/// Zusammenfassung für RemoveSignatureCmd.
	/// </summary>
	public class RemoveSignatureCmd : AbstractCommand
	{
		private IInterfaceModel _targetInterface;
		private IIdentifier _sigId;
		private ISignature _deletedSignature;

		public RemoveSignatureCmd(IInterfaceModel iface, IIdentifier sigId)
		{
			this._targetInterface = iface;
			this._sigId = sigId;
		}

		#region ICommand Member

		public override bool Execute()
		{
			if (this._targetInterface.SignatureList.ContainsSignatureID(this._sigId))
			{
				this._deletedSignature = this._targetInterface.SignatureList.GetSignaturesByID(this._sigId)[0];
				this._targetInterface.SignatureList.DeleteSignatures(this._deletedSignature);

				this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
					EntityChangeReason.SIGNATURE_REMOVED,
					this._deletedSignature.ID.Clone() as IIdentifier);
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
			this._targetInterface.SignatureList.AddSignatures(this._deletedSignature);

			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.SIGNATURE_ADDED,
				this._deletedSignature.ID.Clone() as IIdentifier);
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
			return new RemoveSignatureCmd(this._targetInterface, this._sigId);
		}
		#endregion
	}
}
