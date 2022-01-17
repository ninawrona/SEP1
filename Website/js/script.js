var document, DOMParser;
var chosenClass;
var chosenTeacher;
var chosenWeek=0;

var test = document.getElementById("test");

$("#weekBtn").click(function () {
    var chosenWeekTemp =$("#inputWeek").val();
    var charLast = chosenWeekTemp.charAt(chosenWeekTemp.length-1);
    var charOneBeforeLast = chosenWeekTemp.charAt(chosenWeekTemp.length-2);
    if(charOneBeforeLast==0)
    {
        chosenWeek=parseInt(charLast);
    }
    else
    {
        var numberTemp = charOneBeforeLast + charLast;
        chosenWeek=parseInt(numberTemp);
    }
    test.innerHTML=chosenWeek
});

$("#classBtn").click(function () {
    chosenClass = $("#selectedClass").val();
    if(chosenWeek==0)
    {
        alert("You have to choose a week first!")
    }
    else
    {
    readXMLSessionListClass();
    }
});
$("#teacherBtn").click(function () {
    chosenTeacher = $("#selectedTeacher").val();
    if(chosenWeek==0)
    {
        alert("You have to choose a week first!")
    }
    else
    {
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

    table.innerHTML="<tr><th>Monday</th><th>Tuesday</th><th>Wednesday</th><th>Thursday</th><th>Friday</th></tr><tr><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td></tr>"

    //Counters helping to keep track to which td and tr to put the lesson.
    //Data counters
    var counterMondayData=0;
    var counterTuesdayData=0;
    var counterWednesdayData=0;
    var counterThursdayData=0;
    var counterFridayData=0;
    //Row counters
    var counterMondayRow=1;
    var counterTuesdayRow=1;
    var counterWednesdayRow=1;
    var counterThursdayRow=1;
    var counterFridayRow=1;

    
    for (var p = 0; p < listLength; p++) {

        var course = x[p].getElementsByTagName("Course")[0].childNodes[0].nodeValue;
        var room = x[p].getElementsByTagName("Room")[0].childNodes[0].nodeValue;
        var teachers = x[p].getElementsByTagName("Teachers")[0].childNodes[0].nodeValue.split(",");
        var numberOfLessonsString = x[p].getElementsByTagName("NumberOfLessons")[0].childNodes[0].nodeValue;
        var numberOfLessons = parseInt(numberOfLessonsString);
        var startTime = x[p].getElementsByTagName("StartTime")[0].childNodes[0].nodeValue;
        var weekDay = x[p].getElementsByTagName("WeekDay")[0].childNodes[0].nodeValue;
        
        switch(weekDay)
        {

        }
    }
}



