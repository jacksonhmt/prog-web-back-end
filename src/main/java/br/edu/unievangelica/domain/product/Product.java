package br.edu.unievangelica.domain.product;

import br.edu.unievangelica.domain.category.Category;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
    @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @NotNull
    @NotEmpty
    @Size(max = 80)
    private String nome;

    @NotNull
    @NotEmpty
    @Size(max = 60)
    private String marca;

    @Size(max = 200)
    private String descricao;

    @NotNull
    private float preco;

    @ManyToOne
    private Category category;
}
