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

namespace Palladio.Editor.Core.Agents.PluginCoordinator
{
	/// <summary>
	/// Agent-internal interface for passing data from the Abstraction to the Presentation component.
	/// </summary>
	internal interface IAbstractionAdapter
	{
		PluginInfo[] GetPluginInfos();
		PluginInfo GetPluginInfo(int index);
	}
}
