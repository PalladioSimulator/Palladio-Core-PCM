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
	/// Zusammenfassung für AddBasicComponentCmd.
	/// </summary>
	public class AddBasicComponentCmd : AbstractCommand
	{
		private ICompositeComponent _targetComp;
		private string _name;
		private IBasicComponent _createdComp;

		public AddBasicComponentCmd(ICompositeComponent component, string name)
		{
			this._targetComp = component;
			this._name = name;
		}

		#region ICommand Member

		public override bool Execute()
		{
			if (this._createdComp == null)
			{
				IBasicComponent comp = ComponentFactory.CreateBasicComponent(this._name);
				IInterfaceModel iface = ComponentFactory.CreateInterfaceModel("ProvidesInterface");
				comp.AddProvidesInterface(iface);
				IRole role = comp.GetProvidesRoleByInterfaceID(iface.ID);
				role.Name = "ProvidesRole";
				this._createdComp = comp;
			}
			this._targetComp.AddComponents(this._createdComp);

			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.COMPONENT_ADDED,
				this._createdComp.ID.Clone() as IIdentifier);

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
			this._targetComp.DeleteComponents(this._createdComp.ID);

			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.COMPONENT_REMOVED,
				this._createdComp.ID.Clone() as IIdentifier);

			return true;
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
			return new AddBasicComponentCmd(this._targetComp, this._name);
		}
		#endregion
	}
}
