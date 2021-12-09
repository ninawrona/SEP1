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
var number = 2;
hour820[1].innerHTML = "RWD" + "<br>" + "C05.16a" + "<br>" + "SVA"
hour820[1].classList.add("bg-danger")
hour820[1].classList.add("pt-"+number)
hour820[1].rowSpan = ""+number

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
    var x = xmlDoc.getElementsByTagName("SessionList");
    var listLength = x.length;
    for (var i = 0; i < listLength; i++) {
        var course = x.getElementsByTagName("Course").childNodes[0].nodeValue;
        var room = x.get.getElementsByTagName("Room").childNodes[0].nodeValue;
        var teachers = x.getElementsByTagName("Teachers").childNodes[0].nodeValue.split(",")
        //var teacher = x.get.getElementsByTagName("Teachers").childNodes[0].nodeValue;
        var numberOfLessons = x.getElementsByTagName("NumberOfLessons").childNodes[0].nodeValue;
        var startTime = x.getElementsByTagName("StartTime")[0].childNodes[0].nodeValue;
        var weekDay = x.getElementsByTagName("WeekDay")[0].childNodes[0].nodeValue;
        switch (startTime) {
            case ("8:20"):
                {
                    switch (weekDay) {
                        case ("MONDAY"):
                            {
                                hour820[1].innerHTML = course + "<br>" + room + + "<br>"
                                for(var i = 0; i<teachers.length; i++)
                                {   
                                    hour820[1].innerHTML+=teachers[i]+"  ";
                                }
                                switch(course)
                                {
                                    case("SDJ"):
                                    {
                                        hour820[1].classList.add("bg-danger")
                                    }
                                    break;
                                    case("DMA"):
                                    {
                                        hour820[1].classList.add("bg-info")
                                    }
                                    break;
                                    case("RWD"):
                                    {
                                        hour820[1].classList.add("bg-primary")
                                    }
                                    break;
                                    case("SEP"):
                                    {
                                        hour820[1].classList.add("bg-warning")
                                    }
                                    break;
                                }
                                hour820[1].classList.add("pt-"+numberOfLessons)
                                hour820[1].rowSpan = ""+numberOfLessons
                            }
                            break;
                        case ("TUESDAY"):
                            {
                                hour820[1].innerHTML = course + "<br>" + room + + "<br>"
                                for(var i = 0; i<teachers.length; i++)
                                {   
                                    hour820[1].innerHTML+=teachers[i]+"  ";
                                }
                                switch(course)
                                {
                                    case("SDJ"):
                                    {
                                        hour820[1].classList.add("bg-danger")
                                    }
                                    break;
                                    case("DMA"):
                                    {
                                        hour820[1].classList.add("bg-info")
                                    }
                                    break;
                                    case("RWD"):
                                    {
                                        hour820[1].classList.add("bg-primary")
                                    }
                                    break;
                                    case("SEP"):
                                    {
                                        hour820[1].classList.add("bg-warning")
                                    }
                                    break;
                                }
                                hour820[1].classList.add("pt-"+numberOfLessons)
                                hour820[1].rowSpan = ""+numberOfLessons
                            }
                            break;
                        case ("WEDNESDAY"):
                            {
                                hour820[1].innerHTML = course + "<br>" + room + + "<br>"
                                for(var i = 0; i<teachers.length; i++)
                                {   
                                    hour820[1].innerHTML+=teachers[i]+"  ";
                                }
                                switch(course)
                                {
                                    case("SDJ"):
                                    {
                                        hour820[1].classList.add("bg-danger")
                                    }
                                    break;
                                    case("DMA"):
                                    {
                                        hour820[1].classList.add("bg-info")
                                    }
                                    break;
                                    case("RWD"):
                                    {
                                        hour820[1].classList.add("bg-primary")
                                    }
                                    break;
                                    case("SEP"):
                                    {
                                        hour820[1].classList.add("bg-warning")
                                    }
                                    break;
                                }
                                hour820[1].classList.add("pt-"+numberOfLessons)
                                hour820[1].rowSpan = ""+numberOfLessons
                            }
                            break;
                        case ("THURSDAY"):
                            {
                                hour820[1].innerHTML = course + "<br>" + room + + "<br>"
                                for(var i = 0; i<teachers.length; i++)
                                {   
                                    hour820[1].innerHTML+=teachers[i]+"  ";
                                }
                                switch(course)
                                {
                                    case("SDJ"):
                                    {
                                        hour820[1].classList.add("bg-danger")
                                    }
                                    break;
                                    case("DMA"):
                                    {
                                        hour820[1].classList.add("bg-info")
                                    }
                                    break;
                                    case("RWD"):
                                    {
                                        hour820[1].classList.add("bg-primary")
                                    }
                                    break;
                                    case("SEP"):
                                    {
                                        hour820[1].classList.add("bg-warning")
                                    }
                                    break;
                                }
                                hour820[1].classList.add("pt-"+numberOfLessons)
                                hour820[1].rowSpan = ""+numberOfLessons
                            }
                            break;
                        case ("FRIDAY"):
                            {
                                hour820[1].innerHTML = course + "<br>" + room + + "<br>"
                                for(var i = 0; i<teachers.length; i++)
                                {   
                                    hour820[1].innerHTML+=teachers[i]+"  ";
                                }
                                switch(course)
                                {
                                    case("SDJ"):
                                    {
                                        hour820[1].classList.add("bg-danger")
                                    }
                                    break;
                                    case("DMA"):
                                    {
                                        hour820[1].classList.add("bg-info")
                                    }
                                    break;
                                    case("RWD"):
                                    {
                                        hour820[1].classList.add("bg-primary")
                                    }
                                    break;
                                    case("SEP"):
                                    {
                                        hour820[1].classList.add("bg-warning")
                                    }
                                    break;
                                }
                                hour820[1].classList.add("pt-"+numberOfLessons)
                                hour820[1].rowSpan = ""+numberOfLessons
                            }
                            break;
                    }
                }
                break;
        }

        table +=
            "<tr><td>" + x[i].getElementsByTagName("author")[0].childNodes[0].nodeValue +
            "</td><td>" + x[i].getElementsByTagName("title")[0].childNodes[0].nodeValue +
            "</td><td>" + x[i].getElementsByTagName("year")[0].childNodes[0].nodeValue +
            "</td></tr>";

    }
    table += "</table>";
    document.getElementById("HP").innerHTML = table;
}