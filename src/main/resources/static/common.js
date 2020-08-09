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
	$scope.navaneeth = function(uname) {
		alert(uname);
		$scope.wpstatus=true;
		$scope.lgstatus=false;
		$scope.username=uname;
				$http.get("http://localhost:4040/xyz/mnop?myname=" +uname)
		.then(
				function(response) {
					
					$scope.myresponsestatus = response.status;
					$scope.myresponsedata = response.data;
					alert($scope.myresponsestatus);
					alert($scope.myresponsedata);
					
					
				
				});
		
	}
	
	});