using System;
using System.Reflection;
using ReflectionBasedVisitor;

namespace ReflectionBasedVisitor
{
	/// <summary>
	/// The base class for a reflection based visitor pattern.
	/// See <a href="http://www.javaworld.com/javaworld/javatips/jw-javatip98.html">
	/// http://www.javaworld.com/javaworld/javatips/jw-javatip98.html</a> for details 
	/// on the usage.
	/// </summary>
	/// <remarks>
	/// A usage example in a client using this assembly
	/// <code>
	/// class MyType : IVisitable
	/// {
	/// 	public virtual void AcceptVisitor(IVisitor v) 
	/// 	{
	/// 		// Add code here if you need data structure driven visiting!
	/// 		// Otherwise leave empty!
	///		}
	/// }
	/// 
///	class MyVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor, IVisitor
///	{
///		public override void VisitObject(object o)
///		{
///		   // Add default behaviour here if the visitor visits an object of unknown
///		   // type
///		}
///
///		public void VisitMyType(MyType objectOfMyType)
///		{
///		   // Do sth. when visiting an obejct of type MyType
///		   // For example:
///		   Console.WriteLine("Visiting "+objectOfMyType);
///		   Visit(objectOfMyType.Next);
///		}
///
///	}
	/// </code>
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
	public abstract class ReflectionBasedVisitor : IVisitor
	{
		/// <summary>
		///Determines if the visitor moves by the way
		/// determined by the data structure (true) or if it moves on its own (false).
		/// </summary>
		protected bool isDataDrivenVisitor = false;

		/// <summary>
		/// Default constructor of the base class
		/// </summary>
		/// <param name="isDataDrivenVisitor">Determines if the visitor moves by the way
		/// determined by the data structure (true) or if it moves on its own (false).</param>
		public ReflectionBasedVisitor(bool isDataDrivenVisitor)
		{
			this.isDataDrivenVisitor = isDataDrivenVisitor;
		}

		/// <summary>
		/// The default function which is called if no "VisitTYPE" method is found
		/// by the reflection API
		/// </summary>
		/// <param name="o">The object calling the unknown visitor function</param>
		public abstract void VisitObject (object o);

		/// <summary>
		/// The Visit method called by the reflection API. Do not alter this!!!
		/// </summary>
		/// <param name="o">The object beening visited</param>
		public void Visit(object o)
		{
			MethodInfo method = GetMethod(o.GetType());
			method.Invoke(this, new object[] {o});
			if (o is IVisitable && isDataDrivenVisitor)
			{
				CallAccept((IVisitable)o);
			}
		}
		
		private void CallAccept(IVisitable visitable) 
		{
			visitable.AcceptVisitor(this);
		}

		private MethodInfo GetMethod(Type type) 
		{
			MethodInfo m = null;
			string method = "Visit" + type.Name;
			
			m = GetType().GetMethod(method, new Type[] {type});
			
			// Try the interfaces.  If necessary, you
			// can sort them first to define 'visitable' interface wins
			// in case an object implements more than one.
			if (m == null) 
			{
				Type[] interfaces = type.GetInterfaces();
				for (int i = 0; i < interfaces.Length; i++) 
				{
					method = "Visit" + interfaces[i].Name;
					m = GetType().GetMethod(method, new Type[] {interfaces[i]});
					if (m != null)
						break;
				}
			}
			if (m == null) 
			{
				m = GetType().GetMethod("VisitObject", new Type[] {Type.GetType("System.Object")});
			}
			return m;
		}
	}
}
