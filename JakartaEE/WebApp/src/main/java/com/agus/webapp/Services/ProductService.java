package com.agus.webapp.Services;

import com.agus.webapp.Models.Producto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductService {

    public List<Producto> listar(){

        return Arrays.asList(new Producto(1, "Coca", "Gaseosa", 300),
                new Producto(2, "Pepsi", "Gaseosa", 150),
                new Producto(3, "Sprite", "Gaseosa", 110));
    }
}
