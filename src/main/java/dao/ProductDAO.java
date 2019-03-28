package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.java.connection.ConnectionFactory;
import main.java.model.Product;

public class ProductDAO extends AbstractDAO<Product> {

	protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO product (id,name,quantity,price)"+" VALUES (?,?,?,?)";
	private static final String deleteStatementString = "DELETE FROM product WHERE id=?";
	private static final String updateStatementString = "UPDATE product SET name=?,quantity=?,price=? WHERE id=?";
	public ProductDAO() {
		super();
	}
	public void insert(Product p) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(insertStatementString);
			statement.setInt(1, p.getId());
			statement.setString(2, p.getName());
			statement.setInt(3,p.getQuantity());
			statement.setInt(4,p.getPrice());
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	public void delete(Product p) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(deleteStatementString);
			statement.setInt(1, p.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	public void update(Product p) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(updateStatementString);
			statement.setString(1,p.getName());
			statement.setInt(2,p.getQuantity());
			statement.setInt(3,p.getPrice());
			statement.setInt(4, p.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
}
