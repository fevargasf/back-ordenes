package com.example.ordenes.service;

import com.example.ordenes.model.pojo.DetalleOrdenEntity;
import com.example.ordenes.model.pojo.OrdenEntity;
import com.example.ordenes.model.request.ActualizarStock;
import com.example.ordenes.model.request.OrdenRequest;

public interface OrdersService {
	
	Integer createOrder(OrdenRequest request);
	OrdenEntity getProducts(Integer id);

	void actualizarStock(int id, int productosVendidos);


}
