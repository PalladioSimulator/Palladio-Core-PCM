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
	/// Zusammenfassung für AddCompositeComponentCmd.
	/// </summary>
	public class AddCompositeComponentCmd : AbstractCommand
	{
		private ICompositeComponent _targetComp;
		private string _name;
		private ICompositeComponent _createdComp;

		public AddCompositeComponentCmd(ICompositeComponent component, string name)
		{
			this._targetComp = component;
			this._name = name;
		}

		#region ICommand Member

		public override bool Execute()
		{
			if (this._createdComp == null)
			{
				ICompositeComponent comp = ComponentFactory.CreateCompositeComponent(this._name);
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
			return new AddCompositeComponentCmd(this._targetComp, this._name);
		}
		#endregion
	}
}
