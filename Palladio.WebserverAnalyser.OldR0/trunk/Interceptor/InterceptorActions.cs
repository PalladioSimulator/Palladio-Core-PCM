using System.Reflection;

namespace Palladio.WebserverAnalyser.Interceptor
{
	public delegate void BeforeCallDelegate(long id, MethodInfo method);
	public delegate void AfterCallDelegate(long id, MethodInfo method);

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
		private static void DoNothing(long id, MethodInfo method){}

		public static long GetNextCallID()
		{
			return ++nextID;
		}

		private static long nextID = 0;
	}
}


