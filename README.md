# CloudStaffExam

1. For computer-database Manual test cases

TC001 - Validate that user can add a new computer on the Computer database
data:
        name = "JC";
        introduced = "2020-09-16";
        discontinued = "2021-09-16";
        company = "IBM";

steps:
1. open http://computer-database.gatling.io/computers
2. click add new computer
3. fill up form with data above
4. click submit

expected result: 'Computer JC has been created'



TC002 - Validate search functionality when data is newly created
data:
        name = "JC";

steps:
1. open http://computer-database.gatling.io/computers
2. click add new computer
3. fill up form with data above
4. click submit
5. search created computer on the search field

expected result: Data searched  should be displayed


TC003 - Validate search functionality when data is already existing
data:
        name = "ASCI Blue Mountain";

steps:
1. open http://computer-database.gatling.io/computers
2. click add new computer
3. fill up form with data above
4. click submit
5. search created computer on the search field

expected result: Data searched should be displayed


TC004 - Validate edit/update functionality
data:
        name = "Amiga";

steps:
1. open http://computer-database.gatling.io/computers
2. search computer on the search field
3. click computer link
4. change computer name
5. click save

expected result: Computer name should be updated


TC005 - Validate delete functionality
data:
        name = "Amiga";

steps:
1. open http://computer-database.gatling.io/computers
2. search computer on the search field
3. click computer link
4. click delete

expected result: Computer name should be deleted




2. javascript_alerts manual test cases
  1. go to https://the-internet.herokuapp.com/javascript_alerts
	
  2. click 'Click for JS Alert' button then accept the alert
	Expected message: You successfully clicked an alert	

	3. click 'Click for JS Confirm' button then accept the alert
	Expected message: You clicked: Ok	

	4. click 'Click for JS Confirm' button then dismiss the alert
	Expected message: You clicked: Cancel

	5. click 'Click for JS Prompt'button then enter a text then click accept
	Expected message: You entered: Test

	6. click 'Click for JS Prompt'button then dismiss
	Expected message: You entered: null




Total time taken: approximately 2 hours
