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
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/select/1.3.3/css/select.dataTables.min.css">
    <script src="https://cdn.datatables.net/1.11.5/js/dataTables.responsive.min.js"></script>

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
        <form action="CreateExamController1" method="post">
            <div>
                <h2>Step 1</h2>
                <label for="collection">Select course:</label>
                <select name="collection" id="collection">
            <c:forEach items="${listC}" var="listC">
                    <option value="${listC.id}">${listC.name}</option>
            </c:forEach>
                </select>
                <input type="text" placeholder="Exam Name" name="name" required="required">
                <input type="password" placeholder="Password" name="pass">
                <input type="number" placeholder="Time Limit (Minius)" name="time" required="required">
                <input type="number" placeholder="Number Question" name="qnum" required="required">
                
                <button type="summit" class="next">Next</button>
            </div>
        </form>
        <div class="progress-container">
            <div class="progress" id="progress"></div>
        </div>
    </div>

</body>

    <!-- Start jquery-table -->
    <script type="text/javascript">
        $(document).ready(function () {
            var table = $('#myTable').DataTable({
                select: true, // Enable row selection
                responsive: true // Enable responsiveness
            });
        });
    </script>

</html>