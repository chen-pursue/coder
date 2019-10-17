package com.deng.coder.mapper;

import com.deng.coder.models.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface ArticleMapper {

    @Insert("INSERT INTO article (title,content,writer_id,tag,gmt_create,gmt_modify) VALUES(#{title},#{content},#{writerId},#{tag},#{gmtCreate},#{gmtModify})")
    void add(Article article);

    @Select("SELECT * FROM article ORDER BY gmt_create DESC limit #{offset},#{size}")
    ArrayList<Article> findByTime(@Param("offset") int offset,@Param("size") int size);

    @Select("SELECT COUNT(1) FROM article")
    int totalCount();
}
