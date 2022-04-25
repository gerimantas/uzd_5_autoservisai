package lt.autoservis.u5.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Vertinimas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int balas;
    private LocalDate data;
    private String komentaras;


}
