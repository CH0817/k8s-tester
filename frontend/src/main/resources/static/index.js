function testRequest() {
    $.get('http://localhost:8081/backend/test/hello/rex', data => {
        alert(data);
    });
}