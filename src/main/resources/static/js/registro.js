  function getUrlSearch(key) {
    key = key.replace(/[[]/, '\[');
    key = key.replace(/[]]/, '\]');
    var pattern = "[\?&]" + key + "=([^&#]*)";
    var regex = new RegExp(pattern);
    var url = unescape(window.location.href);
    var results = regex.exec(url);

    if (results === null) {
        return null;
    }

    return results[1];
}
let alertUrl=getUrlSearch("alert")

if(alertUrl == "exist"){
    Swal.fire({
        icon: "error",
        text:"¡El usuario asociado con ese email ya existe!",
        title: 'Error',
        confirmButtonText: "Ok",
    }).then((result) => {
        window.location.href = '/registro';
    })

}
if(alertUrl == "succes"){
    Swal.fire({
        icon: "success",
        text:"¡Inicia Sesion para continuar",
        title: 'Registro exitoso',
        confirmButtonText: "Ok",
    }).then((result) => {
        window.location.href = '/home';
    })

}
if(alertUrl == "logout"){
    Swal.fire({
        icon: "success",
        text: 'Cerraste Sesion Exitosamente',
        confirmButtonText: "Ok",
    }).then((result) => {
        window.location.href = '/home';
    })

}


console.log(alertUrl)