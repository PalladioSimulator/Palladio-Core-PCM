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
		/// <summary>
		/// </summary>
		protected Palladio.Editor.Common.EntityProxies.EventArgs _evtArgs;

		/// <summary>
		/// 
		/// </summary>
		public AbstractCommand()
		{
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public abstract bool Execute();

		/// <summary>
		/// 
		/// </summary>
		public abstract bool CanUndo
		{
			get;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public abstract bool Undo();

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public abstract object Clone();

		/// <summary>
		/// Returns EventArgs to inform about changes made by the command.
		/// </summary>
		public Palladio.Editor.Common.EntityProxies.EventArgs EventArgs
		{
			get
			{
				return this._evtArgs;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		public abstract object Receiver
		{
			get;
		}

	}
}
