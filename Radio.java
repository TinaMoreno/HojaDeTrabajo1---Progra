//********************
// UNIVERSIDAD DEL VALLE DE GUATEMALA
// Departamento de Ciencias De La Computacion
// CC2016 - 20
// Autores: Alvaro Jose Leon Aguilar
//          Valentina Moreno Moreno
//          Milton Giovanni Polanco Serrano 
//			Isabella Recinos RodrÃ­guez
// Fecha: Enero 23 2024
// Descripcion: Hoja de trabajo 1 - Radio
//********************
public class Radio implements IRadio {
    private boolean state;
    private float frequency;
    private boolean isAM;
    private float[] amFrequencyRange = { 530.0f, 1700.0f };
    private float[] fmFrequencyRange = { 88.0f, 108.0f };
    private float[] favFrequencies = new float[12];

    @Override
    public boolean getState() {
        return state;
    }

    @Override
    public void togglePowerOffOn() {
        state = !state;
        if (!state) {
            // Radio is turned off, reset frequency and mode
            frequency = 0.0f;
            isAM = false;
        }
    }

    @Override
    public void toggleAMFM() {
        isAM = !isAM;
        // Ensure the frequency stays within the valid range after mode toggle
        if (isAM && (frequency < amFrequencyRange[0] || frequency > amFrequencyRange[1])) {
            frequency = amFrequencyRange[0];
        } else if (!isAM && (frequency < fmFrequencyRange[0] || frequency > fmFrequencyRange[1])) {
            frequency = fmFrequencyRange[0];
        }
    }

    @Override
    public boolean getStateAMFM() {
        return isAM;
    }

    @Override
    public void nextFrequency() {
        frequency += (isAM ? 10.0f : 0.2f);
        validateFrequencyRange();
    }

    @Override
    public void previousFrequency() {
        frequency -= (isAM ? 10.0f : 0.2f);
        validateFrequencyRange();
    }

    private void validateFrequencyRange() {
        if (isAM) {
            if (frequency < amFrequencyRange[0]) {
                frequency = amFrequencyRange[1];
            } else if (frequency > amFrequencyRange[1]) {
                frequency = amFrequencyRange[0];
            }
        } else {
            if (frequency < fmFrequencyRange[0]) {
                frequency = fmFrequencyRange[1];
            } else if (frequency > fmFrequencyRange[1]) {
                frequency = fmFrequencyRange[0];
            }
        }
    }

    @Override
    public float getCurrentFrequency() {
        return frequency;
    }

    @Override
    public void setFavFrequency(int button) {
        if (button >= 1 && button <= 12) {
            favFrequencies[button - 1] = frequency;
        }
    }

    @Override
    public float getFavFrequency(int button) {
        if (button >= 1 && button <= 12) {
            return favFrequencies[button - 1];
        }
        return 0.0f; // Return 0.0 if the button index is invalid
    }
}
