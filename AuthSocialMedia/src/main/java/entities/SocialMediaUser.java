package entities;


import jakarta.persistence.*;

@Entity(name="social_media_users")
public class SocialMediaUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, name = "username", length = 50)
    private String username;
    @Column(nullable = false, name = "email", length = 100)
    private String email;
    @Column (nullable = false, name = "password", length = 100)
    private String password;

}
