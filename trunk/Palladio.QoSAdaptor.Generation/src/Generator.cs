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

using System;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics;
using Palladio.QoSAdaptor.Configuration;
using Palladio.QoSAdaptor.Pattern;
using System.Windows.Forms;

namespace Palladio.QoSAdaptor.Generation
{
	/// <summary>
	/// The generator asks the user if the adaptor or one of the prediction 
	/// models of the PatternDescription shall be generated and then uses 
	/// CodeSmith to generate it. 
	/// </summary>
	public class Generator : IGenerator	
	{
		#region data
		/// <summary>
		/// The pattern for which artifacts shall be generated.
		/// </summary>
		private IPatternDescription pattern;

		/// <summary>
		/// The path of the CodeSmith configuration file for this.pattern.
		/// </summary>
		private string configurationPath;

		/// <summary>
		/// The GUI used for user selection of artifacts.
		/// </summary>
		private SelectionDialog selectionDialog;

		/// <summary>
		/// The directory containing all information about this.pattern.
		/// </summary>
		private string patternDirectory;

		/// <summary>
		/// The name of the currently chosen artifact.
		/// </summary>
		private string currentArtifactName;

		/// <summary>
		/// The list of templates of the currently chosen artifact.
		/// </summary>
		private IList currentTemplates;

		/// <summary>
		/// Shows if artifacts have been generated. 
		/// </summary>
		private bool generated;
		#endregion 

		#region public methods
		/// <summary>
		/// Starts the generation process for the given pattern. The user is 
		/// asked whether the adaptor or one of the prediction models shall be
		/// generated. After the generation the user can stop the generation
		/// process or generate another artifact.
		/// </summary>
		/// <param name="pattern">The PatternDescription of the patttern for 
		/// which artifacts are to be generated.</param>
		/// <param name="configurationPath">The path of the CodeSmith 
		/// configuration file.</param>
		public bool Start(IPatternDescription pattern, string configurationPath)
		{
			this.pattern = pattern;
			this.configurationPath = configurationPath;
			this.generated = false;

			this.selectionDialog = new SelectionDialog(this.pattern, this);
			Application.Run(this.selectionDialog);
			// TODO: Create GUI to choose the adaptor or one of the 
			// prediction models or end the generation.

			// TODO: Start CodeSmith to generate the source code and copy the 
			// source code to the correct location (Use Config.PatternFolder).

			return this.generated;
		}
		#endregion

		#region internal methods / event handling
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
			foreach (RadioButton rButton in this.selectionDialog.RadioButtons)
			{
				if (rButton.Checked)
				{
					check = true;
					this.currentArtifactName = rButton.Name;

					MessageBox.Show("The generated files have to be saved to the "+
						"corresponding folders in the src folder of the chosen "+
						"pattern in Palladio.QosAdaptor\\Patterns.");

					this.patternDirectory = Config.PATTERN_DIRECTORY+
						this.pattern.Name+"\\";

					if (this.currentArtifactName.Equals("adaptor"))
					{
						this.currentTemplates = (IList)((ICloneable)this.
							pattern.AdapterTemplates).Clone();
					}
					else
					{
						IPredictionModel predictionModel = this.pattern.
							GetPredictionModelByName(this.currentArtifactName);
						this.currentTemplates = (IList)((ICloneable)
							predictionModel.Templates).Clone();
					}
					OpenTemplates();
					break;
				}
			}
			if (!check)
				MessageBox.Show("No artifact has been chosen for generation.");
		}
		#endregion

		#region private methods
		/// <summary>
		/// This is a helper method for generator_Click which opens
		/// the given templates in CodeSmith.
		/// </summary>
		private void OpenTemplates()
		{
			this.selectionDialog.GeneratorButton.Enabled = false;

			IEnumerator enu = this.currentTemplates.GetEnumerator();
			if (enu.MoveNext())
			{
				string template = (string)enu.Current;
				StartCodeSmith(template);
				this.currentTemplates.Remove(enu.Current);
			}
			else 
			{
				MessageBox.Show("All necessary templates have been generated."+
					" The corresponding assembly will be compiled now. It can"+
					" then be found in the bin subfolder of the folder of the"+
					" corresponding pattern in Palladio.QoSAdaptor\\Patterns."+
					" The dll of the adapted service has to be located in the"+
					" corresponding libs folder for compilation.");

				this.generated = true;
				this.selectionDialog.GeneratorButton.Enabled = true;
			}
		}

		/// <summary>
		/// Starts the CodeSmith configuration and generation GUI with the
		/// given template.
		/// </summary>
		/// <param name="template">The name of a CodeSmith template file.
		/// As path the templates directory of the pattern is taken. </param>
		private void StartCodeSmith(string template)
		{
			//start CodeSmith
			Process proc = new Process();

			proc.StartInfo.FileName = "CodeSmith.exe";
			string arg = this.patternDirectory+"templates\\"+template;
			proc.StartInfo.Arguments = arg;
			proc.EnableRaisingEvents = true;
			proc.Exited +=new EventHandler(Proc_Exited);
			try 
			{
				proc.Start();
			}
			catch (Win32Exception e)
			{
				MessageBox.Show(e.Message);
			}
		}

		/// <summary>
		/// Is called when CodeSmith is exited. Calls OpenTemplates to 
		/// restart CodeSmith with the next template or compile the generated 
		/// sources and return to the selection.
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void Proc_Exited(object sender, EventArgs e)
		{
			OpenTemplates();
		}
		#endregion
	}
}
