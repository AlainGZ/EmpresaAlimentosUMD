
package com.mycompany.empresaalimentosumd.SistemaCache;

import com.mycompany.empresaalimentosumd.TransaccionesDistribuidas.Sucursales;
import java.util.HashMap;
import java.util.Map;


public class CacheBranch {
    private static Map<Integer, Sucursales> cache = new HashMap<>();

    public static Sucursales getSucursal(int idSucursal) {
        return cache.get(idSucursal);
    }

    public static void addSucursal(Sucursales sucursal) {
        cache.put(sucursal.getIdSucursal(), sucursal);
    }
}
