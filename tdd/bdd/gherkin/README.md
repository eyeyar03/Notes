# Gherkin

- Gherkin is a set of grammar rules structured in a certain way.
- Written in human-readable language.
- Certain rules and syntax for automated tests.

## Keywords

### FEATURE

- High level software feature or epic.
- Grouping related scenarios together.

FEATURE has 3 things:
- SUMMARY
	- One line summary for the feature.
	
- DESCRIPTION
	- Multi-line description describing feature in more detail.
	- Completely optional but recommended.
	- Inclusion allows for summary to be more terse.
	
- LIST OF SCENARIOS
	- All related scenarios that make up the feature
	
### SCENARIO

- Has an alias of "EXAMPLE" in some implementations.
- The situation that can be tested, a concrete example that illustrates a business rule.

SCENARIO has 3 things:
- SUMMARY
	- One line summary for the scenario (example).
	
- DESCRIPTION
	- Multi-line description describing scenario in more detail.
	- Completely optional but recommended.
	- Inclusion allows for scenario to be more terse.
	
- LIST OF STEPS
	- A scenario should contain a list of steps to validate the software.
	
### GIVEN

- Describes the intial context of the situation / The "scene" of the scenario.
- Usually something that happened in the past.
- Puts system into a known state.

### WHEN

- Describes the event or the action.
- Triggered by an ACTOR whether a person or another system.

### THEN

- Describes the result or expected outcome.
- Output that is observable.

### AND

- Can be used in place of multiple GIVEN, WHEN or THEN.

### BUT

- Can be used when the expected result is implied negative.

### * (asterisk)

- Can be used if there is list of things.


## Secondary Keywords

### RULE

- Groups one or more scenarios together under same business rule.
- Simply a grouping mechanism.
- Optional keyword.
- Added in Gherkin 6 so not always available in Cucumber.

### BACKGROUND

- Background section used to prevent need to repeat GIVEN statements if shared across all scenarios.

### SCENARIO OUTLINE/EXAMPLES

- Provides ability to run same scenario multiple times with different combinations of values, aka, SCENARIO TEMPLATE.

### @ (TAG)

- Can be used to categorize a scenario or feature.
- @IGNORE  is a reserved special tag. Any scenario or feature with this tag will not be executed by Cucumber.

### COMMENT

- Comments start with the # symbol.

### DOC STRINGS

- Used for large piece of text.
- Start and end with 3 double quote or 3 back ticks.

### DATATABLES

- Used to pass a list of values into a step.


### #LANGUAGE

- Gherkin supports 70 human languages.
- Use #LANGUAGE and then 2 letter ISO country code.


## Rules of Keywords

- Keyword should be at the start of the line.
- Keyword should not follow another keyword.

## Notes
- Udemy: https://cognizant.udemy.com/course/gherkin-language-the-master-guide/learn/lecture/30950902?start=105#overview
- Online Editor: https://app.specflow.org/gherkin-editor





