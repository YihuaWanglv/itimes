(function(angular) {


  var ItemController = function($scope, $http, $filter, Item, Category, Project, Location, Tag) {
    $scope.page = 1;
    $scope.nomore = 0;
    $scope.newDate = new Date();
    $scope.newItem = initNewItem();
    $scope.showing;
    $http.get('/items/list',{params: {page:$scope.page}})
    .success(function(data, status, headers, config){
      $scope.items = (data&&data.items)?data.items:[];
    })
    .error(function(data, status, headers, config){
      $scope.items = [];
      alert('load failed');
    });
    var listItem = function() {
      $scope.page++;
      $http.get('/items/list',{params: {page:$scope.page}})
      .success(function(data, status, headers, config){
        // $scope.items = (data&&data.items)?data.items:[];
        if (data&&data.items) {
          if (data.items.length > 0) {
            $scope.items = $scope.items.concat(data.items);
          } else {
            $scope.nomore = 1;
          }
        } else {
          $scope.nomore = 1;
        }
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
      
      listItem();
    }
    $scope.showItemDate = function(_date) {
      var flag = false;
      if (_date) {
        if (!$scope.showing) {
          $scope.showing = _date;
          flag = true;
        } else {
          if (_date !== $scope.showing) {
            flag = true;
            $scope.showing = _date;
          }
        }
      }
      return flag;
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
      // item.$remove(function(){
      //   $scope.items.splice($scope.items.indexOf(item),1);
      // });
      // console.log('---');
      // console.log(item.itemId);
      // $http({
      //   method: 'DELETE',
      //   url: '/items'
      // }).then(function successCallback(response) {
      //   // this callback will be called asynchronously
      //   // when the response is available
      //   $scope.items.splice($scope.items.indexOf(item),1);
      // }, function errorCallback(response) {
      //   // called asynchronously if an error occurs
      //   // or server returns response with an error status.
      //   alert('delete failed!');
      // });
      $http.delete('/items/' + item.itemId, {}).success(function (data, status) {
        // console.log(data);
        console.log('success');
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
 
  // angular.module("myApp.controllers").controller("ItemController"
  //   , [
  //     '$scope', '$http', '$filter', 'Item', 'Category', 'Project', 'Location', 'Tag'
  //     , ItemController
  //   ]
  // );
  ItemController.$inject = ['$scope', '$http', '$filter', 'Item', 'Category', 'Project', 'Location', 'Tag'];
  angular.module("myApp.controllers").controller("ItemController", ItemController);
}(angular));