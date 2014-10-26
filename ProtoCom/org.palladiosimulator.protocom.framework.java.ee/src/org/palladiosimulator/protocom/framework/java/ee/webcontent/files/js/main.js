var App = (function($, App) {
	_.templateSettings = {
		interpolate: /\{\{(.+?)\}\}/g,
		escape: /\{\{-(.+?)\}\}/g
	};

	App.ControlBoxView = Backbone.View.extend({
		tagName: 'div',

		render: function() {
			var registryView = new App.RegistryBoxView;
			this.$el.append(registryView.render().el);

			var modulesView = new App.ModuleCollectionView;
			this.$el.append(modulesView.render().el);

			var scenariosView = new App.ScenariosBoxView;
			this.$el.append(scenariosView.render().el);

			var resultsView = new App.ResultsBoxView;
			this.$el.append(resultsView.render().el);

			var logView = new App.LogBoxView;
			this.$el.append(logView.render().el);

			return this;
		}
	});

	Backbone.View.prototype.close = function() {
		if (typeof this.closing == 'function') {
			this.closing.call(this);
		}

		this.remove();
		this.unbind();
	}

	function showView(view) {
		if (typeof this.currentView != 'undefined') {
			this.currentView.close();
		}

		$('#boxes').html(view.render().el);

		this.currentView = view;
	}

	App.updateView = function() {
		$.get('api/status', function(response) {
			var view;

			switch (response.status) {
				case 'initial':
					view = new App.OptionsBoxView;
					break;

				case 'calibrating':
					view = new App.CalibrationBoxView;
					break;

				case 'started':
					view = new App.ControlBoxView;
					break;

				default:
			}

			showView(view);
		});
	}

	$(document).ready(function() {
		App.updateView();
	});

	return App;
})(jQuery, App || {});
