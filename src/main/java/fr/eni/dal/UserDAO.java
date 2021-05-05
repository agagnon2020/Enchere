package fr.eni.dal;

import java.util.List;

import fr.eni.bo.Utilisateur;

public interface UserDAO {
	public void insert(Utilisateur user) throws BusinessException;
	public List<Utilisateur> selectAll() throws BusinessException;
	public Utilisateur selectById(int id) throws BusinessException;
	public void deleteUser(int idUser) throws BusinessException;
	public Utilisateur selectByAuth(String pseudo, String mdp) throws BusinessException;
	public Utilisateur selectByMail(String email, String mdp) throws BusinessException;
	public void updateUser(Utilisateur user) throws BusinessException;
}
