package mediastorerepository.impl.contexts;


// Component context interface for DBAdapter
public interface IDBAdapterContext {
    mediastorerepository.IMySQL getRoleIMySQL();

    void setRoleIMySQL(mediastorerepository.IMySQL newValue);
}
