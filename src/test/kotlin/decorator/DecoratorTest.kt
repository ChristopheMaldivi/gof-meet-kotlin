package decorator

import org.junit.Assert.assertEquals
import org.junit.Test

typealias TaxSubstractor = (Double) -> Double

fun (TaxSubstractor).andThen(f: TaxSubstractor): TaxSubstractor {
  return { t -> f(this(t))}
}

class DecoratorTest {

  @Test
  fun `compute salary per month`() {
    // given
    val annualSalary = 30000.0
    val computeSalaryPerMonth = { salary: Double -> salary / 12 }

    // when
    val salaryPerMonth = computeSalaryPerMonth(annualSalary)

    // then
    assertEquals(salaryPerMonth, 2500.0, 0.001)
  }

  @Test
  fun `compute salary per month less general then regional then health insurance taxes`() {
    // given
    val annualSalary = 30000.0

    val computeSalaryPerMonth = { salary: Double -> salary / 12 }
    val lessGeneralTax = { salary: Double -> salary * 0.8 }
    val lessRegionalTax = { salary: Double -> salary * 0.95 }
    val lessHealthInsuranceTax = { salary: Double -> salary - 200 }

    val taxes = computeSalaryPerMonth
      .andThen(lessGeneralTax)
      .andThen(lessRegionalTax)
      .andThen(lessHealthInsuranceTax)

    // when
    val salaryPerMonthLessTaxes = taxes(annualSalary)

    // then
    assertEquals(salaryPerMonthLessTaxes, 1700.0, 0.001)
  }

  @Test
  fun `compute salary per month less general then regional then health insurance taxes 2`() {
    // given
    val annualSalary = 30000.0

    val computeSalaryPerMonth = { salary: Double -> salary / 12 }
    val lessGeneralTax = { salary: Double -> salary * 0.8 }
    val lessRegionalTax = { salary: Double -> salary * 0.95 }
    val lessHealthInsuranceTax = { salary: Double -> salary - 200 }

    val taxes = listOf(computeSalaryPerMonth, lessGeneralTax, lessRegionalTax, lessHealthInsuranceTax)

    // when
    var salaryPerMonthLessTaxes = annualSalary
    taxes.forEach({ it(salaryPerMonthLessTaxes) })

    // then
    assertEquals(salaryPerMonthLessTaxes, 1700.0, 0.001)
  }
}
