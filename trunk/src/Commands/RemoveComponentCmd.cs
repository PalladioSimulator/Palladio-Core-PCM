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
	/// Zusammenfassung für RemoveComponentCmd.
	/// </summary>
	public class RemoveComponentCmd : AbstractCommand
	{
		private ICompositeComponent _targetComp;
		private IIdentifier _deleteID;
		private IComponent _deletedComp;

		public RemoveComponentCmd(ICompositeComponent component, IIdentifier id)
		{
			this._targetComp = component;
			this._deleteID = id;
		}

		#region ICommand Member

		public override bool Execute()
		{
			this._deletedComp = this._targetComp.GetComponent(this._deleteID);
			if (this._deletedComp != null)
			{
				this._targetComp.DeleteComponents(this._deleteID);

				this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
					EntityChangeReason.COMPONENT_REMOVED,
					this._deleteID);
				return true;
			}
			else 
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
			if (this._deletedComp == null)
				return false;

			this._targetComp.AddComponents(this._deletedComp);

			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.COMPONENT_ADDED,
				this._deletedComp.ID.Clone() as IIdentifier);
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
				return this._targetComp;
			}
		}

		public override object Clone()
		{
			return new RemoveComponentCmd(this._targetComp, this._deleteID);
		}
		#endregion
	}
}
