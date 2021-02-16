package pro.entit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class factures implements Serializable {
    @Id

    private String id;
    private  String email;
    private  String num;
    private Date date;
    private boolean etat;

    private int ref;
    private int somme;




}