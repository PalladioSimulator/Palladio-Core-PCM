using System;

using Palladio.Attributes;
using Palladio.FiniteStateMachines;
using Palladio.ComponentModel.Exceptions;
using ReflectionBasedVisitor;


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
		/// <summary>
		/// This method is called by the <see cref="ReflectionBasedVisitor"/> to allow data
		/// structure driven visiting of the structure.<br></br>
		/// Leave this method's body empty if you don't need data structure driven visiting.
		/// </summary>
		/// <param name="visitor">The visitor to accept</param>
		public void AcceptVisitor (IVisitor visitor) {}

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
		
		public override bool Equals(object obj)
		{
			if (!(obj is FSMInterface)) return false;
			if (obj == this) return true;
			FSMInterface other = (FSMInterface)obj;
			return other.FSM.Equals(this.FSM);
		}

		public override int GetHashCode()
		{
			return (fsm == null ? 0 : fsm.GetHashCode());
		}
		
		
		public void Serialize(System.Xml.XmlTextWriter writer)
		{
		
		}
		
		public void Deserialize(System.Xml.XmlNode element)
		{
		
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
