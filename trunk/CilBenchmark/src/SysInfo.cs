using System;
using System.Management;
using System.Globalization;
using CilBenchmark.Container.Interfaces;
using Nini.Config;

namespace CilBenchmark
{
	/// <summary>
	/// The class retrives information from the underlying system.
	/// The functions retriving the system informations were not written by the author.
	/// </summary>
	public class SysInfo : MarshalByRefObject, ISysInfo
	{
		private string osName;
		private string osVersion;
		private string processor;
		private string manufacturer;
		private string cpuSpeed;
		private string virtualMemory;
		private string physicalMemory;
		private string clrVersion;

		private	Nini.Config.IniConfigSource conf; 

		/// <summary>
		/// Standard constructor
		/// </summary>
		public SysInfo()
		{
			conf = new IniConfigSource("config.ini"); //read config
			conf.Alias.AddAlias("true",true); //define string "true" to be true
			conf.Alias.AddAlias("false",false);
			if (conf.Configs["System"].GetBoolean("GetSysInformation",true)) //check wheter to retrive the system information or read it from the config file
			{
				if (!GetSysInfo()) //in case it can't be read, like when using Mono
				{
					Console.WriteLine("The system information couldn't be retrived automaticly. I will read the information from the config file.");
					ReadSysInfoFromConfig(); 
				}
			} 
			else 
			{
				ReadSysInfoFromConfig();		
			}
		}
		#region Properties
		/// <summary>
		/// The name of the operation system
		/// </summary>
		public string OSName
		{
			get { return osName; }
		}
		/// <summary>
		/// The version of the operating system
		/// </summary>
		public string OSVersion
		{
			get { return osVersion; }
		}
		/// <summary>
		/// The name of the processor used in the computer
		/// </summary>
		public string Processor
		{
			get { return processor; }
		}
		/// <summary>
		/// The manufacturer of the pc
		/// </summary>
		public string Manufacturer
		{
			get { return manufacturer; }
		}
		/// <summary>
		/// The speed of the CPU
		/// </summary>
		public string CpuSpeed
		{
			get { return cpuSpeed; }
		}
		/// <summary>
		/// The Version number of the Common Language Runtime
		/// </summary>
		public string ClrVersion
		{
			get { return clrVersion; }
		}
		/// <summary>
		/// The size of the virtual memory 
		/// </summary>
		public string VirtualMemory
		{
			 get { return virtualMemory; }
		}
		/// <summary>
		/// The size of the physical memory
		/// </summary>
		public string PhysicalMemory
		{
			get { return physicalMemory; }
		}
		#endregion
		/// <summary>
		/// The method returns all the values as a string without delimiters
		/// </summary>
		/// <returns>The resulting string</returns>
		public override string ToString()
		{
			return osName + osVersion + clrVersion + cpuSpeed + manufacturer + processor + physicalMemory + virtualMemory;
		}
		/// <summary>
		/// The method tries to read the information from the underlying system
		/// </summary>
		/// <returns>True if successful, else False</returns>
		private bool GetSysInfo()
		{
			try 
			{
				System.Management.ManagementScope ms = new System.Management.ManagementScope("\\\\localhost\\root\\cimv2",  new ConnectionOptions() );      
				GetOperatingSystemInfo( ms );
				GetProcessorInfo( ms );
				GetMemoryInfo( ms );
				WriteSysInfoToConfig();
				return true;
			}
			catch (System.Management.ManagementException )
			{
				return false;
			}
		}
		/// <summary>
		/// The function reads the values from the config file.
		/// </summary>
		private void ReadSysInfoFromConfig()
		{
			osName = conf.Configs["System"].GetString("OSName","unkown");
			osVersion = conf.Configs["System"].GetString("OSVersion","unkown");
			clrVersion = conf.Configs["System"].GetString("CLR","unkown");
			processor = conf.Configs["System"].GetString("Processor","unkown");
			cpuSpeed = conf.Configs["System"].GetString("CPUSpeed","unkown");
			manufacturer = conf.Configs["System"].GetString("Manufaturer","unkown");
			physicalMemory = conf.Configs["System"].GetString("RAM","unkown");
			virtualMemory = conf.Configs["System"].GetString("VirtualRAM","unkown");
		}
		/// <summary>
		/// The function writes the values into the config file
		/// </summary>
		private void WriteSysInfoToConfig()
		{
			conf.Configs["System"].Set("OSName",osName);
			conf.Configs["System"].Set("OSVersion",osVersion);
			conf.Configs["System"].Set("CLR",clrVersion);
			conf.Configs["System"].Set("Processor",processor);
			conf.Configs["System"].Set("CPUSpeed",cpuSpeed);
			conf.Configs["System"].Set("Manufacturer",manufacturer);
			conf.Configs["System"].Set("RAM",physicalMemory);
			conf.Configs["System"].Set("VirtualRAM",virtualMemory);
			conf.Save();
		}
		/// <summary>
		/// The function gets the values OSName, OSVersion und CLRVersion from the system 
		/// </summary>
		/// <param name="ms">A reference to the underlying system</param>
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
				osName =  mo["Caption"].ToString();
				osVersion = mo["Version"].ToString();
			}
			clrVersion = Environment.Version.ToString();
		}
		/// <summary>
		/// The function gets the values Manufacturer, Processor und CPUSpeed from the system 
		/// </summary>
		/// <param name="ms">A reference to the underlying system</param>
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
				manufacturer = mo["Manufacturer"].ToString();
				processor = mo["Caption"].ToString();
				cpuSpeed =  FormatSpeed(Int64.Parse(mo["MaxClockSpeed"].ToString()));	
			}

		}
		/// <summary>
		/// The function gets the values VirtualMemory und PhysicalMemory from the system
		/// </summary>
		/// <param name="ms">A reference to the underlying system</param>
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
				virtualMemory = FormatSize(Int64.Parse(mo["TotalVirtualMemory"].ToString()), true);
				physicalMemory = FormatSize(Int64.Parse(mo["TotalPhysicalMemory"].ToString()), true);
			}
		}
		/// <summary>
		/// The function formats the size to a user friendly string
		/// </summary>
		/// <param name="Size">A value describing the size that has to be formatted</param>
		/// <param name="FormatOnly"></param>
		/// <returns> The function formats the size to a user friendly string</returns>
		private static string FormatSize(Int64 Size, bool FormatOnly)
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
		/// <summary>
		///  The function formats the speed to a user friendly string
		/// </summary>
		/// <param name="lSpeed">The value describing the speed that has to be formated</param>
		/// <returns>A formated string</returns>
		private static string FormatSpeed( Int64 lSpeed )
		{

			float floatSpeed = 0;
			string stringSpeed = "";
			NumberFormatInfo myNfi = new NumberFormatInfo();

			if(lSpeed < 1000 ) 
				stringSpeed = lSpeed.ToString(myNfi) + "MHz";
			else 
			{
				floatSpeed = (float) lSpeed / 1000;
				stringSpeed = floatSpeed.ToString(myNfi) + "GHz";
			}

			return stringSpeed;

		}
	}
}
