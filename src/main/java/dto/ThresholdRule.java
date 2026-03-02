
package dto;

import java.time.LocalDateTime;

public class ThresholdRule {
//    rule_id        INTEGER IDENTITY(1,1) PRIMARY KEY,
//    room_id        INTEGER NOT NULL,
//    pollutant_id   INTEGER NOT NULL,
//    lower_value    FLOAT NULL,
//    upper_value    FLOAT NULL,
//    duration_min   INT NOT NULL,
//    severity       TINYINT NOT NULL,
//    active         BIT NOT NULL DEFAULT 1,
//    created_at     DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
//
//    CONSTRAINT FK_Rule_Room
//        FOREIGN KEY (room_id)
//        REFERENCES Room(room_id),
//
//    CONSTRAINT FK_Rule_Pollutant
//        FOREIGN KEY (pollutant_id)
//        REFERENCES Pollutant(pollutant_id)
    private int ruleId ;
    private Room room ;
    private Pollutant pollutant ;
    private Double lowerValue , upperValue ;
    private int durationMin ;
    private short severity;
    private boolean active ; 
    private LocalDateTime createdAt ;   

    public ThresholdRule() {
    }

    public ThresholdRule(int ruleId, Room room, Pollutant pollutant, Double lowerValue, Double upperValue, int durationMin, short severity, boolean active, LocalDateTime createdAt) {
        this.ruleId = ruleId;
        this.room = room;
        this.pollutant = pollutant;
        this.lowerValue = lowerValue;
        this.upperValue = upperValue;
        this.durationMin = durationMin;
        this.severity = severity;
        this.active = active;
        this.createdAt = createdAt;
    }

    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Pollutant getPollutant() {
        return pollutant;
    }

    public void setPollutant(Pollutant pollutant) {
        this.pollutant = pollutant;
    }

    public Double getLowerValue() {
        return lowerValue;
    }

    public void setLowerValue(Double lowerValue) {
        this.lowerValue = lowerValue;
    }

    public Double getUpperValue() {
        return upperValue;
    }

    public void setUpperValue(Double upperValue) {
        this.upperValue = upperValue;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }

    public short getSeverity() {
        return severity;
    }

    public void setSeverity(short severity) {
        this.severity = severity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


       
}
