/**
 * 
 */
$(document).ready(function() {

	//Hien table thong tin trang welcome
	$("input[type='button']").click(function() {
		$("#table1").fadeToggle();
	})

	function check() {
		// Gom du lieu input vao Data
		var data = new Array();
		data[0] = document.getElementById('firstName').value;
		data[1] = document.getElementById('lastName').value;
		data[2] = document.getElementById('firstName_furigana').value;
		data[3] = document.getElementById('lastName_furigana').value;
		data[4] = document.getElementById('bday').value;
		data[5] = document.getElementById('gender').value;
		data[6] = document.getElementById('email').value;
		data[7] = document.getElementById('password').value;
		data[8] = document.getElementById('confirm_password').value;
		data[9] = document.getElementById('addres').value;
		data[10] = document.getElementById('country').value;

		// Tao mang thong bao loi
		var myError = new aArray();
		myError[0] = "<span style ='color:red, font-weight:bold'>Error</span>";
		myError[1] = "<span style ='color:red, font-weight:bold'>Error</span>";
		myError[2] = "<span style ='color:red, font-weight:bold'>Error</span>";
		myError[3] = "<span style ='color:red, font-weight:bold'>Error</span>";
		myError[4] = "<span style ='color:red, font-weight:bold'>Error</span>";
		myError[5] = "<span style ='color:red, font-weight:bold'>Error</span>";
		myError[6] = "<span style ='color:red, font-weight:bold'>Error</span>";
		myError[7] = "<span style ='color:red, font-weight:bold'>Error</span>";
		myError[8] = "<span style ='color:red, font-weight:bold'>Error</span>";
		myError[9] = "<span style ='color:red, font-weight:bold'>Error</span>";
		myError[10] = "<span style ='color:red, font-weight:bold'>Error</span>";

		// In loi ra div
		var nearby = new aArray("z-firstName", "z-lastName", "z-firstName_furigana", "z-lastName_furigana", "z-bday", "z-gender", "z-email", "z-password", "z-confirm_password", "z-addres", "z-country");

		// Tao vong lap For in loi
		for (i in data) {
			var error = myError;
			var div = nearby;
			if (data[i] == "") {
				document.getElementById(div).innerHTML = error;
			} else {
				document.getElementById(div).innerHTML = ("<i class='fas fa-times-circle'></i>");
			}
		}



		//Lay gia tri input
		//		var firstName = $("#firstName").val();
		//		var lastName = $("#lastName").val();
		//		var firstName_furigana = $("#firstName_furigana").val();
		//		var lastName_furigana = $("#lastName_furigana").val();
		//		var bday = $("#bday").val();
		//		var gender = $("#gioitinh").val();
		//		var email = $("#email").val();
		//		var password= $("#password").val();
		//		var confirm_password= $("confirm_password").val();
		//		var addres= $("#addres").val();
		//		var country= $("#country").val();


		//Ktra thong tin



	}
})


