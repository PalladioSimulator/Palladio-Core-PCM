#region info
///////////////////////////////////////////////////////////////////////////////
// This software has been developed as a part of the diploma thesis 
// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage für 
// Komponentenadapter" ("Influence of the configuration of a generator on the 
// prediction of the QoS of component adaptors")
// at the 
// University of Oldenburg
// Department of Computing Science
// Software Engineering Group
// Palladio Research Group
// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
// 
// Development period: July 2005 - January 2006
// 
// Author: Niels Streekmann
// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion

using System.Collections;
using System.Windows.Forms;
using Palladio.QoSAdaptor.Interfaces;
using Palladio.QoSAdaptor.Pattern;
using Palladio.Utils.Collections;

namespace Palladio.QoSAdaptor.PatternSelection
{
	/// <summary>
	/// Main class of the PatterSelection component. Controls the the GUI for 
	/// user choice.
	/// </summary>
	public class Selector : ISelector
	{
		#region attributes
		/// <summary>
		/// Hashmap that contains all mismatches and a list of patterns for 
		/// each mismatch that is able to correct the mismatch.
		/// </summary>
		private Hashmap mismatchSolvingPatterns;

		/// <summary>
		/// Instance of the selection GUI
		/// </summary>
		private SelectionDialog selectionDialog;

		/// <summary>
		/// Interface model specification of the required interface.
		/// </summary>
		private string requiredSpecification;

		/// <summary>
		/// Interface model specification of the provided interface.
		/// </summary>
		private string providedSpecification;

		/// <summary>
		/// The selected pattern.
		/// </summary>
		private IPatternDescription selectedPattern;
		#endregion

		#region public methods
		/// <summary>
		/// Starts the selection process, using a GUI where the user gets an 
		/// overview over found mismatches and patterns that are able to 
		/// correct these mismatches and returns a pattern chosen by the user. 
		/// </summary>
		/// <param name="mismatchSolvingPatterns">A hashmap containing 
		/// mismatches and a list of PatternsDescriptions of patterns able to 
		/// correct these mismatches.</param>
		/// <param name="requiredSpecification">Textual representation of the 
		/// required specification.</param>
		/// <param name="providedSpecification">Textual representation of the 
		/// provided specification.</param>
		/// <returns>The PatternsDescription of the chosen pattern.</returns>
		public IPatternDescription StartSelection (Hashmap mismatchSolvingPatterns, 
			string requiredSpecification, 
			string providedSpecification)
		{
			this.selectedPattern = null;
			this.mismatchSolvingPatterns = mismatchSolvingPatterns;
			this.requiredSpecification = requiredSpecification;
			this.providedSpecification = providedSpecification;

			this.selectionDialog = new SelectionDialog(
				mismatchSolvingPatterns, this);
			
			Application.Run(this.selectionDialog);
			return this.selectedPattern;
		}
		#endregion

		#region internal methods / event handling
		/// <summary>
		/// This method is called, when one of the buttons for the
		/// detailed view is clicked. 
		/// The method opens a new window which lists the details
		/// of the chosen pattern. 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		internal void Button_Click(object sender, System.EventArgs e)
		{
			string bName = ((Button)sender).Name;
			bool breakLoop = false;
			foreach (IMismatch mismatch in this.mismatchSolvingPatterns.Keys)
			{
				foreach (IPatternDescription pattern in 
					(IList)this.mismatchSolvingPatterns[mismatch])
				{
					if (pattern.Name.Equals(bName))
					{
						DetailView details = new DetailView(pattern);
						details.Show();
						breakLoop = true;
						break;
					}
				}
				// prevent that the DetailView is opened twice, because two
				// mismatches can be corrected by the same pattern.
				if (breakLoop)
					break;
			}
		}

		/// <summary>
		/// This method is called, when a generator button has 
		/// been clicked. 
		/// The method opens a new instance of CodeSmith for 
		/// every template that is listed in the 
		/// PatternDescription of the chosen pattern. 
		/// If no pattern is chosen a MessageBox is opened. 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		internal void Generator_Click(object sender, System.EventArgs e)
		{
			bool check = false;
			foreach (RadioButton rButton in this.selectionDialog.RButtons)
			{
				if (rButton.Checked)
				{
					check = true;
					this.selectedPattern = (IPatternDescription)rButton.Tag;
					this.selectionDialog.Close();
				}
			}
			if (!check)
				MessageBox.Show("No Pattern has been chosen.");
		}

		/// <summary>
		/// This method is called, when a specification button has 
		/// been clicked. 
		/// The method opens a new TextBox is open showing the chosen QML
		/// specification.
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		internal void Specification_Click(object sender, System.EventArgs e)
		{
			string buttonName = ((Button)sender).Name;
			if (buttonName.Equals("Required Specification"))
			{
				TextWindow textWindow = new TextWindow(buttonName, 
					this.requiredSpecification);
				textWindow.Show();
			}
			else if (buttonName.Equals("Provided Specification"))
			{
				TextWindow textWindow = new TextWindow(buttonName, 
					this.providedSpecification);
				textWindow.Show();
			}
		}
		#endregion
	}
}
