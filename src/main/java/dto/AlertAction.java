package dto;

import java.time.LocalDateTime;

public class AlertAction {
//    action_id       INTEGER IDENTITY(1,1) PRIMARY KEY,
//    alert_id        INTEGER NOT NULL,
//    actor_user_id   INTEGER NOT NULL,
//    action_type     TINYINT NOT NULL,
//    note            NVARCHAR(255),
//    action_ts       DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
//
//    FOREIGN KEY (alert_id) REFERENCES Alert(alert_id)
    private int actionId;
    private Alert alert;
    private int actorUserId  ;
    private short actionType;
    private String note ;
    private LocalDateTime actionTs;

    public AlertAction() {
    }

    public AlertAction(int actionId, Alert alert, int actorUserId, short actionType, String note, LocalDateTime actionTs) {
        this.actionId = actionId;
        this.alert = alert;
        this.actorUserId = actorUserId;
        this.actionType = actionType;
        this.note = note;
        this.actionTs = actionTs;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    public int getActorUserId() {
        return actorUserId;
    }

    public void setActorUserId(int actorUserId) {
        this.actorUserId = actorUserId;
    }

    public short getActionType() {
        return actionType;
    }

    public void setActionType(short actionType) {
        this.actionType = actionType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getActionTs() {
        return actionTs;
    }

    public void setActionTs(LocalDateTime actionTs) {
        this.actionTs = actionTs;
    }
    
    
}
