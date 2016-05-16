<!DOCTYPE HTML>
<html data-ng-app="myapp">
<head>
<script type="text/javascript" src="js/angular.min.js"></script>
</head>
<body>

<div data-ng-conntroller="tokenGenerator">
	The token is {{token}}
</div>
	<script type="text/javascript">

		var myapp = angular.module('myapp', []);
		console.log(mapp);
		myapp.controller('tokenGenerator', function($scope, $http) {
			$http.get('http://localhost:8080/tokengen/rest/token/generate').success(
					function(data) {
						$scope.token = 'hello';
					});
		});
	</script>
</body>
</html>
