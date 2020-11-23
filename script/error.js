function showError(json){
    parsedError = JSON.parse(json);

    console.log(parsedError.mensaje);
}