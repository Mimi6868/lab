
package dao;

import dto.Pollutant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PollutantDAO extends DBContext implements DAOInterface<Pollutant>{
    private static final String Insert_Pollutant = "INSERT INTO [dbo].[Pollutant]\n"
                    + "           ([name]\n"
                    + "           ,[unit])\n"
                    + "     VALUES\n"
                    + "           (?,?)";
    private static final String Update_Pollutant = "UPDATE [dbo].[Pollutant]\n"
            + "   SET [name] = ?\n"
            + "      ,[unit] = ?\n"
            + " WHERE pollutant_id = ?";
    private static final String Delete_Pollutant = "DELETE FROM [dbo].[Pollutant]\n"
            + "      WHERE pollutant_id = ? ";
    private static final String Select_Pollutant = "select *from Pollutant";
    @Override
    public int insert(Pollutant t) {
        try{
        PreparedStatement pp = c.prepareStatement(Insert_Pollutant);
        pp.setString(1,t.getName());
        pp.setString(2,t.getUnit());
        
        return pp.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public int update(Pollutant t) {
        try{
            PreparedStatement pp = c.prepareStatement(Update_Pollutant);
            pp.setString(1,t.getName());
            pp.setString(2,t.getUnit());
            pp.setInt(3,t.getPollutantId());
            return pp.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try {
            PreparedStatement pp = c.prepareStatement(Delete_Pollutant);
            pp.setInt(1,id);
            return pp.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public List<Pollutant> getAll() {
        List<Pollutant> list = new ArrayList<>();
        try{
            PreparedStatement pp = c.prepareStatement(Select_Pollutant);
            ResultSet rs = pp.executeQuery();
            while(rs.next()){
                Pollutant p = new Pollutant(rs.getString("name"),rs.getString("unit"));
                list.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list ;
    }

    @Override
    public List<Pollutant> selectByCondition(String string) {
        List<Pollutant> list = new ArrayList<>();
        return list ;
    }

    
}
