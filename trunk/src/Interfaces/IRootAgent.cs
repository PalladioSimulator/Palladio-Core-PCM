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
using Palladio.ComponentModel;
using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Core.Interfaces
{
	/// <summary>
	/// Zusammenfassung für ICoreAgent.
	/// </summary>
	internal interface IRootAgent
	{
		event ComponentModelChangedHandler ComponentModelChanged;
		event EntityChangedHandler EntityChanged;

		void Initialize();
		void PluginAttached(IPlugin plugin);
		void PluginDetached(PluginType pluginType, string systemType);

		CompositeComponentProxy GetComponentModel();

	}
}
