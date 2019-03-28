package main.java.bll.validators;
import main.java.model.Client;
public class ClientAgeValidator implements Validator<Client> {
	private static final int MIN_AGE = 7;
	private static final int MAX_AGE = 30;
	public void validate(Client t) {
		if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
			throw new IllegalArgumentException("The Student Age limit is not respected!");
		}

	}
}
