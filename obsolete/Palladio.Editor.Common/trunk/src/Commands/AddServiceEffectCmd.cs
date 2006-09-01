using System;

using Palladio.Identifier;
using Palladio.ComponentModel;
using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Common.Commands
{
	/// <summary>
	/// Zusammenfassung für AddServiceEffectCmd.
	/// </summary>
	public class AddServiceEffectCmd : AbstractCommand
	{
		private IBasicComponent _targetComp;
		private IIdentifier _ifaceID;
		private IIdentifier _sigID;
		private IServiceEffectSpecification _createdServiceEffect;

		public AddServiceEffectCmd(IBasicComponent comp, IIdentifier ifaceID, IIdentifier sigID)
		{
			this._targetComp = comp;
			this._ifaceID = ifaceID;
			this._sigID = sigID;
		}

		#region ICommand Member

		public override bool Execute()
		{
			if (this._createdServiceEffect == null)
				this._createdServiceEffect = ComponentFactory.CreateServiceEffectSpecification();

			this._targetComp.AddServiceEffectSpecification(this._ifaceID, this._sigID, this._createdServiceEffect);

			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.SERVICEEFFECTSPECS_CHANGED,
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
			this._targetComp.DeleteServiceEffectSpecification(ComponentFactory.CreateService(this._targetComp.GetProvidesRoleByInterfaceID(this._ifaceID).Interface, this._sigID));
			
			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.SERVICEEFFECTSPECS_CHANGED,
				null);

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
			return new AddServiceEffectCmd(this._targetComp, this._ifaceID, this._sigID);
		}
		#endregion
	}
}
