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
using Palladio.Editor.Common.EntityProxies;
using Palladio.ComponentModel;

namespace Palladio.Editor.Core.Interfaces
{
	/// <summary>
	/// Zusammenfassung für IViewCoordinator.
	/// </summary>
	internal interface IViewCoordinator
	{
		/// <summary>
		/// Fired when an attached plugin selected a model entity
		/// </summary>
		event SelectionChangedHandler SelectionChanged;

		/// <summary>
		/// 
		/// </summary>
		void Initialize();

		/// <summary>
		/// Attach plugin indicated by pluginInfo.
		/// </summary>
		/// <param name="pluginInfo">Data struct containing informations about the plugin.</param>
		void AttachPlugin(PluginInfo pluginInfo);

		/// <summary>
		/// Detach plugin with the indicated type name.
		/// </summary>
		/// <param name="type">The type name of the plugin.</param>
		void DetachPlugin(string type);
	}
}
