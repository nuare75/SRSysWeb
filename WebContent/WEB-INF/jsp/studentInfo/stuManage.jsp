<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Management</title>
<script type="text/javascript">
	$ (document).ready (function () {
		showGrid ();
		$("#modalStudentBody").hide();
	});
	
	function showInsertForm(){
		$("#modalStudent").modal('show');
		$("#modalStudentBody").show();
	}

	function showGrid () {
		var jsondata = ConvertFormToJSONString ($ ("#studentInfo"));
		$ ("#jqGrid").jqGrid ('GridUnload');
		$ ("#jqGrid").jqGrid (
				{
					url : 'loadStudentData.pop?enqData=' + jsondata, //URL that will return data
					datatype : 'json', //data type of the date that will be returned
					mtype : 'POST', //request method, POST or GET
					jsonReader : { root : "rows", page : "page", total : "total", records : "records", repeatitems : false, id : "bookid" }, //How to read the json data returned
					colNames : [ 'Book Title', 'Author', 'Publication', 'Subject', 'Copies', 'Book Id' ], //define column names
					colModel : [ { name : 'bookname', index : 'bookname' }, { name : 'author', index : 'author' },
							{ name : 'publication', index : 'publication' }, { name : 'subject', index : 'subject', width : 500 }, { name : 'copies', index : 'copies' },
							{ name : 'bookid', index : 'bookid', hidden : true } ], //define column models
					rowNum : 5, //Number of rows per page
					rowList : [ 5, 10, 20, 30, 50, 100 ], //User options to change number of records per page
					pager : '#jqGridPager', //set your pager div id
					caption : 'Book List',
					emptyrecords : 'No Record to display', // Replace comment No Record found
					loadui : 'block', // disable to remove, enable to show loading, block to show loadtext content
					loadtext : 'Loading data... Please wait...', // value to replace loading
					gridview : true, 
					width : $("#jqGridWrapper").width() - 3, //specify width of grid; optional
					rownumbers : true, 
					sortname : 'bookid', 
					sortorder : 'asc', // asc or desc
					viewrecords : true, 
					height : '100%', 
					shrinkToFit : false,
					ondblClickRow : function (rowid, iRow, iCol, e) {
						var cellData = $ (this).jqGrid ("getRowData", rowid);
					} });

		$ ("#jqGrid").jqGrid ('navGrid', '#jqGridPager', { edit : false, add : false, del : false, search : false, refresh : false }, {}, {}, {}, {});
	}
	
	function submitpage(val) {
		if (val=='add') {
			showInsertForm();
			//if (confirm('Are you sure you want to insert?')) {
			//	$("#empform").attr("action", "emp-new");
			//	$("#empform").submit();
			//}
		} else if (val=='update' && ("#myid").val()!='') {
			if (confirm('Are you sure you want to update?')) {
				$("#empform").attr("action", "edit-"+$("#myid").val()+"-employee");
				$("#empform").submit();
			}
		} else if (val=='delete' && ("#myid").val()!='') {
			if (confirm('Are you sure you want to delete?')) {
				$("#empform").attr("action", "delete-"+$("#myid").val()+"-employee");
				$("#empform").submit();
			}
		}
	}
