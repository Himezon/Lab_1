document.addEventListener("DOMContentLoaded", function (){
    document.getElementById("button").addEventListener("click", submit)
    document.getElementById("cleaning_button").addEventListener("click", () => send_request('POST', 'clear.php'))
    })

function submit() {
    if (checkY() && checkR()) {
        let params = "?x="
        document.getElementsByName("select").forEach(x => {
            params += x.value
        })
        params += "&y=" + parseFloat(document.getElementById("y").value.substring(0, 12).replace(',', '.'))
        params += "&r=" + parseFloat(document.getElementById("r").value.substring(0, 12).replace(',', '.'))
        send_request('POST', 'calculator.php', params)
    }
}

function send_request(method, url, params = '') {
    new Promise((resolve, reject) => {
        let xhr = new XMLHttpRequest()
        xhr.open(method, url + params)
        xhr.onload = () => {
            if (xhr.status >= 400)
                reject()
            else
                resolve(xhr)
        }
        xhr.onerror = () => {
            reject(xhr)
        }
        xhr.send()
    }).then(xhr => {
        let response = xhr.responseText
        if (response !== "") document.querySelector(".result_table").innerHTML = response
        else alert("Error in the request!")
    }).catch((xhr) => {
        if (xhr.status === 400) alert("Error in the request!")
        else alert("Unknown error")
    })
}

function checkY() {
    let y = document.getElementById("y")
    if (y.value.trim() === "") {
        alert("Y field must be filled!")
        return false
    }
    let yVal = y.value.replace(',', '.').substring(0, 12)
    if (!isFinite(yVal)) {
        alert("Y must be a number!")
        return false
    }
    if (yVal <= -5 || yVal >= 3) {
        alert("Y must be in range: (-5; 3)!")
        return false
    } else {
        return true
    }
}

function checkR() {
    let r = document.getElementById("r")
    if (r.value.trim() === "") {
        alert("R field must be filled!")
        return false
    }
    let rVal = r.value.replace(',', '.').substring(0, 12)
    if (!isFinite(rVal)) {
        alert("R must be a number!")
        return false
    }
    if (rVal <= 2 || rVal >= 5) {
        alert("R must be in range: (2; 5)!")
        return false
    } else {
        return true
    }
}