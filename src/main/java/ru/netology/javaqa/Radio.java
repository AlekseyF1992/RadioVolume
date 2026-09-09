package ru.netology.javaqa;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private final int stationsCount;

    private static final int DEFAULT_STATIONS_COUNT = 10;
    private static final int MIN_STATION = 0;
    private static final int MIN_VOLUME = 0;
    private static final int MAX_VOLUME = 100;

    public Radio() {
        this.stationsCount = DEFAULT_STATIONS_COUNT;
        this.currentStation = MIN_STATION;
        this.currentVolume = MIN_VOLUME;
    }

    public Radio(int stationsCount) {
        if (stationsCount <= 0) {
            this.stationsCount = DEFAULT_STATIONS_COUNT;
        } else {
            this.stationsCount = stationsCount;
        }
        this.currentStation = MIN_STATION;
        this.currentVolume = MIN_VOLUME;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getStationsCount() {
        return stationsCount;
    }

    public void next() {
        if (currentStation == stationsCount - 1) {
            currentStation = MIN_STATION;
        } else {
            currentStation = currentStation + 1;
        }
    }

    public void prev() {
        if (currentStation == MIN_STATION) {
            currentStation = stationsCount - 1;
        } else {
            currentStation = currentStation - 1;
        }
    }

    public void setCurrentStation(int newStation) {
        if (newStation >= MIN_STATION && newStation < stationsCount) {
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