package by.tms.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    private String name;

    private String username;

    private String password;




}
