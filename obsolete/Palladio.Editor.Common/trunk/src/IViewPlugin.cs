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

using Palladio.Identifier;

namespace Palladio.Editor.Common
{
	/// <summary>
	/// An enumeration to specify where a viewplugin should be placed
	/// within GUI.
	/// </summary>
	public enum ViewControlPosition
	{
		/// <summary>Places the plugin control into a floating or freely dockable frame.</summary>
		FLOAT,
		/// <summary>Places the plugin control into the MDI container.</summary>
		MDI_CONTAINER,
	}

	/// <summary>
	/// The IViewPlugin interface provides services that have to be implemented by
	/// a view plugin.
	/// </summary>
	public interface IViewPlugin : IPlugin
	{
		/// <summary>
		/// Informs the host that the user has selected another element.
		/// </summary>
		event SelectionChangedHandler SelectionChanged;

		/// <summary>
		/// This method is called when a plugin becomes active.
		/// </summary>
		/// <param name="host">The host of the view plugin</param>
		/// <returns>Returns true if initalization process was successful.</returns>
		bool Initialize(IViewPluginHost host);

		/// <summary>
		/// Returns the view control component for presentation and user interaction.
		/// </summary>
		System.Windows.Forms.Control ViewControl { get; }

		/// <summary>
		/// Returns a value that indicates where the ViewControl should be placed within the GUI.
		/// </summary>
		ViewControlPosition ViewControlPosition { get; }

		/// <summary>
		/// Returns the toolbox control component for selecting modelling tools.
		/// </summary>
		Object[] ToolboxItems { get; }

		/// <summary>
		/// Instructs the plugin to select the specified entity
		/// </summary>
		/// <param name="entity">The entity that should become selected.</param>
		void Select(EntityProxies.EntityProxy entity);
	}
}
