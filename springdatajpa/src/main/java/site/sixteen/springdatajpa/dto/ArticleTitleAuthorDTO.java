/**
 * @projectName springdatajpa
 * @package site.sixteen.springdatajpa.dto
 * @className site.sixteen.springdatajpa.dto.ArticleTitleAuthorDTO
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package site.sixteen.springdatajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ArticleTitleAuthorDTO
 *
 * @author panhainan
 * @description
 * @date 2018/9/28 17:10
 */
@Data
@AllArgsConstructor
public class ArticleTitleAuthorDTO {

    private String title;
    private String author;


}
