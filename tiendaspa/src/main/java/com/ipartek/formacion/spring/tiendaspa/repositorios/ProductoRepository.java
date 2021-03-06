package com.ipartek.formacion.spring.tiendaspa.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;
import java.util.List;

import com.ipartek.formacion.spring.tiendaspa.entidades.Producto;

@CrossOrigin(origins = "*")
// excerptProjection = ProductoProjection.class
// Activa la visualización de los elementos de tipo producto a través de la proyección pero sólo en las colecciones no individualmente
// Para la visualización de un elemento individual necesitamos añadir ?projection=nameDeLaProyeccion a la petición individual
@RepositoryRestResource(collectionResourceRel = "productos", path = "productos")
public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long>{
    // Podríamos haber utilizado directamente la ruta /api/categorias/1/productos
    @Query("SELECT p FROM Producto p WHERE p.categoria.id = :id")
    List<Producto> findByCategoriaId(Long id);

    List<Producto> findByNombreContaining(String nombre);
    List<Producto> findByPrecioGreaterThanEqual(BigDecimal importe);

    @Query("SELECT p FROM Producto p WHERE p.categoria.id = :id AND p.nombre LIKE %:nombre%")
    List<Producto> findByNombreYCategoria(String nombre, Long id);
}
