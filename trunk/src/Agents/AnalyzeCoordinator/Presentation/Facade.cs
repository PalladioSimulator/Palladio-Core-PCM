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
using System.Windows.Forms;

using Palladio.Editor.Common;

namespace Palladio.Editor.Core.Agents.AnalyzeCoordinator.Presentation
{
	/// <summary>
	/// A Facade to the Presentation subsystem of the AnalyzeCoordinator PAC agent.
	/// </summary>
	internal class Facade
	{
		#region Fields
		/// <summary>
		/// Form to add and remove plugins</summary>
		private AnalysesControlForm _controlForm;

		/// <summary>
		/// An interface to the abstraction component </summary>
		private IAbstractionAdapter _abstraction;
		#endregion

		#region Public Events
		public event StringEventHandler AnalysisStartRequested;
		#endregion

		public Facade(IAbstractionAdapter abstraction)
		{
			this._abstraction = abstraction;
			this._controlForm = new AnalysesControlForm(this);
		}

		#region Public Properties
		public IAbstractionAdapter Abstraction
		{
			get
			{
				return this._abstraction;
			}
		}
		#endregion

		public void ShowAnalysesControlDialog(string pluginType)
		{
			this._controlForm.UpdateComboBox();
			this._controlForm.SelectPlugin(pluginType);
			this._controlForm.ShowDialog();
		}

		public string GetPluginName(string pluginType)
		{
			return this._abstraction.GetPluginName(pluginType);
		}

		public UserControl GetConfigControl(string pluginType)
		{
			return this._abstraction.GetConfigControl(pluginType);
		}

		public bool CanStart
		{
			set
			{
				this._controlForm.CanStart = value;
			}
		}

		public void CanStartChanged(string type, bool canStart)
		{
			this._controlForm.CanStartChanged(type, canStart);
		}

		#region Event Actuators
		public void FireAnalysisStartRequested(string pluginType)
		{
			if (this.AnalysisStartRequested != null)
				this.AnalysisStartRequested(this, pluginType);
		}
		#endregion
	}
}
