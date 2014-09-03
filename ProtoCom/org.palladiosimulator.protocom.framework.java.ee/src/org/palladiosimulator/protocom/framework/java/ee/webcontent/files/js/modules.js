var App = (function($, App) {

	var Module = Backbone.Model.extend({
		defaults: {
			name: 'Module',
			started: false
		}
	});

	var ModuleView = Backbone.View.extend({
		tagName: 'tr',

		events: {
			'click .start': 'start'
		},

		render: function() {
			var template = _.template($('#template-module').html());
			this.$el.append(template(this.model.toJSON()));

			return this;
		},

		start: function() {
			var self = this;
			
			$.get('api/modules/' + this.model.get('id') + '/start', function(response) {
				self.$el.find(".state").addClass('started').text('Started');
			});
		}
	});

	var ModuleCollection = Backbone.Collection.extend({
		model: Module,
		url: 'api/modules',

		initialize: function() {
			this.fetch();
		}
	});

	App.ModuleCollectionView = Backbone.View.extend({
		tagName: 'div',
		id: 'modules',
		className: 'box',

		initialize: function() {
			this.collection = new ModuleCollection;

			this.collection.on('add', this.renderModule, this);
		},

		render: function() {
			var template = _.template($('#template-modules-box').html());
			this.$el.append(template());

			return this;
		},

		renderModule: function(model, collection, options) {
			var view = new ModuleView({model: model});
			this.$el.find('tbody').append(view.render().el);
		}
	});

	return App;
})(jQuery, App || {});
