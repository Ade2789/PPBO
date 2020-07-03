package com.uas.CRUD.service;

import java.util.List;
import com.uas.CRUD.model.Buku;

public interface BukuService {
	List <Buku> listBuku();
	
	Buku saveOrUpdate(Buku buku);
	
	Buku getIdBuku(int id);
	
	void delete(int id);

}
