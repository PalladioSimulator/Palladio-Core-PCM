using System;

namespace ReflectionBasedVisitor
{
	/// <summary>
	/// Interface for objects than can be visited by an IVisitor. Objects have to 
	/// implement this to take part in the reflection based visitor pattern.
	/// Consult the documentation of the <see cref="ReflectionBasedVisitor"/> to get 
	/// an example.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 11:57:06  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface IVisitable
	{
		/// <summary>
		/// This method is called by the <see cref="ReflectionBasedVisitor"/> to allow data
		/// structure driven visiting of the structure.<br></br>
		/// Leave this method's body empty if you don't need data structure driven visiting.
		/// </summary>
		/// <param name="visitor">The visitor to accept</param>
		void AcceptVisitor (IVisitor visitor);
	}
}
