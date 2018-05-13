package com.jesus.rest.webservice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryJPA extends JpaRepository<Post, Integer>{
	
}
