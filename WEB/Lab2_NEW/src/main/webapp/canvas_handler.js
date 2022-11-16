function drawCanvas() {
    let canvas = document.getElementById("canvas"),
        context = canvas.getContext("2d");
    canvas.width = 500;
    canvas.height = 500;
    context.fillStyle = "#4a50f8"
    context.fillRect(250, 50, 200, 200);
    context.strokeRect(250, 50, 200, 200)
    context.beginPath();
    context.moveTo(250, 250);
    context.lineTo(150, 250);
    context.lineTo(250, 50);
    context.fill();
    context.moveTo(250, 250);
    context.arc(250, 250, 100, Math.PI / 2, Math.PI);
    context.fill();
    context.beginPath();
    context.strokeStyle = "#ffffff";
    context.lineWidth = 2;
    context.moveTo(0, 250);
    context.lineTo(500, 250);
    context.stroke();
    context.beginPath();
    context.strokeStyle = "#ffffff";
    context.lineWidth = 2;
    context.moveTo(250, 500);
    context.lineTo(250, 0);
    context.stroke();
    context.strokeText("R/2", 350, 247);
    context.strokeText("R", 450, 247);
    context.strokeText("R/2", 253, 350);
    context.strokeText("R", 253, 450);
    context.strokeText("R/2", 150, 247);
    context.strokeText("R/2", 253, 150);
    context.strokeText("R", 253, 50);
    context.strokeText("R/2", 350, 247);
    context.strokeText("R", 50, 247);
    context.strokeText("Y", 253, 10);
    context.strokeText("X", 490, 247);
    drawPoints();
}

function drawPoint(x, y, result) {
    let canvas = document.getElementById("canvas"),
        context = canvas.getContext("2d");
    context.strokeStyle = "#ffffff";
    if (result.toString().trim() === 'false') {
        context.fillStyle = "#FF2A1F";
    } else {
        context.fillStyle = "#5FFF33";
    }
    context.beginPath();
    context.arc(x, y, 5, 0, 2 * Math.PI);
    context.fill();
    context.stroke();
    context.closePath();
}

function drawPoints() {
    let Xs = Array.from(document.getElementsByClassName("the_X")).map(v => v.innerHTML);
    let Ys = Array.from(document.getElementsByClassName("the_Y")).map(v => v.innerHTML);
    let Rs = Array.from(document.getElementsByClassName("the_R")).map(v => v.innerHTML);
    let Results = Array.from(document.getElementsByClassName("the_Result")).map(v => v.innerHTML);
    for (let i = 0; i < Xs.length; i++) {
        drawRawPoint(Xs[i], Ys[i], Rs[i], Results[i])
    }
}

function drawRawPoint(x, y, r, res) {
    drawPoint(x / r * 400 / 2 + 250, y / r * (-400) / 2 + 250, res);
}

function handleCanvasClick(canvas, event) {
    let Rs = document.getElementById("R_field")
    const rect = canvas.getBoundingClientRect()
    const clickX = event.clientX - rect.left
    const clickY = event.clientY - rect.top
    let Xs = (clickX - 250) * Rs.value / 200
    let Ys = (-1) * (clickY - 250) * Rs.value / 200
    if (check(Xs.toString(), Ys.toString(), Rs.value.toString()))
        $.ajax({
            url: 'controllerServlet',
            type: 'GET',
            dataType: "json",
            data: {
                'X_field': Xs.toString(),
                'Y_field': Ys.toString(),
                'R_field': Rs.value.toString(),
                'Canvas_clicked': true
            }
        })
            .then(response => {
                console.log(response)
                let res = response['result']
                let x = response['x']
                let y = response['y']
                let r = response['r']
                let time = response['clock']['dateString']
                drawRawPoint(x, y, r, res)
                addToTable(x, y, r, res, time)
            })
            .catch(() => {
                alert("Your params didn't pass the validation.\nPlease, check that X is in [-4; 4], Y is in (-3, 5)")
            });
}

function addToTable(x, y, r, res, time) {
    let row =
        '<tr><th class=\'the_X\'>' + x +
        '</th><th class=\'the_Y\'>' + y +
        '</th><th class=\'the_R\'>' + r +
        '</th><th class=\'the_Result\' style=\'color:' + (res ? "lime" : "red") + '\'>' + res +
        '</th><th>' + time + '</th></tr>'
    $('.result_table tbody').prepend(row)
}