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
	/// Zusammenfassung für AddProvidesInterfaceCmd.
	/// </summary>
	public class AddProvidesInterfaceCmd : AbstractCommand
	{
		private IComponent _targetComp;
		private string _rolename;
		private string _ifacename;
		private IInterfaceModel _createdIface;

		public AddProvidesInterfaceCmd(IComponent component, string rolename, string ifacename)
		{
			this._targetComp = component;
			this._rolename = rolename;
			this._ifacename = ifacename;
		}

		#region ICommand Member

		public override bool Execute()
		{
			if (this._createdIface == null)
				this._createdIface = ComponentFactory.CreateInterfaceModel(this._ifacename);
			this._targetComp.AddProvidesInterface(this._createdIface);
			IRole role = this._targetComp.GetProvidesRoleByInterfaceID(this._createdIface.ID);
			role.Name = this._rolename;

			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.PROVIDESINTERFACE_ADDED,
				this._createdIface.ID.Clone() as IIdentifier);
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
			IRole role = this._targetComp.GetProvidesRoleByInterfaceID(this._createdIface.ID);
			this._targetComp.DeleteProvidesInterfaces(role.ID);

			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.PROVIDESINTERFACE_REMOVED,
				this._createdIface.ID.Clone() as IIdentifier);
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
			return new AddProvidesInterfaceCmd(this._targetComp, this._rolename, this._ifacename);
		}
		#endregion
	}
}
