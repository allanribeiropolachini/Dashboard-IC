function validacaoEmail(field) {
usuario = field.value.substring(0, field.value.indexOf("@"));
dominio = field.value.substring(field.value.indexOf("@")+ 1, field.value.length);

    if ((usuario.length >=1) &&
        (dominio.length >=3) && 
        (usuario.search("@")==-1) && 
        (dominio.search("@")==-1) &&
        (usuario.search(" ")==-1) && 
        (dominio.search(" ")==-1) &&
        (dominio.search(".")!=-1) &&      
        (dominio.indexOf(".") >=1)&& 
        (dominio.lastIndexOf(".") < dominio.length - 1)) {
        document.getElementById("message_email1").innerHTML='';
    }else{
    document.getElementById("message_email1").innerHTML='<div class="alert fade in"> <button type="button" class="close" data-dismiss="alert">×</button> <strong>Error!</strong> <br>Type an valid email.</div>';
    }
}

function check_email() {
  if (document.getElementById('email').value ==
    document.getElementById('confirm_email').value) {
    document.getElementById("message_email2").innerHTML='';
  } else {
    document.getElementById('message_email2').innerHTML = '<div class="alert fade in"> <button type="button" class="close" data-dismiss="alert">×</button> <strong>Error!</strong> <br>The email is not matching.</div>';
  }
}

function check_password() {
  if (document.getElementById('password').value ==
    document.getElementById('confirm_password').value) {
    document.getElementById("message_password").innerHTML='';
  } else {
    document.getElementById('message_password').innerHTML = '<div class="alert fade in"> <button type="button" class="close" data-dismiss="alert">×</button> <strong>Error!</strong> <br>The password is not matching.</div>';
  }
}