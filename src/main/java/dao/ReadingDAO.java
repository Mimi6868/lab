/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Pollutant;
import dto.Reading;
import dto.Sensor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ReadingDAO extends DBContext implements DAOInterface<Reading>{
    private static final String Insert_Reading = "INSERT INTO [dbo].[Reading]\n"
            + "           ([sensor_id]\n"
            + "           ,[pollutant_id]\n"
            + "           ,[ts]\n"
            + "           ,[value]\n"
            + "           ,[quality_flag])\n"
            + "     VALUES\n"
            + "           (?,?,?,?,?)";
    private static final String Update_Reading = "UPDATE [dbo].[Reading]\n"
            + "   SET [sensor_id] = ?\n"
            + "      ,[pollutant_id] = ?\n"
            + "      ,[ts] = ?\n"
            + "      ,[value] = ?\n"
            + "      ,[quality_flag] = ?\n"
            + " WHERE reading_id = ?"; 
    private static final String Delete_Reading = "DELETE FROM [dbo].[Reading]\n"
            + "      WHERE reading_id = ? ";        
    private static  final String Select_Reading = "select *from Reading" ;     
    @Override
    public int insert(Reading t) {
        try{
                PreparedStatement pp = c.prepareStatement(Insert_Reading);
                pp.setInt(1,t.getSensor().getSensorId());
                pp.setInt(2,t.getPollutant().getPollutantId());
                pp.setObject(3,LocalDateTime.now());
                pp.setDouble(4,t.getValue());
                pp.setShort(5,t.getQualityFlag());
                return pp.executeUpdate();
            
        }catch(SQLException e){
            System.out.println(e);
    }
        return 0;
    }

    @Override
    public int update(Reading t) {
        try {
                PreparedStatement pp = c.prepareStatement(Update_Reading);
                pp.setInt(1, t.getSensor().getSensorId());
                pp.setInt(2, t.getPollutant().getPollutantId());
                pp.setObject(3, t.getTs());
                pp.setDouble(4, t.getValue());
                pp.setShort(5, t.getQualityFlag());
                pp.setInt(6, t.getReadingId());
                return pp.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public int delete(int i) {
        try {
            String sql = "DELETE FROM [dbo].[Reading]\n"
                    + "      WHERE reading_id = ? ";
            PreparedStatement pp = c.prepareStatement(sql);
            pp.setInt(1,i);
            return pp.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
         return 0;
    }

    @Override
    public List<Reading> getAll() {
        List<Reading> list = new ArrayList<>();
        try{
            PreparedStatement pp = c.prepareStatement(Select_Reading);
            ResultSet rs = pp.executeQuery();
            while(rs.next()){
                Reading r = new Reading();
                r.setReadingId(rs.getInt("reading_id"));
                Sensor s = new Sensor();
                s.setSensorId(rs.getInt("sensor_id"));
                r.setSensor(s);
                Pollutant p = new Pollutant();
                p.setPollutantId(rs.getInt("pollutant_id"));
                r.setPollutant(p);
                r.setTs(rs.getObject("ts",java.time.LocalDateTime.class));
                r.setValue(rs.getDouble("value"));
                r.setCreatedAt(rs.getObject("created_at",java.time.LocalDateTime.class));
                list.add(r);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return list;
    }

    @Override
    public List<Reading> selectByCondition(String string) {
        List<Reading> list = new ArrayList<>();
        return list;
    }
    
    
    
}
