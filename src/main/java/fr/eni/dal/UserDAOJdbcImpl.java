package fr.eni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.Utilisateur;

public class UserDAOJdbcImpl implements UserDAO {

    private static final String SELECT_ALL = "SELECT * FROM UTILISATEURS";
    private static final String SELECT_BY_ID = "SELECT UTILISATEURS WHERE no_utilisateur=?";
    private static final String INSERT_USER = "insert into UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) values(?,?,?,?,?,?,?,?,?,?,?);";
    private static final String DELETE_USER = "delete from UTILISATEURS where no_utilisateur=?";
    private static final String SELECT_BY_AUTH = "SELECT UTILISATEURS WHERE pseudo=? AND mot_de_passe=?";
    private static final String UPDATE_USER = "update UTILISATEURS set coche=?, pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, credit=?, administrateur=? where no_utilisateur=?";

    @Override
    public void insert(Utilisateur user) throws BusinessException {
        if (user == null) {
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }

        try (Connection cnx = ConnectionProvider.getConnection()) {
            try {
                cnx.setAutoCommit(false);
                PreparedStatement pstmt;
                ResultSet rs;
                if (user.getNo_utilisateur() == 0) {
                    pstmt = cnx.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
                    pstmt.setString(1, user.getPseudo());
                    pstmt.setString(2, user.getNom());
                    pstmt.setString(3, user.getPrenom());
                    pstmt.setString(4, user.getEmail());
                    pstmt.setInt(5, user.getTelephone());
                    pstmt.setString(6, user.getRue());
                    pstmt.setInt(7, user.getCode_postal());
                    pstmt.setString(8, user.getMot_de_passe());
                    pstmt.setInt(9, user.getCredit());
                    pstmt.setBoolean(10, user.getAdministrateur());
                    pstmt.executeUpdate();
                    rs = pstmt.getGeneratedKeys();
                    if (rs.next()) {
                    	user.setNo_utilisateur(rs.getInt(1));
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

    }

    @Override
    public void deleteUser(int id) throws BusinessException {
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
    public List<Utilisateur> selectAll() throws BusinessException {
        List<Utilisateur> listesUser = new ArrayList<>();
        try (Connection cnx = ConnectionProvider.getConnection(); PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	Utilisateur user = new Utilisateur();
            	user.setPseudo(rs.getString("pseudo"));
            	user.setPrenom(rs.getString("prenom"));
            	user.setNom(rs.getString("nom"));
            	user.setEmail(rs.getString("email"));
            	user.setTelephone(rs.getInt("telephone"));
            	user.setRue(rs.getString("rue"));
            	user.setCode_postal(rs.getInt("code_postal"));
            	user.setMot_de_passe(rs.getString("mot_de_passe"));
            	user.setCredit(rs.getInt("credit"));
            	user.setAdministrateur(rs.getBoolean("administrateur"));
            	user.setNo_utilisateur(rs.getInt("no_utilisateur"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.SELECT_USER_ECHEC);
            throw businessException;
        }
        return listesUser;
    }

    @Override
    public Utilisateur selectById(int id) throws BusinessException {
    	Utilisateur user = new Utilisateur();
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            boolean premiereLigne = true;
            while (rs.next()) {
                if (premiereLigne) {
                	user.setPseudo(rs.getString("pseudo"));
                	user.setPrenom(rs.getString("prenom"));
                	user.setNom(rs.getString("nom"));
                	user.setEmail(rs.getString("email"));
                	user.setTelephone(rs.getInt("telephone"));
                	user.setRue(rs.getString("rue"));
                	user.setCode_postal(rs.getInt("code_postal"));
                	user.setMot_de_passe(rs.getString("mot_de_passe"));
                	user.setCredit(rs.getInt("credit"));
                	user.setAdministrateur(rs.getBoolean("administrateur"));
                	user.setNo_utilisateur(rs.getInt("no_utilisateur"));
                    premiereLigne = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.SELECT_USER_ECHEC);
            throw businessException;
        }

        return user;
    }

	@Override
	public Utilisateur selectByAuth(String pseudo, String mdp) throws BusinessException {
		Utilisateur user = new Utilisateur();
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_AUTH);
            pstmt.setString(1, pseudo);
            pstmt.setString(2, mdp);
            ResultSet rs = pstmt.executeQuery();
            boolean premiereLigne = true;
            while (rs.next()) {
                if (premiereLigne) {
                	user.setPseudo(rs.getString("pseudo"));
                	user.setPrenom(rs.getString("prenom"));
                	user.setNom(rs.getString("nom"));
                	user.setEmail(rs.getString("email"));
                	user.setTelephone(rs.getInt("telephone"));
                	user.setRue(rs.getString("rue"));
                	user.setCode_postal(rs.getInt("code_postal"));
                	user.setMot_de_passe(rs.getString("mot_de_passe"));
                	user.setCredit(rs.getInt("credit"));
                	user.setAdministrateur(rs.getBoolean("administrateur"));
                	user.setNo_utilisateur(rs.getInt("no_utilisateur"));
                    premiereLigne = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.SELECT_USER_ECHEC);
            throw businessException;
        }

        return user;
	}

	@Override
	public void updateUser(Utilisateur user) throws BusinessException {
		if (user == null) {
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }

        try (Connection cnx = ConnectionProvider.getConnection()) {
            try {
                cnx.setAutoCommit(false);
                PreparedStatement pstmt;
                ResultSet rs;
                if (user.getNo_utilisateur() == 0) {
                    pstmt = cnx.prepareStatement(UPDATE_USER, PreparedStatement.RETURN_GENERATED_KEYS);
                    pstmt.setString(1, user.getPseudo());
                    pstmt.setString(2, user.getNom());
                    pstmt.setString(3, user.getPrenom());
                    pstmt.setString(4, user.getEmail());
                    pstmt.setInt(5, user.getTelephone());
                    pstmt.setString(6, user.getRue());
                    pstmt.setInt(7, user.getCode_postal());
                    pstmt.setString(8, user.getMot_de_passe());
                    pstmt.setInt(9, user.getCredit());
                    pstmt.setBoolean(10, user.getAdministrateur());
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