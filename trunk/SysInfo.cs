using System;
using System.Management;
using System.Globalization;
using Nini.Config;
using ILBenchmark.Common.Interfaces;

namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für SysInfo.
	/// </summary>
	public class SysInfo : MarshalByRefObject, ISysInfo
	{
		private string _OSName;
		private string _OSVersion;
		private string _Prozessor;
		private string _Manufacturer;
		private string _CPUSpeed;
		private string _VirtualMemory;
		private string _PhysicalMemory;
		private string _clr;

		private	Nini.Config.IniConfigSource conf;

		public SysInfo()
		{
			conf = new IniConfigSource("config.ini");
			conf.Alias.AddAlias("true",true);
			conf.Alias.AddAlias("false",false);
			if (conf.Configs["System"].GetBoolean("GetSysInformation",true))
			{
				if (!GetSysInfo())
					ReadSysInfoFromConfig();		
			} 
			else 
			{
				ReadSysInfoFromConfig();		
			}
		}
		#region Properties
		public string OSName
		{
			get { return _OSName; }
		}
		public string OSVersion
		{
			get { return _OSVersion; }
		}
		public string Processor
		{
			get { return _Prozessor; }
		}
		public string Manufacturer
		{
			get { return _Manufacturer; }
		}
		public string CPUSpeed
		{
			get { return _CPUSpeed; }
		}
		public string CLRVersion
		{
			get { return _clr; }
		}
		public string VirtualMemory
		{
			 get { return _VirtualMemory; }
		}
		public string PhysicalMemory
		{
			get { return _PhysicalMemory; }
		}
		#endregion

		public override string ToString()
		{
			return _OSName + _OSVersion + _clr + _CPUSpeed + _Manufacturer + _Prozessor + _PhysicalMemory + _VirtualMemory;
		}
		/// <summary>
		/// Versucht, die Systeminformationen automatisch zu laden
		/// </summary>
		/// <returns>True bei Erfolg, False bei Fehlschlag(vor allem auf nicht Win Systemen)</returns>
		private bool GetSysInfo()
		{
			try 
			{
				System.Management.ManagementScope ms = new System.Management.ManagementScope("\\\\localhost\\root\\cimv2",  new ConnectionOptions() );      

				GetOperatingSystemInfo( ms );
				GetProcessorInfo( ms );
				GetMemoryInfo( ms );
				return true;
			}
			catch (Exception e)
			{
				return false;
			}
		}
		
		private void ReadSysInfoFromConfig()
		{
			
			_OSName = conf.Configs["System"].GetString("OSName","unkown");
			_OSVersion = conf.Configs["System"].GetString("OSVersion","unkown");
			_clr = conf.Configs["System"].GetString("CLR","unkown");
			_Prozessor = conf.Configs["System"].GetString("Processor","unkown");
			_Manufacturer = conf.Configs["System"].GetString("Manufaturer","unkown");
			_PhysicalMemory = conf.Configs["System"].GetString("RAM","unkown");
			_VirtualMemory = conf.Configs["System"].GetString("VirtualRAM","unkown");
		}

		private void GetOperatingSystemInfo( ManagementScope ms )
		{

			ManagementObjectSearcher query;
			ManagementObjectCollection queryCollection;
			System.Management.ObjectQuery objectQuery;

			//Query remote computer across the connection
			objectQuery = new System.Management.ObjectQuery("SELECT * FROM Win32_OperatingSystem");
			query = new ManagementObjectSearcher(ms,objectQuery);
  
			queryCollection = query.Get();
			foreach ( ManagementObject mo in queryCollection)
			{
				_OSName =  mo["Caption"].ToString();
				_OSVersion = mo["Version"].ToString();
			}
			_clr = Environment.Version.ToString();
		}
		private void GetProcessorInfo( ManagementScope ms )
		{

			ManagementObjectSearcher query;
			ManagementObjectCollection queryCollection;
			System.Management.ObjectQuery objectQuery;

			//get processor info
			objectQuery = new System.Management.ObjectQuery("SELECT * FROM Win32_processor");
			query = new ManagementObjectSearcher(ms,objectQuery);
			queryCollection = query.Get();

			foreach ( ManagementObject mo in queryCollection)
			{
				_Manufacturer = mo["Manufacturer"].ToString();
				_Prozessor = mo["Caption"].ToString();
				_CPUSpeed =  FormatSpeed(Int64.Parse(mo["MaxClockSpeed"].ToString()));	
			}

		}
		private void GetMemoryInfo( ManagementScope ms )
		{

			ManagementObjectSearcher query;
			ManagementObjectCollection queryCollection;
			System.Management.ObjectQuery objectQuery;
			
			//Get memory configuration
			objectQuery = new System.Management.ObjectQuery("SELECT * FROM Win32_LogicalMemoryConfiguration");
			query = new ManagementObjectSearcher(ms,objectQuery);
			queryCollection = query.Get();

			foreach ( ManagementObject mo in queryCollection)
			{
				_VirtualMemory = FormatSize(Int64.Parse(mo["TotalVirtualMemory"].ToString()), true);
				_PhysicalMemory = FormatSize(Int64.Parse(mo["TotalPhysicalMemory"].ToString()), true);
			}

		
		}
		private string FormatSize(Int64 Size, bool FormatOnly)
		{

			string stringSize = "";
			NumberFormatInfo myNfi = new NumberFormatInfo();

			Int64 size = 0;

			if(Size < 1024 ) 
			{
				if(Size == 0) 
					stringSize = "0";
				else 
					stringSize = "1";
			}
			else 
			{
				if(FormatOnly == false)
					size = Size / 1024;
				else 
					size = Size;

				//format number with default format
				stringSize = size.ToString("n",myNfi);

				//remove decimal
				stringSize = stringSize.Replace(".00", "");

			}

			return stringSize + " KB";

		}

		private string FormatSpeed( Int64 lSpeed )
		{

			float floatSpeed = 0;
			string stringSpeed = "";
			NumberFormatInfo myNfi = new NumberFormatInfo();

			if(lSpeed < 1000 ) 
				stringSpeed = lSpeed.ToString() + "MHz";
			else 
			{
				floatSpeed = (float) lSpeed / 1000;
				stringSpeed = floatSpeed.ToString() + "GHz";
			}

			return stringSpeed;

		}
	}
}
