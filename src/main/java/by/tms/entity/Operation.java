package by.tms.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Entity
@Table(name = "operations")
@Getter
@Setter
@ToString
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double num1;

    private Double num2;

    private Double result;

    @Enumerated(EnumType.STRING)
    private OperationType type;

//    private LocalDateTime time;

    @OneToOne(cascade = CascadeType.REMOVE)
    private User user;

}