</script>
</head>
<body><br>
		<div class="container-fluid">
			<div class="panel panel-default">
				<div class="panel-heading" style="height: 55px">
					<ul class="breadcrumb">
						<li><b>Student</b></li>
						<li class="active"><b>Manage Student Info</b></li>
					</ul>
				</div>
				<div class="panel-body">
					<div class="row">
						<div id="jqGridWrapper">
							<table id="jqGrid"></table>
							<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
				<div class="panel-footer" style="height: 55px">
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-default" onclick="submitpage('add');">Add Employee</button>
							<button type="button" class="btn btn-default" onclick="submitpage('update');">Update Employee</button>
							<button type="button" class="btn btn-default" onclick="submitpage('delete');">Delete Employee</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	<div id="modalStudent" class="modal fade" role="dialog" aria-labelledby="modalStudentLabel">
		<div class="modal-dialog" style="height: 350px; width: 80%;">
			<div class="modal-content">
				<div class="modal-header"></div>
				<div class="modal-body" id="modalStudentBody">
				<form:form modelAttribute="studentInfo" id="stuform" class="form-horizontal" role="form" method="post">
					<div class="panel-body">
						<div class="form-group">
							<label for="fullname" class="col-sm-2 control-label">Full
								Name</label>
							<div class="col-sm-10">
								<form:input path="fullname" class="form-control" id="fullname"
									placeholder="Enter Full Name" maxlength="100" />
								<strong><form:errors path="fullname"
										class="alert-danger" /></strong>
							</div>
						</div>
						<div class="form-group">
							<label for="nickname" class="col-sm-2 control-label">Surname</label>
							<div class="col-sm-10">
								<form:input path="surname" class="form-control" id="surname"
									placeholder="Enter Nickname" maxlength="20" />
								<strong><form:errors path="surname"
										class="alert-danger" /></strong>
							</div>
						</div>
						<div class="form-group">
							<label for="noMyKid" class="col-sm-2 control-label">IC
								Number / Passport</label>
							<div class="col-sm-10">
								<form:input path="noMyKid" class="form-control" id="noMyKid"
									placeholder="Enter IC Number / Passport" maxlength="20" />
								<strong><form:errors path="noMyKid"
										class="alert-danger" /></strong>
							</div>
						</div>
						<div class="form-group">
							<label for="studentiId" class="col-sm-2 control-label">Designation</label>
							<div class="col-sm-10">
								<form:input path="studentiId" class="form-control"
									id="studentiId" readonly="true" maxlength="50" />
							</div>
						</div>
						<div class="form-group">
							<label for="dateOfBirth" class="col-sm-2 control-label">Date
								Of Birth</label>
							<div class="col-sm-10">
								<form:input path="dateOfBirth" class="form-control"
									id="dateOfBirth" placeholder="Enter Date Of Birth"
									maxlength="12" />
								<strong><form:errors path="dateOfBirth"
										class="alert-danger" /></strong>
							</div>
						</div>
						<div class="form-group">
							<label for="joinDate" class="col-sm-2 control-label">Year
								Joined</label>
							<div class="col-sm-10">
								<form:input path="yearJoin" class="form-control" id="yearJoin"
									placeholder="Enter Date Joined" maxlength="4" />
								<strong><form:errors path="yearJoin"
										class="alert-danger" /></strong>
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">Grade
								Enter</label>
							<div class="col-sm-10">
								<form:input path="gradeEnter" class="form-control"
									id="gradeEnter" placeholder="Enter Grade" maxlength="1" />
								<strong><form:errors path="gradeEnter"
										class="alert-danger" /></strong>
							</div>
						</div>
						<div class="form-group">
							<label for="gender" class="col-sm-2 control-label">Gender</label>
							<div class="col-sm-10">
								<%-- <form:input path="gender" class="form-control" id="gender" placeholder="Enter Gender" /> --%>
								<form:select class="form-control" id="gender" path="gender">
									<form:option value="">
									</form:option>
									<form:option value="M">Male</form:option>
									<form:option value="F">Female</form:option>
								</form:select>
								<strong><form:errors path="gender" class="alert-danger" /></strong>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">Race</label>
							<div class="col-sm-10">
								<form:input path="race" class="form-control" id="race"
									placeholder="Enter Email" maxlength="50" />
								<strong><form:errors path="race" class="alert-danger" /></strong>
							</div>
						</div>
						<div class="form-group">
							<label for="joinDate" class="col-sm-2 control-label">Year
								Completed</label>
							<div class="col-sm-10">
								<form:input path="yearCompleted" class="form-control"
									id="yearCompleted" placeholder="Enter Date Joined"
									maxlength="4" />
								<strong><form:errors path="yearCompleted"
										class="alert-danger" /></strong>
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">Grade
								Completed</label>
							<div class="col-sm-10">
								<form:input path="gradeCompleted" class="form-control"
									id="gradeCompleted" placeholder="Enter Grade" maxlength="1" />
								<strong><form:errors path="gradeCompleted"
										class="alert-danger" /></strong>
							</div>
						</div>
						<div class="form-group">
							<label for="contactNum" class="col-sm-2 control-label">Contact
								Number</label>
							<div class="col-sm-10">
								<form:input path="contactNum" class="form-control"
									id="contactNum" placeholder="Enter Contact Number"
									maxlength="20" />
								<strong><form:errors path="contactNum"
										class="alert-danger" /></strong>
							</div>
						</div>
						<div class="form-group">
							<label for="address1" class="col-sm-2 control-label">Address</label>
							<div class="col-sm-10">
								<form:input path="address1" class="form-control" id="address1"
									placeholder="Enter Address Line 1" maxlength="250" />
								<strong><form:errors path="address1"
										class="alert-danger" /></strong>
							</div>
						</div>
						<div class="form-group">
							<label for="address1" class="col-sm-2 control-label">&nbsp;</label>
							<div class="col-sm-10">
								<form:input path="address2" class="form-control" id="address1"
									placeholder="Enter Address Line 2" maxlength="250" />
								<strong><form:errors path="address2"
										class="alert-danger" /></strong>
							</div>
						</div>
						<div class="form-group">
							<label for="address1" class="col-sm-2 control-label">&nbsp;</label>
							<div class="col-sm-10">
								<form:input path="postcode" class="form-control" id="postcode"
									placeholder="Enter Postcode" maxlength="10" />
								<strong><form:errors path="postcode"
										class="alert-danger" /></strong>
							</div>
						</div>
						<div class="form-group">
							<label for="address1" class="col-sm-2 control-label">&nbsp;</label>
							<div class="col-sm-10">
								<form:input path="city" class="form-control" id="city"
									placeholder="Enter City" maxlength="50" />
								<strong><form:errors path="city" class="alert-danger" /></strong>
							</div>
						</div>
						<div class="form-group">
							<label for="address1" class="col-sm-2 control-label">&nbsp;</label>
							<div class="col-sm-10">
								<form:input path="state" class="form-control" id="state"
									placeholder="Enter State" maxlength="50" />
								<strong><form:errors path="state" class="alert-danger" /></strong>
							</div>
						</div>
						<div class="form-group">
							<label for="dateUpdate" class="col-sm-2 control-label">Last
								Update</label>
							<div class="col-sm-10">
								<form:input path="dateUpdate" class="form-control"
									id="dateUpdate" readonly="true" />
							</div>
						</div>
					</div>
					</form:form>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary">Insert</button>
					<button class="btn btn-primary" data-dismiss="modal">Cancel</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>