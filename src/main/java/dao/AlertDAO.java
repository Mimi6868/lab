package dao;

import dto.Alert;
import dto.Room;
import dto.Sensor;
import dto.ThresholdRule;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

public class AlertDAO extends DBContext implements DAOInterface<Alert>{
    private static final String Insert_Alert = "INSERT INTO [dbo].[Alert]\n"
            + "           ([room_id]\n"
            + "           ,[sensor_id]\n"
            + "           ,[rule_id]\n"
            + "           ,[alert_type]\n"
            + "           ,[pollutant_id]\n"
            + "           ,[start_ts]\n"
            + "           ,[end_ts]\n"
            + "           ,[severity]\n"
            + "           ,[status]\n"
            + "           ,[message]\n"
            + "           ,[assigned_to])\n"
            + "     VALUES\n"
            + "           (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String Update_Alert = "UPDATE [dbo].[Alert]\n"
            + "   SET [room_id] = ?\n"
            + "      ,[sensor_id] = ?\n"
            + "      ,[rule_id] = ?\n"
            + "      ,[alert_type] = ?\n"
            + "      ,[pollutant_id] = ?\n"
            + "      ,[start_ts] = ?\n"
            + "      ,[end_ts] = ?\n"
            + "      ,[severity] = ?\n"
            + "      ,[status] = ?\n"
            + "      ,[message] = ?\n"
            + "      ,[assigned_to] = ?\n"
            + " WHERE alert_id = ?";
    private static final String Delete_Alert = "DELETE FROM [dbo].[Alert]\n"
            + "      WHERE alert_id = ?";
    private static final String Select_Alert = "select *from Alert "; 
    @Override
    public int insert(Alert t) {
        try {
            PreparedStatement pp = c.prepareStatement(Insert_Alert);
            pp.setInt(1,t.getRoom().getRoomId());
            pp.setInt(2,t.getSensor().getSensorId());
            pp.setInt(3,t.getThresholdRule().getRuleId());
            pp.setShort(4,t.getAlertType());
            pp.setInt(5,t.getPollutantId());
            pp.setObject(6, t.getStartTs());
            pp.setObject(7, t.getEndTs());
            pp.setShort(8,t.getSeverity());
            pp.setShort(9,t.getStatus());
            pp.setString(10, t.getMessage());
            pp.setLong(11,t.getAssignedTo());
            return pp.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public int update(Alert t) {
        try {
            PreparedStatement pp = c.prepareStatement(Update_Alert);
            pp.setInt(1,t.getRoom().getRoomId());
            pp.setInt(2,t.getSensor().getSensorId());
            pp.setInt(3,t.getThresholdRule().getRuleId());
            pp.setShort(4,t.getAlertType());
            pp.setInt(5,t.getPollutantId());
            pp.setObject(6, t.getStartTs());
            pp.setObject(7, t.getEndTs());
            pp.setShort(8,t.getSeverity());
            pp.setShort(9,t.getStatus());
            pp.setString(10, t.getMessage());
            pp.setLong(11,t.getAssignedTo());
            pp.setInt(12,t.getAlertId());
            return pp.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public int delete(int t) {
        try {
            PreparedStatement pp = c.prepareStatement(Delete_Alert);
            pp.setInt(1, t);
            return pp.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public List<Alert> getAll() {
        List<Alert> list = new ArrayList<>();
        try{
            PreparedStatement pp = c.prepareStatement(Select_Alert);
            ResultSet rs = pp.executeQuery();
            while(rs.next()){
                Alert a = new Alert();
                a.setAlertId(rs.getInt("alert_id"));
                Room r = new Room();
                r.setRoomId(rs.getInt("room_id"));
                a.setRoom(r);
                Sensor s = new Sensor();
                s.setSensorId(rs.getInt("sensor_id"));
                ThresholdRule tr = new ThresholdRule();
                tr.setRuleId(rs.getInt("rule_id"));
                a.setThresholdRule(tr);
                a.setAlertType(rs.getShort("alert_type"));
                a.setPollutantId(rs.getInt("pollutant_id"));
                a.setStartTs(rs.getObject("start_ts", java.time.LocalDateTime.class));
                a.setEndTs(rs.getObject("end_ts", java.time.LocalDateTime.class));
                a.setSeverity(rs.getShort("severity"));
                a.setStatus(rs.getShort("status"));
                a.setMessage(rs.getString("message"));
                a.setCreatedAt(rs.getObject("created_at", java.time.LocalDateTime.class));
                a.setAssignedTo(rs.getLong("assigned_to"));
                list.add(a);
                
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return list;
    }

    @Override
    public List<Alert> selectByCondition(String condition) {
        List<Alert> list = new ArrayList<>();
        return list;
    }
     
     
    
}
