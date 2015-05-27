/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var code;

var readLocal = "";
$(document).ready(function(){

$("#adminLogin:login_button").click(function(){
    code = $('#adminLogin:code').text();
    saveToLocal(code);
});


    console.log("js ran!");
});

function saveToLocal(code){
   
       if (typeof(Storage) != "undefined") {
            localStorage.setItem("user", code);
       }

         console.log(code);
    
}


function getUserCode(){
    
  return readLocal = "action=\"#{webBean.checkLogin("+localStorage.getItem("user")+")}";

}