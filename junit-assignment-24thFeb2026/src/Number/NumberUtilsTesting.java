package Number;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberUtilsTesting {

	NumberUtils utils = new NumberUtils();

    // 1️⃣ ValueSource
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 100})
    void testIsPositive(int number) {
        assertTrue(utils.isPositive(number));
    }

    // 2️⃣ CsvSource
    @ParameterizedTest
    @CsvSource({
        "2,4",
        "3,9",
        "4,16",
        "5,25"
    })
    void testSquare(int input, int expected) {
        assertEquals(expected, utils.square(input));
    }

    // 3️⃣ MethodSource
    @ParameterizedTest
    @MethodSource("numberProvider")
    void testSquareUsingMethodSource(int input, int expected) {
        assertEquals(expected, utils.square(input));
    }

    static Stream<Arguments> numberProvider() {
        return Stream.of(
            Arguments.of(6, 36),
            Arguments.of(7, 49),
            Arguments.of(8, 64)
        );
    }
}

