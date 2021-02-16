package pro.dao;
import org.springframework.data.mongodb.repository.MongoRepository;

import pro.entit.factures;

public interface factureRepository extends MongoRepository<factures, String > {
}
