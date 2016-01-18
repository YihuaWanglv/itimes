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

  var ProjectController = function($scope, Project) {
    Project.query(function(response){
      $scope.projects = response ? response : [];
    });
    $scope.createProject = function(projectName) {
      new Project({
        projectName: projectName
      }).$save(function(project){
        $scope.projects.push(project);
      });
      $scope.newProject = "";
    }
    $scope.updateProject = function(project) {
      project.$update();
    }
    $scope.deleteProject = function(project) {
      project.$remove(function(){
        $scope.projects.splice($scope.projects.indexOf(project),1);
      });
    }
    $scope.edit = true;
    $scope.changeButtonFlag = function() {
      $scope.edit = (!$scope.edit);
    }
  }

  var TagController = function($scope, Tag) {
    Tag.query(function(response) {
      $scope.tags = response ? response : [];
    });
    $scope.addTag = function(tagName) {
      new Tag({
        tagName: tagName
      }).$save(function(tag) {
        $scope.tags.push(tag);
      });
      $scope.newTag = "";
    }
    $scope.updateTag = function(tag) {
      tag.$update();
    }
    $scope.deleteTag = function(tag) {
      tag.$remove(function(){
        $scope.tags.splice($scope.tags.indexOf(tag),1);
      });
    }
    $scope.edit = true;
    $scope.changeButtonFlag = function() {
      $scope.edit = (!$scope.edit);
    }
  }
  
  AppController.$inject = ['$scope', 'Item'];
  CategoryController.$inject = ['$scope', 'Category'];
  ProjectController.$inject = ['$scope','Project'];
  TagController.$inject = ['$scope','Tag'];
  angular.module("myApp.controllers").controller("AppController", AppController);
  angular.module("myApp.controllers").controller("CategoryController", CategoryController);
  angular.module("myApp.controllers").controller("ProjectController", ProjectController);
  angular.module("myApp.controllers").controller("TagController", TagController);
}(angular));