/**
 * 공통스크립트소스
 */


/*
 * ajax 호출 공통
 * 
 * @param url 대상 url지정 <br/>
 *        param 폼데이터 json방식으로 데이터 전송..<br/>
 *        callback 콜백함수 지정
 * */
function ajaxCall(url, param, callback){
	$.ajax({
		url : url,
		data : param,
		dataType : 'json',
		success : function(data){callback(data)},
		timeout:5000,
		error : function(e){
			console.log(e);
			alert("에러가 발생했습니다. 관리자에게 문의해 주시기 바랍니다.");
		}		
	})	
}