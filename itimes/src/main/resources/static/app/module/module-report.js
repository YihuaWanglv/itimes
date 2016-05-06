ModuleReport = (function() {
	window.charts = {};
	var api = {
		category: '/report/category',
		categoryTime:'/report/category/time',
		project: '/report/project',
		projectTime: '/report/time/project',
		location: '/report/location',
		locationTime: '/report/time/location'
	}
	function showReport(_config) {
		$('#chart_container').append(getContainer(_config.key));
		loadReport(_config.key, _config.type, _config.title, _config.muti)
	}
	function getContainer(_id) {

		return '<div class="jumbotron">'
		    +'		<div class="container">'
		    +'  		<div class="row">'
		    +'    			<div>'
		    +'      			<canvas id="'+_id+'"></canvas>'
		    +'    			</div>'
		    +'  		</div>'
		    +'		</div>'
			+'	</div>';
	}
	function loadReport(_key, _type, _title, _muti) {
		var _url = api[_key];
		$.ajax({
	        type: "GET",
	        url: _url,
	        data: null,
	        success: function(data) {
	        	if (data) {
	        		var configData = initData(_type, data, _muti);
			        var ctx = document.getElementById(_key).getContext("2d");
			        var config = initConfig(_type, configData, null);
		            window.charts[_key] = new Chart(ctx, config);
	        	}
	        }
	    });
	}
	function initData(_type, _data, _muti) {
		var label = [];
        var datasets = [];
        label = _data.data.labels;
      	var ds = _data.data.dataset;
      	for (var key in ds) {
      		var dataset = {};
      		dataset.label = key;
      		dataset.data = ds[key];
      		if (_type == 'bar') {
      			dataset.backgroundColor = "rgba(220,220,220,0.5)";
      		} else if (_type == 'line') {
      			dataset.fill = false;
	      		dataset.borderColor = Lib_Random.randomColor(0.4);
	      		dataset.backgroundColor = Lib_Random.randomColor(0.5);
	      		dataset.pointBorderColor = Lib_Random.randomColor(0.7);
	      		dataset.pointBackgroundColor = Lib_Random.randomColor(0.5);
	      		dataset.pointBorderWidth = 1;
      		}
      		datasets.push(dataset);
      	}
		var data = {
            labels: label,
            datasets: datasets
        };
      	return data;
	}
	function initConfig(_type, _data, _option) {
		var c = {
			type: _type||'bar',
            data: _data||[],
            options: _option||{
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
                    text: 'TimeItem时间统计报告'
                }
            }
		};
		return c;
	}
	
	return {
		getContainer:getContainer,
		showReport: showReport
	}
})();