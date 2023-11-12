package com.sourcesyncron.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sourcesyncron.v1.model.Status;


@Repository
public interface StatusRepository extends JpaRepository<Status, Long>{

}
