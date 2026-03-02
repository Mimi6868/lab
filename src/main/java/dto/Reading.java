package dto;

import java.time.LocalDateTime;

public class Reading {
//    reading_id     INTEGER IDENTITY(1,1) PRIMARY KEY,
//    sensor_id      INTEGER NOT NULL,
//    pollutant_id   INTEGER NOT NULL,
//    ts             DATETIME2 ,
//    value          FLOAT NOT NULL,
//    quality_flag   TINYINT NOT NULL DEFAULT 1,
//    created_at     DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
//
//    CONSTRAINT FK_Reading_Sensor
//        FOREIGN KEY (sensor_id)
//        REFERENCES Sensor(sensor_id),
//
//    CONSTRAINT FK_Reading_Pollutant
//        FOREIGN KEY (pollutant_id)
//        REFERENCES Pollutant(pollutant_id)
    private int readingId;
    private Sensor sensor ;
    private Pollutant pollutant;
    private LocalDateTime ts ;
    private double value ;
    private short qualityFlag;
    private LocalDateTime createdAt ;

    public Reading() {
    }

    public Reading(int readingId, Sensor sensor, Pollutant pollutant, LocalDateTime ts, double value, short qualityFlag, LocalDateTime createdAt) {
        this.readingId = readingId;
        this.sensor = sensor;
        this.pollutant = pollutant;
        this.ts = ts;
        this.value = value;
        this.qualityFlag = qualityFlag;
        this.createdAt = createdAt;
    }

    public int getReadingId() {
        return readingId;
    }

    public void setReadingId(int readingId) {
        this.readingId = readingId;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Pollutant getPollutant() {
        return pollutant;
    }

    public void setPollutant(Pollutant pollutant) {
        this.pollutant = pollutant;
    }

    public LocalDateTime getTs() {
        return ts;
    }

    public void setTs(LocalDateTime ts) {
        this.ts = ts;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public short getQualityFlag() {
        return qualityFlag;
    }

    public void setQualityFlag(short qualityFlag) {
        this.qualityFlag = qualityFlag;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    
            
}
