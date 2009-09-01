package de.fzi.stanja.sissyconnector;

import de.fzi.stanja.sissyconnector.dbaccess.*;
import junit.framework.*;

public class SissyConnectionTest extends TestCase {
	
	public void testRunQuery(){
		PostGreSqlInteractor dbInteractor = PostGreSqlInteractor.getInstance();
		dbInteractor.runQuery();
	}

}
