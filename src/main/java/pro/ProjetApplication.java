package pro;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import pro.dao.CategoryRepository ;
import pro.entit.Category;
import pro.entit.SousCat;

import pro.entit.livre;
import pro.entit.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;





import java.util.Random;

import java.util.Random;
@CrossOrigin("localhost:4200")
@SpringBootApplication
public class ProjetApplication  implements CommandLineRunner{


	@Autowired
	private pro.dao.userRepository userRepository;

	@Autowired
	private pro.dao.livreRepository livreRepository;

	@Autowired
	private pro.dao.CategoryRepository CategoryRepository;
	@Autowired
	private pro.dao.SousCatRepository  SousCatRepository;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(livre.class);
		restConfiguration.exposeIdsFor(users.class);
		restConfiguration.exposeIdsFor(Category.class);
		restConfiguration.exposeIdsFor(SousCat.class);
		SousCatRepository.save(new SousCat(null,"MANTEAUX",null));
		//SousCatRepository.save(new SousCat(null,"KAMALLL",null));


		//CategoryRepository.save(new Category(null,"tfygv","",null,null));




	}


}
