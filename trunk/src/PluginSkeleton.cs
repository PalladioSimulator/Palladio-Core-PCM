using System;

namespace Palladio.Editor.Common
{
	/// <summary>
	/// Zusammenfassung für PluginSkeleton.
	/// </summary>
	public abstract class PluginSkeleton : AbstractPlugin
	{
		public override event PluginStatusChangedHandler StatusChanged;

		public PluginSkeleton()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}

		public override sealed PluginStatusEnum Status
		{
			get { return base.Status; }
			set 
			{
				if (base.Status != value) 
				{
					base.Status = value;
					if (value == PluginStatusEnum.ACTIVE) 
					{
						OnActivate();
						if (this.StatusChanged != null)
							StatusChanged(this,PluginStatusEnum.ACTIVE);
						return;
					}
					if (value == PluginStatusEnum.INACTIVE) 
					{
						OnInactivate();
						if (this.StatusChanged != null)
							StatusChanged(this,PluginStatusEnum.INACTIVE);
						return;
					}
				}
			}
		}

		public override sealed string Name
		{
			get { return this._name; }
		}

		public override sealed string Description
		{
			get	{ return this._description; }
		}

		public override sealed string Author
		{
			get { return this._author; }
		}

		public override sealed string Version
		{
			get { return this._version; }
		}

		protected abstract void OnActivate();
		protected abstract void OnInactivate();
	}
}
