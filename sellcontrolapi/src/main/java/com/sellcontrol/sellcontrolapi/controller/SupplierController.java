package com.sellcontrol.sellcontrolapi.controller;


import com.sellcontrol.sellcontrolapi.supplier.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierRepository supplierRepository;

    @PostMapping
    @Transactional //Precisa escrever no Banco de Dados
    public void insertSupplier(@RequestBody @Valid DataSuppliersForm data) {

        supplierRepository.save(new Supplier(data));
    }
    @GetMapping
    public Page<DataListSupplier> read(@PageableDefault(size=10, sort= {"razaoSocial"}) Pageable pagination){
        return supplierRepository.findAllByAtivoTrue(pagination).map(DataListSupplier::new);
    }

    @PutMapping
    @Transactional //Precisa escrever no Banco de Dados
    public void update(@RequestBody @Valid DataSuppliersUpdate data) {
        var supplier = supplierRepository.getReferenceById(data.id());
        supplier.updateInfo(data);
    }

    @DeleteMapping("/{id}")
    @Transactional //Precisa escrever no Banco de Dados
    public void delete(@PathVariable Long id) {
        var supplier = supplierRepository.getReferenceById(id);
        supplier.deleteActive();
    }

}
