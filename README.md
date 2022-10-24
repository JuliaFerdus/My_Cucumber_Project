# My_Cucumber_Project
CucumberBDD FW with Selenium WD, Maven, Jenkins ect

# How to run
mvn verify -Denv=qa -Dbrowser=ch -Dcucumber.filter.tags="@test"
# How to run test in default env and browser
mvn verify -Dcucumber.filter.tags="@login"