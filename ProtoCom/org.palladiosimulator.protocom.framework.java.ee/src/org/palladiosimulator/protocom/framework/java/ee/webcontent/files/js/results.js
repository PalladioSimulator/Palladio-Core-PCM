var App = (function($, App) {

	var Result = Backbone.Model.extend({
		urlRoot: 'api/results', 

		defaults: {
			name: 'Analysis Result', 
			date: 0
		},
		
		initialize: function() {
			this.set('url', 'api/results/' + this.get('id'));
		}
	});

	var ResultView = Backbone.View.extend({
		tagName: 'tr', 

		events: {
			'click .delete': 'clear'
		}, 

		initialize: function() {
			this.listenTo(this.model, 'destroy', this.remove);
			this.listenTo(this.model, 'change', this.changed);
		}, 

		render: function() {
			var template = _.template($('#template-result').html());
			this.$el.html(template(this.model.toJSON()));

			return this;
		},
		
		changed: function() {
			this.render();
			this.flash();
		},
		
		flash: function() {
			this.$el.stop(true, true).css('background-color', '#b4d2ff');
			
			this.$el.animate({
				backgroundColor: 'white'
			}, 2000);
		},

		clear: function() {
			this.model.destroy();
		}
	});

	var ResultCollection = Backbone.Collection.extend({
		model: Result,
		url: 'api/results',
		comparator: 'name',

		parse: function(response) {
			return _.sortBy(response, 'name');
		},
		
		initialize: function() {
			this.fetch();
			this.startSocket();
		},

		startSocket: function() {
			var url = 'ws://' + location.host + location.pathname + 'ws/experiment';
			console.log(url);
			
			var connection = new WebSocket(url);
			var self = this;
			
			connection.onmessage = function(e) {
				var data = JSON.parse(e.data);
				self.add(new Result(data), {merge: true, flash: true});
			};
			
			connection.onerror = function(e) {
				console.log(e);
			};
		}
	});

	App.ResultsBoxView = Backbone.View.extend({
		tagName: 'div', 
		id: 'results', 
		className: 'box', 
		
		events: {
			'click h2': 'debug'
		},
		
		debug: function() {
			$.get('api/experiment/test');
		},

		initialize: function() {
			this.collection = new ResultCollection;

			this.listenTo(this.collection, 'add', this.renderResult);
		}, 
		
		render: function() {
			var template = _.template($('#template-results-box').html())
			this.$el.append(template());

			return this;
		}, 

		renderResult: function(model, collection, options) {
			var view = new ResultView({model: model});
			view.render();
			
			var index = collection.indexOf(model);
			var tbody = this.$el.find('tbody');
			
			if (index <= 0) {
				tbody.prepend(view.$el);
			} else {
				var previous = tbody.children().eq(index - 1);
				
				if (previous.length > 0) {
					previous.after(view.$el);
				} else {
					tbody.append(view.$el);
				}
			}
			
			if (options.flash) {
				view.flash();
			}
		}
	});

	return App;
})(jQuery, App || {});
