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

using Palladio.Identifier;
using Palladio.ComponentModel;
using Palladio.ComponentModel.Exceptions;
using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Common.Commands
{
	/// <summary>
	/// Zusammenfassung für AddBindingCmd.
	/// </summary>
	public class AddBindingCmd : AbstractCommand
	{
		private static readonly ILog log = LogManager.GetLogger(typeof(AddBindingCmd));

		private ICompositeComponent _targetComp;
		private IIdentifier _comp1ID;
		private IIdentifier _role1ID;
		private IIdentifier _comp2ID;
		private IIdentifier _role2ID;
		private IBinding _createdBinding;

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <param name="comp1ID"></param>
		/// <param name="role1ID"></param>
		/// <param name="comp2ID"></param>
		/// <param name="role2ID"></param>
		public AddBindingCmd(ICompositeComponent component, IIdentifier comp1ID, IIdentifier role1ID, IIdentifier comp2ID, IIdentifier role2ID)
		{
			this._targetComp = component;
			this._comp1ID = comp1ID;
			this._role1ID = role1ID;
			this._comp2ID = comp2ID;
			this._role2ID = role2ID;
		}

		#region ICommand Member

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public override bool Execute()
		{
			if (this._createdBinding == null)
			{
				this._createdBinding = ComponentFactory.CreateBinding(
					this._targetComp.GetComponent(this._comp1ID),
					this._role1ID,
					this._targetComp.GetComponent(this._comp2ID),
					this._role2ID);
			}
			try
			{
				this._targetComp.AddBindings(this._createdBinding);
			}
			catch(Exception e)
			{
				log.Error("Unable to create binding.");
				return false;
			}

			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.BINDING_ADDED,
				this._createdBinding.ID.Clone() as IIdentifier);

			return true;
		}

		/// <summary>
		/// 
		/// </summary>
		public override bool CanUndo
		{
			get
			{
				return false;
			}
		}

		public override bool Undo()
		{
//			this._targetComp.DeleteComponents(this._createdComp.ID);
//
//			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
//				EntityChangeReason.COMPONENT_REMOVED,
//				this._createdComp.ID.Clone() as IIdentifier);

			return true;
		}

		/// <summary>
		/// Returns the component to which th binding is added
		/// </summary>
		public override object Receiver
		{
			get
			{
				return this._targetComp;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public override object Clone()
		{
			return new AddBindingCmd(this._targetComp, this._comp1ID, this._role1ID, this._comp2ID, this._role2ID);
		}
		#endregion
	}
}
