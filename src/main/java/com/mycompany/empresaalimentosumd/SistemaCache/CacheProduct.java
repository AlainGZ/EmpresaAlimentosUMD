
package com.mycompany.empresaalimentosumd.SistemaCache;

import com.mycompany.empresaalimentosumd.TransaccionesDistribuidas.Productos;
import java.util.HashMap;
import java.util.Map;

//@AlainGomez

public class CacheProduct {
     private static Map<Integer, Productos> cache = new HashMap<>();

    public static Productos getProducto(int idProducto) {
        return cache.get(idProducto);
    }

    public static void addProducto(Productos producto) {
        cache.put(producto.getIdProducto(), producto);
    }
}
