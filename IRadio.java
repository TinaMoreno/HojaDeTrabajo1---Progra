public interface IRadio {
    boolean getState();

    void togglePowerOffOn();

    void toggleAMFM();

    boolean getStateAMFM();

    void nextFrequency();

    void previousFrequency();

    float getCurrentFrequency();

    void setFavFrequency(int button);

    float getFavFrequency(int button);
}
