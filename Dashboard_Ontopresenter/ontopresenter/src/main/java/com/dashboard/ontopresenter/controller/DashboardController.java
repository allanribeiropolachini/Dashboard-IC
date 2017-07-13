package com.dashboard.ontopresenter.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dashboard.ontopresenter.model.ClientTb;
import com.dashboard.ontopresenter.model.DashTypeClientTb;
import com.dashboard.ontopresenter.model.ProviderTb;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//import com.dashboard.ontopresenter.model.*;
//import com.dashboard.ontopresenter.repository.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


@Controller
public class DashboardController {
	
	//@Autowired
	//private Users users;
	
	@RequestMapping("/index")
	public String RequestDashboard() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String RequestLogin() {
		return "login";
	}
	
	@RequestMapping("/user")
	public String RequestUser() {
		return "user";
	}
	
	@RequestMapping("/sign_up")
	public String RequestSignUP() {
		return "sign_up";
	}
	
	@RequestMapping("/politics_atribute")
	public String RequestPolitics_Atributes() {
		return "politics_atribute";
	}
	
	@RequestMapping("/allocate_vm")
	public String RequestAllocate_VM() {
		return "allocate_vm";
	}
	
	@RequestMapping("/politics_manage")
	public String RequestManage_Politics() {
		return "politics_manage";
	}

	@RequestMapping(value="/create_user", method = RequestMethod.POST)
	public ModelAndView SignUp(ClientTb client){
		//System.out.println(">>> " + client.getName());
		//System.out.println(">>> " + client.getPassword());
		//System.out.println(">>> " + client.getEmail());
		
		client.setDescription("Client " + client.getName());
		
		client.setIdClient(ThreadLocalRandom.current().nextInt(1, 999999));
		
		ProviderTb prov = new ProviderTb();
		prov.setIdProvider(1);
		prov.setName("LASDPC");
		prov.setEmail("lasdpc@icmc.usp.br");
		prov.setPassword("lasdpc");
		prov.setDescription("lasdpc");
		client.setProviderTb(prov);
		
		DashTypeClientTb type = new DashTypeClientTb();
		type.setIdDashTypeClient(2);
		type.setDescription("Admin");
		client.setDashTypeClientTb(type);
		
		//System.out.println(">>> " + client.getDescription());
		//System.out.println(">>> " + client.getIdClient());
		//System.out.println(">>> " + client.getProviderTb().getEmail());
		//System.out.println(">>> " + client.getDashTypeClientTb().getDescription());
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ontopresenter");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(client);
		em.getTransaction().commit();
		//em.close();
		
		ModelAndView mv = new ModelAndView("user");
		mv.addObject("name", "Allan");
		return mv;
	}
	
	@RequestMapping(value="/login_user", method = RequestMethod.POST)
	public ModelAndView Login_User(ClientTb client){
		System.out.println(">>> " + client.getName());
		System.out.println(">>> " + client.getPassword());
		System.out.println(">>> " + client.getEmail());
		
		/*client.setDescription("Client " + client.getName());
		
		client.setIdClient(ThreadLocalRandom.current().nextInt(1, 999999));
		
		ProviderTb prov = new ProviderTb();
		prov.setIdProvider(1);
		prov.setName("LASDPC");
		prov.setEmail("lasdpc@icmc.usp.br");
		prov.setPassword("lasdpc");
		prov.setDescription("lasdpc");
		client.setProviderTb(prov);
		
		DashTypeClientTb type = new DashTypeClientTb();
		type.setIdDashTypeClient(2);
		type.setDescription("Admin");
		client.setDashTypeClientTb(type);*/
		
		System.out.println(">>> " + client.getDescription());
		System.out.println(">>> " + client.getIdClient());
		//System.out.println(">>> " + client.getProviderTb().getEmail());
		//System.out.println(">>> " + client.getDashTypeClientTb().getDescription());
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ontopresenter");
		EntityManager em = emf.createEntityManager();
		ClientTb clienttb = em.find(ClientTb.class, 1);
		TypedQuery<ClientTb> consulta = em.createQuery("SELECT C FROM ClientTb C WHERE C.name LIKE '" + client.getName() + "' AND C.password LIKE '" + client.getPassword() + "'", ClientTb.class);

		List<ClientTb> client_list = consulta.getResultList();
		
		
		//em.close();
		
		
		System.out.println(">>> <<<<<<<<<<<<<<<<<<<<<");
		System.out.println(">>> " + clienttb.getName());
		System.out.println(">>> " + clienttb.getPassword());
		System.out.println(">>> " + clienttb.getEmail());
		
		if(client_list.size() != 0){
			System.out.println("ID CONSULTAA>>> " + client_list.get(0).getIdClient());
			ModelAndView mv = new ModelAndView("user");
			mv.addObject("name", client_list.get(0).getName());
			return mv;
		}else{
			ModelAndView mv = new ModelAndView("index");
			return mv;
		}
	}
}
