(function(angular) {
  var AppController = function($scope, Item) {
    Item.query(function(response) {
      $scope.items = response ? response : [];
    });
    
    $scope.addItem = function(description) {
      new Item({
        description: description,
        checked: false
      }).$save(function(item) {
        $scope.items.push(item);
      });
      $scope.newItem = "";
    };
    
    $scope.updateItem = function(item) {
      item.$update();
    };
    
    $scope.deleteItem = function(item) {
      item.$remove(function() {
        $scope.items.splice($scope.items.indexOf(item), 1);
      });
    };
  };

  var CategoryController = function($scope, Category) {
    Category.query(function(response) {
      $scope.categorys = response ? response : [];
    });
    
    $scope.addCategory = function(categoryName) {
      new Category({
        categoryName: categoryName
      }).$save(function(category) {
        $scope.categorys.push(category);
      });
      $scope.newCategory = "";
    };
    
    $scope.updateCategory = function(category) {
      category.$update();
    };
    
    $scope.deleteCategory = function(category) {
      category.$remove(function() {
        $scope.categorys.splice($scope.categorys.indexOf(category), 1);
      });
    };
    $scope.edit = true;
    $scope.changeButtonFlag = function() {
      $scope.edit = (!$scope.edit);
    }
  };
  
  AppController.$inject = ['$scope', 'Item'];
  CategoryController.$inject = ['$scope', 'Category'];
  angular.module("myApp.controllers").controller("AppController", AppController);
  angular.module("myApp.controllers").controller("CategoryController", CategoryController);
}(angular));