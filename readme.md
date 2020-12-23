# Database Management System For Object Oriented Programming Fall Semester of 2020

Project uses Java, JavaFX, MySql. For good work of project you need to create database with name "db2". The tables are not required for creating.

Our project stores students into the MySQL table and projects into another table and links them. This makes to keep in track the who did the project, who did not and project name, description.


The first step was to creating a new project with template of JavaFX in IntelliJ IDEA. <br /><br />

<img src="./images/beginning%20of%20the%20app.png" alt="Beginning of the app" width="250"/><br />

<img src="./images/beginning%20of%20the%20code.png" alt="Beginning of the code" width="650"/><br />

Then we added Buttons to the main scene, so that we can link .fxml documents from the project. From main scene we go to scene, where all students in database are showed, where we can add student, where we can delete a student, where we can add project and projects will be assigned to the student id. This means in database we have 2 tables that are linked with "id" and "projectsId" columns. For each .fxml document we created controller, so the buttons and any other function on .fxml works.<br />



<img src="./images/Beginning%20btns.png" alt="" width="650"/><br />

<img src="./images/adding%20fxml.png" alt="" width="650"/><br />
<img src="./images/adding%20controllers.png" alt="" width="650"/><br />
<img src="./images/adding%20fxml%202.png" alt="" width="650"/><br />
<img src="./images/adding%20controller%202.png" alt="" width="650"/><br />


Then we injected database and wrote some syntax of MySQL in controllers to edit the tables "students" and "projects".
