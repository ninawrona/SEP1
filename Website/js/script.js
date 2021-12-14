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
var timeList = [hour820, hour915, hour1010, hour1105, hour1200, hour1245, hour1340, hour1435,
    hour1530, hour1625, hour1720];
readXMLSessionList();


//Write your function declarations below this line
//example of a function getting and returning the book titles from the XML "text"

/*
function displayTable(){
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(text, "text/xml");
    var x = xmlDoc.getElementsByTagName("book");
    var listLength = x.length;

    var table = "<table><tr><th>Author</th><th>Title</th><th>Year</th>";
    for (var j = 0; j < listLength; j++){
        table +=
        "<tr><td>" + x[j].getElementsByTagName("author")[0].childNodes[0].nodeValue +
        "</td><td>" + x[j].getElementsByTagName("title")[0].childNodes[0].nodeValue +
        "</td><td>" + x[j].getElementsByTagName("year")[0].childNodes[0].nodeValue +
        "</td></tr>";
        
    }
    table += "</table>";
    document.getElementById("GOT").innerHTML = table;
}
*/
function readXMLSessionList() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            showData(xhttp);
        }
    };
    xhttp.open("GET", "../../SessionList1X.xml", true);
    xhttp.send();
}
function readXMLStudentList() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            showData(xhttp);
        }
    };
    xhttp.open("GET", "../../StudentList.xml", true);
    xhttp.send();
}
function readXMLTeacherList() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            showData(xhttp);
        }
    };
    xhttp.open("GET", "../../SessionList1X.xml", true);
    xhttp.send();
}


