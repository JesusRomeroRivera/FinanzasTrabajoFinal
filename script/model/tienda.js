class Tienda{
    constructor(nombre, correo, direccion, password){
        this.id = 0;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.password = password;
    }

    loadFromParsedJson(object){
        this.id = object.id;
        this.nombre = object.nombre;
        this.correo = object.correo;
        this.direccion = object.direccion;
        this.password = object.password;
    }

    loadFromJson(json){
        var parsedTienda = JSON.parse(json);
        this.id = parsedTienda.id;
        this.nombre = parsedTienda.nombre;
        this.correo = parsedTienda.correo;
        this.direccion = parsedTienda.direccion;
        this.password = parsedTienda.password;
    }

    stringify(){
        return JSON.stringify(this);
    }
}


export { Tienda };