using System;

namespace ReflectionBasedVisitor
{
	/// <summary>
	/// Implementation of the ReflectiveVisitor 
	/// see <a href="http://www.javaworld.com/javaworld/javatips/jw-javatip98.html">
	/// http://www.javaworld.com/javaworld/javatips/jw-javatip98.html</a>.
	/// This interface has to be implemented by a class visiting a certain data 
	/// structure implementing the reflection based visitor pattern.
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
	public interface IVisitor
	{
		/// <summary>
		/// The core of the <see cref="ReflectionBasedVisitor"/>. This method is 
		/// provided by the visitor. Please inherit from <see cref="ReflectionBasedVisitor"/> 
		/// to implement your own visitors! <br></br>
		/// Consult the documentation of the <see cref="ReflectionBasedVisitor"/> to get 
		/// an example.
		/// </summary>
		/// <param name="o">An object to be visited</param>
		void Visit(object o);
	}
}
