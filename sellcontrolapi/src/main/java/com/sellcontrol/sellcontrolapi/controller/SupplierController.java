package com.sellcontrol.sellcontrolapi.controller;

import com.sellcontrol.sellcontrolapi.supplier.DataSuppliersForm;
import com.sellcontrol.sellcontrolapi.supplier.Supplier;
import com.sellcontrol.sellcontrolapi.supplier.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierRepository supplierRepository;

    @PostMapping
    @Transactional
    public void insertSupplier(@RequestBody DataSuppliersForm dados) {

        supplierRepository.save(new Supplier(dados));

    }




}
