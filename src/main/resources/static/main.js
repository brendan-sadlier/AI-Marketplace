
window.onload = function () {
    //line chart
    new Chart(document.getElementById("chart1"), {
        type : 'line',
        data : {
            labels : [ 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday' ],
            datasets : [
                {
                    data : [ 186, 205, 1321, 1516, 2107, 2191, 3133 ],
                    label: 'Total',
                    borderColor : "#3cba9f",
                    fill : false,
                    lineTension: 0
                }]
        },
        options : {
            title : {
                display : true,
                text : 'Daily Sales ($)'
            }
        }
    });

    //first bar chart
    new Chart(document.getElementById("chart2"), {
    type: 'bar',
    data: {
    labels: ["MNIST", "Iris", "Banknote Authenticator", "ChatGPT", "Cancer recognition"],
    datasets: [
{
    label: "$",
    backgroundColor: ["#51EAEA", "#FCDDB0", "#FF9D76", "#FB3569", "#82CD47"],
    data: [478, 267, 829, 1732, 1213]
}]
},
    options: {
    indexAxis: 'y',
    legend: {
    display: false
},
    title: {
    display: true,
    text: 'Best Selling Models ($)'
}
}
});

    //second bar chart
    new Chart(document.getElementById("chart3"), {
    type: 'bar',
    data: {
    labels: ["MNIST", "Iris", "Banknote Authenticator", "ChatGPT", "Cancer recognition"],
    datasets: [
{
    label: "$",
    backgroundColor: ["#51EAEA", "#FCDDB0", "#FF9D76", "#FB3569", "#82CD47"],
    data: [478, 267, 829, 1732, 1213]
}]
},
    options: {
    indexAxis: 'y',
    legend: {
    display: false
},
    title: {
    display: true,
    text: 'Most viewed products'
}
}
});
}