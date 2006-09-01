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

namespace Palladio.Editor.Core.Agents.Root
{
	/// <summary>
	/// Agent-internal interface for passing data from the Abstraction to the Presentation component.
	/// </summary>
	internal interface IAbstractionAdapter
	{
		/// <summary>
		/// The name of the file which is associated with the active component model and
		/// to which it is stored when calling the 'Save' routine.
		/// </summary>
		string ModelFileName { get; set; }
	}
}
