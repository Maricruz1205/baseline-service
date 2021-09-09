/*
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * Nombre de archivo: ApplicationController.java Autor: maricjim Fecha de creación: 8 sep. 2021
 */

package com.tis.mx.application.controller;

import java.util.List;
import com.tis.mx.application.service.CompoundInterestCalculator;
import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;

public class ApplicationController {

  private CompoundInterestCalculator calculator;

  public ApplicationController(CompoundInterestCalculator calculator) {
    this.calculator = calculator;
  }

  public List<InvestmentYieldDto> createTableYield(InitialInvestmentDto initialInvestment) {
    if (calculator.validateInput(initialInvestment)) {
      return calculator.createRevenueGrid(initialInvestment);
    }
    throw new CalculatorInputException("El calculo no puede ser ejecutado");
  }

}
