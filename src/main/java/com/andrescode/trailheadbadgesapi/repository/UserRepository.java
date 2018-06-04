package com.andrescode.trailheadbadgesapi.repository;

import com.andrescode.trailheadbadgesapi.collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = {"chrome-extension://njkppckpngjhdlmiindllijgjjeflpon", "chrome-extension://gmpnnbgfdeepifibcklmmedbejbacdic"})
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByCompany(@Param("company") String company);
    User findByTrailheadId(@Param("trailheadId") String trailheadId);
}
