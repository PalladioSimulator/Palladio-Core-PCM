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
using Palladio.ComponentModel.Exceptions;
using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Common.Commands
{
	/// <summary>
	/// Zusammenfassung für AddBindingCmd.
	/// </summary>
	public class AddProvidesMappingCmd : AbstractCommand
	{
		private ICompositeComponent _targetComp;
		private IIdentifier _role1ID;
		private IIdentifier _comp2ID;
		private IIdentifier _role2ID;
		private IMapping _createdMapping;

		public AddProvidesMappingCmd(ICompositeComponent component, IIdentifier role1ID, IIdentifier comp2ID, IIdentifier role2ID)
		{
			this._targetComp = component;
			this._role1ID = role1ID;
			this._comp2ID = comp2ID;
			this._role2ID = role2ID;
		}

		#region ICommand Member

		public override bool Execute()
		{
			if (this._createdMapping == null)
			{
				try 
				{
					this._createdMapping = ComponentFactory.CreateProvidesMapping(
						this._targetComp,
						this._role1ID,
						this._targetComp.GetComponent(this._comp2ID),
						this._role2ID);
				} 
				catch (Exception e)
				{
					return false;
				}
			}
			try
			{
				this._targetComp.AddProvidesMappings(this._createdMapping);
			}
			catch(InvalidRoleException e)
			{
				return false;
			}

			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.PROVIDESMAPPING_ADDED,
				this._createdMapping.ID.Clone() as IIdentifier);

			return true;
		}

		public override bool CanUndo
		{
			get
			{
				return false;
			}
		}

		public override bool Undo()
		{
			//			this._targetComp.DeleteComponents(this._createdComp.ID);
			//
			//			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
			//				EntityChangeReason.COMPONENT_REMOVED,
			//				this._createdComp.ID.Clone() as IIdentifier);

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
			return new AddProvidesMappingCmd(this._targetComp, this._role1ID, this._comp2ID, this._role2ID);
		}
		#endregion
	}
}
