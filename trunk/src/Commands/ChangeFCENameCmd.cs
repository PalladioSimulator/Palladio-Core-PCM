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
	/// Zusammenfassung für ChangeFCENameCmd.
	/// </summary>
	public class ChangeFCENameCmd : AbstractCommand
	{
		private FirstClassEntity _targetEntity;
		private string _newName;
		private string _oldName;

		public ChangeFCENameCmd(FirstClassEntity fce, string newName)
		{
			this._targetEntity = fce;
			this._newName = newName;
		}

		#region ICommand Member

		public override bool Execute()
		{
			this._oldName = this._targetEntity.Name;
			this._targetEntity.Name = this._newName;

			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.PROPERTY_CHANGED,
				null);
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
			this._targetEntity.Name = this._oldName;

			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.PROPERTY_CHANGED,
				null);
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
				return this._targetEntity;
			}
		}

		public override object Clone()
		{
			return new ChangeFCENameCmd(this._targetEntity, this._newName);
		}
		#endregion
	}
}
