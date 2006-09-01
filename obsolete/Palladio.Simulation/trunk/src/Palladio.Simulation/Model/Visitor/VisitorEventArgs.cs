using System;
using Palladio.ComponentModel;

namespace Palladio.Simulation.Model.Visitor
{
	/// <summary>
	/// this defines the eventhandler used by the visitors to comunicate with each other
	/// </summary>
	public delegate void VisitorEventHandler(object sender, VisitorEventArgs args);
	
	/// <summary>
	/// This class is the datastructure for arguments in visitor events.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:42  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	public class VisitorEventArgs : EventArgs
	{
		/// <summary>
		/// This defines the type of the event
		/// </summary>
		public enum EventType 
		{
			/// <summary>
			/// The visitor wants invoke an external call.
			/// </summary>
			TYPE_EXTERNALCALL,

			/// <summary>
			/// The visitor reaches the end of its controlflow.
			/// </summary>
			TYPE_RETURN,

			/// <summary>
			/// The visitor has found an unknown element on its way.
			/// </summary>
			TYPE_UNKNOWN_ELEMENT,

			/// <summary>
			/// The visited component contains unbound requires interfaces.
			/// </summary>
			TYPE_UNBOUNDREQUIRES
		}; 

		/// <summary>
		/// the required signature of the calling component
		/// </summary>
		private IExternalSignature signature;

		/// <summary>
		/// the calling component
		/// </summary>
		private IComponent component;

		/// <summary>
		/// the type of the event
		/// </summary>
		private VisitorEventArgs.EventType type;

		/// <summary>
		/// creates a new VisitorEventArgs object only using the type parameter.
		/// </summary>
		/// <param name="type">the type of the event</param>
		public VisitorEventArgs(VisitorEventArgs.EventType type)
		{
			this.type = type;
		}

		/// <summary>
		/// creates a new VisitorEventArgs object using all provided parameters
		/// </summary>
		/// <param name="type">the type of the event</param>
		/// <param name="component">the calling component</param>
		/// <param name="signature">the required signature of the calling component</param>
		public VisitorEventArgs(VisitorEventArgs.EventType type, IComponent component,IExternalSignature signature)
		{
			this.signature = signature;
			this.type = type;
			this.component = component;
		}

		/// <summary>
		/// return the required signature of the calling component
		/// </summary>
		public IExternalSignature Signature
		{
			get
			{
				return this.signature;
			}
		}

		/// <summary>
		/// return the calling component
		/// </summary>
		public IComponent Component
		{
			get
			{
				return this.component;
			}
		}

		/// <summary>
		/// return the type of the event
		/// </summary>
		public VisitorEventArgs.EventType Type
		{
			get
			{
				return this.type;
			}
		}
	}
}
//EOF