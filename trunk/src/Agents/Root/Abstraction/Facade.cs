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
using System.Collections;
using log4net;

using Palladio.ComponentModel;
using Palladio.Editor.Common;
using Palladio.Editor.Common.Commands;
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
		/// <summary>
		/// log4net logging service</summary>
		private static readonly ILog log = LogManager.GetLogger(typeof(Facade));

		/// <summary>
		/// An adapter to communicate with the presentation component via the controller.</summary>
		private IPresentationAdapter _presentation;

		/// <summary>
		/// Active component model instance</summary>
		private ICompositeComponent _model;

		/// <summary>
		/// A table to store registered attribute types</summary>
		private Hashtable _attributeTypes;

		/// <summary>
		/// Stores the value of <see cref="ModelFileName"/></summary>
		private string _modelFileName;

		/// <summary>
		/// Command stack holding undoable command objects</summary>
		private CommandStack _undoCmdStack;

		/// <summary>
		/// Command stack holding redoable command objects</summary>
		private CommandStack _redoCmdStack;
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
		/// <param name="presentation">An adapter to the presentation component of the root agent.</param>
		public Facade(IPresentationAdapter presentation)
		{
			this._presentation = presentation;

			this._attributeTypes = new Hashtable();

			this._modelFileName = null;

			this._undoCmdStack = new CommandStack();
			this._redoCmdStack = new CommandStack();
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
		/// Initializes the active component model to a new and empty model with one provided interface.
		/// </summary>
		/// <remarks>Fires <see cref="ComponentModelChanged"/>.</remarks>
		public void NewComponentModel()
		{
			this._model = ComponentFactory.CreateCompositeComponent("New Model");

			// automatically attach a provides interface to the component
			IInterfaceModel iface = ComponentFactory.CreateInterfaceModel("ProvidesInterface");
			this._model.AddProvidesInterface(iface);
			IRole role = this._model.GetProvidesRoleByInterfaceID(iface.ID);
			role.Name = "ProvidesRole";

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

		/// <summary>
		/// Register an attribute type, making it available to attributable entities.
		/// </summary>
		/// <param name="type">The attribute type to register</param>
		public void RegisterAttributeType(AbstractAttributeType type)
		{
			this._attributeTypes[type.GetType()] = type;
			log.Debug("Attribute "+type+" registered");
		}

		/// <summary>
		/// Returns all registered attribute types.
		/// </summary>
		/// <returns>An array of registeres attribute types</returns>
		public AbstractAttributeType[] GetRegisteredAttributeTypes()
		{
			AbstractAttributeType[] result = new AbstractAttributeType[this._attributeTypes.Count];
			this._attributeTypes.Values.CopyTo(result,0);
			return result;
		}

		/// <summary>
		/// Pushes a command onto the redo stack 
		/// </summary>
		/// <param name="cmd">The command to push on the redo stack</param>
		public void PushUndo(ICommand cmd)
		{
			this._undoCmdStack.Push(cmd);
		}

		/// <summary>
		/// Pops and returns the top-most command from the undo stack 
		/// </summary>
		/// <returns>The top-most command from the undo stack</returns>
		public ICommand PopUndo()
		{
			return this._undoCmdStack.Pop();
		}

		/// <summary>
		/// Pushes a command onto the redo stack
		/// </summary>
		/// <param name="cmd">The command to push on the redo stack</param>
		public void PushRedo(ICommand cmd)
		{
			this._redoCmdStack.Push(cmd);
		}

		/// <summary>
		/// Pops and returns the top-most command from the redo stack
		/// </summary>
		/// <returns>The top-most command from the redo stack</returns>
		public ICommand PopRedo()
		{
			return this._redoCmdStack.Pop();
		}

		/// <summary>
		/// Returns the number of commands in the undo stack
		/// </summary>
		public int UndoCount
		{
			get
			{
				return this._undoCmdStack.Count;
			}
		}

		/// <summary>
		/// Returns the number of commands in the redo stack
		/// </summary>
		public int RedoCount
		{
			get
			{
				return this._redoCmdStack.Count;
			}
		}

		/// <summary>
		/// Clears the undo command stack
		/// </summary>
		public void ClearUndo()
		{
			this._undoCmdStack.Clear();
		}

		/// <summary>
		/// Clears the redo command stack
		/// </summary>
		public void ClearRedo()
		{
			this._redoCmdStack.Clear();
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
