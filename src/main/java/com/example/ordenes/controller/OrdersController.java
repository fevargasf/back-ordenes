package com.example.ordenes.controller;

import com.example.ordenes.model.pojo.DetalleOrdenEntity;
import com.example.ordenes.model.pojo.OrdenEntity;
import com.example.ordenes.model.request.ActualizarStock;
import com.example.ordenes.model.request.OrdenRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ordenes.service.OrdersService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrdersController {

	private final OrdersService service;

	@PostMapping("/order")
	public ResponseEntity<Integer> createOrder(@RequestBody OrdenRequest request) {

	  Integer result = service.createOrder(request);
	  
	  if(request != null) {
	    return ResponseEntity.ok(result);
	  } else {
	    return ResponseEntity.badRequest().build();
	  }
		
	}

	@GetMapping("/order/{id}")
	public ResponseEntity<OrdenEntity> getProducts(@PathVariable Integer id) {

		log.info("Consultar orden {}", id);
		OrdenEntity result = service.getProducts(id);
		log.info("Consultar orden {}", result);
		if (result != null) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PutMapping("/actualizar")
	public void returnProduct(@RequestBody ActualizarStock actualizarStock)
	{
	   service.actualizarStock(actualizarStock.getId(), actualizarStock.getCantidad());

	}


}
