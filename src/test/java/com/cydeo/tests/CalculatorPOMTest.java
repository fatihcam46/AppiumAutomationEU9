package com.cydeo.tests;
//5
import com.cydeo.pages.CalculatorPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorPOMTest {

    CalculatorPage calculatorPage = new CalculatorPage();
//from public class CalculatorPage {....}
    /**
     * 5 * 8 = 40
     */
    @Test
    public void multiplyTest() {
        calculatorPage.clickSingleDigit(5);
        calculatorPage.multiply.click();
        calculatorPage.clickSingleDigit(8);//it is enough but you can continue
        calculatorPage.equals.click();
        String result = calculatorPage.result.getText();

        System.out.println("result = " + result);//5*8=40  result = 40
//  from driver >>>https://cybertek-appium.s3.amazonaws.com/calculator.apk
//from  public class CalculatorPage {....}
        assertEquals(40, Integer.parseInt(result) );
    }

}
