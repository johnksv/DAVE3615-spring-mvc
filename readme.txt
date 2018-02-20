Assignment 2: Banking - Spring MVC, Hibernate, Spring Security
DAVE3615 - Software Architecture and Frameworks
By: John Kasper Svergja - s305089

To launch:
Unpack the zip to a destination of you choice.
Open a terminal in the directory
In the terminal run "./deploy.sh" (without quotes)
The script will shut down jetty (if running), start tomcat-server (if running), build and copy the .war-file to $CATALINA_HOME/webapps
The application is now available at http://localhost:8080/bank-asgmt2/

Troubleshoot:
Check that you are using tomcat, and that the war actually has been copied to the correct destination.

Features:
Log in and out with Spring security
Create accounts for the user
Apply for loans, both predefined and custom.
Deposit and withdraw money.

See FILENAME for ER-Diagram
