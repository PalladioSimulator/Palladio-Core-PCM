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
	/// An enumeration to describe the current status of a plugin
	/// </summary>
	public enum PluginStatus
	{
		/// <summary>Plugin is inactive</summary>
		INACTIVE,
		/// <summary>Plugin is active</summary>
		ACTIVE
	}

	/// <summary>
	/// An enumeration to describe a plugin's field of duty
	/// </summary>
	public enum PluginType
	{
		/// <summary>Plugin provides a view on the model</summary>
		VIEW,
		/// <summary>Plugin analyzes the model</summary>
		ANALYZE,
		/// <summary>Plugin provides an import filter</summary>
		IMPORT,
		/// <summary>Plugin provides an export filter</summary>
		EXPORT
	}

	/// <summary>
	/// The IPlugin interface provides the most basic members a
	/// plugin implementation must provide.
	/// </summary>
	public interface IPlugin
	{
		string Name				{ get; }
		string Description		{ get; }
		string Author			{ get; }
		string Version			{ get; }

		void Detach();
	}
}
