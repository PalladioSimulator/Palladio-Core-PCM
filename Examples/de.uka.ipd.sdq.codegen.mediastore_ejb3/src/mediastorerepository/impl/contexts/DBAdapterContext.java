package mediastorerepository.impl.contexts;


// Component context class for DBAdapter
public class DBAdapterContext implements mediastorerepository.impl.contexts.IDBAdapterContext {
    protected mediastorerepository.IMySQL iMySQL = null;

    public DBAdapterContext() {
    }

    public DBAdapterContext(mediastorerepository.IMySQL iMySQL) {
        this.iMySQL = iMySQL;
    }

    public mediastorerepository.IMySQL getRoleIMySQL() {
        if (iMySQL == null) {
            throw new RuntimeException(
                "Attempt to retrieve unbounded port. Check your architecture!");
        }

        return iMySQL;
    }

    public void setRoleIMySQL(mediastorerepository.IMySQL newValue) {
        this.iMySQL = newValue;
    }
}
