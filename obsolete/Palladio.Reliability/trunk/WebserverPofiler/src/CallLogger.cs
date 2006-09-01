using System;
using System.Collections;
using System.Reflection;
using System.Threading;

namespace Palladio.Reliability.WebserverProfiler
{
	public class CallInfo
	{
		public long ThreadID;
		public long CallNumber;
		public long CallLevel;
		public long CallerID;
		public string InterfaceName;
		public MethodInfo MethodInfo;
		public long StartTime;
		public long StopTime;

		public CallInfo(long callId, long callLevel, long callerId, string interfaceName, MethodInfo info, long startTime, long threadID)
		{
			CallNumber = callId;
			CallLevel = callLevel;
			CallerID = callerId;
			MethodInfo = info;
			StartTime = startTime;
			StopTime = 0;
			ThreadID = threadID;
			InterfaceName = interfaceName;
		}
	}


	/// <summary>
	/// </summary>
	public class CallLogger
	{
		ArrayList callInfoList;

		/// <summary>
		/// Key: Thread
		/// Value: ThreadInfo
		/// 
		/// GetHashCode provides identification for managed threads. 
		/// For the lifetime of your thread, it will not collide with the 
		/// value from any other thread, regardless of the application domain 
		/// from which you obtain the value.
		/// </summary>
		private Hashtable threadStackTable;

		/// <summary>
		/// ID for the current execution. So, (runID,threadID) is unique.
		/// </summary>
		public long runID;


		/// <summary>
		/// Dataset for the logged info is stored.
		/// </summary>
		public CallInfo[] Calls
		{
			get
			{
				lock(this)
				{
					return (CallInfo[])callInfoList.ToArray(typeof(CallInfo));
				}
			}
		}

		public CallLogger()
		{
			lock(this)
			{
				callInfoList = new ArrayList();
				this.threadStackTable = new Hashtable();
			}
		}

		/// <summary>
		/// Executed before a method is called.
		/// </summary>
		/// <param name="id">Unique ID of the call.</param>
		/// <param name="method">Called Method.</param>
		public void OnCall(long id, string interfaceName, MethodInfo method)
		{
			lock(this)
			{
				ThreadInfo threadInfo = GetCurrentThreadInfo();
				long caller = ((CallInfo) threadInfo.CallStack.Peek()).CallNumber;
				threadInfo.CallLevel++;
				CallInfo info = new CallInfo(id, threadInfo.CallLevel, caller, interfaceName, method, DateTime.Now.Ticks, threadInfo.ThreadId);
				threadInfo.CallStack.Push(info);
			}
		}

		/// <summary>
		/// Executed after a method call.
		/// </summary>
		public void OnReturn()
		{
			lock(this)
			{
				ThreadInfo threadInfo = GetCurrentThreadInfo();
				CallInfo info = (CallInfo) threadInfo.CallStack.Pop();
				callInfoList.Add(info);
				info.StopTime = DateTime.Now.Ticks;
				threadInfo.CallLevel--;
			}
		}

		/// <summary>
		/// Get Stack and CallLevel of the current thread.
		/// </summary>
		/// <returns></returns>
		private ThreadInfo GetCurrentThreadInfo()
		{
			lock(this)
			{
				Thread t = Thread.CurrentThread;
				ThreadInfo info;
				if (!threadStackTable.Contains(t))
					threadStackTable[t] = new ThreadInfo();
				info = (ThreadInfo) threadStackTable[t];
				return info;
			}
		}

		/// <summary>
		/// Contains the ID and Stack of a thread.
		/// </summary>
		private class ThreadInfo
		{
			/// <summary>
			/// Depth of the stack.
			/// </summary>
			public long CallLevel;

			/// <summary>
			/// Method stack of the thread.
			/// </summary>
			public Stack CallStack;

			/// <summary>
			/// ID of the thread.
			/// </summary>
			public long ThreadId;

			public ThreadInfo()
			{
				CallLevel = 0;
				CallStack = new Stack();
				CallStack.Push(new CallInfo(0, 0, 0,"Base", null, 0,0));
				threadCnt++;
				ThreadId = threadCnt;
			}

			private static long threadCnt = 0;
		}
	}
}