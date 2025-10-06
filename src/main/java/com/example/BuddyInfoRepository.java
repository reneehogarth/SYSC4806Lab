package com.example;

import org.springframework.data.repository.CrudRepository;

import com.example.BuddyInfo;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "buddies", path = "buddies")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    Iterable<Object> findByName(String name);
}
