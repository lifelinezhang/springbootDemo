package com.mybatis.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.demo.pojo.Article;
import com.mybatis.demo.service.ArticleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequiresPermissions("article:add")
    @RequestMapping("/add")
    public int addArticle(@RequestBody JSONObject requestJson) {
        Article article = new Article();
        article.setId(requestJson.getInteger("id"));
        article.setContent(requestJson.getString("content"));
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        article.setDeleteStatus("0");
        int result = articleService.add(article);
        return result;
    }

}
