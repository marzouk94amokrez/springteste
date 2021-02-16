package pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.dao.*;

import pro.entit.*;

import java.util.List;


@CrossOrigin("*")
@RestController

public class Controller {
    private pro.dao.livreRepository livreRepository;
    private pro.dao.CategoryRepository CategoryRepository;
    private pro.dao.SousCatRepository SousCatRepository;
    private pro.dao.factureRepository factureRepository;
    private pro.dao.userRepository userRepository;
    public String i;

    @Autowired
    public Controller(CategoryRepository CategoryRepository, livreRepository livreRepository, userRepository userRepository, SousCatRepository SousCatRepository,factureRepository factureRepository) {
        this.CategoryRepository = CategoryRepository;
        this.livreRepository = livreRepository;
        this.userRepository = userRepository;
        this.SousCatRepository = SousCatRepository;
        this.factureRepository = factureRepository;
    }


    @PutMapping(path = "/ajoutcategorie")
    public Category ajoutercategorie(@RequestBody Category newsouscategorie) {
        Category p = new Category();
        System.out.println("kfkfkkfkfkfkkfkfkfkfkfkfkfkkfkfk");

        p.setName(newsouscategorie.getName());
        p.setSouscat(newsouscategorie.getSouscat());

        SousCat j = this.SousCatRepository.moncategorie(newsouscategorie.getSouscat());
        System.out.println(j.getId());
        // System.out.println(p.getId());
        System.out.println(p.getSouscat());
        SousCat h = this.SousCatRepository.findById((String ) j.getId()).get();
        p.setCategory(h);
        return this.CategoryRepository.save(p);
    }


    @PutMapping(path = "/ajoutcategoriepere")
    public SousCat ajoutercategoriepere(@RequestBody SousCat newsouscategorie) {
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        SousCat p = new SousCat();

        p.setName(newsouscategorie.getName());
        System.out.println(p.getName());
        System.out.println("ddddddddddddddddddddddddddddddddddddddd");
        users U = new users();

        U.setName(newsouscategorie.getName());
        U.setPrenom(newsouscategorie.getName());




       this.userRepository.save(U);

        return this.SousCatRepository.save(p);
    }


    @PutMapping(path = "/employ")
    public livre ajouterLivre(@RequestBody livre newProduit) {
        livre p = new livre();

        p.setName(newProduit.getName());
        p.setCat(newProduit.getCat());
        p.setPrix(newProduit.getPrix());
        p.setNbrAchat(newProduit.getNbrAchat());
        p.setNbrJaime(newProduit.getNbrJaime());
        p.setQnt(newProduit.getQnt());
        p.setNamephoto(newProduit.getNamephoto());
        p.setDescription(newProduit.getDescription());
        p.setPromotion(newProduit.isPromotion());
        p.setSelected(newProduit.isSelected());
       // categorie uf = categorieRepository.findById((long) 2).get();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        Category j = this.CategoryRepository.mocate(newProduit.getCat());
        System.out.println(j.getId());
        System.out.println(j.getName());

        Category h = this.CategoryRepository.findById((String ) j.getId()).get();
        p.setCategory(h);
        return this.livreRepository.save(p);
    }

    @PutMapping(path = "/utilisateur")
    public users ajouterusers(@RequestBody users newuser) {
        users U = new users();

        U.setName(newuser.getName());
        U.setPrenom(newuser.getPrenom());

        U.setEmail(newuser.getEmail());
        U.setTel(newuser.getTel());
        U.setTendence(newuser.getTendence());
        U.setMdp(newuser.getMdp());


        return this.userRepository.save(U);
    }


    @RequestMapping(path = "/kabylie")
    public users uticherche(@RequestParam String query, @RequestParam String md) {
        users U = new users();
        users p = new users();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        System.out.println(query);
        System.out.println(md);
        U.setName(query);
        U.setPrenom(md);
        System.out.println(this.userRepository.maRequ(query, md));
        if (this.userRepository.maRequ(query, md) == null) {
            return p;
        } else {
            return this.userRepository.maRequ(query, md);

        }


    }
    @RequestMapping(path = "/getcaty")
    public List<Category> getcat(@RequestParam String query) {
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmkkkkkkkkkkkkkkkkkkkmmmmmmmmmmmmmmmmmmmm");
       return this.CategoryRepository.findBySouscat(query);

    }
    @RequestMapping(path = "/getlivres")
    public List<livre> getliv(@RequestParam String query) {
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmkkkkkkkkkkkkkkkkkkkmmmmmmmmmmmmmmmmmmmm");
        return this.livreRepository.findByCat(query);

    }
    @RequestMapping(path = "/suprimeproduit")
    public boolean supProduit(@RequestParam String  query) {
        this.livreRepository.deleteById(query);
        return true;
    }

    @RequestMapping(path = "/suprimeCategorie")
    public boolean supCategorie(@RequestParam String  query) {
        this.CategoryRepository.deleteById(query);
        return true;
    }

    @RequestMapping(path = "/suprimeUsers")
    public boolean supUsers(@RequestParam String  query) {
        this.userRepository.deleteById(query);
        return true;
    }

    @RequestMapping(path = "/modifierUsers")
    public users modUsers(@RequestBody users us) {
        this.userRepository.deleteById(us.getId());
        users A = new users();
        A.setMdp(us.getMdp());
        A.setName(us.getName());
        A.setPrenom(us.getPrenom());
        A.setTel(us.getTel());
        A.setEmail(us.getEmail());
        A.setTendence(us.getTendence());
        return this.userRepository.save(A);
    }

    @PutMapping(path = "/modproduit")
    public void modProduit(@RequestBody livre produit) {
        this.livreRepository.deleteById(produit.getId());
        livre A = new livre();
        A.setCat(produit.getCat());
        A.setName(produit.getName());
        A.setDescription(produit.getDescription());
        A.setPromotion(produit.isPromotion());
        A.setSelected(produit.isSelected());
        A.setNamephoto(produit.getNamephoto());
        A.setQnt(produit.getQnt());
        A.setNbrJaime(produit.getNbrJaime());
        A.setNbrAchat(produit.getNbrAchat());
        A.setPrix(produit.getPrix());
        Category k = this.CategoryRepository.mocate(produit.getCat());
        //Category l = this.CategoryRepository.findById((String ) k.getId()).get();
        A.setCategory(k);
        this.livreRepository.deleteById(produit.getId());

         this.livreRepository.save(A);
        this.livreRepository.deleteById(produit.getId());

    }

    @RequestMapping(path = "/modCategorie")
    public boolean modCategorie(@RequestParam String name, @RequestParam String  id) {
        this.CategoryRepository.modif(name, id);

        return true;
    }


    @RequestMapping(path = "/min")
    public int min() {
        return livreRepository.min();
    }

    @RequestMapping(path = "/maxval")
    public Number  max() {
        System.out.println("ggggggggggggggggggggggggg");
       // System.out.println(livreRepository.max());
      //  return livreRepository.max();
        return 8;
    }



    @PutMapping(path = "/ajoutfactures")
    public factures ajoutefacture(@RequestBody factures newuser) {
        factures U = new factures();

        U.setRef(newuser.getRef());
        U.setEmail(newuser.getEmail());

        U.setNum(newuser.getNum());
        U.setEtat(newuser.isEtat());
        U.setSomme(newuser.getSomme());
        U.setDate(newuser.getDate());


        return this.factureRepository.save(U);
    }
}