package fr.eni.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.Categorie;

public class CategorieDAOJdbcImpl implements CategorieDAO {

    private static final String SELECT_ALL = "SELECT * FROM CATEGORIES";
    private static final String SELECT_BY_ID = "SELECT * FROM CATEGORIES WHERE no_categorie=?";
    private static final String INSERT_USER = "insert into CATEGORIES(libelle) values(?);";
    private static final String DELETE_USER = "delete from CATEGORIES where no_categorie=?";
    private static final String UPDATE_USER = "update CATEGORIES set libelle=? where no_categorie=?";
     
    @Override
    public Categorie insert(Categorie categorie) throws BusinessException {
        if (categorie == null) {
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }

        try (Connection cnx = ConnectionProvider.getConnection()) {
            try {
                cnx.setAutoCommit(false);
                PreparedStatement pstmt;
                ResultSet rs;
                if (categorie.getNo_categorie() == 0) {
                    pstmt = cnx.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
                    pstmt.setString(1, categorie.getLibelle());
                    pstmt.executeUpdate();
                    rs = pstmt.getGeneratedKeys();
                    if (rs.next()) {
                    	categorie.setNo_categorie(rs.getInt(1));
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
        
        return categorie;

    }

    @Override
    public void deleteCategorie(int id) throws BusinessException {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(DELETE_USER);
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
    public List<Categorie> selectAll() throws BusinessException {
        List<Categorie> listesArticle = new ArrayList<>();
        try (Connection cnx = ConnectionProvider.getConnection(); PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	Categorie categorie = new Categorie();
            	categorie.setNo_categorie(rs.getInt("no_categorie"));
            	categorie.setLibelle(rs.getString("libelle"));
            	listesArticle.add(categorie);
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
    public Categorie selectById(int id) throws BusinessException {
    	Categorie categorie = new Categorie();
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            boolean premiereLigne = true;
            while (rs.next()) {
                if (premiereLigne) {
                	categorie.setNo_categorie(rs.getInt("no_categorie"));
                	categorie.setLibelle(rs.getString("libelle"));
                    premiereLigne = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.SELECT_USER_ECHEC);
            throw businessException;
        }

        return categorie;
    }

	@Override
	public void updateCategorie(Categorie categorie) throws BusinessException {
		if (categorie == null) {
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }

        try (Connection cnx = ConnectionProvider.getConnection()) {
            try {
                cnx.setAutoCommit(false);
                PreparedStatement pstmt;
                if (categorie.getNo_categorie() != 0) {
                    pstmt = cnx.prepareStatement(UPDATE_USER);
                    pstmt.setString(1, categorie.getLibelle());
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

}
