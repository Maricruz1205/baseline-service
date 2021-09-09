/*
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * Nombre de archivo: InitialInvestmentDto.java Autor: maricjim Fecha de creación: 8 sep. 2021
 */
package com.tis.mx.application.dto;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class InitialInvestmentDto {

  public double initialInvestment = 1000;
  public double yearlyInput = 0 * 12;
  public int yearlyInputIncrement = 12 * 0;
  public float investmentYield;
  public int investmentYears;


}
