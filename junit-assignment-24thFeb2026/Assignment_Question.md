# JUnit Assignment

## Assignment 1: Parameterized Tests

### Production Code

Create a class `NumberUtils` with the following methods:

- `boolean isPositive(int number)` → returns true if the number is greater than 0.
- `int square(int number)` → returns the square of the given number.

### Tasks

1. Use **@ParameterizedTest** with **@ValueSource** to test:

   - `isPositive()` for multiple positive values.
2. Use **@CsvSource** to test:

   - `square()` for multiple input-output combinations.
3. Use **@MethodSource** to provide:

   - At least 3 test cases dynamically.

---

## Assignment 2: EnumSource

### Production Code

Create an enum `OrderStatus` with the following values:

- NEW
- PROCESSING
- COMPLETED
- CANCELLED

Create a class `OrderService` with the following method:

- `boolean canCancel(OrderStatus status)` → returns true only if the order status is `NEW`.

### Tasks

1. Use **@EnumSource** to test all enum values.
2. Verify that:
   - Only `NEW` can be cancelled.
   - All other statuses return `false`.
