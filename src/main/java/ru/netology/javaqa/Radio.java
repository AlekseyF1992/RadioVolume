package ru.netology.javaqa;

public class Radio {
    private int currentStation;
    private int currentVolume;

    private static final int MIN_STATION = 0;
    private static final int MAX_STATION = 9;
    private static final int MIN_VOLUME = 0;
    private static final int MAX_VOLUME = 100;

    public Radio() {
        currentStation = MIN_STATION;
        currentVolume = MIN_VOLUME;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void next() {
        if (currentStation == MAX_STATION) {
            currentStation = MIN_STATION;
        } else {
            currentStation = currentStation + 1;
        }
    }

    public void prev() {
        if (currentStation == MIN_STATION) {
            currentStation = MAX_STATION;
        } else {
            currentStation = currentStation - 1;
        }
    }

    public void setCurrentStation(int newStation) {
        if (newStation >= MIN_STATION && newStation <= MAX_STATION) {
            currentStation = newStation;
        }
    }

    public void increaseVolume() {
        if (currentVolume < MAX_VOLUME) {
            currentVolume = currentVolume + 1;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > MIN_VOLUME) {
            currentVolume = currentVolume - 1;
        }
    }

    public void setCurrentVolume(int newVolume) {
        if (newVolume >= MIN_VOLUME && newVolume <= MAX_VOLUME) {
            currentVolume = newVolume;
        }
    }
}