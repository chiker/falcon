var stompClient = null;

function connect() {
    var socket = new SockJS('/pipeline-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/pipeline/requests', function (request) {
            showRequest(request.body);
        });
    });
}

function showRequest(message) {
    var row = $("<tr>").append('<td>' + new Date($.now()) + '</td>')
                     .append('<td>' + message + '</td>');

    $("#requests > tbody").append(row);
}

$(function () {
    connect();
});