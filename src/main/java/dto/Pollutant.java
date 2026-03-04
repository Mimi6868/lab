package dto;

import dao.PollutantDAO;

public class Pollutant {
//    CREATE TABLE Pollutant (
//    pollutant_id   INTEGER IDENTITY(1,1) PRIMARY KEY,
//    name           VARCHAR(100) NOT NULL UNIQUE,
//    unit           VARCHAR(20) NOT NULL
//);
    private int pollutantId ;
    private String name , unit ;

    public Pollutant() {
    }

    public Pollutant(int pollutantId, String name, String unit) {
        this.pollutantId = pollutantId;
        this.name = name;
        this.unit = unit;
    }

    public Pollutant(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }//insert
    

    public int getPollutantId() {
        return pollutantId;
    }

    public void setPollutantId(int pollutantId) {
        this.pollutantId = pollutantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
       
//    public static void main(String[] args) {
//
//        SensorDAO dao = new SensorDAO();
//
//        List<Sensor> list = dao.getAll();
//
//        if (list == null || list.isEmpty()) {
//            System.out.println("Khong co du lieu");
//            return;
//        } else {
//            System.out.println("add");
//        }
//
//    }
    
}
