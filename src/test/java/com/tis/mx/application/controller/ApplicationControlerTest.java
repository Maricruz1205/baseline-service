/* 
* This program is free software: you can redistribute it and/or modify  
* it under the terms of the GNU General Public License as published by  
* the Free Software Foundation, version 3.
*
* This program is distributed in the hope that it will be useful, but 
* WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
* General Public License for more details.
*
* Nombre de archivo: ApplicationControlerTest.java
* Autor: maricjim
* Fecha de creación: 9 sep. 2021
*/
package com.tis.mx.application.controller;


import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import com.tis.mx.application.service.CompoundInterestCalculator;
import com.tis.mx.application.service.impl.CompoundInterestCalculatorImpl;

/**
 * The Class ApplicationControlerTest.
 */
public class ApplicationControlerTest {


  /** The controller. */
  private ApplicationController controller;

  /** The initial investment. */
  private InitialInvestmentDto initialInvestment;

  /** The calculator. */
  private CompoundInterestCalculator calculator;

  /**
   * Creates the values before to test.
   */
  @Before
  public void createValuesBeforeToTest() {
    // crear una calculadora
    this.calculator = new CompoundInterestCalculatorImpl();
    // creo controlador con dependecia de calculadora
    this.controller = new ApplicationController(this.calculator);

    // crear los valores iniciales de la iversion
    this.initialInvestment = new InitialInvestmentDto();

    this.initialInvestment.setInitialInvestment(5000.00);
    this.initialInvestment.setYearlyInput(Double.valueOf(3000.00));
    this.initialInvestment.setYearlyInputIncrement(Integer.valueOf(1));
    this.initialInvestment.setInvestmentYears(5);
    this.initialInvestment.setInvestmentYield(Float.valueOf(0.21f));


  }


  /**
   * Should generate table yield.
   */
  @Test
  public void shouldGenerateTableYield() {
    List<InvestmentYieldDto> tableYield = controller.createTableYield(initialInvestment);

    assertEquals(5, tableYield.size());

    InvestmentYieldDto firstYear = tableYield.get(0);
    assertEquals(Double.valueOf(5000.00), firstYear.getInitialInvestment());
    assertEquals(Double.valueOf(3000.00), firstYear.getYearlyInput());
    assertEquals(Double.valueOf(5000.00), firstYear.getInvestmentYield());
    assertEquals(Double.valueOf(5000.00), firstYear.getFinalBalance());


  }
}
