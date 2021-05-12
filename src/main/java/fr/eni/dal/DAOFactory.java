package fr.eni.dal;

public abstract class DAOFactory {
	
	public static UserDAO getUserDAO()
	{
		return new UserDAOJdbcImpl();
	}
	
	public static ArticleDAO getArticleDAO()
	{
		return new ArticleDAOJdbcImpl();
	}
	
	public static CategorieDAO getCategorieDAO()
	{
		return new CategorieDAOJdbcImpl();
	}
	
	public static EnchereDAO getEnchereDAO()
	{
		return new EnchereDAOJdbcImpl();
	}

}
	