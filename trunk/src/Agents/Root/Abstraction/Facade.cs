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
using log4net;

using Palladio.ComponentModel;
using Palladio.Editor.Common;
using Palladio.Editor.Core.Agents.Root;
using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Core.Agents.Root.Abstraction
{
	/// <summary>
	/// A Facade to the Abstraction subsystem of the Core PAC agent
	/// which is maintaining the active component model instance.
	/// </summary>
	internal class Facade
	{
		#region Fields
		private static readonly ILog log = LogManager.GetLogger(typeof(Facade));

		/// <summary>
		/// The Control Component of the Core PAC agent</summary>
		private IPresentationAdapter _presentation;

		/// <summary>
		/// Active component model instance</summary>
		private ICompositeComponent _model;

		/// <summary>
		/// Stores the value of <see cref="ModelFileName"/></summary>
		private string _modelFileName;
		#endregion

		#region Public Events
		/// <summary>
		/// Fired when the active component model has changed entirely.</summary>
		public event EventHandler ComponentModelChanged;

		#endregion

		#region Constructors
		/// <summary>
		/// Creates a Facade object.
		/// </summary>
		/// <param name="presentation">An adapter to the Presentation component of the root agent.</param>
		public Facade(IPresentationAdapter presentation)
		{
			this._presentation = presentation;

			this._modelFileName = null;
		}
		#endregion

		#region Public Properties
		/// <summary>
		/// Returns an instance of the active component model.
		/// </summary>
		public ICompositeComponent ComponentModel
		{
			get
			{
				return this._model;
			}
		}
		/// <summary>
		/// The name of the file which is associated with the active component model and
		/// to which it is stored when calling <see cref="SaveComponentModel"/>
		/// </summary>
		public string ModelFileName
		{
			get
			{
				return this._modelFileName;
			}
			set
			{
				this._modelFileName = value;
			}
		}
		#endregion

		#region Public Methods
		/// <summary>
		/// Initializes the active component model to a new and empty model.
		/// </summary>
		/// <remarks>Fires <see cref="ComponentModelChanged"/>.</remarks>
		public void NewComponentModel()
		{
			this._model = ComponentFactory.CreateCompositeComponent("New Model");
			this.FireComponentModelChanged();
		}

		/// <summary>
		/// Load an existing model from XML file.
		/// </summary>
		/// <param name="filename">The file in which the new model resides.</param>
		/// <remarks>
		/// This method utilizes <see cref="Palladio.ComponentModel.ModelPersistencyService"/> to 
		/// deserialize a previously saved ComponentModel. When succesful, 
		/// <see cref="ComponentModelChanged"/> is fired and <see cref="ModelFileName"/> updated accordingly.
		/// </remarks>
		public void LoadComponentModel(string filename)
		{
			try
			{
				this._model = ModelPersistencyService.Instance.LoadCompositeComponent(filename);
			}
			catch (Exception e)
			{
				log.Error(e.ToString());
			}
			this.ModelFileName = filename;
			this.FireComponentModelChanged();
		}

		/// <summary>
		/// Saves the active model to the file indicated by <see cref="ModelFileName"/>.
		/// </summary>
		public void SaveComponentModel()
		{
			ModelPersistencyService.Instance.SaveEntity(this._model.ID, this.ModelFileName);
		}

		/// <summary>
		/// Saves the active model.
		/// </summary>
		/// <param name="filename">The file to which the model shall be saved.</param>
		/// <remarks>
		/// This Method updates <see cref="ModelFileName"/> accordingly.
		/// </remarks>
		public void SaveComponentModelAs(string filename)
		{
			ModelPersistencyService.Instance.SaveEntity(this._model.ID, filename);
			this.ModelFileName = filename;
		}
		#endregion

		#region Private Methods
		/// <summary>
		/// Fires the <see cref="ComponentModelChanged"/> event.
		/// </summary>
		private void FireComponentModelChanged()
		{
			if (this.ComponentModelChanged != null)
				this.ComponentModelChanged(this, new System.EventArgs());
		}
		#endregion


	}
}
