using System;
using Palladio.ComponentModel;

namespace ComponentNetworkSimulation.Structure.Visitor
{
	/// <summary>
	/// This class is the abstract implementation of all component visitors in this framework. Therefor it implements 
	/// the interface <code>IComponentVisitor</code>. The visitor holds the visited component, contains the VisitorEvent and
	/// provides the notify methods for this event.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.3  2004/06/19 16:04:42  joemal
	/// add new event for unbound requires interfaces
	///
	/// Revision 1.2  2004/06/19 13:42:28  joemal
	/// Add some methods to retrieve the status of the visitor
	///
	/// Revision 1.1  2004/06/18 17:20:13  joemal
	/// initial class creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public abstract class AbstractComponentVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor,IComponentVisitor
	{
		#region events
		/// <summary>
		/// the visitor event
		/// </summary>
		public event ComponentNetworkSimulation.Structure.Visitor.VisitorEventHandler OnVisitorEvent;
		
		#endregion

		#region data

		/// <summary>
		/// the component of the visitor
		/// </summary>
		private IComponent component;

		#endregion

		#region constructors
		/// <summary>
		/// constructs a new <code>AbstractComponentVisitor</code> using the given component.
		/// </summary>
		/// <param name="component">the component, visited by this visitor</param>
		public AbstractComponentVisitor(IComponent component):base(false)
		{
			this.component = component;
		}
		#endregion

		#region properties

		/// <summary>
		/// return the component visited by this visitor
		/// </summary>
		public IComponent Component
		{
			get
			{
				return this.component;
			}
		}

		/// <summary>
		/// implement to return this current element of the visitor
		/// </summary>
		public abstract object CurrentElement
		{
			get;
		}

		/// <summary>
		/// if the current element is a timeconsumer, it is returned. Otherwise, null is returned.
		/// </summary>
		public ITimeConsumer CurrentTimeConsumer
		{
			get
			{
				if (this.IsTimeConsumer) return (ITimeConsumer)this.CurrentElement;
				return null;
			}
		}

		/// <summary>
		/// returns true, if the current element is a timeconsumer
		/// </summary>
		public bool IsTimeConsumer
		{
			get
			{
				return this.HasAnyElement && (this.CurrentElement is ITimeConsumer);
			}
		}

		/// <summary>
		/// returns true, if any element exits in controlflow of the visitor
		/// </summary>
		public bool HasAnyElement
		{
			get
			{
				return this.CurrentElement != null;
			}
		}
				
		#endregion

		#region methods
		/// <summary>
		/// implement to let the visitor jump to the next element in its component
		/// </summary>
		public abstract void NextElement();

		/// <summary>
		/// this methods is called, if the visitor comes to an element it doesn't know. By default, 
		/// a visitorevent from type unknown element is fired to the super visitor.
		/// </summary>
		/// <param name="o">the unknown object </param>
		public override void VisitObject(object o)
		{
			NotifyUnknownElement();
		}

		/// <summary>
		/// call to notify the super visitor that an unknown element was reached
		/// </summary>
		protected void NotifyUnknownElement()
		{
			if (this.OnVisitorEvent != null)
				this.OnVisitorEvent(this,new VisitorEventArgs(VisitorEventArgs.EventType.TYPE_UNKNOWN_ELEMENT));
		}

		/// <summary>
		/// called to notify the super visitor that an external call is needed.
		/// </summary>
		/// <param name="signature">the required signature of the external call</param>
		protected void NotifyExternalCall(IExternalSignature signature)
		{
			if (this.OnVisitorEvent != null)
				this.OnVisitorEvent(this,new VisitorEventArgs(VisitorEventArgs.EventType.TYPE_EXTERNALCALL,component,signature));
		}

		/// <summary>
		/// called by the visitor to notify the super visitor that it has reached the end of its controlflow
		/// </summary>
		protected void NotifyServiceReturned()
		{
			if (this.OnVisitorEvent != null)
				this.OnVisitorEvent(this,new VisitorEventArgs(VisitorEventArgs.EventType.TYPE_RETURN));
		}

		/// <summary>
		/// called to notify the super visitor that the given component has an unbound requires interfaces. 
		/// The visitor skip the external call.
		/// </summary>
		/// <param name="com">the calling component</param>
		/// <param name="sig">the signature</param>
		protected void NotifyUnboundRequiresInterface(IComponent com,IExternalSignature sig)
		{
			if (this.OnVisitorEvent != null)
				this.OnVisitorEvent(this,new VisitorEventArgs(VisitorEventArgs.EventType.TYPE_UNBOUNDREQUIRES,com,sig));
		}

		#endregion
	}
}
//EOF
