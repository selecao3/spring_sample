package com.hellokoding.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class UserRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public String index(Model model) {
        List<Map<String,Object>> list;
        list = jdbcTemplate.queryForList("select * from fruits");
        model.addAttribute("fruits", list);
        return "index";
    }
}

