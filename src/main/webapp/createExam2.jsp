<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<!-- jquery-table -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
<script
	src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/select/1.3.3/css/select.dataTables.min.css">
<script
	src="https://cdn.datatables.net/1.11.5/js/dataTables.responsive.min.js"></script>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
}

.form-container {
	background-color: #fff;
	max-width: 80%;
	margin: 0 auto;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

form {
	display: block;
	position: relative;
}

.step {
	display: none;
}

.step h2 {
	font-size: 20px;
	margin: 0 0 20px;
}

input {
	width: 100%;
	padding: 10px;
	margin: 5px 0;
	border: 1px solid #ccc;
	border-radius: 3px;
}

button {
	padding: 10px 20px;
	border: none;
	background-color: #007bff;
	color: #fff;
	cursor: pointer;
}

button.prev {
	background-color: #ccc;
}

.progress-container {
	margin: 20px 0;
}

.progress {
	height: 10px;
	background-color: #007bff;
}

table tr th {
	background: #337ab7;
	color: white;
	text-align: left;
	vertical-align: center;
}
</style>
</head>

<body>

	<div class="form-container">
		<form action="CreateExamController2" method="post" id="examForm">
			<div>
				<h2>Step 2</h2>

				<table id="myTable" class="display responsive" style="width: 100%">
					<thead>
						<tr>
							<th></th>
							<th>Question</th>
							<th>Answer A</th>
							<th>Answer B</th>
							<th>Answer C</th>
							<th>Answer D</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listB}" var="listB">
							<tr>
								<td><input type="checkbox" onclick="limitCheckbox(this)" name="${listB.id}" id="${listB.id}">
								</td>
								<td>${listB.detail}</td>
								<td>${listB.answerA}</td>
								<td>${listB.answerB}</td>
								<td>${listB.answerC}</td>
								<td>${listB.answerD}</td>
							</tr>
						</c:forEach>
						<!-- Add more rows as needed -->
					</tbody>
				</table>
				<button class="prev" onclick="myButton">Previous</button>
				<button class="next" type="summit">Summit</button>
			</div>
		</form>
		<div class="progress-container">
			<div class="progress" id="progress"></div>
		</div>
	</div>
</body>

<script type="text/javascript">
<!-- Start jquery-table -->
	$(document).ready(function() {
		var table = $('#myTable').DataTable({
			select : true, // Enable row selection
			responsive : true
		// Enable responsiveness
		});
	});
<!-- End jquery-table -->


<!-- Start limit checkbox -->
	var maxAllowed = <%=request.getAttribute("maxAllowed")%>;

	function limitCheckbox(checkbox) {
		var checkedCheckboxes = document
				.querySelectorAll('input[type="checkbox"]:checked');

		// disable nút check
		if (checkedCheckboxes.length === maxAllowed) {
			disableCheckboxes();
		} else {
			enableCheckboxes();
		}
	}

	function disableCheckboxes() {
		var checkboxes = document.querySelectorAll('input[type="checkbox"]');
		checkboxes.forEach(function(checkbox) {
			if (!checkbox.checked) {
				checkbox.disabled = true;
			}
		});
	}

	function enableCheckboxes() {
		var checkboxes = document.querySelectorAll('input[type="checkbox"]');
		checkboxes.forEach(function(checkbox) {
			checkbox.disabled = false;
		});
	}
<!-- End limit checkbox -->
</script>
</html>