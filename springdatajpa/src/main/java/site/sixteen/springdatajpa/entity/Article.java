/**
 * @projectName jygz
 * @package site.sixteen.springdatajpa.entity
 * @className site.sixteen.springdatajpa.entity.Article
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package site.sixteen.springdatajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Article
 *
 * @author panhainan
 * @description
 * @date 2018/9/27 11:13
 */
@Entity
@Data
@AllArgsConstructor
@NamedQuery(name="Article.findById1",query = "select a from Article a where a.id = ?1 ") //预定义查询，不建议使用
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String content;

    private Date createTime;

    public Article(String title, String author, String content, Date createTime) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.createTime = createTime;
    }
}
