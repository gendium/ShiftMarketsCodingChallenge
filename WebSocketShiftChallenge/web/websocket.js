/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.onload = init;
var socket = new WebSocket("ws://localhost:8080/WebSocketShiftChallenge/actions");
socket.onmessage = onMessage;

function onMessage(event){
    var data = JSON.parse(event.data);
    if(data.action ==="check"){
        printSymbolValue(data);
    }
}

function checkCC(ccSymbol){
    var CryptoSymbol = {
        action: "check",
        symbol: ccSymbol
    };
    socket.send(JSON.stringify(CryptoSymbol));
}

function printSymbolValue(symbol)
{
    var content = document.getElementById("ccResult");
    content.innerHTML = "<b> symbol pair: </b>" + symbol.symbol + " <b> has value: </b>" + symbol.value;
}


function formSubmitCC() {
    var form = document.getElementById("checkCC");
    var ccSymbol = form.elements["crypto_symbol"].value;
    form.reset();
    checkCC(ccSymbol);
}

function init() {
    var content = document.getElementById("ccResult");
    content.innerHTML = "";
}
