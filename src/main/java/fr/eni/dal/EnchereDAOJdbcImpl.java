package fr.eni.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bll.ArticleManager;
import fr.eni.bll.UserManager;
import fr.eni.bo.Enchere;

public class EnchereDAOJdbcImpl implements EnchereDAO {

    private static final String SELECT_ALL = "SELECT * FROM ENCHERES";
    private static final String SELECT_BY_ID = "SELECT * FROM ENCHERES WHERE no_enchere=?";
    private static final String INSERT_ENCHERE = "insert into ENCHERES(date_enchere, montant_enchere, no_article, no_utilisateur) values(?,?,?,?);";
    private static final String DELETE_ENCHERE = "delete from ENCHERES where no_enchere=?";
    private static final String UPDATE_ENCHERE = "update ENCHERES set date_enchere=?, montant_enchere=?, no_article=?, no_utilisateur=? where no_enchere=?";
    private static final String SELECT_BEST = "SELECT TOP(1) * FROM ENCHERES WHERE no_article=? ORDER BY montant_enchere DESC;";
    
    @Override
    public Enchere insert(Enchere enchere) throws BusinessException {
        if (enchere == null) {
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }

        try (Connection cnx = ConnectionProvider.getConnection()) {
            try {
                cnx.setAutoCommit(false);
                PreparedStatement pstmt;
                ResultSet rs;
                if (enchere.getNoEnchere() == 0) {
                    pstmt = cnx.prepareStatement(INSERT_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
                    pstmt.setDate(1, new Date(enchere.getDateEnchere().getTime()));
                    pstmt.setInt(2, enchere.getMontantEnchere());
                    pstmt.setInt(3, enchere.getArticle().getNoArticle());
                    pstmt.setInt(4, enchere.getUtilisateur().getNo_utilisateur());
                    pstmt.executeUpdate();
                    rs = pstmt.getGeneratedKeys();
                    if (rs.next()) {
                    	enchere.setNoEnchere(rs.getInt(1));
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
        
        return enchere;

    }

    @Override
    public void deleteEnchere(int id) throws BusinessException {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(DELETE_ENCHERE);
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
    public List<Enchere> selectAll() throws BusinessException {
        List<Enchere> listesEnchere = new ArrayList<>();
        try (Connection cnx = ConnectionProvider.getConnection(); PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	Enchere enchere = new Enchere();
            	enchere.setNoEnchere(rs.getInt("no_enchere"));
            	enchere.setDateEnchere(rs.getDate("date_enchere"));
            	enchere.setMontantEnchere(rs.getInt("montant_enchere"));
            	ArticleManager artM = new ArticleManager();
            	UserManager userM = new UserManager();
            	enchere.setArticle(artM.informationArticle(rs.getInt("no_article")));
            	enchere.setUtilisateur(userM.infosProfil(rs.getInt("no_utilisateur")));
            	listesEnchere.add(enchere);
            }
        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.SELECT_USER_ECHEC);
            throw businessException;
        }
        return listesEnchere;
    }

    @Override
    public Enchere selectById(int id) throws BusinessException {
    	Enchere enchere = new Enchere();
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            boolean premiereLigne = true;
            while (rs.next()) {
                if (premiereLigne) {
                	enchere.setNoEnchere(rs.getInt("no_enchere"));
                	enchere.setDateEnchere(rs.getDate("date_enchere"));
                	enchere.setMontantEnchere(rs.getInt("montant_enchere"));
                	ArticleManager artM = new ArticleManager();
                	UserManager userM = new UserManager();
                	enchere.setArticle(artM.informationArticle(rs.getInt("no_article")));
                	enchere.setUtilisateur(userM.infosProfil(rs.getInt("no_utilisateur")));
                    premiereLigne = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.SELECT_USER_ECHEC);
            throw businessException;
        }

        return enchere;
    }

	@Override
	public void updateEnchere(Enchere enchere) throws BusinessException {
		if (enchere == null) {
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }

        try (Connection cnx = ConnectionProvider.getConnection()) {
            try {
                cnx.setAutoCommit(false);
                if (enchere.getNoEnchere() != 0) {
                	PreparedStatement pstmt = cnx.prepareStatement(UPDATE_ENCHERE);
                    pstmt.setDate(1, new Date(enchere.getDateEnchere().getTime()));
                    pstmt.setInt(2, enchere.getMontantEnchere());
                    pstmt.setInt(3, enchere.getArticle().getNoArticle());
                    pstmt.setInt(4, enchere.getUtilisateur().getNo_utilisateur());
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
	public Enchere selectBest(int idArticle) throws BusinessException {
		Enchere enchere = new Enchere();
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BEST);
            pstmt.setInt(1, idArticle);
            ResultSet rs = pstmt.executeQuery();
            boolean premiereLigne = true;
            while (rs.next()) {
                if (premiereLigne) {
                	enchere.setNoEnchere(rs.getInt("no_enchere"));
                	enchere.setDateEnchere(rs.getDate("date_enchere"));
                	enchere.setMontantEnchere(rs.getInt("montant_enchere"));
                	ArticleManager artM = new ArticleManager();
                	UserManager userM = new UserManager();
                	enchere.setArticle(artM.informationArticle(rs.getInt("no_article")));
                	enchere.setUtilisateur(userM.infosProfil(rs.getInt("no_utilisateur")));
                    premiereLigne = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.SELECT_USER_ECHEC);
            throw businessException;
        }

        return enchere;
	}

}
