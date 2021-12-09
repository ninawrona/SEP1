var document, DOMParser;
//All the variables rows with our. We are gonna get different days by->
//hour820[1] = 8:20 Monday and hour820[5] = 8:20 Friday.
var hour820 = document.getElementById("8:20").getElementsByTagName("td");
var hour915 = document.getElementById("9:15").getElementsByTagName("td");
var hour1010 = document.getElementById("10:10").getElementsByTagName("td");
var hour1105 = document.getElementById("11:05").getElementsByTagName("td");
var hour1200 = document.getElementById("12:00").getElementsByTagName("td");
var hour1245 = document.getElementById("12:45").getElementsByTagName("td");
var hour1340 = document.getElementById("13:40").getElementsByTagName("td");
var hour1435 = document.getElementById("14:35").getElementsByTagName("td");
var hour1530 = document.getElementById("15:30").getElementsByTagName("td");
var hour1625 = document.getElementById("16:25").getElementsByTagName("td");
var hour1720 = document.getElementById("17:20").getElementsByTagName("td");

readXML();

//Write your function declarations below this line
//example of a function getting and returning the book titles from the XML "text"

/*
function displayTable(){
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(text, "text/xml");
    var x = xmlDoc.getElementsByTagName("book");
    var listLength = x.length;

    var table = "<table><tr><th>Author</th><th>Title</th><th>Year</th>";
    for (var i = 0; i < listLength; i++){
        table +=
        "<tr><td>" + x[i].getElementsByTagName("author")[0].childNodes[0].nodeValue +
        "</td><td>" + x[i].getElementsByTagName("title")[0].childNodes[0].nodeValue +
        "</td><td>" + x[i].getElementsByTagName("year")[0].childNodes[0].nodeValue +
        "</td></tr>";
        
    }
    table += "</table>";
    document.getElementById("GOT").innerHTML = table;
}
*/
function readXML() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            showData(xhttp);
        }
    };
    xhttp.open("GET", "../../SessionList.xml", true);
    xhttp.send();
}

