package myMath;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonomTest_junit {


    @Test
    public void derivative()  {
        Monom x= new Monom(0,0);
        Monom y= new Monom(0,0);
        x.set_coefficient(5);
        x.set_power(2);
        x=x.derivative();
        y.set_coefficient(10);
        y.set_power(1);
        assertEquals(x,y);

    }

    @Test
    public void f() {
        double num=0;
        Monom x= new Monom("5x");
        num=x.f(2.0);
        assertEquals(10.0,num,0.000001);

    }

    @Test
    public void isZero() {
        Monom y= new Monom("0");
        assertEquals(new Monom(0,0),y);
    }

    @Test
    public void add() {
        Monom x= new Monom(2,2);
        Monom y= new Monom(8,2);
        x.add(y);
        Monom temp = new Monom("10x^2");
        assertEquals(x,temp);
    }

    @Test
    public void multipy() {
        Monom x= new Monom(8,2);
        Monom y= new Monom(2,3);
        x.multipy(y);
        Monom temp = new Monom("16x^5");
        assertEquals(x,temp);
        temp=x.derivative();
        assertNotEquals(x,new Monom("16x"));
    }
}