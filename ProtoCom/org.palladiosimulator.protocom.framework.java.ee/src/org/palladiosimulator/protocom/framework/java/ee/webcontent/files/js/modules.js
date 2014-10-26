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

			this.updateState();

			return this;
		},

		updateState: function() {
			if (this.model.get('started')) {
				this.$el.find('.state').addClass('started').text('Started');
				this.$el.find('.start').prop('disabled', true);
			} else {
				this.$el.find('.state').removeClass('started').text('Stopped');
				this.$el.find('.start').prop('disabled', false);
			}
		},

		start: function() {
			var self = this;

			this.$el.find('.start').prop('disabled', true);
			
			/*$.get('api/modules/' + this.model.get('id') + '/start', function(response) {
				self.model.set('started', true);
				self.updateState();
			});*/
			
			$.ajax({
				url: 'api/modules/' + this.model.get('id') + '/start',
				
				success: function(response) {
					self.model.set('started', true);
					self.updateState();
				},
				
				error: function(response) {
					self.updateState();
				}
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

	App.ModulesBoxView = Backbone.View.extend({
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
