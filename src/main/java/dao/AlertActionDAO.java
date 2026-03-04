
package dao;

import dto.Alert;
import dto.AlertAction;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlertActionDAO extends DBContext implements DAOInterface<AlertAction>{
    private static final String Insert_AlertAction = "INSERT INTO [dbo].[AlertAction]\n"
            + "           ([alert_id]\n"
            + "           ,[actor_user_id]\n"
            + "           ,[action_type]\n"
            + "           ,[note])\n"
            + "     VALUES\n"
            + "           (?,?,?,?)";
    private static final String Update_AlertAction = "UPDATE [dbo].[AlertAction]\n"
            + "   SET [alert_id] = ?\n"
            + "      ,[actor_user_id] = ?\n"
            + "      ,[action_type] = ?\n"
            + "      ,[note] = ?\n"
            + " WHERE action_id = ?";
    
    private static final String Delete_AlertAction = "DELETE FROM [dbo].[AlertAction]\n"
            + "      WHERE action_id = ?";
    private static final String Select_AlertAction = "select *from AlertAction"; 
    @Override
    public int insert(AlertAction t) {
        try {
            PreparedStatement pp = c.prepareStatement(Insert_AlertAction);
            pp.setInt(1,t.getAlert().getAlertId());
            pp.setInt(2, t.getActorUserId());
            pp.setShort(3,t.getActionType());
            pp.setString(4,t.getNote());
            return pp.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public int update(AlertAction t) {
        try {
            PreparedStatement pp = c.prepareStatement(Update_AlertAction);
            pp.setInt(1,t.getAlert().getAlertId());
            pp.setInt(2, t.getActorUserId());
            pp.setShort(3,t.getActionType());
            pp.setString(4,t.getNote());
            pp.setInt(5,t.getActionId());
            return pp.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public int delete(int t) {
        try{
            PreparedStatement pp = c.prepareStatement(Delete_AlertAction);
            pp.setInt(1, t);
            return pp.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public List<AlertAction> getAll() {
        
        List<AlertAction> list = new ArrayList<>();
        try{
            PreparedStatement pp = c.prepareStatement(Select_AlertAction);
            ResultSet rs = pp.executeQuery();
            while(rs.next()){
                AlertAction aa = new AlertAction();
                aa.setActionId(rs.getInt("action_id"));
                Alert a = new Alert();
                a.setAlertId(rs.getInt("alert_id"));
                aa.setAlert(a);
                aa.setActorUserId(rs.getInt("actor_user_id"));
                aa.setActionType(rs.getShort("action_type"));
                aa.setNote(rs.getString("note"));
                aa.setActionTs(rs.getObject("action_ts", java.time.LocalDateTime.class));
                list.add(aa);
                
            }
        }catch(SQLException e){
            System.out.println(e);
        }
            
        return list;
    }

    @Override
    public List<AlertAction> selectByCondition(String condition) {
        List<AlertAction> list = new ArrayList<>();
        return list;
    }
   
}
