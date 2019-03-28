package main.java.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.java.connection.ConnectionFactory;
import main.java.model.Client;
public class ClientDAO extends AbstractDAO<Client> {
	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO client (id,name,address,email,mobile,age)"+" VALUES (?,?,?,?,?,?)";
	private static final String deleteStatementString = "DELETE FROM client WHERE id=?";
	private static final String updateStatementString = "UPDATE client SET name=?,address=?,email=?,mobile=?,age=? WHERE id=?";
	public ClientDAO() {
		super();
	}
	public void insert(Client c) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(insertStatementString);
			statement.setInt(1, c.getId());
			statement.setString(2, c.getName());
			statement.setString(3, c.getAddress());
			statement.setString(4, c.getEmail());
			statement.setString(5, c.getMobile());
			statement.setInt(6, c.getAge());
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	public void delete(Client c) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(deleteStatementString);
			statement.setInt(1, c.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	public void update(Client c) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(updateStatementString);
			statement.setString(1, c.getName());
			statement.setString(2, c.getAddress());
			statement.setString(3, c.getEmail());
			statement.setString(4, c.getMobile());
			statement.setInt(5, c.getAge());
			statement.setInt(6, c.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
}
