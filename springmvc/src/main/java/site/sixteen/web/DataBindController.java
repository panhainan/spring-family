package site.sixteen.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.sixteen.entity.Article;
import site.sixteen.entity.Book;
import site.sixteen.entity.Person;
import site.sixteen.entity.User;
import site.sixteen.vo.UserListVO;

import java.util.Date;
import java.util.List;

/**
 * SpringMVC数据绑定实例(采用url或者表单application/x-www-form-urlencoded形式传递)
 *
 * @author panhainan
 * @email panhainan@yeah.net
 */
@Slf4j
@Controller
public class DataBindController {


    /**
     * 参数为基本数据类型，如int
     * 此时param不能为空，否则会出现 HTTP Status 400 – Bad Request
     * 可以通过@RequestParam注解来设置别名，默认值，是否必须等
     * get方式    :   http://localhost:8080/springmvc/basicType?param=16666
     * post方式   :   http://localhost:8080/springmvc/basicType
     * post方式注意:   指定param = 16  同时指定["Content-Type","application/x-www-form-urlencoded"]
     *
     * @param param
     * @return json串
     */
    @RequestMapping("/basicType")
    @ResponseBody
    public String basicType(int param) {
        String msg = "the param is " + param;
        log.info(msg);
        return msg;
    }

    /**
     * 参数为包装类型，如Integer
     * 此时param可以为空，为空时值为null
     * get方式    :   http://localhost:8080/springmvc/wrapperType?param=16666
     * post方式   :   http://localhost:8080/springmvc/wrapperType
     * post方式注意:   指定param = 16  同时指定["Content-Type","application/x-www-form-urlencoded"]
     *
     * @param param
     * @return json串
     */
    @RequestMapping("/wrapperType")
    @ResponseBody
    public String wrapperType(Integer param) {
        String msg = "the param is " + param;
        log.info(msg);
        return msg;
    }

    /**
     * 参数为数组类型
     * get方式    :   http://localhost:8080/springmvc/arrayType?params=Tome&params=Jack
     * post方式   :   http://localhost:8080/springmvc/arrayType
     * post方式注意:   指定params=Tome&params=Jack  同时指定["Content-Type","application/x-www-form-urlencoded"]
     *
     * @param params
     * @return json串
     */
    @RequestMapping("/arrayType")
    @ResponseBody
    public String arrayType(String[] params) {
        StringBuilder msg = new StringBuilder("params are : ");
        for (String p : params) {
            msg.append(p + " ");
        }
        log.info(msg.toString());
        return msg.toString();
    }

    /**
     * 参数为简单对象（简单对象包含对象，即多层级对象）
     * get方式：   http://localhost:8080/springmvc/objectType?name=Tom&age=18
     * post方式：  http://localhost:8080/springmvc/objectType
     * post方式注意:   直接指定name=Tom&age=18（不需要加user.）  同时指定["Content-Type","application/x-www-form-urlencoded"]
     * <p>
     * 注意：若简单对象内部还包含一个对象如Contact contact，Contact有address和phone两个属性
     * 那么参数传递的方式为name=Tom&age=18&contact.address=北京路&phone18074600000
     *
     * @param user
     * @return json串
     */
    @RequestMapping("/objectType")
    @ResponseBody
    public String objectType(User user) {
        String msg = "user is : " + user;
        log.info(msg);
        return msg;
    }

    /**
     * 同属性多对象
     * get方式：http://localhost:8080/springmvc/objectsAttributeType?user.name=Jack&user.age=19&book.name=SpringBoot
     * post方式：http://localhost:8080/springmvc/objectsAttributeType
     * post方式注意:   指定name=Tom&age=18 同时指定["Content-Type","application/x-www-form-urlencoded"]。
     * 会出现结果两个对象的name都为Tom。
     * 若使用user.name方式则会显示null
     * 因此需要使用到下面的initParamUser和initParamBook方法
     *
     * @param user
     * @param book
     * @return json串
     */
    @RequestMapping("/objectsAttributeType")
    @ResponseBody
    public String objectsAttributeType(User user, Book book) {
        String msg = "user is : " + user + ",book is : " + book;
        log.info(msg);
        return msg;
    }

