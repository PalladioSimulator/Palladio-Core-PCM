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

namespace Palladio.QoSAdaptor.Pattern
{
	/// <summary>
	/// Represents a prediction model entry of a pattern description. Contains
	/// the name of the model and a list of patterns belonging to the model.
	/// The path of the templates is determined by the calling application.
	/// </summary>
	internal class PredictionModel : IPredictionModel
	{
		#region attributes
		/// <summary>
		/// The name of the prediction model.
		/// </summary>
		private string name;

		/// <summary>
		/// A list of templates belonging to this prediction model.
		/// </summary>
		private ArrayList templates;

		/// <summary>
		/// States how to use the predicition model
		/// </summary>
		private string usageInstructions;

		/// <summary>
		/// Indicates whether the prediction model is executable or not.
		/// </summary>
		private bool isExecutable;
		#endregion

		#region constructor
		/// <summary>
		/// Constructor that takes the name of the prediction model. Templates 
		/// can be added by using AddTemplate.
		/// </summary>
		/// <param name="name">The name of this prediction model.</param>
		/// <param name="isExecutable">Indicates whether the prediction model
		/// is executable or not.</param>
		public PredictionModel(string name, bool isExecutable)
		{
			this.name = name;
			this.isExecutable = isExecutable;
			this.templates = new ArrayList();
			this.usageInstructions = "";
		}
		#endregion

		#region properties
		/// <summary>
		/// The name of the prediction model.
		/// </summary>
		public string Name
		{
			get
			{
				return name;
			}
		}

		/// <summary>
		/// A list of templates belonging to the prediction model.
		/// </summary>
		public IList Templates
		{
			get
			{
				return this.templates;
			}
		}
	
		/// <summary>
		/// States how to use the prediction model.
		/// </summary>
		public string UsageInstructions
		{
			get
			{
				return this.usageInstructions;
			}
			set
			{
				this.usageInstructions = value;
			}
		}

		/// <summary>
		/// Indicates whether the prediction model is executable or not.
		/// </summary>
		public bool IsExecutable
		{
			get
			{
				return this.isExecutable;
			}
		}
		#endregion

		#region internal methods
		/// <summary>
		/// Adds a template to this prediction model.
		/// </summary>
		/// <param name="template">The name of the new template. The path of 
		/// the template is determined of the folder structure of the calling
		/// application.</param>
		internal void AddTemplate (string template)
		{
			this.templates.Add(template);
		}
		#endregion
	}
}
