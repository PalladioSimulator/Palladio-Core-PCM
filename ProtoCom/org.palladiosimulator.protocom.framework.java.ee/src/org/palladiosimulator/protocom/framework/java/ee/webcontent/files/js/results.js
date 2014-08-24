var App = (function($, App) {

	var Result = Backbone.Model.extend({
		urlRoot: 'api/results', 

		defaults: {
			name: 'Analysis Result', 
			url: '#'
		}
	});

	var ResultView = Backbone.View.extend({
		tagName: 'tr', 

		events: {
			'click .delete': 'clear'
		}, 

		initialize: function() {
			this.listenTo(this.model, 'destroy', this.remove);
		}, 

		render: function() {
			var template = _.template($('#template-result').html());
			this.$el.append(template(this.model.toJSON()));

			return this;
		}, 

		clear: function() {
			this.model.destroy();
		}
	});

	var ResultCollection = Backbone.Collection.extend({
		model: Result, 
		url: 'api/results', 

		initialize: function() {
			this.fetch();
			this.on('destroy', this.checkCollection, this);
		}, 

		checkCollection: function() {
			console.log(this.models);
		}
	});

	App.ResultsBoxView = Backbone.View.extend({
		tagName: 'div', 
		id: 'results', 
		className: 'box', 

		initialize: function() {
			this.collection = new ResultCollection;

			this.collection.on('add', this.renderResult, this);
		}, 

		render: function() {
			var template = _.template($('#template-results-box').html())
			this.$el.append(template());

			return this;
		}, 

		renderResult: function(model, collection, options) {
			var view = new ResultView({model: model});
			this.$el.find('tbody').append(view.render().el);
		}
	});

	return App;
})(jQuery, App || {});
