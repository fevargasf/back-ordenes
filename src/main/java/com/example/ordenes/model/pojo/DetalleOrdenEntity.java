package com.example.ordenes.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
        name = "detalle_orden",
        catalog = "operador",
        schema = "public")
@Data
@ToString
public class DetalleOrdenEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "detalle_orden_seq_generator")
    @SequenceGenerator(
            name = "detalle_orden_seq_generator",
            sequenceName = "public.detalle_orden_id_seq",
            allocationSize = 1)
    @Basic(
            optional = false)
    private Integer id;

    @Column(name = "producto_id")
    private Integer productoId;

    @Column(name = "categoria")
    private String categoria;
    @Basic(
            optional = false)
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cantidad")
    private Integer cantidad;

    @JoinColumn(
            name = "orden_id",
            referencedColumnName = "id")
    @ManyToOne(
            optional = false,
            fetch = FetchType.LAZY)
    @JsonIgnore
    private OrdenEntity ordenId;


}
