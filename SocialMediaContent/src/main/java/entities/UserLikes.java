package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity(name = "user_likes")
public class UserLikes {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private UserPost userPost;



    public UserLikes() {
    }

    public UserLikes(String username, UserPost userPost) {
        this.username = username;
        this.userPost = userPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    @Override
    public String toString() {
        return "UserLikes{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
