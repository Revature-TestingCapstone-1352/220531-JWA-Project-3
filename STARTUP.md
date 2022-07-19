# Project Description

In order to get this project to your local machine, you will need to have the following Software and do the next steps.

The first thing to do is to install gitbash on your local machine and clone the repository, both of them.
*	Backend: https://github.com/Revature-Capstone-1328/Game-Galaxy-Backend.git
*	Frontend: https://github.com/Revature-Capstone-1328/Game-Galaxy-Frontend.git

## Backend

1.	The first thing you have to do is to install/open Eclipse and open the project from your local machine.
2.	Then you will have to go to Eclipse Marketplace (Help->Eclipse Marketplace) and install the Spring Tools 4. Since the project was built in SpringBoot you will need the SpringBoot plugin
3.	After the installation of the SpringTools 4 you can go to the tab Open File and open the project you just cloned.
4.	The next step is to create a Database in PostgreSQL to store the data from the application. 
5.	After you created the database you will need to change the #Database Creds in the application.properties with your Database URL, username, and password.  The application.properties it is in the src/main/resources in the java application.
6.	The only thing that is remaining now is to run the application as a SpringBoot Application and the backend should be running.


## Frontend

1.	You will need to install Visual Studio Code in order to work on the Frontend application.
2.	Download and Install NodeJS from here: https://nodejs.org/en/download/
    *	Run the installer as administrator
    *	Be sure to check the "automatically install the necessary tools" when going through the installer. All other defaults are fine.
    *	After install run node -v and npm -v in gitbash to ensure they are installed and available.
3.	Use NPM to install the Angular CLI. Run this command in gitbash: npm install -g @angular/cli
    *	If you encounter an execution policy error you may need to run: Set-ExecutionPolicy -Scope CurrentUser -ExecutionPolicy RemoteSigned in powershell to grant permission.
    *	Run ng v to check that the Angular CLI was installed.
4.	Open Visual Studio Code and open a Terminal. To open a Terminal, you will have to click on the Terminal tab and open a New Terminal.
5.	In the terminal you will need the run the command npm install to install all the packages necessary.
6.	You also need the command for password Hashing:
    *	Run npm install bcryptjs
    *	npm install @types/bcryptjs
    *	The package.json should be updated, if not you will have to put the following code between "dependencies" and "devDependencies":  
        "browser": {  
        "crypto": false  
        },  
7.	We used pagination to show only a limited number of products. You will have to run the following CLI command: npm install ngx-pagination.
8.	In the end you just need to run ng serve -o to run the application on the server.


