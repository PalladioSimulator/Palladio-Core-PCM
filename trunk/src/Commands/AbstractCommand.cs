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

namespace Palladio.Editor.Common.Commands
{
	/// <summary>
	/// Zusammenfassung für AbstractCommand.
	/// </summary>
	public abstract class AbstractCommand : ICommand
	{
		protected Palladio.Editor.Common.EntityProxies.EventArgs _evtArgs;

		public AbstractCommand()
		{
		}

		public abstract bool Execute();

		public abstract bool CanUndo
		{
			get;
		}

		public abstract bool Undo();

		public abstract object Clone();

		public abstract Palladio.Editor.Common.EntityProxies.EventArgs EventArgs
		{
			get;
		}

		public abstract object Receiver
		{
			get;
		}

	}
}
