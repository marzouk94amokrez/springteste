package pro.entit;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Collection;
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SousCat implements Serializable {
    @Id
    private String id;
    private String name;
    @DBRef
    private Collection<Category> Category;
}

