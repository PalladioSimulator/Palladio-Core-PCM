var App = (function($, App) {

	var Registry = Backbone.Model.extend({
		urlRoot: 'api/registry', 

		defaults: {
			location: 'http://localhost:8080'
		}
	});

	var RegistryView = Backbone.View.extend({
		id: 'registry', 

		events: {
			'blur input[name="location"]': 'blur'
		}, 

		render: function() {
			var template = _.template($('#template-registry').html());
			this.$el.append(template(this.model.toJSON()));

			return this;
		}, 

		blur: function() {
			var location = this.$el.find('input[name="location"]').val();

			this.model.set('location', location);
			this.model.save();

			// var data = {'location': this.$el.find('input[name="location"]').val()};
			
			/*$.ajax({
				type: 'PUT', 
				url: 'registry', 
				contentType: 'application/json', 
				data: JSON.stringify(data), 

				success: function(response) {
				}
			});*/
		}
	});

	App.RegistryBoxView = Backbone.View.extend({
		tagName: 'div', 
		className: 'box', 

		initialize: function() {
			_.bindAll(this, 'fetchSuccess');

			this.model = new Registry;

			this.model.fetch({
				success: this.fetchSuccess
			});
		}, 

		render: function() {
			var template = _.template($('#template-registry-box').html());
			this.$el.append(template());
			
			return this;
		}, 

		fetchSuccess: function(model, response, options) {
			this.renderRegistry(model);
		}, 

		renderRegistry: function(model) {
			var view = new RegistryView({model: model});
			this.$el.append(view.render().el);
		}
	})

	return App;
})(jQuery, App || {});
