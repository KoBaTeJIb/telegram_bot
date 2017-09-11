package ru.kobatejib.telegram.bot.bittrex.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import ru.kobatejib.telegram.bot.bittrex.entyte.Order;

/**
 * Вспомогательный классс для работы с БД
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class DataBaseUtility {
	
	private final static  String  ORDER_ID= "Id";
	private final static  String  ORDER_TYPE_FIELD= "OrderType";
	private final static  String  ORDER_UUID_FIELD= "OrderUuid";
	private final static  String  EXCHANGE_FIELD= "Exchange";
	private final static  String  QUANTITY_FIELD= "Quantity";
	private final static  String  PRICE_FIELD= "Price";
	private final static  String  OPENED_FIELD= "Opened";
	private final static  String  CLOSED_FIELD= "Closed";

	
	/**
	 * Преобразовать набора данных в список ордеров
	 * 
	 * @param resultSet
	 *            набор  данных
	 * @return список ордеров
	 */
	public static List<Order> convertResultSet2ListOrders(
			ResultSet resultSet) {
		List<Order> orders = new ArrayList<Order>();
		try {
			while (resultSet.next()) {
				Order order = new Order();
				orders.add(order);
				int id = resultSet.getInt("id");
				order.setId(id);

				String orderType = resultSet.getString("order_type");
				order.setOrderType(orderType);

				String orderUuid = resultSet.getString("order_uuid");
				order.setOrderUuid(orderUuid);

				String exchange = resultSet.getString("exchange");
				order.setExchange(exchange);

				String price = resultSet.getString("price");
				order.setPrice(price);

				String opened = resultSet.getString("opened");
				order.setOpened(opened);

				String closed = resultSet.getString("closed");
				order.setClosed(closed);

				String quantity = resultSet.getString("quantity");
				order.setQuantity(quantity);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return orders;
	}

	/**
	 * Преобразовать признак в строку
	 * 
	 * @param isBoolean
	 *            признак
	 * @return строка
	 */
	public static String convertBoolean2String(Boolean isBoolean) {
		String value;
		if (isBoolean == null) {
			value = "null";
		} else {
			value = isBoolean.toString();
		}
		return value;
	}

	/**
	 * Преобразовать карту в ордер
	 * 
	 * @param orderMap
	 *            карта ордера
	 * @return ордер
	 */
	public static Order map2Order(Map<String, String> orderMap) {
		Order order = new Order();
		String id = orderMap.get(ORDER_ID);
		if(StringUtils.isNotBlank(id)) {
			order.setId(Integer.parseInt(id));
		}

		String orderType = orderMap.get(ORDER_TYPE_FIELD);
		order.setOrderType(orderType);

		String orderUuid = orderMap.get(ORDER_UUID_FIELD);
		order.setOrderUuid(orderUuid);

		String exchange = orderMap.get(EXCHANGE_FIELD);
		order.setExchange(exchange);

		String price = orderMap.get(PRICE_FIELD);
		order.setPrice(price);

		String opened = orderMap.get(OPENED_FIELD);
		order.setOpened(opened);

		String closed = orderMap.get(CLOSED_FIELD);
		order.setClosed(closed);

		String quantity = orderMap.get(QUANTITY_FIELD);
		order.setQuantity(quantity);
		return order;
	}
}
