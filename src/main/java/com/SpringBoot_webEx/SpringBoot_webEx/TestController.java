package com.SpringBoot_webEx.SpringBoot_webEx;


import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }

    @RequestMapping("/")
    public String main(Model model){
        List<Post> postList = this.postRepository.findAll();
        model.addAttribute("postList", postList);
        model.addAttribute("targetPost", postList.get(0));
        return "main";
    }

    @PostMapping("/write")
    public String write(){
        Post post = new Post();
        post.setTitle("new_title");
        post.setContent("new_content");
        post.setCreateDate(LocalDateTime.now());
        this.postRepository.save(post);

        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Post post = this.postRepository.findById(id).get();
        model.addAttribute("targetPost", post);
        model.addAttribute("postList", postRepository.findAll());
        return "main";
    }

    @PostMapping("/update")
    public String update(Integer id, String title, String content){
        Post post = this.postRepository.findById(id).get();
        post.setTitle(title);
        post.setContent(content);
        this.postRepository.save(post);
        return "redirect:/detail/" + id;
    }
}
