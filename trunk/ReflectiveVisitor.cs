using System;
using System.Reflection;
using ReflectionBasedVisitor.Interfaces;

namespace ReflectionBasedVisitor
{
	/// <summary>
	/// TODO: Add example!!!
	/// </summary>
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
