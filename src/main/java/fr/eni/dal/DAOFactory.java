package fr.eni.dal;

public abstract class DAOFactory {
	
	public static UserDAO getUserDAO()
	{
		return new UserDAOJdbcImpl();
	}
}
	