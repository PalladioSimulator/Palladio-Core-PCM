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
	/// Zusammenfassung für PluginInfoAttribute.
	/// </summary>
	[AttributeUsage(AttributeTargets.Class, AllowMultiple = false)]
	public class PluginInfoAttribute : System.Attribute
	{

		private string name = "Unknown";
		private string author = "Unknown";
		private string version = "0";
		private string description = "No description";

		/// <summary>
		/// 
		/// </summary>
		public string Name
		{
			get { return this.name; }
			set { this.name = value; }
		}

		/// <summary>
		/// 
		/// </summary>
		public string Author
		{
			get { return this.author; }
			set { this.author = value; }
		}

		/// <summary>
		/// 
		/// </summary>
		public string Version
		{
			get { return this.version; }
			set { this.version = value; }
		}

		/// <summary>
		/// 
		/// </summary>
		public string Description
		{
			get { return this.description; }
			set {this.description = value; }
		}
	}
}
