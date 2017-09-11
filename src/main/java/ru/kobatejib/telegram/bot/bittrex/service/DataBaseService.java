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

	public Connection connection;
	public Statement statement;

	public void connect() throws ClassNotFoundException, SQLException {
		try {
			connection = null;
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:bittrex.db");
			System.out.println("Connection OK");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void createDb() throws ClassNotFoundException, SQLException {

		try {
			if(connection != null){
				statement = connection.createStatement();
				statement.execute("CREATE TABLE if not exists 'bittrex' "
						+ "('id' INTEGER PRIMARY KEY AUTOINCREMENT, "
						+ "'order_type' text, " + "'order_uuid' text, "
						+ "'exchange' text, " + "'quantity' text, "
						+ "'price' text, " + "'opened' text, " + "'closed' text);");
				System.out.println("Create table OK");
			} else {
				System.out.println("Error connection is null");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void writeDb(Order order)
			throws ClassNotFoundException, SQLException {
		try {
			statement.execute("INSERT INTO 'bittrex' "
					+ "('order_type', 'order_uuid', 'exchange', 'quantity', 'price', 'opened', 'closed') "
					+ "VALUES " + "(" + order.getOrderType() + ","
					+ order.getOrderUuid() + "," + order.getExchange() + ","
					+ order.getQuantity() + "," + order.getPrice() + ","
					+ order.getOpened() + "," + order.getClass() + ","
					+ order.getPrice() + ");");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Order> findAllByClosed(Boolean closed)
			throws ClassNotFoundException, SQLException {
		List<Order> orders = new ArrayList<Order>();
		String closedParam = DataBaseUtility.convertBooean2String(closed);
		try {
			ResultSet resultSet = statement.executeQuery(
					"SELECT * FROM 'bittrex' WHERE closed=" + closedParam);
			orders = DataBaseUtility.convertResultSet2ListOrders(resultSet);
			System.out.println(resultSet);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return orders;
	}
}
