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
using System.Collections;
using System.Windows.Forms;

namespace Palladio.Editor.Core.Agents.AnalyzeCoordinator
{
	/// <summary>
	/// Agent-internal interface for passing data to the Presentation component.
	/// </summary>
	internal interface IAbstractionAdapter
	{
		string[] AttachedPlugins {get;}
		string GetPluginName(string type);
		UserControl GetConfigControl(string type);
	}
}
