# CS-320
Welcome to the CS-320 organization. This repository contains projects I developed as part of the CS-320 Software Testing course at Southern New Hampshire University. This class focused on applying software testing strategies across the SDLC—requirements analysis, verification and validation, and quality management—with an emphasis on writing effective unit tests.

## About the Course

CS-320 emphasizes creating tests that uncover errors, analyzing testing approaches based on requirements, and applying appropriate test strategies to meet those requirements. The work here reflects practical testing with JUnit 5, coverage analysis, and communicating results clearly.

## What You’ll Find Here

- Project One: Service Implementations + Tests
- Contact.java, ContactService.java, ContactTest.java, ContactServiceTest.java
- Project Two: Summary & Reflections Report: 
A written analysis covering test approach, quality/coverage, techniques used (and not used), and professional testing mindset. 

## Why This Project Matters

These artifacts show that I can translate requirements into code that’s testable, validate behavior with focused unit tests, measure coverage, and reflect on test effectiveness. The result is software that’s more reliable, secure, and easier to maintain.

## Reflection

**How can I ensure that my code, program, or software is functional and secure?**

I design with validation and testing up front: constructors and mutators enforce input rules, while JUnit tests cover both success paths and negative/boundary cases (e.g., length limits, exact phone formats, and non-past dates). Maintaining high coverage across classes helps catch regressions early, and fast, isolated tests make it practical to run them often. In my CS-320 work, I achieved >80% overall coverage with production classes reaching 100%, pairing that with disciplined negative testing to guard against bad inputs. 

**How do I interpret user needs and incorporate them into a program?**

I start from plain-language requirements and turn them into testable rules. For example, “IDs ≤ 10 chars,” “phone = 10 digits,” and “appointments cannot be in the past” became explicit validation plus tests that prove both acceptance (valid data) and rejection (too long, malformed, or past dates). Mapping roles and use cases to concrete assertions keeps features aligned with what users actually need. 

**How do I approach designing software?**

I prefer an iterative, test-first mindset: sketch requirements → write focused, deterministic tests (arrange-act-assert) → implement minimal code to pass → expand with boundaries and edge cases. I track coverage to reveal untested branches and remove low-value tests that don’t add confidence. When external dependencies appear, I plan to layer in integration/mocking where it makes sense; for this in-memory project, unit tests were sufficient. 

## Future Applications

Going forward I’ll keep leaning on small, isolated tests, meaningful boundaries, and coverage monitoring to keep quality high without slowing delivery. When systems involve databases, services, or queues, I’ll extend this foundation with mocks and integration tests to verify interactions while staying CI-friendly.
