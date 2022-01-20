var document, DOMParser;
var chosenClass;
var chosenTeacher;
var chosenWeek = 0;

var path = window.location.pathname;
var page = path.split("/").pop();
 
$("#weekBtn").click(function () {
    var chosenWeekTemp = $("#inputWeek").val();
    var charLast = chosenWeekTemp.charAt(chosenWeekTemp.length - 1);
    var charOneBeforeLast = chosenWeekTemp.charAt(chosenWeekTemp.length - 2);
    if (charOneBeforeLast == 0) {
        chosenWeek = parseInt(charLast);
    }
    else {
        var numberTemp = charOneBeforeLast + charLast;
        chosenWeek = parseInt(numberTemp);
    }
});

$("#classBtn").click(function () {
    chosenClass = $("#selectedClass").val();
    if (chosenWeek == 0) {
        alert("You have to choose a week first!")
    }
    else {
        readXMLSessionListClass();
    }
});
$("#teacherBtn").click(function () {
    chosenTeacher = $("#selectedTeacher").val();
    if (chosenWeek == 0) {
        alert("You have to choose a week first!")
    }
    else {
        readXMLSessionListTeacher();
    }
});


function readXMLSessionListClass() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            showData(xhttp);
        }
    };
    const url = `../../SessionList${chosenClass}.xml`;
    xhttp.open("GET", url, true);
    xhttp.send();
}

function readXMLSessionListTeacher() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            showData(xhttp);
        }
    };
    const urlSecond = `../../SessionList${chosenTeacher}.xml`;
    xhttp.open("GET", urlSecond, true);
    xhttp.send();
}

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