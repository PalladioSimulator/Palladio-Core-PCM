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

using Palladio.ComponentModel;
using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Common.Commands
{
	/// <summary>
	/// Zusammenfassung für ChangeRoleNameCmd.
	/// </summary>
	public class ChangeRoleNameCmd : AbstractCommand
	{
		private IRole _targetRole;
		private string _newName;
		private string _oldName;

		public ChangeRoleNameCmd(IRole role, string newName)
		{
			this._targetRole = role;
			this._newName = newName;
		}

		#region ICommand Member

		public override bool Execute()
		{
			this._oldName = this._targetRole.Name;
			this._targetRole.Name = this._newName;

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
			this._targetRole.Name = this._oldName;

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
				return this._targetRole;
			}
		}

		public override object Clone()
		{
			return new ChangeRoleNameCmd(this._targetRole, this._newName);
		}
		#endregion
	}
}
