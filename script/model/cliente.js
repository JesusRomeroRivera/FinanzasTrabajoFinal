class Cliente{
    constructor(id, nombre, apellido, categoriaDocumento, correo, direccion, password, telefono){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.categoriaDocumento = categoriaDocumento;
        this.correo = correo;
        this.direccion = direccion;
        this.password = password;
        this.telefono = telefono;
    }

    loadFromParsedJson(object){
        this.id = object.id;
        this.nombre = object.nombre;
        this.apellido = object.apellido;
        this.categoriaDocumento = object.categoriaDocumento;
        this.correo = object.correo;
        this.direccion = object.direccion;
        this.password = object.password;
        this.telefono = object.telefono;
    }

    loadFromJson(json){
        var parsedTienda = JSON.parse(json);

        this.id = parsedTienda.id;
        this.nombre = parsedTienda.nombre;
        this.apellido = parsedTienda.apellido;
        this.categoriaDocumento = parsedTienda.categoriaDocumento;
        this.correo = parsedTienda.correo;
        this.direccion = parsedTienda.direccion;
        this.password = parsedTienda.password;
        this.telefono = parsedTienda.telefono;
    }

    stringify(){
        return JSON.stringify(this);
    }
}