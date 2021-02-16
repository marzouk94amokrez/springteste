package pro.entit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class livre implements Serializable {
    @Id
    private String id;
    private String name;
    private String description;
    private boolean promotion;
    private boolean selected;
    private String namephoto;
    private int qnt;
    private int prix;
    private int nbrAchat;
    private String cat;
    private int nbrJaime;
    @DBRef
    private Category Category;
}

