<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<script>
	function goStatics(ym){
		$.ajax({
			type : 'POST',
			url : 'Statics_month',
			data: 't_month='+ym,
			dataType : 'text',
			error : function(){
				alert('통신 실패');
			},
			success : function(data){
				console.log();
			}
		});				
	}
	function barChart(){
		var data = {
				labels: [],
				datasets: [
					{
						label: "",
						fillColor: "rgba(150,200,250,0.5)",
						strokeColor: "rgba(150,200,250,0.8)",
						highlightFill: "rgba(150,200,250,0.75)",
						highlightStroke: "rgba(150,200,250,1)",
						data: [65, 59, 80, 81, 56, 55, 30, 100, 120, 50, 11, 40, 70, 120]
					}
				]
			};
	    var ctx = document.getElementById("barCanvas").getContext("2d");
	    var options = { };
	    var barChart = new Chart(ctx).Bar(data, options);
	}
</script>
<style>
	.hidding{display:none;}
</style>
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
					<td colspan="2">${t_t_count}</td>
				</tr>
				<tr class="statics_text">
					<th colspan="2">총 매출액</th>
					<td colspan="2">${t_t_sell }</td>
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
						<div style="width: 352px; height: 352px;">
							<canvas id="p_Count"></canvas>
						</div>
					</td>
					<td>
						<div style="width: 352px; height: 352px;">
							<canvas id="c_Cell"></canvas>
						</div>
					</td>
				</tr>
				<tr>
					<th colspan="2">월별 통계</th>
					<td colspan="2"><input type="month" name="t_month" onchange="goStatics(this.value)"></td>
				</tr>
				<tr class="statics_text hidding">
					<th colspan="2">총 판매 건 수</th>
					<td colspan="2">
					
					</td>
				</tr>
				<tr class="statics_text hidding">
					<th colspan="2">총 매출액</th>
					<td colspan="2">
					
					</td>
				</tr>
				<tr class="hidding">
					<th colspan="3">
						제품별 판매 건수
					</th>
					<th>
						고객별 매출액 
					</th>
				</tr>
				<tr class="hidding">
					<td colspan="3">
						
					</td>
					<td>
					
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
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
                }/* ,
                {
                    label: 'test2',
                    fill: false,
                    data: [
                        8, 34, 12, 24
                    ],
                    backgroundColor: 'rgb(157, 109, 12)',
                    borderColor: 'rgb(157, 109, 12)'
                } */
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
            }
        }
    });
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
            }
        }
    });
</script>
<script type="text/javascript">
    var context = document
        .getElementById('c_Cell')
        .getContext('2d');
    var c_Cell = new Chart(context, {
        type: 'bar', // 차트의 형태
        data: { // 차트에 들어갈 데이터
            labels: [${t_c_cell_label}],
            datasets: [
                { //데이터
                    label: '판매 건수', //차트 제목
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
            }
        }
    });
</script>
<%@include file="../common_footer.jsp" %>
