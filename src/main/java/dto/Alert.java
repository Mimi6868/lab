package dto;

import java.time.LocalDateTime;

public class Alert {
//    alert_id       INTEGER IDENTITY(1,1) PRIMARY KEY,
//    room_id        INTEGER NOT NULL,
//    sensor_id      INTEGER NOT NULL,
//    rule_id        INTEGER NULL,
//    alert_type     TINYINT NOT NULL,
//    pollutant_id   INTEGER NULL,
//    start_ts       DATETIME2 NOT NULL,
//    end_ts         DATETIME2 NULL,
//    severity       TINYINT NOT NULL,
//    status         TINYINT NOT NULL DEFAULT 1,
//    message        NVARCHAR(MAX),
//    created_at     DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
//    assigned_to    BIGINT NULL,
//
//    FOREIGN KEY (room_id) REFERENCES Room(room_id),
//    FOREIGN KEY (sensor_id) REFERENCES Sensor(sensor_id),
//    FOREIGN KEY (rule_id) REFERENCES ThresholdRule(rule_id)
    private int alertId;
    private Room room;
    private Sensor sensor;
    private ThresholdRule thresholdRule;
    private short alertType;
    private Integer pollutantId ;
    private LocalDateTime startTs , endTs;
    private short severity ,status ;
    private String message ;
    private LocalDateTime createdAt ;
    private Long assignedTo;

    public Alert() {
    }

    public Alert(int alertId, Room room, Sensor sensor, ThresholdRule thresholdRule, short alertType, int pollutantId, LocalDateTime startTs, LocalDateTime endTs, short severity, short status, String message, LocalDateTime createdAt, Long assignedTo) {
        this.alertId = alertId;
        this.room = room;
        this.sensor = sensor;
        this.thresholdRule = thresholdRule;
        this.alertType = alertType;
        this.pollutantId = pollutantId;
        this.startTs = startTs;
        this.endTs = endTs;
        this.severity = severity;
        this.status = status;
        this.message = message;
        this.createdAt = createdAt;
        this.assignedTo = assignedTo;
    }

    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public ThresholdRule getThresholdRule() {
        return thresholdRule;
    }

    public void setThresholdRule(ThresholdRule thresholdRule) {
        this.thresholdRule = thresholdRule;
    }

    public short getAlertType() {
        return alertType;
    }

    public void setAlertType(short alertType) {
        this.alertType = alertType;
    }

    public int getPollutantId() {
        return pollutantId;
    }

    public void setPollutantId(int pollutantId) {
        this.pollutantId = pollutantId;
    }

    public LocalDateTime getStartTs() {
        return startTs;
    }

    public void setStartTs(LocalDateTime startTs) {
        this.startTs = startTs;
    }

    public LocalDateTime getEndTs() {
        return endTs;
    }

    public void setEndTs(LocalDateTime endTs) {
        this.endTs = endTs;
    }

    public short getSeverity() {
        return severity;
    }

    public void setSeverity(short severity) {
        this.severity = severity;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }
    
    
            
    
}
