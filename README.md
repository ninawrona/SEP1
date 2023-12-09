# Semester 1 project: Timetable Planning Tool
Mastery of single user systems is critical for students starting their software engineering journey. This is a timetable planning tool that is implemented in Java. The application UI is created using Java FX and there is an accompanying web page to show the information, which uses jQuery, HTML, and CSS.

![image](https://github.com/ninawrona/SEP1/assets/92271155/287f06f1-3740-419d-892b-c0abfc9d0f75)
![image](https://github.com/ninawrona/SEP1/assets/92271155/730c32d1-a121-4164-a983-cf2de67e74b3)

# Table of contents

# The problem
At VIA University College in Horsens, Bob manages the intricate task of creating timetables for software engineering courses, a significant challenge given the field's high enrollment. The process begins with a document from the department head, detailing student enrollment, teachers, courses, and ECTS values. Bob must manually adjust for individual student transcripts and incorporate teachers' preferences, leading to a time-consuming and stressful task.

Room assignments require meticulous planning to avoid overlaps, and the final timetable undergoes reviews and updates throughout the semester, consuming valuable time. The current method allows all users to view timetables without authentication, hindering efficiency. Moreover, the recent campus move with limited rooms exacerbates the challenges, echoing a case study at Worcester Polytechnic Institute.

Existing market solutions fall short due to their inability to handle special room configurations and courses with multiple teachers. Outdated interfaces further complicate usability, aligning with a systematic review highlighting the inflexibility of current tools for higher education institutions.

In summary, Bob's current method demands excessive manual data entry, creating obstacles to an efficient timetable.

# Key features
## 1. Schedules for class groups
At VIA University College, software engineering students are split into multiple class groups where divisions of approximately 35 students have the same classes together to foster collaboration. Typically, there are 3 classes for international students taking English courses: X, Y, and Z. Danish students are placed in the DK class. In these class groups, their courses need to be schedule so that they do not conflict.
## 2. Individual schedules for teachers and students
Exchange students as well as students that enter university with transfer credits need customized schedules, so their timetable reflects the classes they need to show up to. As such, it is critical that individual schedules can be modified outside of their class group. Additionally, teachers need to be scheduled for courses, so conflicts in their individual schedule must be avoided using the planning tool.
## 3. Booking rooms for sessions
Although the project was implemented toward the tail end of the pandemic in Denmark, each session of a courses needed to take place within a class room. As such, bookings can't overlap on the same room.
![image](https://github.com/ninawrona/SEP1/assets/92271155/8e1b8542-f55f-4532-afe5-588f48f148f2)
## 4. Editing the schedule
It should be possible to edit or remove the sessions. As an introductory project, CRUD (create, read, update, and delete) operations are vital to understand.
## 5. Web page for viewing the schedule
While the planner can use the planning tool (the Java application), students and teachers also need to see their schedules. As such, there is a web page that allows them to view their schedules.
![image](https://github.com/ninawrona/SEP1/assets/92271155/ba947c88-042d-4347-8764-85fe2352662b)
## 6. Danish and english localization
The web pages are available in both English and Danish. In addition, the schedule can be navigated by week number, which is a more popular alternative that describes when an event occurs in the year using a number between 1 and 52.

**English:**
![image](https://github.com/ninawrona/SEP1/assets/92271155/a739038d-c623-409c-af78-b2c9045bdcee)

**Danish:**
![image](https://github.com/ninawrona/SEP1/assets/92271155/11f42fe9-625c-433e-9099-64be892781f8)

## 7. Importing students, courses, and rooms
The planner should be able to import text files that contains information about students, courses, and rooms. This is more convinient than having to enter the information manually, and more configurable than hard coding the values.
![image](https://github.com/ninawrona/SEP1/assets/92271155/e5f36171-126e-4a70-bff3-4cb47dd24abe)

The format of the files should be as comma seperated values, however .csv files are not accepted yet. 
![image](https://github.com/ninawrona/SEP1/assets/92271155/c9c9b390-ff20-4b95-a0b1-103e0f135c10)

# Technologies
## 1. Java 11
Java serves as the backbone of the timetable planning tool, handling the core logic and functionality. It manages tasks such as parsing input data, processing schedule requests, handling room assignments, and implementing any necessary algorithms for optimizing the timetable. Java's object-oriented nature allows for a structured and modular codebase, making it easier to maintain and extend the application.

## 2. JavaFX 17
JavaFX is employed for the graphical user interface (GUI) of the timetable planning tool. It provides a platform-independent framework for creating rich, interactive interfaces, allowing users to intuitively interact with the application. JavaFX's capabilities enable the creation of responsive and visually appealing UI components, enhancing the overall user experience.

## 3. HTML
HTML is utilized for the web-based aspect of the timetable planning tool. It plays a crucial role in creating the structure of web pages where users can view and interact with their schedules. HTML is responsible for defining the content, layout, and structure of the web pages, ensuring compatibility across various web browsers.

## 4. CSS
CSS complements HTML by handling the styling and presentation of the web-based interface. It allows for the customization of fonts, colors, layouts, and other visual aspects, ensuring a consistent and visually appealing appearance. CSS enhances the user interface's aesthetics and usability, contributing to a more engaging and user-friendly experience.

## 5. jQuery
jQuery is employed to simplify and enhance the client-side scripting within the HTML pages. It streamlines tasks such as DOM manipulation, event handling, and asynchronous communication with the server. jQuery's concise syntax and cross-browser compatibility make it a valuable tool for creating dynamic and responsive web interfaces, contributing to a seamless user experience.

## 6. XML
XML is used as a lightweight, portable alternative to a traditional database for persisting schedules. Instead of relying on a database management system, XML allows for the structured storage of schedule data. This choice may be suitable for scenarios where a full-fledged database is not necessary, providing simplicity and ease of integration with Java for reading and writing schedule information. XML's human-readable format also facilitates manual inspection and editing if needed.

# Installation and usage
1. Install Java 11 and JavaFX 17
This project is made using JavaFX 17, which requires at least Java 11. Java 11 can be downloaded here: https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html. JavaFX 17 can be download here: https://gluonhq.com/products/javafx/. The project is not yet configured to be launched as an executable, so you will need to use an IDE to run it. It is critical that JavaFX is added to your project structure if you are using IntelliJ. If you are using Visual Studio Code, you will have to modify the `launch.json` as well as the `settings.json` in the `.vscode` folder.

2. Run the Main class
Find the main class in `Schedule > src > Main.java`. By running the main method, you will open the planning tool application.

3. Import the text files
You will need to import the text files that describes the students, courses, and rooms. This will provide the options in the drop down menus when creating and booking sessions.

4. Choose a class and book sessions
Create your desired sessions for your selected class. Make sure to not create overlaps in the schedules. The following activity diagram describes the expected behavior for booking a session.
![image](https://github.com/ninawrona/SEP1/assets/92271155/b7d26fa6-6110-4f9a-867a-b9cc229a3412)

6. Export the schedule to XML
While looking at the schedule, export the schedule for the chosen class to XML.

7. Open `index.html` in Live Server
Although the html can be opened directly, the Live Server extension for Visual Studio Code more accurately shows the desired behavior described by the jQuery.

8. View the schedule
Navigate to the schedule and verify that it is displayed correctly

# Domain model
Modelling the entities as well as the elementary business logic is key for demonstrating an understanding of domain. It also ensures a common understanding among the developers. and improves collaboration. Here is the domain model of the timetable planning tool.
![image](https://github.com/ninawrona/SEP1/assets/92271155/7540e262-adc5-429d-9621-780837267dac)

# Code snippets

## Java: planning tool
Here is the logic for adding a session, which is triggered when the "Add Session" button is pressed and the fields are filled out.\

```java
@FXML private void addSessionButton()
  {
    if (model.isTeacherAvailable(session))
    {
      try
      {
        session.bookRoom(roomsChoiceBox.getValue());
        //model.addSession(session, roomsChoiceBox.getValue());
        if (session.getRoom() == null)
        {
          System.out.println("Hey! The room for this session is null!");
        }
        if (session.getRoom().getCapacity() > 100
            && session.getCourse().getStudents().size() < 45)
        {
          boolean book = confirmation();
          if (book)
          {
            scheduleViewModel.addSession(session);
            reset();
          }
          else
          {
            session.bookRoom(null);
          }
        }
        else
        {
          System.out.println("I put that session in room " + session.getRoom());
        }

        model.addSession(session, session.getRoom());

        //warning for an auditorium
        if (session.getRoom().getCapacity() > 100
            && session.getCourse().getStudents().size() < 45)
        {
          boolean book = confirmation();
          if (book)
          {
            scheduleViewModel.addSession(session);
          }
          else
          {
            reset();
          }
        }

        {
          scheduleViewModel.addSession(session);
        }

        SessionList sortedSessions = model
            .getSessionsByDateAndClassGroup(getDateFromDatePicker(),
                model.getChosenClassGroup());
        if (sortedSessions.size() > 1)
        {
          //SORTING BASED ON START TIME
          for (int i = 0; i < sortedSessions.size() - 1; i++)
          {
            int difference =
                sortedSessions.get(i + 1).getStartTime().getTimeInSeconds()
                    - sortedSessions.get(i).getEndTime().getTimeInSeconds();

            if (difference > 600)
            {
              if (!(sortedSessions.get(i).getEndTimeString().equals("11:50"))
                  && !(difference == 3300))
              {
                gapConfirmation();
              }
            }
          }
        }

        reset();
        viewHandler.openView("schedule");
      }
      catch (Exception e)
      {
        errorLabel.setText(e.getMessage());
        try
        {
          Thread.sleep(5000);
        }
        catch (InterruptedException interruptedException)
        {
          interruptedException.printStackTrace();
        }
        reset();
      }
    }
    else
    {
      errorLabel.setText("The teacher is not available!");
      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      reset();
    }
  }
```

![image](https://github.com/ninawrona/SEP1/assets/92271155/42085bc1-eb39-4708-9576-ca34409b79d0)
This view is described by the following Java FX XML

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.Insets?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.ChoiceBox?>
<?import javafx.scene.control.DatePicker?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.Separator?>
<?import javafx.scene.layout.HBox?>
<?import javafx.scene.layout.VBox?>
<?import javafx.scene.text.Font?>

<VBox maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity"
      minWidth="-Infinity" prefHeight="373.0" prefWidth="388.0"
      xmlns="http://javafx.com/javafx/17" xmlns:fx="http://javafx.com/fxml/1"
      fx:controller="view.AddSessionViewController">
    <children>
        <Label fx:id="titleLabel" alignment="CENTER" prefHeight="37.0"
               prefWidth="399.0" text="Add a Session" textAlignment="CENTER">
            <font>
                <Font name="Tahoma" size="31.0"/>
            </font>
        </Label>
        <Separator prefWidth="200.0"/>
        <HBox prefHeight="46.0" prefWidth="388.0">
            <children>
                <Label prefHeight="85.0" prefWidth="105.0" text="Course"/>
                <ChoiceBox fx:id="courseChoiceBoxInAddSession" prefHeight="37.0"
                           prefWidth="169.0">
                    <HBox.margin>
                        <Insets bottom="5.0" top="5.0"/>
                    </HBox.margin>
                </ChoiceBox>
            </children>
            <padding>
                <Insets left="10.0"/>
            </padding>
        </HBox>
        <HBox prefHeight="45.0" prefWidth="388.0">
            <children>
                <Label prefHeight="101.0" prefWidth="105.0" text="Pick a Date"/>
                <DatePicker fx:id="datePicker" prefHeight="36.0"
                            prefWidth="168.0">
                    <HBox.margin>
                        <Insets bottom="5.0" top="5.0"/>
                    </HBox.margin>
                </DatePicker>
            </children>
            <padding>
                <Insets left="10.0"/>
            </padding>
        </HBox>
        <VBox alignment="CENTER" prefHeight="88.0" prefWidth="388.0">
            <children>
                <HBox prefHeight="50.0" prefWidth="388.0">
                    <children>
                        <Label prefHeight="44.0" prefWidth="105.0"
                               text="Start Time"/>
                        <ChoiceBox fx:id="startTimeChoiceBox" prefHeight="44.0"
                                   prefWidth="89.0"/>
                        <Label alignment="CENTER" prefHeight="44.0"
                               prefWidth="100.0" text="Lessons"/>
                        <ChoiceBox fx:id="numberOfLessonsChoiceBox"
                                   layoutX="125.0" layoutY="10.0"
                                   prefHeight="44.0" prefWidth="71.0"/>
                    </children>
                    <padding>
                        <Insets left="10.0"/>
                    </padding>
                </HBox>
                <Button alignment="CENTER" mnemonicParsing="false"
                        onAction="#findRoomsButton" prefHeight="25.0"
                        prefWidth="98.0" text="Find rooms">
                    <VBox.margin>
                        <Insets bottom="5.0" top="5.0"/>
                    </VBox.margin>
                </Button>
            </children>
        </VBox>
        <HBox prefHeight="62.0" prefWidth="388.0">
            <children>
                <Label prefHeight="85.0" prefWidth="105.0" text="Room"/>
                <ChoiceBox fx:id="roomsChoiceBox" prefHeight="42.0"
                           prefWidth="171.0">
                    <opaqueInsets>
                        <Insets right="15.0"/>
                    </opaqueInsets>
                    <HBox.margin>
                        <Insets bottom="5.0" top="5.0"/>
                    </HBox.margin>
                </ChoiceBox>
            </children>
            <padding>
                <Insets left="10.0"/>
            </padding>
        </HBox>
        <Separator prefWidth="200.0"/>
        <HBox alignment="CENTER" prefHeight="81.0" prefWidth="388.0">
            <children>
                <Button mnemonicParsing="false" onAction="#addSessionButton"
                        text="Add Session">
                    <HBox.margin>
                        <Insets right="5.0"/>
                    </HBox.margin>
                </Button>
                <Button mnemonicParsing="false"
                        onAction="#cancelInAddSessionButton" text="Cancel">
                    <HBox.margin>
                        <Insets right="5.0"/>
                    </HBox.margin>
                </Button>
            </children>
        </HBox>
        <Label fx:id="errorLabel" prefHeight="36.0" prefWidth="388.0"
               text="Error Label" textFill="#d31515">
            <font>
                <Font size="14.0"/>
            </font>
        </Label>
    </children>
    <opaqueInsets>
        <Insets/>
    </opaqueInsets>
</VBox>
```
## XML: A primitive form of data persistence
Once the schedule is made, the user needs to export it to XML in order to persist it and then view it in the web page. Here is an example of the schedule for 1X
```xml
<?xml version="1.0" encoding="UTF-8"standalone="no"?>

<SessionList>
<Session>
    <Course>SDJ</Course>
    <Class>1X</Class>
    <Teachers>ALHE,</Teachers>
    <Date>08/02/2022</Date>
    <WeekDay>TUESDAY</WeekDay>
    <StartTime>8:20</StartTime>
    <NumberOfLessons>4</NumberOfLessons>
    <EndTime>11:50</EndTime>
    <Room>C05.15</Room>
    <WeekNumber>6</WeekNumber>
</Session>
<Session>
    <Course>DMA</Course>
    <Class>1X</Class>
    <Teachers>RIB,</Teachers>
    <Date>09/02/2022</Date>
    <WeekDay>WEDNESDAY</WeekDay>
    <StartTime>8:20</StartTime>
    <NumberOfLessons>5</NumberOfLessons>
    <EndTime>12:35</EndTime>
    <Room>C05.15</Room>
    <WeekNumber>6</WeekNumber>
</Session>
<Session>
    <Course>SEP</Course>
    <Class>1X</Class>
    <Teachers>ALHE,MWA,</Teachers>
    <Date>09/02/2022</Date>
    <WeekDay>WEDNESDAY</WeekDay>
    <StartTime>14:35</StartTime>
    <NumberOfLessons>2</NumberOfLessons>
    <EndTime>16:15</EndTime>
    <Room>C03.12</Room>
    <WeekNumber>6</WeekNumber>
</Session>
<Session>
    <Course>SDJ</Course>
    <Class>1X</Class>
    <Teachers>ALHE,</Teachers>
    <Date>15/02/2022</Date>
    <WeekDay>TUESDAY</WeekDay>
    <StartTime>8:20</StartTime>
    <NumberOfLessons>4</NumberOfLessons>
    <EndTime>11:50</EndTime>
    <Room>C05.15</Room>
    <WeekNumber>7</WeekNumber>
</Session>
<Session>
    <Course>DMA</Course>
    <Class>1X</Class>
    <Teachers>RIB,</Teachers>
    <Date>16/02/2022</Date>
    <WeekDay>WEDNESDAY</WeekDay>
    <StartTime>8:20</StartTime>
    <NumberOfLessons>5</NumberOfLessons>
    <EndTime>12:35</EndTime>
    <Room>C05.15</Room>
    <WeekNumber>7</WeekNumber>
</Session>
<Session>
    <Course>SEP</Course>
    <Class>1X</Class>
    <Teachers>ALHE,MWA,</Teachers>
    <Date>16/02/2022</Date>
    <WeekDay>WEDNESDAY</WeekDay>
    <StartTime>14:35</StartTime>
    <NumberOfLessons>2</NumberOfLessons>
    <EndTime>16:15</EndTime>
    <Room>C03.12</Room>
    <WeekNumber>7</WeekNumber>
</Session>
<Session>
    <Course>SDJ</Course>
    <Class>1X</Class>
    <Teachers>ALHE,</Teachers>
    <Date>01/03/2022</Date>
    <WeekDay>TUESDAY</WeekDay>
    <StartTime>8:20</StartTime>
    <NumberOfLessons>4</NumberOfLessons>
    <EndTime>11:50</EndTime>
    <Room>C05.15</Room>
    <WeekNumber>9</WeekNumber>
</Session>
<Session>
    <Course>DMA</Course>
    <Class>1X</Class>
    <Teachers>RIB,</Teachers>
    <Date>02/03/2022</Date>
    <WeekDay>WEDNESDAY</WeekDay>
    <StartTime>8:20</StartTime>
    <NumberOfLessons>5</NumberOfLessons>
    <EndTime>12:35</EndTime>
    <Room>C05.15</Room>
    <WeekNumber>9</WeekNumber>
</Session>
<Session>
    <Course>SEP</Course>
    <Class>1X</Class>
    <Teachers>ALHE,MWA,</Teachers>
    <Date>02/03/2022</Date>
    <WeekDay>WEDNESDAY</WeekDay>
    <StartTime>14:35</StartTime>
    <NumberOfLessons>2</NumberOfLessons>
    <EndTime>16:15</EndTime>
    <Room>C03.12</Room>
    <WeekNumber>9</WeekNumber>
</Session>
<Session>
    <Course>SDJ</Course>
    <Class>1X</Class>
    <Teachers>ALHE,</Teachers>
    <Date>08/03/2022</Date>
    <WeekDay>TUESDAY</WeekDay>
    <StartTime>8:20</StartTime>
    <NumberOfLessons>4</NumberOfLessons>
    <EndTime>11:50</EndTime>
    <Room>C05.15</Room>
    <WeekNumber>10</WeekNumber>
</Session>
<Session>
    <Course>DMA</Course>
    <Class>1X</Class>
    <Teachers>RIB,</Teachers>
    <Date>09/03/2022</Date>
    <WeekDay>WEDNESDAY</WeekDay>
    <StartTime>8:20</StartTime>
    <NumberOfLessons>5</NumberOfLessons>
    <EndTime>12:35</EndTime>
    <Room>C05.15</Room>
    <WeekNumber>10</WeekNumber>
</Session>
<Session>
    <Course>SEP</Course>
    <Class>1X</Class>
    <Teachers>ALHE,MWA,</Teachers>
    <Date>09/03/2022</Date>
    <WeekDay>WEDNESDAY</WeekDay>
    <StartTime>14:35</StartTime>
    <NumberOfLessons>2</NumberOfLessons>
    <EndTime>16:15</EndTime>
    <Room>C03.12</Room>
    <WeekNumber>10</WeekNumber>
</Session>
</SessionList>
```
## jQuery: Showing the schedule
Now that the schedule is persisted, this is the javascript code that interprets the XML and displays the session
```javascript
function showData(xml) {
    var xmlDoc = xml.responseXML;
    var x = xmlDoc.getElementsByTagName("Session");
    var listLength = x.length;

    var table = document.getElementById("myTable");

    if (page.includes("-dk")) {
        table.innerHTML = "<tr><th>Mandag</th><th>Tirsdag</th><th>Onsdag</th><th>Torsdag</th><th>Fredag</th></tr><tr><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td></tr>"
    }
    else {
        table.innerHTML = "<tr><th>Monday</th><th>Tuesday</th><th>Wednesday</th><th>Thursday</th><th>Friday</th></tr><tr><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td></tr>"
    }
    var row = table.getElementsByTagName("tr");

    //Counters helping to keep track to which td and tr to put the lesson.
    //Data number
    var MondayData = 0;
    var TuesdayData = 1;
    var WednesdayData = 2;
    var ThursdayData = 3;
    var FridayData = 4;
    //Row counters
    var counterMondayRow = 1;
    var counterTuesdayRow = 1;
    var counterWednesdayRow = 1;
    var counterThursdayRow = 1;
    var counterFridayRow = 1;


    for (var p = 0; p < listLength; p++) {

        var course = x[p].getElementsByTagName("Course")[0].childNodes[0].nodeValue;
        var room = x[p].getElementsByTagName("Room")[0].childNodes[0].nodeValue;
        var teachers = x[p].getElementsByTagName("Teachers")[0].childNodes[0].nodeValue.split(",");
        var startTime = x[p].getElementsByTagName("StartTime")[0].childNodes[0].nodeValue;
        var weekDay = x[p].getElementsByTagName("WeekDay")[0].childNodes[0].nodeValue;
        var endTime = x[p].getElementsByTagName("EndTime")[0].childNodes[0].nodeValue;
        var weekNumberString = x[p].getElementsByTagName("WeekNumber")[0].childNodes[0].nodeValue;
        var weekNumberInt = parseInt(weekNumberString);

        // <b>RWD</b><br>C.05.16a<br>LILE<br><b>8:20-11:50</b>
        switch (weekDay) {
            case ("MONDAY"):
                {
                    if (chosenWeek == weekNumberInt) {
                        row[counterMondayRow].getElementsByTagName("td")[MondayData].innerHTML = "<b>" + course + "</b><br>" + room + "<br>";
                        for (var aa = 0; aa < teachers.length; aa++) {
                            row[counterMondayRow].getElementsByTagName("td")[MondayData].innerHTML += " " + teachers[aa];
                        }
                        row[counterMondayRow].getElementsByTagName("td")[MondayData].innerHTML += "<br><b>" + startTime + "-" + endTime + "</b>";
                        counterMondayRow++;
                    }
                    break;
                }
            case ("TUESDAY"):
                {
                    if (chosenWeek == weekNumberInt) {
                        row[counterTuesdayRow].getElementsByTagName("td")[TuesdayData].innerHTML = "<b>" + course + "</b><br>" + room + "<br>";
                        for (var aa = 0; aa < teachers.length; aa++) {
                            row[counterTuesdayRow].getElementsByTagName("td")[TuesdayData].innerHTML += " " + teachers[aa];
                        }
                        row[counterTuesdayRow].getElementsByTagName("td")[TuesdayData].innerHTML += "<br><b>" + startTime + "-" + endTime + "</b>";
                        counterTuesdayRow++;
                    }
                    break;
                }
            case ("WEDNESDAY"):
                {
                    if (chosenWeek == weekNumberInt) {
                        row[counterWednesdayRow].getElementsByTagName("td")[WednesdayData].innerHTML = "<b>" + course + "</b><br>" + room + "<br>";
                        for (var aa = 0; aa < teachers.length; aa++) {
                            row[counterWednesdayRow].getElementsByTagName("td")[WednesdayData].innerHTML += " " + teachers[aa];
                        }
                        row[counterWednesdayRow].getElementsByTagName("td")[WednesdayData].innerHTML += "<br><b>" + startTime + "-" + endTime + "</b>";
                        counterWednesdayRow++;
                    }
                    break;
                }
            case ("THURSDAY"):
                {
                    if (chosenWeek == weekNumberInt) {
                        row[counterThursdayRow].getElementsByTagName("td")[ThursdayData].innerHTML = "<b>" + course + "</b><br>" + room + "<br>";
                        for (var aa = 0; aa < teachers.length; aa++) {
                            row[counterThursdayRow].getElementsByTagName("td")[ThursdayData].innerHTML += " " + teachers[aa];
                        }
                        row[counterThursdayRow].getElementsByTagName("td")[ThursdayData].innerHTML += "<br><b>" + startTime + "-" + endTime + "</b>";
                        counterThursdayRow++;
                    }
                    break;
                }
            case ("FRIDAY"):
                {
                    if (chosenWeek == weekNumberInt) {
                        row[counterFridayRow].getElementsByTagName("td")[FridayData].innerHTML = "<b>" + course + "</b><br>" + room + "<br>";
                        for (var aa = 0; aa < teachers.length; aa++) {
                            row[counterFridayRow].getElementsByTagName("td")[FridayData].innerHTML += " " + teachers[aa];
                        }
                        row[counterFridayRow].getElementsByTagName("td")[FridayData].innerHTML += "<br><b>" + startTime + "-" + endTime + "</b>";
                        counterFridayRow++;
                    }
                    break;
                }
        }
    }


}
```
# Documentation
In addition to this brief overview, there are JavaDocs with a high amount of coverage. You can open them directly from the `JavaDoc` folder and navigate to the class or method you need clarification on. 

There is also an externsive project and process report found in the root directly. **It is 180 pages long and contains a vast amount of appendices**.

# Contributions
This was a tight knit group project that invloved 5 core members and a supervisor for feedback. This is not open for contribution, but thank you for taking the time to read about how it works.
