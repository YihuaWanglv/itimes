(function(angular) {


  var ItemController = function($scope, $http, $filter, Item, Category, Project, Location, Tag) {
    $scope.page = 1;
    $scope.newDate = new Date();
    $scope.newItem = initNewItem();
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
    function initNewItem() {
      // var _item = {};
      // _item.item = '';
      return {item:''};
    }
    $scope.listNext = function() {
      $scope.page++;
      listItem();
    }
    
    $scope.createItem = function(_item) {
      new Item({
        // itemDate: $filter('date')($scope.newDate, 'yyyy-MM-dd'),
        date: $scope.newDate,
        item: _item.item,
        categoryId: _item.category.categoryId||null,
        projectId: _item.project.projectId||null,
        locationId: _item.location.locationId||null,
        tags: _item.tag.tagName||'',
        categoryName: _item.category.categoryName||'',
        projectName: _item.project.projectName||'',
        location: _item.location.location||'',
        duration: 2
      }).$save(function(item){
        $scope.items.push(item);
      });
      // console.log(_item);
      $scope.newItem = initNewItem();
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
      '$scope', '$http', '$filter', 'Item', 'Category', 'Project', 'Location', 'Tag'
      , ItemController
    ]
  );
}(angular));