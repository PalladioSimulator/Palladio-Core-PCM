using System;
using Palladio.ComponentModel;

namespace ComponentNetworkSimulation.Structure.Visitor
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
	/// Revision 1.1  2004/06/18 17:20:13  joemal
	/// initial class creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public class VisitorEventArgs : EventArgs
	{
		/// <summary>
		/// This defines the type of the event
		/// </summary>
		public enum EventType {TYPE_EXTERNALCALL,TYPE_RETURN,TYPE_UNKNOWN_ELEMENT}; 

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