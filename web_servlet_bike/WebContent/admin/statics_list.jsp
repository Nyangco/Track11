<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<div id="container">	
	<div id="b_right">
		<p class="n_title">
			PURCHASE
		</p>
		<form name="admin">
			<table class="boardForm">
				<colgroup>
					<col width="100">
					<col width="100">
					<col width="152">
					<col width="352">
				</colgroup>
				<tr class="statics_text">
					<th colspan="2">총 판매 건 수</th>
					<td colspan="2">
						<input type="text" name="" value="${t_t_count}" readonly style="border:none;">
					</td>
				</tr>
				<tr class="statics_text">
					<th colspan="2">총 매출액</th>
					<td colspan="2">
						<input type="text" name="" value="${t_t_sell }" readonly style="border:none;">
					</td>
				</tr>
				<tr>
					<th colspan="3">
						제품별 판매 건수
					</th>
					<th>
						고객별 매출액 
					</th>
				</tr>
				<tr>
					<td colspan="3">
						<div style="width: 352px; height: 176px;">
							<canvas id="p_Count"></canvas>
						</div>
					</td>
					<td>
						<div style="width: 352px; height: 176px;">
							<canvas id="c_Cell"></canvas>
						</div>
					</td>
				</tr>
				<tr>
					<th colspan="2">월별 통계</th>
					<td colspan="2"><input type="month" name="t_month" onchange="goStatics(this.value)"></td>
				</tr>
			</table>
			<div id="hide" style="display:none;">
			<table class="boardForm">
				<colgroup>
					<col width="100">
					<col width="100">
					<col width="152">
					<col width="352">
				</colgroup>
				
					<tr class="statics_text ">
						<th colspan="2">총 판매 건 수</th>
						<td colspan="2">
							<input type="text" name="t_count_m" readonly style="border:none;">
						</td>
					</tr>
					<tr class="statics_text ">
						<th colspan="2">총 매출액</th>
						<td colspan="2">
							<input type="text" name="t_sell_m" readonly style="border:none;">
						</td>
					</tr>
					<tr >
						<th colspan="3">
							제품별 판매 건수
						</th>
						<th>
							고객별 매출액 
						</th>
					</tr>
					<tr >
						<td colspan="3">
							<div style="width: 352px; height: 176px;">
							<canvas id="p_Count_m"></canvas>
						</div>
						</td>
						<td>
							<div style="width: 352px; height: 176px;">
							<canvas id="c_Cell_m"></canvas>
						</div>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</div>
<script>
	function goStatics(ym){
		var p_count_m_label, p_count_m_value, c_cell_m_label, c_cell_m_value;
		$.ajax({
			type : 'POST',
			url : 'Statics_month',
			data: 't_month='+ym,
			dataType : 'text',
			error : function(){
				alert('통신 실패');
			},
			success : function(data){
				var jsob = JSON.parse(data);
				admin.t_count_m.value = jsob.t_t_count_m;
				admin.t_sell_m.value = jsob.t_t_sell_m;
				console.log(jsob.t_p_count_m_label);
				console.log(jsob.t_p_count_m_value);
				
				var labels = data.jsonarray.map(function(e) {
				   return e.name;
				});
				
				var context = document
			        .getElementById('p_Count_m')
			        .getContext('2d');
			    var p_Count_m = new Chart(context, {
			        type: 'bar', // 차트의 형태
			        data: { // 차트에 들어갈 데이터
			            labels: [jsob.t_p_count_m_label],
			            datasets: [
			                { //데이터
			                    label: '판매 건수', //차트 제목
			                    fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
			                    data: [jsob.t_p_count_m_value],
			                    backgroundColor: [
			                        //색상
			                        'rgba(255, 99, 132, 0.2)',
			                        'rgba(54, 162, 235, 0.2)',
			                        'rgba(255, 206, 86, 0.2)',
			                        'rgba(75, 192, 192, 0.2)',
			                        'rgba(153, 102, 255, 0.2)'
			                    ],
			                    borderColor: [
			                        //경계선 색상
			                        'rgba(255, 99, 132, 1)',
			                        'rgba(54, 162, 235, 1)',
			                        'rgba(255, 206, 86, 1)',
			                        'rgba(75, 192, 192, 1)',
			                        'rgba(153, 102, 255, 1)'
			                    ],
			                    borderWidth: 1 //경계선 굵기
			                }
			            ]
			        },
			        options: {
			            scales: {
			                yAxes: [
			                    {
			                        ticks: {
			                            beginAtZero: true
			                        }
			                    }
			                ]
			            },
			            legend: {
			                display: false
			            }
			        }
			    });
		    
		    var context = document
		        .getElementById('c_Cell_m')
		        .getContext('2d');
		    var c_cell_m = new Chart(context, {
		        type: 'bar', // 차트의 형태
		        data: { // 차트에 들어갈 데이터
		            labels: [jsob.t_c_cell_m_label],
		            datasets: [
		                { //데이터
		                    label: '판매 건수', //차트 제목
		                    fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
		                    data: [jsob.t_c_cell_m_value],
		                    backgroundColor: [
		                        //색상
		                        'rgba(255, 99, 132, 0.2)',
		                        'rgba(54, 162, 235, 0.2)',
		                        'rgba(255, 206, 86, 0.2)',
		                        'rgba(75, 192, 192, 0.2)',
		                        'rgba(153, 102, 255, 0.2)'
		                    ],
		                    borderColor: [
		                        //경계선 색상
		                        'rgba(255, 99, 132, 1)',
		                        'rgba(54, 162, 235, 1)',
		                        'rgba(255, 206, 86, 1)',
		                        'rgba(75, 192, 192, 1)',
		                        'rgba(153, 102, 255, 1)'
		                    ],
		                    borderWidth: 1 //경계선 굵기
		                }
		            ]
		        },
		        options: {
		            scales: {
		                yAxes: [
		                    {
		                        ticks: {
		                            beginAtZero: true
		                        }
		                    }
		                ]
		            },
		            legend: {
		                display: false
		            }
		        }
		    });
		    $('#hide').show();
			}
		});				
	}
</script>
<script type="text/javascript">
    var context = document
        .getElementById('p_Count')
        .getContext('2d');
    var p_Count = new Chart(context, {
        type: 'bar', // 차트의 형태
        data: { // 차트에 들어갈 데이터
            labels: [${t_p_count_label}],
            datasets: [
                { //데이터
                    label: '판매 건수', //차트 제목
                    fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
                    data: [${t_p_count_value}],
                    backgroundColor: [
                        //색상
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)'
                    ],
                    borderColor: [
                        //경계선 색상
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)'
                    ],
                    borderWidth: 1 //경계선 굵기
                }
            ]
        },
        options: {
            scales: {
                yAxes: [
                    {
                        ticks: {
                            beginAtZero: true
                        }
                    }
                ]
            },
            legend: {
                display: false
            }
        }
    });
    var context = document
        .getElementById('c_Cell')
        .getContext('2d');
    var c_Cell = new Chart(context, {
        type: 'bar', // 차트의 형태
        data: { // 차트에 들어갈 데이터
            labels: [${t_c_cell_label}],
            datasets: [
                { //데이터
                    label: '매출액', //차트 제목
                    fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
                    data: [${t_c_cell_value}],
                    backgroundColor: [
                        //색상
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        //경계선 색상
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1 //경계선 굵기
                }
            ]
        },
        options: {
            scales: {
                yAxes: [
                    {
                        ticks: {
                            beginAtZero: true
                        }
                    }
                ]
            },
            legend: {
                display: false
            }
        }
    });
</script>
<%@include file="../common_footer.jsp" %>
