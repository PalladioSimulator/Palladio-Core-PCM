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
	/// within the dockable GUI.
	/// </summary>
	public enum UserControlPosition
	{
		/// <summary>Places the plugin control into a floating or freely dockable frame.</summary>
		FLOAT,
		/// <summary>Places the plugin control into the MDI container.</summary>
		MDI_CONTAINER,
	}

	/// <summary>
	/// Zusammenfassung für IViewPlugin.
	/// </summary>
	public interface IViewPlugin : IPlugin
	{
		/// <summary>
		/// 
		/// </summary>
		event SelectionChangedHandler SelectionChanged;

		/// <summary>
		/// 
		/// </summary>
		/// <param name="host"></param>
		/// <returns></returns>
		bool Initialize(IViewPluginHost host);

		/// <summary>
		/// 
		/// </summary>
		System.Windows.Forms.Control ViewControl { get; }

		/// <summary>
		/// 
		/// </summary>
		UserControlPosition UserControlPosition { get; }

		/// <summary>
		/// 
		/// </summary>
		Object[] ToolboxItems { get; }

		/// <summary>
		/// 
		/// </summary>
		/// <param name="adapter"></param>
		void Select(EntityProxies.EntityProxy adapter);
	}
}