function showData(xml) {
    var xmlDoc = xml.responseXML;
    var x = xmlDoc.getElementsByTagName("Session");
    var listLength = x.length;
    var test = document.getElementById("test");
    test.innerHTML = "This is the lenght: " + listLength

    for (var i = 0; i < listLength; i++) {

        if (i != 0) {
            test.innerHTML = "I am entering loop second time!"
        }
        var course = x[i].getElementsByTagName("Course")[0].childNodes[0].nodeValue;
        var room = x[i].getElementsByTagName("Room")[0].childNodes[0].nodeValue;
        var teachers = x[i].getElementsByTagName("Teachers")[0].childNodes[0].nodeValue.split(",");
        var numberOfLessons = x[i].getElementsByTagName("NumberOfLessons")[0].childNodes[0].nodeValue;
        var startTime = x[i].getElementsByTagName("StartTime")[0].childNodes[0].nodeValue;
        var weekDay = x[i].getElementsByTagName("WeekDay")[0].childNodes[0].nodeValue;


        switch (startTime) {
            case ("8:20"):
                {
                    switch (weekDay) {
                        case ("MONDAY"):
                            {
                                hour820[1].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour820[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour820[1].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour820[1].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour820[1].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour820[1].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour820[1].classList.add("pt-" + numberOfLessons)
                                hour820[1].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour820[2].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour820[2].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour820[2].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour820[2].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour820[2].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour820[2].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour820[2].classList.add("pt-" + numberOfLessons)
                                hour820[2].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour820[3].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour820[3].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour820[3].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour820[3].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour820[3].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour820[3].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour820[3].classList.add("pt-" + numberOfLessons)
                                hour820[3].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour820[4].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour820[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour820[4].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour820[4].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour820[4].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour820[4].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour820[4].classList.add("pt-" + numberOfLessons)
                                hour820[4].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour820[5].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour820[5].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour820[5].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour820[5].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour820[5].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour820[5].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour820[5].classList.add("pt-" + numberOfLessons)
                                hour820[5].rowSpan = "" + numberOfLessons
                            }
                            break;
                    }
                }
                break;
            case ("9:15"):
                {
                    switch (weekDay) {
                        case ("MONDAY"):
                            {
                                hour915[1].innerHTML = course + "<br>" + room + "<br>";
                                for (var i = 0; i < teachers.length; i++) {
                                    hour915[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour915[1].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour915[1].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour915[1].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour915[1].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour915[1].classList.add("pt-" + numberOfLessons)
                                hour915[1].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour915[2].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour915[2].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour915[2].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour915[2].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour915[2].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour915[2].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour915[2].classList.add("pt-" + numberOfLessons)
                                hour915[2].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour915[3].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour915[3].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour915[3].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour915[3].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour915[3].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour915[3].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour915[3].classList.add("pt-" + numberOfLessons)
                                hour915[3].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour915[4].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour915[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour915[4].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour915[4].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour915[4].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour915[4].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour915[4].classList.add("pt-" + numberOfLessons)
                                hour915[4].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour915[5].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour915[5].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour915[5].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour915[5].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour915[5].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour915[5].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour915[5].classList.add("pt-" + numberOfLessons)
                                hour915[5].rowSpan = "" + numberOfLessons
                            }
                            break;
                    }
                }
                break;
            case ("10:10"):
                {
                    switch (weekDay) {
                        case ("MONDAY"):
                            {
                                hour1010[1].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1010[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1010[1].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1010[1].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1010[1].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1010[1].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1010[1].classList.add("pt-" + numberOfLessons)
                                hour1010[1].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour1010[2].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1010[2].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1010[2].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1010[2].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1010[2].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1010[2].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1010[2].classList.add("pt-" + numberOfLessons)
                                hour1010[2].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1010[3].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1010[3].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1010[3].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1010[3].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1010[3].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1010[3].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1010[3].classList.add("pt-" + numberOfLessons)
                                hour1010[3].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1010[4].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1010[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1010[4].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1010[4].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1010[4].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1010[4].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1010[4].classList.add("pt-" + numberOfLessons)
                                hour1010[4].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1010[5].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1010[5].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1010[5].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1010[5].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1010[5].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1010[5].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1010[5].classList.add("pt-" + numberOfLessons)
                                hour1010[5].rowSpan = "" + numberOfLessons
                            }
                            break;
                    }
                }
                break;
            case ("11:05"):
                {
                    switch (weekDay) {
                        case ("MONDAY"):
                            {
                                hour1105[1].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1105[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1105[1].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1105[1].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1105[1].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1105[1].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1105[1].classList.add("pt-" + numberOfLessons)
                                hour1105[1].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour1105[2].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1105[2].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1105[2].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1105[2].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1105[2].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1105[2].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1105[2].classList.add("pt-" + numberOfLessons)
                                hour1105[2].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1105[3].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1105[3].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1105[3].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1105[3].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1105[3].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1105[3].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1105[3].classList.add("pt-" + numberOfLessons)
                                hour1105[3].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1105[4].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1105[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1105[4].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1105[4].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1105[4].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1105[4].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1105[4].classList.add("pt-" + numberOfLessons)
                                hour1105[4].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1105[5].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1105[5].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1105[5].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1105[5].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1105[5].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1105[5].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1105[5].classList.add("pt-" + numberOfLessons)
                                hour1105[5].rowSpan = "" + numberOfLessons
                            }
                            break;
                    }
                }
                break;
            case ("12:00"):
                {
                    switch (weekDay) {
                        case ("MONDAY"):
                            {
                                hour1200[1].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1200[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1200[1].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1200[1].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1200[1].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1200[1].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1200[1].classList.add("pt-" + numberOfLessons)
                                hour1200[1].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour1200[2].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1200[2].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1200[2].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1200[2].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1200[2].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1200[2].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1200[2].classList.add("pt-" + numberOfLessons)
                                hour1200[2].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1200[3].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1200[3].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1200[3].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1200[3].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1200[3].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1200[3].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1200[3].classList.add("pt-" + numberOfLessons)
                                hour1200[3].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1200[4].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1200[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1200[4].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1200[4].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1200[4].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1200[4].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1200[4].classList.add("pt-" + numberOfLessons)
                                hour1200[4].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1200[5].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1200[5].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1200[5].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1200[5].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1200[5].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1200[5].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1200[5].classList.add("pt-" + numberOfLessons)
                                hour1200[5].rowSpan = "" + numberOfLessons
                            }
                            break;
                    }
                }
                break;
            case ("12:45"):
                {
                    switch (weekDay) {
                        case ("MONDAY"):
                            {
                                hour1245[1].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1245[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1245[1].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1245[1].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1245[1].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1245[1].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1245[1].classList.add("pt-" + numberOfLessons)
                                hour1245[1].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                test.innerHTML = "I am entering this case!"
                                hour1245[2].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1245[2].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1245[2].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1245[2].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1245[2].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1245[2].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1245[2].classList.add("pt-" + numberOfLessons)
                                hour1245[2].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1245[3].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1245[3].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1245[3].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1245[3].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1245[3].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1245[3].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1245[3].classList.add("pt-" + numberOfLessons)
                                hour1245[3].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1245[4].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1245[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1245[4].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1245[4].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1245[4].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1245[4].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1245[4].classList.add("pt-" + numberOfLessons)
                                hour1245[4].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1245[5].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1245[5].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1245[5].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1245[5].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1245[5].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1245[5].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1245[5].classList.add("pt-" + numberOfLessons)
                                hour1245[5].rowSpan = "" + numberOfLessons
                            }
                            break;
                    }
                }
                break;
            case ("13:40"):
                {
                    switch (weekDay) {
                        case ("MONDAY"):
                            {
                                hour1340[1].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1340[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1340[1].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1340[1].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1340[1].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1340[1].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1340[1].classList.add("pt-" + numberOfLessons)
                                hour1340[1].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour1340[2].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1340[2].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1340[2].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1340[2].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1340[2].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1340[2].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1340[2].classList.add("pt-" + numberOfLessons)
                                hour1340[2].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1340[3].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1340[3].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1340[3].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1340[3].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1340[3].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1340[3].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1340[3].classList.add("pt-" + numberOfLessons)
                                hour1340[3].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1340[4].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1340[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1340[4].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1340[4].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1340[4].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1340[4].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1340[4].classList.add("pt-" + numberOfLessons)
                                hour1340[4].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1340[5].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1340[5].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1340[5].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1340[5].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1340[5].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1340[5].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1340[5].classList.add("pt-" + numberOfLessons)
                                hour1340[5].rowSpan = "" + numberOfLessons
                            }
                            break;
                    }
                }
                break;
            case ("14:35"):
                {
                    switch (weekDay) {
                        case ("MONDAY"):
                            {
                                hour1435[1].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1435[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1435[1].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1435[1].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1435[1].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1435[1].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1435[1].classList.add("pt-" + numberOfLessons)
                                hour1435[1].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour1435[2].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1435[2].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1435[2].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1435[2].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1435[2].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1435[2].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1435[2].classList.add("pt-" + numberOfLessons)
                                hour1435[2].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1435[3].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1435[3].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1435[3].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1435[3].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1435[3].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1435[3].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1435[3].classList.add("pt-" + numberOfLessons)
                                hour1435[3].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1435[4].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1435[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1435[4].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1435[4].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1435[4].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1435[4].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1435[4].classList.add("pt-" + numberOfLessons)
                                hour1435[4].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1435[5].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1435[5].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1435[5].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1435[5].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1435[5].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1435[5].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1435[5].classList.add("pt-" + numberOfLessons)
                                hour1435[5].rowSpan = "" + numberOfLessons
                            }
                            break;
                    }
                }
                break;
            case ("15:30"):
                {
                    switch (weekDay) {
                        case ("MONDAY"):
                            {
                                hour1530[1].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1530[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1530[1].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1530[1].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1530[1].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1530[1].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1530[1].classList.add("pt-" + numberOfLessons)
                                hour1530[1].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour1530[2].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1530[2].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1530[2].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1530[2].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1530[2].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1530[2].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1530[2].classList.add("pt-" + numberOfLessons)
                                hour1530[2].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1530[3].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1530[3].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1530[3].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1530[3].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1530[3].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1530[3].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1530[3].classList.add("pt-" + numberOfLessons)
                                hour1530[3].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1530[4].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1530[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1530[4].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1530[4].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1530[4].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1530[4].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1530[4].classList.add("pt-" + numberOfLessons)
                                hour1530[4].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1530[5].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1530[5].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1530[5].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1530[5].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1530[5].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1530[5].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1530[5].classList.add("pt-" + numberOfLessons)
                                hour1530[5].rowSpan = "" + numberOfLessons
                            }
                            break;
                    }
                }
                break;
            case ("16:25"):
                {
                    switch (weekDay) {
                        case ("MONDAY"):
                            {
                                hour1625[1].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1625[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1625[1].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1625[1].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1625[1].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1625[1].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1625[1].classList.add("pt-" + numberOfLessons)
                                hour1625[1].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour1625[2].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1625[2].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            v[2].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1625[2].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1625[2].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1625[2].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1625[2].classList.add("pt-" + numberOfLessons)
                                hour1625[2].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1625[3].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1625[3].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1625[3].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1625[3].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1625[3].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1625[3].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1625[3].classList.add("pt-" + numberOfLessons)
                                hour1625[3].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1625[4].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1625[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1625[4].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1625[4].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1625[4].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1625[4].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1625[4].classList.add("pt-" + numberOfLessons)
                                hour1625[4].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1625[5].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1625[5].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1625[5].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1625[5].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1625[5].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1625[5].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1625[5].classList.add("pt-" + numberOfLessons)
                                hour1625[5].rowSpan = "" + numberOfLessons
                            }
                            break;
                    }
                }
                break;
            case ("17:20"):
                {
                    switch (weekDay) {
                        case ("MONDAY"):
                            {
                                hour1720[1].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1720[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1720[1].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1720[1].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1720[1].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1720[1].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1720[1].classList.add("pt-" + numberOfLessons)
                                hour1720[1].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour1720[2].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1720[2].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1720[2].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1720[2].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1720[2].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1720[2].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1720[2].classList.add("pt-" + numberOfLessons)
                                hour1720[2].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1720[3].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1720[3].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1720[3].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1720[3].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1720[3].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1720[3].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1720[3].classList.add("pt-" + numberOfLessons)
                                hour1720[3].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1720[4].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1720[1].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1720[4].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1720[4].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1720[4].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1720[4].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1720[4].classList.add("pt-" + numberOfLessons)
                                hour1720[4].rowSpan = "" + numberOfLessons
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1720[5].innerHTML = course + "<br>" + room + "<br>"
                                for (var i = 0; i < teachers.length; i++) {
                                    hour1720[5].innerHTML += teachers[i] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1720[5].classList.add("bg-danger")
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1720[5].classList.add("bg-info")
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1720[5].classList.add("bg-primary")
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1720[5].classList.add("bg-warning")
                                        }
                                        break;
                                }
                                hour1720[5].classList.add("pt-" + numberOfLessons)
                                hour1720[5].rowSpan = "" + numberOfLessons
                            }
                            break;
                    }
                }
                break;

        }
    }

}