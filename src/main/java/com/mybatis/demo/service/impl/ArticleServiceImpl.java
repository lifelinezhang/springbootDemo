package com.mybatis.demo.service.impl;

import com.mybatis.demo.mapper.ArticleMapper;
import com.mybatis.demo.pojo.Article;
import com.mybatis.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int add(Article article) {
        return articleMapper.insert(article);
    }
}
