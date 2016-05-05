$(function() {

	$.ajax({
		type : "GET",
		url : "/data/user/config",
		data : null,
		success : function(data) {
			console.log(data);
			if (data) {
				if (data.isreportCategory) {
					$.ajax({
				        type: "GET",
				        url: "/report/category",
				        data: null,
				        success: function(data) {
				          	console.log(data);
				          	var label = [];
				          	var datas = [];
				          	for (var i = 0; i < data.length; i++) {
				          		label.push(data[i].categoryName);
				          		datas.push(data[i].durations);
				          	}
				          	var barChartData = {
					            labels: label,
					            datasets: [{
					                label: '按分类统计',
					                backgroundColor: "rgba(220,220,220,0.5)",
					                data: datas
					            }]
					        };
					        var ctx = document.getElementById("j-canvas-category").getContext("2d");
				            window.myBar = new Chart(ctx, {
				                type: 'bar',
				                data: barChartData,
				                options: {
				                    elements: {
				                        rectangle: {
				                            borderWidth: 2,
				                            borderColor: 'rgb(0, 255, 0)',
				                            borderSkipped: 'bottom'
				                        }
				                    },
				                    responsive: true,
				                    legend: {
				                        position: 'top',
				                    },
				                    title: {
				                        display: true,
				                        text: 'Chart.js Bar Chart'
				                    }
				                }
				            });
				        }
				    });
				} else {
					$('#j-canvas-category').hide();
				}
				if (data.isreportCategoryTime) {
					$.ajax({
				        type: "GET",
				        url: "/report/categoryTime",
				        data: null,
				        success: function(data) {
				          console.log(data);
				        }
				    });
				} else {
					$('#j-canvas-category-time').hide();
				}
				if (data.isreportLocation) {

				} else {
					$('#j-canvas-location').hide();
				}
				if (!data.isreportLocation && !data.isreportLocationTime) {
					$('#j-container-location').hide();
				}

			}
		}
	});

});