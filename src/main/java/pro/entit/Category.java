

package pro.entit;

        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import org.springframework.data.annotation.Id;
        import org.springframework.data.mongodb.core.mapping.DBRef;
        import org.springframework.data.mongodb.core.mapping.Document;


        import java.io.Serializable;
        import java.util.Collection;
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
    @Id
    private String id;
    private String name;
    private String souscat;
    @DBRef
    private Collection<livre> livres;
    @DBRef(lazy = true)
    private SousCat Category  ;
}