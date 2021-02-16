package pro.dao;




        import org.springframework.data.mongodb.repository.MongoRepository;
        import org.springframework.data.repository.query.Param;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;
        import org.springframework.data.rest.core.annotation.RestResource;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.RequestParam;
        import pro.entit.SousCat;
        import org.springframework.data.mongodb.repository.Query;
        import java.util.List;


@CrossOrigin("*")
@RepositoryRestResource
public interface SousCatRepository extends MongoRepository<SousCat, String > {
        @Query("{ 'name' : ?0 }")
    public SousCat  moncategorie (@RequestParam String nom);
}


