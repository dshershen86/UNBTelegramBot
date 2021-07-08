package com.dshershen.telegram.model;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class User {

    private String chatId;
    private String name;
    private boolean isLogin;
    private boolean isAdmin;
    private boolean isHead;
    private Long id;

    public User(String chatId, String name, boolean isManager, boolean isHead, boolean isAdmin) {
            this.chatId = chatId;
            this.name = name;
            this.isLogin = isLogin;
            this.isHead = isHead;
            this.isAdmin = isAdmin;
        }

    public User() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isHead() {
        return isHead;
    }

    public void setHead(boolean head) {
        isHead = head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return chatId.equals(user.chatId) && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, name);
    }
}
