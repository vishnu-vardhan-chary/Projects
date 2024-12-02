function search() {
	var searchType = document.getElementById("searchType").value;
	if (searchType === "name") {
		document.frm.action = "searchByName";
	} else if (searchType === "address") {
		document.frm.action = "searchByAddress";
	} else if (searchType === "salary") {
		document.frm.action = "searchBySalary";
	}
	document.frm.submit();
}

function confirmDelete(employeeId) {
	if (confirm("Are you sure you want to delete this employee?")) {
		window.location.href = "/deleteEmployee/" + employeeId;
	}
}