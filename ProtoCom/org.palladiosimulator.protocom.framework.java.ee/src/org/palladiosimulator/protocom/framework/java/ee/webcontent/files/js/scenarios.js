var App = (function($, App) {
	
	var Scenario = Backbone.Model.extend({
		// urlRoot: 'scenarios', 

		defaults: {
			name: 'Default Scenario', 
			url: '#'
		}
	});

	var ScenarioView = Backbone.View.extend({
		tagName: 'tr', 

		render: function() {
			var template = _.template($('#template-scenario').html());
			this.$el.append(template(this.model.toJSON()));

			return this;
		}
	});

	var ScenarioCollection = Backbone.Collection.extend({
		model: Scenario, 
		url: 'api/scenarios', 

		initialize: function() {
			this.fetch();
		}
	});

	App.ScenariosBoxView = Backbone.View.extend({
		tagName: 'div', 
		id: 'scenarios', 
		className: 'box', 

		initialize: function() {
			this.collection = new ScenarioCollection;

			this.collection.on('add', this.renderScenario, this);
		}, 

		render: function() {
			var template = _.template($('#template-scenarios-box').html());
			this.$el.append(template());

			return this;
		}, 

		renderScenario: function(model, collection, options) {
			var view = new ScenarioView({model: model});
			this.$el.find('tbody').append(view.render().el);
		}
	});

	return App;
})(jQuery, App || {});
