//********************
// UNIVERSIDAD DEL VALLE DE GUATEMALA
// Departamento de Ciencias De La Computacion
// CC2016 - 20
// Autores: Alvaro Jose Leon Aguilar
//          Valentina Moreno Moreno
//          Milton Giovanni Polanco Serrano 
//			Isabella Recinos RodrÃ­guez
// Fecha: Enero 23 2024
// Descripcion: Hoja de trabajo 1 - IRadio
//********************
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
