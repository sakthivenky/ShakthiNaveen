/**
 * 
 */
 var app = angular.module('navaneeApp',[]);
	app.controller('navaneeCtrl', function($scope, $http) {
	$scope.myresponsestatus = "";
	$scope.myresponsedata = "";
	$scope.url='WelcomePage.html';
	$scope.wpstatus=false;
	$scope.lgstatus=true;
	$scope.username="";
	$scope.userList = "";
	$scope.list_user = function()
	{
		alert('list user function called');
		$http.get("http://localhost:4040/user/getAllUsers/")
		.then(
				function(response) {
					$scope.userList = response.data;	
					console.log($scope.userList);
				});
		
		
	}
	
	$scope.navaneeth = function(uname,pwd) {
		alert(uname+"  "+pwd);
		$scope.wpstatus=true;
		$scope.lgstatus=false;
		$scope.username=uname;
				$http.get("http://localhost:4040/user/getUserByName?uname=" +uname+"&pwd="+pwd)
		.then(
				function(response) {
					
					$scope.myresponsestatus = response.status;
					$scope.myresponsedata = response.data;
					if($scope.myresponsedata=='notok')
						$scope.lgstatus=true;
					alert($scope.myresponsestatus);
					alert($scope.myresponsedata);
					
					
				
				});
		
	}
	
	});