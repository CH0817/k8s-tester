function directRequestToK8S() {
    console.info(BACKEND_SERVER);
    $.ajax({
        url: BACKEND_SERVER + '/test/hello/' + getUsername(),
        timeout: 3000,
        xhrFields: {withCredentials: true},
        success: showSuccess,
        error: showError
    });
}

function requestFromBackendIngress() {
    $.ajax({
        url: '/test/k8s/' + getUsername(),
        timeout: 3000,
        xhrFields: {withCredentials: true},
        success: showSuccess,
        error: showError
    });
}

function requestIngress() {
    $.ajax({
        url: 'http://backend.k8s.tester.com.tw/test/hello/' + getUsername(),
        timeout: 3000,
        xhrFields: {withCredentials: true},
        success: showSuccess,
        error: showError
    });
}

function requestGateway() {
    console.info(GATEWAY_SERVER);
    $.ajax({
        url: GATEWAY_SERVER + '/back/test/hello/' + getUsername(),
        timeout: 3000,
        xhrFields: {withCredentials: true},
        success: showSuccess,
        error: showError
    });
}

function getUsername() {
    let username = $('#username').val();
    if (!username) {
        username = 'rex';
    }
    return username;
}

function showSuccess(data) {
    alert(data);
    console.info(document.cookie);
}

function showError(jqXHR) {
    console.info(jqXHR.responseText);
    console.error(jqXHR);
}