import java.sql.*;

/**
 * Created by Kovatelj on 17.07.2017.
 */
public class dataBase {

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public static String getOrderType() {
        return orderType;
    }

    public static String getOrderUuid() {
        return orderUuid;
    }

    public static String getExchange() {
        return exchange;
    }

    public static String getQuantity() {
        return quantity;
    }

    public static String getPrice() {
        return price;
    }

    public static String getOpened() {
        return opened;
    }

    public static String getClosed() {
        return closed;
    }

    private static String orderType;
    private static String orderUuid;
    private static String exchange;
    private static String quantity;
    private static String price;
    private static String opened;
    private static String closed;







    public static void connect() throws ClassNotFoundException, SQLException {
        try {
            connection = null;
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:bittrex.db");
            System.out.println("Connection OK");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void createDb() throws ClassNotFoundException, SQLException {

        try {
            statement = connection.createStatement();
            statement.execute("CREATE TABLE if not exists 'bittrex' " +
                    "('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "'order_type' text, " +
                    "'order_uuid' text, " +
                    "'exchange' text, " +
                    "'quantity' text, " +
                    "'price' text, " +
                    "'opened' text, " +
                    "'closed' text);");
            System.out.println("Create table OK");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeDb(String OrderType, String OrderUuid, String Exchange,
                               String Quantity, String Price, String Opened,
                               String Closed) throws ClassNotFoundException, SQLException {

        try {
            statement.execute("INSERT INTO 'bittrex' (" +
                    "'order_type', " +
                    "'order_uuid', " +
                    "'exchange', " +
                    "'quantity', " +
                    "'price', " +
                    "'opened', " +
                    "'closed') " +
                    "VALUES ('" + OrderType + "', " +
                    "'" + OrderUuid + "', " +
                    "'" + Exchange + "', " +
                    "'" + Quantity + "', " +
                    "'" + Price + "', " +
                    "'" + Opened + "', " +
                    "'" + Closed + "');");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readDb() throws ClassNotFoundException, SQLException {

        try {
            resultSet = statement.executeQuery("SELECT * FROM 'bittrex'");
            int id = resultSet.getInt("id");
            orderType = resultSet.getString("order_type");
            orderUuid = resultSet.getString("order_uuid");
            exchange = resultSet.getString("exchange");
            price = resultSet.getString("price");
            opened = resultSet.getString("opened");
            closed = resultSet.getString("closed");
            quantity = resultSet.getString("quantity");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
