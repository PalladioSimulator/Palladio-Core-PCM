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
using System.IO;
using System.Windows.Forms;
using Palladio.QoSAdaptor.Configuration;
using Palladio.QoSAdaptor.PatternSelection;
using Palladio.QoSAdaptor.Pattern;
using Palladio.QoSAdaptor.QMLComparison;

namespace Palladio.QoSAdaptor.Control
{
	/// <summary>
	/// The main class of the QoSAdaptor software. Represents the only 
	/// interface that should be used from outside.
	/// 
	/// Takes two interface model specifications as arguments, where the first 
	/// is the required specification and the second is the provided 
	/// specification.
	/// 
	/// The application first calls the QMLComparison. If mismatches are 
	/// returned all pattern descriptions in the Patterns folder are parsed and
	/// for each returned mismatches aspect all adequate patterns are listed in
	/// a selection dialog. There on of the patterns can be selected and the 
	/// adaptor and the prediction model belonging to chosen pattern can be 
	/// generated.
	/// TODO: Overwork the ChoiceDialog and rename it to SelectionDialog.
	/// </summary>
	public class Controller
	{
		#region data
		private InterfaceModel interfaceModel;
		#endregion

		#region enumerations
		// enumeration representing the considered interface model
		public enum InterfaceModel
		{
			Syntax, 
			Behavior, 
			Interaction,
			Quality,
			Conceptual
		}
		#endregion

		#region public methods
		/// <summary>
		/// This method starts the the analysis of the interface models,
		/// the selection of a pattern that solves interface model mismatches 
		/// and the generation of an adaptor and a prediction model using that
		/// pattern.
		/// </summary>
		/// <param name="interfaceModel">The considered interface model.
		/// </param>
		/// <param name="required">The required interface model description.
		/// </param>
		/// <param name="provided">The provided interface model description.
		/// </param>
		public void Start(InterfaceModel interfaceModel, TextReader required, 
			TextReader provided)
		{
			this.interfaceModel = interfaceModel;

			IComparator comparator = new QMLComparator();

			IList mismatches = null;
			string requiredSpecification;
			string providedSpecification;
			try
			{
				mismatches = comparator.FindMismatches(required, provided);
				requiredSpecification = comparator.RequiredSpecificationString;
				providedSpecification = comparator.ProvidedSpecificationString;
			}
			catch (IncompleteInterfaceCopingException e)
			{
				MessageBox.Show(e.Message);
				return;
			}

			if (mismatches.Count > 0)
			{
				// Automatic pattern preselection
				ArrayList patterns = GetPatternDescriptions();
				AddMismatchPatterns(mismatches, patterns);

				// Selection of patterns by the user and configuration and 
				// generation using CodeSmith
				// TODO: Use self-implemented PatternConfiguration.
				// Run the GUI with the given patterns.
				Application.Run(new SelectionDialog(mismatches, 
					requiredSpecification, providedSpecification));	
			}
			else
				MessageBox.Show("No mismatches have been found.");

		}
		#endregion

		#region private methods
		/// <summary>
		/// Reads the PatternDescriptions from their XML representations.
		/// </summary>
		/// <returns>A list of PatternDescription objects.</returns>
		private ArrayList GetPatternDescriptions()
		{
			// Read all xml files from the Pattern folder 
			ArrayList patterns = new ArrayList();
			System.IO.DirectoryInfo dirInfo = new DirectoryInfo(
				Config.PATTERN_DIRECTORY);
			FileInfo[] fileInfos = dirInfo.GetFiles("*.xml");
			foreach (FileInfo fileInfo in fileInfos)
			{
				// TODO: Change PatternDescriptionParser so that it takes 
				// a TextReader as argument. And insert a Parse method.
				PatternDescriptionParser parser = new 
					PatternDescriptionParser (fileInfo.FullName);
				// Only take PatternDescriptions with the correct 
				// interfaceModel.
				if (parser.Pattern.InterfaceModel.Equals(this.interfaceModel.ToString()))
					patterns.Add(parser.Pattern);
			}
			return patterns;
		}

		/// <summary>
		/// Adds patterns able to correct a mismatch to the corresponding
		/// mismatch.
		/// </summary>
		/// <param name="mismatches">A list of mismatches.</param>
		/// <param name="patterns">A list of PatternDescriptions of patterns
		/// that may be able to correct the given mismatches.</param>
		private void AddMismatchPatterns(IList mismatches, IList patterns)
		{
			// Create a list of PatternDescriptions that cover the 
			// mismatched attributes found by the Comparator. The list 
			// should not contain duplicates.
			foreach (IMismatch mismatch in mismatches)
			{
				// TODO: consider mismatch.MismatchSubAttribute. Make this 
				// consideration configurable.
				string attribute = mismatch.MismatchAttribute;
				// Find patterns that cover the mismatches and have a 
				// suitability of + or ++
				foreach (PatternDescription pattern in patterns)
				{
					if (pattern.HasMismatchAttribute(attribute))
					{
						MismatchAttribute mismatchAttribute = 
							pattern.GetMismatchAttribute(attribute);
						if ((mismatchAttribute.Suitability.Equals("+")) ||
							(mismatchAttribute.Suitability.Equals("++")))
						{
							mismatch.AddPattern(pattern);
						}
					}
				}
			}
		}
		#endregion
	}
}
