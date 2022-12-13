package com.example.myapplication;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.myapplication.model.CalcularMedidas;

@RunWith(AndroidJUnit4.class)
public class CalcularMedidasTest {
    CalcularMedidas med;
    double a;
    double b;
    double c;
    public CalcularMedidasTest(){
        med = new CalcularMedidas();
    }
    @Test
    public void deveTestarNumerosNegativosNoGotejamentoTest(){
        a = -1;
        b = -1;
        assertNull(med.calcularGotejamento(a,b));
    }

    @Test
    public void deveTestarNumeroZeroNoGotejamentoTest(){
        a = 0;
        b = 0;
        assertNull(med.calcularGotejamento(a,b));
    }

    @Test
    public void deveTestarNumerosPositivosNoGotejamentoTest(){
        a = 5;
        b = 5;
        assertEquals(med.calcularGotejamento(a,b),60.0);
    }

    @Test
    public void deveTestarNumerosNegativosNaRegradeTresTest(){
        a = -1;
        b = -1;
        c = -1;
        assertNull(med.regraDeTres(a,b,c));
    }

    @Test
    public void deveTestarNumeroZeroNaRegradeTresTest(){
        a = 0;
        b = 0;
        c = 0;
        assertNull(med.regraDeTres(a,b,c));
    }

    @Test
    public void deveTestarNumerosPositivosNaRegradeTresTest(){
        a = 54;
        b = 5;
        c = 3;
        assertEquals(med.regraDeTres(a,b,c),32.4);
    }
}
