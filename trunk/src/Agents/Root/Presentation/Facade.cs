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
using Palladio.Editor.Core.Agents.Root;

namespace Palladio.Editor.Core.Agents.Root.Presentation
{
	/// <summary>
	/// A Facade to the Presentation subsystem of the root PAC agent
	/// which is responsible for the main GUI control.
	/// </summary>
	internal class Facade
	{
		#region Fields
		/// <summary>
		/// Instance of the main graphical user interface </summary>
		private GUIMainForm _mainForm;

		/// <summary>
		/// An interface to the abstraction component </summary>
		private IAbstractionAdapter _abstraction;
		#endregion

		#region Public Events
		public event EventHandler NewComponentModelRequested;
		public event FileEventHandler OpenComponentModelRequested;
		public event FileEventHandler SaveComponentModelAsRequested;
		public event EventHandler SaveComponentModelRequested;
		public event EventHandler PluginControlDialogRequested;
		public event StringEventHandler AnalysesControlDialogRequested;
		public event EventHandler ExitApplicationRequested;
		public event EventHandler UndoRequested;
		public event EventHandler RedoRequested;
		#endregion

		#region Constructor
		public Facade(IAbstractionAdapter abstraction)
		{
			this._abstraction = abstraction;
			this._mainForm = new GUIMainForm(this);
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

		public object SelectedObject
		{
			get
			{
				return this._mainForm.GetSelectedObject();
			}
			set
			{
				this._mainForm.SetSelectedObject(value);
			}
		}

		public bool CanUndo
		{
			get
			{
				return this._mainForm.CanUndo;
			}
			set
			{
				this._mainForm.CanUndo = value;
			}
		}

		public bool CanRedo
		{
			get
			{
				return this._mainForm.CanRedo;
			}
			set
			{
				this._mainForm.CanRedo = value;
			}
		}

		#endregion

		#region Public Methods
		public void Show()
		{
			this._mainForm.Show();
		}

		public void AddView(IViewPlugin plugin)
		{
			this._mainForm.AddView(plugin);
		}

		public void RemoveView(string type)
		{
			this._mainForm.RemoveView(type);
		}

		public void AddAnalysis(IAnalyzePlugin plugin)
		{
			this._mainForm.AddAnalysis(plugin);
		}

		public void AddAnalysisResult(System.Windows.Forms.UserControl result)
		{
			this._mainForm.AddAnalysisResult(result);
		}	
		#endregion

		#region Event Actuators
		public void FireNewComponentModelRequested()
		{
			if (this.NewComponentModelRequested != null)
				this.NewComponentModelRequested(this, new System.EventArgs());
		}

		public void FirePluginControlDialogRequested()
		{
			if (this.PluginControlDialogRequested != null)
				this.PluginControlDialogRequested(this, new System.EventArgs());
		}

		public void FireExitApplicationRequested()
		{
			if (this.ExitApplicationRequested != null)
				this.ExitApplicationRequested(this, new System.EventArgs());
		}

		public void FireOpenComponentModelRequested(string filename)
		{
			if (this.OpenComponentModelRequested != null)
				this.OpenComponentModelRequested(this, new System.IO.FileInfo(filename));
		}

		public void FireSaveComponentModelAsRequested(string filename)
		{
			if (this.SaveComponentModelAsRequested != null)
				this.SaveComponentModelAsRequested(this, new System.IO.FileInfo(filename));
		}

		public void FireSaveComponentModelRequested()
		{
			if (this.SaveComponentModelRequested != null)
				this.SaveComponentModelRequested(this, new System.EventArgs());
		}

		public void FireUndoRequested()
		{
			if (this.UndoRequested != null)
				this.UndoRequested(this, new System.EventArgs());
		}

		public void FireRedoRequested()
		{
			if (this.RedoRequested != null)
				this.RedoRequested(this, new System.EventArgs());
		}

		public void FireAnalysesControlDialogRequested(string type)
		{
			if (this.AnalysesControlDialogRequested != null)
				this.AnalysesControlDialogRequested(this, type);
		}
		#endregion

	}
}
