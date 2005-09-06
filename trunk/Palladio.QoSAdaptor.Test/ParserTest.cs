#region info
///////////////////////////////////////////////////////////////////////////////
/// This software has been developed as a part of the diploma thesis 
/// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage für 
/// Komponentenadapter" ("Influence of the configuration of a generator on the 
/// prediction of the QoS of component adaptors")
/// at the 
/// University of Oldenburg
/// Department of Computing Science
/// Software Engineering Group
/// Palladio Research Group
/// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
/// 
/// Development period: July 2005 - January 2006
/// 
/// Author: Niels Streekmann
/// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion
using Palladio.QoSAdaptor.GUI;
using Palladio.QoSAdaptor.Pattern;
using System;
using System.Collections;
using System.Windows.Forms;

namespace Palladio.QoSAdaptor.Test
{
	/// <summary>
	/// Main class of a test application testing PatternDescription and GUI
	/// without the QMLComparison.
	/// </summary>
	public class ParserTest
	{
		/// <summary>
		/// Main method of the parser test.
		/// </summary>
		/// <param name="args">A list of XML pattern descriptions. The 
		/// descriptions have to match PatternDescription.dtd.</param>
		[STAThread]
		static void Main(string[] args) 
		{
			IList list = new ArrayList();

			// Parser the given patterns
			IEnumerator enu = args.GetEnumerator();
			while (enu.MoveNext())
			{
				PatternDescriptionParser parser = new PatternDescriptionParser(
					(string)enu.Current);
				PatternDescription pattern = parser.Pattern;
				list.Add(pattern);
			}	

			// Run the GUI with the given patterns.
			if (list.Count > 0)
				Application.Run(new ChoiceDialog(list));
			else
				Console.WriteLine("At least one pattern description has to be given as a parameter.");
			
		}
	}
}
