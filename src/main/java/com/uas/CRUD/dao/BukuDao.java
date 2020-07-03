package com.uas.CRUD.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uas.CRUD.model.Buku;
import com.uas.CRUD.service.BukuService;

@Service
public class BukuDao implements BukuService {
	
	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}


	@Override
	public List<Buku> listBuku() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Buku",Buku.class).getResultList();
	}


	@Override
	public Buku saveOrUpdate(Buku buku) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Buku saved = em.merge(buku);
		em.getTransaction().commit();
		em.close();
		return saved;
	}


	@Override
	public Buku getIdBuku(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		return em.find(Buku.class, id);
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Buku.class, id));
		em.getTransaction().commit(); 
		em.close();
	}
	

}