function showData(xml) {
    var xmlDoc = xml.responseXML;
    var x = xmlDoc.getElementsByTagName("Session");
    var listLength = x.length;
    var test = document.getElementById("test");

    for (var p = 0; p < listLength; p++) {

        var course = x[p].getElementsByTagName("Course")[0].childNodes[0].nodeValue;
        var room = x[p].getElementsByTagName("Room")[0].childNodes[0].nodeValue;
        var teachers = x[p].getElementsByTagName("Teachers")[0].childNodes[0].nodeValue.split(",");
        var numberOfLessonsString = x[p].getElementsByTagName("NumberOfLessons")[0].childNodes[0].nodeValue;
        var numberOfLessons = parseInt(numberOfLessonsString);
        var startTime = x[p].getElementsByTagName("StartTime")[0].childNodes[0].nodeValue;
        var weekDay = x[p].getElementsByTagName("WeekDay")[0].childNodes[0].nodeValue;
        test.innerHTML = "I am entring it " + p + " times";

        switch (startTime) {
            case ("8:20"):
                {
                    switch (weekDay) {
                        case ("MONDAY"):
                            {
                                hour820[1].innerHTML = course + "<br>" + room + "<br>";
                                for (var j = 0; j < teachers.length; j++) {
                                    hour820[1].innerHTML += teachers[j] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour820[1].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour820[1].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour820[1].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour820[1].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour820[1].classList.add("pt-" + numberOfLessons);
                                hour820[1].rowSpan = "" + numberOfLessons;

                                for (var k = numberOfLessons - 1; k >= 1; k--) {
                                    timeList[k][1].remove();
                                }

                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour820[2].innerHTML = course + "<br>" + room + "<br>";
                                for (var l = 0; l < teachers.length; l++) {
                                    hour820[2].innerHTML += teachers[l] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour820[2].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour820[2].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour820[2].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour820[2].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour820[2].classList.add("pt-" + numberOfLessons);
                                hour820[2].rowSpan = "" + numberOfLessons;
                                for (var m = numberOfLessons - 1; m >= 1; m--) {
                                    timeList[m][2].remove();
                                }
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour820[3].innerHTML = course + "<br>" + room + "<br>";
                                for (var n = 0; n < teachers.length; n++) {
                                    hour820[3].innerHTML += teachers[n] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour820[3].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour820[3].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour820[3].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour820[3].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour820[3].classList.add("pt-" + numberOfLessons);
                                hour820[3].rowSpan = "" + numberOfLessons;

                                for (var o = numberOfLessons - 1; o >= 1; o--) {
                                    timeList[o][3].remove();
                                }
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour820[4].innerHTML = course + "<br>" + room + "<br>";
                                for (var q = 0; q < teachers.length; q++) {
                                    hour820[4].innerHTML += teachers[q] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour820[4].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour820[4].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour820[4].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour820[4].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour820[4].classList.add("pt-" + numberOfLessons);
                                hour820[4].rowSpan = "" + numberOfLessons;
                                for (var r = numberOfLessons - 1; r >= 1; r--) {
                                    timeList[r][4].remove();
                                }
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour820[5].innerHTML = course + "<br>" + room + "<br>";
                                for (var s = 0; s < teachers.length; s++) {
                                    hour820[5].innerHTML += teachers[s] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour820[5].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour820[5].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour820[5].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour820[5].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour820[5].classList.add("pt-" + numberOfLessons);
                                hour820[5].rowSpan = "" + numberOfLessons;
                                for (var t = numberOfLessons - 1; t >= 1; t--) {
                                    timeList[t][5].remove();
                                }
                            } break;
                    }
                }
                break;
            case ("9:15"):
                {
                    switch (weekDay) {
                        case ("MONDAY"):
                            {
                                hour915[1].innerHTML = course + "<br>" + room + "<br>";
                                for (var u = 0; u < teachers.length; u++) {
                                    hour915[1].innerHTML += teachers[u] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour915[1].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour915[1].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour915[1].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour915[1].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour915[1].classList.add("pt-" + numberOfLessons);
                                hour915[1].rowSpan = "" + numberOfLessons;

                                for (var v = numberOfLessons; v >= 2; v--) {
                                    timeList[v][1].remove();
                                }


                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour915[2].innerHTML = course + "<br>" + room + "<br>";
                                for (var w = 0; w < teachers.length; w++) {
                                    hour915[2].innerHTML += teachers[w] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour915[2].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour915[2].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour915[2].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour915[2].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour915[2].classList.add("pt-" + numberOfLessons);
                                hour915[2].rowSpan = "" + numberOfLessons;
                                for (var y = numberOfLessons; y >= 2; y--) {
                                    timeList[y][2].remove();
                                }
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour915[3].innerHTML = course + "<br>" + room + "<br>";
                                for (var z = 0; z < teachers.length; z++) {
                                    hour915[3].innerHTML += teachers[z] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour915[3].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour915[3].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour915[3].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour915[3].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour915[3].classList.add("pt-" + numberOfLessons);
                                hour915[3].rowSpan = "" + numberOfLessons;
                                for (var aa = numberOfLessons; aa >= 2; aa--) {
                                    timeList[aa][3].remove();
                                }
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour915[4].innerHTML = course + "<br>" + room + "<br>";
                                for (var ab = 0; ab < teachers.length; ab++) {
                                    hour915[1].innerHTML += teachers[ab] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour915[4].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour915[4].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour915[4].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour915[4].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour915[4].classList.add("pt-" + numberOfLessons);
                                hour915[4].rowSpan = "" + numberOfLessons;
                                for (var ac = numberOfLessons; ac >= 2; ac--) {
                                    timeList[ac][4].remove();
                                }
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour915[5].innerHTML = course + "<br>" + room + "<br>";
                                for (var ad = 0; ad < teachers.length; ad++) {
                                    hour915[5].innerHTML += teachers[ad] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour915[5].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour915[5].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour915[5].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour915[5].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour915[5].classList.add("pt-" + numberOfLessons);
                                hour915[5].rowSpan = "" + numberOfLessons;
                                for (var ae = numberOfLessons; ae >= 2; ae--) {
                                    timeList[ae][5].remove();
                                }
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
                                hour1010[1].innerHTML = course + "<br>" + room + "<br>";
                                for (var af = 0; af < teachers.length; af++) {
                                    hour1010[1].innerHTML += teachers[af] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1010[1].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1010[1].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1010[1].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1010[1].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1010[1].classList.add("pt-" + numberOfLessons);
                                hour1010[1].rowSpan = "" + numberOfLessons;
                                for (var ag = (numberOfLessons + 1); ag >= 3; ag--) {
                                    timeList[ag][1].remove();
                                }
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                test.innerHTML = "I feel inside here!";
                                hour1010[2].innerHTML = course + "<br>" + room + "<br>";
                                for (var ah = 0; ah < teachers.length; ah++) {
                                    hour1010[2].innerHTML += teachers[ah] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1010[2].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1010[2].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1010[2].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1010[2].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1010[2].classList.add("pt-" + numberOfLessons);
                                hour1010[2].rowSpan = "" + numberOfLessons;

                                for (var ai = numberOfLessons + 1; ai >= 3; ai--) {
                                    timeList[ai][2].remove();
                                }

                            }
                            break;
                        case ("WEDNESDAY"):
                            {

                                hour1010[3].innerHTML = course + "<br>" + room + "<br>";
                                for (var aj = 0; aj < teachers.length; aj++) {
                                    hour1010[3].innerHTML += teachers[aj] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1010[3].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1010[3].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1010[3].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1010[3].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1010[3].classList.add("pt-" + numberOfLessons);
                                hour1010[3].rowSpan = "" + numberOfLessons;
                                for (var ak = numberOfLessons + 1; ak >= 3; ak--) {
                                    timeList[ak][3].remove();
                                }
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1010[4].innerHTML = course + "<br>" + room + "<br>";
                                for (var al = 0; al < teachers.length; al++) {
                                    hour1010[1].innerHTML += teachers[al] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1010[4].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1010[4].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1010[4].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1010[4].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1010[4].classList.add("pt-" + numberOfLessons);
                                hour1010[4].rowSpan = "" + numberOfLessons;
                                for (var am = numberOfLessons + 1; am >= 3; am--) {
                                    timeList[am][4].remove();
                                }
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1010[5].innerHTML = course + "<br>" + room + "<br>";
                                for (var an = 0; an < teachers.length; an++) {
                                    hour1010[5].innerHTML += teachers[an] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1010[5].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1010[5].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1010[5].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1010[5].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1010[5].classList.add("pt-" + numberOfLessons);
                                hour1010[5].rowSpan = "" + numberOfLessons;
                                for (var ao = numberOfLessons + 1; ao >= 3; ao--) {
                                    timeList[ao][5].remove();
                                }
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
                                hour1105[1].innerHTML = course + "<br>" + room + "<br>";
                                for (var ap = 0; ap < teachers.length; ap++) {
                                    hour1105[1].innerHTML += teachers[ap] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1105[1].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1105[1].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1105[1].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1105[1].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1105[1].classList.add("pt-" + numberOfLessons);
                                hour1105[1].rowSpan = "" + numberOfLessons;
                                for (var aq = numberOfLessons + 2; aq >= 4; aq--) {
                                    timeList[aq][1].remove();
                                }
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour1105[2].innerHTML = course + "<br>" + room + "<br>";
                                for (var ar = 0; ar < teachers.length; ar++) {
                                    hour1105[2].innerHTML += teachers[ar] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1105[2].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1105[2].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1105[2].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1105[2].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1105[2].classList.add("pt-" + numberOfLessons);
                                hour1105[2].rowSpan = "" + numberOfLessons;
                                for (var as = numberOfLessons + 2; as >= 4; as--) {
                                    timeList[as][2].remove();
                                }
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1105[3].innerHTML = course + "<br>" + room + "<br>";
                                for (var at = 0; at < teachers.length; at++) {
                                    hour1105[3].innerHTML += teachers[at] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1105[3].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1105[3].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1105[3].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1105[3].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1105[3].classList.add("pt-" + numberOfLessons);
                                hour1105[3].rowSpan = "" + numberOfLessons;
                                for (var au = numberOfLessons + 2; au >= 4; au--) {
                                    timeList[au][3].remove();
                                }
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1105[4].innerHTML = course + "<br>" + room + "<br>";
                                for (var av = 0; av < teachers.length; av++) {
                                    hour1105[1].innerHTML += teachers[av] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1105[4].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1105[4].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1105[4].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1105[4].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1105[4].classList.add("pt-" + numberOfLessons);
                                hour1105[4].rowSpan = "" + numberOfLessons;
                                for (var aw = numberOfLessons + 2; aw >= 4; aw--) {
                                    timeList[aw][4].remove();
                                }
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1105[5].innerHTML = course + "<br>" + room + "<br>";
                                for (var ax = 0; ax < teachers.length; ax++) {
                                    hour1105[5].innerHTML += teachers[ax] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1105[5].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1105[5].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1105[5].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1105[5].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1105[5].classList.add("pt-" + numberOfLessons);
                                hour1105[5].rowSpan = "" + numberOfLessons;
                                for (var ay = numberOfLessons + 2; ay >= 4; ay--) {
                                    timeList[ay][5].remove();
                                }
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
                                hour1200[1].innerHTML = course + "<br>" + room + "<br>";
                                for (var az = 0; az < teachers.length; az++) {
                                    hour1200[1].innerHTML += teachers[az] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1200[1].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1200[1].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1200[1].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1200[1].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1200[1].classList.add("pt-" + numberOfLessons);
                                hour1200[1].rowSpan = "" + numberOfLessons;
                                for (var ba = numberOfLessons + 3; ba >= 5; ba--) {
                                    timeList[ba][1].remove();
                                }
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour1200[2].innerHTML = course + "<br>" + room + "<br>";
                                for (var bb = 0; bb < teachers.length; bb++) {
                                    hour1200[2].innerHTML += teachers[bb] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1200[2].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1200[2].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1200[2].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1200[2].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1200[2].classList.add("pt-" + numberOfLessons);
                                hour1200[2].rowSpan = "" + numberOfLessons;
                                for (var bc = numberOfLessons + 3; bc >= 5; bc--) {
                                    timeList[bc][2].remove();
                                }
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1200[3].innerHTML = course + "<br>" + room + "<br>";
                                for (var bd = 0; bd < teachers.length; bd++) {
                                    hour1200[3].innerHTML += teachers[bd] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1200[3].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1200[3].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1200[3].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1200[3].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1200[3].classList.add("pt-" + numberOfLessons);
                                hour1200[3].rowSpan = "" + numberOfLessons;
                                for (var be = numberOfLessons + 3; be >= 5; be--) {
                                    timeList[be][3].remove();
                                }
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1200[4].innerHTML = course + "<br>" + room + "<br>";
                                for (var bf = 0; bf < teachers.length; bf++) {
                                    hour1200[4].innerHTML += teachers[bf] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1200[4].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1200[4].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1200[4].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1200[4].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1200[4].classList.add("pt-" + numberOfLessons);
                                hour1200[4].rowSpan = "" + numberOfLessons;
                                for (var bg = numberOfLessons + 3; bg >= 5; bg--) {
                                    timeList[bg][4].remove();
                                }
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1200[5].innerHTML = course + "<br>" + room + "<br>";
                                for (var bh = 0; bh < teachers.length; bh++) {
                                    hour1200[5].innerHTML += teachers[bh] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1200[5].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1200[5].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1200[5].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1200[5].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1200[5].classList.add("pt-" + numberOfLessons);
                                hour1200[5].rowSpan = "" + numberOfLessons;
                                for (var bi = numberOfLessons + 3; bi >= 5; bi--) {
                                    timeList[bi][5].remove();
                                }
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
                                hour1245[1].innerHTML = course + "<br>" + room + "<br>";
                                for (var bj = 0; bj < teachers.length; bj++) {
                                    hour1245[1].innerHTML += teachers[bj] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1245[1].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1245[1].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1245[1].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1245[1].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1245[1].classList.add("pt-" + numberOfLessons);
                                hour1245[1].rowSpan = "" + numberOfLessons;
                                for (var bk = numberOfLessons + 4; bk >= 6; bk--) {
                                    timeList[bk][1].remove();
                                }
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour1245[2].innerHTML = course + "<br>" + room + "<br>";
                                for (var bl = 0; bl < teachers.length; bl++) {
                                    hour1245[2].innerHTML += teachers[bl] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1245[2].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1245[2].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1245[2].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1245[2].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1245[2].classList.add("pt-" + numberOfLessons);
                                hour1245[2].rowSpan = "" + numberOfLessons;
                                for (var bm = numberOfLessons + 4; bm >= 6; bm--) {
                                    console.log("before");
                                    console.log(timeList[bm]);
                                    timeList[bm][2].remove();
                                    console.log("after" + timeList[bm]);
                                }
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1245[3].innerHTML = course + "<br>" + room + "<br>";
                                for (var bn = 0; bn < teachers.length; bn++) {
                                    hour1245[3].innerHTML += teachers[bn] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1245[3].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1245[3].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1245[3].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1245[3].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1245[3].classList.add("pt-" + numberOfLessons);
                                hour1245[3].rowSpan = "" + numberOfLessons;
                                for (var bo = numberOfLessons + 4; bo >= 6; bo--) {
                                    timeList[bo][3].remove();
                                }
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1245[4].innerHTML = course + "<br>" + room + "<br>";
                                for (var bp = 0; bp < teachers.length; bp++) {
                                    hour1245[4].innerHTML += teachers[bp] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1245[4].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1245[4].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1245[4].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1245[4].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1245[4].classList.add("pt-" + numberOfLessons);
                                hour1245[4].rowSpan = "" + numberOfLessons;
                                for (var bq = numberOfLessons + 4; bq >= 6; bq--) {
                                    timeList[bq][4].remove();
                                }
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1245[5].innerHTML = course + "<br>" + room + "<br>";
                                for (var br = 0; br < teachers.length; br++) {
                                    hour1245[5].innerHTML += teachers[br] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1245[5].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1245[5].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1245[5].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1245[5].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1245[5].classList.add("pt-" + numberOfLessons);
                                hour1245[5].rowSpan = "" + numberOfLessons;
                                for (var bs = numberOfLessons + 4; bs >= 6; bs--) {
                                    console.log(bs);
                                    console.log(timeList[bs]);
                                    timeList[bs][5].remove();
                                }
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
                                hour1340[1].innerHTML = course + "<br>" + room + "<br>";
                                for (var bt = 0; bt < teachers.length; bt++) {
                                    hour1340[1].innerHTML += teachers[bt] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1340[1].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1340[1].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1340[1].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1340[1].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1340[1].classList.add("pt-" + numberOfLessons);
                                hour1340[1].rowSpan = "" + numberOfLessons;
                                for (var bu = numberOfLessons + 5; bu >= 7; bu--) {
                                    timeList[bu][1].remove();
                                }
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour1340[2].innerHTML = course + "<br>" + room + "<br>";
                                for (var bv = 0; bv < teachers.length; bv++) {
                                    hour1340[2].innerHTML += teachers[bv] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1340[2].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1340[2].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1340[2].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1340[2].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1340[2].classList.add("pt-" + numberOfLessons);
                                hour1340[2].rowSpan = "" + numberOfLessons;
                                for (var bw = numberOfLessons + 5; bw >= 7; bw--) {
                                    timeList[bw][2].remove();
                                }
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1340[3].innerHTML = course + "<br>" + room + "<br>";
                                for (var bx = 0; bx < teachers.length; bx++) {
                                    hour1340[3].innerHTML += teachers[bx] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1340[3].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1340[3].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1340[3].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1340[3].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1340[3].classList.add("pt-" + numberOfLessons);
                                hour1340[3].rowSpan = "" + numberOfLessons;
                                for (var by = numberOfLessons + 5; by >= 7; by--) {
                                    timeList[by][3].remove();
                                }
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1340[4].innerHTML = course + "<br>" + room + "<br>";
                                for (var bz = 0; bz < teachers.length; bz++) {
                                    hour1340[1].innerHTML += teachers[bz] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1340[4].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1340[4].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1340[4].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1340[4].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1340[4].classList.add("pt-" + numberOfLessons);
                                hour1340[4].rowSpan = "" + numberOfLessons;
                                for (var ca = numberOfLessons + 5; ca >= 7; ca--) {
                                    timeList[ca][4].remove();
                                }
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1340[5].innerHTML = course + "<br>" + room + "<br>";
                                for (var cb = 0; cb < teachers.length; cb++) {
                                    hour1340[5].innerHTML += teachers[cb] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1340[5].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1340[5].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1340[5].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1340[5].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1340[5].classList.add("pt-" + numberOfLessons);
                                hour1340[5].rowSpan = "" + numberOfLessons;
                                for (var cd = numberOfLessons + 5; cd >= 7; cd--) {
                                    timeList[cd][5].remove();
                                }
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
                                hour1435[1].innerHTML = course + "<br>" + room + "<br>";
                                for (var ce = 0; ce < teachers.length; ce++) {
                                    hour1435[1].innerHTML += teachers[ce] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1435[1].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1435[1].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1435[1].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1435[1].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1435[1].classList.add("pt-" + numberOfLessons);
                                hour1435[1].rowSpan = "" + numberOfLessons;
                                for (var cf = numberOfLessons + 6; cf >= 8; cf--) {
                                    timeList[cf][1].remove();
                                }
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour1435[2].innerHTML = course + "<br>" + room + "<br>";
                                for (var cg = 0; cg < teachers.length; cg++) {
                                    hour1435[2].innerHTML += teachers[cg] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1435[2].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1435[2].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1435[2].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1435[2].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1435[2].classList.add("pt-" + numberOfLessons);
                                hour1435[2].rowSpan = "" + numberOfLessons;
                                for (var ch = numberOfLessons + 6; ch >= 8; ch--) {
                                    timeList[ch][2].remove();
                                }
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1435[3].innerHTML = course + "<br>" + room + "<br>";
                                for (var ci = 0; ci < teachers.length; ci++) {
                                    hour1435[3].innerHTML += teachers[ci] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1435[3].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1435[3].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1435[3].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1435[3].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1435[3].classList.add("pt-" + numberOfLessons);
                                hour1435[3].rowSpan = "" + numberOfLessons;
                                for (var cj = numberOfLessons + 6; cj >= 8; cj--) {
                                    timeList[cj][3].remove();
                                }
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1435[4].innerHTML = course + "<br>" + room + "<br>";
                                for (var ck = 0; ck < teachers.length; ck++) {
                                    hour1435[4].innerHTML += teachers[ck] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1435[4].classList.add("bg-danger");                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1435[4].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1435[4].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1435[4].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1435[4].classList.add("pt-" + numberOfLessons);
                                hour1435[4].rowSpan = "" + numberOfLessons;
                                for (var cl = numberOfLessons + 6; cl >= 8; cl--) {
                                    timeList[cl][4].remove();
                                }
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1435[5].innerHTML = course + "<br>" + room + "<br>";
                                for (var cm = 0; cm < teachers.length; cm++) {
                                    hour1435[5].innerHTML += teachers[cm] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1435[5].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1435[5].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1435[5].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1435[5].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1435[5].classList.add("pt-" + numberOfLessons);
                                hour1435[5].rowSpan = "" + numberOfLessons;
                                for (var cn = numberOfLessons + 6; cn >= 8; cn--) {
                                    timeList[cn][5].remove();
                                }
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
                                hour1530[1].innerHTML = course + "<br>" + room + "<br>";
                                for (var co = 0; co < teachers.length; co++) {
                                    hour1530[1].innerHTML += teachers[co] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1530[1].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1530[1].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1530[1].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1530[1].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1530[1].classList.add("pt-" + numberOfLessons);
                                hour1530[1].rowSpan = "" + numberOfLessons;
                                for (var cp = numberOfLessons + 7; cp >= 9; cp--) {
                                    timeList[cp][1].remove();
                                }
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour1530[2].innerHTML = course + "<br>" + room + "<br>";
                                for (var cq = 0; cq < teachers.length; cq++) {
                                    hour1530[2].innerHTML += teachers[cq] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1530[2].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1530[2].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1530[2].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1530[2].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1530[2].classList.add("pt-" + numberOfLessons);
                                hour1530[2].rowSpan = "" + numberOfLessons;
                                for (var cr = numberOfLessons + 7; cr >= 9; cr--) {
                                    timeList[cr][2].remove();
                                }
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1530[3].innerHTML = course + "<br>" + room + "<br>";
                                for (var cs = 0; cs < teachers.length; cs++) {
                                    hour1530[3].innerHTML += teachers[cs] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1530[3].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1530[3].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1530[3].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1530[3].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1530[3].classList.add("pt-" + numberOfLessons);
                                hour1530[3].rowSpan = "" + numberOfLessons;
                                for (var ct = numberOfLessons + 7; ct >= 9; ct--) {
                                    timeList[ct][3].remove();
                                }
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1530[4].innerHTML = course + "<br>" + room + "<br>";
                                for (var cu = 0; cu < teachers.length; cu++) {
                                    hour1530[4].innerHTML += teachers[cu] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1530[4].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1530[4].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1530[4].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1530[4].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1530[4].classList.add("pt-" + numberOfLessons);
                                hour1530[4].rowSpan = "" + numberOfLessons;
                                for (var cv = numberOfLessons + 7; cv >= 9; cv--) {
                                    timeList[cv][4].remove();
                                }
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1530[5].innerHTML = course + "<br>" + room + "<br>";
                                for (var cw = 0; cw < teachers.length; cw++) {
                                    hour1530[5].innerHTML += teachers[cw] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1530[5].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1530[5].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1530[5].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1530[5].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1530[5].classList.add("pt-" + numberOfLessons);
                                hour1530[5].rowSpan = "" + numberOfLessons;
                                for (var cx = numberOfLessons + 7; cx >= 9; cx--) {
                                    timeList[cx][5].remove();
                                }
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
                                hour1625[1].innerHTML = course + "<br>" + room + "<br>";
                                for (var cy = 0; cy < teachers.length; cy++) {
                                    hour1625[1].innerHTML += teachers[cy] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1625[1].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1625[1].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1625[1].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1625[1].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1625[1].classList.add("pt-" + numberOfLessons);
                                hour1625[1].rowSpan = "" + numberOfLessons;
                                for (var cz = numberOfLessons + 8; cz >= 10; cz--) {
                                    timeList[cz][1].remove();
                                }
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour1625[2].innerHTML = course + "<br>" + room + "<br>";
                                for (var da = 0; da < teachers.length; da++) {
                                    hour1625[2].innerHTML += teachers[da] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1625[2].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1625[2].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1625[2].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1625[2].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1625[2].classList.add("pt-" + numberOfLessons);
                                hour1625[2].rowSpan = "" + numberOfLessons;
                                for (var db = numberOfLessons + 8; db >= 10; db--) {
                                    timeList[db][2].remove();
                                }
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1625[3].innerHTML = course + "<br>" + room + "<br>";
                                for (var de = 0; de < teachers.length; de++) {
                                    hour1625[3].innerHTML += teachers[de] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1625[3].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1625[3].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1625[3].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1625[3].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1625[3].classList.add("pt-" + numberOfLessons);
                                hour1625[3].rowSpan = "" + numberOfLessons;
                                for (var df = numberOfLessons + 8; df >= 10; df--) {
                                    timeList[df][3].remove();
                                }
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1625[4].innerHTML = course + "<br>" + room + "<br>";
                                for (var dg = 0; dg < teachers.length; dg++) {
                                    hour1625[4].innerHTML += teachers[dg] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1625[4].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1625[4].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1625[4].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1625[4].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1625[4].classList.add("pt-" + numberOfLessons);
                                hour1625[4].rowSpan = "" + numberOfLessons;
                                for (var dh = numberOfLessons + 8; dh >= 10; dh--) {
                                    timeList[dh][4].remove();
                                }
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1625[5].innerHTML = course + "<br>" + room + "<br>";
                                for (var di = 0; di < teachers.length; di++) {
                                    hour1625[5].innerHTML += teachers[di] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1625[5].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1625[5].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1625[5].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1625[5].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1625[5].classList.add("pt-" + numberOfLessons);
                                hour1625[5].rowSpan = "" + numberOfLessons;
                                for (var dj = numberOfLessons + 8; dj >= 10; dj--) {
                                    timeList[dj][5].remove();
                                }
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
                                hour1720[1].innerHTML = course + "<br>" + room + "<br>";
                                for (var dl = 0; dl < teachers.length; dl++) {
                                    hour1720[1].innerHTML += teachers[dl] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1720[1].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1720[1].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1720[1].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1720[1].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1720[1].classList.add("pt-" + numberOfLessons);
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour1720[2].innerHTML = course + "<br>" + room + "<br>";
                                for (var dm = 0; dm < teachers.length; dm++) {
                                    hour1720[2].innerHTML += teachers[dm] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1720[2].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1720[2].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1720[2].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1720[2].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1720[2].classList.add("pt-" + numberOfLessons);
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour1720[3].innerHTML = course + "<br>" + room + "<br>";
                                for (var dn = 0; dn < teachers.length; dn++) {
                                    hour1720[3].innerHTML += teachers[dn] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1720[3].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1720[3].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1720[3].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1720[3].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1720[3].classList.add("pt-" + numberOfLessons);
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour1720[4].innerHTML = course + "<br>" + room + "<br>";
                                for (var dp = 0; dp < teachers.length; dp++) {
                                    hour1720[4].innerHTML += teachers[dp] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1720[4].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1720[4].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1720[4].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1720[4].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1720[4].classList.add("pt-" + numberOfLessons);

                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour1720[5].innerHTML = course + "<br>" + room + "<br>";
                                for (var dq = 0; dq < teachers.length; dq++) {
                                    hour1720[5].innerHTML += teachers[dq] + "  ";
                                }
                                switch (course) {
                                    case ("SDJ"):
                                        {
                                            hour1720[5].classList.add("bg-danger");
                                        }
                                        break;
                                    case ("DMA"):
                                        {
                                            hour1720[5].classList.add("bg-info");
                                        }
                                        break;
                                    case ("RWD"):
                                        {
                                            hour1720[5].classList.add("bg-primary");
                                        }
                                        break;
                                    case ("SEP"):
                                        {
                                            hour1720[5].classList.add("bg-warning");
                                        }
                                        break;
                                }
                                hour1720[5].classList.add("pt-" + numberOfLessons);
                            }
                            break;
                    }
                }
        }
    }
}
/*
function showTeachersInForm(xml) {
    var xmlDoc = xml.responseXML;
    var x = xmlDoc.getElementsByTagName("Session");
    var listLength = x.length;
   
    var i;

    var text = "";
    for (var i = 0; i < listLength; i++) {
        var teachers = x[i].getElementsByTagName("Teachers")[0].childNodes[0].nodeValue.split(",");
        text += teachers + "<br>";


    } document.getElementById("teacherprint").innerHTML = text;
}
*/




