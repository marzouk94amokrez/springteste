package pro.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import pro.entit.Category;
import pro.entit.livre;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;


@CrossOrigin("*")
@RepositoryRestResource
public interface livreRepository extends MongoRepository<livre, String > {
    @Query(value = "SELECT min(nbrAchat) FROM livre")
    public int min();

    //@Query(value = "SELECT max(nbrAchat) FROM livre")
   // @Query("{ $max :  '$nbrAchat'}")
    @Query ("{nbrAchat:-1})")
    public Number max();

    @RestResource(path = "/selectedProduts")
    public List<livre> findBySelectedIsTrue();

    @Query("{'nbrAchat' : {  $gt : ?0 } }")
    public  List<livre> recomo(@Param("mc" )Number des);

    @Query(value ="select x from livre x order by x.nbrJaime DESC")
    public Page<livre> aimer(Pageable pageable);
    public List<livre> findByCat (String b);

    Page<livre> findByOrderByNbrJaimeDesc(Pageable pageable);


}