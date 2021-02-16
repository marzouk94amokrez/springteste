package pro.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import pro.entit.users;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;


@CrossOrigin("*")
@RepositoryRestResource
public interface userRepository  extends MongoRepository<users, String > {

    @Query("{ 'name' : ?0, 'mdp' : ?1 }")
    public users maRequ(@RequestParam String nom,@RequestParam String prenom);
}
