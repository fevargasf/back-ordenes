package com.example.ordenes.model.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(
		name = "orden",
		catalog = "operador",
		schema = "public")
@Data


public class OrdenEntity implements Serializable {

    @Id
	@Column(name = "id")
	@GeneratedValue(
			strategy = GenerationType.AUTO,
			generator = "orden_seq_generator")
	@SequenceGenerator(
			name = "orden_seq_generator",
			sequenceName = "public.orden_id_seq",
			allocationSize = 1)
	private Integer id;

	@Column(name = "referencia")
	private String referencia;

	@Column(name = "estado")
	private boolean estado;


    @OneToMany(mappedBy = "ordenId",
			fetch = FetchType.EAGER)
	private List<DetalleOrdenEntity> listaDetalles;
}
