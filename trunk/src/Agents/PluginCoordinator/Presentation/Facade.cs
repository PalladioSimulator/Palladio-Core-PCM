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

using Palladio.Editor.Common;

namespace Palladio.Editor.Core.Agents.PluginCoordinator.Presentation
{
	/// <summary>
	/// A Facade to the Presentation subsystem of the PluginCoordinator PAC agent.
	/// </summary>
	internal class Facade
	{
		#region Fields
		/// <summary>
		/// Form to add and remove plugins</summary>
		private PluginControlForm _controlForm;

		/// <summary>
		/// An interface to the abstraction component </summary>
		private IAbstractionAdapter _abstraction;
		#endregion

		#region Public Events
		public event FileEventHandler AddPluginRequested;
		public event EventHandler RemovePluginRequested;
		public event EventHandler ActivatePluginRequested;
		public event EventHandler DeactivatePluginRequested;
		#endregion

		#region Constructors
		public Facade(IAbstractionAdapter abstraction)
		{
			this._abstraction = abstraction;
			this._controlForm = new PluginControlForm(this);
		}
		#endregion

		#region Public Properties
		public IAbstractionAdapter Abstraction
		{
			get
			{
				return this._abstraction;
			}
		}
		#endregion

		#region Public Methods
		public void UpdatePluginList(PluginInfo[] infos)
		{
			this._controlForm.UpdateList(infos);
		}

		public void ShowPluginControlDialog()
		{
			this._controlForm.ShowDialog();
		}

		public int GetSelectedPluginListIndex()
		{
			return this._controlForm.GetSelectedPluginListIndex();
		}
		#endregion

		#region Event Actuators
		public void FireAddPluginRequested(string filename)
		{
			if (this.AddPluginRequested != null)
				this.AddPluginRequested(this, new System.IO.FileInfo( filename ));
		}

		public void FireRemovePluginRequested()
		{
			if (this.RemovePluginRequested != null)
				this.RemovePluginRequested(this, new System.EventArgs());
		}

		public void FireActivatePluginRequested()
		{
			if (this.ActivatePluginRequested != null)
				this.ActivatePluginRequested(this, new System.EventArgs());
		}

		public void FireDeactivatePluginRequested()
		{
			if (this.DeactivatePluginRequested != null)
				this.DeactivatePluginRequested(this, new System.EventArgs());
		}
		#endregion
	}
}
