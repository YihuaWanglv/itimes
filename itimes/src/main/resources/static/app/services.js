(function(angular) {
  // var ItemFactory = function($resource) {
  //   return $resource('/items/:id', {
  //     id: '@id'
  //   }, {
  //     update: {
  //       method: "PUT"
  //     },
  //     remove: {
  //       method: "DELETE"
  //     }
  //   });
  // };
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

  // ItemFactory.$inject = ['$resource'];
  CategoryFactory.$inject = ['$resource'];
  // angular.module("myApp.services").factory("Item", ItemFactory);
  angular.module("myApp.services").factory("Category", CategoryFactory);
  angular.module('myApp.services').factory('Project', function($resource) {
    return $resource('/manager/project/:projectId', {
      projectId: '@projectId'
    }, {
      update: {
        method: "PUT"
      },
      remove: {
        method: "DELETE"
      }
    });
  });
  angular.module('myApp.services').factory('Tag', function($resource) {
    return $resource('/manager/tag/:tagId', {
      tagId: '@tagId'
    }, {
      update: {
        method: "PUT"
      },
      remove: {
        method: "DELETE"
      }
    });
  });
  angular.module('myApp.services').factory('Item', function($resource) {
    return $resource('/items/list', {
      last: '2016-01-08'
    }, {
      update: {
        method: "PUT"
      },
      remove: {
        method: "DELETE"
      }
    });
  });
}(angular));