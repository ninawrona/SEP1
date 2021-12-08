var document, DOMParser;


//Write your function declarations below this line
//example of a function getting and returning the book titles from the XML "text"
function displayBookTitle(n) {
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(text, "text/xml");
    var x = xmlDoc.getElementsByTagName("title");
    return x[n].childNodes[0].nodeValue;
}

function displayAuthor(n){
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(text, "text/xml");
    var x = xmlDoc.getElementsByTagName("author");
    return x[n].childNodes[0].nodeValue;
}

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


function readXML(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200){
            showData(xhttp);
        }
    };
    xhttp.open("GET", "../../SessionList.xml", true);
    xhttp.send();
}

function showData(xml){
    var xmlDoc = xml.responseXML;
    var x = xmlDoc.getElementsByTagName("SessionList");
    var listLength = x.length;

    var table = "<table><tr><th>Time</th><th>Monday</th><th>Tuesday</th><th>Wednesday</th><th>Thursday</th><th>Friday</th><th>Saturday</th><th>Sunday</th></tr>";

    for (var i = 0; i < listLength; i++){
        var numberOfLessons = x.getElementsByTagName("NumberOfLessons").childNodes[0].nodeValue
        if (x.getElementsByTagName("StartTime")[0].childNodes[0].nodeValue == "8:20"){

        }
        
        table +=
        "<tr><td>" + x[i].getElementsByTagName("author")[0].childNodes[0].nodeValue +
        "</td><td>" + x[i].getElementsByTagName("title")[0].childNodes[0].nodeValue +
        "</td><td>" + x[i].getElementsByTagName("year")[0].childNodes[0].nodeValue +
        "</td></tr>";
        
    }
    table+= "</table>";
    document.getElementById("HP").innerHTML = table;
}