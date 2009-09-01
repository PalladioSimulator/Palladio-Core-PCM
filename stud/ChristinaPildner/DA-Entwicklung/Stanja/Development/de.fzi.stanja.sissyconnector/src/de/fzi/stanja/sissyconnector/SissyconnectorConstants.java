package de.fzi.stanja.sissyconnector;

import org.eclipse.core.runtime.IPath;

public class SissyconnectorConstants {
	
/*cplugin constants*/
	public final static String ANALYZER_ID  = "de.fzi.stanja.sissyconnector";
	
/*constante for the sissy connection*/
	public final static String PLUGINID_SERVICE_RESOURCES = "de.sissy4eclipse.service.resources";
	public final static String SISSY_RUN_CLASS = "de.fzi.sissy.SissyRun";
	public final static char PATH_SEPARATOR = IPath.SEPARATOR;
	public final static String PATH_TO_RESSOURCES = "resources";
	public final static String PATH_TO_SQL = PATH_TO_RESSOURCES	+ PATH_SEPARATOR + "sql";
	// TODO nötig?
	public final static String PATH_TO_STANDALONE = PATH_TO_SQL + PATH_SEPARATOR + "00_standalone";

/*extention points*/
	public final static String STANJA_EP_ANALYZER = "de.fzi.stanja.analyzer";
	
/*constants for the database connection*/
	/*postgreSQL*/
	public final static String PGSQL_AUTO_RECONECT =  "true";
	public static final String PGSQL_MAX_RECONNECTS = "4";
	public static final String PGSQL_DRIVER = "org.postgresql.Driver";
	
	/*connection properties*/
	public static final String PGSQL_CP_USER = "user";
	public static final String PGSQL_CP_PASSWORD = "password";
	public static final String PGSQL_CP_AUTORECONECT = "autoReconnect";
	public static final String PGSQL_CP_MAXRECONNECTS = "maxReconnects";
	
	/*Language*/
	public static final String PGSQL_CONNECTION_STATUS_INFO ="The connection settings seemes to be valid";
	
	/*test query*/
	public static final String SQL_TEST_QUERY = "SELECT package.fullname AS PackageFullName, class.name AS ClassName,variable.name AS ElementName, file.pathname AS FilePathName, source.startline AS StartLine, source.startchar AS StartChar FROM tvariables variable JOIN tpackages AS package ON (package.id = variable.packageid) JOIN tmembers AS variableAttributes ON (variable.id = variableAttributes.id) JOIN tmembers AS class ON (class.id = variable.classid) JOIN tsourceentities AS source ON (variable.id = source.id) JOIN tfiles AS file ON (source.sourcefileid = file.id) WHERE variableAttributes.isstatic = 1  AND variableAttributes.isfinal = 0  AND class.visibility = 145";
	
	
	/*test constants*/
	public static final String TEST_DB_NAME = "sissy";
	public static final String TEST_DB_URL = "jdbc:postgresql://localhost:5432/";
	public final static String TEST_DB_LOGIN = "sissy";
	public final static String TEST_DB_PASSWORD = "sissy";
	
	/*SQL exception states*/
	public static final String SQLEXCEPTION_STATE_NOSUCHDATABASE = "3D000";
	public static final String SQLEXCEPTION_STATE_ALREADYEXISTS = "42710";
		
	
}