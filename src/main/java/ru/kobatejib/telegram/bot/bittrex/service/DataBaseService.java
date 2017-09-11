package ru.kobatejib.telegram.bot.bittrex.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ru.kobatejib.telegram.bot.bittrex.entyte.Order;
import ru.kobatejib.telegram.bot.bittrex.utility.DataBaseUtility;

/**
 * Created by Kovatelj on 17.07.2017.
 */
public class DataBaseService {

	public Connection connection= null;

	public void connect() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:bittrex.db");
			System.out.println("Connection OK");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void createDb() throws ClassNotFoundException, SQLException {
			if (connection != null) {
				Statement statement = null;
				try {
					statement = connection.createStatement();
					statement.execute("CREATE TABLE if not exists 'bittrex' "
							+ "('id' INTEGER PRIMARY KEY AUTOINCREMENT, "
							+ "'order_type' text, " + "'order_uuid' text, "
							+ "'exchange' text, " + "'quantity' text, "
							+ "'price' text, " + "'opened' text, "
							+ "'closed' text);");
					System.out.println("Create table OK");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					if (statement != null) {
						statement.close();
					}
				}
			} else {
				System.out.println("Error createDb is null");
			}

		
	}

	public void writeDb(Order order)
			throws ClassNotFoundException, SQLException {
		if (connection != null) {
				Statement statement = null;
				try {
					statement = connection.createStatement();
                    statement.execute("INSERT INTO bittrex (" +
                            "order_type, " +
                            "order_uuid, " +
                            "exchange, " +
                            "quantity, " +
                            "price, " +
                            "opened, " +
                            "closed) "
							+ "VALUES " + "('" + order.getOrderType() + "', '"
							+ order.getOrderUuid() + "', '"
                            + order.getExchange() + "', '"
                            + order.getQuantity() + "', '"
                            + order.getPrice() + "', '"
                            + order.getOpened() + "', '"
                            + order.getClosed() + "');");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					if (statement != null) {
						statement.close();
					}
				}
		} else {
			System.out.println("Error writeDb is null");
		}

	}

	public List<Order> findAllByClosed(Boolean closed)
			throws ClassNotFoundException, SQLException {
		List<Order> orders = new ArrayList<Order>();
		String closedParam = DataBaseUtility.convertBoolean2String(closed);
		Statement statement = null;
		if (connection != null) {
			try {
				statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"SELECT * FROM 'bittrex' WHERE closed=" + closedParam);
				orders = DataBaseUtility.convertResultSet2ListOrders(resultSet);
				System.out.println(resultSet);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				if (statement != null) {
					statement.close();
				}
			}
		} else {
			System.out.println("Error findAllByClosed is null");
		}

		return orders;
	}
}
