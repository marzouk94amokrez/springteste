
package pro.dao;



        import org.springframework.data.mongodb.repository.MongoRepository;
        import org.springframework.data.mongodb.repository.Query;
        import org.springframework.web.bind.annotation.RequestParam;
        import pro.entit.Category;

        import org.springframework.data.rest.core.annotation.RepositoryRestResource;
        import org.springframework.web.bind.annotation.CrossOrigin;

        import java.util.List;
        import java.util.Optional;

@CrossOrigin("*")
@RepositoryRestResource
public interface CategoryRepository extends MongoRepository<Category, String > {
    @Query("{ 'name' : ?0 }")
    public Category mocate(@RequestParam String nom);
    @Query("{ 'name' : ?0, 'id' : ?1 }")
    public void modif(@RequestParam String nom, @RequestParam String  id);
    public List<Category> findBySouscat (String b);
}
