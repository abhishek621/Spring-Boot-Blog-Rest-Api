package com.abhishek.blogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhishek.blogapi.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
	
	Tag findByName(String name);
}
