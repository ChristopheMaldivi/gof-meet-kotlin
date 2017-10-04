package decorator

import org.junit.Assert.assertEquals
import org.junit.Test

class DecoratorTest {

  @Test
  fun `compute salary per month`() {
    // given
    val annualSalary = 30000.0

    // => FILL LAMBDA FUNCTION BELOW!
    val computeSalaryPerMonth = null

    // when
    val salaryPerMonth = 0.0 // => UNCOMMENT! computeSalaryPerMonth(annualSalary)

    // then
    assertEquals(salaryPerMonth, 2500.0, 0.001)
  }

  @Test
  fun `compute salary per month less general then regional then health insurance taxes`() {
    // given
    val annualSalary = 30000.0

    // => FILL LAMBDA FUNCTIONS BELOW!
    val computeSalaryPerMonth = null
    val lessGeneralTax = null
    val lessRegionalTax = null
    val lessHealthInsuranceTax = null

    // => UNCOMMENT!
    // NB:
    //  - you need to implement a typealias for these lambdas
    //  - and then to extend this typealias with the 'andThen' function...
    /*val taxes = computeSalaryPerMonth
      .andThen(lessGeneralTax)
      .andThen(lessRegionalTax)
      .andThen(lessHealthInsuranceTax)*/

    // when
    val salaryPerMonthLessTaxes = 0.0 // => UNCOMMENT! taxes(annualSalary)

    // then
    assertEquals(salaryPerMonthLessTaxes, 1700.0, 0.001)
  }

  @Test
  fun `compute salary per month less general then regional then health insurance taxes 2`() {
    // given
    val annualSalary = 30000.0

    // => FILL LAMBDA FUNCTIONS BELOW!
    val computeSalaryPerMonth = null
    val lessGeneralTax = null
    val lessRegionalTax = null
    val lessHealthInsuranceTax = null

    val taxes = listOf(computeSalaryPerMonth, lessGeneralTax, lessRegionalTax, lessHealthInsuranceTax)

    // when
    var salaryPerMonthLessTaxes = annualSalary
    taxes.forEach({ /* ? */ })

    // then
    assertEquals(salaryPerMonthLessTaxes, 1700.0, 0.001)
  }
}
