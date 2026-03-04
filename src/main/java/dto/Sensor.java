package dto;

import java.time.LocalDateTime;

public class Sensor {
//    sensorId       INTEGER IDENTITY(1,1) PRIMARY KEY,
//    room_id        INTEGER NOT NULL,
//    serialNo     VARCHAR(100)  UNIQUE,
//    model          VARCHAR(100) ,
//    status         TINYINT NOT NULL DEFAULT 1,
//    installedAt   DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
//    last_seen_ts   DATETIME2 NULL,
//
//    CONSTRAINT FK_Sensor_Room
//        FOREIGN KEY (room_id)
//        REFERENCES Room(room_id)

    private int sensorId;
    private Room room;
    private String serialNo, model;
    private short status;
    private LocalDateTime installedAt, lastSeenTs;

    public Sensor() {
    }

    public Sensor(int sensorId, Room room, String serialNo, String model, short status, LocalDateTime installedAt, LocalDateTime lastSeenTs) {
        this.sensorId = sensorId;
        this.room = room;
        this.serialNo = serialNo;
        this.model = model;
        this.status = status;
        this.installedAt = installedAt;
        this.lastSeenTs = lastSeenTs;
    }//select

    public Sensor(Room room, String serialNo, String model, short status, LocalDateTime lastSeenTs) {
        this.room = room;
        this.serialNo = serialNo;
        this.model = model;
        this.status = status;
        this.lastSeenTs = lastSeenTs;
    }//insert1

    public Sensor(Room room, String serialNo, String model, short status) {
        this.room = room;
        this.serialNo = serialNo;
        this.model = model;
        this.status = status;
    }//insert2

    public Sensor(int sensorId, Room room, String serialNo, String model, short status, LocalDateTime lastSeenTs) {
        this.sensorId = sensorId;
        this.room = room;
        this.serialNo = serialNo;
        this.model = model;
        this.status = status;
        this.lastSeenTs = lastSeenTs;
    }//update1

    public Sensor(int sensorId, Room room, String serialNo, String model, short status) {
        this.sensorId = sensorId;
        this.room = room;
        this.serialNo = serialNo;
        this.model = model;
        this.status = status;
    }//update2
    
    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public LocalDateTime getInstalledAt() {
        return installedAt;
    }

    public void setInstalledAt(LocalDateTime installedAt) {
        this.installedAt = installedAt;
    }

    public LocalDateTime getLastSeenTs() {
        return lastSeenTs;
    }

    public void setLastSeenTs(LocalDateTime lastSeenTs) {
        this.lastSeenTs = lastSeenTs;
    }

}
