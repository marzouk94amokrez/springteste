package pro.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import pro.entit.users;
import pro.entit.util;

import java.util.List;



@CrossOrigin("*")
@RepositoryRestResource
public interface utilRepository  extends MongoRepository<util, String > {


}
