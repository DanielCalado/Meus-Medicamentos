package com.example.myapplication.model;

public class CalcularMedidas {

    public Object calcularGotejamento(double a, double b){
        if(a > 0 && b >0) {
            double result = a / (b / 60);
            return  result;
        }
        return null;
    }
    public Object regraDeTres(double a, double b, double c){
        if(a> 0 && b>0 & c>0) {
            double result = (c * a) / b;
            return result;
        }
        return null;
    }
}
