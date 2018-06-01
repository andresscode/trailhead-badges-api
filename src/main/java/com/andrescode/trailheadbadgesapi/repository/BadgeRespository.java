package com.andrescode.trailheadbadgesapi.repository;

import com.andrescode.trailheadbadgesapi.collection.Badge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "chrome-extension://njkppckpngjhdlmiindllijgjjeflpon")
@RepositoryRestResource(collectionResourceRel = "badges", path = "badges")
public interface BadgeRespository extends MongoRepository<Badge, String> {
    Badge findByHref(@Param("href") String href);
}
