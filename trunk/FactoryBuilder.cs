using System;
using BibTeX.Parser.Interfaces;

namespace BibTeX.Parser
{
	/// <summary>
	/// Singleton pattern to create bibtex parser
	/// </summary>
	public abstract class FactoryBuilder
	{
		/// <summary>
		/// Create a new BibTeX Factory object
		/// </summary>
		/// <returns>A bibtex factory</returns>
		public static IBibTeXFactory CreateBibTeXFactory()
		{
			return new BibTeXFactory();
		}
	}
}
