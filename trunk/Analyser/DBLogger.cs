using System;
using System.Collections;
using System.Data;
using System.Data.SqlClient;
using System.Reflection;
using System.Threading;

namespace Palldio.Interceptor.Data
{
	/// <summary>
	/// </summary>
	public class DBLogger
	{
		ResultDataSet results;

		/// <summary>
		/// Key: Thread
		/// Value: ThreadInfo
		/// 
		/// GetHashCode provides identification for managed threads. 
		/// For the lifetime of your thread, it will not collide with the 
		/// value from any other thread, regardless of the application domain 
		/// from which you obtain the value.
		/// </summary>
		Hashtable threadStackTable;
		
		/// <summary>
		/// ID for the current execution. So, (runID,threadID) is unique.
		/// </summary>
		public long runID;


		/// <summary>
		/// Dataset for the logged info is stored.
		/// </summary>
		public ResultDataSet Results
		{
			get { return results; }
		}

		public DBLogger(ResultDataSet results, long runID)
		{
			this.results = results;
			this.threadStackTable = new Hashtable();
			this.runID = runID;
		}

		/// <summary>
		/// Executed before a method is called.
		/// </summary>
		/// <param name="id">Unique ID of the call.</param>
		/// <param name="method">Called Method.</param>
		public void OnCall(long id, MethodInfo method)
		{
			ThreadInfo threadInfo = GetCurrentThreadInfo();			
			long caller = ((CallInfo)threadInfo.CallStack.Peek()).CallID;
			threadInfo.CallLevel++;
			CallInfo info = new CallInfo(id, threadInfo.CallLevel, caller, method, DateTime.Now.Ticks);
			threadInfo.CallStack.Push(info);
		}

		/// <summary>
		/// Executed after a method call.
		/// </summary>
		/// <param name="id"></param>
		/// <param name="method"></param>
		public void OnReturn(long id, MethodInfo method)
		{
			ThreadInfo threadInfo = GetCurrentThreadInfo();
			CallInfo info = (CallInfo)threadInfo.CallStack.Pop();
			results.CallTable.AddCallTableRow(info.CallID, info.CallLevel, info.CallerID, info.Info.DeclaringType.ToString(), info.Info.ToString(), info.StartTime, DateTime.Now.Ticks, runID, threadInfo.ThreadId );
			threadInfo.CallLevel--;
		}

		/// <summary>
		/// Get Stack and call level of the current thread.
		/// </summary>
		/// <returns></returns>
		private ThreadInfo GetCurrentThreadInfo()
		{
			Thread t = Thread.CurrentThread;
			if (!threadStackTable.Contains(t))
				threadStackTable[t] = new ThreadInfo();
			return (ThreadInfo) threadStackTable[t];
		}

		private struct CallInfo
		{
			public long CallID;
			public long CallLevel;
			public long CallerID;
			public MethodInfo Info;
			public long StartTime;
			public long StopTime;

			public CallInfo(long callId, long callLevel, long callerId, MethodInfo info, long startTime)
			{
				CallID = callId;
				CallLevel = callLevel;
				CallerID = callerId;
				Info = info;
				StartTime = startTime;
				StopTime = 0;
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
				CallStack.Push( new CallInfo(0,0,0,null,0) );
				ThreadId = ++threadCnt;
			}

			private long threadCnt = 0;
		}

	}
}
