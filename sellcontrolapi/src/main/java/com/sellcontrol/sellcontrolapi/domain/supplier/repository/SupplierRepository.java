package com.sellcontrol.sellcontrolapi.domain.supplier.repository;


import com.sellcontrol.sellcontrolapi.domain.supplier.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//DAO
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    Page<Supplier> findAllByAtivoTrue(Pageable pagination);
}
