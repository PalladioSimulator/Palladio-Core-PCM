using System;

using Palladio.Identifier;
using Palladio.ComponentModel;
using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Common.Commands
{
	/// <summary>
	/// Zusammenfassung für AddServiceEffectCmd.
	/// </summary>
	public class AddServiceToServiceEffectCmd : AbstractCommand
	{
		private IServiceEffectSpecification _target;
		private IService _service;
		private SignatureProxy _serviceProxy;

		public AddServiceToServiceEffectCmd(IServiceEffectSpecification sef, IService service, SignatureProxy serviceProxy)
		{
			this._target = sef;
			this._service = service;
			this._serviceProxy = serviceProxy;
		}

		#region ICommand Member

		public override bool Execute()
		{
			this._target.SignatureList.AddSignatures(this._service);

			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.SERVICE_IN_SEFFSPEC_ADDED,
				this._service.ID);

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
			this._target.SignatureList.DeleteSignatures(this._service);
			
			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.SERVICE_IN_SEFFSPEC_REMOVED,
				this._service.ID);

			return true;
		}

		public override object Receiver
		{
			get
			{
				return this._target;
			}
		}

		public override object Clone()
		{
			return new AddServiceToServiceEffectCmd(this._target, this._service, this._serviceProxy);
		}
		#endregion

		public SignatureProxy SignatureProxy
		{
			get
			{
				return this._serviceProxy;
			}
		}
	}
}
