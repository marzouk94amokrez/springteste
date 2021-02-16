package pro.entit;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;
import java.util.List;
@Document
@Data @NoArgsConstructor @AllArgsConstructor
public class util implements Serializable {
    @Id
    private String id;
    private  String name;
    private  String prenom;
    private  String email ;
    private String tendence;
    private  String mdp;
    private String tel;


}