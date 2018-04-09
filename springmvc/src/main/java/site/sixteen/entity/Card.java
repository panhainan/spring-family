package site.sixteen.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 身份证
 */
public class Card {


    @Size(min = 2, max = 10, message = "长度介于2-10个字符之间")
    private String name;
    @Pattern(regexp = "^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|31)|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}([0-9]|x|X)$", message = "请填写正确的身份证信息")
    private String number;
    @NotNull(message = "{expiringDate.notnull}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiringDate;

    public Card() {
    }

    public Card(String name, String number, Date expiringDate) {
        this.name = name;
        this.number = number;
        this.expiringDate = expiringDate;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", expiringDate=" + expiringDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getExpiringDate() {
        return expiringDate;
    }

    public void setExpiringDate(Date expiringDate) {
        this.expiringDate = expiringDate;
    }
}
