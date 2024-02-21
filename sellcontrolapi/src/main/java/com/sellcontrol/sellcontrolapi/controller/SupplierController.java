package com.sellcontrol.sellcontrolapi.controller;


import com.sellcontrol.sellcontrolapi.domain.supplier.dto.DataListSupplier;
import com.sellcontrol.sellcontrolapi.domain.supplier.dto.DataReturnUpdateSupplier;
import com.sellcontrol.sellcontrolapi.domain.supplier.dto.DataSuppliersForm;
import com.sellcontrol.sellcontrolapi.domain.supplier.dto.DataSuppliersUpdate;
import com.sellcontrol.sellcontrolapi.domain.supplier.model.Supplier;
import com.sellcontrol.sellcontrolapi.domain.supplier.repository.SupplierRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    @Autowired
    private SupplierRepository supplierRepository;
    @GetMapping
    public ResponseEntity<Page<DataListSupplier>> read(@PageableDefault(size=10, sort= {"razaoSocial"}) Pageable pagination){
        var page = supplierRepository.findAllByAtivoTrue(pagination).map(DataListSupplier::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detailSupplier(@PathVariable Long id) {
        var supplier = supplierRepository.getReferenceById(id);

        return ResponseEntity.ok(new DataListSupplier(supplier));
    }

    @PostMapping
    @Transactional //Precisa escrever no Banco de Dados
    public ResponseEntity insertSupplier(@RequestBody @Valid DataSuppliersForm data, UriComponentsBuilder uriBuilder) {
        var supplier = new Supplier(data);
        supplierRepository.save(supplier);

        var uri = uriBuilder.path("/suppliers/{id}").buildAndExpand(supplier.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataReturnUpdateSupplier(supplier));
    }

    @PutMapping
    @Transactional //Precisa escrever no Banco de Dados
    public ResponseEntity update(@RequestBody @Valid DataSuppliersUpdate data) {
        var supplier = supplierRepository.getReferenceById(data.id());
        supplier.updateInfo(data);

        return ResponseEntity.ok(new DataReturnUpdateSupplier(supplier));
    }

    @DeleteMapping("/{id}")
    @Transactional //Precisa escrever no Banco de Dados
    public ResponseEntity delete(@PathVariable Long id) {
        var supplier = supplierRepository.getReferenceById(id);
        supplier.deleteActive();
        return ResponseEntity.noContent().build();
    }

}
