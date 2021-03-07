//Interface utilizada para realizar transações com o db.

package com.spring.codeblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.codeblog.model.Post;

//extends já fornece métodos do Spring Data prontos, como findAll, findById, save, delete etc.
public interface CodeBlogRepository extends JpaRepository<Post, Long> {
	
}
