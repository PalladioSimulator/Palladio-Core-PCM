using System;
using System.Collections;
using Palladio.FiniteStateMachines;
using Palladio.Utils.Collections;
using Palladio.Attributes;
using ReflectionBasedVisitor;
using Palladio.ComponentModel.Exceptions;

namespace Palladio.ComponentModel.InterfaceModels 
{
	/// <summary>
	/// A ProtocolIModel is an extension of a SignatureListModel. In
	/// addition to the list of services it describes the set of all possible
	/// call sequences of these services using a finite state machine 
	/// called protocol. The language accepted by the protocol
	/// represents the possible call sequences.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.7  2004/05/24 15:03:14  sliver
	/// added tests for fsmprotocols in a basic component
	///
	/// Revision 1.6  2004/05/24 13:54:07  sbecker
	/// Added GetSignaturesByName
	///
	/// Revision 1.5  2004/05/24 12:42:34  sbecker
	/// Added test cases for creating protocol interfaces
	///
	/// Revision 1.4  2004/05/23 16:03:56  sliver
	/// completed unit tests
	///
	/// Revision 1.3  2004/05/19 07:54:24  sbecker
	/// Added CVS header
	///
	///
	/// </pre>
	/// </remarks>
	internal class FSMProtocol : IFSMProtocol  
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
		/// Signatures of the interface.
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
		/// Indexer to access the sigantures easily.
		/// </summary>
		public ISignature this[int index]
		{
			get 
			{
				try
				{

					return (ISignature)fsm.InputAlphabet[index].ID; 
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
		public IAttributeHash Attributes 
		{ 
			get { return attributes; }
		}

		/// <summary>
		/// Local unique identifier of the interface model.
		/// </summary>
		public string RoleID 
		{ 
			get{ return roleID; }
			set{ roleID = value; }
		}

		#endregion
		
		#region Methods
		
		/// <summary>
		/// Adds an array of signatures to the interface.
		/// </summary>
		/// <param name="aSigArray">Signatures to add.</param>
		public void AddSignatures(params ISignature[] aSigArray )
		{
			foreach(ISignature sig in aSigArray)
			{
				EditFSM.AddInputSymbols(FSMFactory.CreateDefaultInput(sig));
			}
		}

		/// <summary>
		/// Deletes a set of signatures from the interface.
		/// </summary>
		/// <param name="aSigArray">Signatures to delete.</param>
		public void DeleteSignatures( params ISignature[] aSigArray )
		{
			foreach(ISignature sig in aSigArray)
			{
				EditFSM.DeleteInputSymbols(FSMFactory.CreateDefaultInput(sig));
			}
		} 

		public bool ContainsSignature( ISignature aSignature )
		{
			IInput inputSymbol = FSMFactory.CreateDefaultInput(aSignature);
			return ( Array.IndexOf( fsm.InputAlphabet, inputSymbol ) >= 0 );
		}

		public ISignature[] GetSignaturesByName(string aName)
		{
			ArrayList result = new ArrayList();
			foreach (ISignature s in fsm.InputAlphabet)
			{
				if (s.Name.Equals(aName))
					result.Add(s);
			}
			return (ISignature[])result.ToArray(typeof(ISignature));
		}
		
		/// <summary>
		/// This method is called by the <see cref="ReflectionBasedVisitor"/> to allow data
		/// structure driven visiting of the structure.<br></br>
		/// Leave this method's body empty if you don't need data structure driven visiting.
		/// </summary>
		/// <param name="visitor">The visitor to accept</param>
		public void AcceptVisitor (IVisitor visitor) {}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new FSMProtocol(fsm,attributes,roleID);
		}
		
		public override bool Equals(object obj)
		{
			if (!(obj is IFSMProtocol)) return false;
			if (obj == this) return true;
			IFSMProtocol other = (IFSMProtocol)obj;
			return other.FSM.Equals(this.FSM);
		}

		#endregion

		#region Constructors
		/// <summary>
		/// Copy constructor
		/// </summary>
		/// <param name="fsm">The FSM to be stored in the cloned class</param>
		/// <param name="hash">The attributes to clone</param>
		/// <param name="aRole">The role to clone</param>
		internal FSMProtocol (IFiniteStateMachine fsm, IAttributeHash hash, string aRole)
		{
			this.fsm = (IFiniteStateMachine)fsm.Clone();
			this.attributes = (IAttributeHash)hash.Clone();
			this.roleID = aRole;
		}

		#endregion
		
		#region Data
		
		private IAttributeHash attributes;
		private IFiniteStateMachine fsm;
		private string roleID;
		
		#endregion

	}
}
