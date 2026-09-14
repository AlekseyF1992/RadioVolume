package ru.netology.javaqa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RadioTest {


    @Test
    public void testSetValidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(6);
        Assertions.assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void testNext() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.next();
        Assertions.assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void testNextFromNineToZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrev() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.prev();
        Assertions.assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void testPrevFromZeroToNine() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        Assertions.assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testSetInvalidStationBelowZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.setCurrentStation(-1);
        Assertions.assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void testSetInvalidStationAboveNine() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.setCurrentStation(10);
        Assertions.assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void testIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        radio.increaseVolume();
        radio.increaseVolume();
        Assertions.assertEquals(3, radio.getCurrentVolume());
    }

    @Test
    public void testIncreaseVolumeMax() {
        Radio radio = new Radio();
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        radio.increaseVolume();
        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolumeMin() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testInitialStation() {
        Radio radio = new Radio();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testInitialVolume() {
        Radio radio = new Radio();
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testCustomStationsCount() {
        Radio radio = new Radio(30);
        Assertions.assertEquals(30, radio.getStationsCount());
    }

    @Test
    public void testNextFromMaxCustomStation() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(29);
        radio.next();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevFromZeroCustomStation() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(0);
        radio.prev();
        Assertions.assertEquals(29, radio.getCurrentStation());
    }

    @Test
    public void testSetInvalidStationAboveCustomMax() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(15);
        radio.setCurrentStation(30);
        Assertions.assertEquals(15, radio.getCurrentStation());
    }

    @Test
    public void testDefaultConstructorSetsTenStations() {
        Radio radio = new Radio();
        Assertions.assertEquals(10, radio.getStationsCount());
    }

    @Test
    public void testSetCurrentVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        Assertions.assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    public void testSetCurrentVolumeInvalid() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.setCurrentVolume(150);
        Assertions.assertEquals(50, radio.getCurrentVolume());
    }
    
}