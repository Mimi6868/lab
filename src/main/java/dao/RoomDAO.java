package dao;

import dto.Room;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class RoomDAO extends DBContext implements DAOInterface<Room>{
    public RoomDAO(){
        super();
    }
    private static final String Insert_Room = "INSERT INTO [dbo].[Room]\n"
            + "           ([code]\n"
            + "           ,[name]\n"
            + "           ,[room_type]\n"
            + "           ,[location]\n"
            + "           ,[status])\n"
            + "     VALUES\n"
            + "           (?,?,?,?,?)";
    private static final String Update_Room = "UPDATE [dbo].[Room]\n"
            + "   SET [code] = ?\n"
            + "      ,[name] = ?\n"
            + "      ,[room_type] = ?\n"
            + "      ,[location] = ?\n"
            + "      ,[status] = ?\n"
            + " WHERE room_id = ?";
    private static final String Delete_Room = "DELETE FROM [dbo].[Room]\n"
            + "      WHERE room_id=?";
    private static final String Select_Room = "select * from Room";      
    @Override
    public int insert(Room t) {
        try { 
            PreparedStatement pp = c.prepareStatement(Insert_Room);
            pp.setString(1,t.getCode());
            pp.setString(2,t.getName());
            pp.setString(3,t.getRoomType());
            pp.setString(4,t.getLocation());
            pp.setShort(5,t.getStatus());
            return pp.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
           return 0 ;
        
                
    }

    @Override
    public int update(Room t) {
        try{
            PreparedStatement pp = c.prepareStatement(Update_Room);
            pp.setString(1,t.getCode());
            pp.setString(2,t.getName());
            pp.setString(3,t.getRoomType());
            pp.setString(4,t.getLocation());
            pp.setShort(5,t.getStatus());
            pp.setInt(6,t.getRoomId());
            return pp.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try{
            PreparedStatement pp = c.prepareStatement(Delete_Room);
            pp.setInt(1,id);
            return pp.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return 0 ;
    }

    @Override
    public List<Room> getAll() {
        List<Room> list = new ArrayList<>();
         try {
            PreparedStatement pp = c.prepareStatement(Select_Room);
            ResultSet rs = pp.executeQuery();
            while(rs.next()){
                Room r = new Room(rs.getInt("room_id"),rs.getString("code")
                        ,rs.getString("name"),rs.getString("room_type"),rs.getString("location")
                        ,rs.getShort("status"), rs.getObject("created_at",java.time.LocalDateTime.class));
                list.add(r);
            }
                  
        }catch (SQLException e){
            System.out.println(e);
        }
        return list ;  
    }

    @Override
    public List<Room> selectByCondition(String condition) {
       List<Room> list = new ArrayList<>();
       return list;
    }
//     public static void main(String[] args) {
//        RoomDAO rd = new RoomDAO();
//       // Room r = new Room( 6,"huuuu", "hihi","haaaa","hihi", (short) 3);
//        if(rd.delete(6) == 1){
//            System.out.println("add !");
//        }else {
//            System.out.println("not add!");
//        }
//    }
//    public static void main(String[] args) {
//
//        RoomDAO dao = new RoomDAO();
//
//        List<Room> list = dao.getAll();
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
