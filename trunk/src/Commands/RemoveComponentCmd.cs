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
	/// Zusammenfassung für RemoveComponentCmd.
	/// </summary>
	public class RemoveComponentCmd : AbstractCommand
	{
		private static readonly ILog log = LogManager.GetLogger(typeof(RemoveComponentCmd));

		private ICompositeComponent _targetComp;
		private IIdentifier _deleteID;
		private IComponent _deletedComp;

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <param name="id"></param>
		public RemoveComponentCmd(ICompositeComponent component, IIdentifier id)
		{
			this._targetComp = component;
			this._deleteID = id;
		}

		#region ICommand Member
		/// <summary>
		/// 
		/// </summary>
		/// <returns>True if execution was succesful</returns>
		public override bool Execute()
		{
			this._deletedComp = this._targetComp.GetComponent(this._deleteID);
			if (this._deletedComp != null)
			{
				try
				{
					this._targetComp.DeleteComponents(this._deleteID);
				}
				catch (ComponentHasIncomingConnectionsException e1)
				{
					log.Error("Unable to remove component. Incoming connections detected.");
					return false;
				}
				catch (ComponentHasOutgoingConnectionsException e2)
				{
					log.Error("Unable to remove component. Outgoing connections detected.");
					return false;
				}

				this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
					EntityChangeReason.COMPONENT_REMOVED,
					this._deleteID);
				return true;
			}
			else 
				return false;
		}

		public override bool CanUndo
		{
			get
			{
				return true;
			}
		}

		public override bool Undo()
		{
			if (this._deletedComp == null)
				return false;

			this._targetComp.AddComponents(this._deletedComp);

			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.COMPONENT_ADDED,
				this._deletedComp.ID.Clone() as IIdentifier);
			return true;
		}

		public override Palladio.Editor.Common.EntityProxies.EventArgs EventArgs
		{
			get
			{
				return this._evtArgs;
			}
		}

		public override object Receiver
		{
			get
			{
				return this._targetComp;
			}
		}

		public override object Clone()
		{
			return new RemoveComponentCmd(this._targetComp, this._deleteID);
		}
		#endregion
	}
}
