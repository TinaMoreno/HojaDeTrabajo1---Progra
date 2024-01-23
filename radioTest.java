//********************
// UNIVERSIDAD DEL VALLE DE GUATEMALA
// Departamento de Ciencias De La Computacion
// CC2016 - 20
// Autores: Alvaro Jose Leon Aguilar
//          Valentina Moreno Moreno
//          Milton Giovanni Polanco Serrano 
//			Isabella Recinos RodrÃ­guez
// Fecha: Enero 23 2024
// Descripcion: Hoja de trabajo 1 - Pruebas unitarias
//********************

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class radioTest {

    private IRadio radio;

    @Before
    public void setUp() {
        radio = new Radio();
    }

    @Test
    public void testInitialState() {
        assertFalse(radio.getState());
        assertFalse(radio.getStateAMFM());
        assertEquals(0.0f, radio.getCurrentFrequency(), 0.01f);
    }

    @Test
    public void testTogglePowerOffOn() {
        radio.togglePowerOffOn();
        assertTrue(radio.getState());

        radio.togglePowerOffOn();
        assertFalse(radio.getState());
    }

    @Test
    public void testToggleAMFM() {
        assertFalse(radio.getStateAMFM());
        radio.toggleAMFM();
        assertTrue(radio.getStateAMFM());
        radio.toggleAMFM();
        assertFalse(radio.getStateAMFM());
    }

    @Test
    public void testNextAndPreviousFrequency() {
        radio.togglePowerOffOn();
        radio.nextFrequency();
        assertEquals(108f, radio.getCurrentFrequency(), 0.01f);

        radio.previousFrequency();
        assertEquals(107.8f, radio.getCurrentFrequency(), 0.01f);
    }

    @Test
    public void testSetAndGetFavFrequency() {
        radio.togglePowerOffOn();
        radio.setFavFrequency(1);
        assertEquals(0.0f, radio.getFavFrequency(1), 0.01f);

        radio.nextFrequency();
        radio.setFavFrequency(1);
        assertEquals(108.0f, radio.getFavFrequency(1), 0.01f);
    }
}
