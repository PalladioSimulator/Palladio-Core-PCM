namespace Palladio.Reliability.DatabaseSchema
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	public class DBFactory
	{
		public static TableFactory CallTableFactory
		{
			get { return callTableFactory; }
		}

		public static TableFactory ExecutionTimeTable
		{
			get { return executionTimeTable; }
		}

		public static TableFactory CallInfoTableFactory
		{
			get { return callInfoTableFactory; }
		}

		public static TableFactory RunTableFactory
		{
			get { return runTableFactory; }
		}

		public static TableFactory ClassTableFactory
		{
			get { return classTableFactory; }
		}

		public static TableFactory MethodTableFactory
		{
			get { return methodTableFactory; }
		}

		public static void CreateReliabilityDB(string connectionString)
		{
			runTableFactory.CreateTable(connectionString);
			callTableFactory.CreateTable(connectionString);
			classTableFactory.CreateTable(connectionString);
			methodTableFactory.CreateTable(connectionString);
			callInfoTableFactory.CreateTable(connectionString);
			executionTimeTable.CreateTable(connectionString);
		}

		public static void DropReliabilityDB(string connectionString)
		{
			executionTimeTable.DropTable(connectionString);
			callInfoTableFactory.DropTable(connectionString);
			methodTableFactory.DropTable(connectionString);
			classTableFactory.DropTable(connectionString);
			callTableFactory.DropTable(connectionString);
			runTableFactory.DropTable(connectionString);
		}

		private static TableFactory callTableFactory = new TableFactory(
			"CallTable",
			"CREATE TABLE [CallTable]([ID] [bigint] IDENTITY (1, 1) NOT FOR REPLICATION NOT NULL, [CallNumber] [bigint] NOT NULL, [CallLevel] [bigint] NOT NULL, [CallerID] [bigint] NOT NULL, [ClassName] [varchar](256) COLLATE Latin1_General_CI_AS NOT NULL, [InterfaceName] [varchar](256) COLLATE Latin1_General_CI_AS NOT NULL, [MethodName] [varchar](256) COLLATE Latin1_General_CI_AS NOT NULL, [CallTime] [bigint] NOT NULL, [ReturnTime] [bigint] NOT NULL, [ExecutionTime] AS ([ReturnTime] - [CallTime]), [RunID] [bigint] NOT NULL, [ThreadID] [bigint] NOT NULL, CONSTRAINT [PK_CallTable] PRIMARY KEY CLUSTERED ([ID]) ON [PRIMARY], CONSTRAINT [FK_CallTable_RunTable] FOREIGN KEY ([RunID]) REFERENCES [RunTable]([ID])) ON [PRIMARY]"
			);

		private static TableFactory executionTimeTable = new TableFactory(
			"ExecutionTimeTable",
			"CREATE TABLE [ExecutionTimeTable]([MethodID] [bigint] NOT NULL, [TotalTime] [bigint] NOT NULL, [NumOfCalls] [bigint] NOT NULL, [AverageTime] [bigint] NOT NULL, CONSTRAINT [PK_ExecutionTimeTable] PRIMARY KEY CLUSTERED ([MethodID]) ON [PRIMARY], CONSTRAINT [FK_ExecutionTimeTable_MethodTable] FOREIGN KEY ([MethodID]) REFERENCES [MethodTable]([ID])) ON [PRIMARY]"
			);

		private static TableFactory callInfoTableFactory = new TableFactory(
			"CallInfoTable",
			"CREATE TABLE [CallInfoTable]([ID] [bigint] IDENTITY (1, 1) NOT FOR REPLICATION NOT NULL, [MethodID] [bigint] NOT NULL, [CallTime] [bigint] NOT NULL, [ReturnTime] [bigint] NOT NULL, [ExecutionTime] AS ([ReturnTime] - [CallTime]), CONSTRAINT [PK_TimeTable] PRIMARY KEY CLUSTERED ([ID]) ON [PRIMARY], CONSTRAINT [FK_TimeTable_MethodTable] FOREIGN KEY ([MethodID]) REFERENCES [MethodTable]([ID])) ON [PRIMARY]"
			);

		private static TableFactory runTableFactory = new TableFactory(
			"RunTable",
			"CREATE TABLE [RunTable]([ID] [bigint] IDENTITY (1, 1) NOT FOR REPLICATION NOT NULL, [StartTime] [bigint] NOT NULL, [StopTime] [bigint] NOT NULL, CONSTRAINT [PK_RunTable] PRIMARY KEY CLUSTERED ([ID]) ON [PRIMARY]) ON [PRIMARY]"
			);

		private static TableFactory classTableFactory = new TableFactory(
			"ClassTable",
			"CREATE TABLE [ClassTable]([ID] [bigint] IDENTITY (1, 1) NOT FOR REPLICATION NOT NULL, [ClassName] [varchar](256) COLLATE Latin1_General_CI_AS NOT NULL, [InterfaceName] [varchar](256) COLLATE Latin1_General_CI_AS NOT NULL, CONSTRAINT [PK_ClassTable] PRIMARY KEY CLUSTERED ([ID]) ON [PRIMARY]) ON [PRIMARY]"
			);

		private static TableFactory methodTableFactory = new TableFactory(
			"MethodTable",
			"CREATE TABLE [MethodTable]([ID] [bigint] IDENTITY (1, 1) NOT FOR REPLICATION NOT NULL, [ClassID] [bigint] NOT NULL, [MethodName] [varchar](256) COLLATE Latin1_General_CI_AS NOT NULL, CONSTRAINT [PK_MethodTable] PRIMARY KEY CLUSTERED ([ID]) ON [PRIMARY], CONSTRAINT [FK_MethodTable_ClassTable] FOREIGN KEY ([ClassID]) REFERENCES [ClassTable]([ID])) ON [PRIMARY]"
			);
	}
}