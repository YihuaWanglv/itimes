(function(angular) {


  var ItemController = function($scope, $http, Item, Category, Project, Location, Tag) {
    $scope.page = 1;
    $scope.newDate = new Date();
    $http.get('/items/list',{params: {page:$scope.page}})
    .success(function(data, status, headers, config){
      $scope.items = (data&&data.items)?data.items:[];
    })
    .error(function(data, status, headers, config){
      $scope.items = [];
      alert('load failed');
    });
    var listItem = function() {
      $http.get('/items/list',{params: {page:$scope.page}})
      .success(function(data, status, headers, config){
        $scope.items = (data&&data.items)?data.items:[];
      })
      .error(function(data, status, headers, config){
        $scope.items = [];
        alert('load failed');
      });
    }
    $scope.listNext = function() {
      $scope.page++;
      listItem();
    }
    
    $scope.createItem = function(name) {
      new Item({
        item: name
      }).$save(function(item){
        $scope.Items.push(item);
      });
      $scope.newItem = "";
    }
    $scope.updateItem = function(item) {
      item.$update();
    }
    $scope.deleteItem = function(item) {
      item.$remove(function(){
        $scope.items.splice($scope.items.indexOf(item),1);
      });
    }
    $scope.changeButtonFlag = function(item) {
      item.editting = !item.editting;
    }

    // resource
    Category.query(function(response) {
      $scope.categorys = response ? response : [];
    });
    Project.query(function(response){
      $scope.projects = response ? response : [];
    });
    Location.query(function(response) {
      $scope.locations = response ? response : [];
    });
    Tag.query(function(response) {
      $scope.tags = response ? response : [];
    });

  }
 
  angular.module("myApp.controllers").controller("ItemController"
    , [
      '$scope', '$http', 'Item', 'Category', 'Project', 'Location', 'Tag'
      , ItemController
    ]
  );
}(angular));