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
	/// Zusammenfassung für PluginSkeleton.
	/// </summary>
	public abstract class PluginSkeleton : AbstractPlugin
	{

		/// <summary>
		/// 
		/// </summary>
		/// <param name="name"></param>
		/// <param name="descr"></param>
		/// <param name="author"></param>
		/// <param name="version"></param>
		public PluginSkeleton(string name, string descr, string author, string version)
		{
			this._name = name;
			this._description = descr;
			this._author = author;
			this._version = version;
		}

		/// <summary>
		/// 
		/// </summary>
		public override sealed string Name
		{
			get { return this._name; }
		}

		/// <summary>
		/// 
		/// </summary>
		public override sealed string Description
		{
			get	{ return this._description; }
		}

		/// <summary>
		/// 
		/// </summary>
		public override sealed string Author
		{
			get { return this._author; }
		}

		/// <summary>
		/// 
		/// </summary>
		public override sealed string Version
		{
			get { return this._version; }
		}
	}
}
