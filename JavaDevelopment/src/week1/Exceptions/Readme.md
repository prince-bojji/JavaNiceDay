# Exceptions

___Exceptions___ an event that occurs during the execution of the program that disrupts the formal flow of instructions.

### Types of Exceptions

1. ___Checked___ - Checked exceptions are called compile-time exceptions because these exceptions are checked at compile-time by the compiler.
```bash
try {
    // Code that might throw a checked exception
} catch (IOException e) {
    // Handle the IOException
}
```
[Sample Checked Exceptions Implementation](https://github.com/prince-bojji/JavaNiceDay/tree/main/JavaDevelopment/src/week1/Exceptions/CheckedExceptions.java)

2. ___Unchecked___ - The unchecked exceptions are just opposite to the checked exceptions. The compiler will not check these exceptions at compile time. In simple words, if a program throws an unchecked exception, and even if we didn’t handle or declare it, the program would not give a compilation error.
```bash
try {
    // Code that might throw a checked exception
} catch (IOExceptionArithmeticException e) {
    // Handle the ArithmeticException
}
```
[Sample Unchecked Exceptions Implementation](https://github.com/prince-bojji/JavaNiceDay/tree/main/JavaDevelopment/src/week1/Exceptions/UncheckedExceptions.java)

3. ___Error___ - Error is irrecoverable. Some example of errors are OutOfMemoryError, VirtualMachineError, AssertionError etc.
```bash
try {
    // Code that might throw an error
} catch (OutOfMemoryError e) {
    // Handle the OutOfMemoryError
}
```
[Sample Error Exceptions Implementation](https://github.com/prince-bojji/JavaNiceDay/tree/main/JavaDevelopment/src/week1/Exceptions/ErrorExceptions.java)

