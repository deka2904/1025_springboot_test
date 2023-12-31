package com.SpringBoot_webEx.SpringBoot_webEx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SpringBootWebExApplicationTests {
	@Autowired
	private PostRepository postRepository;
	@Test
	void contextLoads() {
		Post p = new Post();
		p.setTitle("aaa");
		p.setContent("bbb");
		p.setCreateDate(LocalDateTime.now());
		this.postRepository.save(p);
	}
}
