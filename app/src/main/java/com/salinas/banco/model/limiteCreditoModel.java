package com.salinas.banco.model;


public class limiteCreditoModel {



    public android.widget.Toast Toast;
    //Datos del TDA
    private int tipoTargeta;
    private double limiteCredito;
    private double aumentoCredito;
    private double nuevoCredito;


    //Seters y Geters

    public int getTipoTargeta() {
        return tipoTargeta;
    }

    public void setTipoTargeta(int tipoTargeta) {
        this.tipoTargeta = tipoTargeta;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public double getAumentoCredito() {
        return aumentoCredito;
    }

    public void setAumentoCredito(double aumentoCredito) {
        this.aumentoCredito = aumentoCredito;
    }

    public double getNuevoCredito() {
        return nuevoCredito;
    }

    public void setNuevoCredito(double nuevoCredito) {
        this.nuevoCredito = nuevoCredito;
    }




    //Operaciones
    public String calcularNuevoCredito() {

        String resultadoPrecioVenta = "";

        if(tipoTargeta==1){
            aumentoCredito=limiteCredito*0.25;
        }else if(tipoTargeta==2){
            aumentoCredito=limiteCredito*0.35;
        }else if(tipoTargeta==3){
            aumentoCredito=limiteCredito*0.40;
        }else{
            aumentoCredito=limiteCredito*0.50;
        }

        nuevoCredito=limiteCredito+aumentoCredito;

        resultadoPrecioVenta="El aumento de Credito: " + aumentoCredito +
                "\nNuevo Limite de Credito: " + nuevoCredito;

        return resultadoPrecioVenta;
    }


}
