package site.sixteen.springdatajpa.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import site.sixteen.springdatajpa.SpringdatajpaApplicationTests;
import site.sixteen.springdatajpa.entity.Article;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j

public class ArticleRepositoryTest extends SpringdatajpaApplicationTests {

    @Autowired
    private ArticleRepository articleRepository;


    @Test
    @Transactional
    @Rollback(false)
    public void testSave(){
        Article article = new Article("SpringDataJPA简单使用0","十六子","内容：略0",new Date());
        Article result = articleRepository.save(article);
        log.debug("result:{}",result);
        Assert.assertNotNull(result);
        //id = 1
    }
    @Test
    @Transactional
    @Rollback(false)
    public void testSaveAll(){
        List<Article> articles = Arrays.asList(
            new Article("SpringDataJPA简单使用1","十六子","内容：略1",new Date()),
            new Article("SpringDataJPA简单使用2","十六子","内容：略2",new Date()),
            new Article("SpringDataJPA简单使用3","十六子","内容：略3",new Date()),
            new Article("SpringDataJPA简单使用4","十六子","内容：略4",new Date())
        );
        List<Article> results = articleRepository.save(articles);
        logList(results);
        Assert.assertNotNull(results);
    }
    @Test
    public void testGet(){
        Long id = 1L;
        Article article = articleRepository.findOne(id);
        log.debug("article:{}",article);
        Assert.assertNotNull(article);
    }

    @Test
    public void testFindById1(){
        Long id = 1L;
        Article article = articleRepository.findById1(id);
        log.debug("article:{}",article);
        Assert.assertNotNull(article);
    }
    @Test
    public void testFindByAuthor2(){
        String author="十六子";
        List<Article> expect = articleRepository.findByAuthor2(author);
        logList(expect);
        Assert.assertNotNull(expect);
    }
    @Test
    public void testFindByAuthor3(){
        String author="六子";
        List<Article> expect = articleRepository.findByAuthor3(author);
        logList(expect);
        Assert.assertNotNull(expect);
    }

    @Test
    public void testFindByAuthor4(){
        String author="十六";
        List<Article> expect = articleRepository.findByAuthor4(author);
        logList(expect);
        Assert.assertNotNull(expect);
    }

    @Test
    public void testFindByAuthor5(){
        String author="六";
        List<Article> expect = articleRepository.findByAuthor5(author);
        logList(expect);
        Assert.assertNotNull(expect);
    }

    @Test
    public void testFindByAuthor55(){
        String author="六";
        //Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"createTime"),new Sort.Order(Sort.Direction.ASC,"title"));
        Sort sort = new Sort(Sort.Direction.DESC,"createTime","title");
        List<Article> expect = articleRepository.findByAuthor55(author,sort);
        logList(expect);
        Assert.assertNotNull(expect);
    }

    @Test
    public void testFindByAuthor6(){
        String author="六";
        List<Article> expect = articleRepository.findByAuthor6(author);
        logList(expect);
        Assert.assertNotNull(expect);
    }

    @Test
    public void testFindByAuthor7(){
        String author="六";
        List<Article> expect = articleRepository.findByAuthor7(author);
        logList(expect);
        Assert.assertNotNull(expect);
    }

    @Test
    @Transactional
    //@Rollback(false)
    public void testUpdateContentByTitle(){
        log.debug("result:{}",articleRepository.updateContentByTitle("SpringDataJPA简单使用0","内容：略0略0略0略0"));
    }


    public <T> void logList(List<? extends T> list){
        log.debug("*********************************");
        for(T t:list){
            log.debug("{}",t);
        }
        log.debug("*********************************");
    }


}