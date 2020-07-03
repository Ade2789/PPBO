package com.uas.CRUD.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uas.CRUD.model.Buku;
import com.uas.CRUD.service.BukuService;
@Controller
public class BukuController {
	private BukuService bukuService;
	
	@Autowired
	public void setBukuService(BukuService bukuService) {
		this.bukuService = bukuService;
	}


	@RequestMapping("/buku")
	public String MenuBuku(Model model) {
		model.addAttribute("buku", bukuService.listBuku());
		return "buku";
	}
	
	@RequestMapping(value = "/buku/addBooks", method = RequestMethod.GET)
	public String viewForm(Model model) {
		model.addAttribute("buku", new Buku());
		return "formBuku";
	}
	@RequestMapping(value = "/buku/addBooks", method = RequestMethod.POST)
	public String saveBuku(Model model, Buku buku) {
		model.addAttribute("buku", bukuService.saveOrUpdate(buku));
		return "redirect:/buku";
	}
	
	@RequestMapping(value = "/buku/edit/{id}", method = RequestMethod.GET)
	public String editBuku(@PathVariable Integer id, Model model) {
		model.addAttribute("buku", bukuService.getIdBuku(id));
		return "editBuku";
	}
	
	@RequestMapping(value = "/buku/delete/{id}")
	public String delete(@PathVariable int id) {
		bukuService.delete(id);
		return "redirect:/buku";
	}

}
