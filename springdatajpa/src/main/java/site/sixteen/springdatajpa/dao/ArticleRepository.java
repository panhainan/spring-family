/**
 * @projectName jygz
 * @package site.sixteen.springdatajpa.dao
 * @className site.sixteen.springdatajpa.dao.ArticleRepository
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package site.sixteen.springdatajpa.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import site.sixteen.springdatajpa.entity.Article;

import javax.transaction.Transactional;
import java.util.List;

/**
 * ArticleRepository
 *
 * @author panhainan
 * @description
 * @date 2018/9/27 11:15
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findById1(Long id);

    @Query("select a from Article a where a.author like ?1")
    List<Article> findByAuthor2(String author);

    @Query("select a from Article a where a.author like %?1")
    List<Article> findByAuthor3(String author);

    @Query("select a from Article a where a.author like ?1%")
    List<Article> findByAuthor4(String author);

    @Query("select a from Article a where a.author like %:param1%")
    List<Article> findByAuthor5(@Param("param1") String author);

    @Query("select a from Article a where a.author like %:param1%")
    List<Article> findByAuthor55(@Param("param1") String author, Sort sort);

    @Query(nativeQuery = true, value = "select a.* from Article a where a.author like %:param1%")
    List<Article> findByAuthor6(@Param("param1") String author);

    @Query(nativeQuery = true, value = "select a.* from Article a where a.author like concat('%' ,:param1,'%') ")
    List<Article> findByAuthor7(@Param("param1") String author);

    /**
     * 若不加@Modifying，则抛出异常：org.hibernate.hql.internal.QueryExecutionRequestException: Not supported for DML operations
     * 同时还得加上@Transactional 否则抛出异常：javax.persistence.TransactionRequiredException: Executing an update/delete query
     */
    @Modifying
    @Transactional
    @Query("update Article a set a.content=:content where a.title=:title")
    Integer updateContentByTitle(@Param("title") String title,@Param("content")String content);

}
