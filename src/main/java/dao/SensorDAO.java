package dao;

import dto.Room;
import dto.Sensor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SensorDAO extends DBContext implements DAOInterface<Sensor>{
    private static final String Insert_Sensor = "INSERT INTO [dbo].[Sensor]\n"
                + "           ([room_id]\n"
                + "           ,[serial_no]\n"
                + "           ,[model]\n"
                + "           ,[status]\n"
                + "           ,[last_seen_ts])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
    private static final String Update_Sensor = "UPDATE [dbo].[Sensor]\n"
                    + "   SET [room_id] = ?\n"
                    + "      ,[serial_no] = ?\n"
                    + "      ,[model] = ?\n"
                    + "      ,[status] = ?\n"
                    + "      ,[last_seen_ts] = ?\n"
                    + " WHERE  sensor_id = ?";
    private static final String Delete_Sensor = "DELETE FROM [dbo].[Sensor]\n"
                    + "      WHERE sensor_id = ? ";
    private static final String Select_Sensor = "select * from Sensor";

    @Override
    public int insert(Sensor t) {
        try{ 
            
                PreparedStatement pp = c.prepareStatement(Insert_Sensor);
                pp.setInt(1, t.getRoom().getRoomId());
                pp.setString(2, t.getSerialNo());
                pp.setString(3, t.getModel());
                pp.setShort(4, t.getStatus());
                pp.setObject(5, t.getLastSeenTs());
                return pp.executeUpdate();
            

        } catch(SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public int update(Sensor t) {
        try {
              
                PreparedStatement pp = c.prepareStatement(Update_Sensor);
                pp.setInt(1, t.getRoom().getRoomId());
                pp.setString(2, t.getSerialNo());
                pp.setString(3, t.getModel());
                pp.setShort(4, t.getStatus());
                pp.setObject(5, t.getLastSeenTs());
                pp.setInt(6, t.getSensorId());
                return pp.executeUpdate();
            
                
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try {
            PreparedStatement pp = c.prepareStatement(Delete_Sensor);
            pp.setInt(1, id);
            return pp.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public List<Sensor> getAll() {
       List<Sensor> list = new ArrayList<>();
       try {
           PreparedStatement pp = c.prepareStatement(Select_Sensor);
           ResultSet rs = pp.executeQuery();
           while(rs.next()){
               Sensor s = new Sensor();
               s.setSensorId(rs.getInt("sensor_id"));
               //
               Room r = new Room();
               r.setRoomId(rs.getInt("room_id"));
               s.setRoom(r);
               //
               s.setSerialNo(rs.getString("serial_no"));
               s.setModel(rs.getString("model"));
               s.setStatus(rs.getShort("status"));
               s.setInstalledAt(rs.getObject("installed_at" , java.time.LocalDateTime.class));
               s.setLastSeenTs(rs.getObject("last_seen_ts",java.time.LocalDateTime.class));
               list.add(s);
           }
       }catch (SQLException e){
           System.out.println(e);
       }
       return list;
    }

    @Override
    public List<Sensor> selectByCondition(String string) {
        List<Sensor> list = new ArrayList<>();
       return list;
    }
//    public static void main(String[] args) {
//        SensorDAO rd = new SensorDAO();
//        Room room = new Room();
//        room.setRoomId(1);
//        Sensor r = new Sensor( room,"huu", "kakakaka",(short)3 );
//        if(rd.insert(r) == 1){
//            System.out.println("add !");
//        }else {
//            System.out.println("not add!");
//        }
//    }
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
