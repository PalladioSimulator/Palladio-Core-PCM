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
	/// Zusammenfassung für AbstractPlugin.
	/// </summary>
	public abstract class AbstractPlugin : MarshalByRefObject, IPlugin
	{
		/// <summary>
		/// 
		/// </summary>
		public AbstractPlugin()
		{
			this._name			= "undef";
			this._description	= "undef";
			this._author		= "undef";
			this._version		= "undef";
		}

		/// <summary>
		/// Name
		/// </summary>
		protected string _name;
		/// <summary>
		/// Returns the name
		/// </summary>
		public abstract string Name	{ get; }

		/// <summary>
		/// Description
		/// </summary>
		protected string _description;
		/// <summary>
		/// Returns the description
		/// </summary>
		public abstract string Description { get; }

		/// <summary>
		/// Author
		/// </summary>
		protected string _author;
		/// <summary>
		/// Returns the author
		/// </summary>
		public abstract string Author {	get; }

		/// <summary>
		/// Version
		/// </summary>
		protected string _version;
		/// <summary>
		/// Returns the version
		/// </summary>
		public abstract string Version { get; }

		/// <summary>
		/// 
		/// </summary>
		public abstract void Detach();
	}
}
