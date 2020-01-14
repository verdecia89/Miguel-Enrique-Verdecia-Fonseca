/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaonreadytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Miguel
 */
abstract class Vehiculo {

    protected String marca;
    protected String modelo;
    protected Double precio;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, Double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}

class Auto extends Vehiculo {

    private Integer cantidadPuertas = 0;

    public Auto() {
    }

    public Auto(String marca, String modelo, Double precio, Integer cantidadPuertas) {
        super(marca, modelo, precio);
        this.cantidadPuertas = cantidadPuertas;
    }

    public Integer getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(Integer cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public String toString() {
        return "Marca: " + this.marca + " Modelo: " + this.modelo + " Puertas: " + this.cantidadPuertas + " Precio: " + this.precio;
    }
}

class Moto extends Vehiculo {

    private Integer cilindrada;

    public Moto() {
    }

    public Moto(String marca, String modelo, Double precio, Integer cilindrada) {
        super(marca, modelo, precio);
        this.cilindrada = cilindrada;
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Marca: " + this.marca + " Modelo: " + this.modelo + " Cilindrada: " + this.cilindrada + " Precio: " + this.precio;
    }
}

interface IVehiculo {

    void masCaro();

    void masBarato();

    void contieneLetra(String c);
}

public class JavaOnReadyTest implements IVehiculo {

    private List<Vehiculo> listaVehiculos = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        JavaOnReadyTest onReady = new JavaOnReadyTest();
        onReady.insertar(new Auto("Peugeot", "206", 200000.00, 4));
        onReady.insertar(new Moto("Honda", "Titan", 60000.00, 125));
        onReady.insertar(new Auto("Peugeot", "208", 250000.00, 5));
        onReady.insertar(new Moto("Yamaha", "YBR", 80500.50, 160));
        onReady.imprimirLista();
        Thread.sleep(1000);
        System.out.println("=============================");
        Thread.sleep(1000);
        onReady.masCaro();
        onReady.masBarato();
        Thread.sleep(1000);
        onReady.contieneLetra("Y");
        Thread.sleep(1000);
        System.out.println("=============================");
        Thread.sleep(1000);
        onReady.ordenar();
    }

    public void insertar(Vehiculo v) {
        this.listaVehiculos.add(v);
    }

    public void imprimirLista() {
        for (Vehiculo obj : listaVehiculos) {
            System.out.println(obj.toString());
        }
    }

    public void ordenar() {
        Collections.sort(listaVehiculos, (Vehiculo v1, Vehiculo v2) -> v2.getPrecio().compareTo(v1.getPrecio()));
        this.imprimirLista();
    }

    @Override
    public void masCaro() {
        Vehiculo objTmp = null;
        for (Vehiculo obj : listaVehiculos) {
            if (objTmp == null) {
                objTmp = obj;
                continue;
            }
            if (objTmp.getPrecio() < obj.getPrecio()) {
                objTmp = obj;
            }
        }
        System.err.println("Vehículo más caro: " + objTmp.getMarca() + " " + objTmp.getModelo());
    }

    @Override
    public void masBarato() {
        Vehiculo objTmp = null;
        for (Vehiculo obj : listaVehiculos) {
            if (objTmp == null) {
                objTmp = obj;
                continue;
            }
            if (objTmp.getPrecio() > obj.getPrecio()) {
                objTmp = obj;
            }
        }
        System.err.println("Vehículo más barato: " + objTmp.getMarca() + " " + objTmp.getModelo());
    }

    @Override
    public void contieneLetra(String c) {
        for (Vehiculo obj : listaVehiculos) {
            if (obj.getModelo().contains(c)) {
                System.out.println("Vehículo que contiene en el modelo la letra ‘Y’: " + obj.getMarca() + " " + obj.getModelo() + " $" + obj.getPrecio().toString());
                break;
            }
        }
    }
}
