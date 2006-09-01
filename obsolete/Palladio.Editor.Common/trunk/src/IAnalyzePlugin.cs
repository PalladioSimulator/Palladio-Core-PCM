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
	/// The IAnalyzePlugin interface provides services that have to be implemented by
	/// an analysis plugin.
	/// </summary>
	public interface IAnalyzePlugin : IPlugin
	{

		/// <summary>
		/// Event indicating that the value of CanStart has changed.</summary>
		event EventHandler CanStartChanged;

		/// <summary>
		/// This method is called when a plugin becomes active.
		/// </summary>
		/// <param name="host">The host of the analysis plugin.</param>
		/// <returns>Returns true if initalization process was successful.</returns>
		bool Initialize(IAnalyzePluginHost host);

		/// <summary>
		/// Returns the config control that is integrated into the analyses configuration form
		/// when the plugin gets selected.
		/// </summary>
		UserControl ConfigControl { get; }

		/// <summary>
		/// Returns the result control that visualizes informations about the last run of the 
		/// analysis method.
		/// </summary>
		UserControl ResultControl { get; }

		/// <summary>
		/// Returns an array of required attribute types.
		/// </summary>
		System.Type[] RequiredAttributeTypes
		{
			get;
		}

		/// <summary>
		/// Called when the configuration control becomes visible.
		/// </summary>
		void UpdateConfigControl();

		/// <summary>
		/// Indicates whether the analysis method is ready for execution.
		/// </summary>
		bool CanStart { get; }

		/// <summary>
		/// Starts the analysis method.
		/// </summary>
		void Start();
	}
}
