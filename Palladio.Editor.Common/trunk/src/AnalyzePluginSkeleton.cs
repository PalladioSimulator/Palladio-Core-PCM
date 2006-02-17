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

namespace Palladio.Editor.Common
{
	/// <summary>
	/// This is the base class for all analysis plugins. Derive from this class if you 
	/// want to implement an analysis method.
	/// </summary>
	public abstract class AnalyzePluginSkeleton : PluginSkeleton, IAnalyzePlugin
	{
		#region Fields
		/// <summary>
		/// The analyze plugins host.</summary>
		protected IAnalyzePluginHost _host;

		/// <summary>
		/// value of CanStart property</summary>
		private bool _canStart;
		#endregion

		#region Public Events
		/// <summary>
		/// Event indicating that the value of CanStart has changed.</summary>
		public event EventHandler CanStartChanged;
		#endregion

		#region Constructors
		/// <summary>
		/// 
		/// </summary>
		/// <param name="name">Name</param>
		/// <param name="descr">Description</param>
		/// <param name="author">Author</param>
		/// <param name="version">Version</param>
		public AnalyzePluginSkeleton(string name, string descr, string author, string version)
			: base(name,descr,author,version)
		{
			this._canStart = true;
		}
		#endregion

		/// <summary>
		/// This method is called when a plugin becomes active.
		/// </summary>
		/// <param name="host">The host of the analysis plugin.</param>
		/// <returns>Returns true if initalization process was successful.</returns>
		public virtual bool Initialize(IAnalyzePluginHost host)
		{
			this._host = host;
			return true;
		}

		/// <summary>
		/// Override this property to return the config control that is integrated into 
		/// the analyses configuration form when the plugin gets selected.
		/// </summary>
		public virtual UserControl ConfigControl 
		{ 
			get { return null; }
		}

		/// <summary>
		/// Override this property to return the result control that visualizes 
		/// informations about the last run of the analysis method.
		/// </summary>
		public virtual UserControl ResultControl 
		{ 
			get { return null; }
		}

		/// <summary>
		/// Returns an array of required attribute types.
		/// </summary>
		public abstract System.Type[] RequiredAttributeTypes { get;	}

		/// <summary>
		/// Called when the configuration control becomes visible. Override
		/// in order to update your custom ConfigControl.
		/// </summary>
		public virtual void UpdateConfigControl()
		{
			return;
		}

		/// <summary>
		/// Indicates whether the analysis method is ready for execution.
		/// Fires <see cref="CanStartChanged"/> when the value changes.
		/// </summary>
		public virtual bool CanStart
		{
			get { return this._canStart; }
			set
			{
				if (value != this._canStart)
				{
					this._canStart = value;
					if (this.CanStartChanged != null)
						this.CanStartChanged(this, new System.EventArgs());
				}
			}
		}

		/// <summary>
		/// Starts the analysis method. Override this method with the implementation
		/// of your custom analysis method
		/// </summary>
		public abstract void Start();

	}
}
