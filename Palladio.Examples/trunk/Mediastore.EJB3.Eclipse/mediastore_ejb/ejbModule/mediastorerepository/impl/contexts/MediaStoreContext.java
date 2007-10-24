package mediastorerepository.impl.contexts;


// Component context class for MediaStore
public class MediaStoreContext implements mediastorerepository.impl.contexts.IMediaStoreContext {
    protected mediastorerepository.ISound iSound = null;
    protected mediastorerepository.IAudioDB iAudioDB = null;

    public MediaStoreContext() {
    }

    public MediaStoreContext(mediastorerepository.ISound iSound,
        mediastorerepository.IAudioDB iAudioDB) {
        this.iSound = iSound;

        this.iAudioDB = iAudioDB;
    }

    public mediastorerepository.ISound getRoleISound() {
        if (iSound == null) {
            throw new RuntimeException(
                "Attempt to retrieve unbounded port. Check your architecture!");
        }

        return iSound;
    }

    public mediastorerepository.IAudioDB getRoleIAudioDB() {
        if (iAudioDB == null) {
            throw new RuntimeException(
                "Attempt to retrieve unbounded port. Check your architecture!");
        }

        return iAudioDB;
    }

    public void setRoleISound(mediastorerepository.ISound newValue) {
        this.iSound = newValue;
    }

    public void setRoleIAudioDB(mediastorerepository.IAudioDB newValue) {
        this.iAudioDB = newValue;
    }
}
