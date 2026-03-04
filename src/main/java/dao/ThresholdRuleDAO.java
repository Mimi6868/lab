
package dao;

import dto.Pollutant;
import dto.Room;
import dto.ThresholdRule;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThresholdRuleDAO extends DBContext implements DAOInterface<ThresholdRule>{
    private static final String Insert_ThresholdRule = "INSERT INTO [dbo].[ThresholdRule]\n"
            + "           ([room_id]\n"
            + "           ,[pollutant_id]\n"
            + "           ,[lower_value]\n"
            + "           ,[upper_value]\n"
            + "           ,[duration_min]\n"
            + "           ,[severity]\n"
            + "           ,[active])\n"
            + "     VALUES\n"
            + "           (?,?,?,?,?,?,?)";//full
    private static final String Update_ThresholdRule = "UPDATE [dbo].[ThresholdRule]\n"
            + "   SET [room_id] = ?\n"
            + "      ,[pollutant_id] = ?\n"
            + "      ,[lower_value] = ?\n"
            + "      ,[upper_value] = ?\n"
            + "      ,[duration_min] = ?\n"
            + "      ,[severity] = ?\n"
            + "      ,[active] = ?\n"
            + " WHERE rule_id = ?";
    
    private static final String Delete_ThresholdRule = "DELETE FROM [dbo].[ThresholdRule]\n"
            + "      WHERE rule_id = ?";
    private static final String Select_ThresholdRule =  "select *from ThresholdRule";     
    @Override
    public int insert(ThresholdRule t) {
        try{
            PreparedStatement pp = c.prepareStatement(Insert_ThresholdRule);
            pp.setInt(1,t.getRoom().getRoomId());
            pp.setInt(2,t.getPollutant().getPollutantId());
            pp.setDouble(3,t.getLowerValue());
            pp.setDouble(4,t.getUpperValue());
            pp.setInt(5,t.getDurationMin());
            pp.setShort(6,t.getSeverity());
            pp.setBoolean(7,t.isActive());
            return pp.executeUpdate();
        }catch(SQLException e){
            System.out.println(e); 
        }
        return 0;
    }

    @Override
    public int update(ThresholdRule t) {
        try {
                PreparedStatement pp = c.prepareStatement(Update_ThresholdRule);
                pp.setInt(1,t.getRoom().getRoomId());
                pp.setInt(2,t.getPollutant().getPollutantId());
                pp.setDouble(3,t.getLowerValue());
                pp.setDouble(4,t.getUpperValue());
                pp.setInt(5,t.getDurationMin());
                pp.setShort(6,t.getSeverity());
                pp.setBoolean(7,t.isActive());
                pp.setInt(8,t.getRuleId());
                return pp.executeUpdate();   
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public int delete(int t) {
        try{
            PreparedStatement pp = c.prepareStatement(Delete_ThresholdRule);
            pp.setInt(1,t);
            return pp.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0 ;
    }

    @Override
    public List<ThresholdRule> getAll() {
        List<ThresholdRule> list = new ArrayList<>();
        try {
            PreparedStatement pp = c.prepareStatement(Select_ThresholdRule);
            ResultSet rs = pp.executeQuery();
            while(rs.next()){
                ThresholdRule tr = new ThresholdRule();
                tr.setRuleId(rs.getInt("rule_id"));
                Room r = new Room();
                r.setRoomId(rs.getInt("room_id"));
                tr.setRoom(r);
                Pollutant p = new Pollutant();
                p.setPollutantId(rs.getInt("pollutant_id"));
                tr.setPollutant(p);
                tr.setLowerValue(rs.getDouble("lower_value"));
                tr.setUpperValue(rs.getDouble("upper_value"));
                tr.setDurationMin(rs.getInt("duration_min"));
                tr.setSeverity(rs.getShort("severity"));
                tr.setActive(rs.getBoolean("active"));
                tr.setCreatedAt(rs.getObject("created_at", java.time.LocalDateTime.class));
                list.add(tr);
            }
        }catch (SQLException e){
            System.out.println(e); 
        }
        return list;
    }

    @Override
    public List<ThresholdRule> selectByCondition(String condition) {
        List<ThresholdRule> list = new ArrayList<>();
        return list;
    }
     
    
}
