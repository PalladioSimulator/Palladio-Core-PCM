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
	/// This is the host interface for view plugins.
	/// </summary>
	public interface IViewPluginHost : IPluginHost
	{
		/// <summary>
		/// Event to notify attached plugins about the component model being changed.</summary>
		event ComponentModelChangedHandler ComponentModelChanged;

		/// <summary>
		/// Event to notify attached plugins about changes in the model.</summary>
		event EntityChangedHandler EntityChanged;

		/// <summary>
		/// Returns the open component model.
		/// </summary>
		/// <returns>A proxy object for the current component model.</returns>
		EntityProxies.CompositeComponentProxy GetComponentModel();
	}
}
