package cg.park.algorithmpcg.mytest.ugkim;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class StudioRentDAO {
    private Connection conn;

    public StudioRentDAO() {
        String url ="jdbc:mysql://localhost:3306/project";
        String user ="project" ;
        String password ="!123456";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("[Error] :" + e.getMessage());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("[Error] :" + e.getMessage());
        }
    }
    public ArrayList<StudioRentDAO> studiorentdao(String account) {
        PreparedStatement pstmt =null;
        ResultSet rs=null;

        ArrayList<StudioRentDAO> lists = new ArrayList<>();

        String sql = "select id, password from account where id = ? and password = ? ";

        try {
            pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, account + "%");

            rs = pstmt.executeQuery();
            while(rs.next()) {
                String id = rs.getString("id");
                String password = rs.getString("password");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            if(rs != null) try {rs.close();} catch (SQLException e) {}
            if(pstmt != null) try {pstmt.close();} catch (SQLException e) {}
            if(conn != null) try {conn.close();} catch (SQLException e) {}
        }
        return lists;
    }
    public ArrayList<GuestTO> StudioDAO2(String account ){
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<GuestTO> lists = new ArrayList<GuestTO>();

        try {
            String sql = "select id, password from account where id = ? and password = ? ";
            pstmt = this.conn.prepareStatement( sql );
            pstmt.setString( 1, account + "%" );

            rs = pstmt.executeQuery();
            while( rs.next() ) {
                GuestTO dao = new GuestTO();
                dao.setId(rs.getString("id"));
                dao.setPassword(rs.getString("password"));
                lists.add(dao);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println( "[에러]" + e.getMessage() );
        } finally {
            if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
            if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
            if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
        }

        return lists;
    }
}