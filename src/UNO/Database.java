package UNO;

import java.sql.SQLException;

public class Database {
    private static final String CREATETABLE = "CREATE TABLE Sessions (Player varchar(100) NOT NULL, Session int NOT NULL, Round int NOT NULL, Score int NOT NULL, CONSTRAINT PK_Sessions PRIMARY KEY (Player, Session, Round));";
    private static final String INSERT_TEMPLATE = "INSERT INTO Sessions (Player, Round, Session,  Score) VALUES ('%1s', %2d, %3d, %4d);";
    private static final String SELECT_BYPLAYERANDSESSION = "SELECT Player, SUM(Score) AS Score FROM Sessions WHERE Player = '%1s' AND Session = %2d;";

    public static void createDB() {


        try {
            SqliteClient client = new SqliteClient("dbase.sqlite");

            client.executeStatement(CREATETABLE);


        } catch (SQLException ex) {
            System.out.println("Ups! Something went wrong:" + ex.getMessage());
        }
    }

    public void insert_DB(String NAME, int ROUND, int SESSION, int PUNKTE) throws SQLException {

        SqliteClient client = new SqliteClient("dbase.sqlite");
        try {

            client.executeStatement(String.format(INSERT_TEMPLATE, NAME, ROUND, SESSION, PUNKTE));

        } catch (SQLException ex) {
            System.out.println("Ups! Something went wrong:" + ex.getMessage());
        }
    }



}





