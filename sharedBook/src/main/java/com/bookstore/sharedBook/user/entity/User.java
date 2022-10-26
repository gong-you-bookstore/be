package com.bookstore.sharedBook.user.entity;

import com.bookstore.sharedBook.config.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
public class User extends BaseEntity {
    private String name;
    private String nickname;
    private String email;
    private String password;
    private Integer age;
    private String gender;
    private Integer token;

}
