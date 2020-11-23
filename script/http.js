function httpGet(theUrl)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false );
    xmlHttp.send( null );
    return xmlHttp;
}

function httpPost(theUrl, sendObject)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "POST", theUrl, false );
    xmlHttp.setRequestHeader("Content-Type", "application/json");
    xmlHttp.send( sendObject );
    return xmlHttp;
}

function httpPut(theUrl, sendObject)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "PUT", theUrl, false );
    //xmlHttp.setRequestHeader("Content-Type", "application/json");
    xmlHttp.send( sendObject );
    return xmlHttp;
}

function httpDelete(theUrl, sendObject)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "DELETE", theUrl, false );
    //xmlHttp.setRequestHeader("Content-Type", "application/json");
    xmlHttp.send( sendObject );
    return xmlHttp;
}