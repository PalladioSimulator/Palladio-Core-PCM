using System;

using Palladio.Attributes;
using Palladio.FiniteStateMachines;
using Palladio.ComponentModel.Exceptions;

namespace Palladio.ComponentModel.InterfaceModels
{
	/// <summary>
	/// This is the implementation of IFSMInterface
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/02/24 20:13:06  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:48:31  joemal
	/// initial import
	///
	/// 
	/// </pre>
	/// </remarks>
	internal class FSMInterface : IFSMInterface
	{
		protected IEditableFiniteStateMachine editFSM = null;

		public IEditableFiniteStateMachine EditFSM
		{
			get
			{
				if (editFSM == null)
				{
					editFSM = FSMFactory.GetEditableFSM(fsm);
					fsm = editFSM;
				}
				return editFSM;
			}
		}

		#region Properties
		/// <summary>
		/// A Protocol describing
		/// the possible call sequences of the services.
		/// </summary>
		public IFiniteStateMachine FSM
		{
			get { return fsm; }
		}

		/// <summary>
		/// Signatures  of the interface.
		/// </summary>
		public ISignature[] Signatures 
		{
			get
			{
				try
				{
					ISignature[] result = new ISignature[fsm.InputAlphabet.Length];
					for (int i = 0; i < fsm.InputAlphabet.Length; i++)
					{
						result[i] = (ISignature)fsm.InputAlphabet[i].ID;
					}
					return result;
				}
				catch (InvalidCastException ex)
				{
					throw new FSMNotProtocolAutomatonException("Protocol FSMs need to have ISignature objects "+
						"attached to their transitions",ex);
				}
			}
		}

		/// <summary>
		/// A list of attributes attached an object. 
		/// </summary>
		public AttributeHash Attributes 
		{ 
			get { return attributes; }
		}
		#endregion
		
		#region Methods

		public void SignatureListChangeEventHandler(object sender, SignatureListChangeEventArgs args)
		{
			if (args.ChangeTime == ChangeTimeEnum.BEFORE)
			{
				switch (args.ChangeType)
				{
					case ChangeTypeEnum.ADD:
						EditFSM.AddInputSymbols(FSMFactory.CreateInputFromList(args.Signature).StoredInputs);
						break;
					case ChangeTypeEnum.DELETE:
						EditFSM.DeleteInputSymbols(FSMFactory.CreateInputFromList(args.Signature).StoredInputs);
						break;
				}
			}
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new FSMInterface(attributes,fsm);
		}
			
		#endregion

		#region Constructors
		/// <summary>
		/// Copy constructor
		/// </summary>
		/// <param name="fsm">The FSM to be stored in the cloned class</param>
		/// <param name="hash">The attributes to clone</param>
		internal FSMInterface ( AttributeHash hash, IFiniteStateMachine fsm)
		{
			this.fsm = (IFiniteStateMachine)fsm.Clone();
			this.attributes = (AttributeHash)hash.Clone();
		}

		#endregion
		
		#region Data
		
		private AttributeHash attributes;
		private IFiniteStateMachine fsm;
		
		#endregion

	}	
}
