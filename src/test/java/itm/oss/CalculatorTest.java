package itm.oss;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Calculator tests for OSS class")
class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    @DisplayName("Test for function add")
    void testAdd() {
        assertEquals(10, calc.add(5, 5), "5 + 5 should be 10");
    }

    @Test
    @DisplayName("Testing function isPrime with 5")
    void isFivePrime() {
        assertTrue(calc.isPrime(5), "5 is prime.");
    }

    @Test
    @DisplayName("Testing function isPrime with 4")
    void isFourPrime() {
        assertFalse(calc.isPrime(4), "4 is not prime.");
    }

    @Test
    @DisplayName("Testing function isPrime with 0")
    void isZeroNotPrime() {
        assertFalse(calc.isPrime(0), "0 is not prime.");
    }

    @Test
    @DisplayName("Testing function isPrime with negative numbers")
    void testNegativeNumbers() {
        assertFalse(calc.isPrime(-1), "There are not negative primer numbers.");
        assertFalse(calc.isPrime(-2), "There are not negative primer numbers.");
        assertFalse(calc.isPrime(-3), "There are not negative primer numbers.");
        assertFalse(calc.isPrime(-4), "There are not negative primer numbers.");
        assertFalse(calc.isPrime(-5), "There are not negative primer numbers.");
    }
        // ===== 추가한 테스트 =====

    @Test
    @DisplayName("Test for function subtract")
    void testSubtract() {
        assertEquals(3, calc.subtract(5, 2), "5 - 2 should be 3");
    }

    @Test
    @DisplayName("Test for function multiply")
    void testMultiply() {
        assertEquals(20, calc.multiply(4, 5), "4 * 5 should be 20");
    }

    @Test
    @DisplayName("Test for function divide")
    void testDivide() {
        assertEquals(2.5, calc.divide(5, 2), 1e-9, "5 / 2 should be 2.5");
    }

    @Test
    @DisplayName("Divide by zero should throw exception")
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(1, 0));
    }

    // ❌ 실패 예정 1: 버그 때문에 7이 아니라 6이 나옴
    @Test
    @DisplayName("Next prime after 5 should be 7")
    void testNextPrimeAfterFive() {
        assertEquals(7, calc.getNextPrime(5), "The next prime after 5 is 7");
    }

    // ❌ 실패 예정 2: 무한 루프 → 1초 타임아웃으로 강제 종료
    @Test
    @DisplayName("Next prime after 4 should be 5 (with timeout)")
    void testNextPrimeAfterFour() {
        int result = assertTimeoutPreemptively(Duration.ofSeconds(1), () -> calc.getNextPrime(4));
        assertEquals(5, result, "The next prime after 4 is 5");
    }

}
