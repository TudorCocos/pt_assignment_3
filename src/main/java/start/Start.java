package main.java.start;
import java.sql.SQLException;
import java.util.logging.Logger;
import main.java.presentation.Controller;
public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());
	public static void main(String[] args) throws SQLException {
		@SuppressWarnings("unused")
		Controller ctrl = new Controller();
		ctrl.main(args);
	}
}