    //@InitBinder注解在本controller启动时会进行初始化
    @InitBinder("user")
    public void initParamUser(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("book")
    public void initParamBook(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("book.");
    }

    /**
     * 参数为集合List类型（Set类型不太兼容，Map类型需要注意键值对，二者都不太常用）
     * get方式：http://localhost:8080/springmvc/listType?userList[0].name=gaven&userList[1].name=jack
     * post方式：http://localhost:8080/springmvc/listType
     * 指定userList[0].name=gaven&userList[1].name=jack
     * 同时指定["Content-Type","application/x-www-form-urlencoded"]。
     *
     * @param userListVO
     * @return json串
     */
    @RequestMapping("/listType")
    @ResponseBody
    public String listType(UserListVO userListVO) {
        StringBuilder msg = new StringBuilder("userList are : ");
        for (User user : userListVO.getUserList()) {
            msg.append(user + " ");
        }
        log.info(msg.toString());
        return msg.toString();
    }

    /*
       实现SpringMVC对于JSON数据解析绑定需要进行以下4步：
       1. 导入json的jar包：jackson，如对应的maven的pom为
          <dependency>
              <groupId>com.fasterxml.jackson.core</groupId>
              <artifactId>jackson-databind</artifactId>
              <version>2.5.2</version>
          </dependency>
          <dependency>
              <groupId>com.fasterxml.jackson.core</groupId>
              <artifactId>jackson-core</artifactId>
              <version>2.5.2</version>
          </dependency>
       2. 在spring-mvc的配置文件中添加对于json数据解析绑定的配置，这里可以通过<mvc:annotation-driven/>直接快速使用
       3. 前台发送请求必须注明["Content-Type":"application/json"]，同时需要将传递的JSON数据字符串化，如User对象的JSON字符串形式为：
        {
           "name":"Tom",
           "age":20
        }
       4. 在controller中进行接收时，需要在参数位置前指定 @RequestBody 注解

       */

    /**
     * JSON格式简单对象
     * post方式：http://localhost:8080/springmvc/jsonObjectType
     * 注明["Content-Type":"application/json"]以及参数为{ "name":"Tom","age":20 }
     *
     * @param user
     * @return json串
     */
    @RequestMapping("/jsonObjectType")
    @ResponseBody
    public String jsonObjectType(@RequestBody User user) {
        String msg = user.toString();
        log.info(msg);
        return msg;
    }

    /**
     * JSON格式多层级简单对象
     * post方式：http://localhost:8080/springmvc/jsonObjectsType
     * 注明["Content-Type":"application/json"]以及参数为{ "name":"Tom","age":20,"contactInfo":{ "phone":"18074609999","email":"test@yeah.net"} }
     *
     * @param person
     * @return json串
     */
    @RequestMapping("/jsonObjectsType")
    @ResponseBody
    public String jsonObjectsType(@RequestBody Person person) {
        String msg = person.toString();
        log.info(msg);
        return msg;
    }

    /**
     * JSON格式简单对象数组
     * post方式：http://localhost:8080/springmvc/jsonObjectArrayType
     * 注明["Content-Type":"application/json"]以及参数为[{"age":18,"name":"Tom"},{"age":10,"name":"Jack"}]
     *
     * @param users
     * @return json串
     */
    @RequestMapping("/jsonObjectArrayType")
    @ResponseBody
    public String jsonObjectArrayType(@RequestBody User[] users) {
        StringBuilder msg = new StringBuilder();
        for (User user : users) {
            msg.append(user.toString() + " ");
        }
        log.info(msg.toString());
        return msg.toString();
    }

    /**
     * JSON格式简单对象List集合形式
     * post方式：http://localhost:8080/springmvc/jsonObjectListType
     * 注明["Content-Type":"application/json"]以及参数为[{"age":18,"name":"Tom"},{"age":10,"name":"Jack"}]
     * 注意参数形式为List<User>，如果像form表单那样传UserListVO时则会提示400错误。
     *
     * @param userList
     * @return
     */
    @RequestMapping("/jsonObjectListType")
    @ResponseBody
    public String jsonObjectListType(@RequestBody List<User> userList) {
        StringBuilder msg = new StringBuilder();
        for (User user : userList) {
            msg.append(user.toString() + " ");
        }
        log.info(msg.toString());
        return msg.toString();
    }

    /*
      实现SpringMVC对于JSON数据解析绑定需要进行以下4步：
      1. 导入xml的jar包：因为spring-oxm提供对xml的支持，故引入spring-oxm即可;
       2. 在spring-mvc的配置文件中添加对于xml数据解析绑定的配置，这里可以通过<mvc:annotation-driven/>直接快速使用
       3. 前台发送请求必须注明["Content-Type":"application/xml"]，
          同时需要注意，对于传输的指定对象，需要在对象的类里面进行相关操作，
          在类上面添加@XmlRootElement(name="如article")，在其属性的所有get方法上根据需要分别添加对应的@XmlElement(name = "如title,content")，分别表示xml文件中的根节点和节点
          同时注意参数的形式，如Article对象，
            <?xml version="1.0" encoding="UTF-8"?>
            <article>
                <title>here is title</title>
                <content>here is content</content>
            </article>
       4. 在controller中进行接收时，需要在参数位置前指定 @RequestBody 注解
     */

    /**
     * XML格式
     * post方式：http://localhost:8080/springmvc/xmlType
     * 注明["Content-Type":"application/xml"]以及参数为
     * <?xml version="1.0" encoding="UTF-8"?><article><title>here is title</title><content>here is content</content></article>
     *
     * @param article
     * @return json串
     */
    @RequestMapping("/xmlType")
    @ResponseBody
    public String xmlType(@RequestBody Article article) {
        String msg = article.toString();
        log.info(msg);
        return msg;
    }

    /**
     * Date格式
     * get方式：http://localhost:8080/springmvc/dateType?date=2014-10-10
     * post方式：http://localhost:8080/springmvc/dateType 附带参数：date=2014-10-10
     *
     * @param date
     * @return
     */
    @RequestMapping("/dateType")
    @ResponseBody
    public String dateType(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        log.info("{}", date.toString());
        return date.toString();
    }


}