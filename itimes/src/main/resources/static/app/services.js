(function(angular) {
  var ItemFactory = function($resource) {
    return $resource('/items/:id', {
      id: '@id'
    }, {
      update: {
        method: "PUT"
      },
      remove: {
        method: "DELETE"
      }
    });
  };
  var CategoryFactory = function($resource) {
    return $resource('/manager/category/:categoryId', {
      categoryId: '@categoryId'
    }, {
      update: {
        method: "PUT"
      },
      remove: {
        method: "DELETE"
      }
    });
  };
  
  ItemFactory.$inject = ['$resource'];
  CategoryFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("Item", ItemFactory);
  angular.module("myApp.services").factory("Category", CategoryFactory);
}(angular));