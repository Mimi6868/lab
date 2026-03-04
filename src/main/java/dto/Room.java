
package dto;


import java.time.LocalDateTime;

public class Room {
//    roomId     INTEGER IDENTITY(1,1) PRIMARY KEY,
//    code        VARCHAR(50) NOT NULL UNIQUE,
//    name        NVARCHAR(150) ,
//    room_type   VARCHAR(50) ,
//    location    NVARCHAR(255),
//    status      TINYINT NOT NULL DEFAULT 1,
//    createdAt  DATETIME2 NOT NULL DEFAULT SYSDATETIME()
    private int roomId ;
    private String code , name , roomType , location ;
    private short status ;
    private LocalDateTime createdAt ;

    public Room() {
    }

    public Room(int roomId, String code, String name, String roomType, String location, short status, LocalDateTime createdAt ) {
        this.roomId = roomId;
        this.code = code;
        this.name = name;
        this.roomType = roomType;
        this.location = location;
        this.status = status;
        this.createdAt  = createdAt ;
    }
    public Room(int roomId, String code, String name, String roomType, String location, short status ) {
        this.roomId = roomId;
        this.code = code;
        this.name = name;
        this.roomType = roomType;
        this.location = location;
        this.status = status;
    }

    public Room(String code, String name, String roomType, String location, short status) {
        this.code = code;
        this.name = name;
        this.roomType = roomType;
        this.location = location;
        this.status = status;
    }
    

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoom_type(String roomType) {
        this.roomType = roomType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt ;
    }

    public void setCreatedAt (LocalDateTime createdAt ) {
        this.createdAt  = createdAt ;
    }
    
    
}
