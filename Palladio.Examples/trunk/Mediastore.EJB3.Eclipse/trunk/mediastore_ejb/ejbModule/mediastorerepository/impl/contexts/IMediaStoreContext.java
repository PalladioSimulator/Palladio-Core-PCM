package mediastorerepository.impl.contexts;


// Component context interface for MediaStore
public interface IMediaStoreContext {
    mediastorerepository.ISound getRoleISound();

    mediastorerepository.IAudioDB getRoleIAudioDB();

    void setRoleISound(mediastorerepository.ISound newValue);

    void setRoleIAudioDB(mediastorerepository.IAudioDB newValue);
}
