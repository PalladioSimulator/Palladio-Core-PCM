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

namespace Palladio.Editor.Common
{
	/// <summary>
	/// Zusammenfassung für IViewPluginHost.
	/// </summary>
	public interface IViewPluginHost : IPluginHost
	{
		/// <summary>
		/// </summary>
		event ComponentModelChangedHandler ComponentModelChanged;

		/// <summary>
		/// </summary>
		event EntityChangedHandler EntityChanged;

		/// <summary>
		/// </summary>
		/// <returns></returns>
		EntityProxies.CompositeComponentProxy GetComponentModel();
	}
}
