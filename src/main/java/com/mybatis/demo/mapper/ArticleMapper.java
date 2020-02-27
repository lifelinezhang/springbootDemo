package com.mybatis.demo.mapper;

import com.mybatis.demo.pojo.Article;
import org.springframework.stereotype.Component;

@Component
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}