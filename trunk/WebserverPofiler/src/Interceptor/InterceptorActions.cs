using System.Reflection;

namespace Palladio.Reliability.WebserverProfiler.Interceptor
{
	public delegate void BeforeCallDelegate(long id, string interfaceName, MethodInfo method);
	public delegate void AfterCallDelegate();

	/// <summary>
	/// This class contains the action delectates that are performed before
	/// and after a method call.
	/// </summary>
	public class InterceptorActions
	{
		/// <summary>
		/// Delegate that is called before the method is executed. Must not be <c>null</c>!
		/// </summary>
		public static BeforeCallDelegate BeforeCall = new BeforeCallDelegate(DoNothing);

		/// <summary>
		/// Delegate that is called after the mehtod execution. Must not be <c>null</c>!
		/// </summary>
		public static AfterCallDelegate  AfterCall  = new AfterCallDelegate(DoNothing);

		/// <summary>
		/// Dummy action.
		/// </summary>
		/// <param name="id"></param>
		/// <param name="method"></param>
		private static void DoNothing(long id, string interfaceName, MethodInfo method){}
		private static void DoNothing(){}

		public static long GetNextCallID()
		{
			long id = 0;
			lock(next)
			{
				next.ID ++;
				id = next.ID;
			}
			return id;
		}

		private static CallID next = new CallID();

		class CallID
		{
			public long ID;

			public CallID()
			{
				ID = 0;
			}
		}
	}
}


