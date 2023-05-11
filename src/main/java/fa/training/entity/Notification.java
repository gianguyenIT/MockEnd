package fa.training.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "notification")
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification")
    private Long id;
    @Column(name = "title", length = 128)
    private String title;
    @Column(name = "image", length = 128)
    private String image;
    @Column(name = "content", length = 255)
    private String content;

    @ManyToMany
    private Set<Customer> cusNoti;

}
