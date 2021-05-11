 package fr.eni.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bll.CategorieManager;
import fr.eni.bll.UserManager;
import fr.eni.bo.ArticleVendu;

public class ArticleDAOJdbcImpl implements ArticleDAO {

    private static final String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS";
    private static final String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article=?";
    private static final String INSERT_ARTICLE = "insert into ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) values(?,?,?,?,?,?,?,?);";
    private static final String DELETE_ARTICLE = "delete from ARTICLES_VENDUS where no_article=?";
    private static final String UPDATE_ARTICLE = "update ARTICLES_VENDUS set nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, prix_vente=?, no_utilisateur=?, no_categorie=? where no_article=?";
    private static final String SEARCH_NAME = "SELECT * FROM ARTICLES_VENDUS WHERE nom_article LIKE '%?%'";
    private static final String SEARCH_CATEGORY = "SELECT * FROM ARTICLES_VENDUS WHERE no_categorie=?";
    
    @Override
    public ArticleVendu insert(ArticleVendu article) throws BusinessException {
        if (article == null) {
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }

        try (Connection cnx = ConnectionProvider.getConnection()) {
            try {
                cnx.setAutoCommit(false);
                PreparedStatement pstmt;
                ResultSet rs;
                if (article.getNoArticle() == 0) {
                    pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
                    pstmt.setString(1, article.getNomArticle());
                    pstmt.setString(2, article.getDescription());
                    pstmt.setDate(3, new Date(article.getDateDebutEncheres().getTime()));
                    pstmt.setDate(4, new Date(article.getDateFinEncheres().getTime()));
                    pstmt.setInt(5, article.getMiseAPrix());
                    pstmt.setInt(6, article.getPrixVente());
                    pstmt.setInt(7, article.getVendeur().getNo_utilisateur());
                    pstmt.setInt(8, article.getCategorie().getNo_categorie());
                    pstmt.executeUpdate();
                    rs = pstmt.getGeneratedKeys();
                    if (rs.next()) {
                    	article.setNoArticle(rs.getInt(1));
                    }
                    rs.close();
                    pstmt.close();
                }
                cnx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                cnx.rollback();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
            throw businessException;
        }
        
        return article;

    }

    @Override
    public void deleteArticle(int id) throws BusinessException {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(DELETE_ARTICLE);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.DELETE_USER_ECHEC);
            throw businessException;
        }

    }

    @Override
    public List<ArticleVendu> selectAll() throws BusinessException {
        List<ArticleVendu> listesArticle = new ArrayList<>();
        try (Connection cnx = ConnectionProvider.getConnection(); PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	ArticleVendu article = new ArticleVendu();
            	article.setNoArticle(rs.getInt("no_article"));
            	article.setNomArticle(rs.getString("nom_article"));
            	article.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
            	article.setDateFinEncheres(rs.getDate("date_fin_encheres"));
            	article.setPrixVente(rs.getInt("prix_vente"));
            	article.setMiseAPrix(rs.getInt("prix_initial"));
            	UserManager userM = new UserManager();
            	article.setVendeur(userM.infosProfil(rs.getInt("no_utilisateur")));
            	CategorieManager cateM = new CategorieManager();
            	article.setCategorie(cateM.informationCategorie(rs.getInt("no_categorie")));
            	listesArticle.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.SELECT_USER_ECHEC);
            throw businessException;
        }
        return listesArticle;
    }

    @Override
    public ArticleVendu selectById(int id) throws BusinessException {
    	ArticleVendu article = new ArticleVendu();
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            boolean premiereLigne = true;
            while (rs.next()) {
                if (premiereLigne) {
                	article.setNoArticle(rs.getInt("no_article"));
                	article.setNomArticle(rs.getString("nom_article"));
                	article.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
                	article.setDateFinEncheres(rs.getDate("date_fin_encheres"));
                	article.setPrixVente(rs.getInt("prix_vente"));
                	article.setMiseAPrix(rs.getInt("prix_initial"));
                	UserManager userM = new UserManager();
                	article.setVendeur(userM.infosProfil(rs.getInt("no_utilisateur")));
                	//article.setNoArticle(rs.getInt("no_article"));
                    premiereLigne = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.SELECT_USER_ECHEC);
            throw businessException;
        }

        return article;
    }

	@Override
	public void updateArticle(ArticleVendu article) throws BusinessException {
		if (article == null) {
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }

        try (Connection cnx = ConnectionProvider.getConnection()) {
            try {
                cnx.setAutoCommit(false);
                if (article.getNoArticle() != 0) {
                	PreparedStatement pstmt = cnx.prepareStatement(UPDATE_ARTICLE);
                    pstmt.setString(1, article.getNomArticle());
                    pstmt.setString(2, article.getDescription());
                    pstmt.setDate(3, new Date(article.getDateDebutEncheres().getTime()));
                    pstmt.setDate(4, new Date(article.getDateFinEncheres().getTime()));
                    pstmt.setInt(5, article.getMiseAPrix());
                    pstmt.setInt(6, article.getPrixVente());
                    pstmt.setInt(7, article.getVendeur().getNo_utilisateur());
                    pstmt.setInt(8, article.getCategorie().getNo_categorie());
                    pstmt.setInt(9, article.getNoArticle());
                    pstmt.executeUpdate();
                    pstmt.close();
                }
                cnx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                cnx.rollback();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
            throw businessException;
        }
	}

	@Override
	public List<ArticleVendu> searchName(String nomArticle) throws BusinessException {
		List<ArticleVendu> listesArticle = new ArrayList<>();
        try (Connection cnx = ConnectionProvider.getConnection(); PreparedStatement pstmt = cnx.prepareStatement(SEARCH_NAME)) {
            pstmt.setString(1, nomArticle);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	ArticleVendu article = new ArticleVendu();
            	article.setNoArticle(rs.getInt("no_article"));
            	article.setNomArticle(rs.getString("nom_article"));
            	article.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
            	article.setDateFinEncheres(rs.getDate("date_fin_encheres"));
            	article.setPrixVente(rs.getInt("prix_vente"));
            	article.setMiseAPrix(rs.getInt("prix_initial"));
            	UserManager userM = new UserManager();
            	article.setVendeur(userM.infosProfil(rs.getInt("no_utilisateur")));
            	CategorieManager cateM = new CategorieManager();
            	article.setCategorie(cateM.informationCategorie(rs.getInt("no_categorie")));
            	listesArticle.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.SELECT_USER_ECHEC);
            throw businessException;
        }
        return listesArticle;
	}

	@Override
	public List<ArticleVendu> searchCategory(String nomCategorie) throws BusinessException {
		List<ArticleVendu> listesArticle = new ArrayList<>();
        try (Connection cnx = ConnectionProvider.getConnection(); PreparedStatement pstmt = cnx.prepareStatement(SEARCH_CATEGORY)) {
            int idCategorie = 0;
            CategorieManager catM = new CategorieManager();
            idCategorie = catM.recupererCategorie(nomCategorie);
        	pstmt.setInt(1, idCategorie);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	ArticleVendu article = new ArticleVendu();
            	article.setNoArticle(rs.getInt("no_article"));
            	article.setNomArticle(rs.getString("nom_article"));
            	article.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
            	article.setDateFinEncheres(rs.getDate("date_fin_encheres"));
            	article.setPrixVente(rs.getInt("prix_vente"));
            	article.setMiseAPrix(rs.getInt("prix_initial"));
            	UserManager userM = new UserManager();
            	article.setVendeur(userM.infosProfil(rs.getInt("no_utilisateur")));
            	CategorieManager cateM = new CategorieManager();
            	article.setCategorie(cateM.informationCategorie(rs.getInt("no_categorie")));
            	listesArticle.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.SELECT_USER_ECHEC);
            throw businessException;
        }
        return listesArticle;
	}

}
