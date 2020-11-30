# Basic unit tests with TestNg

TestNg is a testing framework that adds annotation and assertions for quickly testing code.

### Getting started with annotations
- `@Test` Marking a method with this annotation tells testng to run this method
- `@BeforeTest` Runs before every test
- `@AfterTest` Run this after every test
- `@BeforeClass` Runs before all tests in the class
- `@AfterClass` Runs after all tests in the class

### What do you do with this?
- Write tests that check the input and output of functions
- Write an `Assert` to check if the output matches the output you expect
- Can tell if your code is programatically correct
- Won't magically figure out if your code is right, correct unit tests need to be written