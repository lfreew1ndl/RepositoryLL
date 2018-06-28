var App = angular.module('App',[]);

App.controller('User',function ($http,$scope) {
    $http.get('/users/get').then(function (response){
        $scope.users=response.data;
        console.log(response);
    });
    this.insertToUser = function add() {
        var name = document.getElementById("UserName").value;
        var balance = document.getElementById("UserBalance").value;
        var lastRequest = document.getElementById("UserLastRequest").value;
        var indexType = document.getElementById("UserType").selectedIndex;
        var type = document.getElementById("UserType").options[indexType].value;

        var req = {
            method: 'POST',
            url: '/users/insert',
            data: {
                name: name,
                balance: balance,
                lastRequest: lastRequest,
                type: type
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdateUser = function startUpdate(id,name,type,balance,lastRequesti) {
        document.getElementById("UserIdUPD").value=id;
        document.getElementById("UserNameUPD").value=name;
        document.getElementById("UserBalanceUPD").value=balance;
        document.getElementById("UserLastRequestUPD").value=lastRequesti;
        var UserType = document.getElementById("UserTypeUPD");
        UserType.value = type;
    };

    this.updateUser = function update() {
        var id = document.getElementById("UserIdUPD").value;
        var name = document.getElementById("UserNameUPD").value;
        var balance = document.getElementById("UserBalanceUPD").value;
        var lastRequest = document.getElementById("UserLastRequestUPD").value;
        var indexType = document.getElementById("UserTypeUPD").selectedIndex;
        var type = document.getElementById("UserTypeUPD").options[indexType].value;
        var req = {
            method: 'POST',
            url: '/users/update?id=' + id,
            data: {
                name: name,
                balance: balance,
                lastRequest: lastRequest,
                type: type
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.delFromUser = function del(id) {
        $http.get('/users/del?id=' + id).then(function () {
            window.location.reload();
        });
    };
});

