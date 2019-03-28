package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.java.connection.ConnectionFactory;
import main.java.model.Orders;

public class OrdersDAO extends AbstractDAO<Orders> {

	
	protected static final Logger LOGGER = Logger.getLogger(OrdersDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO orders (id,customerId,productId,productQuantity,value)"+" VALUES (?,?,?,?,?)";
	private static final String deleteStatementString = "DELETE FROM orders WHERE id=?";
	private static final String updateStatementString = "UPDATE orders SET customerId=?,productId=?,productQuantity=?,value=? WHERE id=?";
	public OrdersDAO() {
		super();
	}
	public void insert(Orders o) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(insertStatementString);
			statement.setInt(1, o.getId());
			statement.setInt(2,o.getCustomerId());
			statement.setInt(3,o.getProductId());
			statement.setInt(4,o.getProductQuantity());
			statement.setInt(5,o.getValue());
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "OrdersDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	public void delete(Orders o) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(deleteStatementString);
			statement.setInt(1, o.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "OrdersDAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	public void update(Orders o) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(updateStatementString);
			statement.setInt(1,o.getCustomerId());
			statement.setInt(2,o.getProductId());
			statement.setInt(3,o.getProductQuantity());
			statement.setInt(4,o.getValue());
			statement.setInt(5, o.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "OrdersDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
}
