package com.SpringBoot_webEx.SpringBoot_webEx;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
