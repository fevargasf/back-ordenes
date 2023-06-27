package com.example.ordenes.service;

import com.example.ordenes.model.pojo.DetalleOrdenEntity;
import com.example.ordenes.model.pojo.OrdenEntity;
import com.example.ordenes.model.request.OrdenRequest;
import com.example.ordenes.model.request.Producto;
import com.example.ordenes.repository.DetalleOrdenRepository;
import com.example.ordenes.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ordenes.facade.ProductsFacade;

import java.util.List;
import java.util.UUID;

@Service
public class OrdersServiceImpl implements OrdersService {

  @Autowired
  private ProductsFacade productsFacade;
  @Autowired
  private DetalleOrdenRepository detalleOrdenRepository;
  @Autowired
  private OrdenRepository ordenRepository;



	@Override
	public Integer createOrder(OrdenRequest request) {

		if(request.productos.isEmpty()){
			throw new RuntimeException("No se puede crear la orden");
		}

		//llamada endpoint Buscador
		//
		List<Producto> productos = request.productos;

		productos.forEach(producto -> {
			if(!productsFacade.consultarDisponibilidad(producto.id,producto.cantidad)){
				throw new RuntimeException("no se puede crear la orden por disponibilidad de productos");
			}
		});

		final String referencia = UUID.randomUUID().toString();
		OrdenEntity crearOrden = new OrdenEntity();
		crearOrden.setEstado(true);
		crearOrden.setReferencia(referencia);
		ordenRepository.save(crearOrden);



		productos.forEach(producto -> {
			DetalleOrdenEntity detalleDeLaOrden = new DetalleOrdenEntity();
			detalleDeLaOrden.setCantidad(producto.cantidad);
			detalleDeLaOrden.setCategoria(producto.categoria);
			detalleDeLaOrden.setNombre(producto.nombre);
			detalleDeLaOrden.setProductoId(producto.id);
			detalleDeLaOrden.setOrdenId(crearOrden);
			detalleOrdenRepository.save(detalleDeLaOrden);
		});

		return crearOrden.getId();
	}

	public OrdenEntity getProducts(Integer id) {
		return ordenRepository.findById(id).orElse(null);
	}




	@Override
	public void actualizarStock(int id, int productosVendidos) {
		productsFacade.actualizarStock(id, -productosVendidos);
	}


}
